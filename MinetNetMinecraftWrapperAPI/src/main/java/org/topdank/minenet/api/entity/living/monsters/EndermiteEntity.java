package org.topdank.minenet.api.entity.living.monsters;

import java.util.Map;

import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.world.World;

public class EndermiteEntity extends LivingEntity {
	
	public EndermiteEntity(World world, int id) {
		super(world, id, 0.4F, 0.3F);
	}
	
	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);
		
		System.out.println("Endermite got:");
		for (int i : metadata.keySet()) {
			System.out.println("endermite: " + i + " " + metadata.get(i));
		}
	}
}