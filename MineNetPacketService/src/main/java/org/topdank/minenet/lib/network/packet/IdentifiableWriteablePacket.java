package org.topdank.minenet.lib.network.packet;

import java.io.IOException;

import org.topdank.minenet.lib.network.io.WriteableOutput;

public abstract class IdentifiableWriteablePacket implements IdentifiablePacket, WriteablePacket {

	@Override
	public abstract void write(WriteableOutput out) throws IOException;

	@Override
	public abstract boolean isPriorityPacket();

	@Override
	public abstract int getId();

	@Override
	public final boolean isIdentifiable() {
		return true;
	}
}