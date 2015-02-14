package org.topdank.minenet.api.world;

import org.topdank.minenet.api.entity.living.player.LocalPlayer;
import org.topdank.minenet.api.entity.tile.TileEntity;
import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.game.location.ChunkLocation;
import org.topdank.minenet.api.world.block.Block;
import org.topdank.minenet.api.world.block.Chunk;
import org.topdank.minenet.api.world.block.art.PaintingRegistry;
import org.topdank.minenet.api.world.block.material.MaterialRegistry;
import org.topdank.minenet.api.world.block.provider.factory.BlockFactory;
import org.topdank.minenet.api.world.block.provider.registry.BlockRegistry;
import org.topdank.minenet.api.world.settings.WorldSettings;

public abstract interface World extends WorldPhysics {

	public abstract WorldSettings getSettings();

	public abstract long getWorldAge();

	public abstract long getTime();

	public abstract int getBlockData(BlockLocation loc);

	public abstract int getBlockData(int x, int y, int z);

	public abstract Block getBlock(BlockLocation loc);

	public abstract Block getBlock(int x, int y, int z);

	public abstract void setBlockData(int id, BlockLocation loc);

	public abstract void setBlockData(int id, int x, int y, int z);

	public abstract TileEntity getTileEntityAt(BlockLocation loc);

	public abstract void setTileEntityAt(TileEntity tileEntity, BlockLocation loc);

	public abstract Chunk getChunkAt(BlockLocation loc);

	public abstract Chunk getChunkAt(ChunkLocation location);

	public abstract void destroy();

	public abstract BlockFactory getBlockFactory();

	public abstract BlockRegistry getBlockRegistry();

	public abstract MaterialRegistry getMaterialRegistry();

	public abstract PaintingRegistry getPaintingRegistry();

	public abstract LocalPlayer getLocalPlayer();
}