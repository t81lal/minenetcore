package org.topdank.minenet.lib.network;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class ThreadFactoryBuilder {
	
	private String name = null;
	private Boolean daemon = null;
	private Integer priority = null;
	private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
	private ThreadFactory backingThreadFactory = null;
	
	public ThreadFactoryBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public ThreadFactoryBuilder setDaemon(boolean daemon) {
		this.daemon = Boolean.valueOf(daemon);
		return this;
	}
	
	public ThreadFactoryBuilder setPriority(int priority) {
		// Preconditions.checkArgument(priority >= 1, "Thread priority (%s) must be >= %s", new Object[] { Integer.valueOf(priority), Integer.valueOf(1) });
		//
		// Preconditions.checkArgument(priority <= 10, "Thread priority (%s) must be <= %s", new Object[] { Integer.valueOf(priority), Integer.valueOf(10) });
		
		this.priority = Integer.valueOf(priority);
		return this;
	}
	
	public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
		this.uncaughtExceptionHandler = uncaughtExceptionHandler;
		return this;
	}
	
	public ThreadFactoryBuilder setThreadFactory(ThreadFactory backingThreadFactory) {
		this.backingThreadFactory = backingThreadFactory;
		return this;
	}
	
	public ThreadFactory build() {
		return build(this);
	}
	
	private static ThreadFactory build(ThreadFactoryBuilder builder) {
		final String name = builder.name;
		final Boolean daemon = builder.daemon;
		final Integer priority = builder.priority;
		final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = builder.uncaughtExceptionHandler;
		
		ThreadFactory backingThreadFactory = builder.backingThreadFactory != null ? builder.backingThreadFactory : Executors.defaultThreadFactory();
		
		return new ThreadFactory() {
			@Override
			public Thread newThread(Runnable runnable) {
				Thread thread = backingThreadFactory.newThread(runnable);
				if (name != null) {
					thread.setName(name);
				}
				if (daemon != null) {
					thread.setDaemon(daemon.booleanValue());
				}
				if (priority != null) {
					thread.setPriority(priority.intValue());
				}
				if (uncaughtExceptionHandler != null) {
					thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
				}
				return thread;
			}
		};
	}
}