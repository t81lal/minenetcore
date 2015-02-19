package org.topdank.minenet.api.ai.task;

import org.topdank.minenet.api.BotContext;
import org.topdank.minenet.api.ai.task.activity.Activity;
import org.topdank.minenet.api.ai.task.activity.WalkActivity;
import org.topdank.minenet.api.entity.Entity;
import org.topdank.minenet.api.entity.living.player.LocalPlayer;
import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;
import org.topdank.minenet.api.world.block.id.BlockId;

public class FollowTask implements Task {

	private final BotContext context;
	private Entity following = null;
	private BlockLocation lastLocation;

	public FollowTask(BotContext context) {
		this.context = context;
	}

	public synchronized void follow(Entity entity) {
		following = entity;
	}

	public synchronized Entity following() {
		return following;
	}

	@Override
	public synchronized boolean isPreconditionMet() {
		return following != null;
	}

	@Override
	public synchronized boolean start(String... options) {
		if (options.length > 0) {
			String name = options[0];
			following = context.getWorld().getPlayerByName(name);
		}
		return following != null;
	}

	@Override
	public void stop() {
		following = null;
	}

	@Override
	public void run() {
		DefaultMinecraftWorld world = context.getWorld();
		LocalPlayer player = world.getLocalPlayer();
		if ((following == null) || (player == null))
			return;
		BlockLocation location = new BlockLocation(following.getLocation());
		if ((lastLocation == null) || !lastLocation.equals(location)) {
			lastLocation = location;
			BlockLocation original = location;
			BlockLocation below = location.offset(0, -1, 0);
			while (!world.getBlockRegistry().getByKey(BlockId.create(world.getBlockData(below))).isSolid() && !world.canClimb(below)) {
				location = below;
				below = below.offset(0, -1, 0);
				if ((original.getY() - location.getY()) >= 5)
					return;
			}
			context.getTaskManager().setActivity(new WalkActivity(context, world.getPathSearchProvider(), location, true));
			System.out.println("set");
		}
	}

	@Override
	public boolean isActive() {
		boolean active = following != null;
		if (active) {
			LocalPlayer player = context.getWorld().getLocalPlayer();
			if (player == null)
				return true;
			player.face(following.getX(), following.getY() + 1, following.getZ());
			Activity activity = context.getTaskManager().getActivity();
			if ((activity == null) || !(activity instanceof WalkActivity))
				return active;
			WalkActivity walkActivity = (WalkActivity) activity;
			if (walkActivity.isActive()
					&& (((player.getLocation().distance(following.getLocation()) < 1) || (following.getLocation().distance(walkActivity.getTarget()) > 3)) && player.isOnGround())) {
				context.getTaskManager().setActivity(null);
			}
		}
		return active;
	}

	@Override
	public TaskPriority getPriority() {
		return TaskPriority.NORMAL;
	}

	@Override
	public boolean isExclusive() {
		return false;
	}

	@Override
	public boolean ignoresExclusive() {
		return false;
	}

	@Override
	public String getName() {
		return "Follow";
	}

	@Override
	public String getOptionDescription() {
		return "[player]";
	}
}