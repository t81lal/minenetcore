package org.topdank.minenet.api.entity.object.provider.factory;

import org.topdank.minenet.api.entity.object.ObjectEntity;
import org.topdank.minenet.api.entity.object.item.ItemEntity;
import org.topdank.minenet.api.entity.object.item.ItemFrameEntity;
import org.topdank.minenet.api.entity.object.projectile.ArrowEntity;
import org.topdank.minenet.api.entity.object.projectile.FireBallEntity;
import org.topdank.minenet.api.entity.object.projectile.WitherSkullEntity;
import org.topdank.minenet.api.entity.object.projectile.thrown.FishingBobEntity;
import org.topdank.minenet.api.entity.object.projectile.thrown.PotionEntity;
import org.topdank.minenet.api.entity.object.projectile.thrown.SnowBallEntity;
import org.topdank.minenet.api.entity.object.vehicle.BoatEntity;
import org.topdank.minenet.api.entity.object.vehicle.MinecartEntity;
import org.topdank.minenet.api.entity.object.vehicle.PoweredMinecartEntity;
import org.topdank.minenet.api.entity.object.vehicle.StorageMinecartEntity;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class VanillaObjectEntityFactory extends ObjectEntityFactory {

	@Override
	public ObjectEntity create(int typeId, DefaultMinecraftWorld world, Integer id) throws IllegalArgumentException {
		switch (typeId) {
			case 1:
				return new BoatEntity(world, id);
			case 2:
				return new ItemEntity(world, id);
			case 10:
				return new MinecartEntity(world, id);
			case 11:
				return new StorageMinecartEntity(world, id);
			case 12:
				return new PoweredMinecartEntity(world, id);
			case 60:
				return new ArrowEntity(world, id);
			case 61:
				return new SnowBallEntity(world, id);
			case 63:
				return new FireBallEntity(world, id);
			case 66:
				return new WitherSkullEntity(world, id);
			case 71:
				return new ItemFrameEntity(world, id);
			case 73:
				return new PotionEntity(world, id);
			case 90:
				return new FishingBobEntity(world, id);
			default:
				throw new IllegalArgumentException("Invalid ObjectEntity typeId: " + typeId);
		}
	}
}