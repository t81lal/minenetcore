package org.topdank.minenet.api.event.player;

import eu.bibl.eventbus.EventCancellable;

public class SprintUpdateEvent extends EventCancellable {
	
	private final boolean sprinting;
	
	public SprintUpdateEvent(boolean sprinting) {
		this.sprinting = sprinting;
	}
	
	public boolean isSprinting() {
		return sprinting;
	}
}