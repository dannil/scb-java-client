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

package com.github.dannil.scbjavaclient.client.businessactivities.nonprofitorganizations.primarystatistics;

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
 * <p>Client which handles business activities non-profit organizations primary statistics
 * data fetching.</p>
 *
 * @since 0.3.0
 */
public class BusinessActivitiesNonProfitOrganizationsPrimaryStatisticsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public BusinessActivitiesNonProfitOrganizationsPrimaryStatisticsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public BusinessActivitiesNonProfitOrganizationsPrimaryStatisticsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all presentation of results data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPresentationOfResults(Collection, Collection)
     */
    public List<ResponseModel> getPresentationOfResults() {
        return getPresentationOfResults(null, null);
    }

    /**
     * <p>Fetch all presentation of results data which match the input constraints.</p>
     *
     * @param incomeStatements
     *            the income statements
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPresentationOfResults(Collection<String> incomeStatements,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Resultatraknposter", incomeStatements);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("CivSamHIO", mappings);
    }

    /**
     * <p>Fetch all income and costs from public administration data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getIncomeAndCostsFromPublicAdministration(Collection, Collection)
     */
    public List<ResponseModel> getIncomeAndCostsFromPublicAdministration() {
        return getIncomeAndCostsFromPublicAdministration(null, null);
    }

    /**
     * <p>Fetch all income and costs from public administration data which match the input
     * constraints.</p>
     *
     * @param incomesAndCosts
     *            the incomes and costs
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getIncomeAndCostsFromPublicAdministration(Collection<String> incomesAndCosts,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("IntakterKostnader", incomesAndCosts);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("CivSamHIOOFFSEKT", mappings);
    }

    /**
     * <p>Fetch all presentation of results for the Swedish Church data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPresentationOfResultsSwedishChurch(Collection, Collection)
     */
    public List<ResponseModel> getPresentationOfResultsSwedishChurch() {
        return getPresentationOfResultsSwedishChurch(null, null);
    }

    /**
     * <p>Fetch all presentation of results for the Swedish Church data which match the
     * input constraints.</p>
     *
     * @param incomeStatements
     *            the income statements
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPresentationOfResultsSwedishChurch(Collection<String> incomeStatements,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Resultatraknposter", incomeStatements);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("CivSamSvKyrk", mappings);
    }

    /**
     * <p>Fetch all income and costs from occupational pension data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getIncomeAndCostsFromOccupationalPension(Collection, Collection)
     */
    public List<ResponseModel> getIncomeAndCostsFromOccupationalPension() {
        return getIncomeAndCostsFromPublicAdministration(null, null);
    }

    /**
     * <p>Fetch all income and costs from occupational pension data which match the input
     * constraints.</p>
     *
     * @param incomesAndCosts
     *            the incomes and costs
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getIncomeAndCostsFromOccupationalPension(Collection<String> incomesAndCosts,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("IntakterKostnader", incomesAndCosts);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("CivSamTJP", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/NV0117/NV0117B/");
    }

}
