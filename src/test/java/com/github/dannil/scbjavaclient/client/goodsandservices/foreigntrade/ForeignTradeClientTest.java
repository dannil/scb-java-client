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

package com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.cn.CNClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.economicindicators.EconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.sitc.SITCClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.spin.SPINClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.total.TotalClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ForeignTradeClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        ForeignTradeClient client = new ForeignTradeClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void cnClient() {
        ForeignTradeClient client = new ForeignTradeClient();

        assertEquals(client.cn().getClass(), CNClient.class);
    }

    @Test
    public void economicIndicatorsClient() {
        ForeignTradeClient client = new ForeignTradeClient();

        assertEquals(client.economicIndicators().getClass(),
                EconomicIndicatorsClient.class);
    }

    @Test
    public void sitcClient() {
        ForeignTradeClient client = new ForeignTradeClient();

        assertEquals(client.sitc().getClass(), SITCClient.class);
    }

    @Test
    public void spinClient() {
        ForeignTradeClient client = new ForeignTradeClient();

        assertEquals(client.spin().getClass(), SPINClient.class);
    }

    @Test
    public void totalClient() {
        ForeignTradeClient client = new ForeignTradeClient();

        assertEquals(client.total().getClass(), TotalClient.class);
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        ForeignTradeClient client = new ForeignTradeClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("HA/HA0201/"), client.getUrl());
    }

}
