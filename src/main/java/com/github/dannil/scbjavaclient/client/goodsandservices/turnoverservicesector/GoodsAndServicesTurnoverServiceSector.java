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

package com.github.dannil.scbjavaclient.client.goodsandservices.turnoverservicesector;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.cn.GoodsAndServicesForeignTradeCNClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.economicindicators.GoodsAndServicesForeignTradeEconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.turnoverservicesector.economicindicators.GoodsAndServicesTurnoverServiceSectorEconomicIndicators;
import com.github.dannil.scbjavaclient.client.goodsandservices.turnoverservicesector.turnover.GoodsAndServicesTurnoverServiceSectorTurnover;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles goods and services turnover service sector data fetching.</p>
 *
 * @since 0.7.0
 */
public class GoodsAndServicesTurnoverServiceSector extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public GoodsAndServicesTurnoverServiceSector() {
        super();

        addClient("economicindicators", new GoodsAndServicesTurnoverServiceSectorEconomicIndicators());
        addClient("turnover", new GoodsAndServicesTurnoverServiceSectorTurnover());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public GoodsAndServicesTurnoverServiceSector(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with goods and services turnover service
     * sector economic indicators data.</p>
     *
     * @return a client for goods and services turnover service sector economic indicators
     *         data
     */
    public GoodsAndServicesTurnoverServiceSectorEconomicIndicators economicIndicators() {
        return (GoodsAndServicesTurnoverServiceSectorEconomicIndicators) getClient("economicindicators");
    }

    /**
     * <p>Retrieve the client for interacting with goods and services turnover service
     * sector turnover data.</p>
     *
     * @return a client for goods and services turnover service sector turnover data
     */
    public GoodsAndServicesTurnoverServiceSectorTurnover turnover() {
        return (GoodsAndServicesTurnoverServiceSectorTurnover) getClient("turnover");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("HA/HA0101/");
    }

}
