package org.topdank.minenet.api.world;

import org.topdank.minenet.api.entity.Entity;
import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.entity.living.player.LocalPlayer;
import org.topdank.minenet.api.entity.living.player.PlayerEntity;
import org.topdank.minenet.api.entity.object.ObjectEntity;
import org.topdank.minenet.api.entity.provider.EntityFactory;
import org.topdank.minenet.api.entity.tile.TileEntity;
import org.topdank.minenet.api.nbt.tag.builtin.CompoundTag;
import org.topdank.minenet.api.provider.registry.NameRegistry;

public abstract interface EntityHandler {

	public abstract Entity[] getEntities();

	public abstract Entity getEntityById(int id);

	public abstract void spawnEntity(Entity entity);

	public abstract void despawnEntity(int eId);

	public abstract void despawnEntity(Entity entity);

	public abstract PlayerEntity getPlayerByName(String name);

	public abstract PlayerEntity[] getPlayers();

	public abstract LocalPlayer getLocalPlayer();

	public abstract void watch(WatchableObject o);

	public abstract void unwatch(WatchableObject o);

	public abstract EntityFactory<LivingEntity, Integer> getLivingEntityFactory();

	public abstract NameRegistry getLivingEntityRegistry();

	public abstract EntityFactory<ObjectEntity, Integer> getObjectEntityFactory();

	public abstract NameRegistry getObjectEntityRegistry();

	public abstract EntityFactory<TileEntity, CompoundTag> getTileEntityFactory();

	public abstract NameRegistry getTileEntityRegistry();
}