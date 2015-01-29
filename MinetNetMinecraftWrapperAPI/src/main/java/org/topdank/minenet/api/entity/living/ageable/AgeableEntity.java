package org.topdank.minenet.api.entity.living.ageable;

import java.util.Map;

import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class AgeableEntity extends LivingEntity {

	protected int growthTimer;

	public AgeableEntity(DefaultMinecraftWorld world, int id, float width, float height) {
		super(world, id, width, height);
	}

	public int getGrowthTimer() {
		return growthTimer;
	}

	public void setGrowthTimer(int growthTimer) {
		this.growthTimer = growthTimer;
	}

	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);

		if (metadata.containsKey(12)) {
			setGrowthTimer((byte) metadata.get(12));
		}
	}
}