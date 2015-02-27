package org.topdank.minenet.lib.network.packet;

import java.io.IOException;

import org.topdank.minenet.lib.network.io.ReadableInput;
import org.topdank.minenet.lib.network.io.WriteableOutput;

public abstract class IdentifiableReadableWriteablePacket implements IdentifiablePacket, WriteablePacket, ReadablePacket {

	@Override
	public abstract void read(ReadableInput in) throws IOException;

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