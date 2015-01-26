package org.topdank.minenet.api.entity.object.provider;

import org.topdank.minenet.api.entity.object.ObjectEntity;
import org.topdank.minenet.api.entity.object.provider.factory.ObjectEntityFactory;
import org.topdank.minenet.api.entity.object.provider.registry.ObjectEntityRegistry;
import org.topdank.minenet.api.provider.EntityRegistryFactoryProvider;

public class ObjectEntityProvider extends EntityRegistryFactoryProvider<ObjectEntity, Integer> {

	public ObjectEntityProvider(ObjectEntityRegistry registry, ObjectEntityFactory factory) {
		super(registry, factory);
	}
}