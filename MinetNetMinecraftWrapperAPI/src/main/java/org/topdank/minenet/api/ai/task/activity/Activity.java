package org.topdank.minenet.api.ai.task.activity;

public abstract interface Activity {
	
	public abstract void run();
	
	public abstract boolean isActive();
	
	public abstract void stop();
}