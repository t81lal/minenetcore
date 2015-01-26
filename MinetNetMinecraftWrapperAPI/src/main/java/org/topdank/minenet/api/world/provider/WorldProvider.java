package org.topdank.minenet.api.world.provider;

import org.topdank.minenet.api.provider.Provider;
import org.topdank.minenet.api.world.block.material.MaterialRegistry;
import org.topdank.minenet.api.world.block.provider.BlockProvider;

public class WorldProvider extends Provider {

	private final MaterialRegistry materialRegistry;
	private final BlockProvider blockProvider;

	public WorldProvider(MaterialRegistry materialRegistry, BlockProvider blockProvider) {
		this.materialRegistry = materialRegistry;
		this.blockProvider = blockProvider;
	}

	public MaterialRegistry getMaterialRegistry() {
		return materialRegistry;
	}

	public BlockProvider getBlockProvider() {
		return blockProvider;
	}
}