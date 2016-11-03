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
public class QueryBuilderTest {

	@Test
	public void callPrivateConstructor() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
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

		assertEquals("{\"query\": [{\"code\": \"Tid\", \"selection\": {\"filter\": \"item\", \"values\": [\"2012\"]}}],\"response\": {\"format\": \"json\"}}",
				query);
	}

}
