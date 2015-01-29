package org.topdank.minenet.api.entity.object.projectile;

import org.topdank.minenet.api.entity.object.ObjectEntity;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class ProjectileEntity extends ObjectEntity {

	public ProjectileEntity(DefaultMinecraftWorld world, int id, float width, float height) {
		super(world, id, width, height);
	}
}