package org.topdank.minenet.api.event.entity;

import eu.bibl.eventbus.EventCancellable;

public abstract class EntityIdEvent extends EventCancellable {
	
	private final int entityId;
	
	public EntityIdEvent(int entityId) {
		this.entityId = entityId;
	}
	
	public int getEntityId() {
		return entityId;
	}
}