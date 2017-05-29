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

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.environment.landuse.EnvironmentLandUseClient;
import com.github.dannil.scbjavaclient.client.environment.seea.airemissionsaccounts.EnvironmentSEEAAirEmissionsAccountsClient;
import com.github.dannil.scbjavaclient.client.environment.seea.energyaccounts.EnvironmentSEEAEnergyAccountsClient;
import com.github.dannil.scbjavaclient.client.environment.seea.goodsandservicessector.EnvironmentSEEAGoodsAndServicesSectorClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
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

        assertEquals(client.airEmissionsAccounts().getClass(), EnvironmentSEEAAirEmissionsAccountsClient.class);
    }

    @Test
    public void goodsAndServicesSector() {
        EnvironmentSEEAClient client = new EnvironmentSEEAClient();

        assertEquals(client.goodsAndServicesSector().getClass(), EnvironmentSEEAGoodsAndServicesSectorClient.class);
    }

    @Test
    public void energyAccounts() {
        EnvironmentSEEAClient client = new EnvironmentSEEAClient();

        assertEquals(client.energyAccounts().getClass(), EnvironmentSEEAEnergyAccountsClient.class);
    }

    @Test
    public void materialFlowAccounts() {
        EnvironmentSEEAClient client = new EnvironmentSEEAClient();

        assertEquals(client.materialFlowAccounts().getClass(), EnvironmentSEEAMaterialFlowAccountsClient.class);
    }

    @Test
    public void taxes() {
        EnvironmentSEEAClient client = new EnvironmentSEEAClient();

        assertEquals(client.taxes().getClass(), EnvironmentSEEATaxes.class);
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        EnvironmentLandUseClient client = new EnvironmentLandUseClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("MI/MI1301/"), client.getUrl());
    }

}
