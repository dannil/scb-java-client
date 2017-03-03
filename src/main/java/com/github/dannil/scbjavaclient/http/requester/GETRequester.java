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

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import com.github.dannil.scbjavaclient.exception.SCBClientException;

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
    public String getBody(String url) {
        try {
            InputStream response = getResponse(getConnection(url));
            return getBody(response);
        } catch (IOException e) {
            throw new SCBClientException(e);
        }
    }

}
