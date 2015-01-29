package org.topdank.minenet.api.entity.object.projectile;

import java.util.Map;

import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class WitherSkullEntity extends FireBallEntity {

	private boolean isInvulnerable;

	public WitherSkullEntity(DefaultMinecraftWorld world, int id) {
		super(world, id, 0.3125F, 0.3125F);
	}

	public boolean isInvulnerable() {
		return isInvulnerable;
	}

	public void setInvulnerable(boolean isInvulnerable) {
		this.isInvulnerable = isInvulnerable;
	}

	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);
		if (metadata.containsKey(10)) {
			isInvulnerable = ((byte) metadata.get(10)) != 0;
		}
	}
}