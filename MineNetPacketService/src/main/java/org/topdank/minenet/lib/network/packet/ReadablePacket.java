package org.topdank.minenet.lib.network.packet;

import java.io.IOException;

import org.topdank.minenet.lib.network.io.ReadableInput;

public abstract interface ReadablePacket extends Packet {
	
	public abstract void read(ReadableInput in) throws IOException;
	
	@Override
	public abstract boolean isPriorityPacket();
	
	@Override
	public abstract int getId();
}