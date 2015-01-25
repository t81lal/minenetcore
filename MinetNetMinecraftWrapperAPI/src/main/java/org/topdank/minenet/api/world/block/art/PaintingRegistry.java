package org.topdank.minenet.api.world.block.art;

import org.topdank.minenet.api.provider.registry.Registry;

public abstract class PaintingRegistry extends Registry<String, Painting> {

	@Override
	public abstract void register();

	public void register(Painting p) {
		register(p.title, p);
	}
}