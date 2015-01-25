package org.topdank.minenet.api.event.entity;

import org.topdank.minenet.api.game.location.PreciseLocation;

public abstract class RotatedEntitySpawnEvent extends EntitySpawnEvent {
	
	private float yaw, pitch;
	
	public RotatedEntitySpawnEvent(int entityId, PreciseLocation location, float yaw, float pitch) {
		super(entityId, location);
		this.yaw = yaw;
		this.pitch = pitch;
	}
	
	public float getYaw() {
		return yaw;
	}
	
	public float getPitch() {
		return pitch;
	}
}