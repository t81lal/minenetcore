package org.topdank.minenet.api.entity.object.item;

import org.topdank.minenet.api.entity.object.ObjectEntity;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;
import org.topdank.minenet.api.world.block.art.Painting;

public class PaintingEntity extends ObjectEntity {

	private Painting painting;

	public PaintingEntity(DefaultMinecraftWorld world, int id, Painting p) {
		super(world, id, p.sizeX / 16, p.sizeY / 16);
		painting = p;
	}

	public Painting getPainting() {
		return painting;
	}

	public void setPainting(Painting p) {
		painting = p;
		setWidth(p.sizeX / 16);
		setHeight(p.sizeY / 16);
	}
}