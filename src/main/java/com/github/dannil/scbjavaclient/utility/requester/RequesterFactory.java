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

package com.github.dannil.scbjavaclient.utility.requester;

import java.util.HashMap;
import java.util.Map;

public class RequesterFactory {

	private static Map<String, AbstractRequester> requesters;

	static {
		requesters = new HashMap<String, AbstractRequester>();
		requesters.put("GET", GETHolder.INSTANCE);
		requesters.put("POST", POSTHolder.INSTANCE);
	}

	private static class GETHolder {
		private static final GETRequester INSTANCE = new GETRequester();
	}

	private static class POSTHolder {
		private static final POSTRequester INSTANCE = new POSTRequester();
	}

	public static AbstractRequester getInstance(String method) {
		if (!requesters.containsKey(method)) {
			throw new IllegalArgumentException(method + " is not a valid method");
		}
		return requesters.get(method);

		// switch (method.toUpperCase()) {
		// case "GET":
		// return GETHolder.INSTANCE;
		//
		// case "POST":
		// return POSTHolder.INSTANCE;
		//
		// default:
		// throw new IllegalArgumentException(method + " is not a valid method");
		// }
	}

	private RequesterFactory() {

	}

}
