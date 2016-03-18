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

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory for returning singleton requesters. The regular {@link RequesterFactory} is recommended
 * instead of this class; this class should only be used if you really need a singleton.
 * 
 * @author Daniel Nilsson
 */
public class RequesterSingletonFactory {

	private static Map<String, AbstractRequester> requesters;

	static {
		requesters = new HashMap<String, AbstractRequester>();
		requesters.put("GET", GETHolder.INSTANCE);
		requesters.put("POST", POSTHolder.INSTANCE);
	}

	private static class GETHolder {
		private static final GETRequester INSTANCE = new GETRequester(StandardCharsets.UTF_8);
	}

	private static class POSTHolder {
		private static final POSTRequester INSTANCE = new POSTRequester(StandardCharsets.UTF_8);
	}

	private RequesterSingletonFactory() {

	}

	/**
	 * Returns a singleton requester which matches the method. All responses are
	 * read as UTF-8 character encoding.
	 * 
	 * @param method
	 *            the method (i.e. GET or POST)
	 * @return a singleton requester which matches the method.
	 */
	public static AbstractRequester getRequester(String method) {
		return getRequester(method, StandardCharsets.UTF_8);
	}

	/**
	 * Returns a singleton requester which matches the method. All responses are
	 * read as to match the character encoding.
	 * 
	 * @param method
	 *            the method (i.e. GET or POST)
	 * @param charset
	 *            the character encoding to use
	 * @return a singleton requester which matches the method.
	 */
	public static AbstractRequester getRequester(String method, Charset charset) {
		if (!requesters.containsKey(method)) {
			throw new IllegalArgumentException(method + " is not a valid method");
		}
		AbstractRequester abs = requesters.get(method);
		abs.setCharset(charset);
		return abs;
	}

}
