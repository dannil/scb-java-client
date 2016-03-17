package com.github.dannil.scbjavaclient.exception;

public class SCBClientParsingException extends SCBClientException {

	private static final long serialVersionUID = 2978418970046773855L;

	public SCBClientParsingException() {
		super();
	}

	public SCBClientParsingException(String message) {
		super(message);
	}

	public SCBClientParsingException(String message, Throwable cause) {
		super(message, cause);
	}

	public SCBClientParsingException(Throwable cause) {
		super(cause);
	}

}
