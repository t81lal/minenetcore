package org.topdank.minenet.lib.network.packet.codecs;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import io.netty.handler.codec.CorruptedFrameException;

import java.util.List;

import org.topdank.minenet.lib.network.Client;
import org.topdank.minenet.lib.network.io.bytebuf.ByteBufReadableInput;
import org.topdank.minenet.lib.network.io.bytebuf.ByteBufWriteableOutput;
import org.topdank.minenet.lib.network.packet.header.PacketHeader;

public class PacketSizerCodec extends ByteToMessageCodec<ByteBuf> {
	
	private Client<?> client;
	
	public PacketSizerCodec(Client<?> client) {
		this.client = client;
	}
	
	@Override
	public void encode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out) throws Exception {
		int length = in.readableBytes();
		PacketHeader header = client.getProtocol().getPacketHeader();
		out.ensureWritable(header.getLengthSize(length) + length);
		header.writeLength(new ByteBufWriteableOutput(out), length);
		out.writeBytes(in);
	}
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {
		PacketHeader header = client.getProtocol().getPacketHeader();
		int size = header.getLengthSize();
		if (size > 0) {
			buf.markReaderIndex();
			byte[] lengthBytes = new byte[size];
			for (int index = 0; index < lengthBytes.length; index++) {
				if (!buf.isReadable()) {
					buf.resetReaderIndex();
					return;
				}
				lengthBytes[index] = buf.readByte();
				if ((header.isLengthVariable() && (lengthBytes[index] >= 0)) || (index == (size - 1))) {
					int length = header.readLength(new ByteBufReadableInput(Unpooled.wrappedBuffer(lengthBytes)), buf.readableBytes());
					if (buf.readableBytes() < length) {
						buf.resetReaderIndex();
						return;
					}
					out.add(buf.readBytes(length));
					return;
				}
			}
			throw new CorruptedFrameException("Length is too long.");
		} else {
			out.add(buf.readBytes(buf.readableBytes()));
		}
	}
}