/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class QueryBuilderTest {

    @Test
    public void callPrivateConstructor()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<?>[] cons = QueryBuilder.class.getDeclaredConstructors();
        cons[0].setAccessible(true);
        Object o = cons[0].newInstance();
        cons[0].setAccessible(false);

        assertNotNull(o);
    }

    @Test
    public void filterValue() {
        Map<String, Collection<?>> inputMap = new HashMap<String, Collection<?>>();
        inputMap.put("ContentsCode", Arrays.asList("HE0103D2"));
        inputMap.put("Alder", new ArrayList<>(Arrays.asList("tot", null)));
        inputMap.put("Kon", Arrays.asList("4"));
        inputMap.put("Boendeform", new ArrayList<>(Arrays.asList(null, null)));
        inputMap.put("Tid", Arrays.asList("2012"));

        String query = QueryBuilder.build(inputMap);

        assertFalse(query.contains("Boendeform"));
        assertTrue(query.contains("Alder"));
        assertTrue(query.contains("Kon"));
        assertTrue(query.contains("Tid"));
    }

    @Test
    public void filterValueRemoveNullKey() {
        Map<String, Collection<?>> inputMap = new HashMap<String, Collection<?>>();
        inputMap.put(null, Arrays.asList("abc"));

        String query = QueryBuilder.build(inputMap);

        assertFalse(query.contains("null"));
        assertFalse(query.contains("abc"));
    }

    @Test
    public void filterValueRemoveNullValue() {
        Map<String, Collection<?>> inputMap = new HashMap<String, Collection<?>>();

        inputMap.put("Tid", new ArrayList<>(Arrays.asList(2012, null)));

        String query = QueryBuilder.build(inputMap);

        assertEquals(
                "{\"query\": [{\"code\": \"Tid\", \"selection\": {\"filter\": \"item\", \"values\": [\"2012\"]}}],\"response\": {\"format\": \"json\"}}",
                query);
    }

    @Test
    public void filterValueRemoveEmptyList() {
        Map<String, Collection<?>> inputMap = new HashMap<String, Collection<?>>();
        inputMap.put("Tid", Collections.EMPTY_LIST);

        String query = QueryBuilder.build(inputMap);

        assertEquals("{\"query\": [],\"response\": {\"format\": \"json\"}}", query);
    }

}
