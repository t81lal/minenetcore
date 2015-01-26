package org.topdank.minenet.api.provider;

import org.topdank.minenet.api.entity.provider.EntityFactory;
import org.topdank.minenet.api.provider.registry.NameRegistry;

public class EntityRegistryFactoryProvider<T, K> extends RegistryFactoryProvider<T, EntityFactory<T, K>> {

	public EntityRegistryFactoryProvider(NameRegistry registry, EntityFactory<T, K> factory) {
		super(registry, factory);
	}
}