package org.topdank.minenet.api.event.world;

import org.topdank.minenet.api.world.World;
import org.topdank.minenet.api.world.block.Chunk;

import eu.bibl.eventbus.EventCancellable;

public class ChunkLoadEvent extends EventCancellable {
	
	private World world;
	private Chunk chunk;
	
	public ChunkLoadEvent(World world, Chunk chunk) {
		this.world = world;
		this.chunk = chunk;
	}
	
	public World getWorld() {
		return world;
	}
	
	public Chunk getChunk() {
		return chunk;
	}
}