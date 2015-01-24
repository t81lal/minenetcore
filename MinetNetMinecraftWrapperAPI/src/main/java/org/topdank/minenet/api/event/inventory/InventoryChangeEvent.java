package org.topdank.minenet.api.event.inventory;

import org.topdank.minenet.api.item.Inventory;
import org.topdank.minenet.api.item.ItemStack;

public class InventoryChangeEvent extends InventoryEvent {
	
	private final int slot;
	private final int button;
	private final short transactionId;
	private final ItemStack item;
	private final boolean shiftHeld;
	
	public InventoryChangeEvent(Inventory inventory, int slot, int button, short transactionId, ItemStack item, boolean shiftHeld) {
		super(inventory);
		this.slot = slot;
		this.button = button;
		this.transactionId = transactionId;
		this.item = item;
		this.shiftHeld = shiftHeld;
	}
	
	public int getSlot() {
		return slot;
	}
	
	public int getButton() {
		return button;
	}
	
	public short getTransactionId() {
		return transactionId;
	}
	
	public ItemStack getItem() {
		return item;
	}
	
	public boolean isShiftHeld() {
		return shiftHeld;
	}
}