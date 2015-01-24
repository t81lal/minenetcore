package org.topdank.minenet.lib.auth.yggdrasil.net.server;

import java.io.IOException;
import java.net.Proxy;

import org.topdank.minenet.lib.auth.net.InternalServerResponse;
import org.topdank.minenet.lib.auth.net.NetUtil;
import org.topdank.minenet.lib.auth.net.Request;
import org.topdank.minenet.lib.auth.net.Response;
import org.topdank.minenet.lib.auth.yggdrasil.YggdrasilSession;
import org.topdank.minenet.lib.auth.yggdrasil.net.YggdrasilResponseFactory;

public class ServerJoinRequest extends Request {
	
	private static final ServerJoinSuccessResponse INSTANCE = new ServerJoinSuccessResponse();
	
	public ServerJoinRequest(String accessToken, String selectedProfileId, String serverId) {
		super(YggdrasilSession.JOIN_MINECRAFT_SERVER_URL, "application/json", formatToJson(accessToken, selectedProfileId, serverId));
	}
	
	@Override
	public Response response(Proxy proxy) throws IOException {
		InternalServerResponse response = NetUtil.post(proxy, this);
		String payload = response.getPayload();
		if ((payload == null) || payload.isEmpty())
			return INSTANCE;
		return YggdrasilResponseFactory.createErrorResponse(response);
	}
	
	private static String formatToJson(String accessToken, String selectedProfileId, String serverId) {
		return "{\"accessToken\":\"" + accessToken + "\",\"selectedProfile\":\"" + selectedProfileId + "\",\"serverId\":\"" + serverId + "\"}";
	}
}