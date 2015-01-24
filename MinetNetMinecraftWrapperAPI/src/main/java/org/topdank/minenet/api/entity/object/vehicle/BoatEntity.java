package org.topdank.minenet.api.entity.object.vehicle;

import java.util.Map;

import org.topdank.minenet.api.world.World;

public class BoatEntity extends VehicleEntity {
	
	private int lastHitTime;
	private int forwardDirection;
	
	public BoatEntity(World world, int id) {
		super(world, id, 1.5F, 0.6F);
	}
	
	public int getLastHitTime() {
		return lastHitTime;
	}
	
	public void setLastHitTime(int lastHitTime) {
		this.lastHitTime = lastHitTime;
	}
	
	public int getForwardDirection() {
		return forwardDirection;
	}
	
	public void setForwardDirection(int forwardDirection) {
		this.forwardDirection = forwardDirection;
	}
	
	// 17 Int Time Since Hit
	// 18 Int Forward Direction
	// 19 Float Damage Taken
	
	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);
		
		if (metadata.containsKey(17)) {
			setLastHitTime((int) metadata.get(17));
		}
		
		if (metadata.containsKey(18)) {
			setForwardDirection((int) metadata.get(18));
		}
		
		if (metadata.containsKey(19)) {
			setDamageTaken((float) metadata.get(19));
		}
	}
}