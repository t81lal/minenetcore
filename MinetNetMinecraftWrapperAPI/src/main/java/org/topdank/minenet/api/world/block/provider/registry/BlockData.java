package org.topdank.minenet.api.world.block.provider.registry;

import org.topdank.minenet.api.game.BoundingBox;
import org.topdank.minenet.api.world.block.id.BlockId;
import org.topdank.minenet.api.world.block.material.Material;

public class BlockData {

	private final BlockId id;
	private final Material material;
	private final String name;
	private final float hardness;
	private final float blastResistence;
	private final float friction;
	private final int maxStack;
	private final BoundingBox boundingBox;

	protected BlockData(BlockId id, Material material, String name, float hardness, float blastResistence, float friction, int maxStack, BoundingBox boundingBox) {
		this.id = id;
		this.material = material;
		this.name = name;
		this.hardness = hardness;
		this.blastResistence = blastResistence;
		this.friction = friction;
		this.maxStack = maxStack;
		this.boundingBox = boundingBox;
	}

	public BlockId getId() {
		return id;
	}

	public Material getMaterial() {
		return material;
	}

	public String getName() {
		return name;
	}

	public float getHardness() {
		return hardness;
	}

	public float getBlastResistence() {
		return blastResistence;
	}

	public float getFriction() {
		return friction;
	}

	public int getMaxStack() {
		return maxStack;
	}

	public BoundingBox getBoundingBox() {
		return boundingBox;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof BlockData))
			return false;
		BlockData db = (BlockData) o;
		return id.equals(db.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	public static class Builder {

		protected BlockId id;
		protected Material material;
		protected String name;
		protected float hardness;
		protected float blastResistence;
		protected float friction;
		protected int maxStack;
		protected BoundingBox boundingBox;

		protected Builder() {
		}

		public Builder id(BlockId id) {
			this.id = id;
			return this;
		}

		public Builder material(Material material) {
			this.material = material;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder hardness(float hardness) {
			this.hardness = hardness;
			return this;
		}

		public Builder blastResistence(float blastResistence) {
			this.blastResistence = blastResistence;
			return this;
		}

		public Builder friction(float friction) {
			this.friction = friction;
			return this;
		}

		public Builder maxStack(int maxStack) {
			this.maxStack = maxStack;
			return this;
		}

		public Builder boundingBox(BoundingBox box) {
			boundingBox = box;
			return this;
		}

		public BlockData create() {
			return new BlockData(id, material, name, hardness, blastResistence, friction, maxStack, boundingBox);
		}
	}

	public static class BoundingBoxStatePair {

		private final int state;
		private final BoundingBox box;

		public BoundingBoxStatePair(int state, BoundingBox box) {
			this.state = state;
			this.box = box;
		}

		public int getState() {
			return state;
		}

		public BoundingBox getBox() {
			return box;
		}
	}
}