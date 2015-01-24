package org.topdank.minenet.api.world.block.biome;

import java.io.IOException;
import java.net.URL;

public class VanillaBiomeRegistry extends BiomeRegistry {

	@Override
	protected void register() {
		try {
			loadFromFile(new URL("http://topdank.org/minenet/api/registry/biomes.registry").openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}