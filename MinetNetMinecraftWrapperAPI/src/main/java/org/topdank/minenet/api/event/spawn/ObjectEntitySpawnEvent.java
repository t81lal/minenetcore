package org.topdank.minenet.api.event.spawn;

import org.topdank.eventbus.Event;
import org.topdank.minenet.api.entity.object.ObjectEntity;

public class ObjectEntitySpawnEvent implements Event {

	private ObjectEntity objectEntity;

	public ObjectEntitySpawnEvent(ObjectEntity objectEntity) {
		this.objectEntity = objectEntity;
	}

	public ObjectEntity getObjectEntity() {
		return objectEntity;
	}
}