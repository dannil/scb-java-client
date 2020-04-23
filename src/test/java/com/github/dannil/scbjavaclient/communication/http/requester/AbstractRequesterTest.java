/*
 * Copyright 2018 Daniel Nilsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.github.dannil.scbjavaclient.communication.http.requester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.http.HttpResponse;

import com.github.dannil.scbjavaclient.communication.http.HttpStatusCode;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.Test;

@Suite
public class AbstractRequesterTest {

    private class DummyRequester extends AbstractRequester {

        @Override
        public HttpResponse<String> getResponse(String url) {
            @SuppressWarnings("unchecked")
            HttpResponse<String> mockResponse = (HttpResponse<String>) mock(HttpResponse.class);
            when(mockResponse.statusCode()).thenReturn(HttpStatusCode.OK.getCode());
            when(mockResponse.body()).thenReturn("body");
            return mockResponse;
        }

    }

    @Test
    public void getResponse() {
        DummyRequester requester = new DummyRequester();
        HttpResponse<String> response = requester.getResponse("");

        assertEquals(HttpStatusCode.OK.getCode(), response.statusCode());
        assertEquals("body", response.body());
    }

}
