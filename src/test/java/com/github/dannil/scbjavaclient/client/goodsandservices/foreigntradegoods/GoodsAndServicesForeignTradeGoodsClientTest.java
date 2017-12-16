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

package com.github.dannil.scbjavaclient.client.goodsandservices.foreigntradegoods;

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
public class GoodsAndServicesForeignTradeGoodsClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        GoodsAndServicesForeignTradeGoodsClient client = new GoodsAndServicesForeignTradeGoodsClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void cnClient() {
        GoodsAndServicesForeignTradeGoodsClient client = new GoodsAndServicesForeignTradeGoodsClient();

        assertEquals(client.cn().getClass(), GoodsAndServicesForeignTradeCNClient.class);
    }

    @Test
    public void economicIndicatorsClient() {
        GoodsAndServicesForeignTradeGoodsClient client = new GoodsAndServicesForeignTradeGoodsClient();

        assertEquals(client.economicIndicators().getClass(),
                GoodsAndServicesForeignTradeEconomicIndicatorsClient.class);
    }

    @Test
    public void sitcClient() {
        GoodsAndServicesForeignTradeGoodsClient client = new GoodsAndServicesForeignTradeGoodsClient();

        assertEquals(client.sitc().getClass(), GoodsAndServicesForeignTradeSITCClient.class);
    }

    @Test
    public void spinClient() {
        GoodsAndServicesForeignTradeGoodsClient client = new GoodsAndServicesForeignTradeGoodsClient();

        assertEquals(client.spin().getClass(), GoodsAndServicesForeignTradeSPINClient.class);
    }

    @Test
    public void totalClient() {
        GoodsAndServicesForeignTradeGoodsClient client = new GoodsAndServicesForeignTradeGoodsClient();

        assertEquals(client.total().getClass(), GoodsAndServicesForeignTradeTotalClient.class);
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        GoodsAndServicesForeignTradeGoodsClient client = new GoodsAndServicesForeignTradeGoodsClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("HA/HA0201/"), client.getUrl());
    }

}
