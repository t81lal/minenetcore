package org.topdank.minenet.api.entity.object.projectile.thrown;

import org.topdank.minenet.api.entity.Entity;
import org.topdank.minenet.api.entity.object.projectile.ProjectileEntity;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class ThrownEntity extends ProjectileEntity {

	protected Entity thrower;

	public ThrownEntity(DefaultMinecraftWorld world, int id, float width, float height) {
		super(world, id, width, height);
	}

	public Entity getThrower() {
		return thrower;
	}

	public void setThrower(Entity thrower) {
		this.thrower = thrower;
	}
}