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

package com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.portfolioinvestment;

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
 * <p>Client which handles financial markets balance of payments portfolio investment data
 * fetching.</p>
 *
 * @since 0.4.0
 */
public class FinancialMarketsBalanceOfPaymentsPortfolioInvestmentClient extends AbstractClient {

    private static final String CURRENCY_CODE = "DenomValuta";

    /**
     * <p>Default constructor.</p>
     */
    public FinancialMarketsBalanceOfPaymentsPortfolioInvestmentClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsBalanceOfPaymentsPortfolioInvestmentClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all net flows years data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNetFlowsYears(Collection, Collection, Collection)
     */
    public List<ResponseModel> getNetFlowsYears() {
        return getNetFlowsYears(null, null, null);
    }

    /**
     * <p>Fetch all net flows years data which match the input constraints.</p>
     *
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
    public List<ResponseModel> getNetFlowsYears(Collection<String> currencies, Collection<String> items,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(CURRENCY_CODE, currencies);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FM0001PIAr", mappings);
    }

    // Daniel 2017-06-11: Returns HTTP 403
    /**
     * <p>Fetch all non-resident trade in Swedish shares data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNonResidentTradeInSwedishShares(Collection, Collection, Collection)
     */
    public List<ResponseModel> getNonResidentTradeInSwedishShares() {
        return getNonResidentTradeInSwedishShares(null, null, null);
    }

    /**
     * <p>Fetch all non-resident trade in Swedish shares data which match the input
     * constraints.</p>
     *
     * @param typesOfTrades
     *            the types of trades
     * @param typesOfShares
     *            the types of shares
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNonResidentTradeInSwedishShares(Collection<String> typesOfTrades,
            Collection<String> typesOfShares, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("UtlHandelAktier", typesOfTrades);
        mappings.put("Aktieslag", typesOfShares);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("FM0001PIM", mappings);
    }

    /**
     * <p>Fetch all non-resident holdings of Swedish interest-bearing securities data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNonResidentHoldingsOfSwedishInterestBearingSecurities(Collection,
     *      Collection, Collection, Collection)
     */
    public List<ResponseModel> getNonResidentHoldingsOfSwedishInterestBearingSecurities() {
        return getNonResidentHoldingsOfSwedishInterestBearingSecurities(null, null, null, null);
    }

    /**
     * <p>Fetch all non-resident holdings of Swedish interest-bearing securities data
     * which match the input constraints.</p>
     *
     * @param holdings
     *            the holdings
     * @param sectors
     *            the sectors
     * @param maturities
     *            the maturities
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNonResidentHoldingsOfSwedishInterestBearingSecurities(Collection<String> holdings,
            Collection<String> sectors, Collection<String> maturities, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Innehav", holdings);
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put("Loptid", maturities);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("FM0001DepM", mappings);
    }

    /**
     * <p>Fetch all net flows quarters data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNetFlowsQuarters(Collection, Collection, Collection)
     */
    public List<ResponseModel> getNetFlowsQuarters() {
        return getNetFlowsQuarters(null, null, null);
    }

    /**
     * <p>Fetch all net flows quarters data which match the input constraints.</p>
     *
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
    public List<ResponseModel> getNetFlowsQuarters(Collection<String> currencies, Collection<String> items,
            Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(CURRENCY_CODE, currencies);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("FM0001PIKv", mappings);
    }

    /**
     * <p>Fetch all Swedish portfolio holdings of foreign securities data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getSwedishPortfolioHoldingsOfForeignSecurities(Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getSwedishPortfolioHoldingsOfForeignSecurities() {
        return getSwedishPortfolioHoldingsOfForeignSecurities(null, null, null);
    }

    /**
     * <p>Fetch all Swedish portfolio holdings of foreign securities data which match the
     * input constraints.</p>
     *
     * @param countries
     *            the countries
     * @param securities
     *            the securities
     * @param halfYears
     *            the half years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getSwedishPortfolioHoldingsOfForeignSecurities(Collection<String> countries,
            Collection<String> securities, Collection<String> halfYears) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Land", countries);
        mappings.put("Vardepapper", securities);
        mappings.put(APIConstants.TIME_CODE, halfYears);

        return getResponseModels("FM0001PIUAr", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM0001/FM0001C/");
    }

}
