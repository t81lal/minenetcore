package org.topdank.minenet.lib.auth;

public final class Profile {
	
	public String id;
	public String name;
	
	public Profile(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"name\":\"" + name + "\"}";
	}
}