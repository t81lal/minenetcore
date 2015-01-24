package org.topdank.minenet.lib.auth.net;

public class Response {
	
	private final int statusCode;
	
	public Response(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
}