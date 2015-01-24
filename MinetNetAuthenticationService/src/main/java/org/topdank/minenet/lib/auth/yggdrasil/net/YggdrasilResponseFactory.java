package org.topdank.minenet.lib.auth.yggdrasil.net;

import org.topdank.minenet.lib.auth.net.InternalServerResponse;
import org.topdank.minenet.lib.auth.net.Response;

public final class YggdrasilResponseFactory {
	
	public static Response createErrorResponse(InternalServerResponse resp) {
		// System.out.println("Got error: " + resp.getStatusCode());
		// System.out.println("Payload: " + resp.getPayload());
		// TODO: impl
		return resp;
	}
}