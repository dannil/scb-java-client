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

package com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.economicindicators;

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
 * <p>Client which handles financial markets balance of payments economic indicators data
 * fetching.</p>
 *
 * @since 0.4.0
 */
public class FinancialMarketsBalanceOfPaymentsEconomicIndicatorsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public FinancialMarketsBalanceOfPaymentsEconomicIndicatorsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsBalanceOfPaymentsEconomicIndicatorsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all balance of payments net data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getBalanceOfPaymentsNet(Collection, Collection)
     */
    public List<ResponseModel> getBalanceOfPaymentsNet() {
        return getBalanceOfPaymentsNet(null, null);
    }

    /**
     * <p>Fetch all balance of payments net data which match the input constraints.</p>
     *
     * @param indicators
     *            the indicators
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getBalanceOfPaymentsNet(Collection<String> indicators, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.ECONOMICINDICATOR_CODE, indicators);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("SnabbStatFM0001", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM0001/FM0001S/");
    }

}
