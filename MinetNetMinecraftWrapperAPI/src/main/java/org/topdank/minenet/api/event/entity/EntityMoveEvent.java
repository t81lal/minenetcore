package org.topdank.minenet.api.event.entity;

import org.topdank.minenet.api.game.location.PreciseLocation;

public class EntityMoveEvent extends EntityIdEvent {
	
	private double x, y, z;
	
	public EntityMoveEvent(int entityId, PreciseLocation loc) {
		super(entityId);
		x = loc.getX();
		y = loc.getY();
		z = loc.getZ();
	}
	
	public EntityMoveEvent(int eID, double x, double y, double z) {
		super(eID);
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
}