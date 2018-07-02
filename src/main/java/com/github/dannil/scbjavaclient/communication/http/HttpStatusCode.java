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

/**
 * <p>Enumerable for the most common HTTP status codes returned by the API.</p>
 *
 * @since 1.2.0
 */
public enum HttpStatusCode {

    OK(200, "OK"), FORBIDDEN(403, "Forbidden"), NOT_FOUND(404, "Not Found"), TOO_MANY_REQUESTS(429,
            "Too Many Requests");

    private int code;
    private String description;

    /**
     * <p>Default constructor.</p>
     *
     * @param code
     *            the status code
     * @param description
     *            the description
     */
    HttpStatusCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * <p>Get the HTTP status code.</p>
     *
     * @return the status code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * <p>Get the description.</p>
     *
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * <p>Get the HTTP status code as a text string.</p>
     *
     * @return the status code as a text string
     */
    public String asText() {
        return String.valueOf(this.code);
    }

    /**
     * <p>Returns a <code>HttpStatusCode</code> which corresponds to the input status
     * code.</p>
     *
     * @param code
     *            the status code
     * @return a <code>HttpStatusCode</code>
     */
    public static HttpStatusCode valueOf(int code) {
        for (HttpStatusCode h : HttpStatusCode.values()) {
            if (h.getCode() == code) {
                return h;
            }
        }
        throw new IllegalArgumentException("No HTTP status enumerable exists for status code " + code);
    }

}
