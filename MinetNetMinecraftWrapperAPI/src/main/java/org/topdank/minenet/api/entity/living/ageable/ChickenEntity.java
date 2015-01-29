package org.topdank.minenet.api.entity.living.ageable;

import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class ChickenEntity extends AgeableEntity {

	public ChickenEntity(DefaultMinecraftWorld world, int id) {
		super(world, id, 0.4F, 0.7F);
	}
}