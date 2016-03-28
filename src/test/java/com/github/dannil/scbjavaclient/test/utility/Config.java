package com.github.dannil.scbjavaclient.test.utility;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.dannil.scbjavaclient.exception.SCBClientException;
import com.github.dannil.scbjavaclient.utility.JsonUtility;
import com.github.dannil.scbjavaclient.utility.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.utility.requester.RequestMethod;
import com.github.dannil.scbjavaclient.utility.requester.RequesterFactory;

public final class Config {

	private static int timerMs;

	static {
		try {
			AbstractRequester get = RequesterFactory.getRequester(RequestMethod.GET);
			String response = get.getResponseBody("http://api.scb.se/OV0104/v1/doris/en/ssd/?config");
			JsonNode node = JsonUtility.getNode(response);

			int maxCalls = node.get("maxCalls").asInt();
			int timeWindow = node.get("timeWindow").asInt();

			// 10000 10
			timerMs = (int) (((timeWindow * 1000.0) / timeWindow) * (maxCalls / 100.0 + 0.9));
			// System.out.println("timerMs: " + timerMs);
		} catch (SCBClientException e) {
			throw e;
		}
	}

	public static int getTimerMs() {
		return timerMs;
	}
}
