package org.topdank.minenet.api.entity.living.ageable;

import org.topdank.minenet.api.world.World;

public class ChickenEntity extends AgeableEntity {
	
	public ChickenEntity(World world, int id) {
		super(world, id, 0.4F, 0.7F);
	}
}