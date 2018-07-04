/*
 * Copyright 2017 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.format.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class JsonAPIConfigTableFormatTest {

    private String json;

    private JsonAPIConfigTableFormat format;

    @BeforeEach
    public void setup() {
        this.json = "{\"maxValues\": 100000,\"maxCalls\": 30,\"timeWindow\": 10,\"CORS\": true}";
        this.format = new JsonAPIConfigTableFormat(this.json);
    }

    @Test
    public void getPairs() {
        Map<String, Collection<String>> extractedPairs = this.format.getPairs();

        Map<String, Collection<String>> staticPairs = new HashMap<String, Collection<String>>();
        staticPairs.put("maxValues", Arrays.asList("100000"));
        staticPairs.put("maxCalls", Arrays.asList("30"));
        staticPairs.put("timeWindow", Arrays.asList("10"));
        staticPairs.put("CORS", Arrays.asList("true"));

        for (Entry<String, Collection<String>> entry : extractedPairs.entrySet()) {
            String key = entry.getKey();
            Collection<String> value = entry.getValue();
            assertTrue(staticPairs.get(key).containsAll(value));
        }
        for (Entry<String, Collection<String>> entry : staticPairs.entrySet()) {
            String key = entry.getKey();
            Collection<String> value = entry.getValue();
            assertTrue(extractedPairs.get(key).containsAll(value));
        }
    }

    @Test
    public void getPairsReturnCache() {
        Map<String, Collection<String>> extractedPairs = this.format.getPairs();

        // A second call to getPairs() triggers the return of the cache
        extractedPairs = this.format.getPairs();

        Map<String, Collection<String>> staticPairs = new HashMap<String, Collection<String>>();
        staticPairs.put("maxValues", Arrays.asList("100000"));
        staticPairs.put("maxCalls", Arrays.asList("30"));
        staticPairs.put("timeWindow", Arrays.asList("10"));
        staticPairs.put("CORS", Arrays.asList("true"));

        for (Entry<String, Collection<String>> entry : extractedPairs.entrySet()) {
            String key = entry.getKey();
            Collection<String> value = entry.getValue();
            assertTrue(staticPairs.get(key).containsAll(value));
        }
        for (Entry<String, Collection<String>> entry : staticPairs.entrySet()) {
            String key = entry.getKey();
            Collection<String> value = entry.getValue();
            assertTrue(extractedPairs.get(key).containsAll(value));
        }
    }

    @Test
    public void getKeys() {
        List<String> extractedKeys = this.format.getKeys();
        List<String> staticKeys = Arrays.asList("maxValues", "maxCalls", "timeWindow", "CORS");

        assertTrue(extractedKeys.containsAll(staticKeys));
        assertTrue(staticKeys.containsAll(extractedKeys));
    }

    @Test
    public void getKeysEmpty() {
        String json = "{}";

        JsonAPIConfigTableFormat format = new JsonAPIConfigTableFormat(json);
        List<String> keys = format.getKeys();

        assertEquals(0, keys.size());
    }

    @Test
    public void getValues() {
        List<String> extractedKeys = this.format.getKeys();

        Map<String, Collection<String>> staticPairs = new HashMap<String, Collection<String>>();
        staticPairs.put("maxValues", Arrays.asList("100000"));
        staticPairs.put("maxCalls", Arrays.asList("30"));
        staticPairs.put("timeWindow", Arrays.asList("10"));
        staticPairs.put("CORS", Arrays.asList("true"));

        for (String key : extractedKeys) {
            List<String> extractedValues = this.format.getValues(key);
            assertTrue(staticPairs.get(key).containsAll(extractedValues));
        }
    }

    @Test
    public void getValuesEmptyForCode() {
        List<String> values = this.format.getValues("THIS_CODE_DOES_NOT_EXIST_HOPEFULLY");

        assertEquals(0, values.size());
    }

    @Test
    public void toStringEquals() {
        String expected = this.json;
        String toString = this.format.toString();

        // Remove whitespace for easier comparison; JSON is still valid
        expected = expected.replace(" ", "");
        toString = toString.replace(" ", "");

        assertEquals(expected, toString);
    }

}
