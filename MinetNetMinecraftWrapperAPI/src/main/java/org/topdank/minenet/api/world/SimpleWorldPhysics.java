package org.topdank.minenet.api.world;

import java.util.Set;

import org.topdank.minenet.api.game.BoundingBox;
import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.world.block.Block;

public class SimpleWorldPhysics implements WorldPhysics {

	private static final BlockLocation[] surrounding = new BlockLocation[] {
			// middle y + 0
			new BlockLocation(-1, 0, 1), new BlockLocation(0, 0, 1), new BlockLocation(1, 0, 1), new BlockLocation(-1, 0, 0), new BlockLocation(1, 0, 0), new BlockLocation(-1, 0, -1),
			new BlockLocation(0, 0, -1),
			new BlockLocation(1, 0, -1),
			// bottom y - 1
			new BlockLocation(-1, -1, 1), new BlockLocation(0, -1, 1), new BlockLocation(1, -1, 1), new BlockLocation(-1, -1, 0), new BlockLocation(0, -1, 0), new BlockLocation(1, -1, 0),
			new BlockLocation(-1, -1, -1), new BlockLocation(0, -1, -1), new BlockLocation(1, -1, -1),
			// top y + 1
			new BlockLocation(-1, 1, 1), new BlockLocation(0, 1, 1), new BlockLocation(1, 1, 1), new BlockLocation(-1, 1, 0), new BlockLocation(0, 1, 0), new BlockLocation(1, 1, 0),
			new BlockLocation(-1, 1, -1), new BlockLocation(0, 1, -1), new BlockLocation(1, 1, -1), };

	private static final boolean[] emptyBlocks;

	static {
		emptyBlocks = new boolean[256];
		// int len = BlockType.values().length;
		// for (BlockType type : BlockType.values()) {
		// if ((type.getId() >= 0) && (type.getId() < 256)) {
		// emptyBlocks[type.getId()] = !type.isSolid();
		// System.out.println(type.getId() + " " + !type.isSolid());
		// }
		// }
		// for (int i = len + 1; i < 256; i++) {
		// emptyBlocks[i] = false;
		// }
	}

	private final World world;

	public SimpleWorldPhysics(World world) {
		this.world = world;
	}

	@Override
	public BlockLocation[] findAdjacent(BlockLocation location) {
		BlockLocation[] locations = new BlockLocation[surrounding.length];
		for (int i = 0; i < locations.length; i++)
			locations[i] = location.offset(surrounding[i]);
		return locations;
	}

	@Override
	public boolean canWalk(BlockLocation from, BlockLocation to) {
		int fromX = from.getX();
		int fromY = from.getY();
		int fromZ = from.getZ();

		int toX = to.getX();
		int toY = to.getY();
		int toZ = to.getZ();

		if (toY < 0)
			return false;

		boolean valid = true;
		valid = valid && isEmpty(toX, toY, toZ); // Block at must be non-solid
		valid = valid && isEmpty(toX, toY + 1, toZ); // Block above must be
														// non-solid

		int lowerBlock = world.getBlockData(new BlockLocation(toX, toY - 1, toZ));

		System.out.println("lower " + lowerBlock + " at " + to);

		valid = valid && (lowerBlock != 10);
		valid = valid && (lowerBlock != 11);
		if (isEmpty(fromX, fromY - 1, fromZ))
			valid = valid
					&& (((toY < fromY) && (toX == fromX) && (toZ == fromZ))
							|| ((canClimb(from) && canClimb(to)) || (!canClimb(from) && canClimb(to)) || (canClimb(from) && !canClimb(to) && ((toX == fromX) && (toZ == fromZ) ? true
									: !isEmpty(toX, toY - 1, toZ)))) || !isEmpty(toX, toY - 1, toZ));
		if ((fromY != toY) && ((fromX != toX) || (fromZ != toZ)))
			return false;
		if ((fromX != toX) && (fromZ != toZ)) {
			valid = valid && isEmpty(toX, fromY, fromZ);
			valid = valid && isEmpty(fromX, fromY, toZ);
			valid = valid && isEmpty(toX, fromY + 1, fromZ);
			valid = valid && isEmpty(fromX, fromY + 1, toZ);
			if (fromY != toY) {
				valid = valid && isEmpty(toX, toY, fromZ);
				valid = valid && isEmpty(fromX, toY, toZ);
				valid = valid && isEmpty(fromX, toY, fromZ);
				valid = valid && isEmpty(toX, fromY, toZ);
				valid = valid && isEmpty(toX, fromY + 1, toZ);
				valid = valid && isEmpty(fromX, toY + 1, fromZ);
				valid = false;
			}
		} else if ((fromX != toX) && (fromY != toY)) {
			valid = valid && isEmpty(toX, fromY, fromZ);
			valid = valid && isEmpty(fromX, toY, fromZ);
			if (fromY > toY)
				valid = valid && isEmpty(toX, fromY + 1, fromZ);
			else
				valid = valid && isEmpty(fromX, toY + 1, fromZ);
			valid = false;
		} else if ((fromZ != toZ) && (fromY != toY)) {
			valid = valid && isEmpty(fromX, fromY, toZ);
			valid = valid && isEmpty(fromX, toY, fromZ);
			if (fromY > toY)
				valid = valid && isEmpty(fromX, fromY + 1, toZ);
			else
				valid = valid && isEmpty(fromX, toY + 1, fromZ);
			valid = false;
		}
		int nodeBlockUnder = world.getBlockData(new BlockLocation(toX, toY - 1, toZ));
		if ((nodeBlockUnder == 85) || (nodeBlockUnder == 107) || (nodeBlockUnder == 113))
			valid = false;
		// int id = world.getBlockIdAt(x2, y2, z2);
		// System.out.println("block " + id + " at x:" + x2 + " y:" + y2 + " z:"
		// + z2 + " canwalk: " + valid);
		return valid;
	}

	@Override
	public boolean canClimb(BlockLocation location) {
		int id = world.getBlockData(location);
		if ((id == 8) || (id == 9) || (id == 65)) // Water / Moving Water /
													// Ladder
			return true;
		if (id == 106) { // Vines (which require an adjacent solid block)
			if (!isEmpty(location.getX(), location.getY(), location.getZ() + 1) || !isEmpty(location.getX(), location.getY(), location.getZ() - 1)
					|| !isEmpty(location.getX() + 1, location.getY(), location.getZ()) || !isEmpty(location.getX() - 1, location.getY(), location.getZ()))
				return true;
		}
		return false;
	}

	private boolean isEmpty(int x, int y, int z) {
		int id = world.getBlockData(new BlockLocation(x, y, z));
		if ((id == 10) || (id == 11)) {
			return false;
		}
		boolean b = (id >= 0) && (id < emptyBlocks.length) && emptyBlocks[id];

		// System.out.println("block " + id + " at x: " + x + " y: " + y +
		// " z: " + z + " is " + b);
		return b;
	}

	@Override
	public World getWorld() {
		return world;
	}

	@Override
	public Set<Block> getCollidingBlocks(BoundingBox box) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isColliding(BoundingBox box) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInBlocks(BoundingBox box, String... blocks) {
		// TODO Auto-generated method stub
		return false;
	}
}