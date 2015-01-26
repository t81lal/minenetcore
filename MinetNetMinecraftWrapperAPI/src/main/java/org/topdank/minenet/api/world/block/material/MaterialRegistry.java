package org.topdank.minenet.api.world.block.material;

import org.topdank.minenet.api.provider.registry.Registry;
import org.topdank.minenet.api.world.block.material.Material.Builder;

public abstract class MaterialRegistry extends Registry<String, Material> {

	@Override
	protected abstract void register();

	protected Builder builder(String name) {
		return new Material.Builder().name(name);
	}

	protected void register(Material m) {
		register(m.getName(), m);
	}
}