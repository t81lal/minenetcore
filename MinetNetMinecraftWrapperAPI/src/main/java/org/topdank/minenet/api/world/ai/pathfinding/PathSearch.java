package org.topdank.minenet.api.world.ai.pathfinding;

import org.topdank.minenet.api.world.location.BlockLocation;

public interface PathSearch {
	
	public void step();
	
	public boolean isDone();
	
	public BlockLocation getStart();
	
	public BlockLocation getEnd();
	
	public PathNode getPath();
	
	public PathSearchProvider getSource();
}