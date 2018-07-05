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

package com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.statementaccountscounty;

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
 * <p>Client which handles public finances annual accounts statement accounts county data
 * fetching.</p>
 *
 * @since 0.3.0
 */
public class PublicFinancesAnnualAccountsStatementAccountsCountyClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PublicFinancesAnnualAccountsStatementAccountsCountyClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PublicFinancesAnnualAccountsStatementAccountsCountyClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all expenses and revenues data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getExpensesAndRevenues(Collection, Collection, Collection)
     */
    public List<ResponseModel> getExpensesAndRevenues() {
        return getExpensesAndRevenues(null, null, null);
    }

    /**
     * <p>Fetch all expenses and revenues data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param activities
     *            the activities
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getExpensesAndRevenues(Collection<String> regions, Collection<String> activities,
            Collection<Integer> years) {
        return generate(regions, activities, years, "KostnDRLT");
    }

    /**
     * <p>Fetch all net costs data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNetCosts(Collection, Collection, Collection)
     */
    public List<ResponseModel> getNetCosts() {
        return getNetCosts(null, null, null);
    }

    /**
     * <p>Fetch all net costs data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param activities
     *            the activities
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNetCosts(Collection<String> regions, Collection<String> activities,
            Collection<Integer> years) {
        return generate(regions, activities, years, "FinansLT");
    }

    /**
     * <p>Fetch all purchases and sales data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPurchasesAndSales(Collection, Collection, Collection)
     */
    public List<ResponseModel> getPurchasesAndSales() {
        return getPurchasesAndSales(null, null, null);
    }

    /**
     * <p>Fetch all purchases and sales data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param activities
     *            the activities
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPurchasesAndSales(Collection<String> regions, Collection<String> activities,
            Collection<Integer> years) {
        return generate(regions, activities, years, "ForsaljVerksamh");
    }

    /**
     * <p>Fetch all contributions data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getContributions(Collection, Collection, Collection)
     */
    public List<ResponseModel> getContributions() {
        return getContributions(null, null, null);
    }

    /**
     * <p>Fetch all contributions data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param activities
     *            the activities
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getContributions(Collection<String> regions, Collection<String> activities,
            Collection<Integer> years) {
        return generate(regions, activities, years, "LamnadeBidragTotalt");
    }

    /**
     * <p>Fetch all income and costs data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getIncomeAndCosts(Collection, Collection, Collection)
     */
    public List<ResponseModel> getIncomeAndCosts() {
        return getIncomeAndCosts(null, null, null);
    }

    /**
     * <p>Fetch all income and costs data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param activities
     *            the activities
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getIncomeAndCosts(Collection<String> regions, Collection<String> activities,
            Collection<Integer> years) {
        return generate(regions, activities, years, "DriftredovLandst");
    }

    /**
     * <p>Fetch all income and costs data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getInvestments(Collection, Collection, Collection)
     */
    public List<ResponseModel> getInvestments() {
        return getInvestments(null, null, null);
    }

    /**
     * <p>Fetch all income and costs data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param activities
     *            the activities
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getInvestments(Collection<String> regions, Collection<String> activities,
            Collection<Integer> years) {
        return generate(regions, activities, years, "InvestLands");
    }

    /**
     * <p>Common generator method for the methods in this class.</p>
     *
     * @param regions
     *            the regions
     * @param activities
     *            the activities
     * @param years
     *            the years
     * @param table
     *            the table
     * @return a <code>List</code> of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     */
    private List<ResponseModel> generate(Collection<String> regions, Collection<String> activities,
            Collection<Integer> years, String table) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Verksomrkom", activities);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels(table, mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("OE/OE0107/OE0107D/");
    }

}
