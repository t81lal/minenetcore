package org.topdank.minenet.api.bot;

import java.util.List;

public abstract interface TaskManager {
	
	public abstract boolean registerTask(Task task);
	
	public abstract boolean unregisterTask(Task task);
	
	public abstract boolean unregisterTask(Class<? extends Task> task);
	
	public abstract void start();
	
	public abstract void update();
	
	public abstract void stopAll();
	
	public abstract <T extends Task> T getTaskFor(Class<T> taskClass);
	
	public abstract List<Task> getRegisteredTasks();
	
	public abstract boolean hasActivity();
	
	public abstract void setActivity(Activity activity);
	
	public abstract Activity getActivity();
}