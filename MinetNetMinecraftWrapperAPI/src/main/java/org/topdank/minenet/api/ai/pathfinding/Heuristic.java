package org.topdank.minenet.api.ai.pathfinding;

import org.topdank.minenet.api.game.location.BlockLocation;

public interface Heuristic {
	
	public double calculateCost(BlockLocation from, BlockLocation to);
}