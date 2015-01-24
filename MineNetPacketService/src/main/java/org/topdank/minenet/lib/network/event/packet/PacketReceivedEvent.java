package org.topdank.minenet.lib.network.event.packet;

import org.topdank.minenet.lib.network.Client;
import org.topdank.minenet.lib.network.packet.ReadablePacket;

public class PacketReceivedEvent extends PacketEvent<ReadablePacket> {

	public PacketReceivedEvent(Client<?> client, ReadablePacket packet) {
		super(client, packet);
	}
}