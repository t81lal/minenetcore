package org.topdank.minenet.api.world;

import java.util.Map;

import org.topdank.minenet.api.BotContext;
import org.topdank.minenet.api.BotVersionProvider;
import org.topdank.minenet.api.entity.Entity;
import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.entity.living.player.LocalPlayer;
import org.topdank.minenet.api.entity.living.player.PlayerEntity;
import org.topdank.minenet.api.entity.object.ObjectEntity;
import org.topdank.minenet.api.entity.provider.EntityFactory;
import org.topdank.minenet.api.entity.tile.TileEntity;
import org.topdank.minenet.api.event.internal.world.InternalBlockChangeEvent;
import org.topdank.minenet.api.event.internal.world.InternalChunkLoadEvent;
import org.topdank.minenet.api.event.internal.world.InternalMultiBlockChangeEvent;
import org.topdank.minenet.api.event.internal.world.InternalMultiChunkLoadEvent;
import org.topdank.minenet.api.event.world.TimeUpdateEvent;
import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.game.location.ChunkLocation;
import org.topdank.minenet.api.nbt.tag.builtin.CompoundTag;
import org.topdank.minenet.api.provider.registry.NameRegistry;
import org.topdank.minenet.api.world.block.Chunk;
import org.topdank.minenet.api.world.block.art.PaintingRegistry;
import org.topdank.minenet.api.world.block.material.MaterialRegistry;
import org.topdank.minenet.api.world.block.provider.factory.BlockFactory;
import org.topdank.minenet.api.world.block.provider.registry.BlockRegistry;
import org.topdank.minenet.api.world.settings.WorldSettings;

import eu.bibl.eventbus.EventBus;
import eu.bibl.eventbus.EventPriority;
import eu.bibl.eventbus.EventTarget;

public class DefaultMinecraftWorld implements World, EntityHandler {

	protected final BotContext context;
	protected final EventBus eventBus;

	protected final EntityFactory<LivingEntity, Integer> livingEntityFactory;
	protected final NameRegistry livingEntityRegistry;

	protected final EntityFactory<ObjectEntity, Integer> objectEntityFactory;
	protected final NameRegistry objectEntityRegistry;

	protected final EntityFactory<TileEntity, CompoundTag> tileEntityFactory;
	protected final NameRegistry tileEntityRegistry;

	protected final BlockFactory blockFactory;
	protected final BlockRegistry blockRegistry;

	protected final MaterialRegistry materialRegistry;
	protected final PaintingRegistry paintingRegistry;

	protected WorldSettings worldSettings;

	protected long worldAge, worldTime;
	protected Map<ChunkLocation, Chunk> chunks;

	protected Map<Integer, Entity> entityCache;
	protected Map<String, PlayerEntity> playerCache;

	protected LocalPlayer localPlayer;

	public DefaultMinecraftWorld(BotContext context, EventBus eventBus, WorldSettings worldSettings) {
		this.context = context;
		this.eventBus = eventBus;
		this.worldSettings = worldSettings;

		BotVersionProvider provider = context.getVersionProvider();
		livingEntityFactory = provider.getEntityProvider().getLivingEntityProvider().getFactory();
		livingEntityRegistry = provider.getEntityProvider().getLivingEntityProvider().getRegistry();
		objectEntityFactory = provider.getEntityProvider().getObjectEntityProvider().getFactory();
		objectEntityRegistry = provider.getEntityProvider().getObjectEntityProvider().getRegistry();
		tileEntityFactory = provider.getEntityProvider().getTileEntityProvider().getFactory();
		tileEntityRegistry = provider.getEntityProvider().getTileEntityProvider().getRegistry();

		blockFactory = provider.getWorldProvider().getBlockProvider().getBlockFactory();
		blockRegistry = provider.getWorldProvider().getBlockProvider().getBlockRegistry();
		materialRegistry = provider.getWorldProvider().getMaterialRegistry();
		paintingRegistry = provider.getWorldProvider().getPaintingRegistry();
	}

	public DefaultMinecraftWorld(BotContext context, WorldSettings worldSettings) {
		this(context, context.getEventBus(), worldSettings);
	}

	public DefaultMinecraftWorld(BotContext context) {
		this(context, context.getEventBus(), null);
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	private void onInternalChunkLoad(InternalChunkLoadEvent e) {
		synchronized (chunks) {
			chunks.put(new ChunkLocation(e.getChunkX(), e.getChunkY(), e.getChunkZ()), e.getChunk());
		}
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	private void onInternalMultiChunkLoadEvent(InternalMultiChunkLoadEvent e) {
		synchronized (chunks) {
			Chunk[] chunks = e.getChunks();
			int length = chunks.length;
			int[] xs = e.getChunkXs();
			int[] ys = e.getChunkYs();
			int[] zs = e.getChunkZs();

			for (int i = 0; i < length; i++) {
				this.chunks.put(new ChunkLocation(xs[i], ys[i], zs[i]), chunks[i]);
			}
		}
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	private void onInternalBlockChangeEvent(InternalBlockChangeEvent e) {
		// optimised so less objects
		int x = e.getX(), y = e.getY(), z = e.getZ();
		int chunkX = x >> 4, chunkY = y >> 4, chunkZ = z >> 4;
		Chunk chunk = getChunkAt(new ChunkLocation(chunkX, chunkY, chunkZ));
		if (chunk == null)
			return;

		int chunkBaseX = chunkX << 4, chunkBaseY = chunkY << 4, chunkBaseZ = chunkZ << 4;
		chunk.getBlocks().set(x - chunkBaseX, y - chunkBaseY, z - chunkBaseZ, e.getData());
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	private void onInternalMultiBlockChangeEvent(InternalMultiBlockChangeEvent e) {
		int[] xs = e.getXs(), ys = e.getYs(), zs = e.getZs();
		int[] datas = e.getDatas();
		int length = datas.length;
		for (int i = 0; i < length; i++) {
			int x = xs[i], y = ys[i], z = zs[i];
			int chunkX = x >> 4, chunkY = y >> 4, chunkZ = z >> 4;
			Chunk chunk = getChunkAt(new ChunkLocation(chunkX, chunkY, chunkZ));
			if (chunk == null)
				continue;
			int chunkBaseX = chunkX << 4, chunkBaseY = chunkY << 4, chunkBaseZ = chunkZ << 4;
			chunk.getBlocks().set(x - chunkBaseX, y - chunkBaseY, z - chunkBaseZ, datas[i]);
		}
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	private void onTimeUpdateEvent(TimeUpdateEvent e) {
		worldTime = e.getTime();
		worldAge = e.getAge();
	}

	@Override
	public BlockLocation[] findAdjacent(BlockLocation location) {
		return null;
	}

	@Override
	public boolean canWalk(BlockLocation from, BlockLocation to) {
		return false;
	}

	@Override
	public boolean canClimb(BlockLocation location) {
		return false;
	}

	@Override
	public int getBlockData(BlockLocation loc) {
		return getBlockData(loc.getX(), loc.getY(), loc.getZ());
	}

	@Override
	public int getBlockData(int x, int y, int z) {
		int chunkX = x >> 4, chunkY = y >> 4, chunkZ = z >> 4;
		Chunk chunk = getChunkAt(new ChunkLocation(chunkX, chunkY, chunkZ));
		if (chunk == null)
			return -1;

		int chunkBaseX = chunkX << 4, chunkBaseY = chunkY << 4, chunkBaseZ = chunkZ << 4;
		return chunk.getBlocks().get(x - chunkBaseX, y - chunkBaseY, z - chunkBaseZ);
	}

	@Override
	public void setBlockData(int data, BlockLocation loc) {
		setBlockData(data, loc.getX(), loc.getY(), loc.getZ());
	}

	@Override
	public void setBlockData(int data, int x, int y, int z) {
		int chunkX = x >> 4, chunkY = y >> 4, chunkZ = z >> 4;
		Chunk chunk = getChunkAt(new ChunkLocation(chunkX, chunkY, chunkZ));
		if (chunk == null)
			return;

		int chunkBaseX = chunkX << 4, chunkBaseY = chunkY << 4, chunkBaseZ = chunkZ << 4;
		chunk.getBlocks().set(x - chunkBaseX, y - chunkBaseY, z - chunkBaseZ, data);
	}

	@Override
	public TileEntity getTileEntityAt(BlockLocation loc) {
		throw new UnsupportedOperationException("DefaultMinecraftWorlds don't support tile/block entities.");
	}

	@Override
	public void setTileEntityAt(TileEntity tileEntity, BlockLocation loc) {
		throw new UnsupportedOperationException("DefaultMinecraftWorlds don't support tile/block entities.");
	}

	@Override
	public Chunk getChunkAt(BlockLocation loc) {
		return getChunkAt(new ChunkLocation(loc));
	}

	@Override
	public Chunk getChunkAt(ChunkLocation location) {
		synchronized (chunks) {
			return chunks.get(location);
		}
	}

	@Override
	public WorldSettings getSettings() {
		return worldSettings;
	}

	@Override
	public long getWorldAge() {
		return worldAge;
	}

	@Override
	public long getTime() {
		return worldTime;
	}

	@Override
	public void destroy() {
		chunks.clear();
	}

	@Override
	public World getWorld() {
		return this;
	}

	@Override
	public Entity[] getEntities() {
		synchronized (entityCache) {
			return entityCache.values().toArray(new Entity[entityCache.size()]);
		}
	}

	@Override
	public Entity getEntityById(int id) {
		synchronized (entityCache) {
			return entityCache.get(id);
		}
	}

	@Override
	public void spawnEntity(Entity entity) {
		synchronized (entityCache) {
			entityCache.put(entity.getId(), entity);
		}

		if (entity instanceof PlayerEntity) {
			if (entity instanceof LocalPlayer) {
				localPlayer = (LocalPlayer) entity;
				System.out.println("LocalPlayer spawned as " + localPlayer);
			} else {
				PlayerEntity player = (PlayerEntity) entity;
				synchronized (playerCache) {
					playerCache.put(player.getName(), player);
				}
			}
		}
	}

	@Override
	public void despawnEntity(int eId) {
		Entity entity = null;
		synchronized (entityCache) {
			entity = entityCache.remove(eId);
		}

		if (entity instanceof PlayerEntity) {
			if (entity instanceof LocalPlayer) {
				System.out.println("Despawned local player " + localPlayer);
				localPlayer = null;
			} else {
				PlayerEntity player = (PlayerEntity) entity;
				synchronized (playerCache) {
					playerCache.remove(player.getName());
				}
			}
		}
	}

	@Override
	public void despawnEntity(Entity entity) {
		if (entity != null)
			despawnEntity(entity.getId());
	}

	@Override
	public PlayerEntity getPlayerByName(String name) {
		synchronized (playerCache) {
			return playerCache.get(name);
		}
	}

	@Override
	public PlayerEntity[] getPlayers() {
		synchronized (playerCache) {
			return playerCache.values().toArray(new PlayerEntity[playerCache.size()]);
		}
	}

	@Override
	public LocalPlayer getLocalPlayer() {
		return localPlayer;
	}

	@Override
	public void watch(WatchableObject o) {
		throw new UnsupportedOperationException("DefaultMinecraftWorlds don't support tickable objects.");
	}

	@Override
	public void unwatch(WatchableObject o) {
		throw new UnsupportedOperationException("DefaultMinecraftWorlds don't support tickable objects.");
	}

	@Override
	public EntityFactory<LivingEntity, Integer> getLivingEntityFactory() {
		return livingEntityFactory;
	}

	@Override
	public NameRegistry getLivingEntityRegistry() {
		return livingEntityRegistry;
	}

	@Override
	public EntityFactory<ObjectEntity, Integer> getObjectEntityFactory() {
		return objectEntityFactory;
	}

	@Override
	public NameRegistry getObjectEntityRegistry() {
		return objectEntityRegistry;
	}

	@Override
	public EntityFactory<TileEntity, CompoundTag> getTileEntityFactory() {
		return tileEntityFactory;
	}

	@Override
	public NameRegistry getTileEntityRegistry() {
		return tileEntityRegistry;
	}

	@Override
	public BlockFactory getBlockFactory() {
		return blockFactory;
	}

	@Override
	public BlockRegistry getBlockRegistry() {
		return blockRegistry;
	}

	@Override
	public MaterialRegistry getMaterialRegistry() {
		return materialRegistry;
	}

	@Override
	public PaintingRegistry getPaintingRegistry() {
		return paintingRegistry;
	}
}