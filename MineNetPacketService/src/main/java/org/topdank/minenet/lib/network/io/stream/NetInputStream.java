package org.topdank.minenet.lib.network.io.stream;

import java.io.IOException;
import java.io.InputStream;

import org.topdank.minenet.lib.network.io.ReadableInput;

public class NetInputStream extends InputStream {
	
	private ReadableInput in;
	private boolean readFirst;
	private byte firstByte;
	
	public NetInputStream(ReadableInput in, byte firstByte) {
		this.in = in;
		this.firstByte = firstByte;
	}
	
	@Override
	public int read() throws IOException {
		if (!readFirst) {
			readFirst = true;
			return firstByte;
		} else {
			return in.readUnsignedByte();
		}
	}
}