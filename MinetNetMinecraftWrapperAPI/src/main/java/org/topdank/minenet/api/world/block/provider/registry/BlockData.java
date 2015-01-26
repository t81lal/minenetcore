package org.topdank.minenet.api.world.block.provider.registry;

import org.topdank.minenet.api.world.block.BlockId;
import org.topdank.minenet.api.world.block.material.Material;

public class BlockData {

	private final BlockId id;
	private final Material material;
	private final String name;
	private final float hardness;
	private final float blastResistence;
	private final float friction;
	private final int maxStack;

	protected BlockData(BlockId id, Material material, String name, float hardness, float blastResistence, float friction, int maxStack) {
		this.id = id;
		this.material = material;
		this.name = name;
		this.hardness = hardness;
		this.blastResistence = blastResistence;
		this.friction = friction;
		this.maxStack = maxStack;
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

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof BlockData))
			return false;
		BlockData db = (BlockData) o;
		return id.equals(db.id);
	}

	public static class Builder {

		private BlockId id;
		private Material material;
		private String name;
		private float hardness;
		private float blastResistence;
		private float friction;
		private int maxStack;

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

		public BlockData create() {
			return new BlockData(id, material, name, hardness, blastResistence, friction, maxStack);
		}
	}
}