package org.topdank.minenet.api.event.inventory;

import org.topdank.minenet.api.item.PlayerInventory;

public abstract class HeldItemEvent extends InventoryEvent {
	
	public HeldItemEvent(PlayerInventory inventory) {
		super(inventory);
	}
	
	@Override
	public PlayerInventory getInventory() {
		return (PlayerInventory) super.getInventory();
	}
}