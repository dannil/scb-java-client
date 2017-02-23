package com.github.dannil.scbjavaclient.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ApiURLTest {

    @Test
    public void createWithLocaleConstructor() throws MalformedURLException {
        URL url = new URL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        ApiURL apiUrl = new ApiURL(url);

        assertEquals("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM/", apiUrl.toString());
    }

    @Test
    public void appendTrailingSlash() {
        ApiURL url = new ApiURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        assertEquals("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM/", url.toString());
    }

    @Test
    public void toLanguageLocale() {
        ApiURL url = new ApiURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        url = url.toLanguage(new Locale("en", "US"));

        assertEquals("http://api.scb.se/OV0104/v1/doris/en/ssd/AM/", url.toString());
    }

    @Test
    public void toLanguageString() {
        ApiURL url = new ApiURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");
        url = url.toLanguage("fr");

        assertEquals("http://api.scb.se/OV0104/v1/doris/fr/ssd/AM/", url.toString());
    }

    @Test
    public void equals() {
        ApiURL url1 = new ApiURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");
        ApiURL url2 = new ApiURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        assertEquals(url1, url2);
    }

    @Test
    public void equalsItself() {
        ApiURL url1 = new ApiURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        assertEquals(url1, url1);
    }

    @Test
    public void notEquals() {
        ApiURL url1 = new ApiURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");
        ApiURL url2 = new ApiURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/BE");

        assertNotEquals(url1, url2);
    }

    @Test
    public void notEqualsNull() {
        ApiURL url1 = new ApiURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        assertNotEquals(url1, null);
    }

    @Test
    public void notEqualsIncompatibleObject() throws MalformedURLException {
        ApiURL url1 = new ApiURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");
        URL url2 = new URL("http://api.scb.se/OV0104/v1/doris/sv/ssd/BE");

        assertNotEquals(url1, url2);
    }

    @Test
    public void testHashCode() {
        ApiURL url1 = new ApiURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");
        ApiURL url2 = new ApiURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        assertEquals(url1.hashCode(), url2.hashCode());
    }

}
