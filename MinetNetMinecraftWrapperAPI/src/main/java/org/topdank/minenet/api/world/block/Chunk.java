package org.topdank.minenet.api.world.block;

public class Chunk {

	private ShortArray3d blocks;
	private NibbleArray3d blocklight;
	private NibbleArray3d skylight;

	public Chunk(boolean skylight) {
		this(new ShortArray3d(4096), new NibbleArray3d(4096), skylight ? new NibbleArray3d(4096) : null);
	}

	public Chunk(ShortArray3d blocks, NibbleArray3d blocklight, NibbleArray3d skylight) {
		this.blocks = blocks;
		this.blocklight = blocklight;
		this.skylight = skylight;
	}

	public ShortArray3d getBlocks() {
		return blocks;
	}

	public NibbleArray3d getBlockLight() {
		return blocklight;
	}

	public NibbleArray3d getSkyLight() {
		return skylight;
	}

	public boolean isEmpty() {
		for (short block : blocks.getData()) {
			if (block != 0) {
				return false;
			}
		}
		return true;
	}
}