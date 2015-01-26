package org.topdank.minenet.api.world.block.provider.factory;

import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.provider.factory.Factory;
import org.topdank.minenet.api.world.World;
import org.topdank.minenet.api.world.block.Block;
import org.topdank.minenet.api.world.provider.WorldProvider;

public abstract class BlockFactory extends Factory<Block> {

	protected final WorldProvider worldProvider;

	public BlockFactory(WorldProvider worldProvider) {
		this.worldProvider = worldProvider;
	}

	public abstract Block create(World world, BlockLocation location, int id, int metadata);
}