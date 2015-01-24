package org.topdank.minenet.lib.auth.net;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;

public abstract class Request {
	
	protected final URL url;
	protected String contentType;
	protected final String payload;
	
	public Request(final URL url, final String contentType, final String payload) {
		this.url = url;
		this.contentType = contentType;
		this.payload = payload;
	}
	
	public abstract Response response(Proxy proxy) throws IOException;
	
	public URL getURL() {
		return url;
	}
	
	public String getContentType() {
		return contentType;
	}
	
	@Override
	public String toString() {
		return payload;
	}
}