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

package com.github.dannil.scbjavaclient.client.businessactivities;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.businessactivities.balancestatistics.BalanceStatisticsClient;
import com.github.dannil.scbjavaclient.client.businessactivities.database.DatabaseClient;
import com.github.dannil.scbjavaclient.client.businessactivities.nonprofitorganizations.NonProfitOrganizationsClient;
import com.github.dannil.scbjavaclient.client.businessactivities.productionindex.ProductionIndexClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles business activities data fetching.</p>
 *
 * @since 0.3.0
 */
public class BusinessActivitiesClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public BusinessActivitiesClient() {
        super();

        addClient("balancestatistics", new BalanceStatisticsClient());
        addClient("database", new DatabaseClient());
        addClient("nonprofitorganizations", new NonProfitOrganizationsClient());
        addClient("productionindex", new ProductionIndexClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public BusinessActivitiesClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with business activities balance statistics
     * data.</p>
     *
     * @return a client for business activities statistics data
     */
    public BalanceStatisticsClient balanceStatistics() {
        return (BalanceStatisticsClient) getClient("balancestatistics");
    }

    /**
     * <p>Retrieve the client for interacting with business activities database statistics
     * data.</p>
     *
     * @return a client for business activities database data
     */
    public DatabaseClient database() {
        return (DatabaseClient) getClient("database");
    }

    /**
     * <p>Retrieve the client for interacting with business activities non-profit
     * organizations data.</p>
     *
     * @return a client for business activities non-profit organizations data
     */
    public NonProfitOrganizationsClient nonProfitOrganizations() {
        return (NonProfitOrganizationsClient) getClient("nonprofitorganizations");
    }

    /**
     * <p>Retrieve the client for interacting with business activities production index
     * data.</p>
     *
     * @return a client for business activities production index data
     */
    public ProductionIndexClient productionIndex() {
        return (ProductionIndexClient) getClient("productionindex");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/");
    }

}
