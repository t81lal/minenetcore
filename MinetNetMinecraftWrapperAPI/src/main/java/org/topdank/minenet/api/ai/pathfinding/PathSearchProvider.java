package org.topdank.minenet.api.ai.pathfinding;

import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.world.World;
import org.topdank.minenet.api.world.WorldPhysics;

public interface PathSearchProvider {

	public PathSearch provideSearch(BlockLocation start, BlockLocation end);

	public Heuristic getHeuristic();

	public WorldPhysics getWorldPhysics();

	public World getWorld();
}