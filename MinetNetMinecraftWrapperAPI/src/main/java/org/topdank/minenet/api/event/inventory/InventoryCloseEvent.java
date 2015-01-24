package org.topdank.minenet.api.event.inventory;

import org.topdank.minenet.api.item.Inventory;

public class InventoryCloseEvent extends InventoryEvent {
	
	public InventoryCloseEvent(Inventory inventory) {
		super(inventory);
	}
}