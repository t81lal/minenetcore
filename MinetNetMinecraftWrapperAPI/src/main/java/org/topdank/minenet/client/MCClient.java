package org.topdank.minenet.client;

import io.netty.channel.ChannelHandlerContext;

import java.io.IOException;

import org.topdank.minenet.api.BotContext;
import org.topdank.minenet.api.util.Timer;
import org.topdank.minenet.client.event.RequestPacketSendEvent;
import org.topdank.minenet.lib.auth.yggdrasil.YggdrasilSession;
import org.topdank.minenet.lib.network.Client;
import org.topdank.minenet.lib.network.Protocol;
import org.topdank.minenet.lib.network.TcpClient;
import org.topdank.minenet.lib.network.event.connection.ConnectedEvent;
import org.topdank.minenet.lib.network.event.packet.PacketReceivedEvent;

import eu.bibl.eventbus.EventBus;
import eu.bibl.eventbus.EventPriority;
import eu.bibl.eventbus.EventTarget;

public class MCClient extends TcpClient {

	protected BotContext context;

	public MCClient(YggdrasilSession session, String host, int port, Protocol protocol, EventBus bus) throws IOException {
		super(session, host, port, protocol, bus);

		if (!(protocol instanceof MCProtocol))
			throw new UnsupportedOperationException("MCClient requires a valid MCProtocol.");

		protocol.init(this);
		bus.register(this);
	}

	public BotContext getBotContext() {
		return context;
	}

	public void setBotContext(BotContext context) {
		if (this.context == null) {
			this.context = context;
		}
	}

	@EventTarget(priority = EventPriority.HIGHEST)
	public void onRequestPacketSendEvent(RequestPacketSendEvent e) {
		Client<?> c = e.getClient();
		if (c.equals(this)) {
			send(e.getPacket());
		}
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		if (disconnected) {
			ctx.channel().close().syncUninterruptibly();
			return;
		}
		channel = ctx.channel();
		disconnected = false;
		protocol.onConnect(new ConnectedEvent(this));
		new PacketHandleThread().start();
	}

	private class PacketHandleThread extends Thread {

		private final Timer timer = new Timer(20, 20);

		public PacketHandleThread() {
			super(((YggdrasilSession) session).getUsername() + " MCClient PacketHandler");
		}

		@Override
		public void run() {
			try {
				while (true) {
					timer.update();
					for (int i = 0; i < timer.getElapsedTicks(); i++) {
						while (packets.size() > 0) {
							protocol.onPacketReceived(new PacketReceivedEvent(MCClient.this, packets.remove(0)));
						}
						((MCProtocol) protocol).onTick();
					}
					if (timer.getFPSCoolDown() > 0) {
						try {
							Thread.sleep(timer.getFPSCoolDown());
						} catch (InterruptedException exception) {
						}
					}
				}
			} catch (Throwable t) {
				try {
					exceptionCaught(null, t);
				} catch (Exception e) {
					System.err.println("Exception while handling exception!");
					e.printStackTrace();
				}
			}
		}
	}
}