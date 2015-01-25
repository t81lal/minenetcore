package org.topdank.minenet.api.event.entity;

import java.util.Map;

import org.topdank.minenet.api.game.location.PreciseLocation;

public class LivingEntitySpawnEvent extends MetaEntitySpawnEvent {
	
	private int type;
	private float headYaw;
	private double velocityX, velocityY, velocityZ;
	
	public LivingEntitySpawnEvent(int entityId, PreciseLocation location, float yaw, float pitch, Map<Integer, Object> metadata, int type, float headYaw, double velocityX, double velocityY, double velocityZ) {
		super(entityId, location, yaw, pitch, metadata);
		this.type = type;
		this.headYaw = headYaw;
		this.velocityX = velocityX;
		this.velocityY = velocityY;
		this.velocityZ = velocityZ;
	}
	
	public int getEntityType() {
		return type;
	}
	
	public float getHeadYaw() {
		return headYaw;
	}
	
	public double getVelocityX() {
		return velocityX;
	}
	
	public double getVelocityY() {
		return velocityY;
	}
	
	public double getVelocityZ() {
		return velocityZ;
	}
}