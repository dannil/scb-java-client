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

package com.github.dannil.scbjavaclient.client.labourmarket.grosspay;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.labourmarket.grosspay.aggregatewages.LabourMarketGrossPayAggregateWagesClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * Client which handles labour market gross pay data fetching.
 *
 * @since 0.3.0
 */
public class LabourMarketGrossPayClient extends AbstractContainerClient {

    /**
     * Default constructor. Initializes values and creates sub-clients.
     */
    public LabourMarketGrossPayClient() {
        super();

        addClient("aggregatewages", new LabourMarketGrossPayAggregateWagesClient());
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public LabourMarketGrossPayClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * Retrieve the client for interacting with labour market gross pay aggregate wages
     * data.
     *
     * @return a client for labour market gross pay aggregate wages data
     */
    public LabourMarketGrossPayAggregateWagesClient aggregateWages() {
        return (LabourMarketGrossPayAggregateWagesClient) getClient("aggregatewages");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("AM/AM0302/");
    }

}
