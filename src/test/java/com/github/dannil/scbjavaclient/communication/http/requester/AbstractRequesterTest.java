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

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.communication.http.HttpResponse;
import com.github.dannil.scbjavaclient.communication.http.HttpStatusCode;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

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
