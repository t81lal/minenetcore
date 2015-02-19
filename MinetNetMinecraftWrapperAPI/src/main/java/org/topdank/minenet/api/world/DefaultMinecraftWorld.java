package org.topdank.minenet.api.world;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.topdank.eventbus.EventBus;
import org.topdank.eventbus.EventPriority;
import org.topdank.eventbus.EventTarget;
import org.topdank.minenet.api.BotContext;
import org.topdank.minenet.api.BotVersionProvider;
import org.topdank.minenet.api.ai.pathfinding.EuclideanHeuristic;
import org.topdank.minenet.api.ai.pathfinding.PathSearchProvider;
import org.topdank.minenet.api.ai.pathfinding.astar.AStarPathSearchProvider;
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
import org.topdank.minenet.api.game.BoundingBox;
import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.game.location.ChunkLocation;
import org.topdank.minenet.api.nbt.tag.builtin.CompoundTag;
import org.topdank.minenet.api.provider.registry.NameRegistry;
import org.topdank.minenet.api.world.block.Block;
import org.topdank.minenet.api.world.block.Chunk;
import org.topdank.minenet.api.world.block.art.PaintingRegistry;
import org.topdank.minenet.api.world.block.id.BlockId;
import org.topdank.minenet.api.world.block.material.MaterialRegistry;
import org.topdank.minenet.api.world.block.provider.factory.BlockFactory;
import org.topdank.minenet.api.world.block.provider.registry.BlockData;
import org.topdank.minenet.api.world.block.provider.registry.BlockRegistry;
import org.topdank.minenet.api.world.settings.WorldSettings;

public class DefaultMinecraftWorld implements World, EntityHandler {

	private static final BlockLocation[] SURROUNDING_BLOCKLOCATION_TEMPLATES = new BlockLocation[] {
			// middle y + 0
			new BlockLocation(-1, 0, 1), new BlockLocation(0, 0, 1), new BlockLocation(1, 0, 1), new BlockLocation(-1, 0, 0), new BlockLocation(1, 0, 0), new BlockLocation(-1, 0, -1),
			new BlockLocation(0, 0, -1),
			new BlockLocation(1, 0, -1),
			// bottom y - 1
			new BlockLocation(-1, -1, 1), new BlockLocation(0, -1, 1), new BlockLocation(1, -1, 1), new BlockLocation(-1, -1, 0), new BlockLocation(0, -1, 0), new BlockLocation(1, -1, 0),
			new BlockLocation(-1, -1, -1), new BlockLocation(0, -1, -1), new BlockLocation(1, -1, -1),
			// top y + 1
			new BlockLocation(-1, 1, 1), new BlockLocation(0, 1, 1), new BlockLocation(1, 1, 1), new BlockLocation(-1, 1, 0), new BlockLocation(0, 1, 0), new BlockLocation(1, 1, 0),
			new BlockLocation(-1, 1, -1), new BlockLocation(0, 1, -1), new BlockLocation(1, 1, -1),

	};

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

	protected final Map<ChunkLocation, Chunk> chunks;

	protected final Map<Integer, Entity> entityCache;
	protected final Map<String, PlayerEntity> playerCache;

	protected final AStarPathSearchProvider pathSearchProvider;

	protected final boolean[] solidBlockData;
	protected final Map<Integer, Boolean> pathableBlocks;

	protected WorldSettings worldSettings;

	protected long worldAge, worldTime;

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

		chunks = new HashMap<ChunkLocation, Chunk>();
		entityCache = new HashMap<Integer, Entity>();
		playerCache = new HashMap<String, PlayerEntity>();

		pathSearchProvider = new AStarPathSearchProvider(new EuclideanHeuristic(), this);

		// fill fast solid block data lookup cache
		Map<BlockId, BlockData> blockDatas = blockRegistry.asMap();
		// not the size of the map because the data is discontiguous
		solidBlockData = new boolean[highBlockId(blockDatas) + 1]; // +1 because array[highest] is 1 based whereas array is 0 based
		// System.out.println(String.format("solidBlockData.length = %d", solidBlockData.length));
		for (Entry<BlockId, BlockData> entry : blockDatas.entrySet()) {
			solidBlockData[entry.getKey().getId()] = entry.getValue().isSolid();
			// System.out.println(String.format("Setting [%d] as [%b]", index - 1, bd.isSolid()));
		}

		// invalid standing on blocks: water, lava, fences
		pathableBlocks = new HashMap<Integer, Boolean>(); // get is pretty fast because its a hash cache
		for (Entry<BlockId, BlockData> entry : blockDatas.entrySet()) {
			// WE DO THIS ANYWAY
			// {we probably shouldnt put 'false's into the map because null checks are fast on the cpu
			// (not sure if faster than bool checks)}
			String name = entry.getValue().getName();
			switch (name) {
				case "Water":
				case "Lava":
					pathableBlocks.put(entry.getKey().getId(), false);
					break;
				default:
					if (name.contains("Fence"))
						pathableBlocks.put(entry.getKey().getId(), false);
					else
						pathableBlocks.put(entry.getKey().getId(), true);
					break;
			}
		}

		eventBus.register(this);
	}

	private static int highBlockId(Map<BlockId, BlockData> map) {
		int highest = 0;
		Iterator<BlockId> idIt = map.keySet().iterator();
		while (idIt.hasNext()) {
			BlockId id = idIt.next();
			if (id.getId() > highest)
				highest = id.getId();
		}
		System.out.println(String.format("Highest id = %d", highest));
		return highest;
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
		BlockLocation[] locations = new BlockLocation[SURROUNDING_BLOCKLOCATION_TEMPLATES.length];
		for (int i = 0; i < locations.length; i++)
			locations[i] = location.offset(SURROUNDING_BLOCKLOCATION_TEMPLATES[i]);
		return locations;

		// throw new UnsupportedOperationException("DefaultMinecraftWorlds don't support adject block finding yet.");
	}

	@Override
	public boolean canWalk(BlockLocation location, BlockLocation location2) {
		int x = location.getX(), y = location.getY(), z = location.getZ();
		int x2 = location2.getX(), y2 = location2.getY(), z2 = location2.getZ();
		if (y2 < 0)
			return false;
		boolean valid = true;
		valid = valid && isEmpty(x2, y2, z2); // Block at must be non-solid
		valid = valid && isEmpty(x2, y2 + 1, z2); // Block above must be non-solid

		int lowerBlock = getBlockData(x2, y2 - 1, z2);

		boolean b = isPathable(lowerBlock);
		valid = valid && b;
		// System.out.println(String.format("Block [%d] at [%d, %d, %d] climable = %b, empty = %b", lowerBlock, x2, y2 - 1, z2, b,
		// isEmpty(x2, y2 - 1, z2)));
		// valid = valid && (lowerBlock != 10);
		// valid = valid && (lowerBlock != 11);
		if (isEmpty(x, y - 1, z))
			valid = valid
					&& (((y2 < y) && (x2 == x) && (z2 == z))
							|| ((canClimb(location) && canClimb(location2)) || (!canClimb(location) && canClimb(location2)) || (canClimb(location) && !canClimb(location2) && ((x2 == x)
									&& (z2 == z) ? true : !isEmpty(x2, y2 - 1, z2)))) || !isEmpty(x2, y2 - 1, z2));
		if ((y != y2) && ((x != x2) || (z != z2)))
			return false;
		if ((x != x2) && (z != z2)) {
			valid = valid && isEmpty(x2, y, z);
			valid = valid && isEmpty(x, y, z2);
			valid = valid && isEmpty(x2, y + 1, z);
			valid = valid && isEmpty(x, y + 1, z2);
			if (y != y2) {
				valid = valid && isEmpty(x2, y2, z);
				valid = valid && isEmpty(x, y2, z2);
				valid = valid && isEmpty(x, y2, z);
				valid = valid && isEmpty(x2, y, z2);
				valid = valid && isEmpty(x2, y + 1, z2);
				valid = valid && isEmpty(x, y2 + 1, z);
				valid = false;
			}
		} else if ((x != x2) && (y != y2)) {
			valid = valid && isEmpty(x2, y, z);
			valid = valid && isEmpty(x, y2, z);
			if (y > y2)
				valid = valid && isEmpty(x2, y + 1, z);
			else
				valid = valid && isEmpty(x, y2 + 1, z);
			valid = false;
		} else if ((z != z2) && (y != y2)) {
			valid = valid && isEmpty(x, y, z2);
			valid = valid && isEmpty(x, y2, z);
			if (y > y2)
				valid = valid && isEmpty(x, y + 1, z2);
			else
				valid = valid && isEmpty(x, y2 + 1, z);
			valid = false;
		}
		// int nodeBlockUnder = getBlockData(x2, y2 - 1, z2);
		if (!isPathable(lowerBlock))
			valid = false;
		return valid;

		// throw new UnsupportedOperationException("DefaultMinecraftWorlds don't support pathing yet.");
	}

	private boolean isPathable(int id) {
		Boolean b = pathableBlocks.get(id);
		// if (b == null)
		// System.out.println(String.format("Null entry [%d]", id));
		// if (b == null)// not in the map so 'false' which means its climable
		// return true;
		// return !b;
		return b;
	}

	private boolean isEmpty(int x, int y, int z) {
		int id = getBlockData(x, y, z);
		// boolean b = (id >= 0) && (id < solidBlockData.length);
		// if (!b) {
		// System.out.println(String.format("Block [%d] at [%d, %d, %d] doesn't fit in solid block array.", id, x, y, z));
		// }
		return (id >= 0) && (id < solidBlockData.length) && !solidBlockData[id];
	}

	@Override
	public boolean canClimb(BlockLocation location) {
		int id = getBlockData(location);
		BlockData data = blockRegistry.getByKey(BlockId.create(id));
		String name = data.getName();
		if (name.equals("Water") || name.equals("Ladder")) // Water / Moving Water / Ladder
			return true;
		if (name.equals("Vines")) { // Vines (which require an adjacent solid block)
			if (!isEmpty(location.getX(), location.getY(), location.getZ() + 1) || !isEmpty(location.getX(), location.getY(), location.getZ() - 1)
					|| !isEmpty(location.getX() + 1, location.getY(), location.getZ()) || !isEmpty(location.getX() - 1, location.getY(), location.getZ()))
				return true;
		}
		return false;
		// throw new UnsupportedOperationException("DefaultMinecraftWorlds don't support pathing yet.");
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
	public Block getBlock(BlockLocation loc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getBlock(int x, int y, int z) {
		int chunkX = x >> 4, chunkY = y >> 4, chunkZ = z >> 4;
		Chunk chunk = getChunkAt(new ChunkLocation(chunkX, chunkY, chunkZ));
		if (chunk == null)
			return null;

		int chunkBaseX = chunkX << 4, chunkBaseY = chunkY << 4, chunkBaseZ = chunkZ << 4;
		int data = chunk.getBlocks().get(x - chunkBaseX, y - chunkBaseY, z - chunkBaseZ);
		return blockFactory.create(this, x, y, z, BlockId.create(data));
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

	@Override
	public Set<Block> getCollidingBlocks(BoundingBox box) {
		Set<Block> blocks = new HashSet<Block>();
		int minX = (int) Math.floor(box.getMinX());
		int minY = (int) Math.floor(box.getMinY() - 1);
		int minZ = (int) Math.floor(box.getMinZ());
		int maxX = (int) Math.ceil(box.getMaxX());
		int maxY = (int) Math.ceil(box.getMaxY());
		int maxZ = (int) Math.ceil(box.getMaxZ());
		synchronized (chunks) {
			Chunk chunk = null;
			BlockLocation chunkBase = null;
			for (int x = minX; x < maxX; x++) {
				for (int z = minZ; z < maxZ; z++) {
					for (int y = minY; y < maxY; y++) {

						if ((chunkBase == null) || (x < chunkBase.getX()) || (y < chunkBase.getY()) || (z < chunkBase.getZ()) || ((x - chunkBase.getX()) >= 16)
								|| ((y - chunkBase.getY()) >= 16) || ((z - chunkBase.getZ()) >= 16)) {
							ChunkLocation chunkLocation = new ChunkLocation(new BlockLocation(x, y, z));
							chunk = chunks.get(chunkLocation);
							// System.out.println(String.format("Found chunk [%b] at [%s]", chunk != null, chunkLocation.toString()));
							chunkBase = new BlockLocation(chunkLocation);
						}
						/* else { boolean chunkNull = chunkBase == null; boolean xLess = x < chunkBase.getX(); boolean yLess = y <
						 * chunkBase.getY(); boolean zLess = z < chunkBase.getZ(); boolean xMore = (x - chunkBase.getX()) >= 16; boolean
						 * yMore = (y - chunkBase.getY()) >= 16; boolean zMore = (z - chunkBase.getZ()) >= 16;
						 * 
						 * System.out.println(String.format(
						 * "Chunk at [%d, %d, %d] | [%s] | [%s] | [ChunkNull: %b, x < c.X: %b, y < c.Y: %b, z < c.Z: %b, r.X >= 16: %b, r.Y >= 16: %b, r.Z >= 16: %b]"
						 * , x, y, z, chunkLocation.toString(), chunkBase.toString(), chunkNull, xLess, yLess, zLess, xMore, yMore, zMore));
						 * } */

						if (chunk != null) {
							// x - chunkBase.getX() is the relative x of the block inside of the chunk
							int id = chunk.getBlocks().get(x - chunkBase.getX(), y - chunkBase.getY(), z - chunkBase.getZ());
							if (id == 0) {
								// System.out.println(String.format("Block at [%d, %d, %d] = 0", x, y, z));
								continue;
							}
							Block block = blockFactory.create(this, x, y, z, BlockId.create(id));
							if (block == null)
								continue;

							// System.out.println(String.format("Block at [%d, %d, %d] = %s", x, y, z, block.getBlockData().getName()));

							// boolean intersects = false;
							for (BoundingBox blockBox : block.getBoundingBoxes()) {
								if (box.intersectsWith(blockBox)) {
									// intersects = true;
									blocks.add(block);
									break;
								}
							}
							// if (!intersects)
							// continue;
							// blocks.add(block);
						}
					}
				}
			}
		}
		return blocks;
	}

	@Override
	public boolean isColliding(BoundingBox box) {
		int minX = (int) Math.floor(box.getMinX());
		int minY = (int) Math.floor(box.getMinY() - 1);
		int minZ = (int) Math.floor(box.getMinZ());
		int maxX = (int) Math.ceil(box.getMaxX());
		int maxY = (int) Math.ceil(box.getMaxY());
		int maxZ = (int) Math.ceil(box.getMaxZ());
		synchronized (chunks) {
			Chunk chunk = null;
			BlockLocation chunkBase = null;
			for (int x = minX; x < maxX; x++) {
				for (int z = minZ; z < maxZ; z++) {
					for (int y = minY; y < maxY; y++) {
						if ((chunkBase == null) || (x < chunkBase.getX()) || (y < chunkBase.getY()) || (z < chunkBase.getZ()) || ((x - chunkBase.getX()) >= 16)
								|| ((y - chunkBase.getY()) >= 16) || ((z - chunkBase.getZ()) >= 16)) {
							ChunkLocation chunkLocation = new ChunkLocation(new BlockLocation(x, y, z));
							chunk = getChunkAt(chunkLocation);
							if (chunk != null)
								chunkBase = chunk.getBlockLocation();
							else
								chunkBase = new BlockLocation(chunkLocation);
						}
						if (chunk != null) {
							// x - chunkBase.getX() is the relative x of the block inside of the chunk
							int id = chunk.getBlocks().get(x - chunkBase.getX(), y - chunkBase.getY(), z - chunkBase.getZ());
							if (id == 0) {
								continue;
							}
							Block block = blockFactory.create(this, x, y, z, BlockId.create(id));
							if (block == null)
								continue;

							boolean intersects = false;
							for (BoundingBox blockBox : block.getBoundingBoxes()) {
								if (box.intersectsWith(blockBox)) {
									intersects = true;
									break;
								}
							}
							if (!intersects)
								continue;
							return true;
						}
					}
				}
			}
		}
		return false;
		// throw new UnsupportedOperationException("DefaultMinecraftWorlds don't support collision management yet.");
	}

	@Override
	public boolean isInBlocks(BoundingBox box, String... blocks) {
		int minX = (int) Math.floor(box.getMinX());
		int minY = (int) Math.floor(box.getMinY() - 1);
		int minZ = (int) Math.floor(box.getMinZ());
		int maxX = (int) Math.ceil(box.getMaxX());
		int maxY = (int) Math.ceil(box.getMaxY());
		int maxZ = (int) Math.ceil(box.getMaxZ());
		synchronized (chunks) {
			Chunk chunk = null;
			BlockLocation chunkBase = null;
			for (int x = minX; x < maxX; x++) {
				for (int z = minZ; z < maxZ; z++) {
					for (int y = minY; y < maxY; y++) {

						ChunkLocation chunkLocation = new ChunkLocation(new BlockLocation(x, y, z));
						if ((chunkBase == null) || (x < chunkBase.getX()) || (y < chunkBase.getY()) || (z < chunkBase.getZ()) || ((x - chunkBase.getX()) >= 16)
								|| ((y - chunkBase.getY()) >= 16) || ((z - chunkBase.getZ()) >= 16)) {
							chunk = getChunkAt(chunkLocation);
							if (chunk != null)
								chunkBase = chunk.getBlockLocation();
							else
								chunkBase = new BlockLocation(chunkLocation);
						}

						if (chunk != null) {
							// x - chunkBase.getX() is the relative x of the block inside of the chunk
							int id = chunk.getBlocks().get(x - chunkBase.getX(), y - chunkBase.getY(), z - chunkBase.getZ());
							if (id == 0) {
								continue;
							}
							Block block = blockFactory.create(this, x, y, z, BlockId.create(id));
							if (block == null)
								continue;

							boolean matches = false;
							for (String b : blocks) {
								BlockData data = blockRegistry.getByKey(BlockId.create(id));
								if (data.getName().equalsIgnoreCase(b)) {
									matches = true;
									break;
								}
							}
							if (!matches)
								continue;
							boolean intersects = true;
							for (BoundingBox blockBox : block.getBoundingBoxes()) {
								if (box.intersectsWith(blockBox)) {
									intersects = true;
									break;
								} else
									intersects = false;
							}
							if (!intersects)
								continue;
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public PathSearchProvider getPathSearchProvider() {
		return pathSearchProvider;
	}
}