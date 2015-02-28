package org.dannil.scbapi.utility;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RequestPoster {

	public static final String makePostRequest(WebResource resource, String query) {
		System.out.println("Query: " + query);

		ClientResponse response = resource.accept("application/json").post(ClientResponse.class, query);
		String result = response.getEntity(String.class);

		System.out.println("Output from server: " + result);
		System.out.println(result.charAt(0));

		// For some reason we get a question-mark in the beginning of the
		// response so we need to drop that to ensure valid JSON
		if (result.charAt(0) == '?') {
			System.out.println(result.substring(1, result.length()));
			return result.substring(1, result.length());
		}
		System.out.println(result.substring(1, result.length()));
		return result;
	}
}
