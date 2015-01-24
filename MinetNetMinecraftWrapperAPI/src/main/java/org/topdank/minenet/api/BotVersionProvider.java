package org.topdank.minenet.api;

import org.topdank.minenet.api.entity.living.LivingEntityRegistry;
import org.topdank.minenet.api.entity.living.player.PlayerController;
import org.topdank.minenet.api.entity.object.ObjectEntityRegistry;
import org.topdank.minenet.api.entity.tile.TileEntityRegistry;
import org.topdank.minenet.api.world.WorldController;
import org.topdank.minenet.api.world.block.art.PaintingRegistry;

public abstract class BotVersionProvider {

	private final LivingEntityRegistry livingEntityRegistry;
	private final ObjectEntityRegistry objectEntityRegistry;
	private final TileEntityRegistry tileEntityRegistry;
	private final PaintingRegistry paintingRegistry;

	private final WorldController worldController;
	private final PlayerController playerController;

	public BotVersionProvider(LivingEntityRegistry livingEntityRegistry, ObjectEntityRegistry objectEntityRegistry,
			TileEntityRegistry tileEntityRegistry, PaintingRegistry paintingRegistry, WorldController worldController,
			PlayerController playerController) {
		this.livingEntityRegistry = livingEntityRegistry;
		this.objectEntityRegistry = objectEntityRegistry;
		this.tileEntityRegistry = tileEntityRegistry;
		this.paintingRegistry = paintingRegistry;
		this.worldController = worldController;
		this.playerController = playerController;

		livingEntityRegistry.register();
		objectEntityRegistry.register();
		tileEntityRegistry.register();
		paintingRegistry.register();
	}

	public LivingEntityRegistry getLivingEntityRegistry() {
		return livingEntityRegistry;
	}

	public ObjectEntityRegistry getObjectEntityRegistry() {
		return objectEntityRegistry;
	}

	public TileEntityRegistry getTileEntityRegistry() {
		return tileEntityRegistry;
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