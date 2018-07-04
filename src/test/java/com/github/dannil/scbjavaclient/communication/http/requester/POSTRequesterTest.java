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
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class POSTRequesterTest {

    @Test
    public void createWithDefaultConstructor() {
        POSTRequester post = new POSTRequester();

        // assertEquals(locale, post.getLocale());
        assertEquals(StandardCharsets.UTF_8, post.getCharset());
    }

    @Test
    public void getCharset() {
        POSTRequester post = new POSTRequester();

        assertEquals(StandardCharsets.UTF_8, post.getCharset());
    }

    // @Test
    // public void getLocale() {
    // Locale locale = new Locale("sv", "SE");
    // POSTRequester post = (POSTRequester)
    // RequesterFactory.getRequester(RequestMethod.POST, locale);
    //
    // assertEquals(locale, post.getLocale());
    // }

    @Test
    public void getPayload() {
        POSTRequester post = new POSTRequester();
        post.setQuery("payload");

        assertEquals("payload", post.getQuery());
    }

    @Test
    public void doRequestIllegalStateNullPayload() throws IOException {
        POSTRequester post = new POSTRequester();

        assertThrows(IllegalStateException.class,
                () -> post.getResponse(URLEndpoint.getRootUrl() + "BE/BE0701/MedelAlderNY").getBody());
    }

}
