package com.github.dannil.scbjavaclient.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class QueryBuilder_UnitTest {

	@Test
	public void callPrivateConstructor() throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Constructor<?>[] cons = QueryBuilder.class.getDeclaredConstructors();
		cons[0].setAccessible(true);
		cons[0].newInstance();
		cons[0].setAccessible(false);

		assertFalse(cons[0].isAccessible());
	}

	@Test
	public void filterValueRemoveNull() {
		Map<String, Collection<?>> inputMap = new HashMap<String, Collection<?>>();
		inputMap.put("Tid", Arrays.asList(2012, null));

		String query = QueryBuilder.build(inputMap);

		assertEquals(
				"{\"query\": [{\"code\": \"Tid\", \"selection\": {\"filter\": \"item\", \"values\": [\"2012\"]}}],\"response\": {\"format\": \"json\"}}",
				query);
	}

}
