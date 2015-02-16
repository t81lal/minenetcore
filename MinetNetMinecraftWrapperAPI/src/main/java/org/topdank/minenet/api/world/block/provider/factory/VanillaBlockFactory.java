package org.topdank.minenet.api.world.block.provider.factory;

import org.topdank.minenet.api.game.BoundingBox;
import org.topdank.minenet.api.game.location.Direction;
import org.topdank.minenet.api.world.World;
import org.topdank.minenet.api.world.block.Block;
import org.topdank.minenet.api.world.block.id.BlockId;
import org.topdank.minenet.api.world.block.provider.registry.BlockData;
import org.topdank.minenet.api.world.block.provider.registry.BlockRegistry;
import org.topdank.minenet.api.world.provider.WorldProvider;

public class VanillaBlockFactory extends BlockFactory {

	private static final int[] STAIR_IDS = new int[200];

	static {
		STAIR_IDS[53] = 53;
		STAIR_IDS[67] = 67;
		STAIR_IDS[108] = 108;
		STAIR_IDS[109] = 109;
		STAIR_IDS[114] = 114;
		STAIR_IDS[128] = 128;
		STAIR_IDS[134] = 134;
		STAIR_IDS[135] = 135;
		STAIR_IDS[136] = 136;
		STAIR_IDS[156] = 156;
		STAIR_IDS[163] = 163;
		STAIR_IDS[164] = 164;
		STAIR_IDS[180] = 180;
	}

	public VanillaBlockFactory(WorldProvider worldProvider) {
		super(worldProvider);
	}

	private BlockRegistry registry;

	@Override
	public Block create(World world, int x, int y, int z, BlockId blockId) {
		if (registry == null)
			registry = worldProvider.getBlockProvider().getBlockRegistry();

		BlockData blockData = registry.getByKey(blockId);
		if (blockData == null) {
			System.out.println("BlockData null for " + blockId);
			return null;
		}

		int data = blockId.getId();
		int id = data >> 4;

		if (STAIR_IDS[id] == id) {
			BoundingBox[] bb = calcStairBbs(world, x, y, z, data);
			return new Block(world, x, y, z, blockId, blockData, bb);
		}

		return new Block(world, x, y, z, blockId, blockData);
	}

	public static BoundingBox[] calcStairBbs(World world, int x, int y, int z, int data) {
		Direction direction = orientation(data);
		boolean upsideDown = (data & 4) != 0;
		double by = y, ty = y + 0.5;
		if (upsideDown) {
			by = y + 0.5;
			ty = y;
		}

		BoundingBox bottom = BoundingBox.create(x, by, z, x + 1, by + 0.5, z + 1);
		BoundingBox topPXPZ = BoundingBox.create(x, ty, z, x + 0.5, ty + 0.5, z + 0.5);
		BoundingBox topPXNZ = BoundingBox.create(x, ty, z + 0.5, x + 0.5, ty + 0.5, z + 1);
		BoundingBox topNXPZ = BoundingBox.create(x + 0.5, ty, z, x + 1, ty + 0.5, z + 0.5);
		BoundingBox topNXNZ = BoundingBox.create(x + 0.5, ty, z + 0.5, x + 1, ty + 0.5, z + 1);

		boolean pxpz = true, pxnz = true, nxnz = false, nxpz = false;
		boolean connectedLeft = checkStair(world, data, x, y, z, direction, Direction.WEST, Direction.NORTH);
		boolean connectedRight = checkStair(world, data, x, y, z, direction, Direction.EAST, Direction.NORTH);
		if (!connectedLeft && checkStair(world, data, x, y, z, direction, Direction.NORTH, Direction.EAST))
			pxpz = false;
		else if (!connectedRight && checkStair(world, data, x, y, z, direction, Direction.NORTH, Direction.WEST))
			pxnz = false;
		else if (!connectedLeft && checkStair(world, data, x, y, z, direction, Direction.SOUTH, Direction.WEST))
			nxpz = true;
		else if (!connectedRight && checkStair(world, data, x, y, z, direction, Direction.SOUTH, Direction.EAST))
			nxnz = true;
		int rotation = ((4 - orientation(direction)) + 2) % 4;
		for (; rotation > 0; rotation--) {
			boolean temp = pxpz;
			pxpz = nxpz;
			nxpz = nxnz;
			nxnz = pxnz;
			pxnz = temp;
		}
		int size = 1 + (pxpz ? 1 : 0) + (pxnz ? 1 : 0) + (nxpz ? 1 : 0) + (nxnz ? 1 : 0), idx = 0;
		BoundingBox[] boxes = new BoundingBox[size];
		boxes[idx++] = bottom;
		if (pxpz)
			boxes[idx++] = topPXPZ;
		if (pxnz)
			boxes[idx++] = topPXNZ;
		if (nxpz)
			boxes[idx++] = topNXPZ;
		if (nxnz)
			boxes[idx++] = topNXNZ;
		return boxes;
	}

	public static boolean checkStair(World world, int id, int x, int y, int z, Direction orientation, Direction direction, Direction facing) {
		direction = rotate(orientation, orientation(direction));
		facing = rotate(orientation, orientation(facing));
		int block = world.getBlockData(x + direction.getOffsetX(), y + direction.getOffsetY(), z + direction.getOffsetZ());

		boolean upsideDown = (id & 4) != 0;
		boolean otherUpsideDown = (block & 4) != 0;
		int otherId = block >> 4;
		if ((STAIR_IDS[otherId] != otherId) || (upsideDown != otherUpsideDown))
			return false;
		return facing == orientation(otherId);
	}

	private static int orientation(Direction direction) {
		switch (direction) {
			default:
			case NORTH:
				return 0;
			case EAST:
				return 1;
			case SOUTH:
				return 2;
			case WEST:
				return 3;
		}
	}

	private static Direction orientation(int data) {
		switch (data & 3) {
			default:
			case 0:
				return Direction.NORTH;
			case 1:
				return Direction.SOUTH;
			case 2:
				return Direction.EAST;
			case 3:
				return Direction.WEST;
		}
	}

	private static Direction rotate(Direction direction, int rotation) {
		for (; rotation > 0; rotation--) {
			switch (direction) {
				default:
				case NORTH:
					direction = Direction.EAST;
					break;
				case EAST:
					direction = Direction.SOUTH;
					break;
				case SOUTH:
					direction = Direction.WEST;
					break;
				case WEST:
					direction = Direction.NORTH;
					break;
			}
		}
		return direction;
	}
}