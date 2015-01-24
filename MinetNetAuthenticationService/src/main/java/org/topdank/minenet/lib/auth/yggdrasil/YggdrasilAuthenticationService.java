package org.topdank.minenet.lib.auth.yggdrasil;

import java.net.Proxy;
import java.util.Map;
import java.util.UUID;

import org.topdank.minenet.lib.auth.AuthenticationService;
import org.topdank.minenet.lib.auth.Profile;

public class YggdrasilAuthenticationService implements AuthenticationService<YggdrasilSession> {
	
	protected static final UUID CLIENT_TOKEN = UUID.randomUUID();
	
	public static final String FLAG_PROXY = "proxy";
	public static final String FLAG_USERNAME = "username";
	public static final String FLAG_PASSWORD = "password";
	public static final String FLAG_ACCESS_TOKEN = "accessToken";
	public static final String FLAG_CLIENT_TOKEN = "clientToken";
	public static final String FLAG_SELECTED_PROFILE = "selectedProfile";
	
	@Override
	public String getClientToken() {
		return CLIENT_TOKEN.toString();
	}
	
	@Override
	public YggdrasilSession createSession(Map<String, Object> flags) throws IllegalArgumentException {
		Proxy proxy = (Proxy) flags.get(FLAG_PROXY);
		
		boolean clientToken = flags.containsKey(FLAG_CLIENT_TOKEN);
		boolean accessToken = flags.containsKey(FLAG_ACCESS_TOKEN);
		boolean selectedProfile = flags.containsKey(FLAG_SELECTED_PROFILE);
		boolean user = flags.containsKey(FLAG_USERNAME);
		boolean pass = flags.containsKey(FLAG_PASSWORD);
		
		YggdrasilSession session = null;
		
		if (clientToken) {
			if (user && pass) {
				session = new YggdrasilSession(this, proxy, (String) flags.get(FLAG_USERNAME), (String) flags.get(FLAG_PASSWORD), (String) flags.get(FLAG_CLIENT_TOKEN));
			} else if (accessToken && selectedProfile) {
				session = new YggdrasilSession(this, proxy, (Profile) flags.get(FLAG_SELECTED_PROFILE), (String) flags.get(FLAG_ACCESS_TOKEN), (String) flags.get(FLAG_CLIENT_TOKEN));
			}
		} else {
			if (user && pass) {
				session = new YggdrasilSession(this, proxy, (String) flags.get(FLAG_USERNAME), (String) flags.get(FLAG_PASSWORD));
			}
		}
		
		if (session == null)
			throw new IllegalArgumentException("Not enough args to create session");
		
		return session;
	}
}