package org.topdank.minenet.api.event.internal;

import org.topdank.minenet.api.world.block.Chunk;

import eu.bibl.eventbus.Event;

public class InternalChunkLoadEvent implements Event {
	
	private final int x, y, z;
	private final Chunk chunk;
	private byte[] biomes;
	
	public InternalChunkLoadEvent(int x, int y, int z, Chunk chunk, byte[] biomes) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.chunk = chunk;
		this.biomes = biomes;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
	
	public Chunk getChunk() {
		return chunk;
	}
	
	public byte[] getBiomes() {
		return biomes;
	}
}