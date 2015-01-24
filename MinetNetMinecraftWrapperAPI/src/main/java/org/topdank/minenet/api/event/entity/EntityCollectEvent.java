package org.topdank.minenet.api.event.entity;

public class EntityCollectEvent extends EntityIdEvent {
	
	private final int collectedId, collectorId;
	
	public EntityCollectEvent(int collectedId, int collectorId) {
		super(collectedId);
		this.collectedId = collectedId;
		this.collectorId = collectorId;
	}
	
	public int getCollectedId() {
		return collectedId;
	}
	
	public int getCollectorId() {
		return collectorId;
	}
}