package org.topdank.minenet.api.entity.object;

import org.topdank.minenet.api.entity.Entity;
import org.topdank.minenet.api.registry.Registry;

public abstract class ObjectEntityRegistry extends Registry<Class<? extends Entity>> {

	@Override
	public abstract void register();
}