package org.topdank.minenet.api.world.block.id;

public class MetaBlockId extends BlockId {

	protected final int metadata;

	public MetaBlockId(int id, int metadata) {
		super(id);
		this.metadata = metadata;
	}

	public int getMetadata() {
		return metadata;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof MetaBlockId))
			return false;
		MetaBlockId b = (MetaBlockId) o;
		return (b.id == id) && (b.metadata == metadata);
	}

	public int hashcode() {
		return (31 * super.hashCode()) + metadata;
	}
}