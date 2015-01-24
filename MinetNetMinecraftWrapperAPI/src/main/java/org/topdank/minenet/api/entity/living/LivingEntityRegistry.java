package org.topdank.minenet.api.entity.living;

import org.topdank.minenet.api.registry.Registry;

public abstract class LivingEntityRegistry extends Registry<Class<? extends LivingEntity>> {

	@Override
	public abstract void register();
}