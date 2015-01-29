package org.topdank.minenet.api.entity.living.monsters;

import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class MagmaCubeEntity extends SlimeEntity {

	public MagmaCubeEntity(DefaultMinecraftWorld world, int id) {
		super(world, id);
	}

	public MagmaCubeEntity(DefaultMinecraftWorld world, int id, float size) {
		super(world, id, size);
	}
}