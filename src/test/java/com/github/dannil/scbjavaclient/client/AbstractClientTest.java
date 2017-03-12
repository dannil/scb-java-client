package com.github.dannil.scbjavaclient.client;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AbstractClientTest {

    private static class DummyClient extends AbstractClient {

        public DummyClient(Locale locale) {
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
        AbstractClient client = new DummyClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void getRootUrl() {
        Locale locale = new Locale("fr", "CA");
        AbstractClient client = new DummyClient(locale);

        assertEquals("https://api.scb.se/OV0104/v1/doris/fr/ssd/", client.getRootUrl());
    }

}
