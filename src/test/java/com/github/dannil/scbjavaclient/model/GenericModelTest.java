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

package com.github.dannil.scbjavaclient.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class GenericModelTest {

    private String json;

    @BeforeEach
    public void setup() {
        this.json = "{\"columns\":[{\"code\":\"Region\",\"text\":\"region\",\"type\":\"d\"},{\"code\":\"Civilstand\",\"text\":\"civilst\u00E5nd\",\"type\":\"d\"},{\"code\":\"Alder\",\"text\":\"\u00E5lder\",\"type\":\"d\"},{\"code\":\"Tid\",\"text\":\"\u00E5r\",\"type\":\"t\"},{\"code\":\"BE0101N1\",\"text\":\"Folkm\u00E4ngd\",\"type\":\"c\"}],\"comments\":[],\"data\":[{\"key\":[\"00\",\"OG\",\"45\",\"2011\"],\"values\":[\"48403\"]},{\"key\":[\"00\",\"OG\",\"45\",\"2012\"],\"values\":[\"47619\"]},{\"key\":[\"00\",\"OG\",\"50\",\"2011\"],\"values\":[\"34868\"]},{\"key\":[\"00\",\"OG\",\"50\",\"2012\"],\"values\":[\"36454\"]},{\"key\":[\"00\",\"G\",\"45\",\"2011\"],\"values\":[\"68640\"]},{\"key\":[\"00\",\"G\",\"45\",\"2012\"],\"values\":[\"69184\"]},{\"key\":[\"00\",\"G\",\"50\",\"2011\"],\"values\":[\"60262\"]},{\"key\":[\"00\",\"G\",\"50\",\"2012\"],\"values\":[\"61902\"]},{\"key\":[\"01\",\"OG\",\"45\",\"2011\"],\"values\":[\"10833\"]},{\"key\":[\"01\",\"OG\",\"45\",\"2012\"],\"values\":[\"10339\"]},{\"key\":[\"01\",\"OG\",\"50\",\"2011\"],\"values\":[\"7893\"]},{\"key\":[\"01\",\"OG\",\"50\",\"2012\"],\"values\":[\"8255\"]},{\"key\":[\"01\",\"G\",\"45\",\"2011\"],\"values\":[\"16031\"]},{\"key\":[\"01\",\"G\",\"45\",\"2012\"],\"values\":[\"16121\"]},{\"key\":[\"01\",\"G\",\"50\",\"2011\"],\"values\":[\"13103\"]},{\"key\":[\"01\",\"G\",\"50\",\"2012\"],\"values\":[\"13966\"]},{\"key\":[\"0114\",\"OG\",\"45\",\"2011\"],\"values\":[\"227\"]},{\"key\":[\"0114\",\"OG\",\"45\",\"2012\"],\"values\":[\"202\"]},{\"key\":[\"0114\",\"OG\",\"50\",\"2011\"],\"values\":[\"127\"]},{\"key\":[\"0114\",\"OG\",\"50\",\"2012\"],\"values\":[\"139\"]},{\"key\":[\"0114\",\"G\",\"45\",\"2011\"],\"values\":[\"344\"]},{\"key\":[\"0114\",\"G\",\"45\",\"2012\"],\"values\":[\"326\"]},{\"key\":[\"0114\",\"G\",\"50\",\"2011\"],\"values\":[\"265\"]},{\"key\":[\"0114\",\"G\",\"50\",\"2012\"],\"values\":[\"266\"]}]}";
    }

    @Test
    public void getEntries() {
        GenericModel model = new GenericModel(this.json);

        Collection<Map<String, Object>> entries = model.getEntries();
        assertNotEquals(0, entries.size());

        for (Map<String, Object> entry : entries) {
            String toString = entry.toString();

            assertTrue(toString.contains("Region"));
            assertTrue(toString.contains("Civilstand"));
            assertTrue(toString.contains("Alder"));
            assertTrue(toString.contains("Tid"));
        }
    }

    @Test
    public void getEntriesFiltered() {
        GenericModel model = new GenericModel(this.json);

        Map<String, Collection<String>> inputs = new HashMap<>();
        inputs.put("Region", Arrays.asList("01", "0114"));
        inputs.put("Alder", Arrays.asList("50"));

        Collection<Map<String, Object>> entries = model.getEntries(inputs);
        assertNotEquals(0, entries.size());

        for (Map<String, Object> entry : entries) {
            String toString = entry.toString();

            assertTrue(toString.contains("Region"));
            assertTrue(toString.contains("01") || toString.contains("0114"));
            assertTrue(toString.contains("Alder"));
            assertTrue(toString.contains("50"));
            assertTrue(toString.contains("Civilstand"));
            assertTrue(toString.contains("Tid"));
        }
    }

    @Test
    public void getEntriesEmptyInputs() {
        GenericModel model = new GenericModel(this.json);
        Map<String, Collection<String>> inputs = new HashMap<>();

        Collection<Map<String, Object>> entries = model.getEntries(inputs);
        assertNotEquals(0, entries.size());

        for (Map<String, Object> entry : entries) {
            String toString = entry.toString();

            assertTrue(toString.contains("Region"));
            assertTrue(toString.contains("01") || toString.contains("0114"));
            assertTrue(toString.contains("Alder"));
            assertTrue(toString.contains("45") || toString.contains("50"));
            assertTrue(toString.contains("Civilstand"));
            assertTrue(toString.contains("Tid"));
        }
    }

    @Test
    public void getEntriesKeyAndValue() {
        GenericModel model = new GenericModel(this.json);

        Collection<Map<String, Object>> entries = model.getEntries("Civilstand", "OG");
        assertNotEquals(0, entries.size());

        for (Map<String, Object> entry : entries) {
            String toString = entry.toString();

            assertTrue(toString.contains("Civilstand"));
            assertTrue(toString.contains("OG"));
            assertTrue(toString.contains("Region"));
            assertTrue(toString.contains("Alder"));
            assertTrue(toString.contains("Tid"));
        }
    }

    @Test
    public void getEntriesNonExistingKey() {
        GenericModel model = new GenericModel(this.json);

        Map<String, Collection<String>> inputs = new HashMap<>();
        inputs.put("TESTKEY1", Arrays.asList("-199", "-200"));
        inputs.put("TESTKEY2", Arrays.asList("-199"));

        Collection<Map<String, Object>> entries = model.getEntries(inputs);
        assertEquals(0, entries.size());
    }

    @Test
    public void getEntriesNonExistingValueForKey() {
        GenericModel model = new GenericModel(this.json);

        Map<String, Collection<String>> inputs = new HashMap<>();
        inputs.put("Region", Arrays.asList("-1", "-2"));
        inputs.put("Alder", Arrays.asList("-1"));

        Collection<Map<String, Object>> entries = model.getEntries(inputs);
        assertEquals(0, entries.size());
    }

    @Test
    public void toStringNotEmpty() {
        GenericModel model = new GenericModel(this.json);
        String toString = model.toString();

        assertTrue(toString.contains("Region"));
        assertTrue(toString.contains("00"));
        assertTrue(toString.contains("01"));
        assertTrue(toString.contains("0114"));

        assertTrue(toString.contains("Civilstand"));
        assertTrue(toString.contains("G"));
        assertTrue(toString.contains("OG"));

        assertTrue(toString.contains("Alder"));
        assertTrue(toString.contains("45"));
        assertTrue(toString.contains("50"));

        assertTrue(toString.contains("Tid"));
        assertTrue(toString.contains("2011"));
        assertTrue(toString.contains("2012"));
    }

}
