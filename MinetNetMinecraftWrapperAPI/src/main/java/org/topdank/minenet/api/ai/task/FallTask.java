package org.topdank.minenet.api.ai.task;

import org.topdank.minenet.api.BotContext;
import org.topdank.minenet.api.ai.task.activity.WalkActivity;
import org.topdank.minenet.api.entity.living.player.LocalPlayer;
import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.world.World;
import org.topdank.minenet.api.world.block.id.BlockId;
import org.topdank.minenet.api.world.block.provider.registry.BlockData;

public class FallTask implements Task {

	private final BotContext context;

	public FallTask(BotContext context) {
		this.context = context;
	}

	@Override
	public synchronized boolean isPreconditionMet() {
		LocalPlayer player = context.getWorld().getLocalPlayer();
		if (player == null)
			return false;
		return !player.isOnGround();
	}

	@Override
	public synchronized boolean start(String... options) {
		return isPreconditionMet();
	}

	@Override
	public synchronized void stop() {
	}

	@Override
	public synchronized void run() {
		World world = context.getWorld();
		LocalPlayer player = world.getLocalPlayer();
		if ((player == null) || (world == null))
			return;
		double speed = WalkActivity.WALKING_SPEED;
		BlockLocation location = new BlockLocation(player.getLocation());
		if (player.isInLiquid())
			speed *= WalkActivity.LIQUID_FACTOR;
		else if (!world.getPathSearchProvider().getWorldPhysics().canClimb(location))
			speed *= WalkActivity.FALL_FACTOR;
		int lowestY = location.getY();
		while (true) {
			int id = world.getBlockData(new BlockLocation(location.getX(), (lowestY - 1), location.getZ()));
			BlockData data = world.getBlockRegistry().getByKey(BlockId.create(id));
			if (data.isSolid() || (lowestY <= 0))
				break;
			lowestY--;
		}
		player.setY(player.getY() + Math.max(-speed, lowestY - player.getY()));
	}

	@Override
	public synchronized boolean isActive() {
		LocalPlayer player = context.getWorld().getLocalPlayer();
		if (player == null)
			return false;
		return !player.isOnGround();
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
		if (context.getTaskManager().hasActivity() && (context.getTaskManager().getActivity() instanceof WalkActivity))
			return false;
		return true;
	}

	@Override
	public String getName() {
		return "Fall";
	}

	@Override
	public String getOptionDescription() {
		return "";
	}
}