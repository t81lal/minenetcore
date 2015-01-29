package org.topdank.minenet.api.world.block.properties;

import java.util.Collection;
import java.util.HashSet;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

public class PropertyInteger extends AbstractProperty<Integer> {

	private final ImmutableSet<Integer> allowedValues;

	protected PropertyInteger(String name, int min, int max) {
		super(name, Integer.class);

		if (min < 0) {
			throw new IllegalArgumentException("Min value of " + name + " must be 0 or greater");
		} else if (max <= min) {
			throw new IllegalArgumentException("Max value of " + name + " must be greater than min (" + min + ")");
		} else {
			HashSet<Integer> var4 = Sets.newHashSet();

			for (int var5 = min; var5 <= max; ++var5) {
				var4.add(Integer.valueOf(var5));
			}

			this.allowedValues = ImmutableSet.copyOf(var4);
		}
	}

	@Override
	public Collection<Integer> getAllowedValues() {
		return this.allowedValues;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass() == o.getClass()) {
			if (!super.equals(o)) {
				return false;
			} else {
				PropertyInteger other = (PropertyInteger) o;
				return this.allowedValues.equals(other.allowedValues);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int var1 = super.hashCode();
		var1 = 31 * var1 + this.allowedValues.hashCode();
		return var1;
	}

	public static PropertyInteger create(String name, int min, int max) {
		return new PropertyInteger(name, min, max);
	}

	/**
	 * Get the name for the given value.
	 */
	@Override
	public String getName(Integer value) {
		return value.toString();
	}
}
