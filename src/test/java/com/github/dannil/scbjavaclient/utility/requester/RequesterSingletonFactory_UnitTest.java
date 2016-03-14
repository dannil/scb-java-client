package com.github.dannil.scbjavaclient.utility.requester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
	public void getRequester() {
		AbstractRequester abs = RequesterSingletonFactory.getRequester("GET");

		assertEquals(RequesterSingletonFactory.getRequester("GET"), abs);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getRequesterIllegalArgument() {
		AbstractRequester abs = RequesterSingletonFactory.getRequester("BLABLA");

		assertNull(abs);
	}

}
