package org.topdank.minenet.api.event.entity;

import java.util.Map;

import org.topdank.minenet.api.game.location.PreciseLocation;

public abstract class MetaEntitySpawnEvent extends RotatedEntitySpawnEvent {
	
	private final Map<Integer, Object> metadata;
	
	public MetaEntitySpawnEvent(int entityId, PreciseLocation location, float yaw, float pitch, Map<Integer, Object> metadata) {
		super(entityId, location, yaw, pitch);
		this.metadata = metadata;
	}
	
	public Map<Integer, Object> getMetadata() {
		return metadata;
	}
}