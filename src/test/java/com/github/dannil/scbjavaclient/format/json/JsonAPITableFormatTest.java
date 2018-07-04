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
public class JsonAPITableFormatTest {

    private String json;

    private JsonAPITableFormat format;

    @BeforeEach
    public void setup() {
        this.json = "{\"title\":\"Folkmängdenefterregion,civilstånd,ålder,kön,tabellinnehållochår\",\"variables\":[{\"code\":\"Region\",\"text\":\"region\",\"values\":[\"00\",\"01\",\"0114\"],\"valueTexts\":[\"Riket\",\"Stockholmslän\",\"UpplandsVäsby\"]},{\"code\":\"Civilstand\",\"text\":\"civilstånd\",\"values\":[\"OG\",\"G\",\"SK\",\"ÄNKL\"],\"valueTexts\":[\"ogifta\",\"gifta\",\"skilda\",\"änkor/änklingar\"],\"elimination\":true},{\"code\":\"Alder\",\"text\":\"ålder\",\"values\":[\"0\",\"1\"],\"valueTexts\":[\"0år\",\"1år\"],\"elimination\":true},{\"code\":\"Kon\",\"text\":\"kön\",\"values\":[\"1\",\"2\"],\"valueTexts\":[\"män\",\"kvinnor\"],\"elimination\":true},{\"code\":\"ContentsCode\",\"text\":\"tabellinnehåll\",\"values\":[\"BE0101N1\",\"BE0101N2\"],\"valueTexts\":[\"Folkmängd\",\"Folkökning\"]},{\"code\":\"Tid\",\"text\":\"år\",\"values\":[\"1968\",\"1969\"],\"valueTexts\":[\"1968\",\"1969\"],\"time\":true}]}";
        this.format = new JsonAPITableFormat(this.json);
    }

    @Test
    public void getPairs() {
        Map<String, Collection<String>> extractedPairs = this.format.getPairs();

        Map<String, Collection<String>> staticPairs = new HashMap<String, Collection<String>>();
        staticPairs.put("Region", Arrays.asList("00", "01", "0114"));
        staticPairs.put("Civilstand", Arrays.asList("OG", "G", "SK", "ÄNKL"));
        staticPairs.put("Alder", Arrays.asList("0", "1"));
        staticPairs.put("Kon", Arrays.asList("1", "2"));
        staticPairs.put("ContentsCode", Arrays.asList("BE0101N1", "BE0101N2"));
        staticPairs.put("Tid", Arrays.asList("1968", "1969"));

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
        staticPairs.put("Region", Arrays.asList("00", "01", "0114"));
        staticPairs.put("Civilstand", Arrays.asList("OG", "G", "SK", "ÄNKL"));
        staticPairs.put("Alder", Arrays.asList("0", "1"));
        staticPairs.put("Kon", Arrays.asList("1", "2"));
        staticPairs.put("ContentsCode", Arrays.asList("BE0101N1", "BE0101N2"));
        staticPairs.put("Tid", Arrays.asList("1968", "1969"));

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
        List<String> staticKeys = Arrays.asList("Region", "Civilstand", "Alder", "Kon", "ContentsCode", "Tid");

        assertTrue(extractedKeys.containsAll(staticKeys));
        assertTrue(staticKeys.containsAll(extractedKeys));
    }

    @Test
    public void getPairsNoVariables() {
        String json = "{\"title\":\"Folkmängdenefterregion,civilstånd,ålder,kön,tabellinnehållochår\"}";

        JsonAPITableFormat format = new JsonAPITableFormat(json);
        Map<String, Collection<String>> expected = new HashMap<String, Collection<String>>();

        assertEquals(expected, format.getPairs());
    }

    @Test
    public void getPairsEmpty() {
        String json = "{\"title\":\"Folkmängdenefterregion,civilstånd,ålder,kön,tabellinnehållochår\",\"variables\":[]}";

        JsonAPITableFormat format = new JsonAPITableFormat(json);
        List<String> keys = format.getKeys();

        assertEquals(0, keys.size());
    }

    @Test
    public void getValues() {
        List<String> extractedKeys = this.format.getKeys();

        Map<String, Collection<String>> staticPairs = new HashMap<String, Collection<String>>();
        staticPairs.put("Region", Arrays.asList("00", "01", "0114"));
        staticPairs.put("Civilstand", Arrays.asList("OG", "G", "SK", "ÄNKL"));
        staticPairs.put("Alder", Arrays.asList("0", "1"));
        staticPairs.put("Kon", Arrays.asList("1", "2"));
        staticPairs.put("ContentsCode", Arrays.asList("BE0101N1", "BE0101N2"));
        staticPairs.put("Tid", Arrays.asList("1968", "1969"));

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
