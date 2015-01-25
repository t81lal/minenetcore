package org.topdank.minenet.api.entity.tile.provider;

import org.topdank.minenet.api.entity.tile.provider.factory.VanillaTileEntityFactory;
import org.topdank.minenet.api.entity.tile.provider.registry.VanillaTileEntityRegistry;

public class VanillaTileEntityProvider extends TileEntityProvider {

	public VanillaTileEntityProvider() {
		super(new VanillaTileEntityRegistry(), new VanillaTileEntityFactory());
	}
}