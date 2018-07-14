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

package com.github.dannil.scbjavaclient.client.businessactivities.investmentsurvey;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.businessactivities.investmentsurvey.economicindicators.BusinessActivitiesInvestmentSurveyEconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles business activities investment survey data fetching.</p>
 *
 * @since 0.7.0
 */
public class BusinessActivitiesInvestmentSurveyClient extends AbstractContainerClient {

    /**
     * <p>Default constructor.</p>
     */
    public BusinessActivitiesInvestmentSurveyClient() {
        super();

        addClient("economicindicators", new BusinessActivitiesInvestmentSurveyEconomicIndicatorsClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public BusinessActivitiesInvestmentSurveyClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with business activities investment survey
     * economic indicators data.</p>
     *
     * @return a client for business activities investment survey economic indicators data
     */
    public BusinessActivitiesInvestmentSurveyEconomicIndicatorsClient economicIndicators() {
        return (BusinessActivitiesInvestmentSurveyEconomicIndicatorsClient) getClient("economicindicators");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/NV0801/");
    }

}
