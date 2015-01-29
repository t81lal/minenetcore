package org.topdank.minenet.api.entity.object.vehicle;

import org.topdank.minenet.api.entity.object.ObjectEntity;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class VehicleEntity extends ObjectEntity {

	protected float damageTaken;

	public VehicleEntity(DefaultMinecraftWorld world, int id, float width, float height) {
		super(world, id, width, height);
	}

	public float getDamageTaken() {
		return damageTaken;
	}

	public void setDamageTaken(float damageTaken) {
		this.damageTaken = damageTaken;
	}
}