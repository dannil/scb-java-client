/*
 * Copyright 2018 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.businessactivities.ordersandturnover.ordersandturnover;

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
 * <p>Client which handles business activities orders and turnover orders and turnover
 * data fetching.</p>
 *
 * @since 0.7.0
 */
public class BusinessActivitiesOrdersAndTurnoverOrdersAndTurnoverClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public BusinessActivitiesOrdersAndTurnoverOrdersAndTurnoverClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public BusinessActivitiesOrdersAndTurnoverOrdersAndTurnoverClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all turnover in industry SNI 2007 monthly data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTurnoverInIndustrySNI2007Monthly(Collection, Collection, Collection)
     */
    public List<ResponseModel> getTurnoverInIndustrySNI2007Monthly() {
        return getTurnoverInIndustrySNI2007Monthly(null, null, null);
    }

    /**
     * <p>Fetch all turnover in industry SNI 2007 monthly data which match the input
     * constraints.</p>
     *
     * @param markets
     *            the markets
     * @param industrialClassifications
     *            the industrial classifications
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTurnoverInIndustrySNI2007Monthly(Collection<String> markets,
            Collection<String> industrialClassifications, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.MARKET_CODE, markets);
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("IndLev2010M", mappings);
    }

    /**
     * <p>Fetch all orders in industry SNI 2007 monthly data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getOrdersInIndustrySNI2007Monthly(Collection, Collection, Collection)
     */
    public List<ResponseModel> getOrdersInIndustrySNI2007Monthly() {
        return getOrdersInIndustrySNI2007Monthly(null, null, null);
    }

    /**
     * <p>Fetch all orders in industry SNI 2007 monthly data which match the input
     * constraints.</p>
     *
     * @param markets
     *            the markets
     * @param industrialClassifications
     *            the industrial classifications
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getOrdersInIndustrySNI2007Monthly(Collection<String> markets,
            Collection<String> industrialClassifications, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.MARKET_CODE, markets);
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("IndOrd2010M", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/NV0501/NV0501A/");
    }

}
