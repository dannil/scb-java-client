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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.economicindicators.PricesAndConsumptionPPIEconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.spin2002month.PricesAndConsumptionPPISPIN2002MonthClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.spin2002year.PricesAndConsumptionPPISPIN2002YearClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.spin2007monthlyandquarterly.PricesAndConsumptionPPISPIN2007MonthlyAndQuarterlyClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.spin2007year.PricesAndConsumptionPPISPIN2007YearClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.spin2015monthlyandquarterly.PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PricesAndConsumptionPPIClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        PricesAndConsumptionPPIClient client = new PricesAndConsumptionPPIClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void economicIndicators() {
        PricesAndConsumptionPPIClient client = new PricesAndConsumptionPPIClient();

        assertEquals(client.economicIndicators().getClass(), PricesAndConsumptionPPIEconomicIndicatorsClient.class);
    }

    @Test
    public void spin2002Month() {
        PricesAndConsumptionPPIClient client = new PricesAndConsumptionPPIClient();

        assertEquals(client.spin2002Month().getClass(), PricesAndConsumptionPPISPIN2002MonthClient.class);
    }

    @Test
    public void spin2002Year() {
        PricesAndConsumptionPPIClient client = new PricesAndConsumptionPPIClient();

        assertEquals(client.spin2002Year().getClass(), PricesAndConsumptionPPISPIN2002YearClient.class);
    }

    @Test
    public void spin2007MonthlyAndQuarterly() {
        PricesAndConsumptionPPIClient client = new PricesAndConsumptionPPIClient();

        assertEquals(client.spin2007MonthlyAndQuarterly().getClass(),
                PricesAndConsumptionPPISPIN2007MonthlyAndQuarterlyClient.class);
    }

    @Test
    public void spin2007Year() {
        PricesAndConsumptionPPIClient client = new PricesAndConsumptionPPIClient();

        assertEquals(client.spin2007Year().getClass(), PricesAndConsumptionPPISPIN2007YearClient.class);
    }

    @Test
    public void spin2015MonthlyAndQuarterly() {
        PricesAndConsumptionPPIClient client = new PricesAndConsumptionPPIClient();

        assertEquals(client.spin2015MonthlyAndQuarterly().getClass(),
                PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClient.class);
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        PricesAndConsumptionPPIClient client = new PricesAndConsumptionPPIClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("PR/P0301/"), client.getUrl());
    }

}
