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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.cpifct.PricesAndConsumptionCPICPIFCTClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.economicindicators.PricesAndConsumptionCPIEconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.hicp.PricesAndConsumptionCPIHICPClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.kpif.PricesAndConsumptionCPIKPIFClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.pricebasicamount.PricesAndConsumptionCPIPriceBasicAmountClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles prices and consumption Consumer Price Index (CPI) data
 * fetching.</p>
 *
 * @since 0.4.0
 */
public class PricesAndConsumptionCPIClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public PricesAndConsumptionCPIClient() {
        super();

        addClient("cpifct", new PricesAndConsumptionCPICPIFCTClient());
        addClient("economicindicators", new PricesAndConsumptionCPIEconomicIndicatorsClient());
        addClient("hicp", new PricesAndConsumptionCPIHICPClient());
        addClient("pricebasicamount", new PricesAndConsumptionCPIPriceBasicAmountClient());
        addClient("kpif", new PricesAndConsumptionCPIKPIFClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PricesAndConsumptionCPIClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption Consumer Price
     * Index (CPI) with fixed interest rate and at constant taxes (CPIF-CT) data.</p>
     *
     * @return a client for prices and consumption Consumer Price Index (CPI) with fixed
     *         interest rate and at constant taxes (CPIF-CT) data
     */
    public PricesAndConsumptionCPICPIFCTClient cpifct() {
        return (PricesAndConsumptionCPICPIFCTClient) getClient("cpifct");
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption Consumer Price
     * Index (CPI) economic indicators data.</p>
     *
     * @return a client for prices and consumption Consumer Price Index (CPI) economic
     *         indicators data
     */
    public PricesAndConsumptionCPIEconomicIndicatorsClient economicIndicators() {
        return (PricesAndConsumptionCPIEconomicIndicatorsClient) getClient("economicindicators");
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption Consumer Price
     * Index (CPI) Harmonized Index of Consumer Prices (HICP) data.</p>
     *
     * @return a client for prices and consumption Consumer Price Index (CPI) Harmonized
     *         Index of Consumer Prices (HICP) data
     */
    public PricesAndConsumptionCPIHICPClient hicp() {
        return (PricesAndConsumptionCPIHICPClient) getClient("hicp");
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption Consumer Price
     * Index (CPI) Price Basic Amount data.</p>
     *
     * @return a client for prices and consumption Consumer Price Index (CPI) Price Basic
     *         Amount data
     */
    public PricesAndConsumptionCPIPriceBasicAmountClient priceBasicAmount() {
        return (PricesAndConsumptionCPIPriceBasicAmountClient) getClient("pricebasicamount");
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption Consumer Price
     * Index (CPI) Underlying Inflation Rate (KPIF) data.</p>
     *
     * @return a client for prices and consumption Consumer Price Index (CPI) Underlying
     *         Inflation Rate (KPIF) data
     */
    public PricesAndConsumptionCPIKPIFClient kpif() {
        return (PricesAndConsumptionCPIKPIFClient) getClient("kpif");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("PR/PR0101/");
    }

}
