package org.topdank.minenet.api.entity.object.projectile.thrown;

import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class EnderpearlEntity extends ThrownEntity {

	public EnderpearlEntity(DefaultMinecraftWorld world, int id) {
		super(world, id, 0.25F, 0.25F);
	}
}