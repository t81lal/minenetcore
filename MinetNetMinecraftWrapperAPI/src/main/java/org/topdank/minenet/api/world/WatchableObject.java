package org.topdank.minenet.api.world;

public abstract class WatchableObject {
	
	protected final int id;
	
	public WatchableObject(int id) {
		this.id = id;
	}
	
	public abstract void update();
	
	public int getId() {
		return id;
	}
}