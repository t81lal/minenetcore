package org.topdank.minenet.api.event.world;

import eu.bibl.eventbus.Event;

public class TimeUpdateEvent implements Event {

	private long time, age;

	public TimeUpdateEvent(long time, long age) {
		this.time = time;
		this.age = age;
	}

	public long getTime() {
		return time;
	}

	public long getAge() {
		return age;
	}
}