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
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;

import com.github.dannil.scbjavaclient.communication.http.HttpResponse;
import com.github.dannil.scbjavaclient.exception.SCBClientException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>HTTP requester for POST requests.</p>
 *
 * @since 1.2.0
 */
public class POSTRequester extends AbstractRequester {

    private static final Logger LOGGER = LoggerFactory.getLogger(POSTRequester.class);

    private String query;

    /**
     * <p>Default constructor.</p>
     */
    public POSTRequester() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param charset
     *            the charset
     */
    public POSTRequester(Charset charset) {
        super(charset);
    }

    /**
     * <p>Getter for query.</p>
     *
     * @return the query
     */
    public String getQuery() {
        return this.query;
    }

    /**
     * <p>Setter for query.</p>
     *
     * @param query
     *            the query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public HttpResponse getResponse(String url) {
        if (this.query == null) {
            throw new IllegalStateException("Payload is null");
        }
        LOGGER.debug("POST: {}, {}", url, this.query);
        try {
            URLConnection connection = getConnection(url);
            connection.setDoOutput(true);
            try (OutputStream output = connection.getOutputStream()) {
                output.write(this.query.getBytes(getCharset()));
            }
            HttpResponse response = getResponse(connection);
            LOGGER.debug("HTTP {}: {}", response.getStatus().getCode(), url);
            return response;
        } catch (IOException e) {
            throw new SCBClientException(e);
        }
    }

}
