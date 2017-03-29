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
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.http.EndpointURL;
import com.github.dannil.scbjavaclient.model.financialmarkets.securities.MaturityStructure;
import com.github.dannil.scbjavaclient.model.financialmarkets.securities.OutstandingAndIssuedAmount;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles financial markets securities data fetching.</p>
 *
 * @since 0.2.0
 */
public class FinancialMarketsSecuritiesClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public FinancialMarketsSecuritiesClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsSecuritiesClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all maturity structure data.</p>
     *
     * @return the maturity structure data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.financialmarkets.securities.MaturityStructure
     *         MaturityStructure} objects
     *
     * @see #getMaturityStructure(Collection, Collection, Collection, Collection)
     */
    public List<MaturityStructure> getMaturityStructure() {
        return getMaturityStructure(null, null, null, null);
    }

    /**
     * <p>Fetch all maturity structure data which match the input constraints.</p>
     *
     * @param sectors
     *            the sectors to fetch data for
     * @param maturities
     *            the maturities to fetch data for
     * @param currencies
     *            the currencies to fetch data for
     * @param months
     *            the months to fetch data for
     * @return the maturity structure data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.financialmarkets.securities.MaturityStructure
     *         MaturityStructure} objects
     */
    public List<MaturityStructure> getMaturityStructure(Collection<Integer> sectors, Collection<String> maturities,
            Collection<String> currencies, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Sektor", sectors);
        mappings.put("Forfall", maturities);
        mappings.put("Valuta", currencies);
        mappings.put(APIConstants.TIME_CODE, months);

        String response = doPostRequest(getUrl() + "FM9998T02", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(MaturityStructure.class);
    }

    /**
     * <p>Fetch all outstanding and issued amount data.</p>
     *
     * @return the outstanding and issued amount data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.financialmarkets.securities.OutstandingAndIssuedAmount
     *         OutstandingAndIssuedAmount} objects
     *
     * @see #getOutstandingAndIssuedAmount(Collection, Collection, Collection, Collection)
     */
    public List<OutstandingAndIssuedAmount> getOutstandingAndIssuedAmount() {
        return getOutstandingAndIssuedAmount(null, null, null, null);
    }

    /**
     * <p>Fetch all outstanding and issued amount data which match the input
     * constraints.</p>
     *
     * @param sectors
     *            the sectors to fetch data for
     * @param items
     *            the items to fetch data for
     * @param currencies
     *            the currencies to fetch data for
     * @param months
     *            the months to fetch data for
     * @return the outstanding and issued amount data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.financialmarkets.securities.OutstandingAndIssuedAmount
     *         OutstandingAndIssuedAmount} objects
     */
    public List<OutstandingAndIssuedAmount> getOutstandingAndIssuedAmount(Collection<Integer> sectors,
            Collection<String> items, Collection<String> currencies, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Sektor", sectors);
        mappings.put("Kontopost", items);
        mappings.put("Valuta", currencies);
        mappings.put(APIConstants.TIME_CODE, months);

        String response = doPostRequest(getUrl() + "FM9998T01", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(OutstandingAndIssuedAmount.class);
    }

    @Override
    public EndpointURL getUrl() {
        return getRootUrl().append("FM/FM9998/");
    }

}
