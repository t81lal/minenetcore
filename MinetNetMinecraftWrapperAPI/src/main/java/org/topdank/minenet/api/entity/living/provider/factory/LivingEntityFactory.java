package org.topdank.minenet.api.entity.living.provider.factory;

import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.entity.provider.EntityFactory;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public abstract class LivingEntityFactory extends EntityFactory<LivingEntity, Integer> {

	@Override
	public abstract LivingEntity create(int typeId, DefaultMinecraftWorld world, Integer id) throws IllegalArgumentException;
}