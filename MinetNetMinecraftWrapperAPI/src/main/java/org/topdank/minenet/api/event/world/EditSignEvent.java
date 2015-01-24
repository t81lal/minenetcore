package org.topdank.minenet.api.event.world;

import org.topdank.minenet.api.world.location.BlockLocation;

import eu.bibl.eventbus.EventCancellable;

public class EditSignEvent extends EventCancellable {
	
	private final BlockLocation location;
	
	public EditSignEvent(BlockLocation location) {
		this.location = location;
	}
	
	public BlockLocation getLocation() {
		return location;
	}
}