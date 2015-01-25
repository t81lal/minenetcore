package org.topdank.minenet.api.event.entity;

import org.topdank.minenet.api.game.location.PreciseLocation;

public abstract class EntitySpawnEvent extends EntityIdEvent {
	
	private PreciseLocation location;
	
	public EntitySpawnEvent(int entityId, PreciseLocation location) {
		super(entityId);
		this.location = location;
	}
	
	public PreciseLocation getLocation() {
		return location;
	}
}