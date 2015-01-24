package org.topdank.minenet.api.bot;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.topdank.minenet.api.BotContext;
import org.topdank.minenet.api.util.Timer;
import org.topdank.minenet.lib.auth.yggdrasil.YggdrasilSession;

public class BasicTaskManager extends Thread implements TaskManager {

	private final BotContext context;
	private final Map<Class<? extends Task>, Task> tasks = new HashMap<Class<? extends Task>, Task>();
	private final Map<Task, BigInteger> startTimes = new HashMap<Task, BigInteger>();
	private Activity activity;

	public BasicTaskManager(BotContext context) {
		super(((YggdrasilSession) context.getClient().getSession()).getUsername() + " TaskManager");
		this.context = context;

		registerTasks();
	}

	protected void registerTasks() {
		// registerTask(new FallTask(context));
		registerTask(new FollowTask(context));
	}

	@Override
	public synchronized boolean registerTask(Task task) {
		if (task == null)
			return false;
		if (tasks.get(task.getClass()) != null)
			return false;
		tasks.put(task.getClass(), task);
		return true;
	}

	@Override
	public synchronized boolean unregisterTask(Task task) {
		if (task == null)
			return false;
		return unregisterTask(task.getClass());
	}

	@Override
	public synchronized boolean unregisterTask(Class<? extends Task> taskClass) {
		if (taskClass == null)
			return false;
		Task task = tasks.remove(taskClass);
		if (task != null) {
			if (task.isActive())
				task.stop();
			startTimes.remove(task);
		}
		return task != null;
	}

	@Override
	public synchronized void update() {

		if (activity != null) {
			if (activity.isActive()) {
				activity.run();
				if ((activity == null) || ((activity != null) && !activity.isActive())) {
					activity.stop();
					activity = null;
				}
			} else {
				activity.stop();
				activity = null;
			}
		}

		List<Task> exclusiveIgnoringTasks = new ArrayList<Task>();
		Task highestExclusiveTask = null;
		int highestPriority = -1;
		BigInteger highestStartTime = null;
		for (Task task : tasks.values()) {
			boolean active = task.isActive();
			boolean hasStartTime = startTimes.containsKey(task);
			if (hasStartTime && !active)
				startTimes.remove(task);
			else if (!hasStartTime && active)
				startTimes.put(task, BigInteger.valueOf(System.currentTimeMillis()));
			if (!active && task.isPreconditionMet()) {
				if (task.start()) {
					startTimes.put(task, BigInteger.valueOf(System.currentTimeMillis()));
				} else {
					task.stop();
				}
			}
			if (task.isExclusive() && active) {
				int taskPriority = task.getPriority().ordinal();
				BigInteger taskStartTime = startTimes.get(task);
				if ((highestExclusiveTask == null) || (taskPriority > highestPriority)
						|| ((taskPriority == highestPriority) && (taskStartTime.compareTo(highestStartTime) < 0))) {
					highestExclusiveTask = task;
					highestPriority = taskPriority;
					highestStartTime = taskStartTime;
				}
			}
			if (task.ignoresExclusive())
				exclusiveIgnoringTasks.add(task);

		}

		if ((activity != null) || (highestExclusiveTask != null)) {
			if (activity != null) {
				if (highestExclusiveTask != null) {
					highestExclusiveTask.run();
					if (!highestExclusiveTask.isActive()) {
						highestExclusiveTask.stop();
						startTimes.remove(highestExclusiveTask);
					}
				}
			}
			for (Task task : exclusiveIgnoringTasks) {
				if (task.isActive()) {
					task.run();
					if (!task.isActive()) {
						task.stop();
						startTimes.remove(task);
					}
				}
			}
			return;
		}
		for (Task task : tasks.values()) {
			if (task.isActive()) {
				task.run();
				if (!task.isActive()) {
					task.stop();
					startTimes.remove(task);
				}
			}
		}
	}

	@Override
	public synchronized void stopAll() {
		for (Task task : tasks.values()) {
			if (task.isActive())
				task.stop();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public synchronized <T extends Task> T getTaskFor(Class<T> taskClass) {
		if (taskClass == null)
			return null;
		return (T) tasks.get(taskClass);
	}

	@Override
	public List<Task> getRegisteredTasks() {
		return new ArrayList<Task>(tasks.values());
	}

	@Override
	public void start() {
		super.start();
	}

	private final Timer timer = new Timer(20, 20);

	@Override
	public void run() {
		try {
			while (true) {
				timer.update();
				for (int i = 0; i < timer.getElapsedTicks(); i++) {
					update();
				}
				if (timer.getFPSCoolDown() > 0) {
					try {
						Thread.sleep(timer.getFPSCoolDown());
					} catch (InterruptedException exception) {
					}
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	@Override
	public boolean hasActivity() {
		return activity != null;
	}

	@Override
	public void setActivity(Activity activity) {
		if ((activity == null) && (this.activity != null))
			this.activity.stop();
		this.activity = activity;
	}

	@Override
	public Activity getActivity() {
		return activity;
	}
}