package org.topdank.minenet.api.event.world;

import org.topdank.minenet.api.nbt.tag.builtin.CompoundTag;

import eu.bibl.eventbus.Event;

public class TileEntityUpdateEvent implements Event {

	private final int x;
	private final int y;
	private final int z;
	private final int type;
	private final CompoundTag compound;

	public TileEntityUpdateEvent(int x, int y, int z, int type, CompoundTag compound) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.type = type;
		this.compound = compound;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public int getType() {
		return type;
	}

	public CompoundTag getCompound() {
		return compound;
	}

	@Override
	public String toString() {
		return "TileEntityUpdateEvent [x=" + x + ", y=" + y + ", z=" + z + ", type=" + type + ", compound=" + compound + "]";
	}
}