/*
 * Copyright 2017 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.http;

import java.util.Objects;

/**
 * <p>Enumerable for the most common HTTP status codes returned by the API.</p>
 *
 * @since 0.2.0
 */
public enum HttpStatusCode {

    OK(200, "OK"), FORBIDDEN(403, "Forbidden"), NOT_FOUND(404, "Not Found"), TOO_MANY_REQUESTS(429,
            "Too Many Requests");

    private int statusCode;
    private String description;
    private String text;

    /**
     * <p>Default constructor.</p>
     *
     * @param statusCode
     *            the status code
     * @param description
     *            the description
     */
    HttpStatusCode(int statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
        this.text = Integer.toString(statusCode);
    }

    /**
     * <p>Get the HTTP status code.</p>
     *
     * @return the status code
     */
    public int getStatusCode() {
        return this.statusCode;
    }

    /**
     * <p>Get the description.</p>
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * <p>Get the HTTP status code as a text string.</p>
     *
     * @return the status code as a text string
     */
    public String asText() {
        return this.text;
    }

    /**
     * <p>Returns a <code>HttpStatusCode</code> which corresponds to the input status
     * code.</p>
     *
     * @param statusCode
     *            the status code
     * @return a <code>HttpStatusCode</code>
     */
    public static HttpStatusCode valueOf(int statusCode) {
        for (HttpStatusCode h : HttpStatusCode.values()) {
            if (Objects.equals(h.getStatusCode(), statusCode)) {
                return h;
            }
        }
        throw new IllegalArgumentException("No HTTP status enum exists for status code " + statusCode);
    }

}
