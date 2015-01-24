package org.topdank.minenet.lib.network.event.disconnect;

import org.topdank.minenet.lib.network.Client;

import eu.bibl.eventbus.Event;

public class TimeoutEvent implements Event {

	private Client<?> client;
	private TimeoutType type;

	public TimeoutEvent(Client<?> client, TimeoutType type) {
		this.client = client;
		this.type = type;
	}

	public Client<?> getClient() {
		return client;
	}

	public TimeoutType getType() {
		return type;
	}
}