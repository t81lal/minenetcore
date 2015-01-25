package org.topdank.minenet.api;

import org.topdank.minenet.api.entity.living.player.PlayerController;
import org.topdank.minenet.api.entity.provider.EntityProvider;
import org.topdank.minenet.api.world.WorldController;
import org.topdank.minenet.api.world.block.art.PaintingRegistry;

public abstract class BotVersionProvider {

	private final EntityProvider entityProvider;
	private final PaintingRegistry paintingRegistry;

	private final WorldController worldController;
	private final PlayerController playerController;

	public BotVersionProvider(EntityProvider entityProvider, PaintingRegistry paintingRegistry, WorldController worldController,
			PlayerController playerController) {
		this.entityProvider = entityProvider;
		this.paintingRegistry = paintingRegistry;
		this.worldController = worldController;
		this.playerController = playerController;

	}

	public EntityProvider getEntityProvider() {
		return entityProvider;
	}

	public PaintingRegistry getPaintingRegistry() {
		return paintingRegistry;
	}

	public WorldController getWorldController() {
		return worldController;
	}

	public PlayerController getPlayerController() {
		return playerController;
	}
}