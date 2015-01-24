package org.topdank.minenet.api.entity.object.item;

import java.util.Map;

import org.topdank.minenet.api.entity.object.ObjectEntity;
import org.topdank.minenet.api.item.ItemStack;
import org.topdank.minenet.api.world.World;

public class ItemEntity extends ObjectEntity {
	
	private ItemStack item;
	
	public ItemEntity(World world, int id) {
		super(world, id, 0.25F, 0.25F);
	}
	
	public ItemStack getItem() {
		return item;
	}
	
	public void setItem(ItemStack item) {
		this.item = item;
	}
	
	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);
		
		if (metadata.containsKey(10)) {
			setItem((ItemStack) metadata.get(10));
		}
	}
}