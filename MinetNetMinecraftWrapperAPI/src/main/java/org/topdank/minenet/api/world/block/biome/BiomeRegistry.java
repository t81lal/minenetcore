package org.topdank.minenet.api.world.block.biome;

import org.topdank.minenet.api.provider.registry.Registry;

public abstract class BiomeRegistry extends Registry<String, Biome> {

	@Override
	protected abstract void register();

	protected void registerBiome(Biome b) {
		register(b.getName(), b);
	}
}