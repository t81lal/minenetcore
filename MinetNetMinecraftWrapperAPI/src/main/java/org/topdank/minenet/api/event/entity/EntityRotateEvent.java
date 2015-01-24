package org.topdank.minenet.api.event.entity;

public class EntityRotateEvent extends EntityIdEvent {
	
	private float yaw, pitch;
	
	public EntityRotateEvent(int entityId, float yaw, float pitch) {
		super(entityId);
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