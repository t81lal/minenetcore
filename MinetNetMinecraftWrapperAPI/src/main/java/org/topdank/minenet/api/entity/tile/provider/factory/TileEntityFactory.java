package org.topdank.minenet.api.entity.tile.provider.factory;

import org.topdank.minenet.api.entity.provider.EntityFactory;
import org.topdank.minenet.api.entity.tile.TileEntity;
import org.topdank.minenet.api.nbt.tag.builtin.CompoundTag;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public abstract class TileEntityFactory extends EntityFactory<TileEntity, CompoundTag> {

	@Override
	public abstract TileEntity create(int typeId, DefaultMinecraftWorld world, CompoundTag tag) throws IllegalArgumentException;
}