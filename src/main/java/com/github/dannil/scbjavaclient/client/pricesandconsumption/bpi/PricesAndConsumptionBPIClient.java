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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.bpi;

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
 * <p>Client which handles prices and consumption building price index (BPI) data
 * fetching.</p>
 *
 * @since 0.4.0
 */
public class PricesAndConsumptionBPIClient extends AbstractClient {

    private static final String TYPEOFINDEX_CODE = "Indexslag";

    /**
     * <p>Default constructor.</p>
     */
    public PricesAndConsumptionBPIClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PricesAndConsumptionBPIClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all building price index for dwellings (quarters) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getBuildingPriceIndexForDwellingsQuarters(Collection, Collection, Collection)
     */
    public List<ResponseModel> getBuildingPriceIndexForDwellingsQuarters() {
        return getBuildingPriceIndexForDwellingsQuarters(null, null, null);
    }

    /**
     * <p>Fetch all building price index for dwellings (quarters) data which match the
     * input constraints.</p>
     *
     * @param typesOfBuildings
     *            the types of buildings
     * @param typesOfIndexes
     *            the types of indexes
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getBuildingPriceIndexForDwellingsQuarters(Collection<String> typesOfBuildings,
            Collection<String> typesOfIndexes, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.TYPEOFBUILDING_CODE, typesOfBuildings);
        mappings.put(TYPEOFINDEX_CODE, typesOfIndexes);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("ByggIndexKv", mappings);
    }

    /**
     * <p>Fetch all building price index for dwellings (years) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getBuildingPriceIndexForDwellingsYears(Collection, Collection, Collection)
     */
    public List<ResponseModel> getBuildingPriceIndexForDwellingsYears() {
        return getBuildingPriceIndexForDwellingsYears(null, null, null);
    }

    /**
     * <p>Fetch all building price index for dwellings (years) data which match the input
     * constraints.</p>
     *
     * @param typesOfBuildings
     *            the types of buildings
     * @param typesOfIndexes
     *            the types of indexes
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getBuildingPriceIndexForDwellingsYears(Collection<String> typesOfBuildings,
            Collection<String> typesOfIndexes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.TYPEOFBUILDING_CODE, typesOfBuildings);
        mappings.put(TYPEOFINDEX_CODE, typesOfIndexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("ByggIndexAr", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("PR/PR0501/");
    }

}
