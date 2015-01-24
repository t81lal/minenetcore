package org.topdank.minenet.api.event.inventory;

import org.topdank.minenet.api.item.PlayerInventory;

public class HeldItemDropEvent extends HeldItemEvent {
	
	private final boolean entireStack;
	
	public HeldItemDropEvent(PlayerInventory inventory, boolean entireStack) {
		super(inventory);
		this.entireStack = entireStack;
	}
	
	public boolean isEntireStack() {
		return entireStack;
	}
}