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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.purchasingpowerparities;

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
 * Client which handles prices and consumption purchasing power parities data
 * fetching.
 *
 * @since 0.4.0
 */
public class PricesAndConsumptionPurchasingPowerParitiesClient extends AbstractClient {

    /**
     * Default constructor.
     */
    public PricesAndConsumptionPurchasingPowerParitiesClient() {
        super();
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PricesAndConsumptionPurchasingPowerParitiesClient(Locale locale) {
        super(locale);
    }

    /**
     * Fetch all extrapolated price level indices data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getExtrapolatedPriceLevelIndices(Collection, Collection)
     */
    public List<ResponseModel> getExtrapolatedPriceLevelIndices() {
        return getExtrapolatedPriceLevelIndices(null, null);
    }

    /**
     * Fetch all extrapolated price level indices data which match the input
     * constraints.
     *
     * @param countryGroups
     *            the country groups
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getExtrapolatedPriceLevelIndices(Collection<String> countryGroups,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("LandLandgrupper", countryGroups);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("PR0401T01Ar", mappings);
    }

    /**
     * Fetch all purchasing power parities data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPurchasingPowerParities(Collection, Collection, Collection)
     */
    public List<ResponseModel> getPurchasingPowerParities() {
        return getPurchasingPowerParities(null, null, null);
    }

    /**
     * Fetch all purchasing power parities data which match the input constraints.
     *
     * @param countries
     *            the countries
     * @param esaClassifications
     *            the ESA classifications
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPurchasingPowerParities(Collection<String> countries,
            Collection<String> esaClassifications, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Land", countries);
        mappings.put("ENS", esaClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("PR0401T03BAr", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("PR/PR0401/");
    }

}
