package org.topdank.eventbus.impl;

import org.topdank.eventbus.EventBus;

public final class EventBuses {

	public static final EventBus singleThreadBus() {
		return new DefaultEventBus();
	}

	public static final EventBus multiThreadBus(int threads) {
		throw new UnsupportedOperationException("Multithreaded EventBuses aren't available yet.");
	}

	public static final EventBus threadSafeBus() {
		return new ConcurrentEventBus();
	}
}