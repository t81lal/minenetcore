package org.topdank.minenet.lib.network;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.topdank.minenet.lib.auth.Session;
import org.topdank.minenet.lib.network.packet.ReadablePacket;
import org.topdank.minenet.lib.network.packet.WriteablePacket;

import eu.bibl.eventbus.Event;
import eu.bibl.eventbus.EventBus;

public abstract class Client<T extends Session> extends SimpleChannelInboundHandler<ReadablePacket> {

	protected T session;
	protected String host;
	protected int port;
	protected Map<String, Object> flags;

	protected Protocol protocol;
	protected EventBus bus;

	protected int compressionThreshold = -1;

	public Client(T session, String host, int port, Protocol protocol, EventBus bus) throws IOException {
		this.session = session;
		this.host = host;
		this.port = port;
		this.protocol = protocol;
		this.bus = bus;
		flags = new HashMap<String, Object>();
	}

	public abstract void connect() throws IOException;

	public abstract void connect(boolean wait) throws IOException;

	public abstract void disconnect(String reason) throws IOException;

	public abstract boolean isConnected();

	public abstract void send(WriteablePacket packet);

	public Session getSession() {
		return session;
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public void setCompressionThreshold(int ct) {
		// System.out.println("Setting compression threshold to " + compressionThreshold);
		compressionThreshold = ct;
	}

	public int getCompressionThreshold() {
		return compressionThreshold;
	}

	@Override
	public abstract void channelActive(ChannelHandlerContext ctx) throws Exception;

	@Override
	public abstract void channelInactive(ChannelHandlerContext ctx) throws Exception;

	@Override
	public abstract void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception;

	@Override
	protected abstract void messageReceived(ChannelHandlerContext ctx, ReadablePacket packet) throws Exception;

	@SuppressWarnings("unchecked")
	public <K> K getFlag(String key) {
		Object value = flags.get(key);
		if (value == null)
			return null;

		try {
			return (K) value;
		} catch (ClassCastException e) {
			throw new IllegalStateException("Tried to get flag \"" + key + "\" as the wrong type. Actual type: " + value.getClass().getName());
		}
	}

	@SuppressWarnings("unchecked")
	public <K> K getFlag(String key, K def) {
		if (flags.containsKey(key)) {
			Object value = flags.get(key);
			if (value == null)
				return null;

			try {
				return (K) value;
			} catch (ClassCastException e) {
				throw new IllegalStateException("Tried to get flag \"" + key + "\" as the wrong type. Actual type: " + value.getClass().getName());
			}
		}
		return def;
	}

	public void setFlag(String key, String val) {
		flags.put(key, val);
	}

	public boolean flagExists(String key) {
		return flags.containsKey(key);
	}

	public Protocol getProtocol() {
		return protocol;
	}

	public void dispatchEvent(Event e) {
		bus.dispatch(e);
	}

	public EventBus getEventBus() {
		return bus;
	}
}