package org.topdank.minenet.api.item;

public enum ToolMaterial {
	
	WOOD(2),
	STONE(4),
	IRON(6),
	GOLD(12),
	DIAMOND(8);
	
	private final int effectiveness;
	
	private ToolMaterial(int effectiveness, int... ids) {
		this.effectiveness = effectiveness;
	}
	
	public int getEffectiveness() {
		return effectiveness;
	}
}