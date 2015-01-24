package org.topdank.minenet.api.entity.object.item;

import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.entity.object.ObjectEntity;
import org.topdank.minenet.api.world.World;

public class PrimedTNTEntity extends ObjectEntity {

	private int fuse;
	private LivingEntity placer;

	public PrimedTNTEntity(World world, int id) {
		super(world, id, 0.98F, 0.98F);
	}

	public int getFuse() {
		return fuse;
	}

	public void setFuse(int fuse) {
		this.fuse = fuse;
	}

	public LivingEntity getPlacer() {
		return placer;
	}

	public void setPlacer(LivingEntity placer) {
		this.placer = placer;
	}
}