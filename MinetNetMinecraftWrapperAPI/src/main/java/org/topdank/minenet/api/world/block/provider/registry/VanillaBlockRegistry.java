package org.topdank.minenet.api.world.block.provider.registry;

import org.topdank.minenet.api.world.block.BlockId;
import org.topdank.minenet.api.world.block.provider.registry.BlockData.Builder;
import org.topdank.minenet.api.world.provider.WorldProvider;

public class VanillaBlockRegistry extends BlockRegistry {

	private static final String MATERIAL_AIR_KEY = "AIR";
	private static final String MATERIAL_ANVIL_KEY = "ANVIL";
	private static final String MATERIAL_BARRIER_KEY = "BARRIER";
	private static final String MATERIAL_CACTUS_KEY = "CACTUS";
	private static final String MATERIAL_CAKE_KEY = "CAKE";
	private static final String MATERIAL_CARPET_KEY = "CARPET";
	private static final String MATERIAL_CIRCUITS_KEY = "CIRCUITS";
	private static final String MATERIAL_CLAY_KEY = "CLAY";
	private static final String MATERIAL_CLOTH_KEY = "CLOTH";
	private static final String MATERIAL_CORAL_KEY = "CORAL";
	private static final String MATERIAL_CRAFTEDSNOW_KEY = "CRAFTEDSNOW";
	private static final String MATERIAL_DRAGONEGG_KEY = "DRAGONEGG";
	private static final String MATERIAL_FIRE_KEY = "FIRE";
	private static final String MATERIAL_GLASS_KEY = "GLASS";
	private static final String MATERIAL_GOURD_KEY = "GOURD";
	private static final String MATERIAL_GRASS_KEY = "GRASS";
	private static final String MATERIAL_GROUND_KEY = "GROUND";
	private static final String MATERIAL_ICE_KEY = "ICE";
	private static final String MATERIAL_IRON_KEY = "IRON";
	private static final String MATERIAL_LAVA_KEY = "LAVA";
	private static final String MATERIAL_LEAVES_KEY = "LEAVES";
	private static final String MATERIAL_PACKEDICE_KEY = "PACKEDICE";
	private static final String MATERIAL_PISTON_KEY = "PISTON";
	private static final String MATERIAL_PLANTS_KEY = "PLANTS";
	private static final String MATERIAL_PORTAL_KEY = "PORTAL";
	private static final String MATERIAL_REDSTONELIGHT_KEY = "REDSTONELIGHT";
	private static final String MATERIAL_ROCK_KEY = "ROCK";
	private static final String MATERIAL_SAND_KEY = "SAND";
	private static final String MATERIAL_SNOW_KEY = "SNOW";
	private static final String MATERIAL_SPONGE_KEY = "SPONGE";
	private static final String MATERIAL_TNT_KEY = "TNT";
	private static final String MATERIAL_VINE_KEY = "VINE";
	private static final String MATERIAL_WATER_KEY = "WATER";
	private static final String MATERIAL_WEB_KEY = "WEB";
	private static final String MATERIAL_WOOD_KEY = "WOOD";

	public VanillaBlockRegistry(WorldProvider worldProvider) {
		super(worldProvider);
	}

	@Override
	protected void register() {
		//@formatter:off
		register(builder("Air", MATERIAL_AIR_KEY)                                       .id(new BlockId(0, 0)).create());

		//stone variants
		register(builder("Stone", MATERIAL_ROCK_KEY)                                    .id(new BlockId(1, 0)).hardness(1.5F).blastResistence(30.0F).create());
		register(builder("Granite", MATERIAL_ROCK_KEY)                                  .id(new BlockId(1, 1)).hardness(1.5F).blastResistence(30.0F).create());
		register(builder("Polished Granite", MATERIAL_ROCK_KEY)                         .id(new BlockId(1, 2)).hardness(1.5F).blastResistence(30.0F).create());
		register(builder("Diorite", MATERIAL_ROCK_KEY)                                  .id(new BlockId(1, 3)).hardness(1.5F).blastResistence(30.0F).create());
		register(builder("Polished Diorite", MATERIAL_ROCK_KEY)                         .id(new BlockId(1, 4)).hardness(1.5F).blastResistence(30.0F).create());
		register(builder("Andesite", MATERIAL_ROCK_KEY)                                 .id(new BlockId(1, 5)).hardness(1.5F).blastResistence(30.0F).create());
		register(builder("Polished Andesite", MATERIAL_ROCK_KEY)                        .id(new BlockId(1, 6)).hardness(1.5F).blastResistence(30.0F).create());

		register(builder("Grass", MATERIAL_GRASS_KEY)                                   .id(new BlockId(2, 0)).hardness(0.6F).blastResistence(3.0F).create());
		register(builder("Dirt", MATERIAL_GROUND_KEY)                                   .id(new BlockId(3, 0)).hardness(0.5F).blastResistence(2.5F).create());
		register(builder("Cobblestone", MATERIAL_ROCK_KEY)                              .id(new BlockId(4, 0)).hardness(2.0F).blastResistence(30.0F).create());

		//plank variants
		register(builder("Oak Wood Planks", MATERIAL_WOOD_KEY)                          .id(new BlockId(5, 0)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Spruce Wood Planks", MATERIAL_WOOD_KEY)                       .id(new BlockId(5, 1)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Birch Wood Planks", MATERIAL_WOOD_KEY)                        .id(new BlockId(5, 2)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Jungle Wood Planks", MATERIAL_WOOD_KEY)                       .id(new BlockId(5, 3)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Acacia Wood Planks", MATERIAL_WOOD_KEY)                       .id(new BlockId(5, 4)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Dark Oak Wood Planks", MATERIAL_WOOD_KEY)                     .id(new BlockId(5, 5)).hardness(2.0F).blastResistence(15.0F).create());

		register(builder("Bedrock", MATERIAL_ROCK_KEY)                                  .id(new BlockId(7, 0)).hardness(-1.0F).blastResistence(1.8E7F).create());
		register(builder("Flowing Water", MATERIAL_WATER_KEY)                           .id(new BlockId(8, 0)).hardness(100.0F).blastResistence(500.0F).create());
		register(builder("Still Water", MATERIAL_WATER_KEY)                             .id(new BlockId(9, 0)).hardness(100.0F).blastResistence(500.0F).create());
		register(builder("Flowing Lava", MATERIAL_LAVA_KEY)                             .id(new BlockId(10, 0)).hardness(100.0F).create());
		register(builder("Still Lava", MATERIAL_LAVA_KEY)                               .id(new BlockId(11, 0)).hardness(100.0F).blastResistence(500.0F).create());
		register(builder("Sand", MATERIAL_SAND_KEY)                                     .id(new BlockId(12, 0)).hardness(0.5F).blastResistence(2.5F).create());
		register(builder("Red Sand", MATERIAL_SAND_KEY)                                 .id(new BlockId(12, 1)).hardness(0.5F).blastResistence(2.5F).create());
		register(builder("Gravel", MATERIAL_SAND_KEY)                                   .id(new BlockId(13, 0)).hardness(0.6F).blastResistence(3.0F).create());
		register(builder("Gold Ore", MATERIAL_ROCK_KEY)                                 .id(new BlockId(14, 0)).hardness(13.0F).blastResistence(15.0F).create());
		register(builder("Iron Ore", MATERIAL_ROCK_KEY)                                 .id(new BlockId(15, 0)).hardness(3.0F).blastResistence(15.0F).create());
		register(builder("Iron Ore", MATERIAL_ROCK_KEY)                                 .id(new BlockId(16, 0)).hardness(3.0F).blastResistence(15.0F).create());
		register(builder("Oak Wood", MATERIAL_WOOD_KEY)                                 .id(new BlockId(17, 0)).hardness(2.0F).blastResistence(10.0F).create());

		//log variants
		register(builder("Spruce Wood", MATERIAL_WOOD_KEY)                              .id(new BlockId(17, 1)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Birch Wood", MATERIAL_WOOD_KEY)                               .id(new BlockId(17, 2)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Jungle Wood", MATERIAL_WOOD_KEY)                              .id(new BlockId(17, 3)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Oak Wood", MATERIAL_WOOD_KEY)                                 .id(new BlockId(17, 4)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Spruce Wood", MATERIAL_WOOD_KEY)                              .id(new BlockId(17, 5)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Birch Wood", MATERIAL_WOOD_KEY)                               .id(new BlockId(17, 6)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Jungle Wood", MATERIAL_WOOD_KEY)                              .id(new BlockId(17, 7)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Oak Wood", MATERIAL_WOOD_KEY)                                 .id(new BlockId(17, 8)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Spruce Wood", MATERIAL_WOOD_KEY)                              .id(new BlockId(17, 9)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Birch Wood", MATERIAL_WOOD_KEY)                               .id(new BlockId(17, 10)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Jungle Wood", MATERIAL_WOOD_KEY)                              .id(new BlockId(17, 11)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Oak Wood", MATERIAL_WOOD_KEY)                                 .id(new BlockId(17, 12)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Spruce Wood", MATERIAL_WOOD_KEY)                              .id(new BlockId(17, 13)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Birch Wood", MATERIAL_WOOD_KEY)                               .id(new BlockId(17, 14)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Jungle Wood", MATERIAL_WOOD_KEY)                              .id(new BlockId(17, 15)).hardness(2.0F).blastResistence(10.0F).create());

		//chronic variants
		register(builder("Oak Leaves", MATERIAL_LEAVES_KEY)                             .id(new BlockId(18, 0)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Spruce Leaves", MATERIAL_LEAVES_KEY)                          .id(new BlockId(18, 1)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Birch Leaves", MATERIAL_LEAVES_KEY)                           .id(new BlockId(18, 2)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Jungle Leaves", MATERIAL_LEAVES_KEY)                          .id(new BlockId(18, 3)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Oak Leaves", MATERIAL_LEAVES_KEY)                             .id(new BlockId(18, 4)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Spruce Leaves", MATERIAL_LEAVES_KEY)                          .id(new BlockId(18, 5)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Birch Leaves", MATERIAL_LEAVES_KEY)                           .id(new BlockId(18, 6)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Jungle Leaves", MATERIAL_LEAVES_KEY)                          .id(new BlockId(18, 7)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Oak Leaves", MATERIAL_LEAVES_KEY)                             .id(new BlockId(18, 8)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Spruce Leaves", MATERIAL_LEAVES_KEY)                          .id(new BlockId(18, 9)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Birch Leaves", MATERIAL_LEAVES_KEY)                           .id(new BlockId(18, 10)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Jungle Leaves", MATERIAL_LEAVES_KEY)                          .id(new BlockId(18, 11)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Oak Leaves", MATERIAL_LEAVES_KEY)                             .id(new BlockId(18, 12)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Spruce Leaves", MATERIAL_LEAVES_KEY)                          .id(new BlockId(18, 13)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Birch Leaves", MATERIAL_LEAVES_KEY)                           .id(new BlockId(18, 14)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Jungle Leaves", MATERIAL_LEAVES_KEY)                          .id(new BlockId(18, 15)).hardness(0.2F).blastResistence(1.0F).create());

		register(builder("Sponge", MATERIAL_SPONGE_KEY)                                 .id(new BlockId(19, 0)).hardness(0.6F).blastResistence(3.0F).create());
		register(builder("Sponge", MATERIAL_SPONGE_KEY)                                 .id(new BlockId(19, 1)).hardness(0.6F).blastResistence(3.0F).create());
		register(builder("Glass", MATERIAL_GLASS_KEY)                                   .id(new BlockId(20, 0)).hardness(0.3F).blastResistence(1.5F).create());
		register(builder("Lapis Lazuli Ore", MATERIAL_ROCK_KEY)                         .id(new BlockId(21, 0)).hardness(3.0F).blastResistence(15.0F).create());
		register(builder("Lapis Lazuli Block", MATERIAL_IRON_KEY)                       .id(new BlockId(22, 0)).hardness(3.0F).blastResistence(15.0F).create());

		//sandstone variants
		register(builder("Dispenser", MATERIAL_ROCK_KEY)                                .id(new BlockId(23, 0)).hardness(3.5F).blastResistence(17.5F).create());
		register(builder("Sandstone", MATERIAL_ROCK_KEY)                                .id(new BlockId(24, 0)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Sandstone", MATERIAL_ROCK_KEY)                                .id(new BlockId(24, 1)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Sandstone", MATERIAL_ROCK_KEY)                                .id(new BlockId(24, 2)).hardness(0.8F).blastResistence(4.0F).create());

		register(builder("Note Block", MATERIAL_WOOD_KEY)                               .id(new BlockId(25, 0)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Bed", MATERIAL_CLOTH_KEY)                                     .id(new BlockId(26, 0)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Powered Rail", MATERIAL_CIRCUITS_KEY)                         .id(new BlockId(27, 0)).hardness(0.7F).blastResistence(3.5F).create());
		register(builder("Detector Rail", MATERIAL_CIRCUITS_KEY)                        .id(new BlockId(28, 0)).hardness(0.7F).blastResistence(3.5F).create());
		register(builder("Sticky Piston", MATERIAL_PISTON_KEY)                          .id(new BlockId(29, 0)).hardness(0.5F).blastResistence(2.5F).create());
		register(builder("Cobweb", MATERIAL_WEB_KEY)                                    .id(new BlockId(30, 0)).hardness(4.0F).blastResistence(20.0F).create());
		register(builder("Dead Bush", MATERIAL_VINE_KEY)                                .id(new BlockId(31, 0)).create());
		register(builder("Tall Grass", MATERIAL_VINE_KEY)                               .id(new BlockId(31, 1)).create());
		register(builder("Fern", MATERIAL_VINE_KEY)                                     .id(new BlockId(31, 2)).create());
		register(builder("Piston", MATERIAL_PISTON_KEY)                                 .id(new BlockId(33, 0)).hardness(0.5F).blastResistence(2.5F).create());
		register(builder("Piston Head", MATERIAL_PISTON_KEY)                            .id(new BlockId(34, 0)).hardness(0.5F).blastResistence(2.5F).create());

		//wool variants
		register(builder("White Wool", MATERIAL_CLOTH_KEY)                              .id(new BlockId(35, 0)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Orange Wool", MATERIAL_CLOTH_KEY)                             .id(new BlockId(35, 1)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Magenta Wool", MATERIAL_CLOTH_KEY)                            .id(new BlockId(35, 2)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Light Blue Wool", MATERIAL_CLOTH_KEY)                         .id(new BlockId(35, 3)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Yellow Wool", MATERIAL_CLOTH_KEY)                             .id(new BlockId(35, 4)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Lime Wool", MATERIAL_CLOTH_KEY)                               .id(new BlockId(35, 5)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Pink Wool", MATERIAL_CLOTH_KEY)                               .id(new BlockId(35, 6)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Grey Wool", MATERIAL_CLOTH_KEY)                               .id(new BlockId(35, 7)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Light Grey Wool", MATERIAL_CLOTH_KEY)                         .id(new BlockId(35, 8)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Cyan Wool", MATERIAL_CLOTH_KEY)                               .id(new BlockId(35, 9)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Purple Wool", MATERIAL_CLOTH_KEY)                             .id(new BlockId(35, 10)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Blue Wool", MATERIAL_CLOTH_KEY)                               .id(new BlockId(35, 11)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Brown Wool", MATERIAL_CLOTH_KEY)                              .id(new BlockId(35, 12)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Green Wool", MATERIAL_CLOTH_KEY)                              .id(new BlockId(35, 13)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Red Wool", MATERIAL_CLOTH_KEY)                                .id(new BlockId(35, 14)).hardness(0.8F).blastResistence(4.0F).create());
		register(builder("Black Wool", MATERIAL_CLOTH_KEY)                              .id(new BlockId(35, 15)).hardness(0.8F).blastResistence(4.0F).create());

		register(builder("Piston Moving", MATERIAL_PISTON_KEY)                          .id(new BlockId(36, 0)).hardness(-1.0F).blastResistence(-5.0F).create());

		//plant variants
		register(builder("Dandelion", MATERIAL_PLANTS_KEY)                              .id(new BlockId(37, 0)).create());
		register(builder("Poppy", MATERIAL_PLANTS_KEY)                                  .id(new BlockId(38, 0)).create());
		register(builder("Blue Orchid", MATERIAL_PLANTS_KEY)                            .id(new BlockId(38, 1)).create());
		register(builder("Allium", MATERIAL_PLANTS_KEY)                                 .id(new BlockId(38, 2)).create());
		register(builder("Azure Bluet", MATERIAL_PLANTS_KEY)                            .id(new BlockId(38, 3)).create());
		register(builder("Red Tulip", MATERIAL_PLANTS_KEY)                              .id(new BlockId(38, 4)).create());
		register(builder("Orange Tulip", MATERIAL_PLANTS_KEY)                           .id(new BlockId(38, 5)).create());
		register(builder("White Tulip", MATERIAL_PLANTS_KEY)                            .id(new BlockId(38, 6)).create());
		register(builder("Pink Tulip", MATERIAL_PLANTS_KEY)                             .id(new BlockId(38, 7)).create());
		register(builder("Oxeye Daisy", MATERIAL_PLANTS_KEY)                            .id(new BlockId(38, 8)).create());
		register(builder("Red Mushroom", MATERIAL_PLANTS_KEY)                           .id(new BlockId(39, 0)).create());
		register(builder("Brown Mushroom", MATERIAL_PLANTS_KEY)                         .id(new BlockId(40, 0)).create());

		register(builder("Gold Block", MATERIAL_IRON_KEY)                               .id(new BlockId(41, 0)).hardness(3.0F).blastResistence(30.0F).create());
		register(builder("Iron Block", MATERIAL_IRON_KEY)                               .id(new BlockId(42, 0)).hardness(5.0F).blastResistence(30.0F).create());

		//stone slabs
		register(builder("Double Stone Slab", MATERIAL_ROCK_KEY)                        .id(new BlockId(43, 0)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Double Sandstone Slab", MATERIAL_ROCK_KEY)                    .id(new BlockId(43, 1)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Double StoneWood Slab", MATERIAL_ROCK_KEY)                    .id(new BlockId(43, 2)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Double Cobblestone Slab", MATERIAL_ROCK_KEY)                  .id(new BlockId(43, 3)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Double Brick Slab", MATERIAL_ROCK_KEY)                        .id(new BlockId(43, 4)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Double Stone Brick Slab", MATERIAL_ROCK_KEY)                  .id(new BlockId(43, 5)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Double Nether Brick Slab", MATERIAL_ROCK_KEY)                 .id(new BlockId(43, 6)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Double Quartz Slab", MATERIAL_ROCK_KEY)                       .id(new BlockId(43, 7)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Smooth Double Stone Slab", MATERIAL_ROCK_KEY)                 .id(new BlockId(43, 8)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Smooth Double Sandstone Slab", MATERIAL_ROCK_KEY)             .id(new BlockId(43, 9)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Tile Smooth Quartz Slab", MATERIAL_ROCK_KEY)                  .id(new BlockId(43, 15)).hardness(2.0F).blastResistence(30.0F).create());

		register(builder("Stone Slab", MATERIAL_ROCK_KEY)                               .id(new BlockId(44, 0)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Sandstone Slab", MATERIAL_ROCK_KEY)                           .id(new BlockId(44, 1)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("StoneWood Slab", MATERIAL_ROCK_KEY)                           .id(new BlockId(44, 2)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Cobblestone Slab", MATERIAL_ROCK_KEY)                         .id(new BlockId(44, 3)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Brick Slab", MATERIAL_ROCK_KEY)                               .id(new BlockId(44, 4)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Stone Brick Slab", MATERIAL_ROCK_KEY)                         .id(new BlockId(44, 5)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Nether Brick Slab", MATERIAL_ROCK_KEY)                        .id(new BlockId(44, 6)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Quartz Slab", MATERIAL_ROCK_KEY)                              .id(new BlockId(44, 7)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Upper Stone Slab", MATERIAL_ROCK_KEY)                         .id(new BlockId(44, 8)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Upper Sandstone Slab", MATERIAL_ROCK_KEY)                     .id(new BlockId(44, 9)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Upper StoneWood Slab", MATERIAL_ROCK_KEY)                     .id(new BlockId(44, 10)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Upper Cobblestone Slab", MATERIAL_ROCK_KEY)                   .id(new BlockId(44, 11)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Upper Brick Slab", MATERIAL_ROCK_KEY)                         .id(new BlockId(44, 12)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Upper Stone Brick Slab", MATERIAL_ROCK_KEY)                   .id(new BlockId(44, 13)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Upper Nether Brick Slab", MATERIAL_ROCK_KEY)                  .id(new BlockId(44, 14)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Upper Quartz Brick Slab", MATERIAL_ROCK_KEY)                  .id(new BlockId(44, 15)).hardness(2.0F).blastResistence(30.0F).create());

		register(builder("Brick", MATERIAL_ROCK_KEY)                                    .id(new BlockId(45, 0)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("TNT", MATERIAL_TNT_KEY)                                       .id(new BlockId(46, 0)).create());
		register(builder("Bookshelf", MATERIAL_WOOD_KEY)                                .id(new BlockId(47, 0)).hardness(1.5F).hardness(7.5F).create());
		register(builder("Mossy Cobblestone", MATERIAL_ROCK_KEY)                        .id(new BlockId(48, 0)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Obsidian", MATERIAL_ROCK_KEY)                                 .id(new BlockId(49, 0)).hardness(50.0F).blastResistence(2000.0F).create());
		register(builder("Torch", MATERIAL_CIRCUITS_KEY)                                .id(new BlockId(50, 0)).create());
		register(builder("Fire", MATERIAL_CIRCUITS_KEY)                                 .id(new BlockId(51, 0)).create());
		register(builder("Mob Spawner", MATERIAL_ROCK_KEY)                              .id(new BlockId(52, 0)).hardness(5.0F).blastResistence(25.0F).create());

		register(builder("Oak Wood Stairs", MATERIAL_WOOD_KEY)                          .id(new BlockId(53, 0)).hardness(2.0F).blastResistence(15.0F).create());

		register(builder("Chest", MATERIAL_WOOD_KEY)                                    .id(new BlockId(54, 0)).hardness(2.5F).blastResistence(12.5F).create());
		register(builder("Redstone Wire", MATERIAL_CIRCUITS_KEY)                        .id(new BlockId(55, 0)).create());
		register(builder("Diamond Ore", MATERIAL_ROCK_KEY)                              .id(new BlockId(56, 0)).hardness(3.0F).blastResistence(15.0F).create());
		register(builder("Block of Diamond", MATERIAL_IRON_KEY)                         .id(new BlockId(57, 0)).hardness(5.0F).blastResistence(30.0F).create());
		register(builder("Crafting Table", MATERIAL_WOOD_KEY)                           .id(new BlockId(58, 0)).hardness(2.5F).blastResistence(12.5F).create());
		register(builder("Wheat", MATERIAL_PLANTS_KEY)                                  .id(new BlockId(59, 0)).create());
		register(builder("Farmland", MATERIAL_GROUND_KEY)                               .id(new BlockId(60, 0)).hardness(0.6F).blastResistence(3.0F).create());
		register(builder("Furnace", MATERIAL_ROCK_KEY)                                  .id(new BlockId(61, 0)).hardness(3.5F).blastResistence(17.5F).create());
		register(builder("Active Furnace", MATERIAL_ROCK_KEY)                           .id(new BlockId(62, 0)).hardness(3.5F).blastResistence(17.5F).create());
		register(builder("Standing Sign", MATERIAL_WOOD_KEY)                            .id(new BlockId(63, 0)).hardness(1.0F).blastResistence(5.0F).create());

		register(builder("Oak Door", MATERIAL_WOOD_KEY)                                 .id(new BlockId(64, 0)).hardness(3.0F).blastResistence(15.0F).create());

		register(builder("Ladder", MATERIAL_CIRCUITS_KEY)                               .id(new BlockId(65, 0)).hardness(0.4F).blastResistence(2.0F).create());
		register(builder("Rail", MATERIAL_CIRCUITS_KEY)                                 .id(new BlockId(66, 0)).hardness(0.7F).blastResistence(3.5F).create());

		register(builder("Cobblestone Stairs", MATERIAL_ROCK_KEY)                       .id(new BlockId(67, 0)).hardness(2.0F).blastResistence(30.0F).create());

		register(builder("Wall Sign", MATERIAL_WOOD_KEY)                                .id(new BlockId(68, 0)).hardness(1.0F).blastResistence(5.0F).create());
		register(builder("Lever", MATERIAL_CIRCUITS_KEY)                                .id(new BlockId(69, 0)).hardness(0.5F).blastResistence(2.5F).create());
		register(builder("Stone Pressure Plate", MATERIAL_ROCK_KEY)                     .id(new BlockId(70, 0)).hardness(0.5F).blastResistence(2.5F).create());
		register(builder("Iron Door", MATERIAL_IRON_KEY)                                .id(new BlockId(71, 0)).hardness(5.0F).blastResistence(25.0F).create());
		register(builder("Wooden Pressure Plate", MATERIAL_WOOD_KEY)                    .id(new BlockId(72, 0)).hardness(0.5F).blastResistence(2.5F).create());
		register(builder("Redstone Ore", MATERIAL_ROCK_KEY)                             .id(new BlockId(73, 0)).hardness(3.0F).blastResistence(15.0F).create());
		register(builder("Glowing Redstone Ore", MATERIAL_ROCK_KEY)                     .id(new BlockId(74, 0)).hardness(3.0F).blastResistence(15.0F).create());
		register(builder("Redstone Torch", MATERIAL_CIRCUITS_KEY)                       .id(new BlockId(75, 0)).create());
		register(builder("Active Redstone Torch", MATERIAL_CIRCUITS_KEY)                .id(new BlockId(76, 0)).create());
		register(builder("Stone Button", MATERIAL_CIRCUITS_KEY)                         .id(new BlockId(77, 0)).hardness(0.5F).blastResistence(2.5F).create());
		register(builder("Snow Layer", MATERIAL_SNOW_KEY)                               .id(new BlockId(78, 0)).hardness(0.1F).blastResistence(0.5F).create());
		register(builder("Ice", MATERIAL_ICE_KEY)                                       .id(new BlockId(79, 0)).hardness(0.5F).blastResistence(2.5F).create());
		register(builder("Snow", MATERIAL_CRAFTEDSNOW_KEY)                              .id(new BlockId(80, 0)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Cactus", MATERIAL_CACTUS_KEY)                                 .id(new BlockId(81, 0)).hardness(0.4F).blastResistence(2.0F).create());
		register(builder("Clay", MATERIAL_CLAY_KEY)                                     .id(new BlockId(82, 0)).hardness(0.6F).blastResistence(3.0F).create());
		register(builder("Sugar Cane", MATERIAL_PLANTS_KEY)                             .id(new BlockId(83, 0)).create());
		register(builder("Jukebox", MATERIAL_WOOD_KEY)                                  .id(new BlockId(84, 0)).hardness(2.0F).blastResistence(30.0F).create());
		register(builder("Fence", MATERIAL_WOOD_KEY)                                    .id(new BlockId(85, 0)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Pumpkin", MATERIAL_GOURD_KEY)                                 .id(new BlockId(86, 0)).hardness(1.0F).blastResistence(5.0F).create());
		register(builder("Netherrack", MATERIAL_ROCK_KEY)                               .id(new BlockId(87, 0)).hardness(0.4F).blastResistence(2.0F).create());

		register(builder("Soul Sand", MATERIAL_SAND_KEY)                                .id(new BlockId(88, 0)).hardness(0.5F).blastResistence(2.5F).friction(0.4F).create());

		register(builder("Glowstone", MATERIAL_GLASS_KEY)                               .id(new BlockId(89, 0)).hardness(0.3F).blastResistence(1.5F).create());
		register(builder("Nether Portal", MATERIAL_PORTAL_KEY)                          .id(new BlockId(90, 0)).create());
		register(builder("Jack o'Lantern", MATERIAL_GOURD_KEY)                          .id(new BlockId(91, 0)).hardness(1.0F).blastResistence(5.0F).create());
		register(builder("Cake", MATERIAL_CAKE_KEY)                                     .id(new BlockId(92, 0)).hardness(0.5F).blastResistence(2.5F).create());
		register(builder("Redstone Repeater", MATERIAL_CIRCUITS_KEY)                    .id(new BlockId(93, 0)).create());
		register(builder("Powered Redstone Repeater", MATERIAL_CIRCUITS_KEY)            .id(new BlockId(94, 0)).create());

		//stain glass TODO: Colours
		register(builder("Stained Glass", MATERIAL_GLASS_KEY)                           .id(new BlockId(95, 0)).hardness(0.3F).blastResistence(1.5F).create());
		register(builder("Stained Glass", MATERIAL_GLASS_KEY)                           .id(new BlockId(95, 1)).hardness(0.3F).blastResistence(1.5F).create());
		register(builder("Stained Glass", MATERIAL_GLASS_KEY)                           .id(new BlockId(95, 2)).hardness(0.3F).blastResistence(1.5F).create());
		register(builder("Stained Glass", MATERIAL_GLASS_KEY)                           .id(new BlockId(95, 3)).hardness(0.3F).blastResistence(1.5F).create());
		register(builder("Stained Glass", MATERIAL_GLASS_KEY)                           .id(new BlockId(95, 4)).hardness(0.3F).blastResistence(1.5F).create());
		register(builder("Stained Glass", MATERIAL_GLASS_KEY)                           .id(new BlockId(95, 5)).hardness(0.3F).blastResistence(1.5F).create());
		register(builder("Stained Glass", MATERIAL_GLASS_KEY)                           .id(new BlockId(95, 6)).hardness(0.3F).blastResistence(1.5F).create());
		register(builder("Stained Glass", MATERIAL_GLASS_KEY)                           .id(new BlockId(95, 7)).hardness(0.3F).blastResistence(1.5F).create());
		register(builder("Stained Glass", MATERIAL_GLASS_KEY)                           .id(new BlockId(95, 8)).hardness(0.3F).blastResistence(1.5F).create());
		register(builder("Stained Glass", MATERIAL_GLASS_KEY)                           .id(new BlockId(95, 9)).hardness(0.3F).blastResistence(1.5F).create());
		register(builder("Stained Glass", MATERIAL_GLASS_KEY)                           .id(new BlockId(95, 10)).hardness(0.3F).blastResistence(1.5F).create());
		register(builder("Stained Glass", MATERIAL_GLASS_KEY)                           .id(new BlockId(95, 11)).hardness(0.3F).blastResistence(1.5F).create());
		register(builder("Stained Glass", MATERIAL_GLASS_KEY)                           .id(new BlockId(95, 12)).hardness(0.3F).blastResistence(1.5F).create());
		register(builder("Stained Glass", MATERIAL_GLASS_KEY)                           .id(new BlockId(95, 13)).hardness(0.3F).blastResistence(1.5F).create());
		register(builder("Stained Glass", MATERIAL_GLASS_KEY)                           .id(new BlockId(95, 14)).hardness(0.3F).blastResistence(1.5F).create());
		register(builder("Stained Glass", MATERIAL_GLASS_KEY)                           .id(new BlockId(95, 15)).hardness(0.3F).blastResistence(1.5F).create());

		register(builder("Trapdoor", MATERIAL_WOOD_KEY)                                 .id(new BlockId(96, 0)).hardness(3.0F).blastResistence(15.0F).create());
		register(builder("Monster Egg", MATERIAL_DRAGONEGG_KEY)                         .id(new BlockId(97, 0)).hardness(0.75F).blastResistence(3.75F).create());
		register(builder("Stone Bricks", MATERIAL_REDSTONELIGHT_KEY)                    .id(new BlockId(98, 0)).hardness(1.5F).blastResistence(30.0F).create());
		register(builder("Mossy Stone Bricks", MATERIAL_REDSTONELIGHT_KEY)              .id(new BlockId(98, 1)).hardness(1.5F).blastResistence(30.0F).create());
		register(builder("Cracked Stone Bricks", MATERIAL_REDSTONELIGHT_KEY)            .id(new BlockId(98, 2)).hardness(1.5F).blastResistence(30.0F).create());
		register(builder("Chiseled Stone Bricks", MATERIAL_REDSTONELIGHT_KEY)           .id(new BlockId(98, 3)).hardness(1.5F).blastResistence(30.0F).create());

		//mushroom blocks
		register(builder("Brown Mushroom Block", MATERIAL_WOOD_KEY)                     .id(new BlockId(99, 0)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Red Mushroom Block", MATERIAL_WOOD_KEY)                       .id(new BlockId(100, 0)).hardness(0.2F).blastResistence(1.0F).create());


		//wooden slab
		register(builder("Double Oak Wood Slab", MATERIAL_WOOD_KEY)                     .id(new BlockId(125, 0)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Double Spruce Wood Slab", MATERIAL_WOOD_KEY)                  .id(new BlockId(125, 1)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Double Birch Wood Slab", MATERIAL_WOOD_KEY)                   .id(new BlockId(125, 2)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Double Jungle Wood Slab", MATERIAL_WOOD_KEY)                  .id(new BlockId(125, 3)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Double Acacia Wood Slab", MATERIAL_WOOD_KEY)                  .id(new BlockId(125, 4)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Double Dark Oak Wood Slab", MATERIAL_WOOD_KEY)                .id(new BlockId(125, 5)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Oak Wood Slab", MATERIAL_WOOD_KEY)                            .id(new BlockId(125, 0)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Spruce Wood Slab", MATERIAL_WOOD_KEY)                         .id(new BlockId(125, 1)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Birch Wood Slab", MATERIAL_WOOD_KEY)                          .id(new BlockId(125, 2)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Jungle Wood Slab", MATERIAL_WOOD_KEY)                         .id(new BlockId(125, 3)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Acacia Wood Slab", MATERIAL_WOOD_KEY)                         .id(new BlockId(125, 4)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Dark Oak Wood Slab", MATERIAL_WOOD_KEY)                       .id(new BlockId(125, 5)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Upper Oak Wood Slab", MATERIAL_WOOD_KEY)                      .id(new BlockId(126, 8)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Upper Spruce Wood Slab", MATERIAL_WOOD_KEY)                   .id(new BlockId(126, 9)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Upper Birch Wood Slab", MATERIAL_WOOD_KEY)                    .id(new BlockId(126, 10)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Upper Jungle Wood Slab", MATERIAL_WOOD_KEY)                   .id(new BlockId(126, 11)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Upper Acacia Wood Slab", MATERIAL_WOOD_KEY)                   .id(new BlockId(126, 12)).hardness(2.0F).blastResistence(15.0F).create());
		register(builder("Upper Dark Oak Wood Slab", MATERIAL_WOOD_KEY)                 .id(new BlockId(126, 13)).hardness(2.0F).blastResistence(15.0F).create());

		//more chronic
		register(builder("Acacia Leaves", MATERIAL_REDSTONELIGHT_KEY)                   .id(new BlockId(161, 0)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Dark Oak Leaves", MATERIAL_REDSTONELIGHT_KEY)                 .id(new BlockId(161, 1)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Acacia Leaves", MATERIAL_REDSTONELIGHT_KEY)                   .id(new BlockId(161, 4)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Dark Oak Leaves", MATERIAL_REDSTONELIGHT_KEY)                 .id(new BlockId(161, 5)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Acacia Leaves", MATERIAL_REDSTONELIGHT_KEY)                   .id(new BlockId(161, 8)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Dark Oak Leaves", MATERIAL_REDSTONELIGHT_KEY)                 .id(new BlockId(161, 9)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Acacia Leaves", MATERIAL_REDSTONELIGHT_KEY)                   .id(new BlockId(161, 12)).hardness(0.2F).blastResistence(1.0F).create());
		register(builder("Dark Oak Leaves", MATERIAL_REDSTONELIGHT_KEY)                 .id(new BlockId(161, 13)).hardness(0.2F).blastResistence(1.0F).create());

		//more logs
		register(builder("Acacia", MATERIAL_REDSTONELIGHT_KEY)                          .id(new BlockId(162, 0)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Dark Oak", MATERIAL_REDSTONELIGHT_KEY)                        .id(new BlockId(162, 1)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Acacia", MATERIAL_REDSTONELIGHT_KEY)                          .id(new BlockId(162, 4)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Dark Oak", MATERIAL_REDSTONELIGHT_KEY)                        .id(new BlockId(162, 5)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Acacia", MATERIAL_REDSTONELIGHT_KEY)                          .id(new BlockId(162, 8)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Dark Oak", MATERIAL_REDSTONELIGHT_KEY)                        .id(new BlockId(162, 9)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Acacia", MATERIAL_REDSTONELIGHT_KEY)                          .id(new BlockId(162, 12)).hardness(2.0F).blastResistence(10.0F).create());
		register(builder("Dark Oak", MATERIAL_REDSTONELIGHT_KEY)                        .id(new BlockId(162, 13)).hardness(2.0F).blastResistence(10.0F).create());

		//more plants
		register(builder("Sunflower", MATERIAL_REDSTONELIGHT_KEY)                       .id(new BlockId(175, 0)).create());
		register(builder("Lilac", MATERIAL_REDSTONELIGHT_KEY)                           .id(new BlockId(175, 1)).create());
		register(builder("Tall Grass", MATERIAL_REDSTONELIGHT_KEY)                      .id(new BlockId(175, 2)).create());
		register(builder("Large Fern", MATERIAL_REDSTONELIGHT_KEY)                      .id(new BlockId(175, 3)).create());
		register(builder("Rose Bush", MATERIAL_REDSTONELIGHT_KEY)                       .id(new BlockId(175, 4)).create());
		register(builder("Peony", MATERIAL_REDSTONELIGHT_KEY)                           .id(new BlockId(175, 5)).create());

		register(builder("Double Red Sandstone Slab", MATERIAL_ROCK_KEY)                .id(new BlockId(181, 0)).create());
		register(builder("Smooth Double Red Sandstone Slab", MATERIAL_ROCK_KEY)         .id(new BlockId(181, 8)).create());
		//@formatter:on
	}

	protected Builder builder(String name, String material) {
		return new Builder().name(name).material(worldProvider.getMaterialRegistry().getByKey(material.toUpperCase())).maxStack(64).friction(0.6F);
	}
}