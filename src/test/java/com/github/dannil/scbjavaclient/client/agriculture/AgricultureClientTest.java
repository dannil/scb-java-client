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

package com.github.dannil.scbjavaclient.client.agriculture;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.client.agriculture.cerealcrops.AgricultureCerealCropsClient;
import com.github.dannil.scbjavaclient.client.agriculture.holdings.AgricultureHoldingsClient;
import com.github.dannil.scbjavaclient.client.agriculture.landuse.AgricultureLandUseClient;
import com.github.dannil.scbjavaclient.client.agriculture.livestock.AgricultureLivestockClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class AgricultureClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        AgricultureClient client = new AgricultureClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void cerealCropsClient() {
        AgricultureClient client = new AgricultureClient();

        assertEquals(client.cerealCrops().getClass(), AgricultureCerealCropsClient.class);
    }

    @Test
    public void holdingsClient() {
        AgricultureClient client = new AgricultureClient();

        assertEquals(client.holdings().getClass(), AgricultureHoldingsClient.class);
    }

    @Test
    public void landUseClient() {
        AgricultureClient client = new AgricultureClient();

        assertEquals(client.landUse().getClass(), AgricultureLandUseClient.class);
    }

    @Test
    public void livestockClient() {
        AgricultureClient client = new AgricultureClient();

        assertEquals(client.livestock().getClass(), AgricultureLivestockClient.class);
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        AgricultureClient client = new AgricultureClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("JO/"), client.getUrl());
    }

}
