package org.topdank.minenet.lib.auth;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract interface AuthenticationService<T extends Session> {
	
	public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	
	public abstract String getClientToken();
	
	public abstract T createSession(Map<String, Object> flags) throws IllegalArgumentException;
}