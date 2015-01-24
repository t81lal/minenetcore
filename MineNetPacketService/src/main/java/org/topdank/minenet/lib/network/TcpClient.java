package org.topdank.minenet.lib.network;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.ReadTimeoutException;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.TimeoutException;
import io.netty.handler.timeout.WriteTimeoutHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.topdank.minenet.lib.auth.yggdrasil.YggdrasilSession;
import org.topdank.minenet.lib.network.event.connection.ConnectedEvent;
import org.topdank.minenet.lib.network.event.disconnect.DisconnectedEvent;
import org.topdank.minenet.lib.network.event.disconnect.DisconnectingEvent;
import org.topdank.minenet.lib.network.event.disconnect.TimeoutEvent;
import org.topdank.minenet.lib.network.event.disconnect.TimeoutType;
import org.topdank.minenet.lib.network.event.packet.PacketReceivedEvent;
import org.topdank.minenet.lib.network.event.packet.PacketSentEvent;
import org.topdank.minenet.lib.network.packet.ReadablePacket;
import org.topdank.minenet.lib.network.packet.WriteablePacket;
import org.topdank.minenet.lib.network.packet.codecs.PacketCompressionCodec;
import org.topdank.minenet.lib.network.packet.codecs.PacketEncryptorCodec;
import org.topdank.minenet.lib.network.packet.codecs.PacketReaderCodec;
import org.topdank.minenet.lib.network.packet.codecs.PacketSizerCodec;
import org.topdank.minenet.lib.network.packet.codecs.PacketWriterCodec;

import eu.bibl.eventbus.EventBus;

public class TcpClient extends Client<YggdrasilSession> {

	protected Channel channel;
	protected boolean disconnected;
	protected boolean writing;
	protected List<ReadablePacket> packets;

	protected EventLoopGroup group;
	protected Bootstrap bootstrap;

	protected int compressionThreshold;

	public TcpClient(YggdrasilSession session, String host, int port, Protocol protocol, EventBus bus) throws IOException {
		super(session, host, port, protocol, bus);
		packets = new ArrayList<ReadablePacket>();
	}

	@Override
	public void connect() throws IOException {
		connect(true);
	}

	@Override
	public void connect(boolean wait) throws IOException {
		if (disconnected || (bootstrap != null))
			throw new IllegalStateException("Client already disconnected");

		bootstrap = new Bootstrap();
		group = new NioEventLoopGroup(0, new ThreadFactoryBuilder().setName(session.getUserID() + " Client Netty Thread").build());

		bootstrap.channel(NioSocketChannel.class);
		bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);

		bootstrap.handler(new ChannelInitializer<Channel>() {
			@Override
			public void initChannel(Channel channel) throws Exception {
				channel.config().setOption(ChannelOption.IP_TOS, 0x18);
				channel.config().setOption(ChannelOption.TCP_NODELAY, false);

				ChannelPipeline pipeline = channel.pipeline();
				pipeline.addFirst("readTimeout", new ReadTimeoutHandler(10));
				pipeline.addFirst("writeTimeout", new WriteTimeoutHandler(0));

				if (protocol.requiresEncryption()) {
					pipeline.addLast("encrypter", new PacketEncryptorCodec(TcpClient.this));
				}
				if (protocol.requiresPacketSizer()) {
					pipeline.addLast("sizer", new PacketSizerCodec(TcpClient.this));
				}
				pipeline.addLast("readerCodec", new PacketReaderCodec(TcpClient.this));
				pipeline.addLast("writerCodec", new PacketWriterCodec(TcpClient.this));
				pipeline.addLast("manager", TcpClient.this);
			}
		}).group(group).remoteAddress(host, port);

		final AtomicBoolean calledTimeout = new AtomicBoolean(false);
		try {
			bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);
			ChannelFuture future = bootstrap.connect();
			bootstrap = null;
			if (wait) {
				while ((channel == null) && !disconnected) {
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				future.addListener(new ChannelFutureListener() {
					@Override
					public void operationComplete(ChannelFuture channelFuture) throws Exception {
						if ((channelFuture.cause() instanceof ConnectTimeoutException) && !calledTimeout.get()) {
							calledTimeout.set(true);
							protocol.onTimeout(new TimeoutEvent(TcpClient.this, TimeoutType.CONNECT));
						}
					}
				});
			}
		} catch (Exception e) {
			if ((e instanceof ConnectTimeoutException) && !calledTimeout.get()) {
				calledTimeout.set(true);
				protocol.onTimeout(new TimeoutEvent(TcpClient.this, TimeoutType.CONNECT));
			} else {
				System.err.println("Failed to establish connection.");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setCompressionThreshold(int ct) {
		compressionThreshold = ct;
		if (compressionThreshold >= 0) {
			if (channel.pipeline().get("compression") == null) {
				channel.pipeline().addBefore("readerCodec", "compression", new PacketCompressionCodec(this));
			}
		}
	}

	@Override
	public void disconnect(String reason) {
		if (disconnected) {
			return;
		}
		disconnected = true;
		if (writing) {
			while (writing) {
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (reason == null) {
			reason = "Connection closed.";
		}
		if (channel != null) {
			if (channel.isOpen()) {
				protocol.onDisconnecting(new DisconnectingEvent(this, reason));
			}
			try {
				channel.close().syncUninterruptibly();
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
		protocol.onDisconnected(new DisconnectedEvent(this, reason));
		if (group != null) {
			try {
				group.shutdownGracefully();
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
		channel = null;
	}

	@Override
	public void send(WriteablePacket packet) {
		if (channel == null) {
			writing = false;
			return;
		}

		writing = true;

		channel.writeAndFlush(packet).addListener(new ChannelFutureListener() {
			@Override
			public void operationComplete(ChannelFuture future) throws Exception {
				writing = false;
				if (!future.isSuccess()) {
					exceptionCaught(null, future.cause());
				} else {
					protocol.onPacketSent(new PacketSentEvent(TcpClient.this, packet));
				}
			}
		});
		if (packet.isPriorityPacket()) {
			while (writing) {
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
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

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		disconnect("Connection closed.");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		writing = false;
		if (!disconnected) {
			if (cause instanceof TimeoutException) {
				protocol.onTimeout(new TimeoutEvent(TcpClient.this, cause instanceof ReadTimeoutException ? TimeoutType.READ : TimeoutType.WRITE));
				disconnect((cause instanceof ReadTimeoutException ? "Read" : "Write") + " timed out.");
			} else if (cause instanceof ConnectTimeoutException) {
				protocol.onTimeout(new TimeoutEvent(this, TimeoutType.CONNECT));
				disconnect("Connection timed out.");
			} else {
				cause.printStackTrace();
				disconnect("Internal network exception: " + cause.toString());
			}
		}
		disconnected = true;
	}

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, ReadablePacket packet) throws Exception {
		if (!packet.isPriorityPacket()) { // already fired oio event for it
			packets.add(packet);
		}
	}

	@Override
	public boolean isConnected() {
		return (channel != null) && channel.isOpen() && !disconnected;
	}

	private class PacketHandleThread extends Thread {

		public PacketHandleThread() {
			super(session.getUsername() + " TCPClient PacketHandler");
		}

		@Override
		public void run() {
			try {
				while (!disconnected) {
					while (packets.size() > 0) {
						protocol.onPacketReceived(new PacketReceivedEvent(TcpClient.this, packets.remove(0)));
					}
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
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