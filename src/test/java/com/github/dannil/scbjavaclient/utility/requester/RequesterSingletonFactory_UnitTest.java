/*
 * Copyright 2016 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dannil.scbjavaclient.utility.requester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

public class RequesterSingletonFactory_UnitTest {

	@Test
	public void callPrivateConstructor() throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Constructor<?>[] cons = RequesterSingletonFactory.class.getDeclaredConstructors();
		cons[0].setAccessible(true);
		cons[0].newInstance();
		cons[0].setAccessible(false);

		assertFalse(cons[0].isAccessible());
	}

	@Test
	public void callPrivateConstructorGETHolder() throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		// Ridiculous code to instantiate private static class inside a private class
		Class<?> enclosingClass = RequesterSingletonFactory.class;
		Constructor<?> enclosingConstructor = enclosingClass.getDeclaredConstructor();
		enclosingConstructor.setAccessible(true);

		Class<?> innerClass = RequesterSingletonFactory.class.getDeclaredClasses()[0];
		// Make sure we instantiate the correct inner class
		assertTrue(innerClass.toString().contains("GETHolder"));

		Constructor<?> innerConstructor = innerClass.getDeclaredConstructors()[0];

		innerConstructor.setAccessible(true);
		innerConstructor.newInstance();
		innerConstructor.setAccessible(false);

		assertFalse(innerConstructor.isAccessible());
	}

	@Test
	public void callPrivateConstructorPOSTHolder() throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		// Ridiculous code to instantiate private static class inside a private class
		Class<?> enclosingClass = RequesterSingletonFactory.class;
		Constructor<?> enclosingConstructor = enclosingClass.getDeclaredConstructor();
		enclosingConstructor.setAccessible(true);

		Class<?> innerClass = RequesterSingletonFactory.class.getDeclaredClasses()[1];
		// Make sure we instantiate the correct inner class
		assertTrue(innerClass.toString().contains("POSTHolder"));

		Constructor<?> innerConstructor = innerClass.getDeclaredConstructors()[0];

		innerConstructor.setAccessible(true);
		innerConstructor.newInstance();
		innerConstructor.setAccessible(false);

		assertFalse(innerConstructor.isAccessible());
	}

	@Test
	public void getRequester() {
		AbstractRequester abs = RequesterSingletonFactory.getRequester(RequestMethod.GET);

		assertEquals(RequesterSingletonFactory.getRequester(RequestMethod.GET), abs);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getRequesterIllegalArgument() {
		AbstractRequester abs = RequesterSingletonFactory.getRequester(null);

		assertNull(abs);
	}

	@Test
	public void requesterIsSingleton() {
		AbstractRequester abs1 = RequesterSingletonFactory.getRequester(RequestMethod.GET, StandardCharsets.UTF_8);
		AbstractRequester abs2 = RequesterSingletonFactory.getRequester(RequestMethod.GET, StandardCharsets.US_ASCII);

		assertEquals(StandardCharsets.US_ASCII, abs1.getCharset());
		assertEquals(abs1.getCharset(), abs2.getCharset());
	}

}
