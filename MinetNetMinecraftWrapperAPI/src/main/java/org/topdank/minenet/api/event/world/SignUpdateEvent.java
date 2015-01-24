package org.topdank.minenet.api.event.world;

import org.topdank.minenet.api.world.location.BlockLocation;

import eu.bibl.eventbus.Event;

public class SignUpdateEvent implements Event {
	
	private final BlockLocation loc;
	private final String[] text;
	
	public SignUpdateEvent(BlockLocation loc, String[] text) {
		this.loc = loc;
		this.text = text;
	}
	
	public BlockLocation getLocation() {
		return loc;
	}
	
	public String[] getText() {
		return text.clone();
	}
}