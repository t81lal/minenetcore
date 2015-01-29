package org.topdank.minenet.api.world.block.properties;

import com.google.common.base.Objects;

public abstract class AbstractProperty<T extends Comparable<T>> implements IProperty<T> {

	private final Class<T> valueClass;
	private final String name;

	protected AbstractProperty(String name, Class<T> valueClass) {
		this.valueClass = valueClass;
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * The class of the values of this property
	 */
	@Override
	public Class<T> getValueClass() {
		return this.valueClass;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("name", this.name).add("clazz", this.valueClass).add("values", getAllowedValues()).toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if ((o != null) && (this.getClass() == o.getClass())) {
			AbstractProperty<?> otherProperty = (AbstractProperty<?>) o;
			return this.valueClass.equals(otherProperty.valueClass) && this.name.equals(otherProperty.name);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (31 * this.valueClass.hashCode()) + this.name.hashCode();
	}
}