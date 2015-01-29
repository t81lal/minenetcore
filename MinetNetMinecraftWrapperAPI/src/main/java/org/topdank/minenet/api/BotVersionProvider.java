package org.topdank.minenet.api;

import org.topdank.minenet.api.entity.living.player.PlayerController;
import org.topdank.minenet.api.entity.provider.EntityProvider;
import org.topdank.minenet.api.provider.Provider;
import org.topdank.minenet.api.world.WorldController;
import org.topdank.minenet.api.world.provider.WorldProvider;

public abstract class BotVersionProvider extends Provider {

	private final EntityProvider entityProvider;
	private final WorldProvider worldProvider;

	private final WorldController worldController;
	private final PlayerController playerController;

	public BotVersionProvider(EntityProvider entityProvider, WorldProvider worldProvider, WorldController worldController, PlayerController playerController) {
		this.entityProvider = entityProvider;
		this.worldProvider = worldProvider;
		this.worldController = worldController;
		this.playerController = playerController;

	}

	public EntityProvider getEntityProvider() {
		return entityProvider;
	}

	public WorldProvider getWorldProvider() {
		return worldProvider;
	}

	public WorldController getWorldController() {
		return worldController;
	}

	public PlayerController getPlayerController() {
		return playerController;
	}
}