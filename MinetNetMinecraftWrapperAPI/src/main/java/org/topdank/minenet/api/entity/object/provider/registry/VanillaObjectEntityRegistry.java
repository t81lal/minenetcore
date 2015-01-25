package org.topdank.minenet.api.entity.object.provider.registry;

public class VanillaObjectEntityRegistry extends ObjectEntityRegistry {

	@Override
	public void register() {
		register(1, "Boat");
		register(2, "Item");
		register(10, "Minecart");
		register(11, "StorageMinecart");
		register(12, "PoweredMinecart");
		register(60, "Arrow");
		register(61, "SnowBall");
		register(63, "FireBall");
		register(66, "WitherSkull");
		register(71, "ItemFrame");
		register(90, "FishingBob");
	}
}