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

/**
 * <p>Exception for when the client couldn't find the requested URL.</p>
 *
 * @since 0.0.2
 */
public class SCBClientHttpUrlNotFoundException extends SCBClientHttpException {

    private static final long serialVersionUID = 1779756868616751298L;

    /**
     * <p>Default constructor.</p>
     */
    public SCBClientHttpUrlNotFoundException() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param message
     *            the message
     */
    public SCBClientHttpUrlNotFoundException(String message) {
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
    public SCBClientHttpUrlNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param cause
     *            the cause
     */
    public SCBClientHttpUrlNotFoundException(Throwable cause) {
        super(cause);
    }

}
