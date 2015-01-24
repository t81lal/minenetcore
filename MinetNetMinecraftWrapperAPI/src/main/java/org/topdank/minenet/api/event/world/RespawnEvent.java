package org.topdank.minenet.api.event.world;

import org.topdank.minenet.api.world.settings.Difficulty;
import org.topdank.minenet.api.world.settings.Dimension;
import org.topdank.minenet.api.world.settings.GameMode;
import org.topdank.minenet.api.world.settings.WorldType;

import eu.bibl.eventbus.Event;

public class RespawnEvent implements Event {
	
	private final Dimension respawnDimension;
	private final Difficulty difficulty;
	private final GameMode gameMode;
	private final WorldType worldType;
	
	public RespawnEvent(Dimension respawnDimension, Difficulty difficulty, GameMode gameMode, WorldType worldType) {
		this.respawnDimension = respawnDimension;
		this.difficulty = difficulty;
		this.gameMode = gameMode;
		this.worldType = worldType;
	}
	
	public Dimension getRespawnDimension() {
		return respawnDimension;
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