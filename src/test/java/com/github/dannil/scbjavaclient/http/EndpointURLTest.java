package com.github.dannil.scbjavaclient.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import com.github.dannil.scbjavaclient.http.EndpointURL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EndpointURLTest {

    @Test
    public void createWithLocaleConstructor() throws MalformedURLException {
        URL url = new URL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        EndpointURL apiUrl = new EndpointURL(url);

        assertEquals("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM/", apiUrl.toString());
    }

    @Test
    public void appendTrailingSlash() {
        EndpointURL url = new EndpointURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        assertEquals("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM/", url.toString());
    }

    @Test
    public void toURLWithLocale() {
        EndpointURL url = new EndpointURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        url = url.toURL(new Locale("en", "US"));

        assertEquals("http://api.scb.se/OV0104/v1/doris/en/ssd/AM/", url.toString());
    }

    @Test
    public void toURLWithString() {
        EndpointURL url = new EndpointURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");
        url = url.toURL("fr");

        assertEquals("http://api.scb.se/OV0104/v1/doris/fr/ssd/AM/", url.toString());
    }

    @Test
    public void toURLWithStringThreeCharacters() {
        EndpointURL url = new EndpointURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/");

        assertEquals("http://api.scb.se/OV0104/v1/doris/ger/ssd/", url.toURL("ger").toString());
    }

    @Test
    public void equals() {
        EndpointURL url1 = new EndpointURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");
        EndpointURL url2 = new EndpointURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        assertEquals(url1, url2);
    }

    @Test
    public void equalsItself() {
        EndpointURL url1 = new EndpointURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        assertEquals(url1, url1);
    }

    @Test
    public void notEquals() {
        EndpointURL url1 = new EndpointURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");
        EndpointURL url2 = new EndpointURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/BE");

        assertNotEquals(url1, url2);
    }

    @Test
    public void notEqualsNull() {
        EndpointURL url1 = new EndpointURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        assertNotEquals(url1, null);
    }

    @Test
    public void notEqualsIncompatibleObject() throws MalformedURLException {
        EndpointURL url1 = new EndpointURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");
        URL url2 = new URL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        assertNotEquals(url1, url2);
    }

    @Test
    public void testHashCode() {
        EndpointURL url1 = new EndpointURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");
        EndpointURL url2 = new EndpointURL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        assertEquals(url1.hashCode(), url2.hashCode());
    }

}
