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

package com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.internationalinvestmentposition;

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
 * <p>Client which handles financial markets balance of payments international investment
 * position data fetching.</p>
 *
 * @since 0.4.0
 */
public class FinancialMarketsBalanceOfPaymentsInternationalInvestmentPositionClient extends AbstractClient {

    private static final String ASSETSANDLIABILITIES_CODE = "TillgangSkuld";

    /**
     * <p>Default constructor.</p>
     */
    public FinancialMarketsBalanceOfPaymentsInternationalInvestmentPositionClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsBalanceOfPaymentsInternationalInvestmentPositionClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all revisions data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getRevisions(Collection, Collection, Collection)
     */
    public List<ResponseModel> getRevisions() {
        return getRevisions(null, null, null);
    }

    /**
     * <p>Fetch all revisions data which match the input constraints.</p>
     *
     * @param assetsAndLiabilities
     *            the assets and liabilities
     * @param items
     *            the items
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getRevisions(Collection<String> assetsAndLiabilities, Collection<String> items,
            Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(ASSETSANDLIABILITIES_CODE, assetsAndLiabilities);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("FM0001UtlRevKv", mappings);
    }

    /**
     * <p>Fetch all assets and liabilities by sectors (quarters) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAssetsAndLiabilitiesBySectorsQuarters(Collection, Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getAssetsAndLiabilitiesBySectorsQuarters() {
        return getAssetsAndLiabilitiesBySectorsQuarters(null, null, null, null);
    }

    /**
     * <p>Fetch all assets and liabilities by sectors (quarters) data which match the
     * input constraints.</p>
     *
     * @param assetsAndLiabilities
     *            the assets and liabilities
     * @param sectors
     *            the sectors
     * @param items
     *            the items
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAssetsAndLiabilitiesBySectorsQuarters(Collection<String> assetsAndLiabilities,
            Collection<Integer> sectors, Collection<String> items, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(ASSETSANDLIABILITIES_CODE, assetsAndLiabilities);
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("FM0001UtlSektorKv", mappings);
    }

    /**
     * <p>Fetch all assets and liabilities by currencies (years) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAssetsAndLiabilitiesByCurrenciesYears(Collection, Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getAssetsAndLiabilitiesByCurrenciesYears() {
        return getAssetsAndLiabilitiesByCurrenciesYears(null, null, null, null);
    }

    /**
     * <p>Fetch all assets and liabilities by currencies (years) data which match the
     * input constraints.</p>
     *
     * @param assetsAndLiabilities
     *            the assets and liabilities
     * @param currencies
     *            the currencies
     * @param items
     *            the items
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAssetsAndLiabilitiesByCurrenciesYears(Collection<String> assetsAndLiabilities,
            Collection<String> currencies, Collection<String> items, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(ASSETSANDLIABILITIES_CODE, assetsAndLiabilities);
        mappings.put("DenomValuta", currencies);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FM0001UtlTSVKAr", mappings);
    }

    /**
     * <p>Fetch all gross external debt data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getGrossExternalDebt(Collection, Collection)
     */
    public List<ResponseModel> getGrossExternalDebt() {
        return getGrossExternalDebt(null, null);
    }

    /**
     * <p>Fetch all gross external debt data which match the input constraints.</p>
     *
     * @param items
     *            the items
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getGrossExternalDebt(Collection<String> items, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("FM0001RSkuldKv", mappings);
    }

    /**
     * <p>Fetch all assets and liabilities by sectors (years) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAssetsAndLiabilitiesBySectorsYears(Collection, Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getAssetsAndLiabilitiesBySectorsYears() {
        return getAssetsAndLiabilitiesBySectorsYears(null, null, null, null);
    }

    /**
     * <p>Fetch all assets and liabilities by sectors (years) data which match the input
     * constraints.</p>
     *
     * @param assetsAndLiabilities
     *            the assets and liabilities
     * @param sectors
     *            the sectors
     * @param items
     *            the items
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAssetsAndLiabilitiesBySectorsYears(Collection<String> assetsAndLiabilities,
            Collection<Integer> sectors, Collection<String> items, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(ASSETSANDLIABILITIES_CODE, assetsAndLiabilities);
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FM0001UtlSektorAr", mappings);
    }

    /**
     * <p>Fetch all assets and liabilities with direct investments data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAssetsAndLiabilitiesWithDirectInvestments(Collection, Collection,
     *      Collection, Collection)
     */
    public List<ResponseModel> getAssetsAndLiabilitiesWithDirectInvestments() {
        return getAssetsAndLiabilitiesWithDirectInvestments(null, null, null, null);
    }

    /**
     * <p>Fetch all assets and liabilities with direct investments data which match the
     * input constraints.</p>
     *
     * @param assetsAndLiabilities
     *            the assets and liabilities
     * @param currencies
     *            the currencies
     * @param items
     *            the items
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAssetsAndLiabilitiesWithDirectInvestments(Collection<String> assetsAndLiabilities,
            Collection<String> currencies, Collection<String> items, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(ASSETSANDLIABILITIES_CODE, assetsAndLiabilities);
        mappings.put("Valuta", currencies);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FM0001UtlStMVAr", mappings);
    }

    /**
     * <p>Fetch all assets and liabilities by currencies (quarters) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAssetsAndLiabilitiesByCurrenciesQuarters(Collection, Collection,
     *      Collection, Collection)
     */
    public List<ResponseModel> getAssetsAndLiabilitiesByCurrenciesQuarters() {
        return getAssetsAndLiabilitiesByCurrenciesQuarters(null, null, null, null);
    }

    /**
     * <p>Fetch all assets and liabilities by currencies (quarters) data which match the
     * input constraints.</p>
     *
     * @param assetsAndLiabilities
     *            the assets and liabilities
     * @param currencies
     *            the currencies
     * @param items
     *            the items
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAssetsAndLiabilitiesByCurrenciesQuarters(Collection<String> assetsAndLiabilities,
            Collection<String> currencies, Collection<String> items, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(ASSETSANDLIABILITIES_CODE, assetsAndLiabilities);
        mappings.put("DenomValuta", currencies);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("FM0001UtlTSVKKv", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM0001/FM0001B/");
    }

}
