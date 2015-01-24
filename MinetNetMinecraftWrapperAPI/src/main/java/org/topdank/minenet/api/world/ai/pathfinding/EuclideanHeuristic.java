package org.topdank.minenet.api.world.ai.pathfinding;

import org.topdank.minenet.api.world.location.BlockLocation;

public class EuclideanHeuristic implements Heuristic {
	
	@Override
	public double calculateCost(BlockLocation from, BlockLocation to) {
		return from.distance(to);
	}
}