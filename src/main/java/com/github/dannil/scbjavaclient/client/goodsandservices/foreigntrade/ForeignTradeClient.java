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
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.cn.CNClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.economicindicators.EconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.sitc.SITCClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.spin.SPINClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.total.TotalClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles goods and services foreign trade data fetching.</p>
 *
 * @since 0.3.0
 */
public class ForeignTradeClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public ForeignTradeClient() {
        super();

        addClient("cn", new CNClient());
        addClient("economicindicators", new EconomicIndicatorsClient());
        addClient("sitc", new SITCClient());
        addClient("spin", new SPINClient());
        addClient("total", new TotalClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public ForeignTradeClient(Locale locale) {
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
    public CNClient cn() {
        return (CNClient) getClient("cn");
    }

    /**
     * <p>Retrieve the client for interacting with goods and services foreign trade
     * economic indicators data.</p>
     *
     * @return a client for goods and services foreign trade economic indicators data
     */
    public EconomicIndicatorsClient economicIndicators() {
        return (EconomicIndicatorsClient) getClient("economicindicators");
    }

    /**
     * <p>Retrieve the client for interacting with goods and services foreign trade SITC
     * (Standard International Trade Classification) data.</p>
     *
     * @return a client for goods and services foreign trade SITC (Standard International
     *         Trade Classification) data
     */
    public SITCClient sitc() {
        return (SITCClient) getClient("sitc");
    }

    /**
     * <p>Retrieve the client for interacting with goods and services foreign trade SPIN
     * (Swedish Standard Classification of Products by Activity) data.</p>
     *
     * @return a client for goods and services foreign trade SPIN (Swedish Standard
     *         Classification of Products by Activity) data
     */
    public SPINClient spin() {
        return (SPINClient) getClient("spin");
    }

    /**
     * <p>Retrieve the client for interacting with goods and services foreign trade total
     * data.</p>
     *
     * @return a client for goods and services foreign trade total data
     */
    public TotalClient total() {
        return (TotalClient) getClient("total");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("HA/HA0201/");
    }

}
