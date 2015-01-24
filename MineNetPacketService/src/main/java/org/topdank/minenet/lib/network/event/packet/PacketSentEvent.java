package org.topdank.minenet.lib.network.event.packet;

import org.topdank.minenet.lib.network.Client;
import org.topdank.minenet.lib.network.packet.WriteablePacket;

public class PacketSentEvent extends PacketEvent<WriteablePacket> {

	public PacketSentEvent(Client<?> client, WriteablePacket packet) {
		super(client, packet);
	}
}