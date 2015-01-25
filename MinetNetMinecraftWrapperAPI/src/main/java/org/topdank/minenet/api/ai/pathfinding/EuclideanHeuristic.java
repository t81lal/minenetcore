package org.topdank.minenet.api.ai.pathfinding;

import org.topdank.minenet.api.game.location.BlockLocation;

public class EuclideanHeuristic implements Heuristic {
	
	@Override
	public double calculateCost(BlockLocation from, BlockLocation to) {
		return from.distance(to);
	}
}