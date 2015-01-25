package org.topdank.minenet.api.entity.provider;

import org.topdank.minenet.api.entity.living.provider.LivingEntityProvider;
import org.topdank.minenet.api.entity.object.provider.ObjectEntityProvider;
import org.topdank.minenet.api.entity.tile.provider.TileEntityProvider;
import org.topdank.minenet.api.provider.Provider;

public class EntityProvider extends Provider {

	private final LivingEntityProvider livingEntityProvider;
	private final ObjectEntityProvider objectEntityProvider;
	private final TileEntityProvider tileEntityProvider;

	public EntityProvider(LivingEntityProvider livingEntityProvider, ObjectEntityProvider objectEntityProvider,
			TileEntityProvider tileEntityProvider) {
		this.livingEntityProvider = livingEntityProvider;
		this.objectEntityProvider = objectEntityProvider;
		this.tileEntityProvider = tileEntityProvider;
	}

	public LivingEntityProvider getLivingEntityProvider() {
		return livingEntityProvider;
	}

	public ObjectEntityProvider getObjectEntityProvider() {
		return objectEntityProvider;
	}

	public TileEntityProvider getTileEntityProvider() {
		return tileEntityProvider;
	}
}