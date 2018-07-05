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

package com.github.dannil.scbjavaclient.client.financialmarkets.investmentfunds;

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
 * <p>Client which handles financial markets investment funds data fetching.</p>
 *
 * @since 0.2.0
 */
public class FinancialMarketsInvestmentFundsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public FinancialMarketsInvestmentFundsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsInvestmentFundsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all ownership of investment fund data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getOwnershipOfInvestmentFund(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getOwnershipOfInvestmentFund() {
        return getOwnershipOfInvestmentFund(null, null, null, null);
    }

    /**
     * <p>Fetch all ownership of investment fund data which match the input
     * constraints.</p>
     *
     * @param observations
     *            the observations to fetch data for
     * @param types
     *            the types to fetch data for
     * @param sectors
     *            the sectors to fetch data for
     * @param quarters
     *            the quarters to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getOwnershipOfInvestmentFund(Collection<String> observations, Collection<String> types,
            Collection<String> sectors, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Innehall", observations);
        mappings.put("Fondtyp", types);
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("F813FondKv", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM0403/");
    }

}
