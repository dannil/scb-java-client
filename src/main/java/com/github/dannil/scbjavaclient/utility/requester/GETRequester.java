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
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

/**
 * <p>HTTP requester for GET requests.</p>
 * 
 * @since 0.0.2
 */
public class GETRequester extends AbstractRequester {

    /**
     * <p>Default constructor.</p>
     */
    public GETRequester() {
        super();
        super.requestProperties.put("Request-Method", "GET");
    }

    /**
     * <p>Overloaded constructor.</p>
     * 
     * @param charset
     *            the charset
     */
    public GETRequester(Charset charset) {
        super(charset);
        super.requestProperties.put("Request-Method", "GET");
    }

    @Override
    public String getBodyAsString(String url) {
        HttpGet request = new HttpGet(url);
        for (Entry<String, String> entry : super.requestProperties.entrySet()) {
            request.addHeader(entry.getKey(), entry.getValue());
        }

        HttpResponse response = super.getResponse(request);
        return super.getBody(response);
    }

}
