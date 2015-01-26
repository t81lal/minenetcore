package org.topdank.minenet.api.entity.living.provider;

import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.entity.living.provider.factory.LivingEntityFactory;
import org.topdank.minenet.api.entity.living.provider.registry.LivingEntityRegistry;
import org.topdank.minenet.api.provider.EntityRegistryFactoryProvider;

public class LivingEntityProvider extends EntityRegistryFactoryProvider<LivingEntity, Integer> {

	public LivingEntityProvider(LivingEntityRegistry registry, LivingEntityFactory factory) {
		super(registry, factory);
	}
}