package org.topdank.minenet.api.entity.living.player;

import org.topdank.minenet.api.BotContext;
import org.topdank.minenet.api.provider.Controller;

public abstract class PlayerController extends Controller<LocalPlayer> {
	
	public PlayerController(BotContext context) {
		super(context);
	}
	
	public abstract void sprint(boolean state);
	
	public abstract void crouch(boolean state);
	
	public abstract void leaveBed();
	
	public abstract void hotbarSwitch(byte slot);
	
	public abstract void swing();
}