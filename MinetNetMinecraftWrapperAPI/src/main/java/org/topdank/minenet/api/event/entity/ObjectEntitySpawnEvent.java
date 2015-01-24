package org.topdank.minenet.api.event.entity;

import org.topdank.minenet.api.world.location.PreciseLocation;

public class ObjectEntitySpawnEvent extends RotatedEntitySpawnEvent {
	
	private int type;
	private int throwerId;
	private double speedX, speedY, speedZ;
	
	public ObjectEntitySpawnEvent(int entityId, PreciseLocation location, float yaw, float pitch, int type, int throwerId, double speedX, double speedY, double speedZ) {
		super(entityId, location, yaw, pitch);
		this.type = type;
		this.throwerId = throwerId;
		this.speedX = speedX;
		this.speedY = speedY;
		this.speedZ = speedZ;
	}
	
	public int getEntityType() {
		return type;
	}
	
	public int getThrowerId() {
		return throwerId;
	}
	
	public double getSpeedX() {
		return speedX;
	}
	
	public double getSpeedY() {
		return speedY;
	}
	
	public double getSpeedZ() {
		return speedZ;
	}
}