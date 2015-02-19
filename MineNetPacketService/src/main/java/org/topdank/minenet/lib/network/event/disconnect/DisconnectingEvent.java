package org.topdank.minenet.lib.network.event.disconnect;

import org.topdank.eventbus.Event;
import org.topdank.minenet.lib.network.Client;

public class DisconnectingEvent implements Event {

	private Client<?> client;
	private String reason;

	public DisconnectingEvent(Client<?> client, String reason) {
		this.client = client;
		this.reason = reason;
	}

	public Client<?> getClient() {
		return client;
	}

	public String getReason() {
		return reason;
	}
}