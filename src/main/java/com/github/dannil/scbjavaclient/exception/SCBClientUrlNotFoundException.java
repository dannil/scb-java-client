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
 * <p>Exception for when the client couldn't find the requested URL.</p>
 * 
 * @author Daniel Nilsson
 */
public class SCBClientUrlNotFoundException extends SCBClientException {

	private static final long serialVersionUID = 1779756868616751298L;

	/**
	 * <p>Default constructor.</p>
	 */
	public SCBClientUrlNotFoundException() {
		super();
	}

	/**
	 * <p>Overloaded constructor.</p>
	 * 
	 * @param message
	 *            the message
	 */
	public SCBClientUrlNotFoundException(String message) {
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
	public SCBClientUrlNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * <p>Overloaded constructor.</p>
	 * 
	 * @param cause
	 *            the cause
	 */
	public SCBClientUrlNotFoundException(Throwable cause) {
		super(cause);
	}

}
