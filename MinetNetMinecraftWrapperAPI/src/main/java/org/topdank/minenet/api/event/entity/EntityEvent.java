package org.topdank.minenet.api.event.entity;

import org.topdank.minenet.api.entity.Entity;

import eu.bibl.eventbus.EventCancellable;

public abstract class EntityEvent extends EventCancellable {
	
	private final Entity entity;
	
	public EntityEvent(Entity entity) {
		this.entity = entity;
	}
	
	public Entity getEntity() {
		return entity;
	}
}