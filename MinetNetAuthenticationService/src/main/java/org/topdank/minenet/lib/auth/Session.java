package org.topdank.minenet.lib.auth;

public abstract interface Session {
	
	public abstract boolean canLogIn();
	
	public abstract boolean canJoinServer();
	
	public abstract void setUsername(String username);
	
	public abstract void setPassword(String password);
	
	public abstract void setAuthenticatedToken(String accessToken);
	
	public abstract String getUserID();
	
	public abstract String getClientToken();
	
	public abstract String getAuthenticatedToken();
	
	public abstract void login() throws AuthenticationException;
	
	public abstract void logout();
}