package org.topdank.minenet.api.entity.object.projectile;

import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class FireBallEntity extends ProjectileEntity {

	public FireBallEntity(DefaultMinecraftWorld world, int id) {
		super(world, id, 1F, 1F);
	}

	public FireBallEntity(DefaultMinecraftWorld world, int id, float width, float height) {
		super(world, id, width, height);
	}
}