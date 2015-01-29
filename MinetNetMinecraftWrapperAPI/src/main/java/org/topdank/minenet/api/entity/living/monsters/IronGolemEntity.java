package org.topdank.minenet.api.entity.living.monsters;

import java.util.Map;

import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class IronGolemEntity extends LivingEntity {

	private boolean isPlayerCreated;

	public IronGolemEntity(DefaultMinecraftWorld world, int id) {
		super(world, id, 1.4F, 2.9F);
	}

	public boolean isPlayerCreated() {
		return isPlayerCreated;
	}

	public void setPlayerCreated(boolean isPlayerCreated) {
		this.isPlayerCreated = isPlayerCreated;
	}

	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);

		if (metadata.containsKey(16)) {
			setPlayerCreated((byte) metadata.get(16) != 0);
		}
	}
}