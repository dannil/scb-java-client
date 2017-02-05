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
public class JsonAPITableFormatTest {

    private String json;

    private JsonAPITableFormat format;

    @Before
    public void setup() {
        this.json = "{\"title\":\"Folkmängdenefterregion,civilstånd,ålder,kön,tabellinnehållochår\",\"variables\":[{\"code\":\"Region\",\"text\":\"region\",\"values\":[\"00\",\"01\",\"0114\"],\"valueTexts\":[\"Riket\",\"Stockholmslän\",\"UpplandsVäsby\"]},{\"code\":\"Civilstand\",\"text\":\"civilstånd\",\"values\":[\"OG\",\"G\",\"SK\",\"ÄNKL\"],\"valueTexts\":[\"ogifta\",\"gifta\",\"skilda\",\"änkor/änklingar\"],\"elimination\":true},{\"code\":\"Alder\",\"text\":\"ålder\",\"values\":[\"0\",\"1\"],\"valueTexts\":[\"0år\",\"1år\"],\"elimination\":true},{\"code\":\"Kon\",\"text\":\"kön\",\"values\":[\"1\",\"2\"],\"valueTexts\":[\"män\",\"kvinnor\"],\"elimination\":true},{\"code\":\"ContentsCode\",\"text\":\"tabellinnehåll\",\"values\":[\"BE0101N1\",\"BE0101N2\"],\"valueTexts\":[\"Folkmängd\",\"Folkökning\"]},{\"code\":\"Tid\",\"text\":\"år\",\"values\":[\"1968\",\"1969\"],\"valueTexts\":[\"1968\",\"1969\"],\"time\":true}]}";
        this.format = new JsonAPITableFormat(this.json);
    }

    @Test
    public void getInputs() {
        Map<String, Collection<String>> extractedInputs = this.format.getInputs();

        Map<String, Collection<String>> staticInputs = new HashMap<String, Collection<String>>();
        staticInputs.put("Region", Arrays.asList("00", "01", "0114"));
        staticInputs.put("Civilstand", Arrays.asList("OG", "G", "SK", "ÄNKL"));
        staticInputs.put("Alder", Arrays.asList("0", "1"));
        staticInputs.put("Kon", Arrays.asList("1", "2"));
        staticInputs.put("ContentsCode", Arrays.asList("BE0101N1", "BE0101N2"));
        staticInputs.put("Tid", Arrays.asList("1968", "1969"));

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
        staticInputs.put("Region", Arrays.asList("00", "01", "0114"));
        staticInputs.put("Civilstand", Arrays.asList("OG", "G", "SK", "ÄNKL"));
        staticInputs.put("Alder", Arrays.asList("0", "1"));
        staticInputs.put("Kon", Arrays.asList("1", "2"));
        staticInputs.put("ContentsCode", Arrays.asList("BE0101N1", "BE0101N2"));
        staticInputs.put("Tid", Arrays.asList("1968", "1969"));

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
        List<String> staticCodes = Arrays.asList("Region", "Civilstand", "Alder", "Kon", "ContentsCode", "Tid");

        assertTrue(extractedCodes.containsAll(staticCodes));
        assertTrue(staticCodes.containsAll(extractedCodes));
    }

    @Test
    public void getCodesEmpty() {
        String json = "{\"title\":\"Folkmängdenefterregion,civilstånd,ålder,kön,tabellinnehållochår\",\"variables\":[]}";

        JsonAPITableFormat format = new JsonAPITableFormat(json);
        List<String> codes = format.getCodes();

        assertEquals(0, codes.size());
    }

    @Test
    public void getValues() {
        List<String> extractedCodes = this.format.getCodes();

        Map<String, Collection<String>> staticInputs = new HashMap<String, Collection<String>>();
        staticInputs.put("Region", Arrays.asList("00", "01", "0114"));
        staticInputs.put("Civilstand", Arrays.asList("OG", "G", "SK", "ÄNKL"));
        staticInputs.put("Alder", Arrays.asList("0", "1"));
        staticInputs.put("Kon", Arrays.asList("1", "2"));
        staticInputs.put("ContentsCode", Arrays.asList("BE0101N1", "BE0101N2"));
        staticInputs.put("Tid", Arrays.asList("1968", "1969"));

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
