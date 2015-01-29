package org.topdank.minenet.api.world.block.properties;

import java.util.Collection;

import com.google.common.collect.ImmutableSet;

public class PropertyBool extends AbstractProperty<Boolean> {

	private final ImmutableSet<Boolean> allowedValues = ImmutableSet.of(Boolean.valueOf(true), Boolean.valueOf(false));

	protected PropertyBool(String name) {
		super(name, Boolean.class);
	}

	@Override
	public Collection<Boolean> getAllowedValues() {
		return this.allowedValues;
	}

	public static PropertyBool create(String name) {
		return new PropertyBool(name);
	}

	/**
	 * Get the name for the given value.
	 */
	@Override
	public String getName(Boolean value) {
		return value.toString();
	}
}
