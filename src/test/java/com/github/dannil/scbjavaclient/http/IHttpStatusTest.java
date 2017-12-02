package com.github.dannil.scbjavaclient.http;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
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
