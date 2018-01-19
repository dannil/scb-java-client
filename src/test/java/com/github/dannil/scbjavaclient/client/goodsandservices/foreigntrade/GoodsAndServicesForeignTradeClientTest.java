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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.cn.GoodsAndServicesForeignTradeCNClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.economicindicators.GoodsAndServicesForeignTradeEconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.sitc.GoodsAndServicesForeignTradeSITCClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.spin.GoodsAndServicesForeignTradeSPINClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.total.GoodsAndServicesForeignTradeTotalClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.Test;

@Suite
@SuppressWarnings("deprecation")
public class GoodsAndServicesForeignTradeClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        GoodsAndServicesForeignTradeClient client = new GoodsAndServicesForeignTradeClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void cnClient() {
        GoodsAndServicesForeignTradeClient client = new GoodsAndServicesForeignTradeClient();

        assertEquals(GoodsAndServicesForeignTradeCNClient.class, client.cn().getClass());
    }

    @Test
    public void economicIndicatorsClient() {
        GoodsAndServicesForeignTradeClient client = new GoodsAndServicesForeignTradeClient();

        assertEquals(GoodsAndServicesForeignTradeEconomicIndicatorsClient.class,
                client.economicIndicators().getClass());
    }

    @Test
    public void sitcClient() {
        GoodsAndServicesForeignTradeClient client = new GoodsAndServicesForeignTradeClient();

        assertEquals(GoodsAndServicesForeignTradeSITCClient.class, client.sitc().getClass());
    }

    @Test
    public void spinClient() {
        GoodsAndServicesForeignTradeClient client = new GoodsAndServicesForeignTradeClient();

        assertEquals(GoodsAndServicesForeignTradeSPINClient.class, client.spin().getClass());
    }

    @Test
    public void totalClient() {
        GoodsAndServicesForeignTradeClient client = new GoodsAndServicesForeignTradeClient();

        assertEquals(GoodsAndServicesForeignTradeTotalClient.class, client.total().getClass());
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        GoodsAndServicesForeignTradeClient client = new GoodsAndServicesForeignTradeClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("HA/HA0201/"), client.getUrl());
    }

}
