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

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles goods and services foreign trade data fetching.</p>
 *
 * @since 0.3.0
 */
public class GoodsAndServicesForeignTradeClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public GoodsAndServicesForeignTradeClient() {
        super();

        // addClient("foodsales", new GoodsAndServicesFoodSalesClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public GoodsAndServicesForeignTradeClient(Locale locale) {
        this();

        setLocale(locale);
    }

    // /**
    // * <p>Retrieve the client for interacting with goods and services food sales
    // data.</p>
    // *
    // * @return a client for goods and services food sales data
    // */
    // public GoodsAndServicesFoodSalesClient foodSales() {
    // return (GoodsAndServicesFoodSalesClient) getClient("foodsales");
    // }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("HA/HA0201/");
    }

}
