package org.topdank.minenet.api.entity.living.monsters;

import java.util.Map;

import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class BlazeEntity extends LivingEntity {

	private boolean isFlaming;

	public BlazeEntity(DefaultMinecraftWorld world, int id) {
		super(world, id, 0.6F, 1.8F);
	}

	public boolean isFlaming() {
		return isFlaming;
	}

	public void setFlaming(boolean isFlaming) {
		this.isFlaming = isFlaming;
	}

	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);

		if (metadata.containsKey(16)) {
			setFlaming((byte) metadata.get(16) != 0);
		}
	}
}