package org.topdank.minenet.api.world.block.properties;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class PropertyEnum<T extends Enum<T> & IStringSerializable> extends AbstractProperty<T> {

	private final ImmutableSet<T> allowedValues;

	/** Map of names to Enum values */
	private final Map<String, T> nameToValue = Maps.newHashMap();

	protected PropertyEnum(String name, Class<T> valueClass, Collection<T> allowedValues) {
		super(name, valueClass);
		this.allowedValues = ImmutableSet.copyOf(allowedValues);
		Iterator<T> it = allowedValues.iterator();

		while (it.hasNext()) {
			T nextT = it.next();
			String serialisedName = ((IStringSerializable) nextT).getName();

			if (this.nameToValue.containsKey(serialisedName)) {
				throw new IllegalArgumentException("Multiple values have the same name \'" + serialisedName + "\'");
			}

			this.nameToValue.put(serialisedName, nextT);
		}
	}

	@Override
	public Collection<T> getAllowedValues() {
		return this.allowedValues;
	}

	/**
	 * Get the name for the given value.
	 */

	@Override
	public String getName(T value) {
		return ((IStringSerializable) value).getName();
	}

	/**
	 * Create a new PropertyEnum with all Enum constants of the given class.
	 */
	public static <T extends Enum<T> & IStringSerializable> PropertyEnum<T> create(String name, Class<T> clazz) {
		return create(name, clazz, Predicates.alwaysTrue());
	}

	/**
	 * Create a new PropertyEnum with all Enum constants of the given class that
	 * match the given Predicate.
	 */
	public static <T extends Enum<T> & IStringSerializable> PropertyEnum<T> create(String name, Class<T> clazz, Predicate<T> filter) {
		return create(name, clazz, Collections2.filter(Lists.newArrayList(clazz.getEnumConstants()), filter));
	}

	/**
	 * Create a new PropertyEnum with the specified values
	 */
	@SafeVarargs
	public static <T extends Enum<T> & IStringSerializable> PropertyEnum<T> create(String name, Class<T> clazz, T... values) {
		return create(name, clazz, Lists.newArrayList(values));
	}

	/**
	 * Create a new PropertyEnum with the specified values
	 */
	public static <T extends Enum<T> & IStringSerializable> PropertyEnum<T> create(String name, Class<T> clazz, Collection<T> values) {
		return new PropertyEnum<T>(name, clazz, values);
	}
}