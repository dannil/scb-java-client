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

package com.github.dannil.scbjavaclient.communication.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class HttpResponseTest {

    @Test
    public void createWithConstructor() {
        InputStream stream = new ByteArrayInputStream(new byte[] {});
        HttpResponse response = new HttpResponse(HttpStatusCode.OK, stream);

        assertEquals(HttpStatusCode.OK, response.getStatus());
        assertNotNull(response.getStream());
    }

    @Test
    public void getStatus() {
        HttpResponse response = new HttpResponse(HttpStatusCode.OK, null);

        assertEquals(HttpStatusCode.OK, response.getStatus());
    }

    @Test
    public void getStream() {
        InputStream stream = new ByteArrayInputStream(new byte[] {});
        HttpResponse response = new HttpResponse(HttpStatusCode.OK, stream);

        assertNotNull(response.getStream());
    }
    
    @Test
    public void getBody() {
        String bodyContent = "hello world";
        InputStream stream = new ByteArrayInputStream(bodyContent.getBytes());
        HttpResponse response = new HttpResponse(HttpStatusCode.OK, stream);

        assertEquals("hello world", response.getBody());
    }
    
    @Test
    public void getBodyEmpty() {
        String bodyContent = "";
        InputStream stream = new ByteArrayInputStream(bodyContent.getBytes());
        HttpResponse response = new HttpResponse(HttpStatusCode.OK, stream);

        assertEquals("", response.getBody());
    }
    
    @Test
    public void getBodyNullStream() {
        InputStream stream = null;
        HttpResponse response = new HttpResponse(HttpStatusCode.OK, stream);

        assertNull(response.getBody());
    }

}
