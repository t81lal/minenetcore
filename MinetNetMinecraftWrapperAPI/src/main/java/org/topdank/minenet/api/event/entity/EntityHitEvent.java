package org.topdank.minenet.api.event.entity;

import org.topdank.minenet.api.entity.Entity;

public class EntityHitEvent extends EntityInteractEvent {
	
	public EntityHitEvent(Entity entity) {
		super(entity);
	}
}