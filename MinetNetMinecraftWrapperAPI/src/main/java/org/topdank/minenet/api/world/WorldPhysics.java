package org.topdank.minenet.api.world;

import org.topdank.minenet.api.game.location.BlockLocation;

public interface WorldPhysics {

	public BlockLocation[] findAdjacent(BlockLocation location);

	public boolean canWalk(BlockLocation from, BlockLocation to);

	public boolean canClimb(BlockLocation location);

	public World getWorld();
}