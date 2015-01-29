package org.topdank.minenet.api.entity.living.monsters;

import java.util.Map;

import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class SkeletonEntity extends LivingEntity {

	private SkeletonType type = SkeletonType.NORMAL;

	public SkeletonEntity(DefaultMinecraftWorld world, int id) {
		super(world, id, 0.6F, 1.95F);
	}

	public SkeletonType getType() {
		return type;
	}

	public void setType(SkeletonType type) {
		this.type = type;
	}

	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);

		if (metadata.containsKey(13)) {
			setType(SkeletonType.values()[(byte) metadata.get(13)]);
		}
	}

	public enum SkeletonType {
		NORMAL,
		WITHER;
	}
}