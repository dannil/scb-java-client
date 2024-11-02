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

package com.github.dannil.scbjavaclient.client.goodsandservices.turnoverservicesector.turnover;

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
 * Client which handles goods and services turnover service sector turnover data
 * fetching.
 *
 * @since 0.7.0
 */
public class GoodsAndServicesTurnoverServiceSectorTurnoverClient extends AbstractClient {

    /**
     * Default constructor.
     */
    public GoodsAndServicesTurnoverServiceSectorTurnoverClient() {
        super();
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public GoodsAndServicesTurnoverServiceSectorTurnoverClient(Locale locale) {
        super(locale);
    }

    // Daniel, 2018-06-28
    // Returns HTTP 403
    /**
     * Fetch all retail sale index by industry (SIC 2007) monthly data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getRetailSaleIndexSIC2007Monthly(Collection, Collection)
     */
    public List<ResponseModel> getRetailSaleIndexSIC2007Monthly() {
        return getRetailSaleIndexSIC2007Monthly(null, null);
    }

    /**
     * Fetch all retail sale index by industry (SIC 2007) monthly data which match the
     * input constraints.
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getRetailSaleIndexSIC2007Monthly(Collection<String> industrialClassifications,
            Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("Detoms07", mappings);
    }

    /**
     * Fetch all monthly indicator for household consumption data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getMonthlyIndicatorForHouseholdConsumption(Collection, Collection)
     */
    public List<ResponseModel> getMonthlyIndicatorForHouseholdConsumption() {
        return getMonthlyIndicatorForHouseholdConsumption(null, null);
    }

    /**
     * Fetch all monthly indicator for household consumption data which match the input
     * constraints.
     *
     * @param purposes
     *            the purposes
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getMonthlyIndicatorForHouseholdConsumption(Collection<String> purposes,
            Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Andamal", purposes);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("HushKonInd", mappings);
    }

    /**
     * Fetch all turnover index for the service sector by industry (SIC 2007) monthly
     * data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTurnoverIndexForTheServiceSectorSIC2007Monthly(Collection, Collection)
     */
    public List<ResponseModel> getTurnoverIndexForTheServiceSectorSIC2007Monthly() {
        return getTurnoverIndexForTheServiceSectorSIC2007Monthly(null, null);
    }

    /**
     * Fetch all turnover index for the service sector by industry (SIC 2007) monthly
     * data which match the input constraints.
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTurnoverIndexForTheServiceSectorSIC2007Monthly(
            Collection<String> industrialClassifications, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("DivtjansterM07X", mappings);
    }

    /**
     * Fetch all retail trade sales comparison to previous period data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getRetailTradeSales(Collection, Collection)
     */
    public List<ResponseModel> getRetailTradeSales() {
        return getRetailTradeSales(null, null);
    }

    /**
     * Fetch all retail trade sales comparison to previous period data which match the
     * input constraints.
     *
     * @param indicators
     *            the indicators
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getRetailTradeSales(Collection<String> indicators, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.ECONOMICINDICATOR_CODE, indicators);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("SnabbStatHA0101", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("HA/HA0101/HA0101B");
    }

}
