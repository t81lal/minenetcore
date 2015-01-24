package org.topdank.minenet.api.entity.object.projectile;

import java.util.Map;

import org.topdank.minenet.api.item.ItemStack;
import org.topdank.minenet.api.world.World;

public class FireworkEntity extends ProjectileEntity {

	private ItemStack data;

	public FireworkEntity(World world, int id) {
		super(world, id, 0.25F, 0.25F);
	}

	public ItemStack getData() {
		return data;
	}

	public void setData(ItemStack data) {
		this.data = data;
	}

	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);

		if (metadata.containsKey(8)) {
			setData((ItemStack) metadata.get(8));
		}
	}
}