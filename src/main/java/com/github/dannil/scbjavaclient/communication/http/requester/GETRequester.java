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

import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;

import com.github.dannil.scbjavaclient.exception.SCBClientException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>HTTP requester for GET requests.</p>
 *
 * @param <T>
 *            the type of the response
 *
 * @since 1.2.0
 */
public class GETRequester<T> extends AbstractRequester<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GETRequester.class);

    /**
     * <p>Default constructor.</p>
     */
    public GETRequester() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param charset
     *            the charset
     */
    public GETRequester(Charset charset) {
        super(charset);
    }

    @Override
    public HttpResponse<T> getResponse(String url) {
        LOGGER.debug("GET: {}", url);
        try {
            HttpResponse<T> response = getResponse(url, "GET", "");
            LOGGER.debug("HTTP {}: {}", response.statusCode(), url);
            return response;
        } catch (IOException | InterruptedException e) {
            throw new SCBClientException(e);
        }
    }

}
