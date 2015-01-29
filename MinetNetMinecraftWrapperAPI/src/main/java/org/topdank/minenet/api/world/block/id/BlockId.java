package org.topdank.minenet.api.world.block.id;

public class BlockId {

	protected final int id;

	public BlockId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof BlockId))
			return false;
		BlockId b = (BlockId) o;
		return (b.id == id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + id;
		return result;
	}
}