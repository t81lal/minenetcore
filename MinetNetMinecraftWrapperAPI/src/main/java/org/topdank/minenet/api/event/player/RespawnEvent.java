package org.topdank.minenet.api.event.player;

import org.topdank.minenet.api.world.settings.Difficulty;
import org.topdank.minenet.api.world.settings.Dimension;
import org.topdank.minenet.api.world.settings.GameMode;
import org.topdank.minenet.api.world.settings.WorldType;

import eu.bibl.eventbus.Event;

public class RespawnEvent implements Event {

	private Dimension dimension;
	private Difficulty difficulty;
	private GameMode gameMode;
	private WorldType worldType;

	public RespawnEvent(Dimension dimension, Difficulty difficulty, GameMode gameMode, WorldType worldType) {
		this.dimension = dimension;
		this.difficulty = difficulty;
		this.gameMode = gameMode;
		this.worldType = worldType;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public GameMode getGameMode() {
		return gameMode;
	}

	public WorldType getWorldType() {
		return worldType;
	}
}