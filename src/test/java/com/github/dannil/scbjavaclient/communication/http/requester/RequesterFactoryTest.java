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
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.communication.http.HttpRequestMethod;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class RequesterFactoryTest {

    @Test
    public void callPrivateConstructor()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<?>[] cons = RequesterFactory.class.getDeclaredConstructors();
        cons[0].setAccessible(true);
        Object o = cons[0].newInstance();
        cons[0].setAccessible(false);

        assertNotNull(o);
    }

    @Test
    public void getGETRequester() {
        AbstractRequester get = RequesterFactory.getRequester(HttpRequestMethod.GET);

        assertEquals(StandardCharsets.UTF_8, get.getCharset());
    }

    @Test
    public void getGETRequesterWithCharset() {
        AbstractRequester get = RequesterFactory.getRequester(HttpRequestMethod.GET, StandardCharsets.US_ASCII);

        assertEquals(StandardCharsets.US_ASCII, get.getCharset());
    }

    @Test
    public void getPOSTRequester() {
        AbstractRequester post = RequesterFactory.getRequester(HttpRequestMethod.POST);

        assertEquals(StandardCharsets.UTF_8, post.getCharset());
    }

    @Test
    public void getPOSTRequesterWithCharset() {
        AbstractRequester post = RequesterFactory.getRequester(HttpRequestMethod.POST, StandardCharsets.US_ASCII);

        assertEquals(StandardCharsets.US_ASCII, post.getCharset());
    }

}
