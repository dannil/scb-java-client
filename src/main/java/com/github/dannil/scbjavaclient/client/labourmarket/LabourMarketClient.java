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
import com.github.dannil.scbjavaclient.client.labourmarket.costindex.CostIndexClient;
import com.github.dannil.scbjavaclient.client.labourmarket.grosspay.GrossPayClient;
import com.github.dannil.scbjavaclient.client.labourmarket.shorttermemployment.ShortTermEmploymentClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

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

        addClient("costindex", new CostIndexClient());
        addClient("grosspay", new GrossPayClient());
        addClient("shorttermemployment", new ShortTermEmploymentClient());
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
    public CostIndexClient costIndex() {
        return (CostIndexClient) getClient("costindex");
    }

    /**
     * <p>Retrieve the client for interacting with labour market gross pay data.</p>
     *
     * @return a client for labour market gross pay data
     */
    public GrossPayClient grossPay() {
        return (GrossPayClient) getClient("grosspay");
    }

    /**
     * <p>Retrieve the client for interacting with labour market short-term employment
     * data.</p>
     *
     * @return a client for labour market short-term employment data
     */
    public ShortTermEmploymentClient shortTermEmployment() {
        return (ShortTermEmploymentClient) getClient("shorttermemployment");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("AM/");
    }

}
