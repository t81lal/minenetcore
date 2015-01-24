package org.topdank.minenet.api.item;

import org.topdank.minenet.api.nbt.tag.builtin.CompoundTag;

public interface ItemStack extends Cloneable {
	
	public int getId();
	
	public int getStackSize();
	
	public void setStackSize(int stackSize);
	
	public int getDamage();
	
	public void setDamage(int damage);
	
	public CompoundTag getStackTagCompound();
	
	public void setStackTagCompound(CompoundTag compound);
	
	public ItemStack clone();
}