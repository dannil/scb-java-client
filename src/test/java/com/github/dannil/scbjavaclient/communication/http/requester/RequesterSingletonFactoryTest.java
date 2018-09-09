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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.communication.http.HttpRequestMethod;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class RequesterSingletonFactoryTest {

    @Test
    public void callPrivateConstructor()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<?>[] cons = RequesterSingletonFactory.class.getDeclaredConstructors();
        cons[0].setAccessible(true);
        Object o = cons[0].newInstance();
        cons[0].setAccessible(false);

        assertNotNull(o);
    }

    @Test
    public void callPrivateConstructorGETHolder() throws NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        // Ridiculous code to instantiate private static class inside a private
        // class
        Class<?> enclosingClass = RequesterSingletonFactory.class;
        Constructor<?> enclosingConstructor = enclosingClass.getDeclaredConstructor();
        enclosingConstructor.setAccessible(true);

        // Make sure we instantiate the correct inner class
        String innerClassName = "GETHolder";
        Class<?> innerClass = null;
        Class<?>[] innerClasses = RequesterSingletonFactory.class.getDeclaredClasses();
        for (int i = 0; i < innerClasses.length; i++) {
            if (innerClasses[i].toString().contains(innerClassName)) {
                // We found the correct class!
                innerClass = innerClasses[i];
            }
        }

        assertNotNull(innerClass);
        assertTrue(innerClass.toString().contains(innerClassName));

        Constructor<?> innerConstructor = innerClass.getDeclaredConstructors()[0];

        innerConstructor.setAccessible(true);
        Object o = innerConstructor.newInstance();
        innerConstructor.setAccessible(false);

        assertNotNull(o);
    }

    @Test
    public void callPrivateConstructorPOSTHolder() throws NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        // Ridiculous code to instantiate private static class inside a private
        // class
        Class<?> enclosingClass = RequesterSingletonFactory.class;
        Constructor<?> enclosingConstructor = enclosingClass.getDeclaredConstructor();
        enclosingConstructor.setAccessible(true);

        // Make sure we instantiate the correct inner class
        String innerClassName = "POSTHolder";
        Class<?> innerClass = null;
        Class<?>[] innerClasses = RequesterSingletonFactory.class.getDeclaredClasses();
        for (int i = 0; i < innerClasses.length; i++) {
            if (innerClasses[i].toString().contains(innerClassName)) {
                // We found the correct class!
                innerClass = innerClasses[i];
            }
        }

        assertNotNull(innerClass);
        assertTrue(innerClass.toString().contains(innerClassName));

        Constructor<?> innerConstructor = innerClass.getDeclaredConstructors()[0];

        innerConstructor.setAccessible(true);
        Object o = innerConstructor.newInstance();
        innerConstructor.setAccessible(false);

        assertNotNull(o);
    }

    @Test
    public void getRequester() {
        AbstractRequester abs = RequesterSingletonFactory.getRequester(HttpRequestMethod.GET);

        assertEquals(RequesterSingletonFactory.getRequester(HttpRequestMethod.GET), abs);
    }

    @Test
    public void getRequesterIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> RequesterSingletonFactory.getRequester(null));
    }

    // @Test
    // public void getRequesterLocale() {
    // Locale locale = new Locale("sv", "SE");
    // AbstractRequester abs = RequesterSingletonFactory.getRequester(RequestMethod.GET,
    // locale);
    //
    // assertTrue(abs instanceof GETRequester);
    // assertEquals(abs.getLocale(), locale);
    // }

    @Test
    public void requesterIsSingleton() {
        AbstractRequester abs1 = RequesterSingletonFactory.getRequester(HttpRequestMethod.GET, StandardCharsets.UTF_8);
        AbstractRequester abs2 = RequesterSingletonFactory.getRequester(HttpRequestMethod.GET, StandardCharsets.US_ASCII);

        assertEquals(StandardCharsets.US_ASCII, abs1.getCharset());
        assertEquals(abs1.getCharset(), abs2.getCharset());
    }

}
