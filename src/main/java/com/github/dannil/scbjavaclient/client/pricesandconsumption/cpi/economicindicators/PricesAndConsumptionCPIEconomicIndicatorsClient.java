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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.economicindicators;

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
 * <p>Client which handles prices and consumption Consumer Price Index (CPI) economic
 * indicators data fetching.</p>
 *
 * @since 0.4.0
 */
public class PricesAndConsumptionCPIEconomicIndicatorsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PricesAndConsumptionCPIEconomicIndicatorsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PricesAndConsumptionCPIEconomicIndicatorsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all consumer price index data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getConsumerPriceIndex(Collection, Collection)
     */
    public List<ResponseModel> getConsumerPriceIndex() {
        return getConsumerPriceIndex(null, null);
    }

    /**
     * <p>Fetch all consumer price index data which match the input constraints.</p>
     *
     * @param indicators
     *            the indicators
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getConsumerPriceIndex(Collection<String> indicators, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.ECONOMICINDICATOR_CODE, indicators);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("SnabbStatPR0101", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("PR/PR0101/PR0101S");
    }

}
