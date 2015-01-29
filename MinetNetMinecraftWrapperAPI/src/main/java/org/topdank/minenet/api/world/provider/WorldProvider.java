package org.topdank.minenet.api.world.provider;

import org.topdank.minenet.api.provider.Provider;
import org.topdank.minenet.api.world.block.art.PaintingRegistry;
import org.topdank.minenet.api.world.block.material.MaterialRegistry;
import org.topdank.minenet.api.world.block.provider.BlockProvider;

public class WorldProvider extends Provider {

	protected BlockProvider blockProvider;
	private final MaterialRegistry materialRegistry;
	private final PaintingRegistry paintingRegistry;

	public WorldProvider(BlockProvider blockProvider, MaterialRegistry materialRegistry, PaintingRegistry paintingRegistry) {
		this.materialRegistry = materialRegistry;
		this.blockProvider = blockProvider;
		this.paintingRegistry = paintingRegistry;
	}

	public WorldProvider(MaterialRegistry materialRegistry, PaintingRegistry paintingRegistry) {
		this.materialRegistry = materialRegistry;
		this.paintingRegistry = paintingRegistry;
	}

	public BlockProvider getBlockProvider() {
		return blockProvider;
	}

	public MaterialRegistry getMaterialRegistry() {
		return materialRegistry;
	}

	public PaintingRegistry getPaintingRegistry() {
		return paintingRegistry;
	}
}