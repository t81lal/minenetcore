package org.topdank.minenet.api.entity.object.projectile;

import org.topdank.minenet.api.world.World;

public class FireBallEntity extends ProjectileEntity {

	public FireBallEntity(World world, int id) {
		super(world, id, 1F, 1F);
	}

	public FireBallEntity(World world, int id, float width, float height) {
		super(world, id, width, height);
	}
}