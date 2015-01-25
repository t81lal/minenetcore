package org.topdank.minenet.api.entity.tile.provider.registry;

import org.topdank.minenet.api.provider.registry.NameRegistry;

public abstract class TileEntityRegistry extends NameRegistry {

	@Override
	public abstract void register();
}