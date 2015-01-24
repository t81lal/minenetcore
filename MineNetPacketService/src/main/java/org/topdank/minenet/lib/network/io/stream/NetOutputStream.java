package org.topdank.minenet.lib.network.io.stream;

import java.io.IOException;
import java.io.OutputStream;

import org.topdank.minenet.lib.network.io.WriteableOutput;

public class NetOutputStream extends OutputStream {
	
	private WriteableOutput out;
	
	public NetOutputStream(WriteableOutput out) {
		this.out = out;
	}
	
	@Override
	public void write(int b) throws IOException {
		out.writeByte(b);
	}
}