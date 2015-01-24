package org.topdank.minenet.api.event.window;

import eu.bibl.eventbus.EventCancellable;

public abstract class WindowEvent extends EventCancellable {
	
	private final int windowId;
	
	public WindowEvent(int windowId) {
		this.windowId = windowId;
	}
	
	public int getWindowId() {
		return windowId;
	}
}