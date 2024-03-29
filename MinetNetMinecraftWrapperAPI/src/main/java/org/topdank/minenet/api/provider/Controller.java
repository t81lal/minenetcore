package org.topdank.minenet.api.provider;

import org.topdank.minenet.api.BotContext;

public abstract class Controller<T> {
	
	protected BotContext context;
	protected T obj;
	
	public Controller(BotContext context) {
		this.context = context;
	}
	
	public void set(T t) {
		obj = t;
	}
}