package org.topdank.minenet.client;

import org.topdank.minenet.lib.network.Protocol;

public abstract class MCProtocol extends Protocol {

	public abstract void onTick();
}