package org.topdank.minenet.api.event.entity;

import java.util.Map;

public class EntityMetadataUpdateEvent extends EntityIdEvent {
	
	private Map<Integer, Object> metadata;
	
	public EntityMetadataUpdateEvent(int entityId, Map<Integer, Object> metadata) {
		super(entityId);
		this.metadata = metadata;
	}
	
	public Map<Integer, Object> getMetadata() {
		return metadata;
	}
}