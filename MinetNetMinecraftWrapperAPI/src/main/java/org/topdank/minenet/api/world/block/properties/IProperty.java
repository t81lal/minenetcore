package org.topdank.minenet.api.world.block.properties;

import java.util.Collection;

public abstract interface IProperty<T extends Comparable<T>> {

	public abstract String getName();

	public abstract Collection<T> getAllowedValues();

	/**
	 * The class of the values of this property
	 */
	public abstract Class<T> getValueClass();

	/**
	 * Get the name for the given value.
	 */
	public abstract String getName(T value);
}