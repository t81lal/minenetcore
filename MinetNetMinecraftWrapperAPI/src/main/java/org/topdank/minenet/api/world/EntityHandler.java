package org.topdank.minenet.api.world;

import org.topdank.minenet.api.entity.Entity;
import org.topdank.minenet.api.entity.living.player.LocalPlayer;
import org.topdank.minenet.api.entity.living.player.PlayerEntity;

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
}