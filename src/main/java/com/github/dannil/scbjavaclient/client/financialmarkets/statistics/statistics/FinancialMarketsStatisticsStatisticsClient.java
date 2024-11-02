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

package com.github.dannil.scbjavaclient.client.financialmarkets.statistics.statistics;

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
 * Client which handles financial markets statistics statistics data fetching.
 *
 * @since 0.4.0
 */
public class FinancialMarketsStatisticsStatisticsClient extends AbstractClient {

    /**
     * Default constructor.
     */
    public FinancialMarketsStatisticsStatisticsClient() {
        super();
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsStatisticsStatisticsClient(Locale locale) {
        super(locale);
    }

    /**
     * Fetch all assets and liabilities data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAssetsAndLiabilities(Collection, Collection, Collection)
     */
    public List<ResponseModel> getAssetsAndLiabilities() {
        return getAssetsAndLiabilities(null, null, null);
    }

    /**
     * Fetch all assets and liabilities data which match the input constraints.
     *
     * @param institutions
     *            the institutions
     * @param itemsAndCounterPartSectors
     *            the items and counter part sectors
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAssetsAndLiabilities(Collection<String> institutions,
            Collection<String> itemsAndCounterPartSectors, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Institut", institutions);
        mappings.put("KontopostMotsektor", itemsAndCounterPartSectors);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("FM5001SDDSMFI", mappings);
    }

    /**
     * Fetch all financial soundness indicators data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getFinancialSoundnessIndicators(Collection, Collection)
     */
    public List<ResponseModel> getFinancialSoundnessIndicators() {
        return getFinancialSoundnessIndicators(null, null);
    }

    /**
     * Fetch all financial soundness indicators data which match the input
     * constraints.
     *
     * @param indicators
     *            the indicators
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getFinancialSoundnessIndicators(Collection<String> indicators,
            Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("FinansiellIndikator", indicators);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("FM5001SDDSFSI", mappings);
    }

    /**
     * Fetch all money supply data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getMoneySupply(Collection, Collection)
     */
    public List<ResponseModel> getMoneySupply() {
        return getMoneySupply(null, null);
    }

    /**
     * Fetch all money supply data which match the input constraints.
     *
     * @param moneySupplies
     *            the money supplies
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getMoneySupply(Collection<String> moneySupplies, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Penningm", moneySupplies);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("FM5001SDDSPM", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM5001/FM5001A/");
    }

}
