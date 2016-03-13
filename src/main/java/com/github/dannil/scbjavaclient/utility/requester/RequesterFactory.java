package com.github.dannil.scbjavaclient.utility.requester;

public class RequesterFactory {

	private static class GETHolder {
		private static final GETRequester INSTANCE = new GETRequester();
	}

	private static class POSTHolder {
		private static final POSTRequester INSTANCE = new POSTRequester();
	}

	public static AbstractRequester getInstance(String method) {
		switch (method.toUpperCase()) {
			case "GET":
				return GETHolder.INSTANCE;

			case "POST":
				return POSTHolder.INSTANCE;

			default:
				throw new IllegalArgumentException(method + " is not a valid method");
		}
	}

	private RequesterFactory() {

	}

}
