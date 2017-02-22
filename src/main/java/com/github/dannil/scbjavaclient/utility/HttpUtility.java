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

import java.net.URI;

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
     * <p>Validates if the status code is a valid HTTP code. The <code>URI</code>
     * parameter is used to specify which address returned the status code.</p>
     *
     * @param uri
     *            the <code>URI</code>
     * @param statusCode
     *            the status code
     */
    public static void validateStatusCode(URI uri, int statusCode) {
        HttpStatusCode httpStatusCode = HttpStatusCode.fromStatusCode(statusCode);
        switch (httpStatusCode) {
            case OK:
                break;

            case FORBIDDEN:
                throw new SCBClientForbiddenException(uri.toString());

            case NOT_FOUND:
                throw new SCBClientNotFoundException(uri.toString());

            case TOO_MANY_REQUESTS:
                throw new SCBClientTooManyRequestsException(uri.toString());

            default:
                throw new SCBClientException("Unhandled HTTP status code " + statusCode);
        }
    }

}
