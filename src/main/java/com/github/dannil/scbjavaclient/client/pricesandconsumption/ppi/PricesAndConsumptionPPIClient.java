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
import com.github.dannil.scbjavaclient.http.URLEndpoint;

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

        // addClient("annualaccounts", new PublicFinancesAnnualAccountsClient());
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
    
    TODO

    // /**
    // * <p>Retrieve the client for interacting with public finances annual accounts
    // * data.</p>
    // *
    // * @return a client for public finances annual accounts data
    // */
    // public PublicFinancesAnnualAccountsClient annualAccounts() {
    // return (PublicFinancesAnnualAccountsClient) getClient("annualaccounts");
    // }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("PR/PR0301/");
    }

}
