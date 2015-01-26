package org.topdank.minenet.api.entity.tile.provider;

import org.topdank.minenet.api.entity.tile.TileEntity;
import org.topdank.minenet.api.entity.tile.provider.factory.TileEntityFactory;
import org.topdank.minenet.api.entity.tile.provider.registry.TileEntityRegistry;
import org.topdank.minenet.api.nbt.tag.builtin.CompoundTag;
import org.topdank.minenet.api.provider.EntityRegistryFactoryProvider;

public class TileEntityProvider extends EntityRegistryFactoryProvider<TileEntity, CompoundTag> {

	public TileEntityProvider(TileEntityRegistry registry, TileEntityFactory factory) {
		super(registry, factory);
	}
}