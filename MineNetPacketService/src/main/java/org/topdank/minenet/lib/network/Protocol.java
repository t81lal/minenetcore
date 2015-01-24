package org.topdank.minenet.lib.network;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import org.topdank.minenet.lib.network.event.connection.ConnectedEvent;
import org.topdank.minenet.lib.network.event.disconnect.DisconnectedEvent;
import org.topdank.minenet.lib.network.event.disconnect.DisconnectingEvent;
import org.topdank.minenet.lib.network.event.disconnect.TimeoutEvent;
import org.topdank.minenet.lib.network.event.packet.PacketReceivedEvent;
import org.topdank.minenet.lib.network.event.packet.PacketSentEvent;
import org.topdank.minenet.lib.network.packet.Packet;
import org.topdank.minenet.lib.network.packet.ReadablePacket;
import org.topdank.minenet.lib.network.packet.WriteablePacket;
import org.topdank.minenet.lib.network.packet.encryption.EncryptionProtocol;
import org.topdank.minenet.lib.network.packet.header.PacketHeader;

/**
 * A protocol for packet sending and receiving.
 */
public abstract class Protocol {

	private final Map<Integer, Class<? extends ReadablePacket>> incoming = new HashMap<Integer, Class<? extends ReadablePacket>>();
	private final Map<Class<? extends WriteablePacket>, Integer> outgoing = new HashMap<Class<? extends WriteablePacket>, Integer>();

	protected boolean wait;

	public abstract boolean requiresEncryption();

	public abstract boolean requiresPacketSizer();

	public abstract EncryptionProtocol getPacketEncryptionProtocol();

	public abstract PacketHeader getPacketHeader();

	public abstract void init(Client<?> client);

	/**
	 * Clears all currently registered packets.
	 */
	public final void clearPackets() {
		incoming.clear();
		outgoing.clear();
	}

	/**
	 * Registers a packet to this protocol as both incoming and outgoing.
	 *
	 * @param id Id to register the packet to.
	 * @param packet Packet to register.
	 * @throws IllegalArgumentException If the packet fails a test creation when being registered as incoming.
	 */
	@SuppressWarnings("unchecked")
	public final void register(int id, Class<? extends Packet> packet) {
		if (packet.isAssignableFrom(ReadablePacket.class)) {
			registerIncoming(id, (Class<? extends ReadablePacket>) packet);
		}
		if (packet.isAssignableFrom(WriteablePacket.class)) {
			registerOutgoing(id, (Class<? extends WriteablePacket>) packet);
		}
	}

	/**
	 * Registers an incoming packet to this protocol.
	 *
	 * @param id Id to register the packet to.
	 * @param packet Packet to register.
	 * @throws IllegalArgumentException If the packet fails a test creation.
	 */
	public final void registerIncoming(int id, Class<? extends ReadablePacket> packet) {
		incoming.put(id, packet);
		// System.out.println("adding " + packet.getSimpleName() + " id " + Integer.toHexString(id));
		// too fucking slow

		// try {
		// createIncomingPacket(id);
		// } catch (IllegalStateException e) {
		// incoming.remove(id);
		// throw new IllegalArgumentException(e.getMessage(), e.getCause());
		// }
	}

	/**
	 * Registers an outgoing packet to this protocol.
	 *
	 * @param id Id to register the packet to.
	 * @param packet Packet to register.
	 */
	public final void registerOutgoing(int id, Class<? extends WriteablePacket> packet) {
		outgoing.put(packet, id);
	}

	/**
	 * Creates a new instance of an incoming packet with the given id.
	 *
	 * @param id Id of the packet to create.
	 * @return The created packet.
	 * @throws IllegalArgumentException If the packet ID is invalid.
	 * @throws IllegalStateException If the packet does not have a no-params constructor or cannot be instantiated.
	 */
	public final ReadablePacket createIncomingPacket(int id) {
		// System.out.println("Got packet with id: " + incoming.get(id).getSimpleName());
		if ((id < 0) || !incoming.containsKey(id) || (incoming.get(id) == null)) {
			throw new IllegalArgumentException("Invalid packet id: 0x" + Integer.toHexString(id) + " / " + id);
		}
		Class<? extends ReadablePacket> packet = incoming.get(id);
		try {
			Constructor<? extends ReadablePacket> constructor = packet.getDeclaredConstructor();
			if (!constructor.isAccessible()) {
				constructor.setAccessible(true);
			}
			return constructor.newInstance();
		} catch (NoSuchMethodError e) {
			throw new IllegalStateException("Packet \"" + id + ", " + packet.getName() + "\" does not have a no-params constructor for instantiation.");
		} catch (Exception e) {
			throw new IllegalStateException("Failed to instantiate packet \"" + id + ", " + packet.getName() + "\".", e);
		}
	}

	/**
	 * Gets the registered id of an outgoing packet class.
	 *
	 * @param packet Class of the packet to get the id for.
	 * @return The packet's registered id.
	 * @throws IllegalArgumentException If the packet is not registered.
	 */
	public final int getOutgoingId(Class<? extends Packet> packet) {
		// System.out.println("Sending packet: " + packet.getSimpleName());
		if (!outgoing.containsKey(packet) || (outgoing.get(packet) == null)) {
			throw new IllegalArgumentException("Unregistered outgoing packet class: " + packet.getName());
		}
		return outgoing.get(packet);
	}

	public final void unregisterIncomingPacket(int id) {
		incoming.remove(id);
	}

	public final void unregisterOutgoingPacket(int id) {
		outgoing.remove(id);
	}

	public final void setWait(boolean wait) {
		this.wait = wait;
	}

	public final boolean packetWait() {
		return wait;
	}

	public abstract void onConnect(ConnectedEvent event);

	public abstract void onPacketReceived(PacketReceivedEvent event);

	public abstract void onPacketSent(PacketSentEvent event);

	public abstract void onTimeout(TimeoutEvent event);

	public abstract String getGameVersion();

	public abstract int getProtocolVersion();

	public abstract void onDisconnected(DisconnectedEvent event);

	public abstract void onDisconnecting(DisconnectingEvent event);
}