package org.topdank.minenet.api.event.spawn;

import org.topdank.eventbus.Event;
import org.topdank.minenet.api.entity.living.player.PlayerEntity;

public class PlayerSpawnEvent implements Event {

	private PlayerEntity player;

	public PlayerSpawnEvent(PlayerEntity player) {
		this.player = player;
	}

	public PlayerEntity getPlayer() {
		return player;
	}
}