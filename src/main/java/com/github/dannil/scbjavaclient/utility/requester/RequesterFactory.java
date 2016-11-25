/*
 * Copyright 2016 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.github.dannil.scbjavaclient.utility.requester;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * <p>Factory for returning regular (non-singleton) requesters.</p>
 * 
 * @author Daniel Nilsson
 */
public final class RequesterFactory {

	/**
	 * <p>Private constructor to prevent instantiation.</p>
	 */
	private RequesterFactory() {

	}

	/**
	 * <p>Returns a regular (non-singleton) requester which matches the method. All
	 * responses are read as UTF-8 character encoding.</p>
	 * 
	 * @param method
	 *            the method (i.e. GET or POST)
	 * @return a regular (non-singleton) requester which matches the method.
	 */
	public static AbstractRequester getRequester(RequestMethod method) {
		return getRequester(method, StandardCharsets.UTF_8);
	}

	/**
	 * <p>Returns a regular (non-singleton) requester which matches the method. All
	 * responses are read as to match the character encoding.</p>
	 * 
	 * @param method
	 *            the method (i.e. GET or POST)
	 * @param charset
	 *            the character encoding to use
	 * @return a regular (non-singleton) requester which matches the method.
	 */
	public static AbstractRequester getRequester(RequestMethod method, Charset charset) {
		// AbstractRequester abs = getRequester(method);
		// abs.setCharset(charset);
		// return abs;
		switch (method) {
			case GET:
				return new GETRequester(charset);

			case POST:
				return new POSTRequester(charset);
		}
		throw new IllegalArgumentException(method + " is not a valid method");
	}

}
