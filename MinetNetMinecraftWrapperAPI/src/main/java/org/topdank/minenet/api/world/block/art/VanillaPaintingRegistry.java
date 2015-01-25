package org.topdank.minenet.api.world.block.art;


public class VanillaPaintingRegistry extends PaintingRegistry {

	@Override
	public void register() {
		register(new Painting("Kebab", 16, 16, 0, 0));
		register(new Painting("Aztec", 16, 16, 16, 0));
		register(new Painting("Alban", 16, 16, 32, 0));
		register(new Painting("Aztec2", 16, 16, 48, 0));
		register(new Painting("Bomb", 16, 16, 64, 0));
		register(new Painting("Plant", 16, 16, 80, 0));
		register(new Painting("Wasteland", 16, 16, 96, 0));
		register(new Painting("Pool", 32, 16, 0, 32));
		register(new Painting("Courbet", 32, 16, 32, 32));
		register(new Painting("Sea", 32, 16, 64, 32));
		register(new Painting("Sunset", 32, 16, 96, 32));
		register(new Painting("Creebet", 32, 16, 128, 32));
		register(new Painting("Wanderer", 16, 32, 0, 64));
		register(new Painting("Graham", 16, 32, 16, 64));
		register(new Painting("Match", 32, 32, 0, 128));
		register(new Painting("Bust", 32, 32, 32, 128));
		register(new Painting("Stage", 32, 32, 64, 128));
		register(new Painting("Void", 32, 32, 96, 128));
		register(new Painting("SkullAndRoses", 32, 32, 128, 128));
		register(new Painting("Fighters", 64, 32, 0, 96));
		register(new Painting("Pointer", 64, 64, 0, 192));
		register(new Painting("Pigscene", 64, 64, 64, 192));
		register(new Painting("BurningSkull", 64, 64, 128, 192));
		register(new Painting("Skeleton", 64, 48, 192, 64));
		register(new Painting("DonkeyKong", 64, 48, 192, 112));
	}
}