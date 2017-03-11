package com.github.dannil.scbjavaclient.exception;

import com.github.dannil.scbjavaclient.http.HttpStatusCode;

public class SCBClientExceptionFactory {

    public static SCBClientException getHttpException(String url, int statusCode) {
        HttpStatusCode httpStatusCode = HttpStatusCode.valueOf(statusCode);
        switch (httpStatusCode) {
            case OK:
                break;

            case FORBIDDEN:
                return new SCBClientForbiddenException(url.toString());

            case NOT_FOUND:
                return new SCBClientNotFoundException(url.toString());

            case TOO_MANY_REQUESTS:
                return new SCBClientTooManyRequestsException(url.toString());

            default:
                return new SCBClientException("Unhandled HTTP status code " + statusCode);
        }
        return null;
    }

}
