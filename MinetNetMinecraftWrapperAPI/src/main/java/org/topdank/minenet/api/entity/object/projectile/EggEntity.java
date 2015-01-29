package org.topdank.minenet.api.entity.object.projectile;

import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class EggEntity extends ProjectileEntity {

	public EggEntity(DefaultMinecraftWorld world, int id) {
		super(world, id, 0.25F, 0.25F);
	}
}