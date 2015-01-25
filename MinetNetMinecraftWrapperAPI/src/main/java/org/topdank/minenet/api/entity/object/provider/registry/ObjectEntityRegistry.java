package org.topdank.minenet.api.entity.object.provider.registry;

import org.topdank.minenet.api.provider.registry.NameRegistry;

public abstract class ObjectEntityRegistry extends NameRegistry {

	@Override
	public abstract void register();
}