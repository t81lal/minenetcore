package org.topdank.minenet.lib.auth.yggdrasil.net.login;

import java.io.IOException;
import java.net.Proxy;

import org.topdank.minenet.lib.auth.Profile;
import org.topdank.minenet.lib.auth.net.InternalServerResponse;
import org.topdank.minenet.lib.auth.net.NetUtil;
import org.topdank.minenet.lib.auth.net.Request;
import org.topdank.minenet.lib.auth.net.Response;
import org.topdank.minenet.lib.auth.yggdrasil.YggdrasilSession;
import org.topdank.minenet.lib.auth.yggdrasil.net.YggdrasilResponseFactory;

import com.google.gson.JsonObject;

public class TokenLoginRequest extends Request {
	
	public TokenLoginRequest(String accessToken, String clientToken, Profile selectedProfile) {
		super(YggdrasilSession.TOKEN_LOGIN_SERVER_URL, "application/json", formatToJson(accessToken, clientToken, selectedProfile));
	}
	
	@Override
	public Response response(Proxy proxy) throws IOException {
		InternalServerResponse resp = NetUtil.post(proxy, this);
		if (resp.getStatusCode() == 200) {
			JsonObject root = NetUtil.JSON_PARSER.parse(resp.getPayload()).getAsJsonObject();
			return new TokenLoginSuccessResponse(root.get("accessToken").getAsString());
		} else {
			return YggdrasilResponseFactory.createErrorResponse(resp);
		}
	}
	
	private static String formatToJson(String accessToken, String clientToken, Profile selectedProfile) {
		return "{\"accessToken\":\"" + accessToken + "\",\"clientToken\":\"" + clientToken + "\",\"selectedProfile\":\"" + selectedProfile + "\"}";
	}
}