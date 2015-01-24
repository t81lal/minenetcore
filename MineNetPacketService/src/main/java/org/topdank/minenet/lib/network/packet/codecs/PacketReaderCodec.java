package org.topdank.minenet.lib.network.packet.codecs;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;

import java.util.List;

import org.topdank.minenet.lib.network.Client;
import org.topdank.minenet.lib.network.Protocol;
import org.topdank.minenet.lib.network.event.packet.PacketReceivedEvent;
import org.topdank.minenet.lib.network.io.ReadableInput;
import org.topdank.minenet.lib.network.io.bytebuf.ByteBufReadableInput;
import org.topdank.minenet.lib.network.packet.ReadablePacket;

public class PacketReaderCodec extends ByteToMessageCodec<ReadablePacket> {

	private Client<?> client;

	public PacketReaderCodec(Client<?> client) {
		this.client = client;
	}

	@Override
	protected void encode(ChannelHandlerContext ctx, ReadablePacket msg, ByteBuf out) throws Exception {
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {
		Protocol protocol = client.getProtocol();
		if (protocol.packetWait()) {
			long start = System.currentTimeMillis();
			while (protocol.packetWait()) {
				Thread.sleep(10);// cpu cycles :(

				long time = System.currentTimeMillis() - start;
				if (time > 10000) {
					protocol.setWait(false);
					break;
				}
			}
		}

		int initial = buf.readerIndex();
		ReadableInput in = new ByteBufReadableInput(buf);
		int id = protocol.getPacketHeader().readPacketId(in);
		if (id == -1) {
			buf.readerIndex(initial);
			return;
		}
		ReadablePacket packet = protocol.createIncomingPacket(id);
		packet.read(in);
		if (packet.isPriorityPacket()) {
			protocol.onPacketReceived(new PacketReceivedEvent(client, packet));
		}
		out.add(packet);
	}
}