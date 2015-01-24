package org.topdank.minenet.api.world.block.biome;

public class Biome {
	
	private final int id;
	private final String name;
	
	// gson can call
	private Biome(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public final int getId() {
		return id;
	}
	
	public final String getName() {
		return name;
	}
}