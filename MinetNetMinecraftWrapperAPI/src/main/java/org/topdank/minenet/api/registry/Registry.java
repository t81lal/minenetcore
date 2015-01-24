package org.topdank.minenet.api.registry;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class Registry<T> {

	protected static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

	private final Map<Integer, T> idCache = new HashMap<Integer, T>();
	private final Map<String, T> nameCache = new HashMap<String, T>();

	protected abstract void register();

	protected void register(T t, int id, String name) {
		idCache.put(id, t);
		nameCache.put(name == null ? name : name.toUpperCase(), t);
	}

	public final boolean exists(int id, String name) {
		return idCache.get(id) == getByName(name);
	}

	public final T getById(int id) {
		return idCache.get(id);
	}

	public final T getByName(String name) {
		return nameCache.get(name == null ? name : name.toUpperCase());
	}

	protected void loadFromFile(File f) {
		try {
			loadFromFile(f.toURI().toURL().openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	protected void loadFromFile(InputStream is) {
		try {
			String s = new String(readFully(is, -1, true));
			IdentifiableObject[] os = GSON.fromJson(s, IdentifiableObject[].class);
			for (IdentifiableObject o : os) {
				try {
					register((T) o.getObject(), o.getId(), o.getName());
				} catch (ClassCastException e1) {
					e1.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// from sun.misc.IOUtils
	public static byte[] readFully(InputStream paramInputStream, int paramInt, boolean paramBoolean) throws IOException {
		byte[] arrayOfByte = new byte[0];
		if (paramInt == -1)
			paramInt = 2147483647;
		int i = 0;
		while (i < paramInt) {
			int j;
			if (i >= arrayOfByte.length) {
				j = Math.min(paramInt - i, arrayOfByte.length + 1024);
				if (arrayOfByte.length < i + j)
					arrayOfByte = Arrays.copyOf(arrayOfByte, i + j);
			} else {
				j = arrayOfByte.length - i;
			}
			int k = paramInputStream.read(arrayOfByte, i, j);
			if (k < 0) {
				if ((paramBoolean) && (paramInt != 2147483647))
					throw new EOFException("Detect premature EOF");
				if (arrayOfByte.length == i)
					break;
				arrayOfByte = Arrays.copyOf(arrayOfByte, i);
				break;
			}
			i += k;
		}
		return arrayOfByte;
	}
}