package org.topdank.minenet.api.game.location;

public enum Direction {

	UP(0, 1, 0),
	DOWN(0, -1, 0),
	NORTH(1, 0, 0),
	SOUTH(-1, 0, 0),
	EAST(0, 0, 1),
	WEST(0, 0, -1),

	NORTH_EAST(1, 0, 1),
	NORTH_WEST(1, 0, -1),
	SOUTH_EAST(-1, 0, 1),
	SOUTH_WEST(-1, 0, -1),

	UP_NORTH(1, 1, 0),
	UP_SOUTH(-1, 1, 0),
	UP_EAST(0, 1, 1),
	UP_WEST(0, 1, -1),
	UP_NORTH_EAST(1, 1, 1),
	UP_NORTH_WEST(1, 1, -1),
	UP_SOUTH_EAST(-1, 1, 1),
	UP_SOUTH_WEST(-1, 1, -1),

	DOWN_NORTH(1, -1, 0),
	DOWN_SOUTH(-1, -1, 0),
	DOWN_EAST(0, -1, 1),
	DOWN_WEST(0, -1, -1),
	DOWN_NORTH_EAST(1, -1, 1),
	DOWN_NORTH_WEST(1, -1, -1),
	DOWN_SOUTH_EAST(-1, -1, 1),
	DOWN_SOUTH_WEST(-1, -1, -1);

	private final int xOffset, yOffset, zOffset;

	private Direction(int xOffset, int yOffset, int zOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.zOffset = zOffset;
	}

	public int getOffsetX() {
		return xOffset;
	}

	public int getOffsetY() {
		return yOffset;
	}

	public int getOffsetZ() {
		return zOffset;
	}
}