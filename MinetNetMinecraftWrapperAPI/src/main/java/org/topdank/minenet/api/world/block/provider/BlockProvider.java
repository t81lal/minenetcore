package org.topdank.minenet.api.world.block.provider;

import org.topdank.minenet.api.provider.Provider;
import org.topdank.minenet.api.world.block.provider.factory.BlockFactory;
import org.topdank.minenet.api.world.block.provider.registry.BlockRegistry;

public class BlockProvider extends Provider {

	private final BlockFactory blockFactory;
	private final BlockRegistry blockRegistry;

	public BlockProvider(BlockFactory blockFactory, BlockRegistry blockRegistry) {
		this.blockFactory = blockFactory;
		this.blockRegistry = blockRegistry;
	}

	public BlockFactory getBlockFactory() {
		return blockFactory;
	}

	public BlockRegistry getBlockRegistry() {
		return blockRegistry;
	}
}