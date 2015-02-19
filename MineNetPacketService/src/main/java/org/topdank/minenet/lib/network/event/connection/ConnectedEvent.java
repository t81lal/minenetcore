package org.topdank.minenet.lib.network.event.connection;

import org.topdank.eventbus.Event;
import org.topdank.minenet.lib.network.Client;

public class ConnectedEvent implements Event {

	private Client<?> client;

	public ConnectedEvent(Client<?> client) {
		this.client = client;
	}

	public Client<?> getClient() {
		return client;
	}
}