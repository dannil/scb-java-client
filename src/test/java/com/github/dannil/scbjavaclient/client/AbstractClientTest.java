package com.github.dannil.scbjavaclient.client;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AbstractClientTest {

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

}
