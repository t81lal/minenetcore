package org.topdank.minenet.api.world;

import java.util.Collection;
import java.util.Set;

import org.topdank.minenet.api.ai.pathfinding.PathSearchProvider;
import org.topdank.minenet.api.entity.Entity;
import org.topdank.minenet.api.entity.living.player.LocalPlayer;
import org.topdank.minenet.api.entity.living.player.PlayerEntity;
import org.topdank.minenet.api.entity.tile.TileEntity;
import org.topdank.minenet.api.game.BoundingBox;
import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.game.location.ChunkLocation;
import org.topdank.minenet.api.game.location.PreciseLocation;
import org.topdank.minenet.api.world.block.Block;
import org.topdank.minenet.api.world.block.BlockType;
import org.topdank.minenet.api.world.block.Chunk;
import org.topdank.minenet.api.world.settings.WorldSettings;

import eu.bibl.eventbus.EventBus;

public abstract interface World {

	public abstract PathSearchProvider getPathSearchProvider();

	public abstract WorldSettings getSettings();

	public abstract Collection<Entity> getEntities();

	public abstract Entity getEntityById(int id);

	public abstract void spawnEntity(Entity entity);

	public abstract void despawnEntity(int eId);

	public abstract void despawnEntity(Entity entity);

	public abstract PlayerEntity getPlayerByName(String name);

	public abstract PlayerEntity[] getPlayers();

	public abstract LocalPlayer getLocalPlayer();

	public abstract void watch(WatchableObject o);

	public abstract void unwatch(WatchableObject o);

	public abstract long getWorldAge();

	public abstract long getTime();

	public abstract Block getBlockAt(int x, int y, int z);

	public abstract Block getBlockAt(BlockLocation location);

	public abstract int getBlockIdAt(int x, int y, int z);

	public abstract int getBlockIdAt(BlockLocation location);

	public abstract void setBlockIdAt(int id, int x, int y, int z);

	public abstract void setBlockIdAt(int id, BlockLocation location);

	public abstract int getBlockMetadataAt(int x, int y, int z);

	public abstract int getBlockMetadataAt(BlockLocation location);

	public abstract void setBlockMetadataAt(int metadata, int x, int y, int z);

	public abstract void setBlockMetadataAt(int metadata, BlockLocation location);

	public abstract TileEntity getTileEntityAt(int x, int y, int z);

	public abstract TileEntity getTileEntityAt(BlockLocation location);

	public abstract void setTileEntityAt(TileEntity tileEntity, int x, int y, int z);

	public abstract void setTileEntityAt(TileEntity tileEntity, BlockLocation location);

	public abstract Chunk getChunkAt(int x, int y, int z);

	public abstract Chunk getChunkAt(BlockLocation loc);

	public abstract Chunk getChunkAt(PreciseLocation loc);

	public abstract Chunk getChunkAt(ChunkLocation location);

	public abstract void destroy();

	public abstract EventBus getEventBus();

	public boolean isInMaterial(BoundingBox box, BlockType... materials);

	public Set<Block> getCollidingBlocks(BoundingBox box);

	public boolean isColliding(BoundingBox box);
}