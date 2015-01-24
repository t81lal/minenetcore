package org.topdank.minenet.api.event.entity;

import java.util.Map;

import org.topdank.minenet.api.item.ItemStack;
import org.topdank.minenet.api.world.location.PreciseLocation;
import org.topdank.minenet.api.world.settings.GameMode;

public class PlayerSpawnEvent extends MetaEntitySpawnEvent {
	
	private final String playerName;
	private final ItemStack heldItem;
	private GameMode gameMode;
	
	public PlayerSpawnEvent(int playerId, String playerName, ItemStack heldItem, PreciseLocation location, float yaw, float pitch, GameMode gameMode, Map<Integer, Object> metadata) {
		super(playerId, location, yaw, pitch, metadata);
		this.playerName = playerName;
		this.gameMode = gameMode;
		this.heldItem = heldItem;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public ItemStack getHeldItem() {
		return heldItem;
	}
	
	public GameMode getGameMode() {
		return gameMode;
	}
}