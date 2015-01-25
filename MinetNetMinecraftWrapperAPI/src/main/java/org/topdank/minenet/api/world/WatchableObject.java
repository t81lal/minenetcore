package org.topdank.minenet.api.world;

public abstract class WatchableObject {

	private final int id;

	public WatchableObject(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public abstract void update();
}