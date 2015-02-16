package org.topdank.minenet.lib.network.packet.codecs;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import io.netty.handler.codec.DecoderException;

import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.topdank.minenet.lib.network.Client;
import org.topdank.minenet.lib.network.io.bytebuf.ByteBufReadableInput;
import org.topdank.minenet.lib.network.io.bytebuf.ByteBufWriteableOutput;

public class PacketCompressionCodec extends ByteToMessageCodec<ByteBuf> {

	private static final int MAX_COMPRESSED_SIZE = 2097152;
	private Client<?> client;
	private Deflater deflater = new Deflater();
	private Inflater inflater = new Inflater();
	private byte buf[] = new byte[8192];

	public PacketCompressionCodec(Client<?> client) {
		this.client = client;
	}

	@Override
	public void encode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out) throws Exception {
		int readable = in.readableBytes();
		// System.out.println((readable < client.getCompressionThreshold() ? "Not C" : "C") + "ompressing packet, len= " + readable +
		// ", threshold= " + client.getCompressionThreshold());
		ByteBufWriteableOutput output = new ByteBufWriteableOutput(out);
		if (readable < client.getCompressionThreshold()) {
			output.writeVarInt(0);
			out.writeBytes(in);
		} else {
			byte[] bytes = new byte[readable];
			in.readBytes(bytes);
			output.writeVarInt(bytes.length);
			deflater.setInput(bytes, 0, readable);
			deflater.finish();
			while (!deflater.finished()) {
				int length = deflater.deflate(buf);
				output.writeBytes(buf, length);
			}
			deflater.reset();
		}
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {
		if (buf.readableBytes() != 0) {
			ByteBufReadableInput in = new ByteBufReadableInput(buf);
			int size = in.readVarInt();
			if (size == 0) {
				out.add(buf.readBytes(buf.readableBytes()));
			} else {
				if (size < client.getCompressionThreshold()) {
					throw new DecoderException("Badly compressed packet: size of " + size + " is below threshold of " + client.getCompressionThreshold() + ".");
				}
				if (size > MAX_COMPRESSED_SIZE) {
					throw new DecoderException("Badly compressed packet: size of " + size + " is larger than protocol maximum of " + MAX_COMPRESSED_SIZE + ".");
				}
				byte[] bytes = new byte[buf.readableBytes()];
				in.readBytes(bytes);
				inflater.setInput(bytes);
				byte[] inflated = new byte[size];
				inflater.inflate(inflated);
				out.add(Unpooled.wrappedBuffer(inflated));
				inflater.reset();
			}
		}
	}
}