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

package com.github.dannil.scbjavaclient.utility;

import java.net.URL;

import com.github.dannil.scbjavaclient.exception.SCBClientException;
import com.github.dannil.scbjavaclient.exception.SCBClientForbiddenException;
import com.github.dannil.scbjavaclient.exception.SCBClientNotFoundException;
import com.github.dannil.scbjavaclient.exception.SCBClientTooManyRequestsException;
import com.github.dannil.scbjavaclient.http.HttpStatusCode;

/**
 * <p>Utility class for various HTTP operations.</p>
 *
 * @since 0.1.0
 */
public final class HttpUtility {

    /**
     * <p>Private constructor to prevent instantiation.</p>
     */
    private HttpUtility() {

    }

    /**
     * <p>Checks if the status code is representing an HTTP OK response. If the status
     * code is representing any other recognized HTTP status code that the API may return,
     * an exception is thrown which matches this status code. The <code>URL</code>
     * parameter is used to specify which address returned the status code.</p>
     *
     * @param url
     *            the <code>URL</code>
     * @param code
     *            the status code
     */
    public static void validateStatusCode(URL url, int code) {
        HttpStatusCode httpStatusCode = HttpStatusCode.valueOf(code);
        switch (httpStatusCode) {
            case OK:
                break;

            case FORBIDDEN:
                throw new SCBClientForbiddenException(url.toString());

            case NOT_FOUND:
                throw new SCBClientNotFoundException(url.toString());

            case TOO_MANY_REQUESTS:
                throw new SCBClientTooManyRequestsException(url.toString());

            default:
                throw new SCBClientException("Unhandled HTTP status code " + code);
        }
    }

}
