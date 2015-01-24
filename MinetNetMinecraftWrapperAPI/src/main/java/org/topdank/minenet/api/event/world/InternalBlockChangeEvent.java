package org.topdank.minenet.api.event.world;

import org.topdank.minenet.api.world.location.BlockLocation;

import eu.bibl.eventbus.Event;

public class InternalBlockChangeEvent implements Event {
	
	private final int id, metadata, x, y, z;
	
	public InternalBlockChangeEvent(int id, int metdata, BlockLocation loc) {
		this.id = id;
		metadata = metdata;
		x = loc.getX();
		y = loc.getY();
		z = loc.getZ();
	}
	
	public InternalBlockChangeEvent(int id, int metadata, int x, int y, int z) {
		this.id = id;
		this.metadata = metadata;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getId() {
		return id;
	}
	
	public int getMetadata() {
		return metadata;
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