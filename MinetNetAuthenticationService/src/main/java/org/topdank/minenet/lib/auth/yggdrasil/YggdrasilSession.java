package org.topdank.minenet.lib.auth.yggdrasil;

import static org.topdank.minenet.lib.auth.net.NetUtil.constantURL;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;

import org.topdank.minenet.lib.auth.AuthenticationException;
import org.topdank.minenet.lib.auth.Profile;
import org.topdank.minenet.lib.auth.Session;
import org.topdank.minenet.lib.auth.net.InternalServerResponse;
import org.topdank.minenet.lib.auth.net.Response;
import org.topdank.minenet.lib.auth.yggdrasil.net.login.PasswordLoginRequest;
import org.topdank.minenet.lib.auth.yggdrasil.net.login.PasswordLoginSuccessResponse;
import org.topdank.minenet.lib.auth.yggdrasil.net.login.TokenLoginRequest;
import org.topdank.minenet.lib.auth.yggdrasil.net.login.TokenLoginSuccessResponse;
import org.topdank.minenet.lib.auth.yggdrasil.net.logout.PasswordLogoutRequest;
import org.topdank.minenet.lib.auth.yggdrasil.net.logout.TokenLogoutRequest;
import org.topdank.minenet.lib.auth.yggdrasil.net.server.ServerJoinRequest;
import org.topdank.minenet.lib.auth.yggdrasil.net.server.ServerJoinSuccessResponse;
import org.topdank.minenet.lib.auth.yggdrasil.net.validate.ValidateRequest;
import org.topdank.minenet.lib.auth.yggdrasil.net.validate.ValidateSuccessResponse;

public class YggdrasilSession implements Session {

	public static final String MOJANG_AUTH_SERVER_BASE_URL = " https://authserver.mojang.com";
	public static final URL PASSWORD_LOGIN_SERVER_URL = constantURL(MOJANG_AUTH_SERVER_BASE_URL + "/authenticate");
	public static final URL TOKEN_LOGIN_SERVER_URL = constantURL(MOJANG_AUTH_SERVER_BASE_URL + "/refresh");
	public static final URL VALIDATE_SERVER_URL = constantURL(MOJANG_AUTH_SERVER_BASE_URL + "/validate");
	public static final URL SIGNOUT_SERVER_URL = constantURL(MOJANG_AUTH_SERVER_BASE_URL + "/signout");
	public static final URL INVALIDATE_SERVER_URL = constantURL(MOJANG_AUTH_SERVER_BASE_URL + "/invalidate");

	public static final String MINECRAFT_SERVER_SERVER_BASE_URL = "https://sessionserver.mojang.com/session/minecraft";
	public static final URL JOIN_MINECRAFT_SERVER_URL = constantURL(MINECRAFT_SERVER_SERVER_BASE_URL + "/join");
	public static final URL CHECK_JOIN_MINECRAFT_SERVER_URL = constantURL(MINECRAFT_SERVER_SERVER_BASE_URL + "/hasJoined");

	protected YggdrasilAuthenticationService service;
	protected Proxy proxy;
	protected String username;
	protected String password;
	protected String clientToken;

	protected String accessToken;
	protected Profile selectedProfile;

	/**
	 * Intended to be used to login to the server with a
	 * username and password request. <br>
	 * <b>N.B:</b> It is strongly advised to store previous
	 * access tokens, client tokens and selectedProfiles to
	 * login in the future. Storing a password can be very
	 * dangerous, especially if it's not encrypted in some
	 * form. <br>
	 * 
	 * @param service {@link YggdrasilAuthenticationService}
	 *        parent auth service.
	 * @param proxy Login proxy (HTTP), can be null.
	 * @param username Login username (can be email).
	 * @param password Login password.
	 * @param clientToken The client token from the
	 *        YggdrasilAuthenticationService or different if
	 *        neccessary.
	 */
	public YggdrasilSession(YggdrasilAuthenticationService service, Proxy proxy, String username, String password, String clientToken) {
		this.service = service;
		this.proxy = proxy == null ? Proxy.NO_PROXY : proxy;
		this.username = username;
		this.password = password;
		this.clientToken = clientToken;
	}

	/**
	 * Delegate call to
	 * {@link #YggdrasilSession(YggdrasilAuthenticationService, Proxy, String, String, String)}
	 * . <br>
	 * Infers client token from the
	 * YggdrasilAuthenticationService. <br>
	 * 
	 * @param service {@link YggdrasilAuthenticationService}
	 *        parent auth service.
	 * @param proxy Login proxy (HTTP), can be null.
	 * @param username Login username (can be email).
	 * @param password Login password.
	 */
	public YggdrasilSession(YggdrasilAuthenticationService service, Proxy proxy, String username, String password) {
		this(service, proxy, username, password, service.getClientToken());
	}

	/**
	 * Delegate call to
	 * {@link #YggdrasilSession(YggdrasilAuthenticationService, Proxy, String, String)}
	 * . <br>
	 * Uses the default proxy (Proxy.NO_PROXY). <br>
	 * 
	 * @param service {@link YggdrasilAuthenticationService}
	 *        parent auth service.
	 * @param username Login username (can be email).
	 * @param password Login password.
	 */
	public YggdrasilSession(YggdrasilAuthenticationService service, String username, String password) {
		this(service, Proxy.NO_PROXY, username, password, service.getClientToken());
	}

	/**
	 * Logs in to the Mojang servers using a previously
	 * generated and authenticated clientToken, accessToken
	 * and selectedProfile data from the server. <br>
	 * This is one of the safest ways to ensure that no
	 * player passwords are passed around. <br>
	 * 
	 * @param service {@link YggdrasilAuthenticationService}
	 *        parent auth service.
	 * @param proxy Login proxy (HTTP), can be null.
	 * @param selectedProfile Player profile from server.
	 * @param accessToken Authenticated accessToken (UUID).
	 * @param clientToken Last used clientToken (UUID).
	 */
	public YggdrasilSession(YggdrasilAuthenticationService service, Proxy proxy, Profile selectedProfile, String accessToken, String clientToken) {
		this.service = service;
		this.proxy = proxy == null ? Proxy.NO_PROXY : proxy;
		this.selectedProfile = selectedProfile;
		this.accessToken = accessToken;
		this.clientToken = clientToken;
	}

	/**
	 * Delegate call to
	 * {@link #YggdrasilSession(YggdrasilAuthenticationService, Profile, String, String)}
	 * . <br>
	 * Uses the default proxy (Proxy.NO_PROXY). <br>
	 * 
	 * @param service {@link YggdrasilAuthenticationService}
	 *        parent auth service.
	 * @param selectedProfile Player profile from server.
	 * @param accessToken Authenticated accessToken (UUID).
	 * @param clientToken Last used clientToken (UUID).
	 */
	public YggdrasilSession(YggdrasilAuthenticationService service, Profile selectedProfile, String accessToken, String clientToken) {
		this(service, Proxy.NO_PROXY, selectedProfile, accessToken, clientToken);
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setAuthenticatedToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public String getUserID() {
		if (selectedProfile != null)
			return selectedProfile.name;
		return username;
	}

	@Override
	public String getClientToken() {
		return clientToken;
	}

	@Override
	public String getAuthenticatedToken() {
		return accessToken;
	}

	public void joinServer(String serverId) throws AuthenticationException {
		if (!canJoinServer())
			throw new AuthenticationException("Not logged in");

		try {
			ServerJoinRequest request = new ServerJoinRequest(accessToken, selectedProfile.id, serverId);
			Response resp = request.response(proxy);
			if (!(resp instanceof ServerJoinSuccessResponse)) {
				throw new AuthenticationException(((InternalServerResponse) resp).getPayload());
			}
			System.out.println("Got: " + resp);
		} catch (IOException e) {
			throw new AuthenticationException("Couldn't join server.", e);
		}
	}

	@Override
	public void login() throws AuthenticationException {
		if (clientToken == null)
			throw new AuthenticationException("ClientToken is null");
		if ((username != null) && (password != null)) {
			loginWithPassword();
		} else if ((accessToken != null) && (selectedProfile != null)) {
			loginWithToken();
		} else {
			throw new AuthenticationException("Invalid login details");
		}
	}

	protected void loginWithPassword() throws AuthenticationException {
		if (clientToken == null)
			throw new AuthenticationException("ClientToken cannot be null");
		if (username == null)
			throw new AuthenticationException("Username cannot be null");
		if (password == null)
			throw new AuthenticationException("Password cannot be null");

		try {
			PasswordLoginRequest request = new PasswordLoginRequest(username, password, clientToken);
			Response response = request.response(proxy);
			if (response.getStatusCode() == 200) {
				PasswordLoginSuccessResponse resp = (PasswordLoginSuccessResponse) response;
				accessToken = resp.getAccessToken();
				selectedProfile = resp.getSelectedProfile();
			} else {
				throw new AuthenticationException(((InternalServerResponse) response).getPayload());
			}
		} catch (IOException e) {
			throw new AuthenticationException(e);
		}
	}

	protected void loginWithToken() throws AuthenticationException {
		if (accessToken == null)
			throw new AuthenticationException("AccessToken cannot be null");
		if (clientToken == null)
			throw new AuthenticationException("ClientToken cannot be null");
		if (selectedProfile == null)
			throw new AuthenticationException("SelectedProfile cannot be null");

		try {
			// ignore received clientToken, it's the same
			TokenLoginRequest request = new TokenLoginRequest(accessToken, clientToken, selectedProfile);
			Response response = request.response(proxy);
			if (response.getStatusCode() == 200) {
				TokenLoginSuccessResponse success = (TokenLoginSuccessResponse) response;
				accessToken = success.getChangedAccessToken();
			} else {
				throw new AuthenticationException(((InternalServerResponse) response).getPayload());
			}
		} catch (IOException e) {
			throw new AuthenticationException(e);
		}
	}

	@Override
	public void logout() {
		if ((username != null) && (password != null)) {
			logoutWithPassword();
		} else if ((accessToken != null) && (clientToken != null)) {
			logoutWithToken();
		}
	}

	protected void logoutWithPassword() {

		try {
			PasswordLogoutRequest request = new PasswordLogoutRequest(username, password);
			Response resp = request.response(proxy);

			if (resp.getStatusCode() != 200) {
				System.out.println(username + " unable to logout with password.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		username = null;
		password = null;
	}

	protected void logoutWithToken() {

		try {
			TokenLogoutRequest request = new TokenLogoutRequest(accessToken, clientToken);
			Response resp = request.response(proxy);

			if (resp.getStatusCode() != 200) {
				System.out.println(username + " unable to logout with tokens.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		accessToken = null;
		clientToken = null;
	}

	@Override
	public boolean canLogIn() {
		return ((username != null) && (password != null)) || ((username != null) && (accessToken != null) && (clientToken != null));
	}

	@Override
	public boolean canJoinServer() {
		return validate();
	}

	protected boolean validate() {
		try {
			ValidateRequest request = new ValidateRequest(accessToken);
			Response response = request.response(proxy);
			return response instanceof ValidateSuccessResponse;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Proxy getProxy() {
		return proxy;
	}

	public void setProxy(Proxy proxy) {
		this.proxy = proxy;
	}

	public Profile getSelectedProfile() {
		return selectedProfile;
	}

	public void setSelectedProfile(Profile selectedProfile) {
		this.selectedProfile = selectedProfile;
	}

	public YggdrasilAuthenticationService getService() {
		return service;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public String getAccessToken() {
		return accessToken;
	}

	@Override
	public String toString() {
		return "YggdrasilSession [proxy=" + proxy + ", username=" + username + ", clientToken=" + clientToken + ", accessToken=" + accessToken + ", selectedProfile= " + selectedProfile
				+ "]";
	}
}
