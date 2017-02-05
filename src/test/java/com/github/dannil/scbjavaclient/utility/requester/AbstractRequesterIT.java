/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.utility.requester;

import static org.junit.Assert.assertNull;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbjavaclient.exception.SCBClientException;
import com.github.dannil.scbjavaclient.test.RemoteIntegrationTestSuite;

@RunWith(JUnit4.class)
public class AbstractRequesterIT extends RemoteIntegrationTestSuite {

    private static class DummyGETRequester extends GETRequester {

        public DummyGETRequester() {
            super();
            super.client = HttpClientBuilder.create().disableRedirectHandling().build();
        }

    }

    @Test(expected = SCBClientException.class)
    public void unhandledHttpStatusCode() {
        AbstractRequester abs = new DummyGETRequester();

        HttpGet get = new HttpGet("http://java.net");
        HttpResponse response = abs.getResponse(get);

        assertNull(response);
    }

}
