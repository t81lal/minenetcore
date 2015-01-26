package org.topdank.minenet.api.world.block;

public final class BlockId {

	private final int id;
	private final int metadata;

	public BlockId(int id, int metadata) {
		this.id = id;
		this.metadata = metadata;
	}

	public int getId() {
		return id;
	}

	public int getMetadata() {
		return metadata;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof BlockId))
			return false;
		BlockId b = (BlockId) o;
		return b.id == id && b.metadata == metadata;
	}
}