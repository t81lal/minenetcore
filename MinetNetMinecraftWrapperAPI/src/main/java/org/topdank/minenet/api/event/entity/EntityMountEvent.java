package org.topdank.minenet.api.event.entity;

public class EntityMountEvent extends EntityIdEvent {
	
	private int mountedEntityId;
	
	public EntityMountEvent(int entityId, int mountedEntityId) {
		super(entityId);
		this.mountedEntityId = mountedEntityId;
	}
	
	public int getMountedEntityId() {
		return mountedEntityId;
	}
}