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

package com.github.dannil.scbjavaclient.communication.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.github.dannil.scbjavaclient.exception.SCBClientException;

import org.apache.commons.io.input.BOMInputStream;

/**
 * <p>Class which encapsulates HTTP response data.</p>
 *
 * @since 1.2.0
 */
public class HttpResponse {

    private HttpStatusCode status;

    private InputStream stream;

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param status
     *            the status
     * @param stream
     *            the stream
     */
    public HttpResponse(HttpStatusCode status, InputStream stream) {
        this.status = status;
        this.stream = stream;
    }

    /**
     * <p>Getter for status.</p>
     *
     * @return the status
     */
    public HttpStatusCode getStatus() {
        return this.status;
    }

    /**
     * <p>Getter for stream.</p>
     *
     * @return the stream
     */
    public InputStream getStream() {
        return this.stream;
    }

    /**
     * <p>Retrieves the body for the current <code>InputStream</code>.</p>
     *
     * @return the body
     */
    public String getBody() {
        if (this.stream == null) {
            return null;
        }
        try (BOMInputStream bis = new BOMInputStream(this.stream)) {
            try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
                for (int result = bis.read(); result != -1; result = bis.read()) {
                    bos.write((byte) result);
                }
                return bos.toString();
            }
        } catch (IOException e) {
            throw new SCBClientException(e);
        }
    }

}
