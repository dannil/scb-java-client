/*
 * Copyright 2016 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dannil.scbjavaclient.test.utility;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.dannil.scbjavaclient.exception.SCBClientException;
import com.github.dannil.scbjavaclient.format.JsonConventionalFormat;
import com.github.dannil.scbjavaclient.utility.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.utility.requester.RequestMethod;
import com.github.dannil.scbjavaclient.utility.requester.RequesterFactory;

public final class Config {

	private static int timerMs;

	static {
		try {
			AbstractRequester get = RequesterFactory.getRequester(RequestMethod.GET);
			String response = get.getBodyAsString("http://api.scb.se/OV0104/v1/doris/en/ssd/?config");
			JsonNode node = JsonConventionalFormat.toNode(response);

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
