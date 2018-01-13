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

import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntradegoods.cn.GoodsAndServicesForeignTradeGoodsCNClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntradegoods.economicindicators.GoodsAndServicesForeignTradeGoodsEconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntradegoods.sitc.GoodsAndServicesForeignTradeGoodsSITCClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntradegoods.spin.GoodsAndServicesForeignTradeGoodsSPINClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntradegoods.total.GoodsAndServicesForeignTradeGoodsTotalClient;
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

        assertEquals(GoodsAndServicesForeignTradeGoodsCNClient.class, client.cn().getClass());
    }

    @Test
    public void economicIndicatorsClient() {
        GoodsAndServicesForeignTradeGoodsClient client = new GoodsAndServicesForeignTradeGoodsClient();

        assertEquals(GoodsAndServicesForeignTradeGoodsEconomicIndicatorsClient.class,
                client.economicIndicators().getClass());
    }

    @Test
    public void sitcClient() {
        GoodsAndServicesForeignTradeGoodsClient client = new GoodsAndServicesForeignTradeGoodsClient();

        assertEquals(GoodsAndServicesForeignTradeGoodsSITCClient.class, client.sitc().getClass());
    }

    @Test
    public void spinClient() {
        GoodsAndServicesForeignTradeGoodsClient client = new GoodsAndServicesForeignTradeGoodsClient();

        assertEquals(GoodsAndServicesForeignTradeGoodsSPINClient.class, client.spin().getClass());
    }

    @Test
    public void totalClient() {
        GoodsAndServicesForeignTradeGoodsClient client = new GoodsAndServicesForeignTradeGoodsClient();

        assertEquals(GoodsAndServicesForeignTradeGoodsTotalClient.class, client.total().getClass());
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
