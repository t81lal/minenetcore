package org.topdank.minenet.api.entity.tile;

import org.topdank.minenet.api.registry.Registry;

public abstract class TileEntityRegistry extends Registry<Class<? extends TileEntity>> {

	@Override
	public abstract void register();
}