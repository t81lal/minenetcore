package org.topdank.minenet.client.event;

import org.topdank.minenet.lib.network.Client;
import org.topdank.minenet.lib.network.event.packet.PacketEvent;
import org.topdank.minenet.lib.network.packet.WriteablePacket;

public class RequestPacketSendEvent extends PacketEvent<WriteablePacket> {

	public RequestPacketSendEvent(Client<?> client, WriteablePacket packet) {
		super(client, packet);
	}
}