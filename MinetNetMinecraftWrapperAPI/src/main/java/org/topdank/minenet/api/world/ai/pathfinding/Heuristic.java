package org.topdank.minenet.api.world.ai.pathfinding;

import org.topdank.minenet.api.world.location.BlockLocation;

public interface Heuristic {
	
	public double calculateCost(BlockLocation from, BlockLocation to);
}