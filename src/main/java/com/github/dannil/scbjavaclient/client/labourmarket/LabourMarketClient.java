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

package com.github.dannil.scbjavaclient.client.labourmarket;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.labourmarket.costindex.LabourMarketCostIndexClient;
import com.github.dannil.scbjavaclient.client.labourmarket.grosspay.LabourMarketGrossPayClient;
import com.github.dannil.scbjavaclient.client.labourmarket.shorttermemployment.LabourMarketShortTermEmploymentClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles labour market data fetching.</p>
 *
 * @since 0.3.0
 */
public class LabourMarketClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public LabourMarketClient() {
        super();

        addClient("costindex", new LabourMarketCostIndexClient());
        addClient("grosspay", new LabourMarketGrossPayClient());
        addClient("shorttermemployment", new LabourMarketShortTermEmploymentClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public LabourMarketClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with labour market cost index data.</p>
     *
     * @return a client for labour market cost index data
     */
    public LabourMarketCostIndexClient costIndex() {
        return (LabourMarketCostIndexClient) getClient("costindex");
    }

    /**
     * <p>Retrieve the client for interacting with labour market gross pay data.</p>
     *
     * @return a client for labour market gross pay data
     */
    public LabourMarketGrossPayClient grossPay() {
        return (LabourMarketGrossPayClient) getClient("grosspay");
    }

    /**
     * <p>Retrieve the client for interacting with labour market short-term employment
     * data.</p>
     *
     * @return a client for labour market short-term employment data
     */
    public LabourMarketShortTermEmploymentClient shortTermEmployment() {
        return (LabourMarketShortTermEmploymentClient) getClient("shorttermemployment");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("AM/");
    }

}
