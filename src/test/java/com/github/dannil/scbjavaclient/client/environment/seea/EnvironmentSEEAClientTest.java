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

package com.github.dannil.scbjavaclient.client.environment.seea;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.client.environment.seea.airemissionsaccounts.EnvironmentSEEAAirEmissionsAccountsClient;
import com.github.dannil.scbjavaclient.client.environment.seea.energyaccounts.EnvironmentSEEAEnergyAccountsClient;
import com.github.dannil.scbjavaclient.client.environment.seea.goodsandservicessector.EnvironmentSEEAGoodsAndServicesSectorClient;
import com.github.dannil.scbjavaclient.client.environment.seea.materialflowaccounts.EnvironmentSEEAMaterialFlowAccountsClient;
import com.github.dannil.scbjavaclient.client.environment.seea.taxes.EnvironmentSEEATaxesClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class EnvironmentSEEAClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        EnvironmentSEEAClient client = new EnvironmentSEEAClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void airEmissionsAccounts() {
        EnvironmentSEEAClient client = new EnvironmentSEEAClient();

        assertEquals(EnvironmentSEEAAirEmissionsAccountsClient.class, client.airEmissionsAccounts().getClass());
    }

    @Test
    public void goodsAndServicesSector() {
        EnvironmentSEEAClient client = new EnvironmentSEEAClient();

        assertEquals(EnvironmentSEEAGoodsAndServicesSectorClient.class, client.goodsAndServicesSector().getClass());
    }

    @Test
    public void energyAccounts() {
        EnvironmentSEEAClient client = new EnvironmentSEEAClient();

        assertEquals(EnvironmentSEEAEnergyAccountsClient.class, client.energyAccounts().getClass());
    }

    @Test
    public void materialFlowAccounts() {
        EnvironmentSEEAClient client = new EnvironmentSEEAClient();

        assertEquals(EnvironmentSEEAMaterialFlowAccountsClient.class, client.materialFlowAccounts().getClass());
    }

    @Test
    public void taxes() {
        EnvironmentSEEAClient client = new EnvironmentSEEAClient();

        assertEquals(EnvironmentSEEATaxesClient.class, client.taxes().getClass());
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        EnvironmentSEEAClient client = new EnvironmentSEEAClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("MI/MI1301/"), client.getUrl());
    }

}
