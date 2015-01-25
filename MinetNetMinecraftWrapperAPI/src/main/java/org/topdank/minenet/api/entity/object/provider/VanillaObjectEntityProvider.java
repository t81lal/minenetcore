package org.topdank.minenet.api.entity.object.provider;

import org.topdank.minenet.api.entity.object.provider.factory.VanillaObjectEntityFactory;
import org.topdank.minenet.api.entity.object.provider.registry.VanillaObjectEntityRegistry;

public class VanillaObjectEntityProvider extends ObjectEntityProvider {

	public VanillaObjectEntityProvider() {
		super(new VanillaObjectEntityRegistry(), new VanillaObjectEntityFactory());
	}
}