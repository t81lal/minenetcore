package org.topdank.minenet.lib.network.packet;

public abstract interface IdentifiablePacket extends Packet {

	@Override
	public abstract boolean isPriorityPacket();

	public abstract int getId();

	@Override
	public abstract boolean isIdentifiable();
}