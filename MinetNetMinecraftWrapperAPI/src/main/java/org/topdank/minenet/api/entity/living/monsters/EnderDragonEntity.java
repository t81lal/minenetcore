package org.topdank.minenet.api.entity.living.monsters;

import java.util.Map;

import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class EnderDragonEntity extends LivingEntity {

	public EnderDragonEntity(DefaultMinecraftWorld world, int id) {
		super(world, id, 16F, 8F);
	}

	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);

		// System.out.println("EnderDragon got:");
		// for (int i : metadata.keySet()) {
		// System.out.println("enderdragon: " + i + " " + metadata.get(i));
		// }
	}
}