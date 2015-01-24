package org.topdank.minenet.api.entity.object.projectile.thrown;

import org.topdank.minenet.api.item.ItemStack;
import org.topdank.minenet.api.world.World;

public class PotionEntity extends ThrownEntity {

	private ItemStack damage;

	public PotionEntity(World world, int id) {
		super(world, id, 0.25F, 0.25F);
	}

	public ItemStack getDamage() {
		return damage;
	}

	public void setDamage(ItemStack damage) {
		this.damage = damage;
	}
}