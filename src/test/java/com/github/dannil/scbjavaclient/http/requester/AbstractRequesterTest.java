package com.github.dannil.scbjavaclient.http.requester;

import static org.junit.Assert.assertEquals;

import com.github.dannil.scbjavaclient.http.HttpResponse;
import com.github.dannil.scbjavaclient.http.HttpStatusCode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
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
        
        assertEquals(response.getStatus(), HttpStatusCode.OK);
        assertEquals(response.getStream(), null);
    }
    
}
