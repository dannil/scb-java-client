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
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.http.URLEndpoint;
import com.github.dannil.scbjavaclient.model.ResponseModel;

/**
 * <p>Client which handles goods and services turnover service sector turnover data
 * fetching.</p>
 *
 * @since 0.7.0
 */
public class GoodsAndServicesTurnoverServiceSectorTurnover extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public GoodsAndServicesTurnoverServiceSectorTurnover() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public GoodsAndServicesTurnoverServiceSectorTurnover(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all turnover index for motor trade, hotels, restaurants and other services
     * (SIC 2002) yearly data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Yearly(Collection,
     *      Collection)
     */
    public List<ResponseModel> getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Yearly() {
        return getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Yearly(null, null);
    }

    /**
     * <p>Fetch all turnover index for motor trade, hotels, restaurants and other services
     * (SIC 2002) yearly data which match the input constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Yearly(
            Collection<String> industrialClassifications, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2002_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("DivtjansterAr", mappings);
    }

    /**
     * <p>Fetch all turnover index for wholesale trade and other services by industry (SIC
     * 2002) yearly data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Yearly(Collection,
     *      Collection)
     */
    public List<ResponseModel> getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Yearly() {
        return getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Yearly(null, null);
    }

    /**
     * <p>Fetch all turnover index for wholesale trade and other services by industry (SIC
     * 2002) yearly data which match the input constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Yearly(
            Collection<String> industrialClassifications, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2002_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("PartihFtgtjAr", mappings);
    }

    /**
     * <p>Fetch all retail sale index by industry (SIC 2002) monthly data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getRetailSaleIndexSIC2002Monthly(Collection, Collection)
     */
    public List<ResponseModel> getRetailSaleIndexSIC2002Monthly() {
        return getRetailSaleIndexSIC2002Monthly(null, null);
    }

    /**
     * <p>Fetch all retail sale index by industry (SIC 2002) monthly data which match the
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
    public List<ResponseModel> getRetailSaleIndexSIC2002Monthly(Collection<String> industrialClassifications,
            Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2002_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("Detoms", mappings);
    }

    /**
     * <p>Fetch all retail sale index by industry (SIC 2002) yearly data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getRetailSaleIndexSIC2002Yearly(Collection, Collection)
     */
    public List<ResponseModel> getRetailSaleIndexSIC2002Yearly() {
        return getRetailSaleIndexSIC2002Yearly(null, null);
    }

    /**
     * <p>Fetch all retail sale index by industry (SIC 2002) yearly data which match the
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
    public List<ResponseModel> getRetailSaleIndexSIC2002Yearly(Collection<String> industrialClassifications,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2002_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("DetOmsAr", mappings);
    }

    /**
     * <p>Fetch all turnover index for motor trade, hotels, restaurants and other services
     * by industry (SIC 2002) quarterly data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Quarterly(Collection,
     *      Collection)
     */
    public List<ResponseModel> getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Quarterly() {
        return getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Quarterly(null, null);
    }

    /**
     * <p>Fetch all turnover index for motor trade, hotels, restaurants and other services
     * by industry (SIC 2002) quarterly data which match the input constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Quarterly(
            Collection<String> industrialClassifications, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2002_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("Divtjanster", mappings);
    }

    /**
     * <p>Fetch all turnover index for wholesale trade and other services by industry (SIC
     * 2002) quarterly data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Quarterly(Collection,
     *      Collection)
     */
    public List<ResponseModel> getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Quarterly() {
        return getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Quarterly(null, null);
    }

    /**
     * <p>Fetch all turnover index for wholesale trade and other services by industry (SIC
     * 2002) quarterly data which match the input constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Quarterly(
            Collection<String> industrialClassifications, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2002_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("PartihFtgtj", mappings);
    }

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
     * <p>Fetch all turnover index for the service sector by industry (SIC 2007) yearly
     * data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTurnoverIndexForTheServiceSectorSIC2007Yearly(Collection, Collection)
     */
    public List<ResponseModel> getTurnoverIndexForTheServiceSectorSIC2007Yearly() {
        return getTurnoverIndexForTheServiceSectorSIC2007Yearly(null, null);
    }

    /**
     * <p>Fetch all turnover index for the service sector by industry (SIC 2007) yearly
     * data which match the input constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTurnoverIndexForTheServiceSectorSIC2007Yearly(
            Collection<String> industrialClassifications, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("DivtjansterAr07X", mappings);
    }

    /**
     * <p>Fetch all turnover index for the service sector by industry (SIC 2007) quarterly
     * data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTurnoverIndexForTheServiceSectorSIC2007Quarterly(Collection, Collection)
     */
    public List<ResponseModel> getTurnoverIndexForTheServiceSectorSIC2007Quarterly() {
        return getTurnoverIndexForTheServiceSectorSIC2007Quarterly(null, null);
    }

    /**
     * <p>Fetch all turnover index for the service sector by industry (SIC 2007) quarterly
     * data which match the input constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTurnoverIndexForTheServiceSectorSIC2007Quarterly(
            Collection<String> industrialClassifications, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("DivtjansterKv07X", mappings);
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
     * <p>Fetch all monthly indicator for household consumption data which match the
     * input constraints.</p>
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

    // TODO Add methods here!

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("HA/HA0101/HA0101B");
    }

}
