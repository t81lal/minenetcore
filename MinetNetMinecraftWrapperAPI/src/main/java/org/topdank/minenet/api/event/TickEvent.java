package org.topdank.minenet.api.event;

import org.topdank.eventbus.Event;

public final class TickEvent implements Event {
	
	public static final Event INSTANCE = new TickEvent();
	
	private TickEvent() {
	}
}