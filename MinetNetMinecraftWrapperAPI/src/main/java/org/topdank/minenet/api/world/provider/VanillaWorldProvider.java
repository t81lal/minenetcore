package org.topdank.minenet.api.world.provider;

import org.topdank.minenet.api.world.block.art.VanillaPaintingRegistry;
import org.topdank.minenet.api.world.block.material.VanillaMaterialRegistry;
import org.topdank.minenet.api.world.block.provider.VanillaBlockProvider;

public class VanillaWorldProvider extends WorldProvider {

	public VanillaWorldProvider() {
		super(new VanillaMaterialRegistry(), new VanillaPaintingRegistry());
		blockProvider = new VanillaBlockProvider(this);
		blockProvider.getBlockRegistry().register();
	}
}