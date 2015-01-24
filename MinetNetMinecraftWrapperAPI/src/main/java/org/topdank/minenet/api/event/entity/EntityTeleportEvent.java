package org.topdank.minenet.api.event.entity;


public class EntityTeleportEvent extends EntityIdEvent {
	
	private double x, y, z;
	private float yaw, pitch;
	private boolean setOnGround;
	private boolean onGround;
	
	public EntityTeleportEvent(int entityId, double x, double y, double z, float yaw, float pitch, boolean onGround) {
		super(entityId);
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
		setOnGround = true;
	}
	
	public EntityTeleportEvent(int entityId, double x, double y, double z, float yaw, float pitch) {
		super(entityId);
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
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
	
	public float getYaw() {
		return yaw;
	}
	
	public float getPitch() {
		return pitch;
	}
	
	public boolean setOnGround() {
		return setOnGround;
	}
	
	public boolean isOnGround() {
		return onGround;
	}
}