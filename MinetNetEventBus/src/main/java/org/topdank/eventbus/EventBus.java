package org.topdank.eventbus;

public abstract interface EventBus {

	public abstract void register(Object src);

	public abstract void register(Object src, Class<? extends Event> eventClass);

	public abstract void register(Object src, Class<? extends Event>[] eventClass);

	public abstract void unregister(Object src);

	public abstract void unregister(Object src, Class<? extends Event> eventClass);

	public abstract void unregister(Object src, Class<? extends Event>[] eventClass);

	public abstract void dispatch(Event event);

	public abstract void dispatch(Event[] events);
}