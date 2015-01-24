package org.topdank.minenet.api.entity.object;

import org.topdank.minenet.api.entity.object.item.ItemEntity;
import org.topdank.minenet.api.entity.object.item.ItemFrameEntity;
import org.topdank.minenet.api.entity.object.projectile.ArrowEntity;
import org.topdank.minenet.api.entity.object.projectile.FireBallEntity;
import org.topdank.minenet.api.entity.object.projectile.WitherSkullEntity;
import org.topdank.minenet.api.entity.object.projectile.thrown.FishingBobEntity;
import org.topdank.minenet.api.entity.object.projectile.thrown.SnowBallEntity;
import org.topdank.minenet.api.entity.object.vehicle.BoatEntity;
import org.topdank.minenet.api.entity.object.vehicle.MinecartEntity;
import org.topdank.minenet.api.entity.object.vehicle.PoweredMinecartEntity;
import org.topdank.minenet.api.entity.object.vehicle.StorageMinecartEntity;

public class VanillaObjectEntityRegistry extends ObjectEntityRegistry {

	@Override
	public void register() {
		register(BoatEntity.class, 1, "Boat");
		register(ItemEntity.class, 2, "Item");
		register(MinecartEntity.class, 10, "Minecart");
		register(StorageMinecartEntity.class, 11, "StorageMinecart");
		register(PoweredMinecartEntity.class, 12, "PoweredMinecart");
		register(ArrowEntity.class, 60, "Arrow");
		register(SnowBallEntity.class, 61, "SnowBall");
		register(FireBallEntity.class, 63, "FireBall");
		register(WitherSkullEntity.class, 66, "WitherSkull");
		register(ItemFrameEntity.class, 71, "ItemFrame");
		register(FishingBobEntity.class, 90, "FishingBob");
	}
}