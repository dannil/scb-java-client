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

package com.github.dannil.scbjavaclient.client.financialmarkets.enterprises;

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
 * <p>Client which handles financial markets enterprises data fetching.</p>
 *
 * @since 0.4.0
 */
public class FinancialMarketsEnterprisesClient extends AbstractClient {

    private static final String INSTITUTE_CODE = "Finansinstitut";

    /**
     * <p>Default constructor.</p>
     */
    public FinancialMarketsEnterprisesClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsEnterprisesClient(Locale locale) {
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
     * @param institutes
     *            the institutes
     * @param items
     *            the items
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getIncomeStatements(Collection<String> institutes, Collection<String> items,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(INSTITUTE_CODE, institutes);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FinResAr", mappings);
    }

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
     * @param institutes
     *            the institutes
     * @param items
     *            the items
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getBalanceSheet(Collection<String> institutes, Collection<String> items,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(INSTITUTE_CODE, institutes);
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FinBalAr", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM0402/");
    }

}
