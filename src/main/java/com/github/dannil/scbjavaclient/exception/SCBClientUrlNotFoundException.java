package com.github.dannil.scbjavaclient.exception;

public class SCBClientUrlNotFoundException extends SCBClientException {

	private static final long serialVersionUID = 1779756868616751298L;

	public SCBClientUrlNotFoundException() {
		super();
	}

	public SCBClientUrlNotFoundException(String message) {
		super(message);
	}

	public SCBClientUrlNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public SCBClientUrlNotFoundException(Throwable cause) {
		super(cause);
	}

}
