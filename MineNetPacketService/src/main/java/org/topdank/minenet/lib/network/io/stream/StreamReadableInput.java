package org.topdank.minenet.lib.network.io.stream;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.topdank.minenet.lib.network.io.ReadableInput;

/**
 * A ReadableInput implementation using an InputStream as a backend.
 * @author Bibl
 */
public class StreamReadableInput implements ReadableInput {
	
	private InputStream in;
	
	public StreamReadableInput(InputStream in) {
		this.in = in;
	}
	
	@Override
	public boolean readBoolean() throws IOException {
		return readByte() == 1;
	}
	
	@Override
	public byte readByte() throws IOException {
		return (byte) readUnsignedByte();
	}
	
	@Override
	public int readUnsignedByte() throws IOException {
		int b = in.read();
		if (b < 0) {
			throw new EOFException();
		}
		return b;
	}
	
	@Override
	public short readShort() throws IOException {
		return (short) readUnsignedShort();
	}
	
	@Override
	public int readUnsignedShort() throws IOException {
		int ch1 = readUnsignedByte();
		int ch2 = readUnsignedByte();
		return (ch1 << 8) + (ch2 << 0);
	}
	
	@Override
	public char readChar() throws IOException {
		int ch1 = readUnsignedByte();
		int ch2 = readUnsignedByte();
		return (char) ((ch1 << 8) + (ch2 << 0));
	}
	
	@Override
	public int readInt() throws IOException {
		int ch1 = readUnsignedByte();
		int ch2 = readUnsignedByte();
		int ch3 = readUnsignedByte();
		int ch4 = readUnsignedByte();
		return (ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0);
	}
	
	@Override
	public int readVarInt() throws IOException {
		int value = 0;
		int size = 0;
		int b;
		while (((b = readByte()) & 0x80) == 0x80) {
			value |= (b & 0x7F) << (size++ * 7);
			if (size > 5) {
				throw new IOException("VarInt too long (length must be <= 5)");
			}
		}
		return value | ((b & 0x7F) << (size * 7));
	}
	
	@Override
	public long readLong() throws IOException {
		byte read[] = this.readBytes(8);
		return ((long) read[0] << 56) + ((long) (read[1] & 255) << 48) + ((long) (read[2] & 255) << 40) + ((long) (read[3] & 255) << 32) + ((long) (read[4] & 255) << 24) + ((read[5] & 255) << 16) + ((read[6] & 255) << 8)
				+ ((read[7] & 255) << 0);
	}
	
	@Override
	public long readVarLong() throws IOException {
		int value = 0;
		int size = 0;
		int b;
		while (((b = readByte()) & 0x80) == 0x80) {
			value |= (b & 0x7F) << (size++ * 7);
			if (size > 10) {
				throw new IOException("VarLong too long (length must be <= 10)");
			}
		}
		return value | ((b & 0x7F) << (size * 7));
	}
	
	@Override
	public float readFloat() throws IOException {
		return Float.intBitsToFloat(readInt());
	}
	
	@Override
	public double readDouble() throws IOException {
		return Double.longBitsToDouble(readLong());
	}
	
	@Override
	public byte[] readPrefixedBytes() throws IOException {
		short length = readShort();
		return this.readBytes(length);
	}
	
	@Override
	public byte[] readBytes(int length) throws IOException {
		if (length < 0) {
			throw new IllegalArgumentException("Array cannot have length less than 0.");
		}
		byte b[] = new byte[length];
		int n = 0;
		while (n < length) {
			int count = in.read(b, n, length - n);
			if (count < 0) {
				throw new EOFException();
			}
			n += count;
		}
		return b;
	}
	
	@Override
	public int readBytes(byte[] b) throws IOException {
		return in.read(b);
	}
	
	@Override
	public int readBytes(byte[] b, int offset, int length) throws IOException {
		return in.read(b, offset, length);
	}
	
	@Override
	public String readString() throws IOException {
		int length = readVarInt();
		byte bytes[] = this.readBytes(length);
		return new String(bytes, "UTF-8");
	}
	
	@Override
	public UUID readUUID() throws IOException {
		return new UUID(readLong(), readLong());
	}
	
	@Override
	public int available() throws IOException {
		return in.available();
	}
	
	@Override
	public void close() throws IOException {
		in.close();
	}
	
	public InputStream getUnderlyingStream() {
		return in;
	}
}