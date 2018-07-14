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

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntradegoods.cn.GoodsAndServicesForeignTradeGoodsCNClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntradegoods.economicindicators.GoodsAndServicesForeignTradeGoodsEconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntradegoods.sitc.GoodsAndServicesForeignTradeGoodsSITCClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntradegoods.spin.GoodsAndServicesForeignTradeGoodsSPINClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntradegoods.total.GoodsAndServicesForeignTradeGoodsTotalClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles goods and services foreign trade goods data fetching.</p>
 *
 * @since 0.7.0
 */
public class GoodsAndServicesForeignTradeGoodsClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public GoodsAndServicesForeignTradeGoodsClient() {
        super();

        addClient("cn", new GoodsAndServicesForeignTradeGoodsCNClient());
        addClient("economicindicators", new GoodsAndServicesForeignTradeGoodsEconomicIndicatorsClient());
        addClient("sitc", new GoodsAndServicesForeignTradeGoodsSITCClient());
        addClient("spin", new GoodsAndServicesForeignTradeGoodsSPINClient());
        addClient("total", new GoodsAndServicesForeignTradeGoodsTotalClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public GoodsAndServicesForeignTradeGoodsClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with goods and services foreign trade goods
     * CN (Combined Nomenclature) data.</p>
     *
     * @return a client for goods and services foreign trade goods CN (Combined
     *         Nomenclature) data
     */
    public GoodsAndServicesForeignTradeGoodsCNClient cn() {
        return (GoodsAndServicesForeignTradeGoodsCNClient) getClient("cn");
    }

    /**
     * <p>Retrieve the client for interacting with goods and services foreign trade goods
     * economic indicators data.</p>
     *
     * @return a client for goods and services foreign trade goods economic indicators
     *         data
     */
    public GoodsAndServicesForeignTradeGoodsEconomicIndicatorsClient economicIndicators() {
        return (GoodsAndServicesForeignTradeGoodsEconomicIndicatorsClient) getClient("economicindicators");
    }

    /**
     * <p>Retrieve the client for interacting with goods and services foreign trade goods
     * SITC (Standard International Trade Classification) data.</p>
     *
     * @return a client for goods and services foreign trade goods SITC (Standard
     *         International Trade Classification) data
     */
    public GoodsAndServicesForeignTradeGoodsSITCClient sitc() {
        return (GoodsAndServicesForeignTradeGoodsSITCClient) getClient("sitc");
    }

    /**
     * <p>Retrieve the client for interacting with goods and services foreign trade goods
     * SPIN (Swedish Standard Classification of Products by Activity) data.</p>
     *
     * @return a client for goods and services foreign trade goods SPIN (Swedish Standard
     *         Classification of Products by Activity) data
     */
    public GoodsAndServicesForeignTradeGoodsSPINClient spin() {
        return (GoodsAndServicesForeignTradeGoodsSPINClient) getClient("spin");
    }

    /**
     * <p>Retrieve the client for interacting with goods and services foreign trade goods
     * total data.</p>
     *
     * @return a client for goods and services foreign trade goods total data
     */
    public GoodsAndServicesForeignTradeGoodsTotalClient total() {
        return (GoodsAndServicesForeignTradeGoodsTotalClient) getClient("total");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("HA/HA0201/");
    }

}
