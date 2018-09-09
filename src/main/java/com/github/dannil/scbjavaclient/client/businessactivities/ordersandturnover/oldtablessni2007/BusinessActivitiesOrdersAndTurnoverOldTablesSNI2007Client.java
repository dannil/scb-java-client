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

package com.github.dannil.scbjavaclient.client.businessactivities.ordersandturnover.oldtablessni2007;

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
 * <p>Client which handles business activities orders and turnover old tables SNI 2007
 * data fetching.</p>
 *
 * @since 0.7.0
 */
public class BusinessActivitiesOrdersAndTurnoverOldTablesSNI2007Client extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public BusinessActivitiesOrdersAndTurnoverOldTablesSNI2007Client() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public BusinessActivitiesOrdersAndTurnoverOldTablesSNI2007Client(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all turnover in industry fixed prices SNI 2007 annual data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTurnoverInIndustryFixedPricesSNI2007Annual(Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getTurnoverInIndustryFixedPricesSNI2007Annual() {
        return getTurnoverInIndustryFixedPricesSNI2007Annual(null, null, null);
    }

    /**
     * <p>Fetch all turnover in industry fixed prices SNI 2007 annual data which match the
     * input constraints.</p>
     *
     * @param markets
     *            the markets
     * @param industrialClassifications
     *            the industrial classifications
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTurnoverInIndustryFixedPricesSNI2007Annual(Collection<String> markets,
            Collection<String> industrialClassifications, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.MARKET_CODE, markets);
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("IndLev2010Ar", mappings);
    }

    /**
     * <p>Fetch all orders in industry fixed prices SNI 2007 annual data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getOrdersInIndustryFixedPricesSNI2007Annual(Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getOrdersInIndustryFixedPricesSNI2007Annual() {
        return getOrdersInIndustryFixedPricesSNI2007Annual(null, null, null);
    }

    /**
     * <p>Fetch all orders in industry fixed prices SNI 2007 annual data which match the
     * input constraints.</p>
     *
     * @param markets
     *            the markets
     * @param industrialClassifications
     *            the industrial classifications
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getOrdersInIndustryFixedPricesSNI2007Annual(Collection<String> markets,
            Collection<String> industrialClassifications, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.MARKET_CODE, markets);
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("IndOrd2010Ar", mappings);
    }

    /**
     * <p>Fetch all orders and turnover in industry for total industry data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getOrdersAndTurnoverInIndustryForTotalIndustry(Collection, Collection)
     */
    public List<ResponseModel> getOrdersAndTurnoverInIndustryForTotalIndustry() {
        return getOrdersAndTurnoverInIndustryForTotalIndustry(null, null);
    }

    /**
     * <p>Fetch all orders and turnover in industry for total industry data which match
     * the input constraints.</p>
     *
     * @param economicIndicators
     *            the economic indicators
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getOrdersAndTurnoverInIndustryForTotalIndustry(Collection<String> economicIndicators,
            Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.ECONOMICINDICATOR_CODE, economicIndicators);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("SnabbStatNV0501", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/NV0501/NV0501B/");
    }

}
