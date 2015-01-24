package org.topdank.minenet.api.event.entity;

import org.topdank.minenet.api.entity.Entity;

public abstract class EntityInteractEvent extends EntityEvent {
	
	public EntityInteractEvent(Entity entity) {
		super(entity);
	}
}