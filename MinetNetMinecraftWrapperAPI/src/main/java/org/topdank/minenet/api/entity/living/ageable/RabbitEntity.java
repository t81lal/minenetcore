package org.topdank.minenet.api.entity.living.ageable;

import java.util.Map;

import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class RabbitEntity extends AgeableEntity {

	// TODO: find out rabbit types
	private int type;

	public RabbitEntity(DefaultMinecraftWorld world, int id) {
		super(world, id, 0.6F, 0.7F);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);

		if (metadata.containsKey(18)) {
			setType((byte) metadata.get(18));
		}
	}
}