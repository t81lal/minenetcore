package org.topdank.minenet.api.entity.living.ageable;

import org.topdank.minenet.api.world.World;

public class CowEntity extends AgeableEntity {
	
	public CowEntity(World world, int id) {
		super(world, id, 0.9F, 1.3F);
	}
}