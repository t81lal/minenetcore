package org.topdank.minenet.lib.network.event.packet;

import org.topdank.minenet.lib.network.Client;
import org.topdank.minenet.lib.network.packet.Packet;

import eu.bibl.eventbus.EventCancellable;

public class PacketEvent<T extends Packet> extends EventCancellable {

	protected Client<?> client;
	protected T packet;

	public PacketEvent(Client<?> client, T packet) {
		this.client = client;
		this.packet = packet;
	}

	public Client<?> getClient() {
		return client;
	}

	public T getPacket() {
		return packet;
	}
}