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

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AbstractContainerClientTest {

    private static class DummyContainerClient extends AbstractContainerClient {

        public DummyContainerClient(Locale locale) {
            super(locale);
        }

        @Override
        public String getUrl() {
            // TODO Auto-generated method stub
            return null;
        }

    }

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        AbstractContainerClient client = new DummyContainerClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void setLocale() {
        Locale locale = new Locale("sv", "SE");
        AbstractContainerClient client = new DummyContainerClient(locale);

        AbstractClient subClientOne = new DummyContainerClient(locale);
        AbstractClient subClientTwo = new DummyContainerClient(locale);

        client.addClient("client1", subClientOne);
        client.addClient("client2", subClientTwo);

        Locale newLocale = new Locale("fr", "CA");
        client.setLocale(newLocale);

        assertEquals(newLocale, subClientOne.getLocale());
        assertEquals(newLocale, subClientTwo.getLocale());
    }

    @Test
    public void getRootUrl() {
        Locale locale = new Locale("fr", "CA");
        AbstractContainerClient client = new DummyContainerClient(locale);

        assertEquals("https://api.scb.se/OV0104/v1/doris/fr/ssd/", client.getRootUrl());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addClientItself() {
        Locale locale = new Locale("sv", "SE");
        AbstractContainerClient client = new DummyContainerClient(locale);

        client.addClient("client", client);
    }

}
