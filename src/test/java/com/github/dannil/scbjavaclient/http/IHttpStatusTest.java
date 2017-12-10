package com.github.dannil.scbjavaclient.http;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.Test;

@Suite
public class IHttpStatusTest {

    private class DummyHttpStatus implements IHttpStatus {

        @Override
        public HttpStatusCode getStatusCode() {
            return HttpStatusCode.OK;
        }

    }

    @Test
    public void getStatusCode() {
        DummyHttpStatus status = new DummyHttpStatus();

        assertEquals(HttpStatusCode.OK, status.getStatusCode());
    }

}
