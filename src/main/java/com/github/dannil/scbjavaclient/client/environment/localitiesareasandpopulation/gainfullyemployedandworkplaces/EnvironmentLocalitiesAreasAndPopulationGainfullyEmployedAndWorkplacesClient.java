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

package com.github.dannil.scbjavaclient.client.environment.localitiesareasandpopulation.gainfullyemployedandworkplaces;

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
 * <p>Client which handles environment localities areas and population gainfully employed
 * and workplaces data fetching.</p>
 *
 * @since 0.7.0
 */
public class EnvironmentLocalitiesAreasAndPopulationGainfullyEmployedAndWorkplacesClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentLocalitiesAreasAndPopulationGainfullyEmployedAndWorkplacesClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentLocalitiesAreasAndPopulationGainfullyEmployedAndWorkplacesClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all gainfully employed 16+ years data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getGainfullyEmployed(Collection, Collection, Collection)
     */
    public List<ResponseModel> getGainfullyEmployed() {
        return getGainfullyEmployed(null, null, null);
    }

    /**
     * <p>Fetch all gainfully employed 16+ years data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param sexes
     *            the sexes to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getGainfullyEmployed(Collection<String> regions, Collection<Integer> sexes,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("DagbefTatort", mappings);
    }

    /**
     * <p>Fetch all gainfully employed 16+ years workplaces data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getGainfullyEmployedWorkplaces(Collection, Collection)
     */
    public List<ResponseModel> getGainfullyEmployedWorkplaces() {
        return getGainfullyEmployedWorkplaces(null, null);
    }

    /**
     * <p>Fetch all gainfully employed 16+ years workplaces data which match the input
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
    public List<ResponseModel> getGainfullyEmployedWorkplaces(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("DagbefArbStTatort", mappings);
    }

    /**
     * <p>Fetch all gainfully employed 16+ years areas data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getGainfullyEmployedAreas(Collection, Collection, Collection)
     */
    public List<ResponseModel> getGainfullyEmployedAreas() {
        return getGainfullyEmployedAreas(null, null, null);
    }

    /**
     * <p>Fetch all gainfully employed 16+ years areas data which match the input
     * constraints.</p>
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
    public List<ResponseModel> getGainfullyEmployedAreas(Collection<String> regions, Collection<String> typeOfAreas,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("TypOmr", typeOfAreas);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("ForvArbPerTO", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0810/MI0810C/");
    }

}
