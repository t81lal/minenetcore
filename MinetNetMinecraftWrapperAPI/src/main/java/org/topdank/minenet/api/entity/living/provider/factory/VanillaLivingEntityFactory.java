package org.topdank.minenet.api.entity.living.provider.factory;

import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.entity.living.ageable.BatEntity;
import org.topdank.minenet.api.entity.living.ageable.ChickenEntity;
import org.topdank.minenet.api.entity.living.ageable.CowEntity;
import org.topdank.minenet.api.entity.living.ageable.HorseEntity;
import org.topdank.minenet.api.entity.living.ageable.MushroomCowEntity;
import org.topdank.minenet.api.entity.living.ageable.PigEntity;
import org.topdank.minenet.api.entity.living.ageable.RabbitEntity;
import org.topdank.minenet.api.entity.living.ageable.SheepEntity;
import org.topdank.minenet.api.entity.living.ageable.SnowManEntity;
import org.topdank.minenet.api.entity.living.ageable.SquidEntity;
import org.topdank.minenet.api.entity.living.ageable.VillagerEntity;
import org.topdank.minenet.api.entity.living.ageable.tameable.OcelotEntity;
import org.topdank.minenet.api.entity.living.ageable.tameable.WolfEntity;
import org.topdank.minenet.api.entity.living.monsters.BlazeEntity;
import org.topdank.minenet.api.entity.living.monsters.CaveSpiderEntity;
import org.topdank.minenet.api.entity.living.monsters.CreeperEntity;
import org.topdank.minenet.api.entity.living.monsters.EnderDragonEntity;
import org.topdank.minenet.api.entity.living.monsters.EndermanEntity;
import org.topdank.minenet.api.entity.living.monsters.EndermiteEntity;
import org.topdank.minenet.api.entity.living.monsters.GhastEntity;
import org.topdank.minenet.api.entity.living.monsters.GiantZombieEntity;
import org.topdank.minenet.api.entity.living.monsters.GuardianEntity;
import org.topdank.minenet.api.entity.living.monsters.IronGolemEntity;
import org.topdank.minenet.api.entity.living.monsters.MagmaCubeEntity;
import org.topdank.minenet.api.entity.living.monsters.SilverFishEntity;
import org.topdank.minenet.api.entity.living.monsters.SkeletonEntity;
import org.topdank.minenet.api.entity.living.monsters.SlimeEntity;
import org.topdank.minenet.api.entity.living.monsters.SpiderEntity;
import org.topdank.minenet.api.entity.living.monsters.WitchEntity;
import org.topdank.minenet.api.entity.living.monsters.WitherEntity;
import org.topdank.minenet.api.entity.living.monsters.ZombieEntity;
import org.topdank.minenet.api.entity.living.monsters.ZombiePigmanEntity;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;

public class VanillaLivingEntityFactory extends LivingEntityFactory {

	@Override
	public LivingEntity create(int typeId, DefaultMinecraftWorld world, Integer id) throws IllegalArgumentException {
		switch (typeId) {
			case 50:
				return new CreeperEntity(world, id);
			case 51:
				return new SkeletonEntity(world, id);
			case 52:
				return new SpiderEntity(world, id);
			case 53:
				return new GiantZombieEntity(world, id);
			case 54:
				return new ZombieEntity(world, id);
			case 55:
				return new SlimeEntity(world, id);
			case 56:
				return new GhastEntity(world, id);
			case 57:
				return new ZombiePigmanEntity(world, id);
			case 58:
				return new EndermanEntity(world, id);
			case 59:
				return new CaveSpiderEntity(world, id);
			case 60:
				return new SilverFishEntity(world, id);
			case 61:
				return new BlazeEntity(world, id);
			case 62:
				return new MagmaCubeEntity(world, id);
			case 63:
				return new EnderDragonEntity(world, id);
			case 64:
				return new WitherEntity(world, id);
			case 65:
				return new BatEntity(world, id);
			case 66:
				return new WitchEntity(world, id);
			case 67:
				return new EndermiteEntity(world, id);
			case 68:
				return new GuardianEntity(world, id);
			case 90:
				return new PigEntity(world, id);
			case 91:
				return new SheepEntity(world, id);
			case 92:
				return new CowEntity(world, id);
			case 93:
				return new ChickenEntity(world, id);
			case 94:
				return new SquidEntity(world, id);
			case 95:
				return new WolfEntity(world, id);
			case 96:
				return new MushroomCowEntity(world, id);
			case 97:
				return new SnowManEntity(world, id);
			case 98:
				return new OcelotEntity(world, id);
			case 99:
				return new IronGolemEntity(world, id);
			case 100:
				return new HorseEntity(world, id);
			case 101:
				return new RabbitEntity(world, id);
			case 120:
				return new VillagerEntity(world, id);
			default:
				throw new IllegalArgumentException("Invalid LivingEntity typeId: " + typeId);
		}
	}
}