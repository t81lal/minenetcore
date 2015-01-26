package org.topdank.minenet.api.provider;

import org.topdank.minenet.api.provider.factory.Factory;
import org.topdank.minenet.api.provider.registry.NameRegistry;

public class RegistryFactoryProvider<T, F extends Factory<T>> extends Provider {

	private final NameRegistry registry;
	private final F factory;

	public RegistryFactoryProvider(NameRegistry registry, F factory) {
		this.registry = registry;
		this.factory = factory;
	}

	public NameRegistry getRegistry() {
		return registry;
	}

	public F getFactory() {
		return factory;
	}
}