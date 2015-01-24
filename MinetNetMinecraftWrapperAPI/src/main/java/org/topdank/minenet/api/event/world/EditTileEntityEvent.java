package org.topdank.minenet.api.event.world;

import eu.bibl.eventbus.Event;

public class EditTileEntityEvent implements Event {
	
	private int x, y, z;
	
	public EditTileEntityEvent(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
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