package org.topdank.minenet.api.world.block.properties;

import java.util.Arrays;
import java.util.Comparator;

import org.topdank.minenet.api.world.block.provider.registry.BlockData;

import com.google.common.collect.ImmutableList;

public class BlockState {

	private static final Comparator<IProperty<?>> propertyComparator = new Comparator<IProperty<?>>() {

		@Override
		public int compare(IProperty<?> o1, IProperty<?> o2) {
			return o1.getName().compareTo(o2.getName());
		}

	};
	private BlockData blockData;
	private ImmutableList<IProperty<?>> properties;

	public BlockState(BlockData blockData, IProperty<?>... properties) {
		this.blockData = blockData;
		Arrays.sort(properties, propertyComparator);
		this.properties = ImmutableList.copyOf(properties);

	}
}