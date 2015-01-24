package org.topdank.minenet.api.world.ai.pathfinding;

import org.topdank.minenet.api.world.location.BlockLocation;

public class ManhattanHeuristic implements Heuristic {
	
	@Override
	public double calculateCost(BlockLocation from, BlockLocation to) {
		return Math.abs(from.getX() - to.getX()) + Math.abs(from.getY() - to.getY()) + Math.abs(from.getZ() - to.getZ());
	}
}