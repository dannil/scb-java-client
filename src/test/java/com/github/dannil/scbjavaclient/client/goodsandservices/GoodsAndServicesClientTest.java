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

package com.github.dannil.scbjavaclient.client.goodsandservices;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.client.goodsandservices.foodsales.GoodsAndServicesFoodSalesClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntradegoods.GoodsAndServicesForeignTradeGoodsClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class GoodsAndServicesClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        GoodsAndServicesClient client = new GoodsAndServicesClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void foodSalesClient() {
        GoodsAndServicesClient client = new GoodsAndServicesClient();

        assertEquals(GoodsAndServicesFoodSalesClient.class, client.foodSales().getClass());
    }

    @Test
    public void foreignTradeGoodsClient() {
        GoodsAndServicesClient client = new GoodsAndServicesClient();

        assertEquals(GoodsAndServicesForeignTradeGoodsClient.class, client.foreignTradeGoods().getClass());
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        GoodsAndServicesClient client = new GoodsAndServicesClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("HA"), client.getUrl());
    }

}
