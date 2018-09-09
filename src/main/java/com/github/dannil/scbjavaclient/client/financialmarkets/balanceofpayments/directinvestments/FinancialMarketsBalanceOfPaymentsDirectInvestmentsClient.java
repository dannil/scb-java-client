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

package com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.directinvestments;

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
 * <p>Client which handles financial markets balance of payments direct investments data
 * fetching.</p>
 *
 * @since 0.4.0
 */
public class FinancialMarketsBalanceOfPaymentsDirectInvestmentsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public FinancialMarketsBalanceOfPaymentsDirectInvestmentsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsBalanceOfPaymentsDirectInvestmentsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all direct investments by economic activity (NACE 2007) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getDirectInvestmentsByEconomicActivityNACE2007(Collection, Collection)
     */
    public List<ResponseModel> getDirectInvestmentsByEconomicActivityNACE2007() {
        return getDirectInvestmentsByEconomicActivityNACE2007(null, null);
    }

    /**
     * <p>Fetch all direct investments by economic activity (NACE 2007) data which match
     * the input constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getDirectInvestmentsByEconomicActivityNACE2007(
            Collection<String> industrialClassifications, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FM0001SNI07T03", mappings);
    }

    /**
     * <p>Fetch all direct investments by country (years) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getDirectInvestmentsByCountryYears(Collection, Collection)
     */
    public List<ResponseModel> getDirectInvestmentsByCountryYears() {
        return getDirectInvestmentsByCountryYears(null, null);
    }

    /**
     * <p>Fetch all direct investments by country (years) data which match the input
     * constraints.</p>
     *
     * @param countries
     *            the countries
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getDirectInvestmentsByCountryYears(Collection<String> countries,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Land", countries);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FM0001T04", mappings);
    }

    /**
     * <p>Fetch all direct investments by economic activity (NACE 2002) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getDirectInvestmentsByEconomicActivityNACE2002(Collection, Collection)
     */
    public List<ResponseModel> getDirectInvestmentsByEconomicActivityNACE2002() {
        return getDirectInvestmentsByEconomicActivityNACE2002(null, null);
    }

    /**
     * <p>Fetch all direct investments by economic activity (NACE 2002) data which match
     * the input constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getDirectInvestmentsByEconomicActivityNACE2002(
            Collection<String> industrialClassifications, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2002_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FM0001SNI02T03", mappings);
    }

    /**
     * <p>Fetch all direct investments by investment item data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getDirectInvestmentsByInvestmentItem(Collection, Collection)
     */
    public List<ResponseModel> getDirectInvestmentsByInvestmentItem() {
        return getDirectInvestmentsByInvestmentItem(null, null);
    }

    /**
     * <p>Fetch all direct investments by investment item data which match the input
     * constraints.</p>
     *
     * @param investments
     *            the investments
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getDirectInvestmentsByInvestmentItem(Collection<String> investments,
            Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Investeringsposter", investments);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("FM0001T01", mappings);
    }

    /**
     * <p>Fetch all direct investments by country (quarters) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getDirectInvestmentsByCountryQuarters(Collection, Collection)
     */
    public List<ResponseModel> getDirectInvestmentsByCountryQuarters() {
        return getDirectInvestmentsByCountryQuarters(null, null);
    }

    /**
     * <p>Fetch all direct investments by country (quarters) data which match the input
     * constraints.</p>
     *
     * @param countries
     *            the countries
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getDirectInvestmentsByCountryQuarters(Collection<String> countries,
            Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Land", countries);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("FM0001T04Kv", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM0001/FM0001D/");
    }

}
