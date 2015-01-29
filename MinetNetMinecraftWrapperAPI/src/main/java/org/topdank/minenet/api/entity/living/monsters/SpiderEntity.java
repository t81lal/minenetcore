package org.topdank.minenet.api.entity.living.monsters;

import java.util.Map;

import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class SpiderEntity extends LivingEntity {

	private boolean isClimbing;

	public SpiderEntity(DefaultMinecraftWorld world, int id, float width, float height) {
		super(world, id, width, height);
	}

	public SpiderEntity(DefaultMinecraftWorld world, int id) {
		super(world, id, 1.4F, 0.9F);
	}

	public boolean isClimbing() {
		return isClimbing;
	}

	public void setClimbing(boolean isClimbing) {
		this.isClimbing = isClimbing;
	}

	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);

		if (metadata.containsKey(16)) {
			setClimbing((byte) metadata.get(16) != 0);
		}
	}
}