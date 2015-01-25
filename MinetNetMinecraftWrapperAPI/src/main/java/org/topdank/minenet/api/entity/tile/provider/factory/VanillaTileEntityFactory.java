package org.topdank.minenet.api.entity.tile.provider.factory;

import org.topdank.minenet.api.entity.tile.TileEntity;
import org.topdank.minenet.api.nbt.tag.builtin.CompoundTag;
import org.topdank.minenet.api.world.World;

public class VanillaTileEntityFactory extends TileEntityFactory {

	@Override
	public TileEntity create(int typeId, World world, CompoundTag tag) throws IllegalArgumentException {
		return null;
	}
}