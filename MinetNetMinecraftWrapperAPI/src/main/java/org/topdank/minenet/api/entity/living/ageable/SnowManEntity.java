package org.topdank.minenet.api.entity.living.ageable;

import java.util.Map;

import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class SnowManEntity extends LivingEntity {

	public SnowManEntity(DefaultMinecraftWorld world, int id) {
		super(world, id, 0.7F, 1.9F);
	}

	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);

		System.out.println("SnowMan got:");
		for (int i : metadata.keySet()) {
			System.out.println("snowman: " + i + " " + metadata.get(i));
		}
	}
}