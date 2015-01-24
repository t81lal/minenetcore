package org.topdank.minenet.api.event.entity;

import org.topdank.minenet.api.entity.Entity;

public class EntityUseEvent extends EntityInteractEvent {
	
	public EntityUseEvent(Entity entity) {
		super(entity);
	}
}