package org.topdank.minenet.api.world;

import java.util.Set;

import org.topdank.minenet.api.game.BoundingBox;
import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.world.block.Block;

public abstract interface WorldPhysics {

	public abstract BlockLocation[] findAdjacent(BlockLocation location);

	public abstract boolean canWalk(BlockLocation from, BlockLocation to);

	public abstract boolean canClimb(BlockLocation location);

	public abstract Set<Block> getCollidingBlocks(BoundingBox box);

	public abstract boolean isColliding(BoundingBox box);

	public abstract boolean isInBlocks(BoundingBox box, String... blocks);

	public abstract World getWorld();
}