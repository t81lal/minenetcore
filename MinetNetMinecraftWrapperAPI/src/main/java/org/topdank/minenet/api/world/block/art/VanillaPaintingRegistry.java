package org.topdank.minenet.api.world.block.art;

import java.io.IOException;
import java.net.URL;

public class VanillaPaintingRegistry extends PaintingRegistry {

	@Override
	public void register() {
		try {
			loadFromFile(new URL("http://topdank.org/minenet/api/registry/paintings.registry").openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}