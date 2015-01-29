package org.topdank.minenet.api.world.block.provider.registry;

import org.topdank.minenet.api.world.block.id.BlockId;
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

	private boolean registered = false;

	@Override
	public void register() {
		// @formatter:off
		if(registered)
			return;
		registered = true;
		register("tile.air.name", MATERIAL_AIR_KEY, 0.0F, 0.0F, new int[] { 0 });
		register("tile.stone.name", MATERIAL_ROCK_KEY, 1.5F, 30.0F, new int[] { 16, 17, 18, 19, 20, 21, 22 });
		register("Grass Block", MATERIAL_GRASS_KEY, 0.6F, 3.0F, new int[] { 32 });
		register("Dirt", MATERIAL_GROUND_KEY, 0.5F, 2.5F, new int[] { 48, 49, 50 });
		register("Cobblestone", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 64 });
		register("Wooden Planks", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 80, 81, 82, 83, 84, 85 });
		register("tile.sapling.name", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, new int[] { 96, 97, 98, 99, 100, 101, 104, 105, 106, 107, 108, 109 });
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
		register("Powered Rail", MATERIAL_CIRCUITS_KEY, 0.7F, 3.5F, new int[] { 432, 433, 434, 435, 436, 437, 440, 441, 442, 443, 444, 445 });
		register("Detector Rail", MATERIAL_CIRCUITS_KEY, 0.7F, 3.5F, new int[] { 448, 449, 450, 451, 452, 453, 456, 457, 458, 459, 460, 461 });
		register("Sticky Piston", MATERIAL_PISTON_KEY, 0.5F, 2.5F, new int[] { 464, 465, 466, 467, 468, 469, 472, 473, 474, 475, 476, 477 });
		register("Cobweb", MATERIAL_WEB_KEY, 4.0F, 20.0F, new int[] { 480 });
		register("Grass", MATERIAL_VINE_KEY, 0.0F, 0.0F, new int[] { 496, 497, 498 });
		register("Dead Bush", MATERIAL_VINE_KEY, 0.0F, 0.0F, new int[] { 512 });
		register("Piston", MATERIAL_PISTON_KEY, 0.5F, 2.5F, new int[] { 528, 529, 530, 531, 532, 533, 536, 537, 538, 539, 540, 541 });
		register("tile.null.name", MATERIAL_PISTON_KEY, 0.5F, 2.5F, new int[] { 544, 545, 546, 547, 548, 549, 552, 553, 554, 555, 556, 557 });
		register("Wool", MATERIAL_CLOTH_KEY, 0.8F, 4.0F, new int[] { 560, 561, 562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575 });
		register("tile.null.name", MATERIAL_PISTON_KEY, -1.0F, 0.0F, new int[] { 576, 577, 578, 579, 580, 581, 584, 585, 586, 587, 588, 589 });
		register("Flower", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, new int[] { 592 });
		register("Flower", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, new int[] { 608, 609, 610, 611, 612, 613, 614, 615, 616 });
		register("Mushroom", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, new int[] { 624 });
		register("Mushroom", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, new int[] { 640 });
		register("Block of Gold", MATERIAL_IRON_KEY, 3.0F, 30.0F, new int[] { 656 });
		register("Block of Iron", MATERIAL_IRON_KEY, 5.0F, 30.0F, new int[] { 672 });
		register("Stone Slab", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 688, 689, 690, 691, 692, 693, 694, 695, 696, 697, 698, 699, 700, 701, 702, 703 });
		register("Stone Slab", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 704, 705, 706, 707, 708, 709, 710, 711, 712, 713, 714, 715, 716, 717, 718, 719 });
		register("Bricks", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 720 });
		register("TNT", MATERIAL_TNT_KEY, 0.0F, 0.0F, new int[] { 736, 737 });
		register("Bookshelf", MATERIAL_WOOD_KEY, 1.5F, 7.5F, new int[] { 752 });
		register("Moss Stone", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 768 });
		register("Obsidian", MATERIAL_ROCK_KEY, 50.0F, 6000.0F, new int[] { 784 });
		register("Torch", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, new int[] { 801, 802, 803, 804, 805 });
		register("Fire", MATERIAL_FIRE_KEY, 0.0F, 0.0F, new int[] { 816, 817, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 828, 829, 830, 831 });
		register("Monster Spawner", MATERIAL_ROCK_KEY, 5.0F, 25.0F, new int[] { 832 });
		register("Oak Wood Stairs", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 848, 849, 850, 851, 852, 853, 854, 855 });
		register("Chest", MATERIAL_WOOD_KEY, 2.5F, 12.5F, new int[] { 866, 867, 868, 869 });
		register("Redstone Dust", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, new int[] { 880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 892, 893, 894, 895 });
		register("Diamond Ore", MATERIAL_ROCK_KEY, 3.0F, 15.0F, new int[] { 896 });
		register("Block of Diamond", MATERIAL_IRON_KEY, 5.0F, 30.0F, new int[] { 912 });
		register("Crafting Table", MATERIAL_WOOD_KEY, 2.5F, 12.5F, new int[] { 928 });
		register("Crops", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, new int[] { 944, 945, 946, 947, 948, 949, 950, 951 });
		register("Farmland", MATERIAL_GROUND_KEY, 0.6F, 3.0F, new int[] { 960, 961, 962, 963, 964, 965, 966, 967 });
		register("Furnace", MATERIAL_ROCK_KEY, 3.5F, 17.5F, new int[] { 978, 979, 980, 981 });
		register("Furnace", MATERIAL_ROCK_KEY, 3.5F, 17.5F, new int[] { 994, 995, 996, 997 });
		register("Sign", MATERIAL_WOOD_KEY, 1.0F, 5.0F, new int[] { 1008, 1009, 1010, 1011, 1012, 1013, 1014, 1015, 1016, 1017, 1018, 1019, 1020, 1021, 1022, 1023 });
		register("tile.doorOak.name", MATERIAL_WOOD_KEY, 3.0F, 15.0F, new int[] { 1024, 1025, 1026, 1027, 1028, 1029, 1030, 1031, 1032, 1033, 1034, 1035 });
		register("Ladder", MATERIAL_CIRCUITS_KEY, 0.4F, 2.0F, new int[] { 1042, 1043, 1044, 1045 });
		register("Rail", MATERIAL_CIRCUITS_KEY, 0.7F, 3.5F, new int[] { 1056, 1057, 1058, 1059, 1060, 1061, 1062, 1063, 1064, 1065 });
		register("Cobblestone Stairs", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 1072, 1073, 1074, 1075, 1076, 1077, 1078, 1079 });
		register("Sign", MATERIAL_WOOD_KEY, 1.0F, 5.0F, new int[] { 1090, 1091, 1092, 1093 });
		register("Lever", MATERIAL_CIRCUITS_KEY, 0.5F, 2.5F, new int[] { 1104, 1105, 1106, 1107, 1108, 1109, 1110, 1111, 1112, 1113, 1114, 1115, 1116, 1117, 1118, 1119 });
		register("Stone Pressure Plate", MATERIAL_ROCK_KEY, 0.5F, 2.5F, new int[] { 1120, 1121 });
		register("Iron Door", MATERIAL_IRON_KEY, 5.0F, 25.0F, new int[] { 1136, 1137, 1138, 1139, 1140, 1141, 1142, 1143, 1144, 1145, 1146, 1147 });
		register("Wooden Pressure Plate", MATERIAL_WOOD_KEY, 0.5F, 2.5F, new int[] { 1152, 1153 });
		register("Redstone Ore", MATERIAL_ROCK_KEY, 3.0F, 15.0F, new int[] { 1168 });
		register("Redstone Ore", MATERIAL_ROCK_KEY, 3.0F, 15.0F, new int[] { 1184 });
		register("Redstone Torch", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, new int[] { 1201, 1202, 1203, 1204, 1205 });
		register("Redstone Torch", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, new int[] { 1217, 1218, 1219, 1220, 1221 });
		register("Button", MATERIAL_CIRCUITS_KEY, 0.5F, 2.5F, new int[] { 1232, 1233, 1234, 1235, 1236, 1237, 1240, 1241, 1242, 1243, 1244, 1245 });
		register("Snow", MATERIAL_SNOW_KEY, 0.1F, 0.5F, new int[] { 1248, 1249, 1250, 1251, 1252, 1253, 1254, 1255 });
		register("Ice", MATERIAL_ICE_KEY, 0.5F, 2.5F, new int[] { 1264 });
		register("Snow", MATERIAL_CRAFTEDSNOW_KEY, 0.2F, 1.0F, new int[] { 1280 });
		register("Cactus", MATERIAL_CACTUS_KEY, 0.4F, 2.0F, new int[] { 1296, 1297, 1298, 1299, 1300, 1301, 1302, 1303, 1304, 1305, 1306, 1307, 1308, 1309, 1310, 1311 });
		register("Clay", MATERIAL_CLAY_KEY, 0.6F, 3.0F, new int[] { 1312 });
		register("Sugar cane", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, new int[] { 1328, 1329, 1330, 1331, 1332, 1333, 1334, 1335, 1336, 1337, 1338, 1339, 1340, 1341, 1342, 1343 });
		register("Jukebox", MATERIAL_WOOD_KEY, 2.0F, 30.0F, new int[] { 1344, 1345 });
		register("Oak Fence", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 1360 });
		register("Pumpkin", MATERIAL_GOURD_KEY, 1.0F, 5.0F, new int[] { 1376, 1377, 1378, 1379 });
		register("Netherrack", MATERIAL_ROCK_KEY, 0.4F, 2.0F, new int[] { 1392 });
		register("Soul Sand", MATERIAL_SAND_KEY, 0.5F, 2.5F, new int[] { 1408 });
		register("Glowstone", MATERIAL_GLASS_KEY, 0.3F, 1.5F, new int[] { 1424 });
		register("Portal", MATERIAL_PORTAL_KEY, -1.0F, 0.0F, new int[] { 1441, 1442 });
		register("Jack o'Lantern", MATERIAL_GOURD_KEY, 1.0F, 5.0F, new int[] { 1456, 1457, 1458, 1459 });
		register("Cake", MATERIAL_CAKE_KEY, 0.5F, 2.5F, new int[] { 1472, 1473, 1474, 1475, 1476, 1477, 1478 });
		register("tile.diode.name", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, new int[] { 1488, 1489, 1490, 1491, 1492, 1493, 1494, 1495, 1496, 1497, 1498, 1499, 1500, 1501, 1502, 1503 });
		register("tile.diode.name", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, new int[] { 1504, 1505, 1506, 1507, 1508, 1509, 1510, 1511, 1512, 1513, 1514, 1515, 1516, 1517, 1518, 1519 });
		register("Stained Glass", MATERIAL_GLASS_KEY, 0.3F, 1.5F, new int[] { 1520, 1521, 1522, 1523, 1524, 1525, 1526, 1527, 1528, 1529, 1530, 1531, 1532, 1533, 1534, 1535 });
		register("Wooden Trapdoor", MATERIAL_WOOD_KEY, 3.0F, 15.0F, new int[] { 1536, 1537, 1538, 1539, 1540, 1541, 1542, 1543, 1544, 1545, 1546, 1547, 1548, 1549, 1550, 1551 });
		register("Stone Monster Egg", MATERIAL_CLAY_KEY, 0.75F, 3.75F, new int[] { 1552, 1553, 1554, 1555, 1556, 1557 });
		register("Stone Bricks", MATERIAL_ROCK_KEY, 1.5F, 30.0F, new int[] { 1568, 1569, 1570, 1571 });
		register("Mushroom", MATERIAL_WOOD_KEY, 0.2F, 1.0F, new int[] { 1584, 1585, 1586, 1587, 1588, 1589, 1590, 1591, 1592, 1593, 1594, 1598, 1599 });
		register("Mushroom", MATERIAL_WOOD_KEY, 0.2F, 1.0F, new int[] { 1600, 1601, 1602, 1603, 1604, 1605, 1606, 1607, 1608, 1609, 1610, 1614, 1615 });
		register("Iron Bars", MATERIAL_IRON_KEY, 5.0F, 30.0F, new int[] { 1616 });
		register("Glass Pane", MATERIAL_GLASS_KEY, 0.3F, 1.5F, new int[] { 1632 });
		register("Melon", MATERIAL_GOURD_KEY, 1.0F, 5.0F, new int[] { 1648 });
		register("tile.pumpkinStem.name", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, new int[] { 1664, 1665, 1666, 1667, 1668, 1669, 1670, 1671 });
		register("tile.pumpkinStem.name", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, new int[] { 1680, 1681, 1682, 1683, 1684, 1685, 1686, 1687 });
		register("Vines", MATERIAL_VINE_KEY, 0.2F, 1.0F, new int[] { 1696, 1697, 1698, 1699, 1700, 1701, 1702, 1703, 1704, 1705, 1706, 1707, 1708, 1709, 1710, 1711 });
		register("Oak Fence Gate", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 1712, 1713, 1714, 1715, 1716, 1717, 1718, 1719, 1720, 1721, 1722, 1723, 1724, 1725, 1726, 1727 });
		register("Brick Stairs", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 1728, 1729, 1730, 1731, 1732, 1733, 1734, 1735 });
		register("Stone Brick Stairs", MATERIAL_ROCK_KEY, 1.5F, 30.0F, new int[] { 1744, 1745, 1746, 1747, 1748, 1749, 1750, 1751 });
		register("Mycelium", MATERIAL_GRASS_KEY, 0.6F, 3.0F, new int[] { 1760 });
		register("Lily Pad", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, new int[] { 1776 });
		register("Nether Brick", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 1792 });
		register("Nether Brick Fence", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 1808 });
		register("Nether Brick Stairs", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 1824, 1825, 1826, 1827, 1828, 1829, 1830, 1831 });
		register("Nether Wart", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, new int[] { 1840, 1841, 1842, 1843 });
		register("Enchantment Table", MATERIAL_ROCK_KEY, 5.0F, 6000.0F, new int[] { 1856 });
		register("tile.brewingStand.name", MATERIAL_IRON_KEY, 0.5F, 2.5F, new int[] { 1872, 1873, 1874, 1875, 1876, 1877, 1878, 1879 });
		register("Cauldron", MATERIAL_IRON_KEY, 2.0F, 10.0F, new int[] { 1888, 1889, 1890, 1891 });
		register("tile.null.name", MATERIAL_PORTAL_KEY, -1.0F, 1.8E7F, new int[] { 1904 });
		register("End Portal", MATERIAL_ROCK_KEY, -1.0F, 1.8E7F, new int[] { 1920, 1921, 1922, 1923, 1924, 1925, 1926, 1927 });
		register("End Stone", MATERIAL_ROCK_KEY, 3.0F, 45.0F, new int[] { 1936 });
		register("Dragon Egg", MATERIAL_DRAGONEGG_KEY, 3.0F, 45.0F, new int[] { 1952 });
		register("Redstone Lamp", MATERIAL_REDSTONELIGHT_KEY, 0.3F, 1.5F, new int[] { 1968 });
		register("Redstone Lamp", MATERIAL_REDSTONELIGHT_KEY, 0.3F, 1.5F, new int[] { 1984 });
		register("Wood Slab", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2000, 2001, 2002, 2003, 2004, 2005 });
		register("Wood Slab", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2016, 2017, 2018, 2019, 2020, 2021, 2024, 2025, 2026, 2027, 2028, 2029 });
		register("Cocoa", MATERIAL_PLANTS_KEY, 0.2F, 15.0F, new int[] { 2032, 2033, 2034, 2035, 2036, 2037, 2038, 2039, 2040, 2041, 2042, 2043 });
		register("Sandstone Stairs", MATERIAL_ROCK_KEY, 0.8F, 4.0F, new int[] { 2048, 2049, 2050, 2051, 2052, 2053, 2054, 2055 });
		register("Emerald Ore", MATERIAL_ROCK_KEY, 3.0F, 15.0F, new int[] { 2064 });
		register("Ender Chest", MATERIAL_ROCK_KEY, 22.5F, 3000.0F, new int[] { 2082, 2083, 2084, 2085 });
		register("Tripwire Hook", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, new int[] { 2096, 2097, 2098, 2099, 2100, 2101, 2102, 2103, 2104, 2105, 2106, 2107, 2108, 2109, 2110, 2111 });
		register("Tripwire", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, new int[] { 2112, 2113, 2114, 2115, 2116, 2117, 2118, 2119, 2120, 2121, 2122, 2123, 2124, 2125, 2126, 2127 });
		register("Block of Emerald", MATERIAL_IRON_KEY, 5.0F, 30.0F, new int[] { 2128 });
		register("Spruce Wood Stairs", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2144, 2145, 2146, 2147, 2148, 2149, 2150, 2151 });
		register("Birch Wood Stairs", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2160, 2161, 2162, 2163, 2164, 2165, 2166, 2167 });
		register("Jungle Wood Stairs", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2176, 2177, 2178, 2179, 2180, 2181, 2182, 2183 });
		register("Command Block", MATERIAL_IRON_KEY, -1.0F, 1.8E7F, new int[] { 2192, 2193 });
		register("Beacon", MATERIAL_GLASS_KEY, 3.0F, 15.0F, new int[] { 2208 });
		register("tile.cobbleWall.name", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 2224, 2225 });
		register("tile.flowerPot.name", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, new int[] { 2240, 2241, 2242, 2243, 2244, 2245, 2246, 2247, 2248, 2249, 2250, 2251, 2252, 2253, 2254, 2255 });
		register("Carrots", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, new int[] { 2256, 2257, 2258, 2259, 2260, 2261, 2262, 2263 });
		register("Potatoes", MATERIAL_PLANTS_KEY, 0.0F, 0.0F, new int[] { 2272, 2273, 2274, 2275, 2276, 2277, 2278, 2279 });
		register("Button", MATERIAL_CIRCUITS_KEY, 0.5F, 2.5F, new int[] { 2288, 2289, 2290, 2291, 2292, 2293, 2296, 2297, 2298, 2299, 2300, 2301 });
		register("tile.skull.name", MATERIAL_CIRCUITS_KEY, 1.0F, 5.0F, new int[] { 2304, 2305, 2306, 2307, 2308, 2309, 2312, 2313, 2314, 2315, 2316, 2317 });
		register("Anvil", MATERIAL_ANVIL_KEY, 5.0F, 6000.0F, new int[] { 2320, 2321, 2322, 2323, 2324, 2325, 2326, 2327, 2328, 2329, 2330, 2331 });
		register("Trapped Chest", MATERIAL_WOOD_KEY, 2.5F, 12.5F, new int[] { 2338, 2339, 2340, 2341 });
		register("Weighted Pressure Plate (Light)", MATERIAL_IRON_KEY, 0.5F, 2.5F,
				new int[] { 2352, 2353, 2354, 2355, 2356, 2357, 2358, 2359, 2360, 2361, 2362, 2363, 2364, 2365, 2366, 2367 });
		register("Weighted Pressure Plate (Heavy)", MATERIAL_IRON_KEY, 0.5F, 2.5F,
				new int[] { 2368, 2369, 2370, 2371, 2372, 2373, 2374, 2375, 2376, 2377, 2378, 2379, 2380, 2381, 2382, 2383 });
		register("tile.comparator.name", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, new int[] { 2384, 2385, 2386, 2387, 2388, 2389, 2390, 2391, 2392, 2393, 2394, 2395, 2396, 2397, 2398, 2399 });
		register("tile.comparator.name", MATERIAL_CIRCUITS_KEY, 0.0F, 0.0F, new int[] { 2400, 2401, 2402, 2403, 2404, 2405, 2406, 2407, 2408, 2409, 2410, 2411, 2412, 2413, 2414, 2415 });
		register("Daylight Sensor", MATERIAL_WOOD_KEY, 0.2F, 1.0F, new int[] { 2416, 2417, 2418, 2419, 2420, 2421, 2422, 2423, 2424, 2425, 2426, 2427, 2428, 2429, 2430, 2431 });
		register("Block of Redstone", MATERIAL_IRON_KEY, 5.0F, 30.0F, new int[] { 2432 });
		register("Nether Quartz Ore", MATERIAL_ROCK_KEY, 3.0F, 15.0F, new int[] { 2448 });
		register("Hopper", MATERIAL_IRON_KEY, 3.0F, 24.0F, new int[] { 2464, 2466, 2467, 2468, 2469, 2472, 2474, 2475, 2476, 2477 });
		register("Block of Quartz", MATERIAL_ROCK_KEY, 0.8F, 4.0F, new int[] { 2480, 2481, 2482, 2483, 2484 });
		register("Quartz Stairs", MATERIAL_ROCK_KEY, 0.8F, 4.0F, new int[] { 2496, 2497, 2498, 2499, 2500, 2501, 2502, 2503 });
		register("Activator Rail", MATERIAL_CIRCUITS_KEY, 0.7F, 3.5F, new int[] { 2512, 2513, 2514, 2515, 2516, 2517, 2520, 2521, 2522, 2523, 2524, 2525 });
		register("Dropper", MATERIAL_ROCK_KEY, 3.5F, 17.5F, new int[] { 2528, 2529, 2530, 2531, 2532, 2533, 2536, 2537, 2538, 2539, 2540, 2541 });
		register("Stained Clay", MATERIAL_ROCK_KEY, 1.25F, 21.0F, new int[] { 2544, 2545, 2546, 2547, 2548, 2549, 2550, 2551, 2552, 2553, 2554, 2555, 2556, 2557, 2558, 2559 });
		register("Stained Glass Pane", MATERIAL_GLASS_KEY, 0.3F, 1.5F, new int[] { 2560, 2561, 2562, 2563, 2564, 2565, 2566, 2567, 2568, 2569, 2570, 2571, 2572, 2573, 2574, 2575 });
		register("Leaves", MATERIAL_LEAVES_KEY, 0.2F, 1.0F, new int[] { 2576, 2577, 2580, 2581, 2584, 2585, 2588, 2589 });
		register("Wood", MATERIAL_WOOD_KEY, 2.0F, 10.0F, new int[] { 2592, 2593, 2596, 2597, 2600, 2601, 2604, 2605 });
		register("Acacia Wood Stairs", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2608, 2609, 2610, 2611, 2612, 2613, 2614, 2615 });
		register("Dark Oak Wood Stairs", MATERIAL_WOOD_KEY, 2.0F, 15.0F, new int[] { 2624, 2625, 2626, 2627, 2628, 2629, 2630, 2631 });
		register("Slime Block", MATERIAL_CLAY_KEY, 0.0F, 0.0F, new int[] { 2640 });
		register("Barrier", MATERIAL_BARRIER_KEY, -1.0F, 1.8000004E7F, new int[] { 2656 });
		register("Iron Trapdoor", MATERIAL_IRON_KEY, 5.0F, 25.0F, new int[] { 2672, 2673, 2674, 2675, 2676, 2677, 2678, 2679, 2680, 2681, 2682, 2683, 2684, 2685, 2686, 2687 });
		register("tile.prismarine.name", MATERIAL_ROCK_KEY, 1.5F, 30.0F, new int[] { 2688, 2689, 2690 });
		register("Sea Lantern", MATERIAL_GLASS_KEY, 0.3F, 1.5F, new int[] { 2704 });
		register("Hay Bale", MATERIAL_GRASS_KEY, 0.5F, 2.5F, new int[] { 2720, 2724, 2728 });
		register("Carpet", MATERIAL_CARPET_KEY, 0.1F, 0.5F, new int[] { 2736, 2737, 2738, 2739, 2740, 2741, 2742, 2743, 2744, 2745, 2746, 2747, 2748, 2749, 2750, 2751 });
		register("Hardened Clay", MATERIAL_ROCK_KEY, 1.25F, 21.0F, new int[] { 2752 });
		register("Block of Coal", MATERIAL_ROCK_KEY, 5.0F, 30.0F, new int[] { 2768 });
		register("Packed Ice", MATERIAL_PACKEDICE_KEY, 0.5F, 2.5F, new int[] { 2784 });
		register("Plant", MATERIAL_VINE_KEY, 0.0F, 0.0F, new int[] { 2800, 2801, 2802, 2803, 2804, 2805, 2808 });
		register("tile.banner.name", MATERIAL_WOOD_KEY, 1.0F, 5.0F, new int[] { 2816, 2817, 2818, 2819, 2820, 2821, 2822, 2823, 2824, 2825, 2826, 2827, 2828, 2829, 2830, 2831 });
		register("tile.banner.name", MATERIAL_WOOD_KEY, 1.0F, 5.0F, new int[] { 2834, 2835, 2836, 2837 });
		register("Daylight Sensor", MATERIAL_WOOD_KEY, 0.2F, 1.0F, new int[] { 2848, 2849, 2850, 2851, 2852, 2853, 2854, 2855, 2856, 2857, 2858, 2859, 2860, 2861, 2862, 2863 });
		register("Red Sandstone", MATERIAL_ROCK_KEY, 0.8F, 4.0F, new int[] { 2864, 2865, 2866 });
		register("Red Sandstone Stairs", MATERIAL_ROCK_KEY, 0.8F, 4.0F, new int[] { 2880, 2881, 2882, 2883, 2884, 2885, 2886, 2887 });
		register("tile.stoneSlab2.name", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 2896, 2904 });
		register("tile.stoneSlab2.name", MATERIAL_ROCK_KEY, 2.0F, 30.0F, new int[] { 2912, 2920 });
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
		register("tile.doorSpruce.name", MATERIAL_WOOD_KEY, 3.0F, 15.0F, new int[] { 3088, 3089, 3090, 3091, 3092, 3093, 3094, 3095, 3096, 3097, 3098, 3099 });
		register("tile.doorBirch.name", MATERIAL_WOOD_KEY, 3.0F, 15.0F, new int[] { 3104, 3105, 3106, 3107, 3108, 3109, 3110, 3111, 3112, 3113, 3114, 3115 });
		register("tile.doorJungle.name", MATERIAL_WOOD_KEY, 3.0F, 15.0F, new int[] { 3120, 3121, 3122, 3123, 3124, 3125, 3126, 3127, 3128, 3129, 3130, 3131 });
		register("tile.doorAcacia.name", MATERIAL_WOOD_KEY, 3.0F, 15.0F, new int[] { 3136, 3137, 3138, 3139, 3140, 3141, 3142, 3143, 3144, 3145, 3146, 3147 });
		register("tile.doorDarkOak.name", MATERIAL_WOOD_KEY, 3.0F, 15.0F, new int[] { 3152, 3153, 3154, 3155, 3156, 3157, 3158, 3159, 3160, 3161, 3162, 3163 });

		// register(builder("Air", MATERIAL_AIR_KEY) .id(new MetaBlockId(0,
		// 0)).create());
		//
		// //stone variants
		// register(builder("Stone", MATERIAL_ROCK_KEY) .id(new MetaBlockId(1,
		// 0)).hardness(1.5F).blastResistence(30.0F).create());
		// register(builder("Granite", MATERIAL_ROCK_KEY) .id(new MetaBlockId(1,
		// 1)).hardness(1.5F).blastResistence(30.0F).create());
		// register(builder("Polished Granite", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(1, 2)).hardness(1.5F).blastResistence(30.0F).create());
		// register(builder("Diorite", MATERIAL_ROCK_KEY) .id(new MetaBlockId(1,
		// 3)).hardness(1.5F).blastResistence(30.0F).create());
		// register(builder("Polished Diorite", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(1, 4)).hardness(1.5F).blastResistence(30.0F).create());
		// register(builder("Andesite", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(1, 5)).hardness(1.5F).blastResistence(30.0F).create());
		// register(builder("Polished Andesite", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(1, 6)).hardness(1.5F).blastResistence(30.0F).create());
		//
		// register(builder("Grass", MATERIAL_GRASS_KEY) .id(new MetaBlockId(2,
		// 0)).hardness(0.6F).blastResistence(3.0F).create());
		// register(builder("Dirt", MATERIAL_GROUND_KEY) .id(new MetaBlockId(3,
		// 0)).hardness(0.5F).blastResistence(2.5F).create());
		// register(builder("Cobblestone", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(4, 0)).hardness(2.0F).blastResistence(30.0F).create());
		//
		// //plank variants
		// register(builder("Oak Wood Planks", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(5, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Spruce Wood Planks", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(5, 1)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Birch Wood Planks", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(5, 2)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Jungle Wood Planks", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(5, 3)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Acacia Wood Planks", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(5, 4)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Dark Oak Wood Planks", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(5, 5)).hardness(2.0F).blastResistence(15.0F).create());
		//
		// register(builder("Bedrock", MATERIAL_ROCK_KEY) .id(new MetaBlockId(7,
		// 0)).hardness(-1.0F).blastResistence(1.8E7F).create());
		// register(builder("Flowing Water", MATERIAL_WATER_KEY) .id(new
		// MetaBlockId(8,
		// 0)).hardness(100.0F).blastResistence(500.0F).create());
		// register(builder("Still Water", MATERIAL_WATER_KEY) .id(new
		// MetaBlockId(9,
		// 0)).hardness(100.0F).blastResistence(500.0F).create());
		// register(builder("Flowing Lava", MATERIAL_LAVA_KEY) .id(new
		// MetaBlockId(10, 0)).hardness(100.0F).create());
		// register(builder("Still Lava", MATERIAL_LAVA_KEY) .id(new
		// MetaBlockId(11,
		// 0)).hardness(100.0F).blastResistence(500.0F).create());
		// register(builder("Sand", MATERIAL_SAND_KEY) .id(new MetaBlockId(12,
		// 0)).hardness(0.5F).blastResistence(2.5F).create());
		// register(builder("Red Sand", MATERIAL_SAND_KEY) .id(new
		// MetaBlockId(12, 1)).hardness(0.5F).blastResistence(2.5F).create());
		// register(builder("Gravel", MATERIAL_SAND_KEY) .id(new MetaBlockId(13,
		// 0)).hardness(0.6F).blastResistence(3.0F).create());
		// register(builder("Gold Ore", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(14, 0)).hardness(13.0F).blastResistence(15.0F).create());
		// register(builder("Iron Ore", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(15, 0)).hardness(3.0F).blastResistence(15.0F).create());
		// register(builder("Iron Ore", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(16, 0)).hardness(3.0F).blastResistence(15.0F).create());
		// register(builder("Oak Wood", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(17, 0)).hardness(2.0F).blastResistence(10.0F).create());
		//
		// //log variants
		// register(builder("Spruce Wood", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(17, 1)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Birch Wood", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(17, 2)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Jungle Wood", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(17, 3)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Oak Wood", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(17, 4)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Spruce Wood", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(17, 5)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Birch Wood", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(17, 6)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Jungle Wood", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(17, 7)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Oak Wood", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(17, 8)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Spruce Wood", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(17, 9)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Birch Wood", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(17, 10)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Jungle Wood", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(17, 11)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Oak Wood", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(17, 12)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Spruce Wood", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(17, 13)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Birch Wood", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(17, 14)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Jungle Wood", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(17, 15)).hardness(2.0F).blastResistence(10.0F).create());
		//
		// //chronic variants
		// register(builder("Oak Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(18, 0)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Spruce Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(18, 1)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Birch Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(18, 2)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Jungle Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(18, 3)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Oak Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(18, 4)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Spruce Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(18, 5)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Birch Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(18, 6)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Jungle Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(18, 7)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Oak Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(18, 8)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Spruce Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(18, 9)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Birch Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(18, 10)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Jungle Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(18, 11)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Oak Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(18, 12)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Spruce Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(18, 13)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Birch Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(18, 14)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Jungle Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(18, 15)).hardness(0.2F).blastResistence(1.0F).create());
		//
		// register(builder("Sponge", MATERIAL_SPONGE_KEY) .id(new
		// MetaBlockId(19, 0)).hardness(0.6F).blastResistence(3.0F).create());
		// register(builder("Sponge", MATERIAL_SPONGE_KEY) .id(new
		// MetaBlockId(19, 1)).hardness(0.6F).blastResistence(3.0F).create());
		// register(builder("Glass", MATERIAL_GLASS_KEY) .id(new MetaBlockId(20,
		// 0)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Lapis Lazuli Ore", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(21, 0)).hardness(3.0F).blastResistence(15.0F).create());
		// register(builder("Lapis Lazuli Block", MATERIAL_IRON_KEY) .id(new
		// MetaBlockId(22, 0)).hardness(3.0F).blastResistence(15.0F).create());
		//
		// //sandstone variants
		// register(builder("Dispenser", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(23, 0)).hardness(3.5F).blastResistence(17.5F).create());
		// register(builder("Sandstone", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(24, 0)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Sandstone", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(24, 1)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Sandstone", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(24, 2)).hardness(0.8F).blastResistence(4.0F).create());
		//
		// register(builder("Note Block", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(25, 0)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Bed", MATERIAL_CLOTH_KEY) .id(new MetaBlockId(26,
		// 0)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Powered Rail", MATERIAL_CIRCUITS_KEY) .id(new
		// MetaBlockId(27, 0)).hardness(0.7F).blastResistence(3.5F).create());
		// register(builder("Detector Rail", MATERIAL_CIRCUITS_KEY) .id(new
		// MetaBlockId(28, 0)).hardness(0.7F).blastResistence(3.5F).create());
		// register(builder("Sticky Piston", MATERIAL_PISTON_KEY) .id(new
		// MetaBlockId(29, 0)).hardness(0.5F).blastResistence(2.5F).create());
		// register(builder("Cobweb", MATERIAL_WEB_KEY) .id(new MetaBlockId(30,
		// 0)).hardness(4.0F).blastResistence(20.0F).create());
		// register(builder("Dead Bush", MATERIAL_VINE_KEY) .id(new
		// MetaBlockId(31, 0)).create());
		// register(builder("Tall Grass", MATERIAL_VINE_KEY) .id(new
		// MetaBlockId(31, 1)).create());
		// register(builder("Fern", MATERIAL_VINE_KEY) .id(new MetaBlockId(31,
		// 2)).create());
		// register(builder("Piston", MATERIAL_PISTON_KEY) .id(new
		// MetaBlockId(33, 0)).hardness(0.5F).blastResistence(2.5F).create());
		// register(builder("Piston Head", MATERIAL_PISTON_KEY) .id(new
		// MetaBlockId(34, 0)).hardness(0.5F).blastResistence(2.5F).create());
		//
		// //wool variants
		// register(builder("White Wool", MATERIAL_CLOTH_KEY) .id(new
		// MetaBlockId(35, 0)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Orange Wool", MATERIAL_CLOTH_KEY) .id(new
		// MetaBlockId(35, 1)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Magenta Wool", MATERIAL_CLOTH_KEY) .id(new
		// MetaBlockId(35, 2)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Light Blue Wool", MATERIAL_CLOTH_KEY) .id(new
		// MetaBlockId(35, 3)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Yellow Wool", MATERIAL_CLOTH_KEY) .id(new
		// MetaBlockId(35, 4)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Lime Wool", MATERIAL_CLOTH_KEY) .id(new
		// MetaBlockId(35, 5)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Pink Wool", MATERIAL_CLOTH_KEY) .id(new
		// MetaBlockId(35, 6)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Grey Wool", MATERIAL_CLOTH_KEY) .id(new
		// MetaBlockId(35, 7)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Light Grey Wool", MATERIAL_CLOTH_KEY) .id(new
		// MetaBlockId(35, 8)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Cyan Wool", MATERIAL_CLOTH_KEY) .id(new
		// MetaBlockId(35, 9)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Purple Wool", MATERIAL_CLOTH_KEY) .id(new
		// MetaBlockId(35, 10)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Blue Wool", MATERIAL_CLOTH_KEY) .id(new
		// MetaBlockId(35, 11)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Brown Wool", MATERIAL_CLOTH_KEY) .id(new
		// MetaBlockId(35, 12)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Green Wool", MATERIAL_CLOTH_KEY) .id(new
		// MetaBlockId(35, 13)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Red Wool", MATERIAL_CLOTH_KEY) .id(new
		// MetaBlockId(35, 14)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Black Wool", MATERIAL_CLOTH_KEY) .id(new
		// MetaBlockId(35, 15)).hardness(0.8F).blastResistence(4.0F).create());
		//
		// register(builder("Piston Moving", MATERIAL_PISTON_KEY) .id(new
		// MetaBlockId(36, 0)).hardness(-1.0F).blastResistence(-5.0F).create());
		//
		// //plant variants
		// register(builder("Dandelion", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(37, 0)).create());
		// register(builder("Poppy", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(38, 0)).create());
		// register(builder("Blue Orchid", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(38, 1)).create());
		// register(builder("Allium", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(38, 2)).create());
		// register(builder("Azure Bluet", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(38, 3)).create());
		// register(builder("Red Tulip", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(38, 4)).create());
		// register(builder("Orange Tulip", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(38, 5)).create());
		// register(builder("White Tulip", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(38, 6)).create());
		// register(builder("Pink Tulip", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(38, 7)).create());
		// register(builder("Oxeye Daisy", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(38, 8)).create());
		// register(builder("Red Mushroom", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(39, 0)).create());
		// register(builder("Brown Mushroom", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(40, 0)).create());
		//
		// register(builder("Gold Block", MATERIAL_IRON_KEY) .id(new
		// MetaBlockId(41, 0)).hardness(3.0F).blastResistence(30.0F).create());
		// register(builder("Iron Block", MATERIAL_IRON_KEY) .id(new
		// MetaBlockId(42, 0)).hardness(5.0F).blastResistence(30.0F).create());
		//
		// //stone slabs
		// register(builder("Double Stone Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(43, 0)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Double Sandstone Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(43, 1)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Double StoneWood Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(43, 2)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Double Cobblestone Slab", MATERIAL_ROCK_KEY)
		// .id(new MetaBlockId(43,
		// 3)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Double Brick Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(43, 4)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Double Stone Brick Slab", MATERIAL_ROCK_KEY)
		// .id(new MetaBlockId(43,
		// 5)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Double Nether Brick Slab", MATERIAL_ROCK_KEY)
		// .id(new MetaBlockId(43,
		// 6)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Double Quartz Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(43, 7)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Smooth Double Stone Slab", MATERIAL_ROCK_KEY)
		// .id(new MetaBlockId(43,
		// 8)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Smooth Double Sandstone Slab", MATERIAL_ROCK_KEY)
		// .id(new MetaBlockId(43,
		// 9)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Tile Smooth Quartz Slab", MATERIAL_ROCK_KEY)
		// .id(new MetaBlockId(43,
		// 15)).hardness(2.0F).blastResistence(30.0F).create());
		//
		// register(builder("Stone Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(44, 0)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Sandstone Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(44, 1)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("StoneWood Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(44, 2)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Cobblestone Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(44, 3)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Brick Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(44, 4)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Stone Brick Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(44, 5)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Nether Brick Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(44, 6)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Quartz Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(44, 7)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Upper Stone Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(44, 8)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Upper Sandstone Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(44, 9)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Upper StoneWood Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(44, 10)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Upper Cobblestone Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(44, 11)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Upper Brick Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(44, 12)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Upper Stone Brick Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(44, 13)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Upper Nether Brick Slab", MATERIAL_ROCK_KEY)
		// .id(new MetaBlockId(44,
		// 14)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Upper Quartz Brick Slab", MATERIAL_ROCK_KEY)
		// .id(new MetaBlockId(44,
		// 15)).hardness(2.0F).blastResistence(30.0F).create());
		//
		// register(builder("Brick", MATERIAL_ROCK_KEY) .id(new MetaBlockId(45,
		// 0)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("TNT", MATERIAL_TNT_KEY) .id(new MetaBlockId(46,
		// 0)).create());
		// register(builder("Bookshelf", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(47, 0)).hardness(1.5F).hardness(7.5F).create());
		// register(builder("Mossy Cobblestone", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(48, 0)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Obsidian", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(49,
		// 0)).hardness(50.0F).blastResistence(2000.0F).create());
		// register(builder("Torch", MATERIAL_CIRCUITS_KEY) .id(new
		// MetaBlockId(50, 0)).create());
		// register(builder("Fire", MATERIAL_CIRCUITS_KEY) .id(new
		// MetaBlockId(51, 0)).create());
		// register(builder("Mob Spawner", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(52, 0)).hardness(5.0F).blastResistence(25.0F).create());
		//
		// register(builder("Oak Wood Stairs", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(53, 0)).hardness(2.0F).blastResistence(15.0F).create());
		//
		// register(builder("Chest", MATERIAL_WOOD_KEY) .id(new MetaBlockId(54,
		// 0)).hardness(2.5F).blastResistence(12.5F).create());
		// register(builder("Redstone Wire", MATERIAL_CIRCUITS_KEY) .id(new
		// MetaBlockId(55, 0)).create());
		// register(builder("Diamond Ore", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(56, 0)).hardness(3.0F).blastResistence(15.0F).create());
		// register(builder("Block of Diamond", MATERIAL_IRON_KEY) .id(new
		// MetaBlockId(57, 0)).hardness(5.0F).blastResistence(30.0F).create());
		// register(builder("Crafting Table", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(58, 0)).hardness(2.5F).blastResistence(12.5F).create());
		// register(builder("Wheat", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(59, 0)).create());
		// register(builder("Farmland", MATERIAL_GROUND_KEY) .id(new
		// MetaBlockId(60, 0)).hardness(0.6F).blastResistence(3.0F).create());
		// register(builder("Furnace", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(61, 0)).hardness(3.5F).blastResistence(17.5F).create());
		// register(builder("Active Furnace", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(62, 0)).hardness(3.5F).blastResistence(17.5F).create());
		// register(builder("Standing Sign", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(63, 0)).hardness(1.0F).blastResistence(5.0F).create());
		//
		// register(builder("Oak Door", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(64, 0)).hardness(3.0F).blastResistence(15.0F).create());
		//
		// register(builder("Ladder", MATERIAL_CIRCUITS_KEY) .id(new
		// MetaBlockId(65, 0)).hardness(0.4F).blastResistence(2.0F).create());
		// register(builder("Rail", MATERIAL_CIRCUITS_KEY) .id(new
		// MetaBlockId(66, 0)).hardness(0.7F).blastResistence(3.5F).create());
		//
		// register(builder("Cobblestone Stairs", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(67, 0)).hardness(2.0F).blastResistence(30.0F).create());
		//
		// register(builder("Wall Sign", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(68, 0)).hardness(1.0F).blastResistence(5.0F).create());
		// register(builder("Lever", MATERIAL_CIRCUITS_KEY) .id(new
		// MetaBlockId(69, 0)).hardness(0.5F).blastResistence(2.5F).create());
		// register(builder("Stone Pressure Plate", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(70, 0)).hardness(0.5F).blastResistence(2.5F).create());
		// register(builder("Iron Door", MATERIAL_IRON_KEY) .id(new
		// MetaBlockId(71, 0)).hardness(5.0F).blastResistence(25.0F).create());
		// register(builder("Wooden Pressure Plate", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(72, 0)).hardness(0.5F).blastResistence(2.5F).create());
		// register(builder("Redstone Ore", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(73, 0)).hardness(3.0F).blastResistence(15.0F).create());
		// register(builder("Glowing Redstone Ore", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(74, 0)).hardness(3.0F).blastResistence(15.0F).create());
		// register(builder("Redstone Torch", MATERIAL_CIRCUITS_KEY) .id(new
		// MetaBlockId(75, 0)).create());
		// register(builder("Active Redstone Torch", MATERIAL_CIRCUITS_KEY)
		// .id(new MetaBlockId(76, 0)).create());
		// register(builder("Stone Button", MATERIAL_CIRCUITS_KEY) .id(new
		// MetaBlockId(77, 0)).hardness(0.5F).blastResistence(2.5F).create());
		// register(builder("Snow Layer", MATERIAL_SNOW_KEY) .id(new
		// MetaBlockId(78, 0)).hardness(0.1F).blastResistence(0.5F).create());
		// register(builder("Ice", MATERIAL_ICE_KEY) .id(new MetaBlockId(79,
		// 0)).hardness(0.5F).blastResistence(2.5F).create());
		// register(builder("Snow", MATERIAL_CRAFTEDSNOW_KEY) .id(new
		// MetaBlockId(80, 0)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Cactus", MATERIAL_CACTUS_KEY) .id(new
		// MetaBlockId(81, 0)).hardness(0.4F).blastResistence(2.0F).create());
		// register(builder("Clay", MATERIAL_CLAY_KEY) .id(new MetaBlockId(82,
		// 0)).hardness(0.6F).blastResistence(3.0F).create());
		// register(builder("Sugar Cane", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(83, 0)).create());
		// register(builder("Jukebox", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(84, 0)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Fence", MATERIAL_WOOD_KEY) .id(new MetaBlockId(85,
		// 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Pumpkin", MATERIAL_GOURD_KEY) .id(new
		// MetaBlockId(86, 0)).hardness(1.0F).blastResistence(5.0F).create());
		// register(builder("Netherrack", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(87, 0)).hardness(0.4F).blastResistence(2.0F).create());
		//
		// register(builder("Soul Sand", MATERIAL_SAND_KEY) .id(new
		// MetaBlockId(88,
		// 0)).hardness(0.5F).blastResistence(2.5F).friction(0.4F).create());
		//
		// register(builder("Glowstone", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(89, 0)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Nether Portal", MATERIAL_PORTAL_KEY) .id(new
		// MetaBlockId(90, 0)).create());
		// register(builder("Jack o'Lantern", MATERIAL_GOURD_KEY) .id(new
		// MetaBlockId(91, 0)).hardness(1.0F).blastResistence(5.0F).create());
		// register(builder("Cake", MATERIAL_CAKE_KEY) .id(new MetaBlockId(92,
		// 0)).hardness(0.5F).blastResistence(2.5F).create());
		// register(builder("Redstone Repeater", MATERIAL_CIRCUITS_KEY) .id(new
		// MetaBlockId(93, 0)).create());
		// register(builder("Powered Redstone Repeater", MATERIAL_CIRCUITS_KEY)
		// .id(new MetaBlockId(94, 0)).create());
		//
		// //stain glass TODO: Colours
		// register(builder("Stained Glass", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(95, 0)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(95, 1)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(95, 2)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(95, 3)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(95, 4)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(95, 5)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(95, 6)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(95, 7)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(95, 8)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(95, 9)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(95, 10)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(95, 11)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(95, 12)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(95, 13)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(95, 14)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(95, 15)).hardness(0.3F).blastResistence(1.5F).create());
		//
		// register(builder("Trapdoor", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(96, 0)).hardness(3.0F).blastResistence(15.0F).create());
		// register(builder("Monster Egg", MATERIAL_DRAGONEGG_KEY) .id(new
		// MetaBlockId(97, 0)).hardness(0.75F).blastResistence(3.75F).create());
		// register(builder("Stone Bricks", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(98, 0)).hardness(1.5F).blastResistence(30.0F).create());
		// register(builder("Mossy Stone Bricks", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(98,
		// 1)).hardness(1.5F).blastResistence(30.0F).create());
		// register(builder("Cracked Stone Bricks", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(98,
		// 2)).hardness(1.5F).blastResistence(30.0F).create());
		// register(builder("Chiseled Stone Bricks", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(98,
		// 3)).hardness(1.5F).blastResistence(30.0F).create());
		//
		// //mushroom blocks
		// register(builder("Brown Mushroom Block", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(99, 0)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Red Mushroom Block", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(100, 0)).hardness(0.2F).blastResistence(1.0F).create());
		//
		// register(builder("Iron Bars", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(101, 0)).hardness(5.0F).blastResistence(30.0F).create());
		// register(builder("Glass Pane", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(102, 0)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Melon", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(103, 0)).hardness(1.0F).blastResistence(5.0F).create());
		// register(builder("Pumpkin Stem", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(104, 0)).create());
		// register(builder("Melon Stem", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(105, 0)).create());
		// register(builder("Vines", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(106, 0)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Oak Fence Gate", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(107,
		// 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Brick Stairs", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(108, 0)).hardness(2.0F).blastResistence(4.0F).create());
		// register(builder("Stone Brick Stairs", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(109,
		// 0)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Mycelium", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(110, 0)).hardness(0.6F).blastResistence(2.5F).create());
		// register(builder("Lily Pad", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(111, 0)).hardness(0.6F).create());
		// register(builder("Nether Brick", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(112, 0)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Nether Brick Fence", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(113,
		// 0)).hardness(2.0F).blastResistence(30.0F).create());
		// register(builder("Nether Brick Stairs", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(114,
		// 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Nether Wart", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(115, 0)).create());
		// register(builder("Enchantment Table", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(116,
		// 0)).hardness(5.0F).blastResistence(6000.0F).create());
		// register(builder("Brewing Stand", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(117, 0)).hardness(0.5F).blastResistence(2.5F).create());
		// register(builder("Cauldron", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(118, 0)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("End Portal", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(119,
		// 0)).hardness(-1.0F).blastResistence(1.8E7F).create());
		// register(builder("End Portal Frame", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(120,
		// 0)).hardness(1.8E7F).blastResistence(-1.0F).create());
		// register(builder("End Stone", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(121, 0)).hardness(3.0F).blastResistence(45.0F).create());
		// register(builder("Dragon Egg", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(122, 0)).hardness(3.0F).blastResistence(45.0F).create());
		// register(builder("Redstone Lamp", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(123, 0)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Redstone Lamp", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(124, 0)).hardness(0.3F).blastResistence(1.5F).create());
		//
		// //wooden slab
		// register(builder("Double Oak Wood Slab", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(125, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Double Spruce Wood Slab", MATERIAL_WOOD_KEY)
		// .id(new MetaBlockId(125,
		// 1)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Double Birch Wood Slab", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(125, 2)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Double Jungle Wood Slab", MATERIAL_WOOD_KEY)
		// .id(new MetaBlockId(125,
		// 3)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Double Acacia Wood Slab", MATERIAL_WOOD_KEY)
		// .id(new MetaBlockId(125,
		// 4)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Double Dark Oak Wood Slab", MATERIAL_WOOD_KEY)
		// .id(new MetaBlockId(125,
		// 5)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Oak Wood Slab", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(125, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Spruce Wood Slab", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(125, 1)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Birch Wood Slab", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(125, 2)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Jungle Wood Slab", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(125, 3)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Acacia Wood Slab", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(125, 4)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Dark Oak Wood Slab", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(125, 5)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Upper Oak Wood Slab", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(126, 8)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Upper Spruce Wood Slab", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(126, 9)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Upper Birch Wood Slab", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(126,
		// 10)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Upper Jungle Wood Slab", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(126,
		// 11)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Upper Acacia Wood Slab", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(126,
		// 12)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Upper Dark Oak Wood Slab", MATERIAL_WOOD_KEY)
		// .id(new MetaBlockId(126,
		// 13)).hardness(2.0F).blastResistence(15.0F).create());
		//
		// register(builder("Cocoa", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(127, 0)).hardness(0.2F).blastResistence(15.0F).create());
		// register(builder("Sandstone Stairs", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(128,
		// 0)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Emerald Ore", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(129, 0)).hardness(3.0F).blastResistence(15.0F).create());
		// register(builder("Ender Chest", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(130,
		// 0)).hardness(22.5F).blastResistence(3000.0F).create());
		// register(builder("Redstone Comparator (on)",
		// MATERIAL_REDSTONELIGHT_KEY) .id(new MetaBlockId(150, 0)).create());
		// register(builder("Daylight Sensor", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(151,
		// 0)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Redstone Block", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(152,
		// 0)).hardness(5.0F).blastResistence(30.0F).create());
		// register(builder("Nether Quartz Ore", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(153,
		// 0)).hardness(3.0F).blastResistence(15.0F).create());
		// register(builder("Hopper", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(154, 0)).hardness(3.0F).blastResistence(15.0F).create());
		// register(builder("Block of Quartz", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(155,
		// 0)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Chiseled Block of Quartz",
		// MATERIAL_REDSTONELIGHT_KEY) .id(new MetaBlockId(155,
		// 1)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Pillar Block of Quartz",
		// MATERIAL_REDSTONELIGHT_KEY) .id(new MetaBlockId(155,
		// 2)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Pillar Block of Quartz",
		// MATERIAL_REDSTONELIGHT_KEY) .id(new MetaBlockId(155,
		// 3)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Pillar Block of Quartz",
		// MATERIAL_REDSTONELIGHT_KEY) .id(new MetaBlockId(155,
		// 4)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Quartz Stairs", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(156, 0)).hardness(4.0F).blastResistence(0.8F).create());
		// register(builder("Activator Rail", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(157,
		// 0)).hardness(0.7F).blastResistence(3.5F).create());
		// register(builder("Dropper", MATERIAL_REDSTONELIGHT_KEY) .id(new
		// MetaBlockId(158, 0)).hardness(3.5F).blastResistence(30.0F).create());
		// register(builder("White Stained Clay", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(159,
		// 0)).hardness(1.25F).blastResistence(30.0F).create());
		// register(builder("Orange Stained Clay", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(159,
		// 1)).hardness(1.25F).blastResistence(30.0F).create());
		// register(builder("Magenta Stained Clay", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(159,
		// 2)).hardness(1.25F).blastResistence(30.0F).create());
		// register(builder("Light Blue Stained Clay",
		// MATERIAL_REDSTONELIGHT_KEY) .id(new MetaBlockId(159,
		// 3)).hardness(1.25F).blastResistence(30.0F).create());
		// register(builder("Yellow Stained Clay", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(159,
		// 4)).hardness(1.25F).blastResistence(30.0F).create());
		// register(builder("Lime Stained Clay", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(159,
		// 5)).hardness(1.25F).blastResistence(30.0F).create());
		// register(builder("Pink Stained Clay", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(159,
		// 6)).hardness(1.25F).blastResistence(30.0F).create());
		// register(builder("Gray Stained Clay", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(159,
		// 7)).hardness(1.25F).blastResistence(30.0F).create());
		// register(builder("Light gray Stained Clay",
		// MATERIAL_REDSTONELIGHT_KEY) .id(new MetaBlockId(159,
		// 8)).hardness(1.25F).blastResistence(30.0F).create());
		// register(builder("Cyan Stained Clay", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(159,
		// 9)).hardness(1.25F).blastResistence(30.0F).create());
		// register(builder("Purple Stained Clay", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(159,
		// 10)).hardness(1.25F).blastResistence(30.0F).create());
		// register(builder("Blue Stained Clay", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(159,
		// 11)).hardness(1.25F).blastResistence(30.0F).create());
		// register(builder("Nigga Stained Clay", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(159,
		// 12)).hardness(1.25F).blastResistence(30.0F).create());
		// register(builder("Green Stained Clay", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(159,
		// 13)).hardness(1.25F).blastResistence(30.0F).create());
		// register(builder("Red Stained Clay", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(159,
		// 14)).hardness(1.25F).blastResistence(30.0F).create());
		// register(builder("Black Stained Clay", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(159,
		// 15)).hardness(1.25F).blastResistence(30.0F).create());
		// register(builder("Stained Glass Pane", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(160,
		// 0)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass Pane", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(160,
		// 1)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass Pane", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(160,
		// 2)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass Pane", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(160,
		// 3)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass Pane", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(160,
		// 4)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass Pane", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(160,
		// 5)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass Pane", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(160,
		// 6)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass Pane", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(160,
		// 7)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass Pane", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(160,
		// 8)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass Pane", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(160,
		// 9)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass Pane", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(160,
		// 10)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass Pane", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(160,
		// 11)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass Pane", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(160,
		// 12)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass Pane", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(160,
		// 13)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass Pane", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(160,
		// 14)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Stained Glass Pane", MATERIAL_REDSTONELIGHT_KEY)
		// .id(new MetaBlockId(160,
		// 15)).hardness(0.3F).blastResistence(1.5F).create());
		//
		// //more chronic
		// register(builder("Acacia Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(161, 0)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Dark Oak Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(161, 1)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Acacia Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(161, 4)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Dark Oak Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(161, 5)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Acacia Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(161, 8)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Dark Oak Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(161, 9)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Acacia Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(161, 12)).hardness(0.2F).blastResistence(1.0F).create());
		// register(builder("Dark Oak Leaves", MATERIAL_LEAVES_KEY) .id(new
		// MetaBlockId(161, 13)).hardness(0.2F).blastResistence(1.0F).create());
		//
		// //more logs
		// register(builder("Acacia", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(162, 0)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Dark Oak", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(162, 1)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Acacia", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(162, 4)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Dark Oak", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(162, 5)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Acacia", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(162, 8)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Dark Oak", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(162, 9)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Acacia", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(162,
		// 12)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Dark Oak", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(162,
		// 13)).hardness(2.0F).blastResistence(10.0F).create());
		//
		// register(builder("Acacia Wood Stairs", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(163, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Dark Oak Wood Stairs", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(164, 0)).hardness(2.0F).blastResistence(15.0F).create());
		//
		// register(builder("Slime Block", MATERIAL_CLAY_KEY) .id(new
		// MetaBlockId(165, 0)).create());
		// register(builder("Barrier", MATERIAL_BARRIER_KEY) .id(new
		// MetaBlockId(166,
		// 0)).hardness(-1.0F).blastResistence(1.8E7F).create());
		// register(builder("Iron Trapdoor", MATERIAL_IRON_KEY) .id(new
		// MetaBlockId(167, 0)).hardness(3.0F).blastResistence(25.0F).create());
		// register(builder("Prismarine", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(168, 0)).hardness(1.5F).blastResistence(30.0F).create());
		// register(builder("Sea Lantern", MATERIAL_GLASS_KEY) .id(new
		// MetaBlockId(169, 0)).hardness(0.3F).blastResistence(1.5F).create());
		// register(builder("Hay Bale", MATERIAL_GRASS_KEY) .id(new
		// MetaBlockId(170, 0)).hardness(2.5F).blastResistence(0.5F).create());
		//
		// //carpets
		// register(builder("White Carpet", MATERIAL_CARPET_KEY) .id(new
		// MetaBlockId(171, 0)).create());
		// register(builder("Orange Carpet", MATERIAL_CARPET_KEY) .id(new
		// MetaBlockId(171, 1)).create());
		// register(builder("Magenta Carpet", MATERIAL_CARPET_KEY) .id(new
		// MetaBlockId(171, 2)).create());
		// register(builder("Light Blue Carpet", MATERIAL_CARPET_KEY) .id(new
		// MetaBlockId(171, 3)).create());
		// register(builder("Yellow Carpet", MATERIAL_CARPET_KEY) .id(new
		// MetaBlockId(171, 4)).create());
		// register(builder("Lime Carpet", MATERIAL_CARPET_KEY) .id(new
		// MetaBlockId(171, 5)).create());
		// register(builder("Pink Carpet", MATERIAL_CARPET_KEY) .id(new
		// MetaBlockId(171, 6)).create());
		// register(builder("Grey Carpet", MATERIAL_CARPET_KEY) .id(new
		// MetaBlockId(171, 7)).create());
		// register(builder("Silver Carpet", MATERIAL_CARPET_KEY) .id(new
		// MetaBlockId(171, 8)).create());
		// register(builder("Cyan Carpet", MATERIAL_CARPET_KEY) .id(new
		// MetaBlockId(171, 9)).create());
		// register(builder("Purple Carpet", MATERIAL_CARPET_KEY) .id(new
		// MetaBlockId(171, 10)).create());
		// register(builder("Blue Carpet", MATERIAL_CARPET_KEY) .id(new
		// MetaBlockId(171, 11)).create());
		// register(builder("Brown Carpet", MATERIAL_CARPET_KEY) .id(new
		// MetaBlockId(171, 12)).create());
		// register(builder("Green Carpet", MATERIAL_CARPET_KEY) .id(new
		// MetaBlockId(171, 13)).create());
		// register(builder("Red Carpet", MATERIAL_CARPET_KEY) .id(new
		// MetaBlockId(171, 14)).create());
		// register(builder("Black Carpet", MATERIAL_CARPET_KEY) .id(new
		// MetaBlockId(171, 15)).create());
		//
		// register(builder("Hardened Clay", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(172,
		// 0)).hardness(1.25F).blastResistence(30.0F).create());
		// register(builder("Block of Coal", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(173, 0)).hardness(5.0F).blastResistence(30.0F).create());
		// register(builder("Packed Ice", MATERIAL_PACKEDICE_KEY) .id(new
		// MetaBlockId(174, 0)).hardness(2.5F).blastResistence(0.5F).create());
		//
		// //more plants
		// register(builder("Sunflower", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(175, 0)).create());
		// register(builder("Lilac", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(175, 1)).create());
		// register(builder("Tall Grass", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(175, 2)).create());
		// register(builder("Large Fern", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(175, 3)).create());
		// register(builder("Rose Bush", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(175, 4)).create());
		// register(builder("Peony", MATERIAL_PLANTS_KEY) .id(new
		// MetaBlockId(175, 5)).create());
		//
		// register(builder("Inverted Daylight Sensor", MATERIAL_WOOD_KEY)
		// .id(new MetaBlockId(178,
		// 0)).hardness(0.2F).blastResistence(1.0F).create());
		//
		// register(builder("Red Sandstone", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(179, 0)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Chiseled Red Sandstone", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(179, 1)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Smooth Red Sandstone", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(179, 2)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Red Standstone Stairs", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(180, 0)).hardness(0.8F).blastResistence(4.0F).create());
		// register(builder("Double Red Sandstone Slab", MATERIAL_ROCK_KEY)
		// .id(new MetaBlockId(181,
		// 0)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Smooth Double Red Sandstone Slab",
		// MATERIAL_ROCK_KEY) .id(new MetaBlockId(181,
		// 8)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Red Sandstone Slab", MATERIAL_ROCK_KEY) .id(new
		// MetaBlockId(182, 0)).hardness(2.0F).blastResistence(10.0F).create());
		// register(builder("Upper Red Sandstone Slab", MATERIAL_ROCK_KEY)
		// .id(new MetaBlockId(182,
		// 8)).hardness(2.0F).blastResistence(10.0F).create());
		//
		// register(builder("Spruce Fence Gate", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(183, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Birch Fence Gate", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(184, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Jungle Fence Gate", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(185, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Dark Oak Fence Gate", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(186, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Acacia Fence Gate", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(187, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Spruce Fence", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(188, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Birch Fence", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(189, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Jungle Fence", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(190, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Dark Oak Fence", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(191, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Acacia Fence", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(192, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Spruce Door", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(193, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Birch Door", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(194, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Jungle Door", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(195, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Acacia Door", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(196, 0)).hardness(2.0F).blastResistence(15.0F).create());
		// register(builder("Dark Oak Door", MATERIAL_WOOD_KEY) .id(new
		// MetaBlockId(197, 0)).hardness(2.0F).blastResistence(15.0F).create());

		// @formatter:on
	}

	protected void register(String name, String material, float hardness, float blastResistence, int[] ids) {
		Builder builder = builder(name, material).maxStack(64);
		for (int id : ids) {
			register(new BlockId(id), builder.hardness(hardness).blastResistence(blastResistence).create());
		}
	}

	protected Builder builder(String name, String material) {
		return new Builder().name(name).material(worldProvider.getMaterialRegistry().getByKey(material.toUpperCase())).maxStack(64).friction(0.6F);
	}
}