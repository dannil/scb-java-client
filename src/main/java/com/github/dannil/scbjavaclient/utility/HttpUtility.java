package com.github.dannil.scbjavaclient.utility;

import java.net.URI;

import com.github.dannil.scbjavaclient.exception.SCBClientException;
import com.github.dannil.scbjavaclient.exception.SCBClientForbiddenException;
import com.github.dannil.scbjavaclient.exception.SCBClientTooManyRequestsException;
import com.github.dannil.scbjavaclient.exception.SCBClientUrlNotFoundException;

public final class HttpUtility {

	/**
	 * <p>
	 * Private constructor to prevent instantiation.
	 * </p>
	 */
	private HttpUtility() {

	}

	/**
	 * <p>
	 * Validates if the status code is a valid HTTP code. The <code>URI</code> parameter is used to
	 * specify which URI returned the status code.
	 * </p>
	 * 
	 * @param uri
	 *            the <code>URI</code>
	 * @param statusCode
	 *            the status code
	 */
	public static void validateStatusCode(URI uri, int statusCode) {
		switch (statusCode) {
			case 200:
				break;

			case 403:
				throw new SCBClientForbiddenException(uri.toString());

			case 404:
				throw new SCBClientUrlNotFoundException(uri.toString());

			case 429:
				throw new SCBClientTooManyRequestsException(uri.toString());

			default:
				throw new SCBClientException("Unhandled HTTP status code " + statusCode);
		}
	}

}
