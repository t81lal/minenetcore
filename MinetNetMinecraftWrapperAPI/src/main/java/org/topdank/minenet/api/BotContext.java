package org.topdank.minenet.api;

import org.topdank.minenet.api.ai.task.BasicTaskManager;
import org.topdank.minenet.api.ai.task.TaskManager;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;
import org.topdank.minenet.client.MCClient;

import eu.bibl.eventbus.EventBus;

public class BotContext {

	// private final Logger LOGGER = LoggerFactory.getLogger("MinetNet");

	protected final MCClient client;
	protected final EventBus bus;
	protected BotVersionProvider provider;
	protected DefaultMinecraftWorld world;
	protected TaskManager taskManager;

	protected BotContext(MCClient client, EventBus bus) {
		this.client = client;
		this.bus = bus;
		taskManager = new BasicTaskManager(this);
	}

	public BotContext(MCClient client, EventBus bus, BotVersionProvider provider) {
		this(client, bus);
		this.provider = provider;
	}

	public MCClient getClient() {
		return client;
	}

	public EventBus getEventBus() {
		return bus;
	}

	public DefaultMinecraftWorld getWorld() {
		return world;
	}

	public void setWorld(DefaultMinecraftWorld w) {
		if (world != null)
			world.destroy();
		world = w;
	}

	public TaskManager getTaskManager() {
		return taskManager;
	}

	public BotVersionProvider getVersionProvider() {
		return provider;
	}
}