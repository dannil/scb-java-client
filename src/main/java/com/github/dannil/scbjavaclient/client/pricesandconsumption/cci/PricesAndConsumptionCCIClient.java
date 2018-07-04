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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.cci;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.cci.fpiexcludingwage.PricesAndConsumptionCCIFPIExcludingWageClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.cci.fpiincludingwage.PricesAndConsumptionCCIFPIIncludingWageClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles prices and consumption construction cost index (CCI) data
 * fetching.</p>
 *
 * @since 0.4.0
 */
public class PricesAndConsumptionCCIClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public PricesAndConsumptionCCIClient() {
        super();

        addClient("fpiexcludingwage", new PricesAndConsumptionCCIFPIExcludingWageClient());
        addClient("fpiincludingwage", new PricesAndConsumptionCCIFPIIncludingWageClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PricesAndConsumptionCCIClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption construction
     * cost index (CCI) factor price index (FPI) excluding wage data.</p>
     *
     * @return a client for prices and consumption construction cost index (CCI) factor
     *         price index (FPI) excluding wage data
     */
    public PricesAndConsumptionCCIFPIExcludingWageClient fpiExcludingWage() {
        return (PricesAndConsumptionCCIFPIExcludingWageClient) getClient("fpiexcludingwage");
    }

    /**
     * <p>Retrieve the client for interacting with prices and consumption construction
     * cost index (CCI) factor price index (FPI) including wage data.</p>
     *
     * @return a client for prices and consumption construction cost index (CCI) factor
     *         price index (FPI) including wage data
     */
    public PricesAndConsumptionCCIFPIIncludingWageClient fpiIncludingWage() {
        return (PricesAndConsumptionCCIFPIIncludingWageClient) getClient("fpiincludingwage");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("PR/PR0502/");
    }

}
