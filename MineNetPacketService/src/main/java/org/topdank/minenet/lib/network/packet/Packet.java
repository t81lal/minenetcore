package org.topdank.minenet.lib.network.packet;

public abstract interface Packet {
	
	public abstract boolean isPriorityPacket();
	
	public abstract int getId();
}