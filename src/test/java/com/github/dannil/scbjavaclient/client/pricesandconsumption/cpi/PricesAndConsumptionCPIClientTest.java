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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.cpifct.PricesAndConsumptionCPICPIFCTClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.economicindicators.PricesAndConsumptionCPIEconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.hicp.PricesAndConsumptionCPIHICPClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.kpif.PricesAndConsumptionCPIKPIFClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.pricebasicamount.PricesAndConsumptionCPIPriceBasicAmountClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class PricesAndConsumptionCPIClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        PricesAndConsumptionCPIClient client = new PricesAndConsumptionCPIClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void cpifct() {
        PricesAndConsumptionCPIClient client = new PricesAndConsumptionCPIClient();

        assertEquals(PricesAndConsumptionCPICPIFCTClient.class, client.cpifct().getClass());
    }

    @Test
    public void economicIndicators() {
        PricesAndConsumptionCPIClient client = new PricesAndConsumptionCPIClient();

        assertEquals(PricesAndConsumptionCPIEconomicIndicatorsClient.class, client.economicIndicators().getClass());
    }

    @Test
    public void hicp() {
        PricesAndConsumptionCPIClient client = new PricesAndConsumptionCPIClient();

        assertEquals(PricesAndConsumptionCPIHICPClient.class, client.hicp().getClass());
    }

    @Test
    public void priceBasicAmount() {
        PricesAndConsumptionCPIClient client = new PricesAndConsumptionCPIClient();

        assertEquals(PricesAndConsumptionCPIPriceBasicAmountClient.class, client.priceBasicAmount().getClass());
    }

    @Test
    public void kpif() {
        PricesAndConsumptionCPIClient client = new PricesAndConsumptionCPIClient();

        assertEquals(PricesAndConsumptionCPIKPIFClient.class, client.kpif().getClass());
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        PricesAndConsumptionCPIClient client = new PricesAndConsumptionCPIClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("PR/PR0101/"), client.getUrl());
    }

}
