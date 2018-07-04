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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

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
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class BusinessActivitiesClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        BusinessActivitiesClient client = new BusinessActivitiesClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void accomodationStatisticsClient() {
        BusinessActivitiesClient client = new BusinessActivitiesClient();

        assertEquals(BusinessActivitiesAccomodationStatisticsClient.class, client.accomodationStatistics().getClass());
    }

    @Test
    public void balanceStatisticsClient() {
        BusinessActivitiesClient client = new BusinessActivitiesClient();

        assertEquals(BusinessActivitiesBalanceStatisticsClient.class, client.balanceStatistics().getClass());
    }

    @Test
    public void databaseClient() {
        BusinessActivitiesClient client = new BusinessActivitiesClient();

        assertEquals(BusinessActivitiesDatabaseClient.class, client.database().getClass());
    }

    @Test
    public void industrialCapacityUtilizationClient() {
        BusinessActivitiesClient client = new BusinessActivitiesClient();

        assertEquals(BusinessActivitiesIndustrialCapacityUtilizationClient.class,
                client.industrialCapacityUtilization().getClass());
    }

    @Test
    public void industrialInventoriesClient() {
        BusinessActivitiesClient client = new BusinessActivitiesClient();

        assertEquals(BusinessActivitiesIndustrialInventoriesClient.class, client.industrialInventories().getClass());
    }

    @Test
    public void investmentSurveyClient() {
        BusinessActivitiesClient client = new BusinessActivitiesClient();

        assertEquals(BusinessActivitiesInvestmentSurveyClient.class, client.investmentSurvey().getClass());
    }

    @Test
    public void nonFinancialCorporationsClient() {
        BusinessActivitiesClient client = new BusinessActivitiesClient();

        assertEquals(BusinessActivitiesNonFinancialCorporationsClient.class,
                client.nonFinancialCorporations().getClass());
    }

    @Test
    public void nonProfitOrganizationsClient() {
        BusinessActivitiesClient client = new BusinessActivitiesClient();

        assertEquals(BusinessActivitiesNonProfitOrganizationsClient.class, client.nonProfitOrganizations().getClass());
    }

    @Test
    public void productionIndexClient() {
        BusinessActivitiesClient client = new BusinessActivitiesClient();

        assertEquals(BusinessActivitiesProductionIndexClient.class, client.productionIndex().getClass());
    }

    @Test
    public void productionValueIndexClient() {
        BusinessActivitiesClient client = new BusinessActivitiesClient();

        assertEquals(BusinessActivitiesProductionValueIndexClient.class, client.productionValueIndex().getClass());
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        BusinessActivitiesClient client = new BusinessActivitiesClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("NV/"), client.getUrl());
    }

}
