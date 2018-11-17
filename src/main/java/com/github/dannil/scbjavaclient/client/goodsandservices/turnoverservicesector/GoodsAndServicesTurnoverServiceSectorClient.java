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
import com.github.dannil.scbjavaclient.client.goodsandservices.turnoverservicesector.oldtablessni2002.GoodsAndServicesTurnoverServiceSectorOldTablesSNI2002Client;
import com.github.dannil.scbjavaclient.client.goodsandservices.turnoverservicesector.oldtablessni2007.GoodsAndServicesTurnoverServiceSectorOldTablesSNI2007Client;
import com.github.dannil.scbjavaclient.client.goodsandservices.turnoverservicesector.turnover.GoodsAndServicesTurnoverServiceSectorTurnoverClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles goods and services turnover service sector data fetching.</p>
 *
 * @since 0.7.0
 */
public class GoodsAndServicesTurnoverServiceSectorClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public GoodsAndServicesTurnoverServiceSectorClient() {
        super();

        addClient("oldtablessni2002", new GoodsAndServicesTurnoverServiceSectorOldTablesSNI2002Client());
        addClient("oldtablessni2007", new GoodsAndServicesTurnoverServiceSectorOldTablesSNI2007Client());
        addClient("turnover", new GoodsAndServicesTurnoverServiceSectorTurnoverClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public GoodsAndServicesTurnoverServiceSectorClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with goods and services turnover service
     * sector old tables SNI 2002 data.</p>
     *
     * @return a client for goods and services turnover service sector old tables SNI 2002
     *         data
     */
    public GoodsAndServicesTurnoverServiceSectorOldTablesSNI2002Client oldTablesSNI2002() {
        return (GoodsAndServicesTurnoverServiceSectorOldTablesSNI2002Client) getClient("oldtablessni2002");
    }

    /**
     * <p>Retrieve the client for interacting with goods and services turnover service
     * sector old tables SNI 2007 data.</p>
     *
     * @return a client for goods and services turnover service sector old tables SNI 2007
     *         data
     */
    public GoodsAndServicesTurnoverServiceSectorOldTablesSNI2007Client oldTablesSNI2007() {
        return (GoodsAndServicesTurnoverServiceSectorOldTablesSNI2007Client) getClient("oldtablessni2007");
    }

    /**
     * <p>Retrieve the client for interacting with goods and services turnover service
     * sector turnover data.</p>
     *
     * @return a client for goods and services turnover service sector turnover data
     */
    public GoodsAndServicesTurnoverServiceSectorTurnoverClient turnover() {
        return (GoodsAndServicesTurnoverServiceSectorTurnoverClient) getClient("turnover");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("HA/HA0101/");
    }

}
