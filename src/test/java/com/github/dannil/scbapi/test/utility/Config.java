package com.github.dannil.scbapi.test.utility;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.dannil.scbapi.utility.JsonUtility;
import com.github.dannil.scbapi.utility.RequestPoster;

public final class Config {

	private static int timerMs;

	static {
		try {
			String response = RequestPoster.doGet("http://api.scb.se/OV0104/v1/doris/en/ssd/?config");
			JsonNode node = JsonUtility.getNode(response);

			int maxCalls = node.get("maxCalls").asInt();
			int timeWindow = node.get("timeWindow").asInt();

			// 10000 10
			timerMs = (int) (((timeWindow * 1000.0) / timeWindow) * (maxCalls / 100.0 + 0.9));
			System.out.println("timerMs: " + timerMs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int getTimerMs() {
		return timerMs;
	}
}
