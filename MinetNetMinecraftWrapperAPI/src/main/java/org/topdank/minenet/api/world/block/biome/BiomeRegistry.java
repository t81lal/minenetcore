package org.topdank.minenet.api.world.block.biome;

import org.topdank.minenet.api.registry.Registry;

public abstract class BiomeRegistry extends Registry<Biome> {
	
	@Override
	protected abstract void register();
	
	protected void registerBiome(Biome b) {
		register(b, b.getId(), b.getName());
	}
}