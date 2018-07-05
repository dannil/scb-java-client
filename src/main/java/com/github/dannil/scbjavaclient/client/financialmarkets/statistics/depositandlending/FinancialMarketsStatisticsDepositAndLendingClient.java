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

package com.github.dannil.scbjavaclient.client.financialmarkets.statistics.depositandlending;

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
 * <p>Client which handles financial markets statistics deposit and lending data
 * fetching.</p>
 *
 * @since 0.5.0
 */
public class FinancialMarketsStatisticsDepositAndLendingClient extends AbstractClient {

    private static final String AGREEMENT_CODE = "Avtal";

    private static final String COUNTERPARTYSECTOR_CODE = "Motpartssektor";

    private static final String ORIGINALRATEFIXATIONS_CODE = "Rantebindningstid";

    private static final String REFERENCESECTOR_CODE = "Referenssektor";

    /**
     * <p>Default constructor.</p>
     */
    public FinancialMarketsStatisticsDepositAndLendingClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsStatisticsDepositAndLendingClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all lending rates breakdown by remaining maturity data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getLendingRatesBreakdownByRemainingMaturity(Collection, Collection,
     *      Collection, Collection)
     */
    public List<ResponseModel> getLendingRatesBreakdownByRemainingMaturity() {
        return getLendingRatesBreakdownByRemainingMaturity(null, null, null, null);
    }

    /**
     * <p>Fetch all lending rates breakdown by remaining maturity data which match the
     * input constraints.</p>
     *
     * @param referenceSectors
     *            the reference sectors
     * @param counterpartySectors
     *            the counterparty sectors
     * @param remainingMaturity
     *            the remaining maturity
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getLendingRatesBreakdownByRemainingMaturity(Collection<String> referenceSectors,
            Collection<Integer> counterpartySectors, Collection<String> remainingMaturity, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(REFERENCESECTOR_CODE, referenceSectors);
        mappings.put(COUNTERPARTYSECTOR_CODE, counterpartySectors);
        mappings.put("AterstRantebtid", remainingMaturity);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("RantaT02", mappings);
    }

    /**
     * <p>Fetch all lending rates to households for housing loans breakdown by maturity
     * data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getLendingRatesToHouseholdsForHousingLoansBreakdownByMaturity(Collection,
     *      Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getLendingRatesToHouseholdsForHousingLoansBreakdownByMaturity() {
        return getLendingRatesToHouseholdsForHousingLoansBreakdownByMaturity(null, null, null, null, null);
    }

    /**
     * <p>Fetch all lending rates to households for housing loans breakdown by maturity
     * data which match the input constraints.</p>
     *
     * @param referenceSectors
     *            the reference sectors
     * @param counterpartySectors
     *            the counterparty sectors
     * @param agreements
     *            the agreements
     * @param originalRateFixations
     *            the original rate fixations
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getLendingRatesToHouseholdsForHousingLoansBreakdownByMaturity(
            Collection<String> referenceSectors, Collection<String> counterpartySectors, Collection<String> agreements,
            Collection<String> originalRateFixations, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(REFERENCESECTOR_CODE, referenceSectors);
        mappings.put(COUNTERPARTYSECTOR_CODE, counterpartySectors);
        mappings.put(AGREEMENT_CODE, agreements);
        mappings.put(ORIGINALRATEFIXATIONS_CODE, originalRateFixations);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("RantaT04", mappings);
    }

    // Daniel 2017-08-29:
    // Throws HTTP 403
    //
    /**
     * <p>Fetch all lending rates to households and non-financial corporations breakdown
     * by maturity data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getLendingRatesToHouseholdsAndNonFinancialCorporationsBreakdownByMaturity(Collection,
     *      Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getLendingRatesToHouseholdsAndNonFinancialCorporationsBreakdownByMaturity() {
        return getLendingRatesToHouseholdsAndNonFinancialCorporationsBreakdownByMaturity(null, null, null, null, null);
    }

    /**
     * <p>Fetch all lending rates to households and non-financial corporations breakdown
     * by maturity data which match the input constraints.</p>
     *
     * @param referenceSectors
     *            the reference sectors
     * @param counterpartySectors
     *            the counterparty sectors
     * @param agreements
     *            the agreements
     * @param originalRateFixations
     *            the original rate fixations
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getLendingRatesToHouseholdsAndNonFinancialCorporationsBreakdownByMaturity(
            Collection<String> referenceSectors, Collection<String> counterpartySectors, Collection<String> agreements,
            Collection<String> originalRateFixations, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(REFERENCESECTOR_CODE, referenceSectors);
        mappings.put(COUNTERPARTYSECTOR_CODE, counterpartySectors);
        mappings.put(AGREEMENT_CODE, agreements);
        mappings.put(ORIGINALRATEFIXATIONS_CODE, originalRateFixations);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("RantaT01", mappings);
    }

    /**
     * <p>Fetch all lending rates breakdown by purpose data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getLendingRatesBreakdownByPurpose(Collection, Collection, Collection,
     *      Collection, Collection)
     */
    public List<ResponseModel> getLendingRatesBreakdownByPurpose() {
        return getLendingRatesBreakdownByPurpose(null, null, null, null, null);
    }

    /**
     * <p>Fetch all lending rates breakdown by purpose data which match the input
     * constraints.</p>
     *
     * @param referenceSectors
     *            the reference sectors
     * @param counterpartySectors
     *            the counterparty sectors
     * @param agreements
     *            the agreements
     * @param purposes
     *            the purposes
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getLendingRatesBreakdownByPurpose(Collection<String> referenceSectors,
            Collection<String> counterpartySectors, Collection<String> agreements, Collection<String> purposes,
            Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(REFERENCESECTOR_CODE, referenceSectors);
        mappings.put(COUNTERPARTYSECTOR_CODE, counterpartySectors);
        mappings.put(AGREEMENT_CODE, agreements);
        mappings.put("Andamal", purposes);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("RantaT03", mappings);
    }

    /**
     * <p>Fetch all banks deposit rates data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getBanksDepositRates(Collection, Collection, Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getBanksDepositRates() {
        return getBanksDepositRates(null, null, null, null, null);
    }

    /**
     * <p>Fetch all banks deposit rates data which match the input constraints.</p>
     *
     * @param referenceSectors
     *            the reference sectors
     * @param counterpartySectors
     *            the counterparty sectors
     * @param agreements
     *            the agreements
     * @param originalRateFixations
     *            the original rate fixations
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getBanksDepositRates(Collection<String> referenceSectors,
            Collection<Integer> counterpartySectors, Collection<String> agreements,
            Collection<Integer> originalRateFixations, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(REFERENCESECTOR_CODE, referenceSectors);
        mappings.put(COUNTERPARTYSECTOR_CODE, counterpartySectors);
        mappings.put(AGREEMENT_CODE, agreements);
        mappings.put(ORIGINALRATEFIXATIONS_CODE, originalRateFixations);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("RantaT05", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM5001/FM5001C/");
    }

}
