package org.topdank.minenet.api.world.ai.pathfinding.astar;

import org.topdank.minenet.api.world.World;
import org.topdank.minenet.api.world.ai.pathfinding.Heuristic;
import org.topdank.minenet.api.world.ai.pathfinding.PathSearchProvider;
import org.topdank.minenet.api.world.ai.pathfinding.WorldPhysics;
import org.topdank.minenet.api.world.location.BlockLocation;

public class AStarPathSearchProvider implements PathSearchProvider {
	
	private final Heuristic heuristic;
	private final WorldPhysics worldPhysics;
	private final World world;
	
	public AStarPathSearchProvider(Heuristic heuristic, WorldPhysics worldPhysics) {
		this.heuristic = heuristic;
		this.worldPhysics = worldPhysics;
		world = worldPhysics.getWorld();
	}
	
	@Override
	public AStarPathSearch provideSearch(BlockLocation start, BlockLocation end) {
		return new AStarPathSearch(this, start, end);
	}
	
	@Override
	public Heuristic getHeuristic() {
		return heuristic;
	}
	
	@Override
	public WorldPhysics getWorldPhysics() {
		return worldPhysics;
	}
	
	@Override
	public World getWorld() {
		return world;
	}
}