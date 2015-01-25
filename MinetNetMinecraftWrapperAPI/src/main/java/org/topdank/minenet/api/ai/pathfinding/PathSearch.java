package org.topdank.minenet.api.ai.pathfinding;

import org.topdank.minenet.api.game.location.BlockLocation;

public interface PathSearch {
	
	public void step();
	
	public boolean isDone();
	
	public BlockLocation getStart();
	
	public BlockLocation getEnd();
	
	public PathNode getPath();
	
	public PathSearchProvider getSource();
}