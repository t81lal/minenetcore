package org.topdank.minenet.api.bot;

import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.topdank.minenet.api.BotContext;
import org.topdank.minenet.api.entity.BoundingBox;
import org.topdank.minenet.api.entity.living.player.LocalPlayer;
import org.topdank.minenet.api.world.World;
import org.topdank.minenet.api.world.ai.pathfinding.PathNode;
import org.topdank.minenet.api.world.ai.pathfinding.PathSearch;
import org.topdank.minenet.api.world.block.Block;
import org.topdank.minenet.api.world.block.BlockType;
import org.topdank.minenet.api.world.location.BlockLocation;

public class WalkActivity implements Activity {

	public static final double WALKING_SPEED = 0.15;
	public static final double SPRINT_SPEED = 0.28;
	public static final double JUMP_FACTOR = 3;
	public static final double FALL_FACTOR = 4;
	public static final double LIQUID_FACTOR = 0.5;
	public static final int TIMEOUT_MS_TIME = 60000;

	private final ExecutorService service = Executors.newSingleThreadExecutor();

	private final BotContext context;
	private final BlockLocation target;
	private final long startTime;
	private Future<PathNode> thread;
	private BlockLocation stepTarget;
	private PathNode nextStep;
	private boolean searchCompleted;
	private int ticksSinceStepChange = 0;

	public WalkActivity(BotContext context, BlockLocation target) {
		this(context, target, false);
	}

	public WalkActivity(BotContext context, BlockLocation target, boolean keepWalking) {
		this.context = context;
		this.target = target;
		if (keepWalking) {
			Activity activity = context.getTaskManager().getActivity();
			if ((activity != null) && (activity instanceof WalkActivity) && ((WalkActivity) activity).isMoving()) {
				WalkActivity walkActivity = (WalkActivity) activity;
				nextStep = walkActivity.nextStep;
				ticksSinceStepChange = walkActivity.ticksSinceStepChange;
			}
		}
		thread = service.submit(new Callable<PathNode>() {
			@Override
			public PathNode call() throws Exception {
				World world = context.getWorld();
				LocalPlayer player = world.getLocalPlayer();
				if ((world == null) || (player == null) || (target == null))
					return null;
				BlockLocation ourLocation = new BlockLocation(player.getLocation());
				PathSearch search = world.getPathSearchProvider().provideSearch(ourLocation, target);
				while (!search.isDone() && ((thread == null) || !thread.isCancelled())) {
					search.step();
				}
				return search.getPath();
			}
		});
		startTime = System.currentTimeMillis();
	}

	@Override
	public void run() {
		if (!thread.isDone()) {
			if (TIMEOUT_MS_TIME > 0 && System.currentTimeMillis() - startTime > TIMEOUT_MS_TIME) {
				thread.cancel(true);
				setNextStep(null);
			} else {
				LocalPlayer player = context.getWorld().getLocalPlayer();
				player.setYaw((player.getYaw() + 15) % 360);
			}
			return;
		} else if (thread.isDone() && !thread.isCancelled() && !searchCompleted) {
			searchCompleted = true;
			try {
				setNextStep(thread.get());
				if (nextStep == null) {
					System.out.println("Error! Could not find path!");
					return;
				} else
					System.out.println("Path found, walking...");
			} catch (Exception exception) {
				exception.printStackTrace();
				setNextStep(null);
				return;
			}
		} else if (thread.isCancelled())
			return;
		searchCompleted = true;
		if (nextStep != null) {
			LocalPlayer player = context.getWorld().getLocalPlayer();
			if (player.getLocation().distanceSquared(stepTarget) > 4) {
				nextStep = null;
				System.out.println("Failed1");
				return;
			}
			ticksSinceStepChange++;
			if (ticksSinceStepChange > 80 || context.getWorld().isColliding(player.getBoundingBox())) {
				nextStep = null;
				System.out.println("Failed2");
				return;
			}
			BlockLocation nextStepTarget = findNextStepTarget();
			if (player.getLocation().distance(stepTarget.getX(),
					Math.abs(player.getY() - stepTarget.getY()) < 1 ? player.getY() : stepTarget.getY(), stepTarget.getZ()) < 0.3
					|| (nextStepTarget != null && player.getLocation().distance(nextStepTarget) < stepTarget
							.distance(nextStepTarget))) {
				setNextStep(nextStep.getNext());
				if (nextStep == null) {
					System.out.println("Failed3");
					return;
				}
				stepTarget = nextStepTarget;
				nextStepTarget = findNextStepTarget();
			}
			System.out.println(" -> Moving from " + player.getLocation() + " to " + nextStep);

			double x = stepTarget.getX(), y = stepTarget.getY(), z = stepTarget.getZ();
			// System.out.println("TARGETING [" + x + "," + y + "," + z + "]");
			double dist = Math.hypot(x - player.getX(), z - player.getZ());
			if (dist < 0.5 && nextStepTarget == null) {
				player.setMotionX(0);
				player.setMotionZ(0);
				player.accelerate(Math.atan2(z - player.getZ(), x - player.getX()), 0, Math.min(dist / 4, WALKING_SPEED / 4),
						Math.min(dist, WALKING_SPEED));
			} else
				player.accelerate(Math.atan2(z - player.getZ(), x - player.getX()), 0, WALKING_SPEED / 4,
						Math.min(dist, WALKING_SPEED));
			if (y > player.getY()
					&& (y - player.getY() > 0.5 || dist > 1.5 || !context.getWorld().isColliding(
							player.getBoundingBoxAt(stepTarget.getX(), stepTarget.getY() - 1, stepTarget.getZ()))))
				player.jump();
		}
	}

	private BlockLocation findNextStepTarget() {
		LocalPlayer player = context.getWorld().getLocalPlayer();
		BlockLocation nextStepTarget = getNextStep(1);
		if (nextStepTarget != null
				&& nextStepTarget.getY() > stepTarget.getY()
				&& nextStepTarget.getX() == stepTarget.getX()
				&& nextStepTarget.getY() == stepTarget.getY()
				&& !context.getWorld().isInMaterial(
						player.getBoundingBoxAt(nextStepTarget.getX() + 0.5, nextStepTarget.getY(), nextStepTarget.getZ() + 0.5),
						BlockType.WATER, BlockType.STATIONARY_WATER, BlockType.LAVA, BlockType.STATIONARY_LAVA, BlockType.LADDER,
						BlockType.VINE))
			nextStepTarget = getNextStep(2);
		if (nextStepTarget != null) {
			BoundingBox bounds = player.getBoundingBox();
			if (nextStepTarget.getY() > player.getY() && nextStepTarget.getY() - player.getY() > 0.5) {
				if (!collides(
						context.getWorld(),
						player.getBoundingBoxAt(player.getX() + (nextStepTarget.getX() - player.getX()) / 2,
								nextStepTarget.getY() - 0.5, player.getZ() + (nextStepTarget.getZ() - player.getZ()) / 2), bounds)) {
					BlockLocation nextNextStepTarget = getNextStep(2);
					if (nextNextStepTarget != null
							&& nextNextStepTarget.getY() == nextStepTarget.getY()
							&& !collides(context.getWorld(), player.getBoundingBoxAt(nextNextStepTarget.getX(),
									nextStepTarget.getY() - 0.5, nextNextStepTarget.getZ()), bounds)) {
						nextStepTarget = new BlockLocation(nextNextStepTarget.getX(), nextStepTarget.getY() - 0.5,
								nextNextStepTarget.getZ());
					}
				}
			}
		}
		return nextStepTarget;
	}

	private boolean collides(World world, BoundingBox target, BoundingBox current) {
		Set<Block> blocks = world.getCollidingBlocks(target);
		blocks.removeAll(world.getCollidingBlocks(current));
		return !blocks.isEmpty();
	}

	private BlockLocation getNextStep(int lookahead) {
		PathNode nextStep = this.nextStep;
		for (int i = 0; i < lookahead && nextStep != null; i++)
			nextStep = nextStep.getNext();
		if (nextStep == null)
			return null;
		return new BlockLocation(nextStep.getLocation());
	}

	private void setNextStep(PathNode step) {
		nextStep = step;
		stepTarget = nextStep != null ? new BlockLocation(nextStep.getLocation()) : null;
		ticksSinceStepChange = 0;
	}

	@Override
	public void stop() {
		if ((thread != null) && !thread.isDone())
			thread.cancel(true);
		nextStep = null;
	}

	public boolean isMoving() {
		return nextStep != null;
	}

	@Override
	public boolean isActive() {
		return (thread != null) || (nextStep != null);
	}

	public BlockLocation getTarget() {
		return target;
	}
}