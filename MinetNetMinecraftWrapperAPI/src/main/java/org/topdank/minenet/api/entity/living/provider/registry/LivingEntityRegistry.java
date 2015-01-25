package org.topdank.minenet.api.entity.living.provider.registry;

import org.topdank.minenet.api.provider.registry.NameRegistry;

public abstract class LivingEntityRegistry extends NameRegistry {

	@Override
	public abstract void register();
}