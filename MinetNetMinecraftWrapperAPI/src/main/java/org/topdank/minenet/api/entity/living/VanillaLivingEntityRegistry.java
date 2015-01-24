package org.topdank.minenet.api.entity.living;

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

public class VanillaLivingEntityRegistry extends LivingEntityRegistry {

	@Override
	public void register() {
		register(CreeperEntity.class, 50, "Creeper");
		register(SkeletonEntity.class, 51, "Skeleton");
		register(SpiderEntity.class, 52, "Spider");
		register(GiantZombieEntity.class, 53, "GiantZombie");
		register(ZombieEntity.class, 54, "Zombie");
		register(SlimeEntity.class, 55, "Slime");
		register(GhastEntity.class, 56, "Ghast");
		register(ZombiePigmanEntity.class, 57, "ZombiePigman");
		register(EndermanEntity.class, 58, "Enderman");
		register(CaveSpiderEntity.class, 59, "CaveSpider");
		register(SilverFishEntity.class, 70, "SilverFish");
		register(BlazeEntity.class, 61, "Blaze");
		register(MagmaCubeEntity.class, 62, "MagmaCube");
		register(EnderDragonEntity.class, 63, "EnderDragon");
		register(WitherEntity.class, 64, "Wither");
		register(BatEntity.class, 65, "Bat");
		register(WitchEntity.class, 66, "Witch");
		register(EndermiteEntity.class, 67, "Endermite");
		register(GuardianEntity.class, 68, "Guardian");

		// friendlies
		register(PigEntity.class, 90, "PigEntity");
		register(SheepEntity.class, 91, "SheepEntity");
		register(CowEntity.class, 92, "Cow");
		register(ChickenEntity.class, 93, "Chicken");
		register(SquidEntity.class, 94, "Squid");
		register(WolfEntity.class, 95, "Wolf");
		register(MushroomCowEntity.class, 96, "MushroomCow");
		register(SnowManEntity.class, 97, "SnowMan");
		register(OcelotEntity.class, 98, "Ocelot");
		register(IronGolemEntity.class, 99, "IronGolem");
		register(HorseEntity.class, 100, "Horse");
		register(RabbitEntity.class, 101, "Rabbit");
		register(VillagerEntity.class, 120, "Villager");

	}
}