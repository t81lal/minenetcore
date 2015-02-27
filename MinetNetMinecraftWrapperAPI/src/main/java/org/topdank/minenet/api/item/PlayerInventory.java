package org.topdank.minenet.api.item;

import org.topdank.minenet.api.BotContext;
import org.topdank.minenet.api.entity.living.player.LocalPlayer;

public class PlayerInventory implements Inventory {

	private final BotContext context;
	private final LocalPlayer player;
	private final ItemStack[] armor = new ItemStack[4];
	private final ItemStack[] items = new ItemStack[36];
	private final ItemStack[] crafting = new ItemStack[4];
	private ItemStack craftingOutput = null;
	private ItemStack selectedItem = null;
	private int delay = 0, currentHeldSlot = 0;

	//	private short transactionId = 0;

	public PlayerInventory(BotContext context, LocalPlayer player) {
		this.context = context;
		this.player = player;
		context.getEventBus().register(this);
	}

	// @EventTarget(priority = EventPriority.HIGH)
	// public synchronized void onWindowClose(WindowCloseEvent event) {
	// if (event.getWindowId() == 0) {
	// selectedItem = null;
	// Arrays.fill(crafting, null);
	// }
	// }
	//
	// @EventTarget(priority = EventPriority.HIGH)
	// public void onChangeHeldItem(ChangeHeldItemEvent event) {
	// setCurrentHeldSlot(event.getSlot());
	// }
	//
	// @EventTarget(priority = EventPriority.HIGH)
	// public synchronized void onWindowTransactionComplete(WindowTransactionCompleteEvent event) {
	// if (!event.isAccepted())
	// selectedItem = null;
	// }

	@Override
	public synchronized int getSize() {
		return items.length + armor.length;
	}

	@Override
	public synchronized ItemStack getItemAt(int slot) {
		return slot < 36 ? items[slot] : slot < 40 ? armor[slot - 36] : slot < 44 ? crafting[slot - 40] : slot == 44 ? craftingOutput : null;
	}

	public synchronized ItemStack getArmorAt(int slot) {
		return armor[slot];
	}

	public synchronized ItemStack getCraftingAt(int slot) {
		return crafting[slot];
	}

	public synchronized ItemStack getCraftingOutput() {
		return craftingOutput;
	}

	@Override
	public synchronized void setItemAt(int slot, ItemStack item) {
		if (slot < 36)
			items[slot] = item;
		else if (slot < 40)
			armor[slot - 36] = item;
		else if (slot < 44)
			crafting[slot - 40] = item;
		else if (slot == 44)
			craftingOutput = item;
	}

	public synchronized void setArmorAt(int slot, ItemStack item) {
		armor[slot] = item;
	}

	public synchronized void setCraftingAt(int slot, ItemStack item) {
		crafting[slot] = item;
	}

	public synchronized void setCraftingOutput(ItemStack item) {
		craftingOutput = item;
	}

	@Override
	public void setItemFromServerAt(int serverSlot, ItemStack item) {
		setItemAt(getClientSlotFor(serverSlot), item);
	}

	public synchronized void selectItemAt(int slot) {
		selectItemAt(slot, true);
	}

	@Override
	public synchronized void selectItemAt(int slot, boolean leftClick) {
		// TODO Fix: not entirely accurate, not yet sure why
		ItemStack item = getItemAt(slot);
		armorSlotCheck: while (selectedItem != null) {
			int id = selectedItem.getId();
			boolean valid = false;
			switch (slot) {
				case 36:
					valid = (id == 86) || (id == 298) || (id == 302) || (id == 306) || (id == 310) || (id == 314);
					break;
				case 37:
					valid = (id == 299) || (id == 303) || (id == 307) || (id == 311) || (id == 315);
					break;
				case 38:
					valid = (id == 300) || (id == 304) || (id == 308) || (id == 312) || (id == 316);
					break;
				case 39:
					valid = (id == 301) || (id == 305) || (id == 309) || (id == 313) || (id == 317);
					break;
				default:
					break armorSlotCheck;
			}
			if (valid) {
				setItemAt(slot, selectedItem);
				selectedItem = null;
			}
			// context.getEventBus().dispatch(new InventoryChangeEvent(this, getServerSlotFor(slot), leftClick ? 0 : 1, transactionId++,
			// item, false));
			delay();
			return;
		}
		if ((slot == 44) && (item != null)) {
			for (int i = 0; i < 4; i++) {
				ItemStack craft = crafting[i];
				if (craft != null) {
					if (craft.getStackSize() > 1)
						craft.setStackSize(craft.getStackSize() - 1);
					else
						crafting[i] = null;
				}
			}
		}
		if (leftClick) {
			if (selectedItem != null) {
				if (item != null) {
					if (item.getId() == selectedItem.getId()) {
						if (item.getStackSize() != 64) {
							int newStackSize = item.getStackSize() + selectedItem.getStackSize();
							item.setStackSize(Math.min(64, newStackSize));
							newStackSize -= 64;
							if (newStackSize > 0)
								selectedItem.setStackSize(newStackSize);
							else
								selectedItem = null;
						}
					} else {
						setItemAt(slot, selectedItem);
						selectedItem = item;
					}
				} else {
					setItemAt(slot, selectedItem);
					selectedItem = null;
				}
			} else if (item != null) {
				setItemAt(slot, null);
				selectedItem = item;
			}
		} else {
			if (selectedItem != null) {
				if (item != null) {
					if (item.getId() == selectedItem.getId()) {
						if (item.getStackSize() != 64) {
							item.setStackSize(item.getStackSize() + 1);
							if (selectedItem.getStackSize() > 1)
								selectedItem.setStackSize(selectedItem.getStackSize() - 1);
							else
								selectedItem = null;
						}
					} else {
						setItemAt(slot, selectedItem);
						selectedItem = item;
					}
				} else {
					ItemStack newItem = selectedItem.clone();
					newItem.setStackSize(1);
					setItemAt(slot, newItem);
					if (selectedItem.getStackSize() > 1)
						selectedItem.setStackSize(selectedItem.getStackSize() - 1);
					else
						selectedItem = null;
				}
			} else if (item != null) {
				if (item.getStackSize() == 1) {
					selectedItem = item;
					setItemAt(slot, null);
				} else {
					int stackSize = item.getStackSize();
					item.setStackSize(stackSize / 2);
					ItemStack newSelectedItem = item.clone();
					newSelectedItem.setStackSize(newSelectedItem.getStackSize() + (stackSize % 2));
					selectedItem = newSelectedItem;
				}
			}
		}
		// context.getEventBus().dispatch(new InventoryChangeEvent(this, getServerSlotFor(slot), leftClick ? 0 : 1, transactionId++, item,
		// false));
		delay();
	}

	public synchronized void selectArmorAt(int slot) {
		selectItemAt(slot + 36, true);
	}

	public synchronized void selectCraftingAt(int slot) {
		selectCraftingAt(slot, true);
	}

	public synchronized void selectCraftingAt(int slot, boolean leftClick) {
		selectItemAt(slot + 40, leftClick);
	}

	public void selectCraftingOutput() {
		selectItemAt(44, true);
	}

	@Override
	public synchronized void selectItemAtWithShift(int slot) {
		// TODO Fix: not entirely accurate, not yet sure why either
		delay();
		ItemStack item = getItemAt(slot);
		int rangeStart, rangeEnd;
		if (item == null)
			return;
		if (slot < items.length) {
			rangeStart = items.length;
			rangeEnd = items.length + items.length;
		} else {
			rangeStart = 0;
			rangeEnd = items.length;
		}
		boolean slotFound = false;
		for (int i = rangeStart; i < rangeEnd; i++) {
			if ((slot < items.length ? items[i - items.length] : items[i]) == null) {
				if (slot < items.length) {
					items[slot] = null;
					items[i - items.length] = item;
				} else {
					items[i] = item;
					items[slot - items.length] = null;
				}
				slotFound = true;
				break;
			}
		}
		if (!slotFound)
			return;
		// context.getEventBus().dispatch(new InventoryChangeEvent(this, slot, 0, (short) 0, item, true));
	}

	public synchronized boolean contains(int... ids) {
		boolean air = false;
		for (int id : ids)
			if (id == 0)
				air = true;
		for (int slot = 0; slot < 36; slot++)
			if (items[slot] != null) {
				for (int id : ids)
					if (items[slot].getId() == id)
						return true;
			} else if (air)
				return true;
		return false;
	}

	public synchronized int getCount(int id) {
		int amount = 0;
		for (int slot = 0; slot < 36; slot++)
			if ((items[slot] != null) && (items[slot].getId() == id))
				amount += items[slot].getStackSize();
		return amount;
	}

	public synchronized ItemStack getFirstItem(int id) {
		for (int slot = 0; slot < 36; slot++)
			if ((items[slot] != null) && (items[slot].getId() == id))
				return items[slot];
		return null;
	}

	public synchronized int getFirstSlot(int id) {
		for (int slot = 0; slot < 36; slot++)
			if (items[slot] != null ? items[slot].getId() == id : id == 0)
				return slot;
		return -1;
	}

	@Override
	public synchronized ItemStack getSelectedItem() {
		return selectedItem;
	}

	@Override
	public synchronized void dropSelectedItem() {
		selectedItem = null;
		// context.getEventBus().dispatch(new InventoryChangeEvent(this, -999, 0, transactionId++, null, true));
		delay();
	}

	@Override
	public synchronized void close() {
		// context.getEventBus().dispatch(new InventoryCloseEvent(this));
	}

	public synchronized int getCurrentHeldSlot() {
		return currentHeldSlot;
	}

	public synchronized ItemStack getCurrentHeldItem() {
		return items[currentHeldSlot];
	}

	public synchronized void dropCurrentHeldItem() {
		dropItem(false);
	}

	public synchronized void dropCurrentHeldItemStack() {
		dropItem(true);
	}

	private void dropItem(boolean stack) {
		// context.getEventBus().dispatch(new HeldItemDropEvent(this, stack));
	}

	public void setCurrentHeldSlot(int currentHeldSlot) {
		if ((currentHeldSlot < 0) || (currentHeldSlot >= 9))
			throw new IllegalArgumentException();
		//		int oldSlot = this.currentHeldSlot;
		this.currentHeldSlot = currentHeldSlot;
		// context.getEventBus().dispatch(new HeldItemChangeEvent(this, oldSlot, currentHeldSlot));
	}

	public LocalPlayer getPlayer() {
		return player;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	private void delay() {
		if (delay > 0) {
			try {
				Thread.sleep(delay);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
	}

	private int getClientSlotFor(int serverSlot) {
		if (serverSlot > 35)
			return serverSlot - 36;
		if (serverSlot == 0)
			return 44;
		if (serverSlot < 5)
			return serverSlot + 39;
		if (serverSlot < 9)
			return serverSlot + 31;
		return serverSlot;
	}

	//	private int getServerSlotFor(int clientSlot) {
	//		if (clientSlot < 9)
	//			return 36 + clientSlot;
	//		else if (clientSlot > 43)
	//			return clientSlot - 44;
	//		else if (clientSlot > 39)
	//			return clientSlot - 39;
	//		else if (clientSlot > 35)
	//			return clientSlot - 31;
	//		return clientSlot;
	//	}

	@Override
	public int getWindowId() {
		return 0;
	}

	public void destroy() {
		context.getEventBus().unregister(this);
	}
}