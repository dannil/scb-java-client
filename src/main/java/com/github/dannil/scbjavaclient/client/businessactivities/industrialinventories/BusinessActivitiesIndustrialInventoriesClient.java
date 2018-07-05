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

package com.github.dannil.scbjavaclient.client.businessactivities.industrialinventories;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.businessactivities.industrialinventories.economicindicators.BusinessActivitiesIndustrialInventoriesEconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.businessactivities.industrialinventories.inventories.BusinessActivitiesIndustrialInventoriesInventoriesClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles business activities industrial inventories data fetching.</p>
 *
 * @since 0.3.0
 */
public class BusinessActivitiesIndustrialInventoriesClient extends AbstractContainerClient {

    /**
     * <p>Default constructor.</p>
     */
    public BusinessActivitiesIndustrialInventoriesClient() {
        super();

        addClient("economicindicators", new BusinessActivitiesIndustrialInventoriesEconomicIndicatorsClient());
        addClient("inventories", new BusinessActivitiesIndustrialInventoriesInventoriesClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public BusinessActivitiesIndustrialInventoriesClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with business activities industrial
     * inventories economic indicators data.</p>
     *
     * @return a client for business activities industrial inventories economic indicators
     *         data
     */
    public BusinessActivitiesIndustrialInventoriesEconomicIndicatorsClient economicIndicators() {
        return (BusinessActivitiesIndustrialInventoriesEconomicIndicatorsClient) getClient("economicindicators");
    }

    /**
     * <p>Retrieve the client for interacting with business activities industrial
     * inventories inventories data.</p>
     *
     * @return a client for business activities industrial inventories inventories data
     */
    public BusinessActivitiesIndustrialInventoriesInventoriesClient inventories() {
        return (BusinessActivitiesIndustrialInventoriesInventoriesClient) getClient("inventories");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/NV0602/");
    }

}
