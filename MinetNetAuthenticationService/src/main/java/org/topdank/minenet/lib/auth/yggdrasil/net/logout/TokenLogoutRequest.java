package org.topdank.minenet.lib.auth.yggdrasil.net.logout;

import java.io.IOException;
import java.net.Proxy;

import org.topdank.minenet.lib.auth.net.InternalServerResponse;
import org.topdank.minenet.lib.auth.net.NetUtil;
import org.topdank.minenet.lib.auth.net.Request;
import org.topdank.minenet.lib.auth.net.Response;
import org.topdank.minenet.lib.auth.yggdrasil.YggdrasilSession;
import org.topdank.minenet.lib.auth.yggdrasil.net.YggdrasilResponseFactory;

public class TokenLogoutRequest extends Request {
	
	private static final TokenLogoutSuccessResponse INSTANCE = new TokenLogoutSuccessResponse();
	
	public TokenLogoutRequest(String accessToken, String clientToken) {
		super(YggdrasilSession.INVALIDATE_SERVER_URL, "application/json", formatToJson(accessToken, clientToken));
	}
	
	@Override
	public Response response(Proxy proxy) throws IOException {
		InternalServerResponse resp = NetUtil.post(proxy, this);
		String payload = resp.getPayload();
		if ((payload == null) || payload.isEmpty())
			return INSTANCE;
		return YggdrasilResponseFactory.createErrorResponse(resp);
	}
	
	private static String formatToJson(String accessToken, String clientToken) {
		return "{\"accessToken\":\"" + accessToken + "\", \"clientToken\":\"" + clientToken + "\"}";
	}
}