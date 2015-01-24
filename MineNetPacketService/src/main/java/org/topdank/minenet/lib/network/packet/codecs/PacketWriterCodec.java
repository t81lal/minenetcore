package org.topdank.minenet.lib.network.packet.codecs;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;

import java.util.List;

import org.topdank.minenet.lib.network.Client;
import org.topdank.minenet.lib.network.Protocol;
import org.topdank.minenet.lib.network.io.WriteableOutput;
import org.topdank.minenet.lib.network.io.bytebuf.ByteBufWriteableOutput;
import org.topdank.minenet.lib.network.packet.WriteablePacket;

public class PacketWriterCodec extends ByteToMessageCodec<WriteablePacket> {
	
	private Client<?> client;
	
	public PacketWriterCodec(Client<?> client) {
		this.client = client;
	}
	
	@Override
	protected void encode(ChannelHandlerContext ctx, WriteablePacket packet, ByteBuf buf) throws Exception {
		WriteableOutput out = new ByteBufWriteableOutput(buf);
		Protocol protocol = client.getProtocol();
		protocol.getPacketHeader().writePacketId(out, protocol.getOutgoingId(packet.getClass()));
		packet.write(out);
	}
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {
	}
}