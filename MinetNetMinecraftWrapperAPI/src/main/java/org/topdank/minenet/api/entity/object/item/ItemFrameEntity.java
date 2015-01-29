package org.topdank.minenet.api.entity.object.item;

import java.util.Map;

import org.topdank.minenet.api.entity.object.ObjectEntity;
import org.topdank.minenet.api.item.ItemStack;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class ItemFrameEntity extends ObjectEntity {

	private ItemStack item;
	private int rotation;

	public ItemFrameEntity(DefaultMinecraftWorld world, int id) {
		super(world, id, 0.375F, 0.03125F);
	}

	// 8 Slot Item
	// 9 Byte Rotation

	public ItemStack getItem() {
		return item;
	}

	public void setItem(ItemStack item) {
		this.item = item;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);

		if (metadata.containsKey(8)) {
			setItem((ItemStack) metadata.get(8));
		}

		if (metadata.containsKey(9)) {
			setRotation((byte) metadata.get(9));
		}
	}
}
