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
import java.util.EnumMap;
import java.util.Map;

import com.github.dannil.scbjavaclient.communication.http.HttpRequestMethod;

/**
 * <p>Factory for returning singleton requesters. The regular {@link RequesterFactory} is
 * recommended instead of this class; this class should only be used if you really need a
 * singleton.</p>
 *
 * @since 1.2.0
 */
public final class RequesterSingletonFactory {

    private static Map<HttpRequestMethod, AbstractRequester> requesters;

    static {
        requesters = new EnumMap<>(HttpRequestMethod.class);
        requesters.put(HttpRequestMethod.GET, GETHolder.INSTANCE);
        requesters.put(HttpRequestMethod.POST, POSTHolder.INSTANCE);
    }

    /**
     * <p>Private constructor to prevent instantiation.</p>
     */
    private RequesterSingletonFactory() {

    }

    /**
     * <p>Returns a singleton requester which matches the method. All requests are routed
     * to match the
     * {@link com.github.dannil.scbjavaclient.constants.APIConstants#FALLBACK_LOCALE
     * FALLBACK_LOCALE} and responses are read as UTF-8 character encoding.</p>
     *
     * @param method
     *            the method (i.e. GET or POST)
     * @return a singleton requester which matches the method.
     */
    public static AbstractRequester getRequester(HttpRequestMethod method) {
        return getRequester(method, StandardCharsets.UTF_8);
    }

    /**
     * <p>Returns a singleton requester which matches the method. All responses are read
     * as to match the character encoding.</p>
     *
     * @param method
     *            the method (i.e. GET or POST)
     * @param charset
     *            the character encoding to use
     * @return a singleton requester which matches the method.
     */
    public static AbstractRequester getRequester(HttpRequestMethod method, Charset charset) {
        if (!requesters.containsKey(method)) {
            throw new IllegalArgumentException(method + " is not a valid method");
        }
        AbstractRequester abs = requesters.get(method);
        abs.setCharset(charset);
        return abs;
    }

    /**
     * <p>Singleton holder for GET requester.</p>
     */
    private static final class GETHolder {

        protected static final AbstractRequester INSTANCE = new GETRequester(StandardCharsets.UTF_8);

        /**
         * Private constructor.
         */
        private GETHolder() {
            // To avoid initialization outside this class
        }

    }

    /**
     * <p>Singleton holder for POST requester.</p>
     */
    private static final class POSTHolder {

        protected static final AbstractRequester INSTANCE = new POSTRequester(StandardCharsets.UTF_8);

        /**
         * Private constructor.
         */
        private POSTHolder() {
            // To avoid initialization outside this class
        }

    }

}
