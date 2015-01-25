package org.topdank.minenet.api.ai.pathfinding;

import org.topdank.minenet.api.game.location.BlockLocation;

public interface PathNode {

	public BlockLocation getLocation();

	public PathNode getNext();

	public PathNode getPrevious();

	public void setNext(PathNode node);

	public void setPrevious(PathNode node);

	public double getCost();

	public double getCostEstimate();

	public void setCost(double cost);

	public void setCostEstimate(double costEstimate);

	public boolean isStart();

	public boolean isEnd();

	public PathSearch getSource();
}