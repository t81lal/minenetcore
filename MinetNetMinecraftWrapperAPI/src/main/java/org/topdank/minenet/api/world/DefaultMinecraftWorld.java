package org.topdank.minenet.api.world;

import java.lang.reflect.Method;
import java.util.Map;

import org.topdank.minenet.api.BotContext;
import org.topdank.minenet.api.entity.tile.TileEntity;
import org.topdank.minenet.api.event.internal.InternalChunkLoadEvent;
import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.game.location.ChunkLocation;
import org.topdank.minenet.api.world.block.Chunk;
import org.topdank.minenet.api.world.settings.WorldSettings;

import eu.bibl.eventbus.EventBus;
import eu.bibl.eventbus.EventPriority;
import eu.bibl.eventbus.EventTarget;

public class DefaultMinecraftWorld implements World {

	protected BotContext context;
	protected EventBus eventBus;

	protected WorldSettings worldSettings;

	protected long worldAge, worldTime;
	protected Map<ChunkLocation, Chunk> chunks;

	public DefaultMinecraftWorld(BotContext context, EventBus eventBus, WorldSettings worldSettings) {
		this.context = context;
		this.eventBus = eventBus;
		this.worldSettings = worldSettings;
	}

	public DefaultMinecraftWorld(BotContext context, WorldSettings worldSettings) {
		this(context, context.getEventBus(), worldSettings);
	}

	public DefaultMinecraftWorld(BotContext context) {
		this(context, context.getEventBus(), null);
	}

	public static void main(String[] args) {
		for (Method m : DefaultMinecraftWorld.class.getDeclaredMethods()) {
			if (m.getName().equals("onInternalChunkLoad")) {
				System.out.println(m.getAnnotations().length);
			}
		}
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	private void onInternalChunkLoad(InternalChunkLoadEvent e) {

	}

	@Override
	public BlockLocation[] findAdjacent(BlockLocation location) {
		return null;
	}

	@Override
	public boolean canWalk(BlockLocation from, BlockLocation to) {
		return false;
	}

	@Override
	public boolean canClimb(BlockLocation location) {
		return false;
	}

	@Override
	public WorldSettings getSettings() {
		return worldSettings;
	}

	@Override
	public long getWorldAge() {
		return worldAge;
	}

	@Override
	public long getTime() {
		return worldTime;
	}

	@Override
	public int getBlockIdAt(BlockLocation loc) {
		return 0;
	}

	@Override
	public int getBlockIdAt(int x, int y, int z) {
		return 0;
	}

	@Override
	public void setBlockIdAt(int id, BlockLocation loc) {

	}

	@Override
	public void setBlockIdAt(int id, int x, int y, int z) {

	}

	@Override
	public TileEntity getTileEntityAt(BlockLocation loc) {
		return null;
	}

	@Override
	public void setTileEntityAt(TileEntity tileEntity, BlockLocation loc) {

	}

	@Override
	public Chunk getChunkAt(BlockLocation loc) {
		return null;
	}

	@Override
	public Chunk getChunkAt(ChunkLocation location) {
		return null;
	}

	@Override
	public void destroy() {

	}

	@Override
	public World getWorld() {
		return this;
	}
}