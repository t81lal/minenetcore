package org.topdank.minenet.api.ai.task;


public abstract interface Task {
	/**
	 * Returns true if the precondition to activate it is met.
	 */
	public abstract boolean isPreconditionMet();
	
	/**
	 * Starts the task.
	 */
	public abstract boolean start(String... options);
	
	/**
	 * Stops the task. This is called either when it becomes inactive or it is
	 * told to stop.
	 */
	public abstract void stop();
	
	/**
	 * Called every game tick that it is active.
	 */
	public abstract void run();
	
	/**
	 * Returns true as long as the task can continue to run.
	 */
	public abstract boolean isActive();
	
	/**
	 * Returns the priority of the task. This only pertains to tasks that are
	 * exclusive. If multiple exclusive tasks are active, the task with the
	 * highest priority will take precedence. If the there is more than one task
	 * of highest priority, the task that was started first will take
	 * precedence.
	 *
	 * @see Task#isExclusive()
	 */
	public abstract TaskPriority getPriority();
	
	/**
	 * Returns true if all other tasks should be put on hold while this task is
	 * active.
	 *
	 * @see Task#getPriority()
	 */
	public abstract boolean isExclusive();
	
	/**
	 * Returns true if this task ignores other active tasks that are exclusive.
	 */
	public abstract boolean ignoresExclusive();
	
	/**
	 * The name of the task (e.g. FollowTask would have the name Follow)
	 */
	public abstract String getName();
	
	/**
	 * Describes the options provided to start the task.
	 */
	public abstract String getOptionDescription();
}