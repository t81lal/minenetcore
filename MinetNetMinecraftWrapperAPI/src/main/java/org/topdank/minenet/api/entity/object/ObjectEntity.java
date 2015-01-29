package org.topdank.minenet.api.entity.object;

import org.topdank.minenet.api.entity.Entity;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class ObjectEntity extends Entity {

	public ObjectEntity(DefaultMinecraftWorld world, int id, float width, float height) {
		super(world, id, width, height);
	}
}