package org.topdank.minenet.api.event.world;

import eu.bibl.eventbus.EventCancellable;

public class TimeUpdateEvent extends EventCancellable {
	
	private final long time, worldAge;
	
	public TimeUpdateEvent(long time, long worldAge) {
		this.time = time;
		this.worldAge = worldAge;
	}
	
	public long getTime() {
		return time;
	}
	
	public long getWorldAge() {
		return worldAge;
	}
}