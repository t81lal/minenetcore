package org.topdank.minenet.api.registry;

public final class IdentifiableObject implements Identifiable {
	
	private final int id;
	private final String name;
	private final Object o;
	
	public IdentifiableObject(int id, String name, Object o) {
		this.id = id;
		this.name = name;
		this.o = o;
	}
	
	public Object getObject() {
		return o;
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public String getName() {
		return name;
	}
}