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

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbjavaclient.client.environment.emissions.EnvironmentEmissionsClient;
import com.github.dannil.scbjavaclient.client.environment.greenhousegas.EnvironmentGreenhouseGasClient;
import com.github.dannil.scbjavaclient.client.environment.industrialwateruse.EnvironmentIndustrialWaterUseClient;
import com.github.dannil.scbjavaclient.client.environment.landandwaterarea.EnvironmentLandAndWaterAreaClient;
import com.github.dannil.scbjavaclient.client.environment.landuse.EnvironmentLandUseClient;
import com.github.dannil.scbjavaclient.client.environment.landusedfortransport.EnvironmentLandUsedForTransportClient;
import com.github.dannil.scbjavaclient.client.environment.packagingandpackagingwaste.EnvironmentPackagingAndPackagingWasteClient;
import com.github.dannil.scbjavaclient.client.environment.protectednature.EnvironmentProtectedNatureClient;
import com.github.dannil.scbjavaclient.client.environment.smallerlocalities.EnvironmentSmallerLocalitiesClient;
import com.github.dannil.scbjavaclient.client.environment.waste.EnvironmentWasteClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

@RunWith(JUnit4.class)
public class EnvironmentClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        EnvironmentClient client = new EnvironmentClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void emissionsClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(client.emissions().getClass(), EnvironmentEmissionsClient.class);
    }

    @Test
    public void greenhouseGasClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(client.greenhouseGas().getClass(), EnvironmentGreenhouseGasClient.class);
    }

    @Test
    public void industrialWaterUseClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(client.industrialWaterUse().getClass(), EnvironmentIndustrialWaterUseClient.class);
    }

    @Test
    public void landAndWaterAreaClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(client.landAndWaterArea().getClass(), EnvironmentLandAndWaterAreaClient.class);
    }

    @Test
    public void landUseClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(client.landUse().getClass(), EnvironmentLandUseClient.class);
    }

    @Test
    public void landUsedForTransportClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(client.landUsedForTransport().getClass(), EnvironmentLandUsedForTransportClient.class);
    }

    @Test
    public void packagingAndPackagingWasteClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(client.packagingAndPackagingWaste().getClass(), EnvironmentPackagingAndPackagingWasteClient.class);
    }

    @Test
    public void protectedNatureClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(client.protectedNature().getClass(), EnvironmentProtectedNatureClient.class);
    }

    @Test
    public void smallerLocalitiesClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(client.smallerLocalities().getClass(), EnvironmentSmallerLocalitiesClient.class);
    }

    @Test
    public void wasteClient() {
        EnvironmentClient client = new EnvironmentClient();

        assertEquals(client.waste().getClass(), EnvironmentWasteClient.class);
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
