package org.topdank.minenet.api.nbt.tag.builtin.custom;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.topdank.minenet.api.nbt.tag.builtin.Tag;

/**
 * A tag containing a serializable object.
 */
public class SerializableTag extends Tag {

	private Serializable value;

	/**
	 * Creates a tag with the specified name.
	 *
	 * @param name The name of the tag.
	 */
	public SerializableTag(String name) {
		this(name, 0);
	}

	/**
	 * Creates a tag with the specified name.
	 *
	 * @param name  The name of the tag.
	 * @param value The value of the tag.
	 */
	public SerializableTag(String name, Serializable value) {
		super(name);
		this.value = value;
	}

	@Override
	public Serializable getValue() {
		return this.value;
	}

	/**
	 * Sets the value of this tag.
	 *
	 * @param value New value of this tag.
	 */
	public void setValue(Serializable value) {
		this.value = value;
	}

	@Override
	public void read(DataInputStream in) throws IOException {
		ObjectInputStream str = new ObjectInputStream(in);
		try {
			this.value = (Serializable) str.readObject();
		} catch(ClassNotFoundException e) {
			throw new IOException("Class not found while reading SerializableTag!", e);
		}
	}

	@Override
	public void write(DataOutputStream out) throws IOException {
		ObjectOutputStream str = new ObjectOutputStream(out);
		str.writeObject(this.value);
	}

	@Override
	public SerializableTag clone() {
		return new SerializableTag(this.getName(), this.getValue());
	}

}
