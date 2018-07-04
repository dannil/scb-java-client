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

package com.github.dannil.scbjavaclient.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
@Remote
public class SCBClientIT {

    @Test
    @Date("2017-01-01")
    public void getInputs() {
        Locale locale = new Locale("sv", "SE");
        SCBClient client = new SCBClient(locale);

        Map<String, Collection<String>> inputs = client.getInputs("UF/UF0104/SamAntSkol");

        Map<String, Collection<String>> staticInputs = new HashMap<String, Collection<String>>();
        Collection<String> staticInputsArsKurs = Arrays.asList("10", "11", "12", "13", "14", "15", "16");
        Collection<String> staticInputsContentsCode = Arrays.asList("UF0104L1");
        Collection<String> staticInputsTid = Arrays.asList("1997", "1998", "1999", "2000", "2001", "2002", "2003",
                "2004", "2005", "2006");

        staticInputs.put("ArsKurs", staticInputsArsKurs);
        staticInputs.put("ContentsCode", staticInputsContentsCode);
        staticInputs.put("Tid", staticInputsTid);

        assertEquals(staticInputs, inputs);
    }
    
    @Test
    @Date("2018-06-26")
    public void getInputsNonExistingTable() {
        Locale locale = new Locale("sv", "SE");
        SCBClient client = new SCBClient(locale);
        
        Map<String, Collection<String>> inputs = client.getInputs("ABC/ABC/ABC");
        
        assertNotNull(inputs);
        assertTrue(inputs.isEmpty());
    }

    @Test
    @Date("2017-01-01")
    public void getRawData() {
        Locale locale = new Locale("sv", "SE");
        SCBClient client = new SCBClient(locale);

        String response = client.getRawData("BE/BE0101/BE0101A/BefolkningNy");

        assertTrue(response.contains("BE0101N1"));
        assertTrue(response.contains("BE0101N2"));
        assertTrue(response.contains("Tid"));
        assertFalse(response.contains("Region"));
        assertFalse(response.contains("Civilstand"));
        assertFalse(response.contains("Alder"));
        assertFalse(response.contains("Kon"));
    }

    @Test
    @Date("2017-01-01")
    public void getRawDataWithInputs() {
        Locale locale = new Locale("sv", "SE");
        SCBClient client = new SCBClient(locale);

        Map<String, Collection<?>> payload = new HashMap<String, Collection<?>>();
        payload.put("Region", Arrays.asList("00", "01", "0114"));
        payload.put("Civilstand", Arrays.asList("OG", "G"));
        payload.put("Alder", Arrays.asList(45, 50));
        payload.put("Tid", Arrays.asList(2011, 2012));

        String response = client.getRawData("BE/BE0101/BE0101A/BefolkningNy", payload);

        assertTrue(response.contains("Region"));
        assertTrue(response.contains("Civilstand"));
        assertTrue(response.contains("Alder"));
        assertTrue(response.contains("Tid"));
    }

    @Test
    @Date("2017-01-01")
    public void getConfig() {
        Locale locale = new Locale("sv", "SE");
        SCBClient client = new SCBClient(locale);

        Map<String, String> config = client.getConfig();
        assertFalse(config.isEmpty());
        for (Entry<String, String> entry : config.entrySet()) {
            assertNotNull(entry.getKey());
            assertNotNull(entry.getValue());
        }
    }

    @Test
    @Date("2017-01-01")
    public void getRegions() {
        SCBClient client = new SCBClient();

        List<String> regions = client.getRegions("BE/BE0101/BE0101A/BefolkningNy");

        assertNotNull(regions);
        assertFalse(regions.isEmpty());
    }

    @Test
    @Date("2017-08-19")
    public void getRegionsMissingCodeInTable() {
        SCBClient client = new SCBClient();

        List<String> regions = client.getRegions("BE/BE0001/BE0001D/BE0001T04Ar");

        assertNotNull(regions);
        assertTrue(regions.isEmpty());
    }
    
    @Test
    @Date("2018-06-26")
    public void getRegionsNonExistingTable() {
        Locale locale = new Locale("sv", "SE");
        SCBClient client = new SCBClient(locale);
        
        List<String> regions = client.getRegions("ABC/ABC/ABC");
        
        assertNotNull(regions);
        assertTrue(regions.isEmpty());
    }

    @Test
    @Date("2017-01-01")
    public void getTimes() {
        SCBClient client = new SCBClient();

        List<String> times = client.getTimes("BE/BE0101/BE0101A/BefolkningNy");

        assertNotNull(times);
        assertFalse(times.isEmpty());
    }

    @Test
    @Date("2017-01-01")
    public void getTimesMissingCodeInTable() {
        SCBClient client = new SCBClient();

        List<String> times = client.getTimes("NR/NR0105/NR0105A");

        assertNotNull(times);
        assertTrue(times.isEmpty());
    }
    
    @Test
    @Date("2018-06-26")
    public void getTimesNonExistingTable() {
        Locale locale = new Locale("sv", "SE");
        SCBClient client = new SCBClient(locale);
        
        List<String> times = client.getTimes("ABC/ABC/ABC");
        
        assertNotNull(times);
        assertTrue(times.isEmpty());
    }

    @Test
    @Date("2018-01-01")
    public void supportedLanguage() {
        String language = "sv";

        assertTrue(SCBClient.isSupportedLanguage(language));
    }

    @Test
    @Date("2018-01-01")
    public void unsupportedLanguage() {
        String language = "fr";

        assertFalse(SCBClient.isSupportedLanguage(language));
    }

    @Test
    @Date("2017-01-01")
    public void supportedLocale() {
        Locale locale = new Locale("sv", "SE");

        assertTrue(SCBClient.isSupportedLocale(locale));
    }

    @Test
    @Date("2017-01-01")
    public void unsupportedLocale() {
        Locale locale = new Locale("fr", "CA");

        assertFalse(SCBClient.isSupportedLocale(locale));
    }

}
