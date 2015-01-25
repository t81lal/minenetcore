package org.topdank.minenet.api.entity.provider;

import org.topdank.minenet.api.entity.living.provider.VanillaLivingEntityProvider;
import org.topdank.minenet.api.entity.object.provider.VanillaObjectEntityProvider;
import org.topdank.minenet.api.entity.tile.provider.VanillaTileEntityProvider;

public class VanillaEntityProvider extends EntityProvider {

	public VanillaEntityProvider() {
		super(new VanillaLivingEntityProvider(), new VanillaObjectEntityProvider(), new VanillaTileEntityProvider());
	}
}