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
 * <p>Client which handles goods and services turnover service sector turnover data
 * fetching.</p>
 *
 * @since 0.7.0
 */
public class GoodsAndServicesTurnoverServiceSectorTurnoverClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public GoodsAndServicesTurnoverServiceSectorTurnoverClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
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
     * <p>Fetch all retail sale index by industry (SIC 2007) monthly data.</p>
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
     * <p>Fetch all retail sale index by industry (SIC 2007) monthly data which match the
     * input constraints.</p>
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
     * <p>Fetch all retail sale index by industry (SIC 2007) yearly data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getRetailSaleIndexSIC2007Yearly(Collection, Collection)
     */
    public List<ResponseModel> getRetailSaleIndexSIC2007Yearly() {
        return getRetailSaleIndexSIC2007Yearly(null, null);
    }

    /**
     * <p>Fetch all retail sale index by industry (SIC 2007) yearly data which match the
     * input constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getRetailSaleIndexSIC2007Yearly(Collection<String> industrialClassifications,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("DetOmsAr07", mappings);
    }

    /**
     * <p>Fetch all monthly indicator for household consumption data.</p>
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
     * <p>Fetch all monthly indicator for household consumption data which match the input
     * constraints.</p>
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
     * <p>Fetch all turnover index for the service sector by industry (SIC 2007) monthly
     * data.</p>
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
     * <p>Fetch all turnover index for the service sector by industry (SIC 2007) monthly
     * data which match the input constraints.</p>
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
     * <p>Fetch all retail trade sales comparison to previous period data.</p>
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
     * <p>Fetch all retail trade sales comparison to previous period data which match the
     * input constraints.</p>
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
