package org.topdank.minenet.api.entity.object.provider.factory;

import org.topdank.minenet.api.entity.object.ObjectEntity;
import org.topdank.minenet.api.entity.provider.EntityFactory;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public abstract class ObjectEntityFactory extends EntityFactory<ObjectEntity, Integer> {

	@Override
	public abstract ObjectEntity create(int typeId, DefaultMinecraftWorld world, Integer id) throws IllegalArgumentException;
}