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
import com.github.dannil.scbjavaclient.client.businessactivities.nonprofitorganizations.primarystatistics.BusinessActivitiesNonProfitOrganizationsPrimaryStatisticsClient;
import com.github.dannil.scbjavaclient.client.businessactivities.nonprofitorganizations.satelliteaccounts.BusinessActivitiesNonProfitOrganizationsSatelliteAccountsClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles business activities non-profit organizations data fetching.</p>
 *
 * @since 0.3.0
 */
public class BusinessActivitiesNonProfitOrganizationsClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public BusinessActivitiesNonProfitOrganizationsClient() {
        super();

        addClient("primarystatistics", new BusinessActivitiesNonProfitOrganizationsPrimaryStatisticsClient());
        addClient("satelliteaccounts", new BusinessActivitiesNonProfitOrganizationsSatelliteAccountsClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public BusinessActivitiesNonProfitOrganizationsClient(Locale locale) {
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
    public BusinessActivitiesNonProfitOrganizationsPrimaryStatisticsClient primaryStatistics() {
        return (BusinessActivitiesNonProfitOrganizationsPrimaryStatisticsClient) getClient("primarystatistics");
    }

    /**
     * <p>Retrieve the client for interacting with business activities non-profit
     * organizations satellite accounts data.</p>
     *
     * @return a client for business activities non-profit organizations satellite
     *         accounts data
     */
    public BusinessActivitiesNonProfitOrganizationsSatelliteAccountsClient satelliteAccounts() {
        return (BusinessActivitiesNonProfitOrganizationsSatelliteAccountsClient) getClient("satelliteaccounts");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/NV0117/");
    }

}
