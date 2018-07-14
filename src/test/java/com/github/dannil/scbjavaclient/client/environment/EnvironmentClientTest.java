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

package com.github.dannil.scbjavaclient.client.environment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.client.environment.airpollutants.EnvironmentAirPollutantsClient;
import com.github.dannil.scbjavaclient.client.environment.greenhousegas.EnvironmentGreenhouseGasClient;
import com.github.dannil.scbjavaclient.client.environment.islands.EnvironmentIslandsClient;
import com.github.dannil.scbjavaclient.client.environment.landandwaterarea.EnvironmentLandAndWaterAreaClient;
import com.github.dannil.scbjavaclient.client.environment.landuse.EnvironmentLandUseClient;
import com.github.dannil.scbjavaclient.client.environment.landusedfortransport.EnvironmentLandUsedForTransportClient;
import com.github.dannil.scbjavaclient.client.environment.packagingandpackagingwaste.EnvironmentPackagingAndPackagingWasteClient;
import com.github.dannil.scbjavaclient.client.environment.protectednature.EnvironmentProtectedNatureClient;
import com.github.dannil.scbjavaclient.client.environment.seea.EnvironmentSEEAClient;
import com.github.dannil.scbjavaclient.client.environment.smallerlocalities.EnvironmentSmallerLocalitiesClient;
import com.github.dannil.scbjavaclient.client.environment.waste.EnvironmentWasteClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class EnvironmentClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        EnvironmentClient client = new EnvironmentClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void airPollutantsClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(EnvironmentAirPollutantsClient.class, client.airPollutants().getClass());
    }

    @Test
    public void greenhouseGasClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(EnvironmentGreenhouseGasClient.class, client.greenhouseGas().getClass());
    }

    @Test
    public void islandsClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(EnvironmentIslandsClient.class, client.islands().getClass());
    }

    @Test
    public void landAndWaterAreaClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(EnvironmentLandAndWaterAreaClient.class, client.landAndWaterArea().getClass());
    }

    @Test
    public void landUseClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(EnvironmentLandUseClient.class, client.landUse().getClass());
    }

    @Test
    public void landUsedForTransportClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(EnvironmentLandUsedForTransportClient.class, client.landUsedForTransport().getClass());
    }

    @Test
    public void packagingAndPackagingWasteClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(EnvironmentPackagingAndPackagingWasteClient.class, client.packagingAndPackagingWaste().getClass());
    }

    @Test
    public void protectedNatureClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(EnvironmentProtectedNatureClient.class, client.protectedNature().getClass());
    }

    @Test
    public void seeaClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(EnvironmentSEEAClient.class, client.seea().getClass());
    }

    @Test
    public void smallerLocalitiesClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(EnvironmentSmallerLocalitiesClient.class, client.smallerLocalities().getClass());
    }

    @Test
    public void wasteClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(EnvironmentWasteClient.class, client.waste().getClass());
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        EnvironmentClient client = new EnvironmentClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("MI/"), client.getUrl());
    }

}
