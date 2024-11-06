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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.pricebasicamount;

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
 * Client which handles prices and consumption Consumer Price Index (CPI) Price Basic
 * Amount data fetching.
 *
 * @since 0.4.0
 */
public class PricesAndConsumptionCPIPriceBasicAmountClient extends AbstractClient {

    /**
     * Default constructor.
     */
    public PricesAndConsumptionCPIPriceBasicAmountClient() {
        super();
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PricesAndConsumptionCPIPriceBasicAmountClient(Locale locale) {
        super(locale);
    }

    /**
     * Fetch all price basic amount data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPriceBasicAmount(Collection)
     */
    public List<ResponseModel> getPriceBasicAmount() {
        return getPriceBasicAmount(null);
    }

    /**
     * Fetch all price basic amount data which match the input constraints.
     *
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPriceBasicAmount(Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Basbeloppet", mappings);
    }

    /**
     * Fetch all increased price basic amount data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getIncreasedPriceBasicAmount(Collection)
     */
    public List<ResponseModel> getIncreasedPriceBasicAmount() {
        return getIncreasedPriceBasicAmount(null);
    }

    /**
     * Fetch all increased price basic amount data which match the input
     * constraints.
     *
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getIncreasedPriceBasicAmount(Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Basbelopp", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("PR/PR0101/PR0101E/");
    }

}
