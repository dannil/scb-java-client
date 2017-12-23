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

package com.github.dannil.scbjavaclient.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import com.github.dannil.scbjavaclient.http.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.Test;

@Suite
public class AbstractClientTest {

    private static class DummyClient extends AbstractClient {

        public DummyClient(Locale locale) {
            super(locale);
        }

        @Override
        public URLEndpoint getUrl() {
            // TODO Auto-generated method stub
            return null;
        }

    }

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        AbstractClient client = new DummyClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void getRootUrl() {
        Locale locale = new Locale("fr", "CA");
        AbstractClient client = new DummyClient(locale);

        assertEquals("https://api.scb.se/OV0104/v1/doris/fr/ssd/", client.getRootUrl().toString());
    }

}
