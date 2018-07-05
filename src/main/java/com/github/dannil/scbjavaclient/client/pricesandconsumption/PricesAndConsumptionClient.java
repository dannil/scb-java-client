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

package com.github.dannil.scbjavaclient.client.pricesandconsumption;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.bpi.PricesAndConsumptionBPIClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.cci.PricesAndConsumptionCCIClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.PricesAndConsumptionCPIClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.PricesAndConsumptionPPIClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.purchasingpowerparities.PricesAndConsumptionPurchasingPowerParitiesClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles prices and consumption data fetching.</p>
 *
 * @since 0.4.0
 */
public class PricesAndConsumptionClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public PricesAndConsumptionClient() {
        super();

        addClient("bpi", new PricesAndConsumptionBPIClient());
        addClient("cci", new PricesAndConsumptionCCIClient());
        addClient("cpi", new PricesAndConsumptionCPIClient());
        addClient("ppi", new PricesAndConsumptionPPIClient());
        addClient("purchasingpowerparities", new PricesAndConsumptionPurchasingPowerParitiesClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PricesAndConsumptionClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption building price
     * index (BPI) data.</p>
     *
     * @return a client for prices and consumption building price index (BPI) data
     */
    public PricesAndConsumptionBPIClient bpi() {
        return (PricesAndConsumptionBPIClient) getClient("bpi");
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption construction
     * cost index (CCI) data.</p>
     *
     * @return a client for prices and consumption construction cost index (CCI) data
     */
    public PricesAndConsumptionCCIClient cci() {
        return (PricesAndConsumptionCCIClient) getClient("cci");
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption Consumer Price
     * Index (CPI) data.</p>
     *
     * @return a client for prices and consumption Consumer Price Index (CPI) data
     */
    public PricesAndConsumptionCPIClient cpi() {
        return (PricesAndConsumptionCPIClient) getClient("cpi");
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption producer and
     * import price index (PPI) data.</p>
     *
     * @return a client for prices and consumption producer and import price index (PPI)
     *         data
     */
    public PricesAndConsumptionPPIClient ppi() {
        return (PricesAndConsumptionPPIClient) getClient("ppi");
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption purchasing power
     * parities data.</p>
     *
     * @return a client for prices and consumption purchasing power parities data
     */
    public PricesAndConsumptionPurchasingPowerParitiesClient purchasingPowerParities() {
        return (PricesAndConsumptionPurchasingPowerParitiesClient) getClient("purchasingpowerparities");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("PR/");
    }

}
