package org.topdank.minenet.api.world.ai.pathfinding;

import org.topdank.minenet.api.world.World;
import org.topdank.minenet.api.world.location.BlockLocation;

public interface WorldPhysics {
	
	public BlockLocation[] findAdjacent(BlockLocation location);
	
	public boolean canWalk(BlockLocation from, BlockLocation to);
	
	public boolean canClimb(BlockLocation location);
	
	public World getWorld();
}