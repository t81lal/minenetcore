package org.topdank.minenet.api.entity.object.projectile;

import java.util.Map;

import org.topdank.minenet.api.world.World;

public class ArrowEntity extends ProjectileEntity {

	private boolean isCrit;

	public ArrowEntity(World world, int id) {
		super(world, id, 0.5F, 0.5F);
	}

	public boolean isCrit() {
		return isCrit;
	}

	public void setCrit(boolean isCrit) {
		this.isCrit = isCrit;
	}

	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);

		if (metadata.containsKey(16)) {
			setCrit((byte) metadata.get(16) != 0);
		}
	}
}