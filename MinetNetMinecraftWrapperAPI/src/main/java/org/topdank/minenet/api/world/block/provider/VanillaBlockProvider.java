package org.topdank.minenet.api.world.block.provider;

import org.topdank.minenet.api.world.block.provider.factory.VanillaBlockFactory;
import org.topdank.minenet.api.world.block.provider.registry.VanillaBlockRegistry;
import org.topdank.minenet.api.world.provider.WorldProvider;

public class VanillaBlockProvider extends BlockProvider {

	public VanillaBlockProvider(WorldProvider worldProvider) {
		super(worldProvider, new VanillaBlockFactory(worldProvider), new VanillaBlockRegistry(worldProvider));
	}
}