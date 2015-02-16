package org.topdank.minenet.api.world.block.provider.registry;

import org.topdank.minenet.api.game.BoundingBox;
import org.topdank.minenet.api.world.block.id.BlockId;
import org.topdank.minenet.api.world.block.provider.registry.BlockData.BoundingBoxStatePair;
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
	// private static final String MATERIAL_CORAL_KEY = "CORAL";
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

	private boolean registered = false;

	@Override
	public void register() {
		if (registered)
			return;
		registered = true;

		//@formatter:off
		register("Air", MATERIAL_AIR_KEY, 0.0F, 0.0F, false, null, 0);

		register("Stone", MATERIAL_ROCK_KEY, 1.5F, 30.0F, new int[]{16,17,18,19,20,21,22});
		register("Grass", MATERIAL_GRASS_KEY, 0.6F, 3.0F, 32);
		register("Dirt", MATERIAL_GROUND_KEY, 0.5F, 2.5F, new int[] { 48, 49, 50 });
		register("Cobblestone", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 64 });
		register("Wooden Planks", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 80, 81, 82, 83, 84, 85 });

		register("Sappling", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, false, BoundingBox.create(0.1F, 0, 0.1F, 0.9F, 0.8F, 0.9F), new int[] { 96, 97, 98, 99, 100, 101, 104, 105, 106, 107, 108, 109 });

		register("Bedrock", MATERIAL_ROCK_KEY, -1.0F, 1.8E7F, new int[] { 112 });

		register("Water", MATERIAL_WATER_KEY, 100.0F, 500.0F, new int[] { 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143 });

		register("Water", MATERIAL_WATER_KEY, 100.0F, 500.0F, new int[] { 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159 });
		register("Lava", MATERIAL_LAVA_KEY, 100.0F, 500.0F, new int[] { 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175 });

		register("Lava", MATERIAL_LAVA_KEY, 100.0F, 500.0F, new int[] { 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191 });

		register("Sand", MATERIAL_SAND_KEY, 0.5F, 2.5F, new int[] { 192, 193 });
		register("Gravel", MATERIAL_SAND_KEY, 0.6F, 3.0F, new int[] { 208 });
		register("Gold Ore", MATERIAL_ROCK_KEY, 3.0F, 15.0F, new int[] { 224 });
		register("Iron Ore", MATERIAL_ROCK_KEY, 3.0F, 15.0F, new int[] { 240 });
		register("Coal Ore", MATERIAL_ROCK_KEY, 3.0F, 15.0F, new int[] { 256 });
		register("Wood", MATERIAL_WOOD_KEY, 2.0F, 10.0F, new int[] { 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 286, 287 });
		register("Leaves", MATERIAL_LEAVES_KEY, 0.2F, 1.0F, new int[] { 288, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300, 301, 302, 303 });
		register("tile.sponge.name", MATERIAL_SPONGE_KEY, 0.6F, 3.0F, new int[] { 304, 305 });
		register("Glass", MATERIAL_GLASS_KEY, 0.3F, 1.5F, new int[] { 320 });
		register("Lapis Lazuli Ore", MATERIAL_ROCK_KEY, 3.0F, 15.0F, new int[] { 336 });
		register("Lapis Lazuli Block", MATERIAL_IRON_KEY, 3.0F, 15.0F, new int[] { 352 });
		register("Dispenser", MATERIAL_ROCK_KEY, 3.5F, 17.5F, new int[] { 368, 369, 370, 371, 372, 373, 376, 377, 378, 379, 380, 381 });
		register("Sandstone", MATERIAL_ROCK_KEY, 0.8F, 4.0F, new int[] { 384, 385, 386 });
		register("Note Block", MATERIAL_WOOD_KEY, 0.8F, 4.0F, new int[] { 400 });
		register("Bed", MATERIAL_CLOTH_KEY, 0.2F, 1.0F, new int[] { 416, 417, 418, 419, 424, 425, 426, 427, 428, 429, 430, 431 });

		BoundingBox railBB = BoundingBox.create(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		railBB = null;
		register("Powered Rail", MATERIAL_CIRCUITS_KEY, 0.7F, 3.5F, false, railBB, new int[] { 432, 433, 434, 435, 436, 437, 440, 441, 442, 443, 444, 445 });
		register("Detector Rail", MATERIAL_CIRCUITS_KEY, 0.7F, 3.5F, false, railBB, new int[] { 448, 449, 450, 451, 452, 453, 456, 457, 458, 459, 460, 461 });
		register("Sticky Piston", MATERIAL_PISTON_KEY, 0.5F, 2.5F, false, railBB, new int[] { 464, 465, 466, 467, 468, 469, 472, 473, 474, 475, 476, 477 });

		register("Cobweb", MATERIAL_WEB_KEY, 4.0F, 20.0F, new int[] { 480 });


		register("Grass", MATERIAL_VINE_KEY, 0.0F, 0.0F, BoundingBox.create(0.1F, 0.0F, 0.1F, 0.9F, 0.8F, 0.9F), new int[] { 496, 497, 498 });
		register("Dead Bush", MATERIAL_VINE_KEY, 0.0F, 0.0F, false, BoundingBox.create(0.1F, 0.0F, 0.1F, 0.9F, 0.8F, 0.9F), new int[] { 512 });

		register("Sticky Piston", MATERIAL_PISTON_KEY, 0.5F, 2.5F, new int[] { 528, 529, 530, 531, 532, 533, 536, 537, 538, 539, 540, 541 });
		register("Piston", MATERIAL_PISTON_KEY, 0.5F, 2.5F, new int[] { 544, 545, 546, 547, 548, 549, 552, 553, 554, 555, 556, 557 });
		register("Wool", MATERIAL_CLOTH_KEY, 0.8F, 4.0F, new int[] { 560, 561, 562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575 });
		register("Piston Head", MATERIAL_PISTON_KEY, -1.0F, 0.0F, new int[] { 576, 577, 578, 579, 580, 581, 584, 585, 586, 587, 588, 589 });

        BoundingBox flowerBb = BoundingBox.create(0.3F, 0F, 0.3F, 0.7F, 0.6F, 0.7F);
        flowerBb = null;
		register("Yellow Flower", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, false, flowerBb,new int[] { 592 });
		register("Red Flower", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, false, flowerBb, new int[] { 608, 609, 610, 611, 612, 613, 614, 615, 616 });

        BoundingBox mushroomBb = BoundingBox.create(0.3F, 0F, 0.3F, 0.7F, 0.6F, 0.7F);
        mushroomBb = null;
		register("Brown Mushroom", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, false, mushroomBb, new int[] { 624 });
		register("Red Mushroom", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, false, mushroomBb, new int[] { 640 });

		register("Block of Gold", MATERIAL_IRON_KEY, 3.0F, 30.0F, new int[] { 656 });
		register("Block of Iron", MATERIAL_IRON_KEY, 5.0F, 30.0F, new int[] { 672 });

		register("Double Stone Slab", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 688, 689, 690, 691, 692, 693, 694, 695, 696, 697, 698, 699, 700, 701, 702, 703 });
		registerSlabs("Stone Slab", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 704, 705, 706, 707, 708, 709, 710, 711, 712, 713, 714, 715, 716, 717, 718, 719 });

		register("Bricks", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 720 });
		register("TNT", MATERIAL_TNT_KEY, 0.0F, 0.0F, new int[] { 736, 737 });
		register("Bookshelf", MATERIAL_WOOD_KEY, 1.5F, 7.5F, new int[] { 752 });
		register("Moss Stone", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 768 });
		register("Obsidian", MATERIAL_ROCK_KEY, 50.0F, 6000.0F, new int[] { 784 });

		register("Torch", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, false, null, new int[] { 801, 802, 803, 804, 805 });

		register("Fire", MATERIAL_FIRE_KEY, 0.0F, 0.0F, false, null, new int[] { 816, 817, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 828, 829, 830, 831 });

		register("Monster Spawner", MATERIAL_ROCK_KEY, 5.0F, 25.0F, new int[] { 832 });

		//TODO: calculate at runtime
		register("Oak Wood Stairs", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 848, 849, 850, 851, 852, 853, 854, 855 });

		register("Chest", MATERIAL_WOOD_KEY, 2.5F, 12.5F, BoundingBox.create(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F), new int[] { 866, 867, 868, 869 });

		register("Redstone Dust", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, null, new int[] { 880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 892, 893, 894, 895 });

		register("Diamond Ore", MATERIAL_ROCK_KEY, 3.0F, 15.0F, new int[] { 896 });
		register("Block of Diamond", MATERIAL_IRON_KEY, 5.0F, 30.0F, new int[] { 912 });

		register("Crafting Table", MATERIAL_WOOD_KEY, 2.5F, 12.5F, new int[] { 928 });

		register("Crops", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, false, BoundingBox.create(0F, 0.0F, 0F, 1F, 0.25F, 1F), new int[] { 944, 945, 946, 947, 948, 949, 950, 951 });

		register("Farmland", MATERIAL_GROUND_KEY, 0.6F, 3.0F, BoundingBox.create(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F), new int[] { 960, 961, 962, 963, 964, 965, 966, 967 });

		register("Furnace", MATERIAL_ROCK_KEY, 3.5F, 17.5F, new int[] { 978, 979, 980, 981 });
		register("Furnace", MATERIAL_ROCK_KEY, 3.5F, 17.5F, new int[] { 994, 995, 996, 997 });

		register("Sign", MATERIAL_WOOD_KEY, 1.0F, 5.0F, false, null, new int[] { 1008, 1009, 1010, 1011, 1012, 1013, 1014, 1015, 1016, 1017, 1018, 1019, 1020, 1021, 1022, 1023 });

		register("Oak Door", MATERIAL_WOOD_KEY, 3.0F, 15.0F, new BoundingBoxStatePair[]{
				new BoundingBoxStatePair(1024, calcDoorBounds(1024)),
				new BoundingBoxStatePair(1025, calcDoorBounds(1025)),
				new BoundingBoxStatePair(1026, calcDoorBounds(1026)),
				new BoundingBoxStatePair(1027, calcDoorBounds(1027)),
				new BoundingBoxStatePair(1028, calcDoorBounds(1028)),
				new BoundingBoxStatePair(1029, calcDoorBounds(1029)),
				new BoundingBoxStatePair(1030, calcDoorBounds(1030)),
				new BoundingBoxStatePair(1031, calcDoorBounds(1031)),
				new BoundingBoxStatePair(1032, calcDoorBounds(1032)),
				new BoundingBoxStatePair(1033, calcDoorBounds(1033)),
				new BoundingBoxStatePair(1034, calcDoorBounds(1035)),
				new BoundingBoxStatePair(1035, calcDoorBounds(1036))
		});

		register("Ladder", MATERIAL_CIRCUITS_KEY, 0.4F, 2.0F, new BoundingBoxStatePair[]{
				new BoundingBoxStatePair(1042, calcLadderBounds(1042)),
				new BoundingBoxStatePair(1043, calcLadderBounds(1043)),
				new BoundingBoxStatePair(1044, calcLadderBounds(1044)),
				new BoundingBoxStatePair(1045, calcLadderBounds(1045)),
		});

		register("Rail", MATERIAL_CIRCUITS_KEY, 0.7F, 3.5F, false, railBB, new int[] { 1056, 1057, 1058, 1059, 1060, 1061, 1062, 1063, 1064, 1065 });

		//TODO: calculate at runtime
		register("Cobblestone Stairs", MATERIAL_ROCK_KEY, 2.0F, 30.0F, null, new int[] { 1072, 1073, 1074, 1075, 1076, 1077, 1078, 1079 });

		register("Sign", MATERIAL_WOOD_KEY, 1.0F, 5.0F, false, null, new int[] { 1090, 1091, 1092, 1093 });

		register("Lever", MATERIAL_CIRCUITS_KEY, 0.5F, 2.5F, false, null, new int[] { 1104, 1105, 1106, 1107, 1108, 1109, 1110, 1111, 1112, 1113, 1114, 1115, 1116, 1117, 1118, 1119 });
		register("Stone Pressure Plate", MATERIAL_ROCK_KEY, 0.5F, 2.5F, false, null, new int[] { 1120, 1121 });

		//TODO: calculate at runtime
		register("Iron Door", MATERIAL_IRON_KEY, 5.0F, 25.0F, null, new int[] { 1136, 1137, 1138, 1139, 1140, 1141, 1142, 1143, 1144, 1145, 1146, 1147 });

		register("Wooden Pressure Plate", MATERIAL_WOOD_KEY, 0.5F, 2.5F, false, null, new int[] { 1152, 1153 });

		register("Redstone Ore", MATERIAL_ROCK_KEY, 3.0F, 15.0F, new int[] { 1168 });
		register("Redstone Ore", MATERIAL_ROCK_KEY, 3.0F, 15.0F, new int[] { 1184 });

		register("Redstone Torch", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, null, new int[] { 1201, 1202, 1203, 1204, 1205 });
		register("Redstone Torch", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, null, new int[] { 1217, 1218, 1219, 1220, 1221 });

		register("Button", MATERIAL_CIRCUITS_KEY, 0.5F, 2.5F, false, null, new int[] { 1232, 1233, 1234, 1235, 1236, 1237, 1240, 1241, 1242, 1243, 1244, 1245 });

		BoundingBox snowLayerBb = BoundingBox.create(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		register("Snow", MATERIAL_SNOW_KEY, 0.1F, 0.5F, false, new BoundingBoxStatePair[]{
				new BoundingBoxStatePair(1248, snowLayerBb),
				new BoundingBoxStatePair(1249, snowLayerBb = snowLayerBb.offset(0F, 0.125F, 0F)),
				new BoundingBoxStatePair(1250, snowLayerBb = snowLayerBb.offset(0F, 0.125F, 0F)),
				new BoundingBoxStatePair(1251, snowLayerBb = snowLayerBb.offset(0F, 0.125F, 0F)),
				new BoundingBoxStatePair(1252, snowLayerBb = snowLayerBb.offset(0F, 0.125F, 0F)),
				new BoundingBoxStatePair(1253, snowLayerBb = snowLayerBb.offset(0F, 0.125F, 0F)),
				new BoundingBoxStatePair(1254, snowLayerBb = snowLayerBb.offset(0F, 0.125F, 0F)),
				new BoundingBoxStatePair(1255, snowLayerBb = snowLayerBb.offset(0F, 0.125F, 0F))
		});

		register("Ice", MATERIAL_ICE_KEY, 0.5F, 2.5F, new int[] { 1264 });
		register("Snow", MATERIAL_CRAFTEDSNOW_KEY, 0.2F, 1.0F, new int[] { 1280 });
		register("Cactus", MATERIAL_CACTUS_KEY, 0.4F, 2.0F, BoundingBox.create(0.0625F, 0F, 0.0625F, 0.9375F, 1F, 0.9375F), new int[] { 1296, 1297, 1298, 1299, 1300, 1301, 1302, 1303, 1304, 1305, 1306, 1307, 1308, 1309, 1310, 1311 });

		register("Clay", MATERIAL_CLAY_KEY, 0.6F, 3.0F, new int[] { 1312 });
		register("Sugar cane", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, false, BoundingBox.create(0.125F, 0F, 0.125F, 0.875F, 1F, 0.875F), new int[] { 1328, 1329, 1330, 1331, 1332, 1333, 1334, 1335, 1336, 1337, 1338, 1339, 1340, 1341, 1342, 1343 });
		register("Jukebox", MATERIAL_WOOD_KEY, 2.0F, 30.0F, new int[] { 1344, 1345 });

		//TODO: calculate at runtime
		register("Oak Fence", MATERIAL_WOOD_KEY, 2.0F, 15.0F, null, new int[] { 1360 });

		register("Pumpkin", MATERIAL_GOURD_KEY, 1.0F, 5.0F, new int[] { 1376, 1377, 1378, 1379 });
		register("Netherrack", MATERIAL_ROCK_KEY, 0.4F, 2.0F, new int[] { 1392 });

		register("Soul Sand", MATERIAL_SAND_KEY, 0.5F, 2.5F, BoundingBox.create(0F, 0F, 0F, 1F, 0.875F, 1F), new int[]{1408});

		register("Glowstone", MATERIAL_GLASS_KEY, 0.3F, 1.5F, new int[] { 1424 });

		register("Portal", MATERIAL_PORTAL_KEY, -1.0F, 0.0F, null, new int[] { 1441, 1442 });

		register("Jack o'Lantern", MATERIAL_GOURD_KEY, 1.0F, 5.0F, new int[] { 1456, 1457, 1458, 1459 });

		register("Cake", MATERIAL_CAKE_KEY, 0.5F, 2.5F, new BoundingBoxStatePair[]{
				new BoundingBoxStatePair(1472, calcCakeBounds(1472)),
				new BoundingBoxStatePair(1473, calcCakeBounds(1473)),
				new BoundingBoxStatePair(1474, calcCakeBounds(1474)),
				new BoundingBoxStatePair(1475, calcCakeBounds(1475)),
				new BoundingBoxStatePair(1476, calcCakeBounds(1476)),
				new BoundingBoxStatePair(1477, calcCakeBounds(1477)),
				new BoundingBoxStatePair(1478, calcCakeBounds(1478)),
		});

		BoundingBox repeaterBb = BoundingBox.create(0F, 0F, 0F, 1F, 0.125F, 1F);
		register("Repeater", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, false, repeaterBb, new int[] { 1488, 1489, 1490, 1491, 1492, 1493, 1494, 1495, 1496, 1497, 1498, 1499, 1500, 1501, 1502, 1503 });
		register("Repeater", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, false, repeaterBb, new int[] { 1504, 1505, 1506, 1507, 1508, 1509, 1510, 1511, 1512, 1513, 1514, 1515, 1516, 1517, 1518, 1519 });

		register("Stained Glass", MATERIAL_GLASS_KEY, 0.3F, 1.5F, new int[] { 1520, 1521, 1522, 1523, 1524, 1525, 1526, 1527, 1528, 1529, 1530, 1531, 1532, 1533, 1534, 1535 });

		register("Wooden Trapdoor", MATERIAL_WOOD_KEY, 3.0F, 15.0F, new BoundingBoxStatePair[]{
				new BoundingBoxStatePair(1536, calcTrapdoorBounds(1536)),
				new BoundingBoxStatePair(1537, calcTrapdoorBounds(1537)),
				new BoundingBoxStatePair(1538, calcTrapdoorBounds(1538)),
				new BoundingBoxStatePair(1539, calcTrapdoorBounds(1539)),
				new BoundingBoxStatePair(1540, calcTrapdoorBounds(1540)),
				new BoundingBoxStatePair(1541, calcTrapdoorBounds(1541)),
				new BoundingBoxStatePair(1542, calcTrapdoorBounds(1542)),
				new BoundingBoxStatePair(1543, calcTrapdoorBounds(1543)),
				new BoundingBoxStatePair(1544, calcTrapdoorBounds(1544)),
				new BoundingBoxStatePair(1545, calcTrapdoorBounds(1545)),
				new BoundingBoxStatePair(1546, calcTrapdoorBounds(1546)),
				new BoundingBoxStatePair(1547, calcTrapdoorBounds(1547)),
				new BoundingBoxStatePair(1548, calcTrapdoorBounds(1548)),
				new BoundingBoxStatePair(1549, calcTrapdoorBounds(1549)),
				new BoundingBoxStatePair(1550, calcTrapdoorBounds(1550)),
				new BoundingBoxStatePair(1551, calcTrapdoorBounds(1551)),
		});

		register("Stone Monster Egg", MATERIAL_CLAY_KEY, 0.75F, 3.75F, new int[] { 1552, 1553, 1554, 1555, 1556, 1557 });
		register("Stone Bricks", MATERIAL_ROCK_KEY, 1.5F, 30.0F, new int[] { 1568, 1569, 1570, 1571 });
		register("Brown Mushtree", MATERIAL_WOOD_KEY, 0.2F, 1.0F, new int[] { 1584, 1585, 1586, 1587, 1588, 1589, 1590, 1591, 1592, 1593, 1594, 1598, 1599 });
		register("Red Mushtree", MATERIAL_WOOD_KEY, 0.2F, 1.0F, new int[] { 1600, 1601, 1602, 1603, 1604, 1605, 1606, 1607, 1608, 1609, 1610, 1614, 1615 });

		//TODO: calculate at runtime
		register("Iron Bars", MATERIAL_IRON_KEY, 5.0F, 30.0F, new int[] { 1616 });
		register("Glass Pane", MATERIAL_GLASS_KEY, 0.3F, 1.5F, null, new int[] { 1632 });

		register("Melon", MATERIAL_GOURD_KEY, 1.0F, 5.0F, new int[] { 1648 });
		register("Pumpkin Stem", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, new int[] { 1664, 1665, 1666, 1667, 1668, 1669, 1670, 1671 });
		register("Melon Stem", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, new int[] { 1680, 1681, 1682, 1683, 1684, 1685, 1686, 1687 });

		register("Vines", MATERIAL_VINE_KEY, 0.2F, 1.0F, null, new int[] { 1696, 1697, 1698, 1699, 1700, 1701, 1702, 1703, 1704, 1705, 1706, 1707, 1708, 1709, 1710, 1711 });

		//TODO: calculate at runtime
		register("Oak Fence Gate", MATERIAL_WOOD_KEY, 2.0F, 15.0F, null, new int[] { 1712, 1713, 1714, 1715, 1716, 1717, 1718, 1719, 1720, 1721, 1722, 1723, 1724, 1725, 1726, 1727 });
		register("Brick Stairs", MATERIAL_ROCK_KEY, 2.0F, 30.0F, null, new int[] { 1728, 1729, 1730, 1731, 1732, 1733, 1734, 1735 });
		register("Stone Brick Stairs", MATERIAL_ROCK_KEY, 1.5F, 30.0F, null, new int[] { 1744, 1745, 1746, 1747, 1748, 1749, 1750, 1751 });

		register("Mycelium", MATERIAL_GRASS_KEY, 0.6F, 3.0F, new int[] { 1760 });

		//TODO: rethink?
		register("Lily Pad", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, BoundingBox.create(0F, 0.0F, 0F, 1F, 0.015625F, 1F), new int[] { 1776 });

		register("Nether Brick", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 1792 });

		//TODO: calculate at runtime
		register("Nether Brick Fence", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 1808 });
		register("Nether Brick Stairs", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 1824, 1825, 1826, 1827, 1828, 1829, 1830, 1831 });

		register("Nether Wart", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, false, null, new int[] { 1840, 1841, 1842, 1843 });

		register("Enchantment Table", MATERIAL_ROCK_KEY, 5.0F, 6000.0F, BoundingBox.create(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F), new int[] { 1856 });
		register("Brewing Stand", MATERIAL_IRON_KEY, 0.5F, 2.5F, BoundingBox.create(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F), new int[] { 1872, 1873, 1874, 1875, 1876, 1877, 1878, 1879 });
		register("Cauldron", MATERIAL_IRON_KEY, 2.0F, 10.0F, new int[] { 1888, 1889, 1890, 1891 });
		register("tile.null.name", MATERIAL_PORTAL_KEY, -1.0F, 1.8E7F, new int[] { 1904 });
		register("End Portal", MATERIAL_ROCK_KEY, -1.0F, 1.8E7F, null, new int[] { 1920, 1921, 1922, 1923, 1924, 1925, 1926, 1927 });
		register("End Stone", MATERIAL_ROCK_KEY, 3.0F, 45.0F, new int[] { 1936 });
		register("Dragon Egg", MATERIAL_DRAGONEGG_KEY, 3.0F, 45.0F, BoundingBox.create(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F), new int[] { 1952 });
		register("Redstone Lamp", MATERIAL_REDSTONELIGHT_KEY, 0.3F, 1.5F, new int[] { 1968 });
		register("Redstone Lamp", MATERIAL_REDSTONELIGHT_KEY, 0.3F, 1.5F, new int[] { 1984 });

		register("Double Wood Slab", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2000, 2001, 2002, 2003, 2004, 2005 });
		registerSlabs("Wood Slab", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2016, 2017, 2018, 2019, 2020, 2021, 2024, 2025, 2026, 2027, 2028, 2029 });

		register("Cocoa", MATERIAL_PLANTS_KEY, 0.2F, 15.0F, new BoundingBoxStatePair[]{
				new BoundingBoxStatePair(2032, calcCocoaBounds(2032)),
				new BoundingBoxStatePair(2033, calcCocoaBounds(2033)),
				new BoundingBoxStatePair(2034, calcCocoaBounds(2034)),
				new BoundingBoxStatePair(2035, calcCocoaBounds(2035)),
				new BoundingBoxStatePair(2036, calcCocoaBounds(2036)),
				new BoundingBoxStatePair(2037, calcCocoaBounds(2037)),
				new BoundingBoxStatePair(2038, calcCocoaBounds(2038)),
				new BoundingBoxStatePair(2039, calcCocoaBounds(2039)),
				new BoundingBoxStatePair(2040, calcCocoaBounds(2040)),
				new BoundingBoxStatePair(2041, calcCocoaBounds(2041)),
				new BoundingBoxStatePair(2042, calcCocoaBounds(2042)),
				new BoundingBoxStatePair(2043, calcCocoaBounds(2043))
		});

		//TODO: calculate at runtime
		register("Sandstone Stairs", MATERIAL_ROCK_KEY, 0.8F, 4.0F, new int[] { 2048, 2049, 2050, 2051, 2052, 2053, 2054, 2055 });

		register("Emerald Ore", MATERIAL_ROCK_KEY, 3.0F, 15.0F, new int[] { 2064 });

		register("Ender Chest", MATERIAL_ROCK_KEY, 22.5F, 3000.0F, BoundingBox.create(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F), new int[] { 2082, 2083, 2084, 2085 });

		//TODO: maybe full block so you don't set one off? further: redstone tracer and analyser? :D
		register("Tripwire Hook", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, false, null, new int[] { 2096, 2097, 2098, 2099, 2100, 2101, 2102, 2103, 2104, 2105, 2106, 2107, 2108, 2109, 2110, 2111 });
		register("Tripwire", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, false, null, new int[] { 2112, 2113, 2114, 2115, 2116, 2117, 2118, 2119, 2120, 2121, 2122, 2123, 2124, 2125, 2126, 2127 });

		register("Block of Emerald", MATERIAL_IRON_KEY, 5.0F, 30.0F, new int[] { 2128 });

		//TODO: calculate at runtime
		register("Spruce Wood Stairs", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2144, 2145, 2146, 2147, 2148, 2149, 2150, 2151 });
		register("Birch Wood Stairs", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2160, 2161, 2162, 2163, 2164, 2165, 2166, 2167 });
		register("Jungle Wood Stairs", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2176, 2177, 2178, 2179, 2180, 2181, 2182, 2183 });

		register("Command Block", MATERIAL_IRON_KEY, -1.0F, 1.8E7F, new int[] { 2192, 2193 });
		register("Beacon", MATERIAL_GLASS_KEY, 3.0F, 15.0F, new int[] { 2208 });

		//TODO: calculate at runtime
		register("Cobblestone Wall", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 2224, 2225 });

		register("Flower Pot", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, BoundingBox.create(0.3125F, 0F, 0.3125F, 0.6875F, 0.375F, 0.6875F), new int[] { 2240, 2241, 2242, 2243, 2244, 2245, 2246, 2247, 2248, 2249, 2250, 2251, 2252, 2253, 2254, 2255 });
		register("Carrots", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, false, null, new int[] { 2256, 2257, 2258, 2259, 2260, 2261, 2262, 2263 });
		register("Potatoes", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, false, null, new int[] { 2272, 2273, 2274, 2275, 2276, 2277, 2278, 2279 });
		register("Button", MATERIAL_CIRCUITS_KEY, 0.5F, 2.5F, false, null, new int[] { 2288, 2289, 2290, 2291, 2292, 2293, 2296, 2297, 2298, 2299, 2300, 2301 });
		register("Severed Head", MATERIAL_CIRCUITS_KEY, 1.0F, 5.0F, BoundingBox.create(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F), new int[] { 2304, 2305, 2306, 2307, 2308, 2309, 2312, 2313, 2314, 2315, 2316, 2317 });

		register("Anvil", MATERIAL_ANVIL_KEY, 5.0F, 6000.0F, new BoundingBoxStatePair[]{
				new BoundingBoxStatePair(2320, calcAnvilBounds(2320)),
				new BoundingBoxStatePair(2321, calcAnvilBounds(2321)),
				new BoundingBoxStatePair(2322, calcAnvilBounds(2322)),
				new BoundingBoxStatePair(2323, calcAnvilBounds(2323)),
				new BoundingBoxStatePair(2324, calcAnvilBounds(2324)),
				new BoundingBoxStatePair(2325, calcAnvilBounds(2325)),
				new BoundingBoxStatePair(2326, calcAnvilBounds(2326)),
				new BoundingBoxStatePair(2327, calcAnvilBounds(2327)),
				new BoundingBoxStatePair(2328, calcAnvilBounds(2328)),
				new BoundingBoxStatePair(2329, calcAnvilBounds(2329)),
				new BoundingBoxStatePair(2330, calcAnvilBounds(2330)),
				new BoundingBoxStatePair(2331, calcAnvilBounds(2331)),
		});

		register("Trapped Chest", MATERIAL_WOOD_KEY, 2.5F, 12.5F, BoundingBox.create(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F), new int[] { 2338, 2339, 2340, 2341 });
		register("Weighted Pressure Plate (Light)", MATERIAL_IRON_KEY, 0.5F, 2.5F,
				false, null, new int[] { 2352, 2353, 2354, 2355, 2356, 2357, 2358, 2359, 2360, 2361, 2362, 2363, 2364, 2365, 2366, 2367 });
		register("Weighted Pressure Plate (Heavy)", MATERIAL_IRON_KEY, 0.5F, 2.5F,
				false, null, new int[] { 2368, 2369, 2370, 2371, 2372, 2373, 2374, 2375, 2376, 2377, 2378, 2379, 2380, 2381, 2382, 2383 });
		register("Comparator", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, false, BoundingBox.create(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F), new int[] { 2384, 2385, 2386, 2387, 2388, 2389, 2390, 2391, 2392, 2393, 2394, 2395, 2396, 2397, 2398, 2399 });
		register("Comparator", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, false, BoundingBox.create(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F), new int[] { 2400, 2401, 2402, 2403, 2404, 2405, 2406, 2407, 2408, 2409, 2410, 2411, 2412, 2413, 2414, 2415 });
		register("Daylight Sensor", MATERIAL_WOOD_KEY, 0.2F, 1.0F, BoundingBox.create(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F), new int[] { 2416, 2417, 2418, 2419, 2420, 2421, 2422, 2423, 2424, 2425, 2426, 2427, 2428, 2429, 2430, 2431 });
		register("Block of Redstone", MATERIAL_IRON_KEY, 5.0F, 30.0F, new int[] { 2432 });
		register("Nether Quartz Ore", MATERIAL_ROCK_KEY, 3.0F, 15.0F, new int[] { 2448 });

		register("Hopper", MATERIAL_IRON_KEY, 3.0F, 24.0F, new int[] { 2464, 2466, 2467, 2468, 2469, 2472, 2474, 2475, 2476, 2477 });

		register("Block of Quartz", MATERIAL_ROCK_KEY, 0.8F, 4.0F, new int[] { 2480, 2481, 2482, 2483, 2484 });

		register("Quartz Stairs", MATERIAL_ROCK_KEY, 0.8F, 4.0F, new int[] { 2496, 2497, 2498, 2499, 2500, 2501, 2502, 2503 });

		register("Activator Rail", MATERIAL_CIRCUITS_KEY, 0.7F, 3.5F, false, railBB, new int[] { 2512, 2513, 2514, 2515, 2516, 2517, 2520, 2521, 2522, 2523, 2524, 2525 });

		register("Dropper", MATERIAL_ROCK_KEY, 3.5F, 17.5F, new int[] { 2528, 2529, 2530, 2531, 2532, 2533, 2536, 2537, 2538, 2539, 2540, 2541 });

		register("Stained Clay", MATERIAL_ROCK_KEY, 1.25F, 21.0F, new int[] { 2544, 2545, 2546, 2547, 2548, 2549, 2550, 2551, 2552, 2553, 2554, 2555, 2556, 2557, 2558, 2559 });

		//TODO: calculate at runtime
		register("Stained Glass Pane", MATERIAL_GLASS_KEY, 0.3F, 1.5F, null, new int[] { 2560, 2561, 2562, 2563, 2564, 2565, 2566, 2567, 2568, 2569, 2570, 2571, 2572, 2573, 2574, 2575 });

		register("Leaves", MATERIAL_LEAVES_KEY, 0.2F, 1.0F, new int[] { 2576, 2577, 2580, 2581, 2584, 2585, 2588, 2589 });
		register("Wood", MATERIAL_WOOD_KEY, 2.0F, 10.0F, new int[] { 2592, 2593, 2596, 2597, 2600, 2601, 2604, 2605 });

		//TODO: calculate at runtime
		register("Acacia Wood Stairs", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2608, 2609, 2610, 2611, 2612, 2613, 2614, 2615 });
		register("Dark Oak Wood Stairs", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2624, 2625, 2626, 2627, 2628, 2629, 2630, 2631 });

		register("Slime Block", MATERIAL_CLAY_KEY, 0.0F, 0.0F, new int[] { 2640 });

		register("Barrier", MATERIAL_BARRIER_KEY, -1.0F, 1.8000004E7F, new int[] { 2656 });

		register("Iron Trapdoor", MATERIAL_IRON_KEY, 5.0F, 25.0F, new BoundingBoxStatePair[]{
				new BoundingBoxStatePair(2672, calcTrapdoorBounds(2672)),
				new BoundingBoxStatePair(2673, calcTrapdoorBounds(2673)),
				new BoundingBoxStatePair(2674, calcTrapdoorBounds(2674)),
				new BoundingBoxStatePair(2675, calcTrapdoorBounds(2675)),
				new BoundingBoxStatePair(2676, calcTrapdoorBounds(2676)),
				new BoundingBoxStatePair(2677, calcTrapdoorBounds(2677)),
				new BoundingBoxStatePair(2678, calcTrapdoorBounds(2678)),
				new BoundingBoxStatePair(2679, calcTrapdoorBounds(2679)),
				new BoundingBoxStatePair(2680, calcTrapdoorBounds(2680)),
				new BoundingBoxStatePair(2681, calcTrapdoorBounds(2681)),
				new BoundingBoxStatePair(2682, calcTrapdoorBounds(2682)),
				new BoundingBoxStatePair(2683, calcTrapdoorBounds(2683)),
				new BoundingBoxStatePair(2684, calcTrapdoorBounds(2684)),
				new BoundingBoxStatePair(2685, calcTrapdoorBounds(2685)),
				new BoundingBoxStatePair(2686, calcTrapdoorBounds(2686)),
				new BoundingBoxStatePair(2687, calcTrapdoorBounds(2687))
		});

		register("Prismarine", MATERIAL_ROCK_KEY, 1.5F, 30.0F, new int[] { 2688, 2689, 2690 });
		register("Sea Lantern", MATERIAL_GLASS_KEY, 0.3F, 1.5F, new int[] { 2704 });
		register("Hay Bale", MATERIAL_GRASS_KEY, 0.5F, 2.5F, new int[] { 2720, 2724, 2728 });
		register("Carpet", MATERIAL_CARPET_KEY, 0.1F, 0.5F, false, BoundingBox.create(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F), new int[] { 2736, 2737, 2738, 2739, 2740, 2741, 2742, 2743, 2744, 2745, 2746, 2747, 2748, 2749, 2750, 2751 });
		register("Hardened Clay", MATERIAL_ROCK_KEY, 1.25F, 21.0F, new int[] { 2752 });
		register("Block of Coal", MATERIAL_ROCK_KEY, 5.0F, 30.0F, new int[] { 2768 });
		register("Packed Ice", MATERIAL_PACKEDICE_KEY, 0.5F, 2.5F, new int[] { 2784 });

		register("Plant", MATERIAL_VINE_KEY, 0.0F, 0.0F, false, null, new int[] { 2800, 2801, 2802, 2803, 2804, 2805, 2808 });

		register("Banner", MATERIAL_WOOD_KEY, 1.0F, 5.0F, false, null, new int[] { 2816, 2817, 2818, 2819, 2820, 2821, 2822, 2823, 2824, 2825, 2826, 2827, 2828, 2829, 2830, 2831 });
		register("Banner", MATERIAL_WOOD_KEY, 1.0F, 5.0F, false, null, new int[] { 2834, 2835, 2836, 2837 });
		register("Daylight Sensor", MATERIAL_WOOD_KEY, 0.2F, 1.0F, BoundingBox.create(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F), new int[] { 2848, 2849, 2850, 2851, 2852, 2853, 2854, 2855, 2856, 2857, 2858, 2859, 2860, 2861, 2862, 2863 });
		register("Red Sandstone", MATERIAL_ROCK_KEY, 0.8F, 4.0F, new int[] { 2864, 2865, 2866 });
		register("Red Sandstone Stairs", MATERIAL_ROCK_KEY, 0.8F, 4.0F, new int[] { 2880, 2881, 2882, 2883, 2884, 2885, 2886, 2887 });

		register("Double Red Sandstone Slab", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 2896, 2904 });
		registerSlabs("Red Sandstone Slab", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 2912, 2920 });

		//TOOD: calculate at runtime
		register("Spruce Fence Gate", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2928, 2929, 2930, 2931, 2932, 2933, 2934, 2935, 2936, 2937, 2938, 2939, 2940, 2941, 2942, 2943 });
		register("Birch Fence Gate", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2944, 2945, 2946, 2947, 2948, 2949, 2950, 2951, 2952, 2953, 2954, 2955, 2956, 2957, 2958, 2959 });
		register("Jungle Fence Gate", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2960, 2961, 2962, 2963, 2964, 2965, 2966, 2967, 2968, 2969, 2970, 2971, 2972, 2973, 2974, 2975 });
		register("Dark Oak Fence Gate", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2976, 2977, 2978, 2979, 2980, 2981, 2982, 2983, 2984, 2985, 2986, 2987, 2988, 2989, 2990, 2991 });
		register("Acacia Fence Gate", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2992, 2993, 2994, 2995, 2996, 2997, 2998, 2999, 3000, 3001, 3002, 3003, 3004, 3005, 3006, 3007 });
		register("Spruce Fence", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 3008 });
		register("Birch Fence", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 3024 });
		register("Jungle Fence", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 3040 });
		register("Dark Oak Fence", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 3056 });
		register("Acacia Fence", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 3072 });

		register("Spruce Door", MATERIAL_WOOD_KEY, 3.0F, 15.0F, new BoundingBoxStatePair[]{
				new BoundingBoxStatePair(3088, calcDoorBounds(3088)),
				new BoundingBoxStatePair(3089, calcDoorBounds(3089)),
				new BoundingBoxStatePair(3090, calcDoorBounds(3090)),
				new BoundingBoxStatePair(3091, calcDoorBounds(3091)),
				new BoundingBoxStatePair(3092, calcDoorBounds(3092)),
				new BoundingBoxStatePair(3093, calcDoorBounds(3093)),
				new BoundingBoxStatePair(3094, calcDoorBounds(3094)),
				new BoundingBoxStatePair(3095, calcDoorBounds(3095)),
				new BoundingBoxStatePair(3096, calcDoorBounds(3096)),
				new BoundingBoxStatePair(3097, calcDoorBounds(3097)),
				new BoundingBoxStatePair(3098, calcDoorBounds(3098)),
				new BoundingBoxStatePair(3099, calcDoorBounds(3099))
		});
		register("Birch Door", MATERIAL_WOOD_KEY, 3.0F, 15.0F, new BoundingBoxStatePair[]{
				new BoundingBoxStatePair(3104, calcDoorBounds(3104)),
				new BoundingBoxStatePair(3105, calcDoorBounds(3105)),
				new BoundingBoxStatePair(3106, calcDoorBounds(3106)),
				new BoundingBoxStatePair(3107, calcDoorBounds(3107)),
				new BoundingBoxStatePair(3108, calcDoorBounds(3108)),
				new BoundingBoxStatePair(3109, calcDoorBounds(3109)),
				new BoundingBoxStatePair(3110, calcDoorBounds(3110)),
				new BoundingBoxStatePair(3111, calcDoorBounds(3111)),
				new BoundingBoxStatePair(3112, calcDoorBounds(3112)),
				new BoundingBoxStatePair(3113, calcDoorBounds(3113)),
				new BoundingBoxStatePair(3114, calcDoorBounds(3114)),
				new BoundingBoxStatePair(3115, calcDoorBounds(3115))
		});
		register("Jungle Door", MATERIAL_WOOD_KEY, 3.0F, 15.0F, new BoundingBoxStatePair[]{
				new BoundingBoxStatePair(3120, calcDoorBounds(3120)),
				new BoundingBoxStatePair(3121, calcDoorBounds(3121)),
				new BoundingBoxStatePair(3122, calcDoorBounds(3122)),
				new BoundingBoxStatePair(3123, calcDoorBounds(3123)),
				new BoundingBoxStatePair(3124, calcDoorBounds(3124)),
				new BoundingBoxStatePair(3125, calcDoorBounds(3125)),
				new BoundingBoxStatePair(3126, calcDoorBounds(3126)),
				new BoundingBoxStatePair(3127, calcDoorBounds(3127)),
				new BoundingBoxStatePair(3128, calcDoorBounds(3128)),
				new BoundingBoxStatePair(3129, calcDoorBounds(3129)),
				new BoundingBoxStatePair(3130, calcDoorBounds(3130)),
				new BoundingBoxStatePair(3131, calcDoorBounds(3131))
		});
		register("Acacia Door", MATERIAL_WOOD_KEY, 3.0F, 15.0F, new BoundingBoxStatePair[]{
				new BoundingBoxStatePair(3136, calcDoorBounds(3136)),
				new BoundingBoxStatePair(3137, calcDoorBounds(3137)),
				new BoundingBoxStatePair(3138, calcDoorBounds(3138)),
				new BoundingBoxStatePair(3139, calcDoorBounds(3139)),
				new BoundingBoxStatePair(3140, calcDoorBounds(3140)),
				new BoundingBoxStatePair(3141, calcDoorBounds(3141)),
				new BoundingBoxStatePair(3142, calcDoorBounds(3142)),
				new BoundingBoxStatePair(3143, calcDoorBounds(3143)),
				new BoundingBoxStatePair(3144, calcDoorBounds(3144)),
				new BoundingBoxStatePair(3145, calcDoorBounds(3145)),
				new BoundingBoxStatePair(3146, calcDoorBounds(3146)),
				new BoundingBoxStatePair(3147, calcDoorBounds(3147))
		});
		register("Dark Oak Door", MATERIAL_WOOD_KEY, 3.0F, 15.0F, new BoundingBoxStatePair[]{
				new BoundingBoxStatePair(3152, calcDoorBounds(3152)),
				new BoundingBoxStatePair(3153, calcDoorBounds(3153)),
				new BoundingBoxStatePair(3154, calcDoorBounds(3154)),
				new BoundingBoxStatePair(3155, calcDoorBounds(3155)),
				new BoundingBoxStatePair(3156, calcDoorBounds(3156)),
				new BoundingBoxStatePair(3157, calcDoorBounds(3157)),
				new BoundingBoxStatePair(3158, calcDoorBounds(3158)),
				new BoundingBoxStatePair(3159, calcDoorBounds(3159)),
				new BoundingBoxStatePair(3160, calcDoorBounds(3160)),
				new BoundingBoxStatePair(3161, calcDoorBounds(3161)),
				new BoundingBoxStatePair(3162, calcDoorBounds(3162)),
				new BoundingBoxStatePair(3163, calcDoorBounds(3163))
		});
		//@formatter:on
	}

	public static BoundingBox calcAnvilBounds(int meta) {
		int orienation = meta & 3;
		switch (orienation) {
			case 0:// south
				return BoundingBox.create(0.125F, 0.0F, 0.0F, 0.875F, 1.0F, 1.0F);
			case 1:// west
				return BoundingBox.create(0.0F, 0.0F, 0.125F, 1.0F, 1.0F, 0.875F);
			case 2:// north
				return BoundingBox.create(0.125F, 0.0F, 0.0F, 0.875F, 1.0F, 1.0F);
			case 3:// east
			default:
				return BoundingBox.create(0.0F, 0.0F, 0.125F, 1.0F, 1.0F, 0.875F);

		}
	}

	public static BoundingBox calcCocoaBounds(int meta) {
		int age = (meta & 15) >> 2;
		int orienation = meta & 3;
		int var6 = 4 + (age * 2);
		int var7 = 5 + (age * 2);
		float var8 = (float) var6 / 2.0F;
		switch (orienation) {
			case 0:// south
				return BoundingBox.create((8.0F - var8) / 16.0F, (12.0F - (float) var7) / 16.0F, (15.0F - (float) var6) / 16.0F, (8.0F + var8) / 16.0F, 0.75F, 0.9375F);
			case 1:// west
				return BoundingBox.create((8.0F - var8) / 16.0F, (12.0F - (float) var7) / 16.0F, 0.0625F, (8.0F + var8) / 16.0F, 0.75F, (1.0F + (float) var6) / 16.0F);
			case 2:// north
				return BoundingBox.create(0.0625F, (12.0F - (float) var7) / 16.0F, (8.0F - var8) / 16.0F, (1.0F + (float) var6) / 16.0F, 0.75F, (8.0F + var8) / 16.0F);
			case 3:// east
			default:
				return BoundingBox.create((15.0F - (float) var6) / 16.0F, (12.0F - (float) var7) / 16.0F, (8.0F - var8) / 16.0F, 0.9375F, 0.75F, (8.0F + var8) / 16.0F);

		}
	}

	public static BoundingBox calcLadderBounds(int meta) {
		float thickness = 0.125F;

		// minecraft:ladder[facing=north] = 1042 100000100 10
		// minecraft:ladder[facing=south] = 1043 100000100 11
		// minecraft:ladder[facing=west] = 1044 1000001010 00
		// minecraft:ladder[facing=east] = 1045 1000001010 01

		int dir = meta & 3;

		switch (dir) {
			case 1:
				return BoundingBox.create(0.0F, 0.0F, 1.0F - thickness, 1.0F, 1.0F, 1.0F);
			case 2:
				return BoundingBox.create(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, thickness);
			case 3:
				return BoundingBox.create(1.0F - thickness, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			default:
				return BoundingBox.create(0.0F, 0.0F, 0.0F, thickness, 1.0F, 1.0F);
		}
	}

	public static BoundingBox calcTrapdoorBounds(int meta) {
		boolean open = (meta & 4) != 0;
		boolean top = (meta & 8) != 0;
		int orientation = meta & 3;

		if (open) {
			if (orientation == 0) {
				return BoundingBox.create(0.0F, 0.0F, 0.8125F, 1.0F, 1.0F, 1.0F);
			}

			if (orientation == 1) {
				return BoundingBox.create(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1875F);
			}

			if (orientation == 2) {
				return BoundingBox.create(0.8125F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			}

			if (orientation == 3) {
				return BoundingBox.create(0.0F, 0.0F, 0.0F, 0.1875F, 1.0F, 1.0F);
			}
		}

		if (top) {
			return BoundingBox.create(0.0F, 0.8125F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			return BoundingBox.create(0.0F, 0.0F, 0.0F, 1.0F, 0.1875F, 1.0F);
		}
	}

	public static BoundingBox calcDoorBounds(int meta) {
		final float thickness = 0.1875F;
		// 0 = east
		// 1 = south
		// 2 = west
		// 3 = north
		int orientation = meta & 3;
		boolean open = (meta & 4) != 0;
		boolean somethingDunnoSet = (meta & 16) != 0;

		if (open) {
			if (orientation == 0) {
				if (!somethingDunnoSet) {
					return BoundingBox.create(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, thickness);
				} else {
					return BoundingBox.create(0.0F, 0.0F, 1.0F - thickness, 1.0F, 1.0F, 1.0F);
				}
			} else if (orientation == 1) {
				if (!somethingDunnoSet) {
					return BoundingBox.create(1.0F - thickness, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				} else {
					return BoundingBox.create(0.0F, 0.0F, 0.0F, thickness, 1.0F, 1.0F);
				}
			} else if (orientation == 2) {
				if (!somethingDunnoSet) {
					return BoundingBox.create(0.0F, 0.0F, 1.0F - thickness, 1.0F, 1.0F, 1.0F);
				} else {
					return BoundingBox.create(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, thickness);
				}
			} else if (orientation == 3) {
				if (!somethingDunnoSet) {
					return BoundingBox.create(0.0F, 0.0F, 0.0F, thickness, 1.0F, 1.0F);
				} else {
					return BoundingBox.create(1.0F - thickness, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				}
			}
		} else if (orientation == 0) {
			return BoundingBox.create(0.0F, 0.0F, 0.0F, thickness, 1.0F, 1.0F);
		} else if (orientation == 1) {
			return BoundingBox.create(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, thickness);
		} else if (orientation == 2) {
			return BoundingBox.create(1.0F - thickness, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else if (orientation == 3) {
			return BoundingBox.create(0.0F, 0.0F, 1.0F - thickness, 1.0F, 1.0F, 1.0F);
		}

		throw new IllegalArgumentException("Invalid door metadata: " + meta);
	}

	public static BoundingBox calcCakeBounds(int id) {
		float cakeFactor = 0.0625F;
		float slicesFactor = (float) (1 + ((id & 7) * 2)) / 16.0F;
		float height = 0.5F;
		return BoundingBox.create(slicesFactor, 0F, cakeFactor, 1 - cakeFactor, height, 1 - cakeFactor);
	}

	protected void registerSlabs(String name, String material, float hardness, float blastResistence, int... ids) {
		Builder builder = builder(name, material).maxStack(64);
		for (int id : ids) {
			boolean bottom = (id & 8) == 0;// bit 8 is the top/bottom
			register(
					BlockId.create(id),
					builder.hardness(hardness).blastResistence(blastResistence)
							.boundingBox(bottom ? BoundingBox.create(0F, 0F, 0F, 1F, 0.5F, 1F) : BoundingBox.create(0F, 0.5F, 0F, 1F, 1F, 1F)).create());
		}
	}

	protected void register(String name, String material, float hardness, float blastResistence, BoundingBoxStatePair[] pairs) {
		register(name, material, hardness, blastResistence, true, pairs);
	}

	protected void register(String name, String material, float hardness, float blastResistence, boolean solid, BoundingBoxStatePair[] pairs) {
		Builder builder = builder(name, material).maxStack(64).solid(solid);
		for (BoundingBoxStatePair pair : pairs) {
			register(BlockId.create(pair.getState()), builder.hardness(hardness).blastResistence(blastResistence).boundingBox(pair.getBox()).create());
		}
	}

	protected void register(String name, String material, float hardness, float blastResistence, BoundingBox bb, int... ids) {
		register(name, material, hardness, blastResistence, true, bb, ids);
	}

	protected void register(String name, String material, float hardness, float blastResistence, boolean solid, BoundingBox bb, int... ids) {
		Builder builder = builder(name, material).maxStack(64).solid(solid);
		for (int id : ids) {
			register(BlockId.create(id), builder.hardness(hardness).blastResistence(blastResistence).boundingBox(bb).create());
		}
	}

	protected void register(String name, String material, float hardness, float blastResistence, int... ids) {
		register(name, material, hardness, blastResistence, true, ids);
	}

	protected void register(String name, String material, float hardness, float blastResistence, boolean solid, int... ids) {
		Builder builder = builder(name, material).maxStack(64);
		for (int id : ids) {
			register(BlockId.create(id), builder.hardness(hardness).blastResistence(blastResistence).boundingBox(BoundingBox.NORMAL_BOUNDING_BOX).create());
		}
	}

	protected Builder builder(String name, String material) {
		return new Builder().name(name).material(worldProvider.getMaterialRegistry().getByKey(material.toUpperCase())).maxStack(64).friction(0.6F);
	}
}