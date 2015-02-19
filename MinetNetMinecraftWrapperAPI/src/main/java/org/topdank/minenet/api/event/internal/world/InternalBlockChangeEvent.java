package org.topdank.minenet.api.event.internal.world;

import org.topdank.eventbus.Event;
import org.topdank.minenet.api.game.location.BlockLocation;

public class InternalBlockChangeEvent implements Event {

	private final int data, x, y, z;

	public InternalBlockChangeEvent(int data, BlockLocation loc) {
		this.data = data;
		x = loc.getX();
		y = loc.getY();
		z = loc.getZ();
	}

	public InternalBlockChangeEvent(int data, int x, int y, int z) {
		this.data = data;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getData() {
		return data;
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
}