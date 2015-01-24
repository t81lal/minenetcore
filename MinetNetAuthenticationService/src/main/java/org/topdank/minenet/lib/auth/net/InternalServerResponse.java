package org.topdank.minenet.lib.auth.net;

public class InternalServerResponse extends Response {
	
	protected String payload;
	
	public InternalServerResponse(int statusCode, String payload) {
		super(statusCode);
		this.payload = payload;
	}
	
	public String getPayload() {
		return payload;
	}
}