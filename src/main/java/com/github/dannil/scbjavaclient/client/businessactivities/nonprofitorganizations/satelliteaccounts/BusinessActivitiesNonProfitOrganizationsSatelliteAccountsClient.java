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

package com.github.dannil.scbjavaclient.client.businessactivities.nonprofitorganizations.satelliteaccounts;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.model.ResponseModel;

/**
 * <p>Client which handles business activities non-profit organizations satellite accounts
 * data fetching.</p>
 *
 * @since 0.3.0
 */
public class BusinessActivitiesNonProfitOrganizationsSatelliteAccountsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public BusinessActivitiesNonProfitOrganizationsSatelliteAccountsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public BusinessActivitiesNonProfitOrganizationsSatelliteAccountsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all income, expenditure and savings data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getIncomeExpenditureAndSavings(Collection, Collection, Collection)
     */
    public List<ResponseModel> getIncomeExpenditureAndSavings() {
        return getIncomeExpenditureAndSavings(null, null, null);
    }

    /**
     * <p>Fetch all income, expenditure and savings data which match the input
     * constraints.</p>
     *
     * @param icnpo
     *            the ICNPO
     * @param transactionItems
     *            the transaction items
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getIncomeExpenditureAndSavings(Collection<String> icnpo,
            Collection<String> transactionItems, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ICNPO", icnpo);
        mappings.put("Transaktionspost", transactionItems);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("CivSamICNPO2", mappings);
    }

    /**
     * <p>Fetch all number of organizations and employment data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNumberOfOrganizationsAndEmployment(Collection, Collection)
     */
    public List<ResponseModel> getNumberOfOrganizationsAndEmployment() {
        return getNumberOfOrganizationsAndEmployment(null, null);
    }

    /**
     * <p>Fetch all number of organizations and employment data which match the input
     * constraints.</p>
     *
     * @param icnpo
     *            the ICNPO
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNumberOfOrganizationsAndEmployment(Collection<String> icnpo,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ICNPO", icnpo);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("CivSamSyssICNPO2", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/NV0117/NV0117A/");
    }

}
