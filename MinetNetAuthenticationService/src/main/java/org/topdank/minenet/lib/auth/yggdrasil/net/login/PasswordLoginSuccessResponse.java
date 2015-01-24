package org.topdank.minenet.lib.auth.yggdrasil.net.login;

import org.topdank.minenet.lib.auth.Profile;
import org.topdank.minenet.lib.auth.net.Response;

public class PasswordLoginSuccessResponse extends Response {
	
	private final String accessToken;
	private final Profile selectedProfile;
	
	public PasswordLoginSuccessResponse(String accessToken, Profile selectedProfile) {
		super(200);
		this.accessToken = accessToken;
		this.selectedProfile = selectedProfile;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	
	public Profile getSelectedProfile() {
		return selectedProfile;
	}
}