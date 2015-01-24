package org.topdank.minenet.api.event.inventory;

import eu.bibl.eventbus.EventCancellable;

public class ChangeHeldItemEvent extends EventCancellable {
	
	private final int slot;
	
	public ChangeHeldItemEvent(int slot) {
		this.slot = slot;
	}
	
	public int getSlot() {
		return slot;
	}
}