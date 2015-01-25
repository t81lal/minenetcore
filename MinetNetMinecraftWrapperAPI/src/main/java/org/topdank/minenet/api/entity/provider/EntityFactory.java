package org.topdank.minenet.api.entity.provider;

import org.topdank.minenet.api.provider.factory.Factory;
import org.topdank.minenet.api.world.World;

public abstract class EntityFactory<T, K> extends Factory<T> {

	public abstract T create(int typeId, World world, K eData);
}