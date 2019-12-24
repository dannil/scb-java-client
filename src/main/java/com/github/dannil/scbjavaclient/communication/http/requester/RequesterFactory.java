/*
 * Copyright 2018 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.communication.http.requester;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.github.dannil.scbjavaclient.communication.http.HttpRequestMethod;

/**
 * <p>Factory for returning regular (non-singleton) requesters.</p>
 *
 * @since 1.2.0
 */
public final class RequesterFactory {

    /**
     * <p>Private constructor to prevent instantiation.</p>
     */
    private RequesterFactory() {

    }

    /**
     * <p>Returns a regular (non-singleton) requester which matches the method. All
     * requests are routed to match the
     * {@link com.github.dannil.scbjavaclient.constants.APIConstants#FALLBACK_LOCALE
     * FALLBACK_LOCALE} and responses are read as UTF-8 character encoding.</p>
     *
     * @param method
     *            the method (i.e. GET or POST)
     * @return a regular (non-singleton) requester which matches the method.
     */
    public static AbstractRequester getRequester(HttpRequestMethod method) {
        return getRequester(method, StandardCharsets.UTF_8);
    }

    /**
     * <p>Returns a regular (non-singleton) requester which matches the method. All
     * requests are routed to match the specified <code>Locale</code> and responses are
     * read as to match the character encoding.</p>
     *
     * @param method
     *            the method (i.e. GET or POST)
     * @param charset
     *            the character encoding to use
     * @return a regular (non-singleton) requester which matches the method.
     */
    public static AbstractRequester getRequester(HttpRequestMethod method, Charset charset) {
        switch (method) {
            case GET:
                return new GETRequester(charset);

            case POST:
                return new POSTRequester(charset);

            default:
                throw new IllegalArgumentException(method + " is not a valid method");
        }
    }

}
