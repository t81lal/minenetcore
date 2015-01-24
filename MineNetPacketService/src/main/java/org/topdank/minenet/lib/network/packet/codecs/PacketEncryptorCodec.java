package org.topdank.minenet.lib.network.packet.codecs;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;

import java.util.List;

import org.topdank.minenet.lib.network.Client;
import org.topdank.minenet.lib.network.packet.encryption.EncryptionProtocol;

public class PacketEncryptorCodec extends ByteToMessageCodec<ByteBuf> {
	
	private Client<?> client;
	private byte[] decryptedArray = new byte[0];
	private byte[] encryptedArray = new byte[0];
	
	public PacketEncryptorCodec(Client<?> client) {
		this.client = client;
	}
	
	@Override
	public void encode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out) throws Exception {
		EncryptionProtocol enc = client.getProtocol().getPacketEncryptionProtocol();
		if (enc != null) {
			int length = in.readableBytes();
			byte[] bytes = getBytes(in);
			int outLength = enc.getEncryptOutputSize(length);
			if (encryptedArray.length < outLength) {
				encryptedArray = new byte[outLength];
			}
			out.writeBytes(encryptedArray, 0, enc.encrypt(bytes, 0, length, encryptedArray, 0));
		} else {
			out.writeBytes(in);
		}
	}
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {
		EncryptionProtocol enc = client.getProtocol().getPacketEncryptionProtocol();
		if (enc != null) {
			int length = buf.readableBytes();
			byte[] bytes = getBytes(buf);
			ByteBuf result = ctx.alloc().heapBuffer(enc.getDecryptOutputSize(length));
			result.writerIndex(enc.decrypt(bytes, 0, length, result.array(), result.arrayOffset()));
			out.add(result);
		} else {
			out.add(buf.readBytes(buf.readableBytes()));
		}
	}
	
	private byte[] getBytes(ByteBuf buf) {
		int length = buf.readableBytes();
		if (decryptedArray.length < length) {
			decryptedArray = new byte[length];
		}
		buf.readBytes(decryptedArray, 0, length);
		return decryptedArray;
	}
}