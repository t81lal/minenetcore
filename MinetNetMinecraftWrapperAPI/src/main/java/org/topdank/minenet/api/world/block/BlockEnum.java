package org.topdank.minenet.api.world.block;

import static org.topdank.minenet.api.world.block.BlockType.Flag.INDESTRUCTABLE;
import static org.topdank.minenet.api.world.block.BlockType.Flag.INTERACTABLE;
import static org.topdank.minenet.api.world.block.BlockType.Flag.PLACEABLE;
import static org.topdank.minenet.api.world.block.BlockType.Flag.SOLID;

import org.topdank.minenet.api.item.ToolEnum;

public enum BlockEnum {
	
	UNKNOWN(-1, -1, -1, -1, null, -1);
	
	private final int id, metadata;
	private final int maxStack;
	private final int blockHardness;
	private final ToolEnum tool;
	private final int flags;
	
	private BlockEnum(int id, int metadata, int maxStack, int blockHardness, ToolEnum tool, int flags) {
		this.id = id;
		this.metadata = metadata;
		this.maxStack = maxStack;
		this.blockHardness = blockHardness;
		this.tool = tool;
		this.flags = flags;
	}
	
	public int getId() {
		return id;
	}
	
	public int getMetadata() {
		return metadata;
	}
	
	public int getMaxStack() {
		return maxStack;
	}
	
	public int getBlockHardness() {
		return blockHardness;
	}
	
	public boolean isSolid() {
		return (flags & SOLID) == SOLID;
	}
	
	public boolean isInteractable() {
		return (flags & INTERACTABLE) == INTERACTABLE;
	}
	
	public boolean isPlaceable() {
		return (flags & PLACEABLE) == PLACEABLE;
	}
	
	public boolean isIndestructable() {
		return (flags & INDESTRUCTABLE) == INDESTRUCTABLE;
	}
	
	public static final class BlockDataFlag {
		public static final int SOLID = 0x01;
		public static final int INTERACTABLE = 0x02;
		public static final int PLACEABLE = 0x04;
		public static final int INDESTRUCTABLE = 0x08;
	}
}