package org.topdank.minenet.api.ai.task.activity;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.topdank.minenet.api.BotContext;
import org.topdank.minenet.api.ai.pathfinding.PathNode;
import org.topdank.minenet.api.ai.pathfinding.PathSearch;
import org.topdank.minenet.api.ai.pathfinding.PathSearchProvider;
import org.topdank.minenet.api.entity.living.player.LocalPlayer;
import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.world.World;
import org.topdank.minenet.api.world.block.id.BlockId;

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
	//	private BlockLocation stepTarget;
	private PathNode nextStep;
	//	private boolean searchCompleted;
	private int ticksSinceStepChange = 0;

	public WalkActivity(BotContext context, PathSearchProvider searchProvider, BlockLocation target) {
		this(context, searchProvider, target, false);
	}

	public WalkActivity(BotContext context, PathSearchProvider searchProvider, BlockLocation target, boolean keepWalking) {
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
				PathSearch search = searchProvider.provideSearch(ourLocation, target);
				while (!search.isDone() && ((thread == null) || !thread.isCancelled())) {
					search.step();
				}
				return search.getPath();
			}
		});
		startTime = System.currentTimeMillis();
	}

	public long getStartTime() {
		return startTime;
	}

	@Override
	public void run() {
		if ((thread != null) && !thread.isDone()) {
			// if ((timeout > 0) && ((System.currentTimeMillis() - startTime) > timeout)) {
			// thread.cancel(true);
			// thread = null;
			// nextStep = null;
			// return;
			// }
		} else if ((thread != null) && thread.isDone() && !thread.isCancelled()) {
			try {
				nextStep = thread.get();
				System.out.println("Path found, walking...");
				ticksSinceStepChange = 0;
			} catch (Exception exception) {
				exception.printStackTrace();
				nextStep = null;
				return;
			} finally {
				thread = null;
			}
		}
		if (nextStep != null) {
			LocalPlayer player = context.getWorld().getLocalPlayer();
			System.out.println(" -> Moving from " + player.getLocation() + " to " + nextStep);
			if ((nextStep.getNext() != null) && (player.getLocation().distanceSquared(nextStep.getNext().getLocation()) < 0.2)) {
				nextStep = nextStep.getNext();
				ticksSinceStepChange = 0;
			}
			if (player.getLocation().distanceSquared(nextStep.getLocation()) > 4) {
				nextStep = null;
				return;
			}
			ticksSinceStepChange++;
			if (ticksSinceStepChange > 80) {
				nextStep = null;
				return;
			}
			double speed = WALKING_SPEED;
			BlockLocation location = nextStep.getLocation();
			BlockLocation block = new BlockLocation(player.getLocation());
			double x = location.getX() + 0.5, y = location.getY(), z = location.getZ() + 0.5;
			boolean inLiquid = player.isInLiquid();

			if (context.getWorld().getBlockRegistry().getByKey(BlockId.create(context.getWorld().getBlockData(block.offset(0, -1, 0)))).getName().equals("Soul Sand")) {
				if (context.getWorld().getBlockRegistry().getByKey(BlockId.create(context.getWorld().getBlockData(location.offset(0, -1, 0)))).getName().equals("Soul Sand"))
					y -= 0.12;
				speed *= LIQUID_FACTOR;
			} else if (inLiquid)
				speed *= LIQUID_FACTOR;
			if (player.getY() != y) {
				if (!inLiquid && !context.getWorld().getPathSearchProvider().getWorldPhysics().canClimb(block))
					if (player.getY() < y)
						player.jump();
				// speed *= jumpFactor;
				// else
				// speed *= fallFactor;
				player.setY(player.getY() + (player.getY() < y ? Math.min(speed, y - player.getY()) : Math.max(-speed, y - player.getY())));
			}
			if (player.getX() != x)
				player.setX(player.getX() + (player.getX() < x ? Math.min(speed, x - player.getX()) : Math.max(-speed, x - player.getX())));
			if (player.getZ() != z)
				player.setZ(player.getZ() + (player.getZ() < z ? Math.min(speed, z - player.getZ()) : Math.max(-speed, z - player.getZ())));
			if ((player.getX() == x) && (player.getY() == y) && (player.getZ() == z)) {
				nextStep = nextStep.getNext();
				ticksSinceStepChange = 0;
			}
		}
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