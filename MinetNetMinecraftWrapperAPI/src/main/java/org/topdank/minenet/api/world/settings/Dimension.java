package org.topdank.minenet.api.world.settings;

public enum Dimension {
	
	NETHER(-1),
	OVERWORLD(0),
	END(1);
	
	private final int id;
	
	private Dimension(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public static Dimension getDimensionById(int id) {
		for (Dimension dimension : values())
			if (dimension.getId() == id)
				return dimension;
		return null;
	}
}