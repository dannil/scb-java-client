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

package com.github.dannil.scbjavaclient.client.businessactivities.nonprofitorganizations;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.businessactivities.nonprofitorganizations.primarystatistics.PrimaryStatisticsClient;
import com.github.dannil.scbjavaclient.client.businessactivities.nonprofitorganizations.satelliteaccounts.SatelliteAccountsClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles business activities non-profit organizations data fetching.</p>
 *
 * @since 0.3.0
 */
public class NonProfitOrganizationsClient extends AbstractContainerClient {

    /**
     * <p>Default constructor.</p>
     */
    public NonProfitOrganizationsClient() {
        super();

        addClient("primarystatistics", new PrimaryStatisticsClient());
        addClient("satelliteaccounts", new SatelliteAccountsClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public NonProfitOrganizationsClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with business activities non-profit
     * organizations primary statistics data.</p>
     *
     * @return a client for business activities non-profit organizations primary
     *         statistics data
     */
    public PrimaryStatisticsClient primaryStatistics() {
        return (PrimaryStatisticsClient) getClient("primarystatistics");
    }

    /**
     * <p>Retrieve the client for interacting with business activities non-profit
     * organizations satellite accounts data.</p>
     *
     * @return a client for business activities non-profit organizations satellite
     *         accounts data
     */
    public SatelliteAccountsClient satelliteAccounts() {
        return (SatelliteAccountsClient) getClient("satelliteaccounts");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/NV0117/");
    }

}
