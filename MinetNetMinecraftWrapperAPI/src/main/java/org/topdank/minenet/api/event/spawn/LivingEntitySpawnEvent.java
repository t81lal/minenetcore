package org.topdank.minenet.api.event.spawn;

import org.topdank.minenet.api.entity.living.LivingEntity;

import eu.bibl.eventbus.Event;

public class LivingEntitySpawnEvent implements Event {

	private LivingEntity livingEntity;

	public LivingEntitySpawnEvent(LivingEntity livingEntity) {
		this.livingEntity = livingEntity;
	}

	public LivingEntity getObjectEntity() {
		return livingEntity;
	}
}