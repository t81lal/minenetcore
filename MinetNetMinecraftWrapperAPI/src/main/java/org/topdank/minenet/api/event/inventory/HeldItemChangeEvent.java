package org.topdank.minenet.api.event.inventory;

import org.topdank.minenet.api.item.PlayerInventory;

public class HeldItemChangeEvent extends HeldItemEvent {
	
	private final int oldSlot, newSlot;
	
	public HeldItemChangeEvent(PlayerInventory inventory, int oldSlot, int newSlot) {
		super(inventory);
		this.oldSlot = oldSlot;
		this.newSlot = newSlot;
	}
	
	public int getOldSlot() {
		return oldSlot;
	}
	
	public int getNewSlot() {
		return newSlot;
	}
}