package org.topdank.minenet.api.provider.registry;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public abstract class Registry<T, K> {

	protected static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

	protected final Map<T, K> cache = new HashMap<T, K>();

	public Registry() {
		register();
	}

	protected void register(T t, K k) {
		cache.put(t, k);
	}

	public final boolean exists(T t, K k) {
		return cache.get(t).equals(k);
	}

	public final K getByKey(T t) {
		return cache.get(t);
	}

	protected abstract void register();

	protected void loadFromFile(File f) {
		try {
			loadFromFile(f.toURI().toURL().openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void loadFromFile(InputStream is) {
		try {
			String s = new String(readFully(is, -1, true));
			Map<T, K> map = GSON.fromJson(s, new TypeToken<Map<T, K>>() {
			}.getType());
			for (Entry<T, K> entry : map.entrySet()) {
				try {
					register(entry.getKey(), entry.getValue());
				} catch (ClassCastException e1) {
					e1.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			System.out.println("Invalid registry file.");
			e.printStackTrace();
		}
	}

	// from sun.misc.IOUtils
	public static byte[] readFully(InputStream is, int maxLength, boolean detectEOF) throws IOException {
		byte[] bytesRead = new byte[0];
		if (maxLength == -1)
			maxLength = 2147483647;
		int i = 0;
		while (i < maxLength) {
			int j;
			if (i >= bytesRead.length) {
				j = Math.min(maxLength - i, bytesRead.length + 1024);
				if (bytesRead.length < i + j)
					bytesRead = Arrays.copyOf(bytesRead, i + j);
			} else {
				j = bytesRead.length - i;
			}
			int k = is.read(bytesRead, i, j);
			if (k < 0) {
				if ((detectEOF) && (maxLength != 2147483647))
					throw new EOFException("Detect premature EOF");
				if (bytesRead.length == i)
					break;
				bytesRead = Arrays.copyOf(bytesRead, i);
				break;
			}
			i += k;
		}
		return bytesRead;
	}
}