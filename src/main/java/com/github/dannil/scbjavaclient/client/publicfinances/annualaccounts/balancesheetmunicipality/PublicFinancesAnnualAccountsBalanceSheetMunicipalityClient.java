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

package com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.balancesheetmunicipality;

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
 * <p>Client which handles public finances annual accounts balance sheet municipality data
 * fetching.</p>
 *
 * @since 0.3.0
 */
public class PublicFinancesAnnualAccountsBalanceSheetMunicipalityClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PublicFinancesAnnualAccountsBalanceSheetMunicipalityClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PublicFinancesAnnualAccountsBalanceSheetMunicipalityClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all income statements data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getIncomeStatements(Collection, Collection, Collection)
     */
    public List<ResponseModel> getIncomeStatements() {
        return getIncomeStatements(null, null, null);
    }

    /**
     * <p>Fetch all income statements data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param incomeStatements
     *            the income statements
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getIncomeStatements(Collection<String> regions, Collection<String> incomeStatements,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Resultatraknposter", incomeStatements);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("ResultKn", mappings);
    }

    // Daniel 2017-04-17: Returns HTTP 403
    /**
     * <p>Fetch all balance sheet data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getBalanceSheet(Collection, Collection, Collection)
     */
    public List<ResponseModel> getBalanceSheet() {
        return getBalanceSheet(null, null, null);
    }

    /**
     * <p>Fetch all balance sheet data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param balanceSheets
     *            the balance sheets
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getBalanceSheet(Collection<String> regions, Collection<String> balanceSheets,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Balansraknposter", balanceSheets);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BalansKn", mappings);
    }

    /**
     * <p>Fetch all guarantees and contingent liabilities data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getGuaranteesAndContingentLiabilities(Collection, Collection, Collection)
     */
    public List<ResponseModel> getGuaranteesAndContingentLiabilities() {
        return getGuaranteesAndContingentLiabilities(null, null, null);
    }

    /**
     * <p>Fetch all guarantees and contingent liabilities data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param typesOfGuarantees
     *            the types of guarantees
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getGuaranteesAndContingentLiabilities(Collection<String> regions,
            Collection<Integer> typesOfGuarantees, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("BorgenAnsvarsposter", typesOfGuarantees);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BorgensforbKn", mappings);
    }

    /**
     * <p>Fetch all local government incomes data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getLocalGovernmentIncomes(Collection, Collection, Collection)
     */
    public List<ResponseModel> getLocalGovernmentIncomes() {
        return getLocalGovernmentIncomes(null, null, null);
    }

    /**
     * <p>Fetch all local government incomes data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param items
     *            the items
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getLocalGovernmentIncomes(Collection<String> regions, Collection<Integer> items,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("VerksInt", mappings);
    }

    /**
     * <p>Fetch all municipalities costs data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getMunicipalitiesCosts(Collection, Collection, Collection)
     */
    public List<ResponseModel> getMunicipalitiesCosts() {
        return getMunicipalitiesCosts(null, null, null);
    }

    /**
     * <p>Fetch all municipalities costs data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param items
     *            the items
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getMunicipalitiesCosts(Collection<String> regions, Collection<Integer> items,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("VerksKostn", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("OE/OE0107/OE0107A/");
    }

}
