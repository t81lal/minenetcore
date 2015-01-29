package org.topdank.minenet.api.entity.living.monsters;

import java.util.Map;

import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class GuardianEntity extends LivingEntity {

	public GuardianEntity(DefaultMinecraftWorld world, int id) {
		super(world, id, 0.85F, 0.85F);
	}

	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);

		System.out.println("Guardian got:");
		for (int i : metadata.keySet()) {
			System.out.println("guardian: " + i + " " + metadata.get(i));
		}
	}
}