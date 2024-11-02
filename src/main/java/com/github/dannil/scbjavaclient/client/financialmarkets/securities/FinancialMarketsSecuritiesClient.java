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

package com.github.dannil.scbjavaclient.client.financialmarkets.securities;

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
 * Client which handles financial markets securities data fetching.
 *
 * @since 0.2.0
 */
public class FinancialMarketsSecuritiesClient extends AbstractClient {

    /**
     * Default constructor.
     */
    public FinancialMarketsSecuritiesClient() {
        super();
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsSecuritiesClient(Locale locale) {
        super(locale);
    }

    /**
     * Fetch all maturity structure data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getMaturityStructure(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getMaturityStructure() {
        return getMaturityStructure(null, null, null, null);
    }

    /**
     * Fetch all maturity structure data which match the input constraints.
     *
     * @param sectors
     *            the sectors to fetch data for
     * @param maturities
     *            the maturities to fetch data for
     * @param currencies
     *            the currencies to fetch data for
     * @param months
     *            the months to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getMaturityStructure(Collection<Integer> sectors, Collection<String> maturities,
            Collection<String> currencies, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put("Forfall", maturities);
        mappings.put("Valuta", currencies);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("FM9998T02", mappings);
    }

    /**
     * Fetch all outstanding and issued amount data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getOutstandingAndIssuedAmount(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getOutstandingAndIssuedAmount() {
        return getOutstandingAndIssuedAmount(null, null, null, null);
    }

    /**
     * Fetch all outstanding and issued amount data which match the input
     * constraints.
     *
     * @param sectors
     *            the sectors to fetch data for
     * @param items
     *            the items to fetch data for
     * @param currencies
     *            the currencies to fetch data for
     * @param months
     *            the months to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getOutstandingAndIssuedAmount(Collection<Integer> sectors, Collection<String> items,
            Collection<String> currencies, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put("Valuta", currencies);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("FM9998T01", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM9998/");
    }

}
