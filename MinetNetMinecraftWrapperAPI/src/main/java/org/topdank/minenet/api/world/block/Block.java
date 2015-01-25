package org.topdank.minenet.api.world.block;

import org.topdank.minenet.api.game.BoundingBox;
import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.world.World;

public class Block {

	private static final BoundingBox DEFAULT = BoundingBox.getBoundingBox(0, 0, 0, 1, 1, 1);

	private final World world;
	private final Chunk chunk;
	private final BlockLocation location;
	private final int id, metadata;
	private final BlockType type;
	private final BoundingBox boundingBox;
	private final BoundingBox[] asArray;

	public Block(World world, Chunk chunk, BlockLocation location, int id, int metadata) {
		this.world = world;
		this.chunk = chunk;
		this.location = location;
		this.id = id;
		this.metadata = metadata;
		type = BlockType.getById(id);
		boundingBox = DEFAULT.offset(location);
		asArray = new BoundingBox[] { boundingBox };
	}

	public World getWorld() {
		return world;
	}

	public Chunk getChunk() {
		return chunk;
	}

	public BlockLocation getLocation() {
		return location;
	}

	public int getId() {
		return id;
	}

	public int getMetadata() {
		return metadata;
	}

	public BlockType getBlockType() {
		return type;
	}

	public BoundingBox[] getBoundingBoxes() {
		return asArray;
	}

	public BoundingBox getBoundingBox() {
		return boundingBox;
	}
}