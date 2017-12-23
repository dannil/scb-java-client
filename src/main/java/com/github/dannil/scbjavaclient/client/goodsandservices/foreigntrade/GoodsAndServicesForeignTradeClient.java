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
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.cn.GoodsAndServicesForeignTradeCNClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.economicindicators.GoodsAndServicesForeignTradeEconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.sitc.GoodsAndServicesForeignTradeSITCClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.spin.GoodsAndServicesForeignTradeSPINClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.total.GoodsAndServicesForeignTradeTotalClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles goods and services foreign trade data fetching.</p>
 *
 * @since 0.3.0
 *
 * @deprecated use
 *             {@link com.github.dannil.scbjavaclient.client.goodsandservices.foreigntradegoods.GoodsAndServicesForeignTradeGoodsClient
 *             GoodsAndServicesForeignTradeGoodsClient} instead
 */
@Deprecated
public class GoodsAndServicesForeignTradeClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public GoodsAndServicesForeignTradeClient() {
        super();

        addClient("cn", new GoodsAndServicesForeignTradeCNClient());
        addClient("economicindicators", new GoodsAndServicesForeignTradeEconomicIndicatorsClient());
        addClient("sitc", new GoodsAndServicesForeignTradeSITCClient());
        addClient("spin", new GoodsAndServicesForeignTradeSPINClient());
        addClient("total", new GoodsAndServicesForeignTradeTotalClient());
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

    /**
     * <p>Retrieve the client for interacting with goods and services foreign trade CN
     * (Combined Nomenclature) data.</p>
     *
     * @return a client for goods and services foreign trade CN (Combined Nomenclature)
     *         data
     */
    public GoodsAndServicesForeignTradeCNClient cn() {
        return (GoodsAndServicesForeignTradeCNClient) getClient("cn");
    }

    /**
     * <p>Retrieve the client for interacting with goods and services foreign trade
     * economic indicators data.</p>
     *
     * @return a client for goods and services foreign trade economic indicators data
     */
    public GoodsAndServicesForeignTradeEconomicIndicatorsClient economicIndicators() {
        return (GoodsAndServicesForeignTradeEconomicIndicatorsClient) getClient("economicindicators");
    }

    /**
     * <p>Retrieve the client for interacting with goods and services foreign trade SITC
     * (Standard International Trade Classification) data.</p>
     *
     * @return a client for goods and services foreign trade SITC (Standard International
     *         Trade Classification) data
     */
    public GoodsAndServicesForeignTradeSITCClient sitc() {
        return (GoodsAndServicesForeignTradeSITCClient) getClient("sitc");
    }

    /**
     * <p>Retrieve the client for interacting with goods and services foreign trade SPIN
     * (Swedish Standard Classification of Products by Activity) data.</p>
     *
     * @return a client for goods and services foreign trade SPIN (Swedish Standard
     *         Classification of Products by Activity) data
     */
    public GoodsAndServicesForeignTradeSPINClient spin() {
        return (GoodsAndServicesForeignTradeSPINClient) getClient("spin");
    }

    /**
     * <p>Retrieve the client for interacting with goods and services foreign trade total
     * data.</p>
     *
     * @return a client for goods and services foreign trade total data
     */
    public GoodsAndServicesForeignTradeTotalClient total() {
        return (GoodsAndServicesForeignTradeTotalClient) getClient("total");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("HA/HA0201/");
    }

}
