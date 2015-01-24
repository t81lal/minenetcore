package org.topdank.minenet.api.event.entity;

public class EntityHeadRotateEvent extends EntityIdEvent {
	
	private float headYaw;
	
	public EntityHeadRotateEvent(int entityId, float headYaw) {
		super(entityId);
		this.headYaw = headYaw;
	}
	
	public float getHeadYaw() {
		return headYaw;
	}
}