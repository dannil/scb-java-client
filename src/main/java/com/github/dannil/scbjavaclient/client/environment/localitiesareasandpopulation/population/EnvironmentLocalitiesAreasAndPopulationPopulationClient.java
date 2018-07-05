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

package com.github.dannil.scbjavaclient.client.environment.localitiesareasandpopulation.population;

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
 * <p>Client which handles environment localities areas and population population data
 * fetching.</p>
 *
 * @since 0.7.0
 */
public class EnvironmentLocalitiesAreasAndPopulationPopulationClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentLocalitiesAreasAndPopulationPopulationClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentLocalitiesAreasAndPopulationPopulationClient(Locale locale) {
        super(locale);
    }

    // Daniel 2017-03-29: Returns HTTP 403
    /**
     * <p>Fetch all population and land area within localities data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPopulationAndLandAreaWithinLocalities(Collection, Collection)
     */
    public List<ResponseModel> getPopulationAndLandAreaWithinLocalities() {
        return getPopulationAndLandAreaWithinLocalities(null, null);
    }

    /**
     * <p>Fetch all population and land area within localities data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPopulationAndLandAreaWithinLocalities(Collection<String> regions,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("LandarealTatort", mappings);
    }

    /**
     * <p>Fetch all population and land area within and outside of localities data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPopulationAndLandAreaWithinAndOutsideOfLocalities(Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getPopulationAndLandAreaWithinAndOutsideOfLocalities() {
        return getPopulationAndLandAreaWithinAndOutsideOfLocalities(null, null, null);
    }

    /**
     * <p>Fetch all population and land area within and outside of localities data which
     * match the input constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param typeOfAreas
     *            the type of areas to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPopulationAndLandAreaWithinAndOutsideOfLocalities(Collection<String> regions,
            Collection<String> typeOfAreas, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("TypOmr", typeOfAreas);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BefLandInvKvmTO", mappings);
    }

    /**
     * <p>Fetch all number of localities and population density data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNumberOfLocalitiesAndPopulationDensity(Collection, Collection)
     */
    public List<ResponseModel> getNumberOfLocalitiesAndPopulationDensity() {
        return getNumberOfLocalitiesAndPopulationDensity(null, null);
    }

    /**
     * <p>Fetch all number of localities and population density data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNumberOfLocalitiesAndPopulationDensity(Collection<String> regions,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("TatortGrad", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0810/MI0810A/");
    }

}
