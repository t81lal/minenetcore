package org.topdank.minenet.api.entity.living.ageable;

import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class SquidEntity extends LivingEntity {

	public SquidEntity(DefaultMinecraftWorld world, int id) {
		super(world, id, 0.95F, 0.95F);
	}
}