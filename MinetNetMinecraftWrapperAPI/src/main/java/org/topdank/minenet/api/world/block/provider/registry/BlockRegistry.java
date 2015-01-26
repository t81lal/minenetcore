package org.topdank.minenet.api.world.block.provider.registry;

import org.topdank.minenet.api.provider.registry.Registry;
import org.topdank.minenet.api.world.block.BlockId;
import org.topdank.minenet.api.world.provider.WorldProvider;

public abstract class BlockRegistry extends Registry<BlockId, BlockData> {

	protected final WorldProvider worldProvider;

	public BlockRegistry(WorldProvider worldProvider) {
		super(false);
		this.worldProvider = worldProvider;
	}

	@Override
	protected abstract void register();

	protected void register(BlockData d) {
		register(d.getId(), d);
	}
}