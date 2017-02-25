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

package com.github.dannil.scbjavaclient.http.requester;

import java.nio.charset.Charset;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;

/**
 * <p>HTTP requester for POST requests.</p>
 *
 * @since 0.0.2
 */
public class POSTRequester extends AbstractRequester {

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
    public String getBody(String url) {
        if (this.query == null) {
            throw new IllegalStateException("Payload is null");
        }

        HttpPost request = new HttpPost(url);
        for (Entry<String, String> entry : getRequestProperties().entrySet()) {
            request.addHeader(entry.getKey(), entry.getValue());
        }

        HttpEntity entity = new ByteArrayEntity(this.query.getBytes(Charset.forName(getCharset().name())));
        request.setEntity(entity);

        HttpResponse response = getResponse(request);
        return getBody(response);
    }
}
