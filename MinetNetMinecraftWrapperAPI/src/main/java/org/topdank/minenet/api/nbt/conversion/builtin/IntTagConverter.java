package org.topdank.minenet.api.nbt.conversion.builtin;

import org.topdank.minenet.api.nbt.conversion.TagConverter;
import org.topdank.minenet.api.nbt.tag.builtin.IntTag;

/**
 * A converter that converts between IntTag and int.
 */
public class IntTagConverter implements TagConverter<IntTag, Integer> {

	@Override
	public Integer convert(IntTag tag) {
		return tag.getValue();
	}

	@Override
	public IntTag convert(String name, Integer value) {
		return new IntTag(name, value);
	}

}
