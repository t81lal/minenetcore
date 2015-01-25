package org.topdank.minenet.api.world.block.biome;

public class VanillaBiomeRegistry extends BiomeRegistry {

	@Override
	protected void register() {
		registerBiome(new Biome(0, "Ocean"));
		registerBiome(new Biome(1, "Plains"));
		registerBiome(new Biome(2, "Desert"));
		registerBiome(new Biome(3, "ExtremeHills"));
		registerBiome(new Biome(4, "Forest"));
		registerBiome(new Biome(5, "Taiga"));
		registerBiome(new Biome(6, "SwampLand"));
		registerBiome(new Biome(7, "River"));
		registerBiome(new Biome(8, "Hell"));
		registerBiome(new Biome(9, "Sky"));
		registerBiome(new Biome(10, "FrozenOcean"));
		registerBiome(new Biome(11, "FrozenRiver"));
		registerBiome(new Biome(12, "IcePlains"));
		registerBiome(new Biome(13, "IceMountains"));
		registerBiome(new Biome(14, "MushroomIsland"));
		registerBiome(new Biome(15, "MushroomIslandShore"));
		registerBiome(new Biome(16, "Beach"));
		registerBiome(new Biome(17, "DesertHills"));
		registerBiome(new Biome(18, "ForestHills"));
		registerBiome(new Biome(19, "TaigaHills"));
		registerBiome(new Biome(20, "ExtremeHillsEdge"));
		registerBiome(new Biome(21, "Jungle"));
		registerBiome(new Biome(22, "JungleHills"));
	}
}