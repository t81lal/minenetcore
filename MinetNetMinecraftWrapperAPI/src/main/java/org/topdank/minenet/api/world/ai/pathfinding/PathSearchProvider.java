package org.topdank.minenet.api.world.ai.pathfinding;

import org.topdank.minenet.api.world.World;
import org.topdank.minenet.api.world.location.BlockLocation;

public interface PathSearchProvider {
	
	public PathSearch provideSearch(BlockLocation start, BlockLocation end);
	
	public Heuristic getHeuristic();
	
	public WorldPhysics getWorldPhysics();
	
	public World getWorld();
}