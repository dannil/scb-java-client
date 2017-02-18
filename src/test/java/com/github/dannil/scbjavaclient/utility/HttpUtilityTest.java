package com.github.dannil.scbjavaclient.utility;

import static org.junit.Assert.assertFalse;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;

import com.github.dannil.scbjavaclient.exception.SCBClientException;
import com.github.dannil.scbjavaclient.exception.SCBClientForbiddenException;
import com.github.dannil.scbjavaclient.exception.SCBClientTooManyRequestsException;
import com.github.dannil.scbjavaclient.exception.SCBClientUrlNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class HttpUtilityTest {

    private URI url;

    @Before
    public void setup() throws URISyntaxException {
        this.url = new URI("http://example.com");

    }

    @Test
    public void callPrivateConstructor()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<?>[] cons = HttpUtility.class.getDeclaredConstructors();
        cons[0].setAccessible(true);
        cons[0].newInstance();
        cons[0].setAccessible(false);

        assertFalse(cons[0].isAccessible());
    }

    @Test(expected = SCBClientForbiddenException.class)
    public void httpForbidden() {
        HttpUtility.validateStatusCode(url, 403);
    }

    @Test(expected = SCBClientUrlNotFoundException.class)
    public void httpNotFound() {
        HttpUtility.validateStatusCode(url, 404);
    }

    @Test(expected = SCBClientTooManyRequestsException.class)
    public void httpTooManyRequests() {
        HttpUtility.validateStatusCode(url, 429);
    }

    @Test(expected = SCBClientException.class)
    public void unhandledStatusCode() {
        HttpUtility.validateStatusCode(url, -1);
    }

}
