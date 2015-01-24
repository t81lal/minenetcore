package org.topdank.minenet.api.event.entity;

import org.topdank.minenet.api.world.location.PreciseLocation;

public class PaintingSpawnEvent extends EntitySpawnEvent {
	
	private String title;
	private int direction;
	
	public PaintingSpawnEvent(int entityId, PreciseLocation location, String title, int direction) {
		super(entityId, location);
		this.title = title;
		this.direction = direction;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getDirection() {
		return direction;
	}
}