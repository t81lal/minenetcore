package org.topdank.minenet.lib.network.packet;

import java.io.IOException;

import org.topdank.minenet.lib.network.io.ReadableInput;

public abstract class IdentifiableReadablePacket implements IdentifiablePacket, ReadablePacket {

	@Override
	public abstract void read(ReadableInput in) throws IOException;

	@Override
	public abstract boolean isPriorityPacket();

	@Override
	public final boolean isIdentifiable() {
		return true;
	}
}