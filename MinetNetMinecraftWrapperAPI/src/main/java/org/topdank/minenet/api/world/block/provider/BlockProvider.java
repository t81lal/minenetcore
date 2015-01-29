package org.topdank.minenet.api.world.block.provider;

import org.topdank.minenet.api.provider.Provider;
import org.topdank.minenet.api.world.block.provider.factory.BlockFactory;
import org.topdank.minenet.api.world.block.provider.registry.BlockRegistry;
import org.topdank.minenet.api.world.provider.WorldProvider;

public class BlockProvider extends Provider {

	protected final WorldProvider worldProvider;
	private final BlockFactory blockFactory;
	private final BlockRegistry blockRegistry;

	public BlockProvider(WorldProvider worldProvider, BlockFactory blockFactory, BlockRegistry blockRegistry) {
		this.worldProvider = worldProvider;
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