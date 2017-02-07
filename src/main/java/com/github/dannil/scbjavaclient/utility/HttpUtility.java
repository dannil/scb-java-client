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
import com.github.dannil.scbjavaclient.exception.SCBClientHttpForbiddenException;
import com.github.dannil.scbjavaclient.exception.SCBClientHttpTooManyRequestsException;
import com.github.dannil.scbjavaclient.exception.SCBClientHttpUrlNotFoundException;

/**
 * <p>Utility class for various HTTP operations.</p>
 *
 * @since 0.1.0
 */
public final class HttpUtility {

    private static final int HTTP_OK = 200;

    private static final int HTTP_FORBIDDEN = 403;

    private static final int HTTP_NOTFOUND = 404;

    private static final int HTTP_TOO_MANY_REQUESTS = 429;

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
        switch (statusCode) {
            case HTTP_OK:
                break;

            case HTTP_FORBIDDEN:
                throw new SCBClientHttpForbiddenException(uri.toString());

            case HTTP_NOTFOUND:
                throw new SCBClientHttpUrlNotFoundException(uri.toString());

            case HTTP_TOO_MANY_REQUESTS:
                throw new SCBClientHttpTooManyRequestsException(uri.toString());

            default:
                throw new SCBClientException("Unhandled HTTP status code " + statusCode);
        }
    }

}
