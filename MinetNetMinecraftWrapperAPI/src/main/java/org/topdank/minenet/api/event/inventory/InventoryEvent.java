package org.topdank.minenet.api.event.inventory;

import org.topdank.minenet.api.item.Inventory;

import eu.bibl.eventbus.EventCancellable;

public abstract class InventoryEvent extends EventCancellable {
	
	private final Inventory inventory;
	
	public InventoryEvent(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
}