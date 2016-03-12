package com.github.dannil.scbjavaclient.utility.requester;


public class RequesterFactory {

	private static GETRequester get;
	private static POSTRequester post;

	public static Requester getInstance(String method) {
		if (get == null) {
			get = new GETRequester();
		}
		if (post == null) {
			post = new POSTRequester();
		}

		switch (method) {
			case "GET":
				return get;

			case "POST":
				return post;

			default:
				throw new IllegalArgumentException(method + " is not a valid method");
		}
	}

	private RequesterFactory() {

	}

}
