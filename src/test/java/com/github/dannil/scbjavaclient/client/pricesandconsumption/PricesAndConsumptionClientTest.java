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

package com.github.dannil.scbjavaclient.client.pricesandconsumption;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.pricesandconsumption.bpi.PricesAndConsumptionBPIClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.cci.PricesAndConsumptionCCIClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.PricesAndConsumptionPPIClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.purchasingpowerparities.PricesAndConsumptionPurchasingPowerParitiesClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PricesAndConsumptionClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        PricesAndConsumptionClient client = new PricesAndConsumptionClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void bpi() {
        PricesAndConsumptionClient client = new PricesAndConsumptionClient();

        assertEquals(client.bpi().getClass(), PricesAndConsumptionBPIClient.class);
    }

    @Test
    public void cci() {
        PricesAndConsumptionClient client = new PricesAndConsumptionClient();

        assertEquals(client.cci().getClass(), PricesAndConsumptionCCIClient.class);
    }

    @Test
    public void ppi() {
        PricesAndConsumptionClient client = new PricesAndConsumptionClient();

        assertEquals(client.ppi().getClass(), PricesAndConsumptionPPIClient.class);
    }

    @Test
    public void purchasingPowerParities() {
        PricesAndConsumptionClient client = new PricesAndConsumptionClient();

        assertEquals(client.purchasingPowerParities().getClass(),
                PricesAndConsumptionPurchasingPowerParitiesClient.class);
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        PricesAndConsumptionClient client = new PricesAndConsumptionClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("PR/"), client.getUrl());
    }

}
