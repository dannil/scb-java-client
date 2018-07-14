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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.cci;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.client.pricesandconsumption.cci.fpiexcludingwage.PricesAndConsumptionCCIFPIExcludingWageClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.cci.fpiincludingwage.PricesAndConsumptionCCIFPIIncludingWageClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class PricesAndConsumptionCCIClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        PricesAndConsumptionCCIClient client = new PricesAndConsumptionCCIClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void fpiExcludingWage() {
        PricesAndConsumptionCCIClient client = new PricesAndConsumptionCCIClient();

        assertEquals(PricesAndConsumptionCCIFPIExcludingWageClient.class, client.fpiExcludingWage().getClass());
    }

    @Test
    public void fpiIncludingWage() {
        PricesAndConsumptionCCIClient client = new PricesAndConsumptionCCIClient();

        assertEquals(PricesAndConsumptionCCIFPIIncludingWageClient.class, client.fpiIncludingWage().getClass());
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        PricesAndConsumptionCCIClient client = new PricesAndConsumptionCCIClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("PR/PR0502/"), client.getUrl());
    }

}
