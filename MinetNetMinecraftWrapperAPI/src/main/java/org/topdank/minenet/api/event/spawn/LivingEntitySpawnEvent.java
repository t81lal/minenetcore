package org.topdank.minenet.api.event.spawn;

import org.topdank.eventbus.Event;
import org.topdank.minenet.api.entity.living.LivingEntity;

public class LivingEntitySpawnEvent implements Event {

	private LivingEntity livingEntity;

	public LivingEntitySpawnEvent(LivingEntity livingEntity) {
		this.livingEntity = livingEntity;
	}

	public LivingEntity getObjectEntity() {
		return livingEntity;
	}
}