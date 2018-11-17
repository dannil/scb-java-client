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
import com.github.dannil.scbjavaclient.client.businessactivities.accomodationstatistics.BusinessActivitiesAccomodationStatisticsClient;
import com.github.dannil.scbjavaclient.client.businessactivities.balancestatistics.BusinessActivitiesBalanceStatisticsClient;
import com.github.dannil.scbjavaclient.client.businessactivities.database.BusinessActivitiesDatabaseClient;
import com.github.dannil.scbjavaclient.client.businessactivities.industrialcapacityutilization.BusinessActivitiesIndustrialCapacityUtilizationClient;
import com.github.dannil.scbjavaclient.client.businessactivities.industrialinventories.BusinessActivitiesIndustrialInventoriesClient;
import com.github.dannil.scbjavaclient.client.businessactivities.investmentsurvey.BusinessActivitiesInvestmentSurveyClient;
import com.github.dannil.scbjavaclient.client.businessactivities.nonfinancialcorporations.BusinessActivitiesNonFinancialCorporationsClient;
import com.github.dannil.scbjavaclient.client.businessactivities.nonprofitorganizations.BusinessActivitiesNonProfitOrganizationsClient;
import com.github.dannil.scbjavaclient.client.businessactivities.productionindex.BusinessActivitiesProductionIndexClient;
import com.github.dannil.scbjavaclient.client.businessactivities.productionvalueindex.BusinessActivitiesProductionValueIndexClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

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

        addClient("accomodationstatistics", new BusinessActivitiesAccomodationStatisticsClient());
        addClient("balancestatistics", new BusinessActivitiesBalanceStatisticsClient());
        addClient("database", new BusinessActivitiesDatabaseClient());
        addClient("industrialcapacityutilization", new BusinessActivitiesIndustrialCapacityUtilizationClient());
        addClient("industrialinventories", new BusinessActivitiesIndustrialInventoriesClient());
        addClient("investmentsurvey", new BusinessActivitiesInvestmentSurveyClient());
        addClient("nonfinancialcorporations", new BusinessActivitiesNonFinancialCorporationsClient());
        addClient("nonprofitorganizations", new BusinessActivitiesNonProfitOrganizationsClient());
        addClient("productionindex", new BusinessActivitiesProductionIndexClient());
        addClient("productionvalueindex", new BusinessActivitiesProductionValueIndexClient());
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
     * <p>Retrieve the client for interacting with business activities accomodation
     * statistics data.</p>
     *
     * @return a client for business activities accomodation statistics data
     */
    public BusinessActivitiesAccomodationStatisticsClient accomodationStatistics() {
        return (BusinessActivitiesAccomodationStatisticsClient) getClient("accomodationstatistics");
    }

    /**
     * <p>Retrieve the client for interacting with business activities balance statistics
     * data.</p>
     *
     * @return a client for business activities statistics data
     */
    public BusinessActivitiesBalanceStatisticsClient balanceStatistics() {
        return (BusinessActivitiesBalanceStatisticsClient) getClient("balancestatistics");
    }

    /**
     * <p>Retrieve the client for interacting with business activities database data.</p>
     *
     * @return a client for business activities database data
     */
    public BusinessActivitiesDatabaseClient database() {
        return (BusinessActivitiesDatabaseClient) getClient("database");
    }

    /**
     * <p>Retrieve the client for interacting with business activities industrial capacity
     * utilization data.</p>
     *
     * @return a client for business activities industrial capacity utilization data
     */
    public BusinessActivitiesIndustrialCapacityUtilizationClient industrialCapacityUtilization() {
        return (BusinessActivitiesIndustrialCapacityUtilizationClient) getClient("industrialcapacityutilization");
    }

    /**
     * <p>Retrieve the client for interacting with business activities industrial
     * inventories data.</p>
     *
     * @return a client for business activities industrial inventories data
     */
    public BusinessActivitiesIndustrialInventoriesClient industrialInventories() {
        return (BusinessActivitiesIndustrialInventoriesClient) getClient("industrialinventories");
    }

    /**
     * <p>Retrieve the client for interacting with business activities investment survey
     * data.</p>
     *
     * @return a client for business activities investment survey data
     */
    public BusinessActivitiesInvestmentSurveyClient investmentSurvey() {
        return (BusinessActivitiesInvestmentSurveyClient) getClient("investmentsurvey");
    }

    /**
     * <p>Retrieve the client for interacting with business activities non financial
     * corporations data.</p>
     *
     * @return a client for business activities non financial corporations data
     */
    public BusinessActivitiesNonFinancialCorporationsClient nonFinancialCorporations() {
        return (BusinessActivitiesNonFinancialCorporationsClient) getClient("nonfinancialcorporations");
    }

    /**
     * <p>Retrieve the client for interacting with business activities non-profit
     * organizations data.</p>
     *
     * @return a client for business activities non-profit organizations data
     */
    public BusinessActivitiesNonProfitOrganizationsClient nonProfitOrganizations() {
        return (BusinessActivitiesNonProfitOrganizationsClient) getClient("nonprofitorganizations");
    }

    /**
     * <p>Retrieve the client for interacting with business activities production index
     * data.</p>
     *
     * @return a client for business activities production index data
     */
    public BusinessActivitiesProductionIndexClient productionIndex() {
        return (BusinessActivitiesProductionIndexClient) getClient("productionindex");
    }

    /**
     * <p>Retrieve the client for interacting with business activities production value
     * index data.</p>
     *
     * @return a client for business activities production value index data
     */
    public BusinessActivitiesProductionValueIndexClient productionValueIndex() {
        return (BusinessActivitiesProductionValueIndexClient) getClient("productionvalueindex");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/");
    }

}
