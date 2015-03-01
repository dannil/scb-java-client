package org.dannil.scbapi.utility;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class RequestPoster {

	public static final String makeGetRequest(String address) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(address);
		Response response = target.request().get();
		String result = response.readEntity(String.class);

		System.out.println("Output from server: " + result);
		return result;
	}

	public static final String makePostRequest(String address, String query) {
		System.out.println("Query: " + query);

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(address);
		Response response = target.request().post(Entity.json(query));
		String result = response.readEntity(String.class);

		System.out.println("Output from server: " + result);

		// For some reason we get a question-mark in the beginning of the
		// response so we need to drop that to ensure valid JSON; this
		// occurs with different request clients so it's definitely a
		// problem on the server side
		return result.substring(1, result.length());
	}

}
