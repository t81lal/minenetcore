package org.topdank.minenet.api.provider;

import org.topdank.minenet.api.entity.provider.EntityFactory;
import org.topdank.minenet.api.provider.registry.NameRegistry;

public class RegistryFactoryProvider<T, K> {

	private final NameRegistry registry;
	private final EntityFactory<T, K> factory;

	public RegistryFactoryProvider(NameRegistry registry, EntityFactory<T, K> factory) {
		this.registry = registry;
		this.factory = factory;
	}

	public NameRegistry getRegistry() {
		return registry;
	}

	public EntityFactory<T, K> getFactory() {
		return factory;
	}
}