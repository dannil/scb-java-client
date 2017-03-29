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

package com.github.dannil.scbjavaclient.exception;

import com.github.dannil.scbjavaclient.http.HttpStatusCode;
import com.github.dannil.scbjavaclient.http.IHttpStatus;

/**
 * <p>Exception for when the client couldn't find the requested URL.</p>
 *
 * @since 0.0.2
 */
public class SCBClientNotFoundException extends SCBClientException implements IHttpStatus {

    private static final long serialVersionUID = 1257045307364064956L;

    /**
     * <p>Default constructor.</p>
     */
    public SCBClientNotFoundException() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param message
     *            the message
     */
    public SCBClientNotFoundException(String message) {
        super(message);
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param message
     *            the message
     * @param cause
     *            the cause
     */
    public SCBClientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param cause
     *            the cause
     */
    public SCBClientNotFoundException(Throwable cause) {
        super(cause);
    }

    @Override
    public HttpStatusCode getStatusCode() {
        return HttpStatusCode.NOT_FOUND;
    }

}
