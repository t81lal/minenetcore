package org.topdank.minenet.lib.auth.yggdrasil.net.login;

import org.topdank.minenet.lib.auth.net.Response;

public class TokenLoginSuccessResponse extends Response {
	
	private String changedAccessToken;
	
	public TokenLoginSuccessResponse(String changedAccessToken) {
		super(200);
	}
	
	public String getChangedAccessToken() {
		return changedAccessToken;
	}
}