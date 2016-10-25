/*
 * Copyright 2016 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dannil.scbjavaclient.exception;

/**
 * Exception for when the client receives a response from the API but it refuses to perform any
 * further requests. Can occur if your request to the API or the resulting response from a request
 * to the API exceeds the maximum limit.
 * 
 * @author Daniel Nilsson
 */
public class SCBClientForbiddenException extends SCBClientException {

	private static final long serialVersionUID = 2445143839207212787L;

	/**
	 * Default constructor.
	 */
	public SCBClientForbiddenException() {
		super();
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param message
	 *            the message
	 */
	public SCBClientForbiddenException(String message) {
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
	public SCBClientForbiddenException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param cause
	 *            the cause
	 */
	public SCBClientForbiddenException(Throwable cause) {
		super(cause);
	}

}
