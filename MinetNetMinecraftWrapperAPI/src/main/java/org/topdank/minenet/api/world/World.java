package org.topdank.minenet.api.world;

import org.topdank.minenet.api.entity.tile.TileEntity;
import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.game.location.ChunkLocation;
import org.topdank.minenet.api.world.block.Chunk;
import org.topdank.minenet.api.world.settings.WorldSettings;

public abstract interface World extends WorldPhysics {

	public abstract WorldSettings getSettings();

	public abstract long getWorldAge();

	public abstract long getTime();

	public abstract int getBlockIdAt(BlockLocation loc);

	public abstract int getBlockIdAt(int x, int y, int z);

	public abstract void setBlockIdAt(int id, BlockLocation loc);

	public abstract void setBlockIdAt(int id, int x, int y, int z);

	public abstract TileEntity getTileEntityAt(BlockLocation loc);

	public abstract void setTileEntityAt(TileEntity tileEntity, BlockLocation loc);

	public abstract Chunk getChunkAt(BlockLocation loc);

	public abstract Chunk getChunkAt(ChunkLocation location);

	public abstract void destroy();
}