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

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foodsales.GoodsAndServicesFoodSalesClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntradegoods.GoodsAndServicesForeignTradeGoodsClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles goods and services data fetching.</p>
 *
 * @since 0.3.0
 */
public class GoodsAndServicesClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public GoodsAndServicesClient() {
        super();

        addClient("foodsales", new GoodsAndServicesFoodSalesClient());
        addClient("foreigntradegoods", new GoodsAndServicesForeignTradeGoodsClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public GoodsAndServicesClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with goods and services food sales data.</p>
     *
     * @return a client for goods and services food sales data
     */
    public GoodsAndServicesFoodSalesClient foodSales() {
        return (GoodsAndServicesFoodSalesClient) getClient("foodsales");
    }

    /**
     * <p>Retrieve the client for interacting with goods and services foreign trade goods
     * data.</p>
     *
     * @return a client for goods and services foreign trade goods data
     */
    public GoodsAndServicesForeignTradeGoodsClient foreignTradeGoods() {
        return (GoodsAndServicesForeignTradeGoodsClient) getClient("foreigntradegoods");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("HA/");
    }

}
