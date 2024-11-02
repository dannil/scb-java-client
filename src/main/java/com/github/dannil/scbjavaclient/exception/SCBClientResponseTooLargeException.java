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

package com.github.dannil.scbjavaclient.exception;

/**
 * Exception for when the resulting response of a call to the API exceeded the maximum
 * response size, as defined by the PI.
 *
 * @since 1.2.0
 */
public class SCBClientResponseTooLargeException extends SCBClientException {

    private static final long serialVersionUID = 4871111166346462765L;

    /**
     * Default constructor.
     */
    public SCBClientResponseTooLargeException() {
        super();
    }

    /**
     * Overloaded constructor.
     *
     * @param message
     *            the message
     */
    public SCBClientResponseTooLargeException(String message) {
        super(message);
    }

    /**
     * Overloaded constructor.
     *
     * @param message
     *            the message
     * @param cause
     *            the cause
     */
    public SCBClientResponseTooLargeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Overloaded constructor.
     *
     * @param cause
     *            the cause
     */
    public SCBClientResponseTooLargeException(Throwable cause) {
        super(cause);
    }

}
