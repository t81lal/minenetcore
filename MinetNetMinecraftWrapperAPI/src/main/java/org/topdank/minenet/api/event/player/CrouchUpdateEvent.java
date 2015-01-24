package org.topdank.minenet.api.event.player;

import eu.bibl.eventbus.EventCancellable;

public class CrouchUpdateEvent extends EventCancellable {
	
	private final boolean crouching;
	
	public CrouchUpdateEvent(boolean crouching) {
		this.crouching = crouching;
	}
	
	public boolean isCrouching() {
		return crouching;
	}
}