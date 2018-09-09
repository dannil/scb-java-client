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

package com.github.dannil.scbjavaclient.client.population.statistics.meanpopulation;

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
 * <p>Client which handles population statistics mean population data fetching.</p>
 *
 * @since 1.2.0
 */
public class PopulationStatisticsMeanPopulationClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PopulationStatisticsMeanPopulationClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationStatisticsMeanPopulationClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all mean population by birth year data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getMeanPopulationByBirthYear(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getMeanPopulationByBirthYear() {
        return getMeanPopulationByBirthYear(null, null, null, null);
    }

    /**
     * <p>Fetch all mean population by birth year data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param ages
     *            the ages to fetch data for
     * @param sexes
     *            the sexes to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getMeanPopulationByBirthYear(Collection<String> regions, Collection<String> ages,
            Collection<Integer> sexes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MedelfolkFodelsear", mappings);
    }

    /**
     * <p>Fetch all mean population by current age data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getMeanPopulationByCurrentAge(Collection, Collection, Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getMeanPopulationByCurrentAge() {
        return getMeanPopulationByCurrentAge(null, null, null, null, null);
    }

    /**
     * <p>Fetch all mean population by current age data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param maritalStatuses
     *            the marital statuses to fetch data for
     * @param ages
     *            the ages to fetch data for
     * @param sexes
     *            the sexes to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getMeanPopulationByCurrentAge(Collection<String> regions,
            Collection<String> maritalStatuses, Collection<String> ages, Collection<Integer> sexes,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Civilstand", maritalStatuses);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MedelfolkHandelse", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0101/BE0101D/");
    }

}
