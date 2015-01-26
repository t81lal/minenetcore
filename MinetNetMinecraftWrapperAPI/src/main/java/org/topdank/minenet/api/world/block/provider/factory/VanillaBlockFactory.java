package org.topdank.minenet.api.world.block.provider.factory;

import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.world.World;
import org.topdank.minenet.api.world.block.Block;
import org.topdank.minenet.api.world.provider.WorldProvider;

public class VanillaBlockFactory extends BlockFactory {

	public VanillaBlockFactory(WorldProvider worldProvider) {
		super(worldProvider);
	}

	@Override
	public Block create(World world, BlockLocation location, int id, int metadata) {
		return null;
	}
}