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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JsonAPIConfigTableFormatTest {

    private String json;

    private JsonAPIConfigTableFormat format;

    @Before
    public void setup() {

        this.json = "{\"maxValues\": 100000,\"maxCalls\": 30,\"timeWindow\": 10,\"CORS\": true}";
        this.format = new JsonAPIConfigTableFormat(this.json);
    }

    @Test
    public void getInputs() {
        Map<String, Collection<String>> extractedInputs = this.format.getInputs();

        Map<String, Collection<String>> staticInputs = new HashMap<String, Collection<String>>();
        staticInputs.put("maxValues", Arrays.asList("100000"));
        staticInputs.put("maxCalls", Arrays.asList("30"));
        staticInputs.put("timeWindow", Arrays.asList("10"));
        staticInputs.put("CORS", Arrays.asList("true"));

        for (Entry<String, Collection<String>> entry : extractedInputs.entrySet()) {
            String key = entry.getKey();
            Collection<String> value = entry.getValue();

            assertTrue(staticInputs.get(key).containsAll(value));
        }
        for (Entry<String, Collection<String>> entry : staticInputs.entrySet()) {
            String key = entry.getKey();
            Collection<String> value = entry.getValue();

            assertTrue(extractedInputs.get(key).containsAll(value));
        }
    }

    @Test
    public void getInputsReturnCache() {
        Map<String, Collection<String>> extractedInputs = this.format.getInputs();

        // A second call to getInputs() triggers the return of the cache
        extractedInputs = this.format.getInputs();

        Map<String, Collection<String>> staticInputs = new HashMap<String, Collection<String>>();
        staticInputs.put("maxValues", Arrays.asList("100000"));
        staticInputs.put("maxCalls", Arrays.asList("30"));
        staticInputs.put("timeWindow", Arrays.asList("10"));
        staticInputs.put("CORS", Arrays.asList("true"));

        for (Entry<String, Collection<String>> entry : extractedInputs.entrySet()) {
            String key = entry.getKey();
            Collection<String> value = entry.getValue();

            assertTrue(staticInputs.get(key).containsAll(value));
        }
        for (Entry<String, Collection<String>> entry : staticInputs.entrySet()) {
            String key = entry.getKey();
            Collection<String> value = entry.getValue();

            assertTrue(extractedInputs.get(key).containsAll(value));
        }
    }

    @Test
    public void getCodes() {
        List<String> extractedCodes = this.format.getCodes();
        List<String> staticCodes = Arrays.asList("maxValues", "maxCalls", "timeWindow", "CORS");

        assertTrue(extractedCodes.containsAll(staticCodes));
        assertTrue(staticCodes.containsAll(extractedCodes));
    }

    @Test
    public void getCodesEmpty() {
        String json = "{}";

        JsonAPIConfigTableFormat format = new JsonAPIConfigTableFormat(json);
        List<String> codes = format.getCodes();

        assertEquals(0, codes.size());
    }

    @Test
    public void getValues() {
        List<String> extractedCodes = this.format.getCodes();

        Map<String, Collection<String>> staticInputs = new HashMap<String, Collection<String>>();
        staticInputs.put("maxValues", Arrays.asList("100000"));
        staticInputs.put("maxCalls", Arrays.asList("30"));
        staticInputs.put("timeWindow", Arrays.asList("10"));
        staticInputs.put("CORS", Arrays.asList("true"));

        for (String code : extractedCodes) {
            List<String> extractedValues = this.format.getValues(code);

            assertTrue(staticInputs.get(code).containsAll(extractedValues));
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
        toString = expected.replace(" ", "");

        assertEquals(expected, toString);
    }

}
