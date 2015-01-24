package org.topdank.minenet.api.entity.object.projectile.thrown;

import org.topdank.minenet.api.world.World;

public class SnowBallEntity extends ThrownEntity {

	public SnowBallEntity(World world, int id) {
		super(world, id, 0.25F, 0.25F);
	}
}