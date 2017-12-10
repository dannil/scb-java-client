package com.github.dannil.scbjavaclient.http.requester;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.dannil.scbjavaclient.http.HttpResponse;
import com.github.dannil.scbjavaclient.http.HttpStatusCode;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.Test;

@Suite
public class AbstractRequesterTest {

    private class DummyRequester extends AbstractRequester {

        @Override
        public HttpResponse getResponse(String url) {
            return new HttpResponse(HttpStatusCode.OK, null);
        }

    }

    @Test
    public void getResponse() {
        DummyRequester requester = new DummyRequester();
        HttpResponse response = requester.getResponse("");

        assertEquals(HttpStatusCode.OK, response.getStatus());
        assertEquals(null, response.getStream());
    }

}
