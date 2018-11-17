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

package com.github.dannil.scbjavaclient.client.businessactivities.industrialcapacityutilization;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.businessactivities.industrialcapacityutilization.economicindicators.BusinessActivitiesIndustrialCapacityUtilizationEconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.businessactivities.industrialcapacityutilization.industrialcapacityutilization.BusinessActivitiesIndustrialCapacityUtilizationIndustrialCapacityUtilizationClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles business activities industrial capacity utilization data
 * fetching.</p>
 *
 * @since 0.7.0
 */
public class BusinessActivitiesIndustrialCapacityUtilizationClient extends AbstractContainerClient {

    /**
     * <p>Default constructor.</p>
     */
    public BusinessActivitiesIndustrialCapacityUtilizationClient() {
        super();

        addClient("economicindicators", new BusinessActivitiesIndustrialCapacityUtilizationEconomicIndicatorsClient());
        addClient("industrialcapacityutilization",
                new BusinessActivitiesIndustrialCapacityUtilizationIndustrialCapacityUtilizationClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public BusinessActivitiesIndustrialCapacityUtilizationClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with business activities industrial capacity
     * utilization economic indicators data.</p>
     *
     * @return a client for business activities industrial capacity utilization economic
     *         indicators data
     */
    public BusinessActivitiesIndustrialCapacityUtilizationEconomicIndicatorsClient economicIndicators() {
        return (BusinessActivitiesIndustrialCapacityUtilizationEconomicIndicatorsClient) getClient(
                "economicindicators");
    }

    /**
     * <p>Retrieve the client for interacting with business activities industrial capacity
     * utilization industrial capacity utilization data.</p>
     *
     * @return a client for business activities industrial capacity utilization industrial
     *         capacity utilization data
     */
    public BusinessActivitiesIndustrialCapacityUtilizationIndustrialCapacityUtilizationClient industrialCapacityUtilization() {
        return (BusinessActivitiesIndustrialCapacityUtilizationIndustrialCapacityUtilizationClient) getClient(
                "industrialcapacityutilization");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/NV0701/");
    }

}
