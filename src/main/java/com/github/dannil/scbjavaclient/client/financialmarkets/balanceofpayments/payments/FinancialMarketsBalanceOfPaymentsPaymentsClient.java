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

package com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.payments;

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
 * Client which handles financial markets balance of payments payments data
 * fetching.
 *
 * @since 0.4.0
 */
public class FinancialMarketsBalanceOfPaymentsPaymentsClient extends AbstractClient {

    private static final String EXPORTANDIMPORT_CODE = "ExpImp";

    /**
     * Default constructor.
     */
    public FinancialMarketsBalanceOfPaymentsPaymentsClient() {
        super();
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsBalanceOfPaymentsPaymentsClient(Locale locale) {
        super(locale);
    }

    /**
     * Fetch all transactions quarters data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTransactionsQuarters(Collection, Collection)
     */
    public List<ResponseModel> getTransactionsQuarters() {
        return getTransactionsQuarters(null, null);
    }

    /**
     * Fetch all transactions quarters data which match the input constraints.
     *
     * @param items
     *            the items
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTransactionsQuarters(Collection<String> items, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("FM0001BetBalKv", mappings);
    }

    /**
     * Fetch all seasonally adjusted current account and capital account data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getSeasonallyAdjustedCurrentAccountAndCapitalAccount(Collection, Collection)
     */
    public List<ResponseModel> getSeasonallyAdjustedCurrentAccountAndCapitalAccount() {
        return getSeasonallyAdjustedCurrentAccountAndCapitalAccount(null, null);
    }

    /**
     * Fetch all seasonally adjusted current account and capital account data which
     * match the input constraints.
     *
     * @param items
     *            the items
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getSeasonallyAdjustedCurrentAccountAndCapitalAccount(Collection<String> items,
            Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("FM0001BetSasRKv", mappings);
    }

    /**
     * Fetch all current accounts quarters data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getCurrentAccountsQuarters(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getCurrentAccountsQuarters() {
        return getCurrentAccountsQuarters(null, null, null, null);
    }

    /**
     * Fetch all current accounts quarters data which match the input constraints.
     *
     * @param countryGroups
     *            the country groups
     * @param exportsAndImports
     *            the exports and imports
     * @param items
     *            the items
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getCurrentAccountsQuarters(Collection<String> countryGroups,
            Collection<String> exportsAndImports, Collection<String> items, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Landgrupp", countryGroups);
        mappings.put(EXPORTANDIMPORT_CODE, exportsAndImports);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("FM0001BytBKv", mappings);
    }

    /**
     * Fetch all financial accounts quarters data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getFinancialAccountsQuarters(Collection, Collection, Collection)
     */
    public List<ResponseModel> getFinancialAccountsQuarters() {
        return getFinancialAccountsQuarters(null, null, null);
    }

    /**
     * Fetch all financial accounts quarters data which match the input
     * constraints.
     *
     * @param typesOfInvestments
     *            the types of investments
     * @param items
     *            the items
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getFinancialAccountsQuarters(Collection<String> typesOfInvestments,
            Collection<String> items, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Investering", typesOfInvestments);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("FM0001FinansBKv", mappings);
    }

    /**
     * Fetch all secondary income and capital accounts data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getSecondaryIncomeAndCapitalAccounts(Collection, Collection, Collection)
     */
    public List<ResponseModel> getSecondaryIncomeAndCapitalAccounts() {
        return getSecondaryIncomeAndCapitalAccounts(null, null, null);
    }

    /**
     * Fetch all secondary income and capital accounts data which match the input
     * constraints.
     *
     * @param transactions
     *            the transactions
     * @param items
     *            the items
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getSecondaryIncomeAndCapitalAccounts(Collection<String> transactions,
            Collection<String> items, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Transaktioner", transactions);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("FM0001SInkomstKv", mappings);
    }

    /**
     * Fetch all transactions years data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTransactionsYears(Collection, Collection)
     */
    public List<ResponseModel> getTransactionsYears() {
        return getTransactionsYears(null, null);
    }

    /**
     * Fetch all transactions years data which match the input constraints.
     *
     * @param items
     *            the items
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTransactionsYears(Collection<String> items, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FM0001BetBalAr", mappings);
    }

    /**
     * Fetch all revisions data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getRevisions(Collection, Collection)
     */
    public List<ResponseModel> getRevisions() {
        return getRevisions(null, null);
    }

    /**
     * Fetch all revisions data which match the input constraints.
     *
     * @param items
     *            the items
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getRevisions(Collection<String> items, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("FM0001BetBalRevKv", mappings);
    }

    /**
     * Fetch all current accounts years data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getCurrentAccountsYears(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getCurrentAccountsYears() {
        return getCurrentAccountsYears(null, null, null, null);
    }

    /**
     * Fetch all current accounts years data which match the input constraints.
     *
     * @param countryGroups
     *            the country groups
     * @param exportsAndImports
     *            the exports and imports
     * @param items
     *            the items
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getCurrentAccountsYears(Collection<String> countryGroups,
            Collection<String> exportsAndImports, Collection<String> items, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Landgrupp", countryGroups);
        mappings.put(EXPORTANDIMPORT_CODE, exportsAndImports);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FM0001BytBAr", mappings);
    }

    /**
     * Fetch all financial accounts years data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getFinancialAccountsYears(Collection, Collection, Collection)
     */
    public List<ResponseModel> getFinancialAccountsYears() {
        return getFinancialAccountsYears(null, null, null);
    }

    /**
     * Fetch all financial accounts years data which match the input constraints.
     *
     * @param typesOfInvestments
     *            the types of investments
     * @param items
     *            the items
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getFinancialAccountsYears(Collection<String> typesOfInvestments,
            Collection<String> items, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Investering", typesOfInvestments);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FM0001FinansBAr", mappings);
    }

    /**
     * Fetch all primary income data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPrimaryIncome(Collection, Collection, Collection)
     */
    public List<ResponseModel> getPrimaryIncome() {
        return getPrimaryIncome(null, null, null);
    }

    /**
     * Fetch all primary income data which match the input constraints.
     *
     * @param exportsAndImports
     *            the exports and imports
     * @param items
     *            the items
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPrimaryIncome(Collection<String> exportsAndImports, Collection<String> items,
            Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(EXPORTANDIMPORT_CODE, exportsAndImports);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("FM0001PInkomstKv", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM0001/FM0001A/");
    }

}
