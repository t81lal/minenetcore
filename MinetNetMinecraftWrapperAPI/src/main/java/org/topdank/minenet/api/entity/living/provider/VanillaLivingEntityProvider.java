package org.topdank.minenet.api.entity.living.provider;

import org.topdank.minenet.api.entity.living.provider.factory.VanillaLivingEntityFactory;
import org.topdank.minenet.api.entity.living.provider.registry.VanillaLivingEntityRegistry;

public class VanillaLivingEntityProvider extends LivingEntityProvider {

	public VanillaLivingEntityProvider() {
		super(new VanillaLivingEntityRegistry(), new VanillaLivingEntityFactory());
	}
}