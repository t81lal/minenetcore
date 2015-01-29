package org.topdank.minenet.api.entity.living.monsters;

import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class CaveSpiderEntity extends SpiderEntity {

	public CaveSpiderEntity(DefaultMinecraftWorld world, int id) {
		super(world, id, 0.7F, 0.5F);
	}
}