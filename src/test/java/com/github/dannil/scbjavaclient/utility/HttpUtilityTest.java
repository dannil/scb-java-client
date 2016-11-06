package com.github.dannil.scbjavaclient.utility;

import static org.junit.Assert.assertFalse;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class HttpUtilityTest {

	@Test
	public void callPrivateConstructor() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<?>[] cons = HttpUtility.class.getDeclaredConstructors();
		cons[0].setAccessible(true);
		cons[0].newInstance();
		cons[0].setAccessible(false);

		assertFalse(cons[0].isAccessible());
	}

}
