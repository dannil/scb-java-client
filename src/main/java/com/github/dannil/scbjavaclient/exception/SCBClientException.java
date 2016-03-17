package com.github.dannil.scbjavaclient.exception;

public class SCBClientException extends RuntimeException {

	private static final long serialVersionUID = -2428718528932238427L;

	public SCBClientException() {
		super();
	}

	public SCBClientException(String message) {
		super(message);
	}

	public SCBClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public SCBClientException(Throwable cause) {
		super(cause);
	}

}
