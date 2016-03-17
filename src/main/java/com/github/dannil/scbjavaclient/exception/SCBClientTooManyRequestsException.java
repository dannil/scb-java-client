package com.github.dannil.scbjavaclient.exception;

public class SCBClientTooManyRequestsException extends SCBClientException {

	private static final long serialVersionUID = -7761485153313257674L;

	public SCBClientTooManyRequestsException() {
		super();
	}

	public SCBClientTooManyRequestsException(String message) {
		super(message);
	}

	public SCBClientTooManyRequestsException(String message, Throwable cause) {
		super(message, cause);
	}

	public SCBClientTooManyRequestsException(Throwable cause) {
		super(cause);
	}

}
