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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.economicindicators.PricesAndConsumptionPPIEconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.spin2002month.PricesAndConsumptionPPISPIN2002MonthClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.spin2002year.PricesAndConsumptionPPISPIN2002YearClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.spin2007monthlyandquarterly.PricesAndConsumptionPPISPIN2007MonthlyAndQuarterlyClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.spin2007year.PricesAndConsumptionPPISPIN2007YearClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.spin2015monthlyandquarterly.PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles prices and consumption producer and import price index (PPI)
 * data fetching.</p>
 *
 * @since 0.4.0
 */
public class PricesAndConsumptionPPIClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public PricesAndConsumptionPPIClient() {
        super();

        addClient("economicindicators", new PricesAndConsumptionPPIEconomicIndicatorsClient());
        addClient("spin2002month", new PricesAndConsumptionPPISPIN2002MonthClient());
        addClient("spin2002year", new PricesAndConsumptionPPISPIN2002YearClient());
        addClient("spin2007monthlyandquarterly", new PricesAndConsumptionPPISPIN2007MonthlyAndQuarterlyClient());
        addClient("spin2007year", new PricesAndConsumptionPPISPIN2007YearClient());
        addClient("spin2015monthlyandquarterly", new PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PricesAndConsumptionPPIClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption producer and
     * import price index (PPI) economic indicators data.</p>
     *
     * @return a client for prices and consumption producer and import price index (PPI)
     *         economic indicators data
     */
    public PricesAndConsumptionPPIEconomicIndicatorsClient economicIndicators() {
        return (PricesAndConsumptionPPIEconomicIndicatorsClient) getClient("economicindicators");
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption producer and
     * import price index (PPI) SPIN 2002 month data.</p>
     *
     * @return a client for prices and consumption producer and import price index (PPI)
     *         SPIN 2002 month data
     */
    public PricesAndConsumptionPPISPIN2002MonthClient spin2002Month() {
        return (PricesAndConsumptionPPISPIN2002MonthClient) getClient("spin2002month");
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption producer and
     * import price index (PPI) SPIN 2002 year data.</p>
     *
     * @return a client for prices and consumption producer and import price index (PPI)
     *         SPIN 2002 year data
     */
    public PricesAndConsumptionPPISPIN2002YearClient spin2002Year() {
        return (PricesAndConsumptionPPISPIN2002YearClient) getClient("spin2002year");
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption producer and
     * import price index (PPI) SPIN 2007 monthly and quarterly data.</p>
     *
     * @return a client for prices and consumption producer and import price index (PPI)
     *         SPIN 2007 monthly and quarterly data
     */
    public PricesAndConsumptionPPISPIN2007MonthlyAndQuarterlyClient spin2007MonthlyAndQuarterly() {
        return (PricesAndConsumptionPPISPIN2007MonthlyAndQuarterlyClient) getClient("spin2007monthlyandquarterly");
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption producer and
     * import price index (PPI) SPIN 2007 year data.</p>
     *
     * @return a client for prices and consumption producer and import price index (PPI)
     *         SPIN 2007 year data
     */
    public PricesAndConsumptionPPISPIN2007YearClient spin2007Year() {
        return (PricesAndConsumptionPPISPIN2007YearClient) getClient("spin2007year");
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption producer and
     * import price index (PPI) SPIN 2015 monthly and quarterly data.</p>
     *
     * @return a client for prices and consumption producer and import price index (PPI)
     *         SPIN 2015 monthly and quarterly data
     */
    public PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClient spin2015MonthlyAndQuarterly() {
        return (PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClient) getClient("spin2015monthlyandquarterly");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("PR/PR0301/");
    }

}
