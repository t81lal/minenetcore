package org.topdank.minenet.lib.auth.yggdrasil.net.login;

import java.io.IOException;
import java.net.Proxy;

import org.topdank.minenet.lib.auth.AuthenticationService;
import org.topdank.minenet.lib.auth.Profile;
import org.topdank.minenet.lib.auth.net.InternalServerResponse;
import org.topdank.minenet.lib.auth.net.NetUtil;
import org.topdank.minenet.lib.auth.net.Request;
import org.topdank.minenet.lib.auth.net.Response;
import org.topdank.minenet.lib.auth.yggdrasil.YggdrasilSession;
import org.topdank.minenet.lib.auth.yggdrasil.net.YggdrasilResponseFactory;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class PasswordLoginRequest extends Request {
	
	public PasswordLoginRequest(String username, String password, String clientToken) {
		super(YggdrasilSession.PASSWORD_LOGIN_SERVER_URL, "application/json", formatToJson(username, password, clientToken));
	}
	
	@Override
	public Response response(Proxy proxy) throws IOException {
		InternalServerResponse resp = NetUtil.post(proxy, this);
		if (resp.getStatusCode() == 200) {
			JsonObject root = NetUtil.JSON_PARSER.parse(resp.getPayload()).getAsJsonObject();
			String accessToken = root.get("accessToken").getAsString();
			JsonElement jsonSP = root.get("selectedProfile");
			Profile selectedProfile = AuthenticationService.GSON.fromJson(jsonSP.getAsJsonObject(), Profile.class);
			return new PasswordLoginSuccessResponse(accessToken, selectedProfile);
		} else {
			return YggdrasilResponseFactory.createErrorResponse(resp);
		}
	}
	
	private static String formatToJson(String username, String password, String clientToken) {
		return "{\"password\":\"" + password + "\",\"agent\":{\"name\":\"Minecraft\",\"version\":1},\"clientToken\":\"" + clientToken + "\",\"username\":\"" + username + "\"}";
	}
}