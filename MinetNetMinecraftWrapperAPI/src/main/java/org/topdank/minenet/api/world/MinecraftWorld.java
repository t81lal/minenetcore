package org.topdank.minenet.api.world;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.topdank.minenet.api.BotContext;
import org.topdank.minenet.api.ai.pathfinding.ManhattanHeuristic;
import org.topdank.minenet.api.ai.pathfinding.PathSearchProvider;
import org.topdank.minenet.api.ai.pathfinding.astar.AStarPathSearchProvider;
import org.topdank.minenet.api.entity.Entity;
import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.entity.living.player.LocalPlayer;
import org.topdank.minenet.api.entity.living.player.PlayerEntity;
import org.topdank.minenet.api.entity.object.ObjectEntity;
import org.topdank.minenet.api.entity.object.projectile.thrown.ThrownEntity;
import org.topdank.minenet.api.entity.tile.TileEntity;
import org.topdank.minenet.api.event.TickEvent;
import org.topdank.minenet.api.event.entity.EntityCollectEvent;
import org.topdank.minenet.api.event.entity.EntityDespawnEvent;
import org.topdank.minenet.api.event.entity.EntityDismountEvent;
import org.topdank.minenet.api.event.entity.EntityHeadRotateEvent;
import org.topdank.minenet.api.event.entity.EntityMetadataUpdateEvent;
import org.topdank.minenet.api.event.entity.EntityMountEvent;
import org.topdank.minenet.api.event.entity.EntityMoveEvent;
import org.topdank.minenet.api.event.entity.EntityRotateEvent;
import org.topdank.minenet.api.event.entity.EntityTeleportEvent;
import org.topdank.minenet.api.event.entity.LivingEntitySpawnEvent;
import org.topdank.minenet.api.event.entity.ObjectEntitySpawnEvent;
import org.topdank.minenet.api.event.entity.PlayerSpawnEvent;
import org.topdank.minenet.api.event.world.ChunkLoadEvent;
import org.topdank.minenet.api.event.world.InternalBlockChangeEvent;
import org.topdank.minenet.api.event.world.InternalChunkLoadEvent;
import org.topdank.minenet.api.event.world.RespawnEvent;
import org.topdank.minenet.api.event.world.TileEntityUpdateEvent;
import org.topdank.minenet.api.event.world.TimeUpdateEvent;
import org.topdank.minenet.api.game.BoundingBox;
import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.game.location.ChunkLocation;
import org.topdank.minenet.api.game.location.PreciseLocation;
import org.topdank.minenet.api.world.block.Block;
import org.topdank.minenet.api.world.block.BlockType;
import org.topdank.minenet.api.world.block.Chunk;
import org.topdank.minenet.api.world.settings.WorldSettings;

import eu.bibl.eventbus.EventBus;
import eu.bibl.eventbus.EventPriority;
import eu.bibl.eventbus.EventTarget;

public class MinecraftWorld implements World {

	protected BotContext context;
	protected EventBus bus;

	protected WorldSettings worldSettings;
	protected long worldAge;
	protected long time;

	protected Map<Integer, Entity> entities;
	protected Map<String, PlayerEntity> players;
	protected Map<Integer, WatchableObject> watchedObjects;
	protected Map<ChunkLocation, Chunk> chunks;
	protected Map<BlockLocation, TileEntity> tileEntities;
	protected LocalPlayer localPlayer;

	protected PathSearchProvider pathFinder;

	public MinecraftWorld(BotContext context, WorldSettings worldSettings) {
		this.context = context;
		bus = context.getEventBus();
		this.worldSettings = worldSettings;

		entities = new HashMap<Integer, Entity>();
		players = new HashMap<String, PlayerEntity>();
		watchedObjects = new HashMap<Integer, WatchableObject>();
		chunks = new HashMap<ChunkLocation, Chunk>();
		tileEntities = new HashMap<BlockLocation, TileEntity>();

		pathFinder = new AStarPathSearchProvider(new ManhattanHeuristic(), new SimpleWorldPhysics(this));

		bus.register(this);
	}

	@Override
	public WorldSettings getSettings() {
		return worldSettings;
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onTickEvent(TickEvent e) {
		synchronized (watchedObjects) {
			for (WatchableObject o : watchedObjects.values()) {
				o.update();
			}
		}
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onTimeUpdate(TimeUpdateEvent event) {
		time = event.getTime();
		worldAge = event.getWorldAge();
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onRespawn(RespawnEvent event) {
		synchronized (chunks) {
			chunks.clear();
		}
		worldSettings.setDifficulty(event.getDifficulty()).setDimension(event.getRespawnDimension()).setGameMode(event.getGameMode()).setWorldType(event.getWorldType());
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onPlayerSpawn(PlayerSpawnEvent event) {
		PlayerEntity entity = new PlayerEntity(this, event.getEntityId(), event.getPlayerName(), event.getGameMode());
		entity.setLocation(event.getLocation());
		entity.setYaw(event.getYaw());
		entity.setPitch(event.getPitch());
		entity.setWornItemAt(0, event.getHeldItem());
		if (event.getMetadata() != null)
			entity.updateMetadata(event.getMetadata());
		spawnEntity(entity);
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onEntityCollect(EntityCollectEvent event) {
		Entity entity = getEntityById(event.getCollectedId());
		if (entity != null)
			despawnEntity(entity);
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onObjectEntitySpawn(ObjectEntitySpawnEvent e) {
		ObjectEntity entity = context.getVersionProvider().getEntityProvider().getObjectEntityProvider().getFactory().create(e.getEntityType(), this, e.getEntityId());
		entity.setLocation(e.getLocation());
		entity.setYaw(e.getYaw());
		entity.setPitch(e.getPitch());
		entity.setMotion(e.getSpeedX(), e.getSpeedY(), e.getSpeedZ());
		if ((entity instanceof ThrownEntity)) {
			Entity thrower = getEntityById(e.getThrowerId());
			if (thrower != null)
				((ThrownEntity) entity).setThrower(thrower);
		} else {
			System.out.println("Spawning object entity " + entity);
			System.out.println("Extra data is " + e.getThrowerId());
		}
		spawnEntity(entity);
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onLivingEntitySpawn(LivingEntitySpawnEvent e) {
		LivingEntity entity = context.getVersionProvider().getEntityProvider().getLivingEntityProvider().getFactory().create(e.getEntityType(), this, e.getEntityId());
		entity.setLocation(e.getLocation());
		entity.setYaw(e.getYaw());
		entity.setPitch(e.getPitch());
		entity.setHeadYaw(e.getHeadYaw());
		entity.setMotion(e.getVelocityX(), e.getVelocityY(), e.getVelocityZ());
		if (e.getMetadata() != null)
			entity.updateMetadata(e.getMetadata());
		spawnEntity(entity);
	}

	// @EventTarget(priority = EventPriority.HIGHEST)
	// public void onPaintingSpawn(PaintingSpawnEvent e) {
	// PaintingEntity entity = new PaintingEntity(this, e.getEntityId(),
	// context.getVersionProvider().getPaintingRegistry()
	// .getByName(e.getTitle()));
	// entity.setLocation(e.getLocation());
	// entity.setDirection(e.getDirection());
	// spawnEntity(entity);
	// }

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onEntityDespawn(EntityDespawnEvent event) {
		Entity entity = getEntityById(event.getEntityId());
		if (entity != null) {
			despawnEntity(entity);
			entity.setDead(true);
		}
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onEntityMove(EntityMoveEvent e) {
		Entity entity = getEntityById(e.getEntityId());
		if (entity == null)
			return;
		entity.setLocation(entity.getX() + e.getX(), entity.getY() + e.getY(), entity.getZ() + e.getZ());
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onEntityRotate(EntityRotateEvent event) {
		Entity entity = getEntityById(event.getEntityId());
		if (entity == null)
			return;
		entity.setYaw(event.getYaw());
		entity.setPitch(event.getPitch());
	}

	// inlined in protocol
	// @EventTarget(priority = EventPriority.HIGHEST)
	// public void onEntityMoveRotateEvent(EntityMoveRotateEvent e) {
	// Entity entity = getEntityById(e.getEntityId());
	// if (entity == null)
	// return;
	// entity.setLocation(entity.getX() + e.getX(), entity.getY() + e.getY(),
	// entity.getZ() + e.getZ());
	// entity.setPitch(e.getPitch());
	// entity.setYaw(e.getYaw());
	// if (entity instanceof PlayerEntity)
	// System.out.println("moverot update");
	// }

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onEntityTeleport(EntityTeleportEvent event) {
		Entity entity = getEntityById(event.getEntityId());
		if (entity == null)
			return;
		entity.setLocation(event.getX(), event.getY(), event.getZ());
		entity.setYaw(event.getYaw());
		entity.setPitch(event.getPitch());
		if (event.setOnGround()) {
			entity.setOnGround(event.isOnGround());
		}
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onEntityHeadRotate(EntityHeadRotateEvent event) {
		Entity entity = getEntityById(event.getEntityId());
		if (entity == null)
			return;
		entity.setHeadYaw(event.getHeadYaw());
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onEntityMount(EntityMountEvent event) {
		Entity rider = getEntityById(event.getEntityId());
		Entity riding = getEntityById(event.getMountedEntityId());
		if ((rider == null) || (riding == null))
			return;
		rider.setRiding(riding);
		riding.setRider(rider);
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onEntityDismount(EntityDismountEvent event) {
		Entity rider = getEntityById(event.getEntityId());
		if (rider == null)
			return;
		if (rider.getRiding() != null) {
			rider.getRiding().setRider(null);
			rider.setRiding(null);
		}
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onEntityMetadataUpdate(EntityMetadataUpdateEvent event) {
		Entity entity = getEntityById(event.getEntityId());
		if (entity == null)
			return;
		entity.updateMetadata(event.getMetadata());
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onChunkLoad(InternalChunkLoadEvent event) {
		ChunkLocation location = new ChunkLocation(event.getX(), event.getY(), event.getZ());
		// System.out.println("at " + location);
		synchronized (chunks) {
			chunks.put(location, event.getChunk());
		}
		bus.dispatch(new ChunkLoadEvent(this, event.getChunk()));
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onBlockChange(InternalBlockChangeEvent event) {
		setBlockIdAt(event.getId(), event.getX(), event.getY(), event.getZ());
		if (event.getMetadata() != -1)
			setBlockMetadataAt(event.getMetadata(), event.getX(), event.getY(), event.getZ());
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onTileEntityUpdate(TileEntityUpdateEvent event) {
		System.out.println(event);
		BlockLocation location = new BlockLocation(event.getX(), event.getY(), event.getZ());
		TileEntity entity = context.getVersionProvider().getEntityProvider().getTileEntityProvider().getFactory().create(event.getType(), this, event.getCompound());
		entity.setX(event.getX());
		entity.setY(event.getY());
		entity.setZ(event.getZ());
		setTileEntityAt(entity, location);
	}

	// @EventTarget(priority = EventPriority.HIGHEST)
	// public void onSignUpdate(SignUpdateEvent event) {
	// setTileEntityAt(
	// new SignTileEntity(event.getLocation(), event.getText()),
	// event.getLocation());
	// }
	//
	// @EventTarget(priority = EventPriority.HIGHEST)
	// public void onEditTileEntity(EditTileEntityEvent event) {
	// TileEntity entity = getTileEntityAt(event.getX(), event.getY(),
	// event.getZ());
	// if (entity != null)
	// if (entity instanceof SignTileEntity)
	// bus.dispatch(new EditSignEvent(entity.getLocation()));
	// }

	@Override
	public Collection<Entity> getEntities() {
		synchronized (entities) {
			return entities.values();
		}
	}

	@Override
	public Entity getEntityById(int id) {
		synchronized (entities) {
			Entity e = entities.get(id);
			return e;
		}
	}

	@Override
	public void spawnEntity(Entity entity) {
		if (entity == null)
			return;
		synchronized (entities) {
			entities.put(entity.getId(), entity);
		}

		if (entity instanceof PlayerEntity) {
			synchronized (players) {
				PlayerEntity pEntity = (PlayerEntity) entity;// avoid 2 casts
				players.put(pEntity.getName().toLowerCase(), pEntity);
			}

			if (entity instanceof LocalPlayer) {
				localPlayer = (LocalPlayer) entity;
			}
		}
	}

	@Override
	public void despawnEntity(int eId) {
		despawnEntity(entities.get(eId));
	}

	@Override
	public void despawnEntity(Entity entity) {
		if (entity == null)
			return;
		synchronized (entities) {
			entities.remove(entity);
		}

		if (entity instanceof PlayerEntity) {
			synchronized (players) {
				PlayerEntity pEntity = (PlayerEntity) entity;// avoid 2 casts
				players.remove(pEntity.getName().toLowerCase());
			}

			if (entity instanceof LocalPlayer) {
				localPlayer = null;
			}
		}
	}

	@Override
	public PlayerEntity getPlayerByName(String name) {
		synchronized (players) {
			return players.get(name.toLowerCase());
		}
	}

	@Override
	public PlayerEntity[] getPlayers() {
		synchronized (players) {
			return players.values().toArray(new PlayerEntity[players.size()]);
		}
	}

	@Override
	public LocalPlayer getLocalPlayer() {
		return localPlayer;
	}

	@Override
	public void watch(WatchableObject o) {
		if ((o != null) && (o.getId() != -1))
			watchedObjects.put(o.getId(), o);
		if (o instanceof PlayerEntity) {
			System.out.println("watching " + ((PlayerEntity) o).getName());
		}
	}

	@Override
	public void unwatch(WatchableObject o) {
		if (watchedObjects.containsKey(o.getId()))
			watchedObjects.remove(o.getId());
		if (o instanceof PlayerEntity) {
			System.out.println("unwatching " + ((PlayerEntity) o).getName());
		}
	}

	@Override
	public long getWorldAge() {
		return worldAge;
	}

	@Override
	public long getTime() {
		return time;
	}

	@Override
	public Block getBlockAt(int x, int y, int z) {
		return getBlockAt(new BlockLocation(x, y, z));
	}

	@Override
	public Block getBlockAt(BlockLocation location) {
		ChunkLocation chunkLocation = new ChunkLocation(location);
		Chunk chunk = getChunkAt(chunkLocation);
		if (chunk == null)
			return null;
		BlockLocation chunkBlockOffset = new BlockLocation(chunkLocation);
		int chunkOffsetX = location.getX() - chunkBlockOffset.getX();
		int chunkOffsetY = location.getY() - chunkBlockOffset.getY();
		int chunkOffsetZ = location.getZ() - chunkBlockOffset.getZ();
		int id = chunk.getBlocks().getBlock(chunkOffsetX, chunkOffsetY, chunkOffsetZ);
		int metadata = chunk.getBlocks().getData(chunkOffsetX, chunkOffsetY, chunkOffsetZ);
		return new Block(this, chunk, location, id, metadata);
	}

	@Override
	public int getBlockIdAt(int x, int y, int z) {
		return getBlockIdAt(new BlockLocation(x, y, z));
	}

	@Override
	public int getBlockIdAt(BlockLocation blockLocation) {
		ChunkLocation location = new ChunkLocation(blockLocation);
		BlockLocation chunkBlockOffset = new BlockLocation(location);
		Chunk chunk = getChunkAt(location);
		if (chunk == null)
			return 0;
		int id = chunk.getBlocks().getBlock(blockLocation.getX() - chunkBlockOffset.getX(), blockLocation.getY() - chunkBlockOffset.getY(), blockLocation.getZ() - chunkBlockOffset.getZ());
		return id;
	}

	@Override
	public void setBlockIdAt(int id, int x, int y, int z) {
		setBlockIdAt(id, new BlockLocation(x, y, z));
	}

	@Override
	public void setBlockIdAt(int id, BlockLocation blockLocation) {
		ChunkLocation location = new ChunkLocation(blockLocation);
		BlockLocation chunkBlockOffset = new BlockLocation(location);
		Chunk chunk = getChunkAt(location);
		if (chunk == null)
			return;
		chunk.getBlocks().setBlock(blockLocation.getX() - chunkBlockOffset.getX(), blockLocation.getY() - chunkBlockOffset.getY(), blockLocation.getZ() - chunkBlockOffset.getZ(), id);
	}

	@Override
	public int getBlockMetadataAt(int x, int y, int z) {
		return getBlockMetadataAt(new BlockLocation(x, y, z));
	}

	@Override
	public int getBlockMetadataAt(BlockLocation blockLocation) {
		ChunkLocation location = new ChunkLocation(blockLocation);
		BlockLocation chunkBlockOffset = new BlockLocation(location);
		Chunk chunk = getChunkAt(location);
		if (chunk == null)
			return 0;
		int metadata = chunk.getBlocks().getData(blockLocation.getX() - chunkBlockOffset.getX(), blockLocation.getY() - chunkBlockOffset.getY(),
				blockLocation.getZ() - chunkBlockOffset.getZ());
		return metadata;
	}

	@Override
	public void setBlockMetadataAt(int metadata, int x, int y, int z) {
		setBlockMetadataAt(metadata, new BlockLocation(x, y, z));
	}

	@Override
	public void setBlockMetadataAt(int metadata, BlockLocation blockLocation) {
		ChunkLocation location = new ChunkLocation(blockLocation);
		BlockLocation chunkBlockOffset = new BlockLocation(location);
		Chunk chunk = getChunkAt(location);
		if (chunk == null)
			return;
		chunk.getBlocks().setData(metadata, blockLocation.getX() - chunkBlockOffset.getX(), blockLocation.getY() - chunkBlockOffset.getY(), blockLocation.getZ() - chunkBlockOffset.getZ());
	}

	@Override
	public TileEntity getTileEntityAt(int x, int y, int z) {
		return getTileEntityAt(new BlockLocation(x, y, z));
	}

	@Override
	public TileEntity getTileEntityAt(BlockLocation blockLocation) {
		return tileEntities.get(blockLocation);
		// ChunkLocation location = new ChunkLocation(blockLocation);
		// BlockLocation chunkBlockOffset = new BlockLocation(location);
		// Chunk chunk = getChunkAt(location);
		// if (chunk == null)
		// return null;
		// TileEntity tileEntity = tileEntities.get(new
		// BlockLocation(blockLocation.getX() - chunkBlockOffset.getX(),
		// blockLocation.getY() - chunkBlockOffset.getY(), blockLocation.getZ()
		// - chunkBlockOffset.getZ()));
		// return tileEntity;
	}

	@Override
	public void setTileEntityAt(TileEntity tileEntity, int x, int y, int z) {
		setTileEntityAt(tileEntity, new BlockLocation(x, y, z));
	}

	@Override
	public void setTileEntityAt(TileEntity tileEntity, BlockLocation blockLocation) {
		// ChunkLocation location = new ChunkLocation(blockLocation);
		// BlockLocation chunkBlockOffset = new BlockLocation(location);
		// Chunk chunk = getChunkAt(location);
		// if (chunk == null)
		// return;
		// tileEntities.put(new BlockLocation(blockLocation.getX() -
		// chunkBlockOffset.getX(), blockLocation.getY() -
		// chunkBlockOffset.getY(), blockLocation.getZ() -
		// chunkBlockOffset.getZ()), tileEntity);
		tileEntities.put(blockLocation, tileEntity);
	}

	// @Override
	// public Chunk getChunkAt(int x, int z) {
	// return getChunkAt(new ChunkLocation(x, z));
	// }

	@Override
	public Chunk getChunkAt(int x, int y, int z) {
		return getChunkAt(new ChunkLocation(x >> 4, y >> 4, z >> 4));
	}

	@Override
	public Chunk getChunkAt(BlockLocation loc) {
		return getChunkAt(new ChunkLocation(loc));
	}

	@Override
	public Chunk getChunkAt(PreciseLocation loc) {
		return getChunkAt(new ChunkLocation(loc));
	}

	@Override
	public Chunk getChunkAt(ChunkLocation location) {
		synchronized (chunks) {
			return chunks.get(location);
		}
	}

	@Override
	public void destroy() {
		bus.unregister(this);
		synchronized (entities) {
			for (Entity entity : entities.values())
				entity.setDead(true);
			entities.clear();
		}
		synchronized (chunks) {
			chunks.clear();
		}
		System.gc();
	}

	@Override
	public EventBus getEventBus() {
		return bus;
	}

	@Override
	public PathSearchProvider getPathSearchProvider() {
		return pathFinder;
	}

	@Override
	public boolean isColliding(BoundingBox box) {
		int minX = (int) Math.floor(box.getMinX());
		int minY = (int) Math.floor(box.getMinY());
		int minZ = (int) Math.floor(box.getMinZ());
		int maxX = (int) Math.ceil(box.getMaxX());
		int maxY = (int) Math.ceil(box.getMaxY());
		int maxZ = (int) Math.ceil(box.getMaxZ());
		synchronized (chunks) {
			Chunk chunk = null;
			BlockLocation chunkBase = null;
			for (int x = minX; x <= maxX; x++) {
				for (int z = minZ; z <= maxZ; z++) {
					for (int y = minY; y <= maxY; y++) {
						if (chunkBase == null || chunkBase.getY() - y >= 16 || chunkBase.getX() - x >= 16 || chunkBase.getZ() - z >= 16) {
							ChunkLocation chunkLocation = new ChunkLocation(new BlockLocation(x, y, z));
							chunk = getChunkAt(chunkLocation);
							if (chunk != null)
								chunkBase = chunkLocation.toBlockLocation();
							else
								throw new IllegalArgumentException("Invalid chunk " + chunk + " when " + chunkLocation);
						}
						if (chunk != null) {
							Block block = null;
							if (chunk.getBlocks().contains(x - chunkBase.getX(), y - chunkBase.getY(), z - chunkBase.getZ())) {
								int id = chunk.getBlocks().getBlock(x - chunkBase.getX(), y - chunkBase.getY(), z - chunkBase.getZ());
								int metadata = chunk.getBlocks().getData(x - chunkBase.getX(), y - chunkBase.getY(), z - chunkBase.getZ());
								if (id >= 0)
									block = new Block(this, chunk, chunkBase, id, metadata);
							}

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
	}

	@Override
	public Set<Block> getCollidingBlocks(BoundingBox box) {
		Set<Block> blocks = new HashSet<>();
		int minX = (int) Math.floor(box.getMinX());
		int minY = (int) Math.floor(box.getMinY());
		int minZ = (int) Math.floor(box.getMinZ());
		int maxX = (int) Math.ceil(box.getMaxX());
		int maxY = (int) Math.ceil(box.getMaxY());
		int maxZ = (int) Math.ceil(box.getMaxZ());
		synchronized (chunks) {
			Chunk chunk = null;
			BlockLocation chunkBase = null;
			for (int x = minX; x <= maxX; x++) {
				for (int z = minZ; z <= maxZ; z++) {
					for (int y = minY; y <= maxY; y++) {
						if (chunkBase == null || chunkBase.getY() - y >= 16 || chunkBase.getX() - x >= 16 || chunkBase.getZ() - z >= 16) {
							ChunkLocation chunkLocation = new ChunkLocation(new BlockLocation(x, y, z));
							chunk = getChunkAt(chunkLocation);
							if (chunk != null)
								chunkBase = chunkLocation.toBlockLocation();
							else
								continue;
						}
						if (chunk != null) {
							Block block = null;
							if (chunk.getBlocks().contains(x - chunkBase.getX(), y - chunkBase.getY(), z - chunkBase.getZ())) {
								int id = chunk.getBlocks().getBlock(x - chunkBase.getX(), y - chunkBase.getY(), z - chunkBase.getZ());
								int metadata = chunk.getBlocks().getData(x - chunkBase.getX(), y - chunkBase.getY(), z - chunkBase.getZ());
								if (id >= 0)
									block = new Block(this, chunk, chunkBase, id, metadata);
							}
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
							blocks.add(block);
						}
					}
				}
			}
		}
		return blocks;
	}

	@Override
	public boolean isInMaterial(BoundingBox box, BlockType... materials) {
		int minX = (int) Math.floor(box.getMinX());
		int minY = (int) Math.floor(box.getMinY());
		int minZ = (int) Math.floor(box.getMinZ());
		int maxX = (int) Math.ceil(box.getMaxX());
		int maxY = (int) Math.ceil(box.getMaxY());
		int maxZ = (int) Math.ceil(box.getMaxZ());
		synchronized (chunks) {
			Chunk chunk = null;
			BlockLocation chunkBase = null;
			for (int x = minX; x <= maxX; x++) {
				for (int z = minZ; z <= maxZ; z++) {
					for (int y = minY; y <= maxY; y++) {
						if (chunkBase == null || chunkBase.getY() - y >= 16 || chunkBase.getX() - x >= 16 || chunkBase.getZ() - z >= 16) {
							ChunkLocation chunkLocation = new ChunkLocation(new BlockLocation(x, y, z));
							chunk = getChunkAt(chunkLocation);
							if (chunk != null)
								chunkBase = chunkLocation.toBlockLocation();
							else
								continue;
						}
						if (chunk != null) {
							Block block = null;
							if (chunk.getBlocks().contains(x - chunkBase.getX(), y - chunkBase.getY(), z - chunkBase.getZ())) {
								int id = chunk.getBlocks().getBlock(x - chunkBase.getX(), y - chunkBase.getY(), z - chunkBase.getZ());
								int metadata = chunk.getBlocks().getData(x - chunkBase.getX(), y - chunkBase.getY(), z - chunkBase.getZ());
								if (id >= 0)
									block = new Block(this, chunk, chunkBase, id, metadata);
							}
							if (block == null)
								continue;
							boolean matches = false;
							for (BlockType material : materials) {
								if (material == block.getBlockType()) {
									matches = true;
									break;
								}
							}
							if (!matches)
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
	}
}