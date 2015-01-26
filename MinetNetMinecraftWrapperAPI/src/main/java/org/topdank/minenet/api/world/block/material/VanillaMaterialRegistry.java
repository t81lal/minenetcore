package org.topdank.minenet.api.world.block.material;

import static org.topdank.minenet.api.world.block.material.Material.FLAG_FLAMMABLE;
import static org.topdank.minenet.api.world.block.material.Material.FLAG_LIQUID;
import static org.topdank.minenet.api.world.block.material.Material.FLAG_OPAQUE;
import static org.topdank.minenet.api.world.block.material.Material.FLAG_REQUIRES_TOOL;
import static org.topdank.minenet.api.world.block.material.Material.FLAG_SOLID;

import java.util.TreeSet;

public class VanillaMaterialRegistry extends MaterialRegistry {

	@Override
	protected void register() {
		register(builder("AIR").create());
		register(builder("ANVIL").flags(FLAG_OPAQUE | FLAG_SOLID | FLAG_REQUIRES_TOOL).create());
		register(builder("BARRIER").flags(FLAG_OPAQUE | FLAG_SOLID).create());
		register(builder("GRASS").flags(FLAG_OPAQUE | FLAG_SOLID).create());
		register(builder("GROUND").flags(FLAG_OPAQUE | FLAG_SOLID).create());
		register(builder("WOOD").flags(FLAG_OPAQUE | FLAG_SOLID | FLAG_FLAMMABLE).create());
		register(builder("ROCK").flags(FLAG_OPAQUE | FLAG_SOLID | FLAG_REQUIRES_TOOL).create());
		register(builder("IRON").flags(FLAG_OPAQUE | FLAG_SOLID | FLAG_REQUIRES_TOOL).create());
		register(builder("WATER").flags(FLAG_LIQUID).create());
		register(builder("LAVA").flags(FLAG_LIQUID).create());
		register(builder("LEAVES").flags(FLAG_FLAMMABLE).create());
		register(builder("PLANTS").create());
		register(builder("VINE").create());
		register(builder("SPONGE").flags(FLAG_OPAQUE | FLAG_SOLID).create());
		register(builder("CLOTH").flags(FLAG_OPAQUE | FLAG_SOLID | FLAG_FLAMMABLE).create());
		register(builder("FIRE").create());
		register(builder("SAND").flags(FLAG_OPAQUE | FLAG_SOLID).create());
		register(builder("CIRCUITS").create());
		register(builder("CARPET").flags(FLAG_FLAMMABLE).create());
		register(builder("GLASS").flags(FLAG_SOLID).create());
		register(builder("REDSTONELIGHT").flags(FLAG_OPAQUE | FLAG_SOLID).create());
		register(builder("TNT").flags(FLAG_SOLID | FLAG_FLAMMABLE).create());
		register(builder("CORAL").flags(FLAG_OPAQUE | FLAG_SOLID).create());
		register(builder("ICE").flags(FLAG_SOLID).create());
		register(builder("PACKEDICE").flags(FLAG_OPAQUE | FLAG_SOLID).create());
		register(builder("SNOW").create());
		register(builder("CRAFTEDSNOW").flags(FLAG_OPAQUE | FLAG_SOLID).create());
		register(builder("CACTUS").flags(FLAG_SOLID).create());
		register(builder("CLAY").flags(FLAG_OPAQUE | FLAG_SOLID).create());
		register(builder("GOURD").flags(FLAG_OPAQUE | FLAG_SOLID).create());
		register(builder("DRAGONEGG").flags(FLAG_OPAQUE | FLAG_SOLID).create());
		register(builder("PORTAL").flags(FLAG_REQUIRES_TOOL).create());
		register(builder("CAKE").flags(FLAG_OPAQUE | FLAG_SOLID).create());
		register(builder("WEB").flags(FLAG_SOLID).create());
		register(builder("PISTON").flags(FLAG_OPAQUE | FLAG_SOLID).create());
	}

	public static void main(String[] args) {
		VanillaMaterialRegistry m = new VanillaMaterialRegistry();
		for (String s : new TreeSet<String>(m.cache.keySet())) {
			System.out.println("private static final String MATERIAL_" + s + "_KEY = \"" + s + "\";");
		}
	}
}