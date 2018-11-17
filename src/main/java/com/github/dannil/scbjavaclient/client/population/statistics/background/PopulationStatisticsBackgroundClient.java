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

package com.github.dannil.scbjavaclient.client.population.statistics.background;

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
 * <p>Client which handles population statistics background data fetching.</p>
 *
 * @since 0.4.0
 */
public class PopulationStatisticsBackgroundClient extends AbstractClient {

    private static final String BACKGROUND_CODE = "UtlBakgrund";

    /**
     * <p>Default constructor.</p>
     */
    public PopulationStatisticsBackgroundClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationStatisticsBackgroundClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all number of persons with foreign or Swedish background (rough division)
     * data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPersonsWithBackgroundRoughDivision(Collection, Collection, Collection,
     *      Collection, Collection)
     */
    public List<ResponseModel> getPersonsWithBackgroundRoughDivision() {
        return getPersonsWithBackgroundRoughDivision(null, null, null, null, null);
    }

    /**
     * <p>Fetch all number of persons with foreign or Swedish background (rough division)
     * data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param backgrounds
     *            the backgrounds
     * @param ages
     *            the ages
     * @param sexes
     *            the sexes
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPersonsWithBackgroundRoughDivision(Collection<String> regions,
            Collection<Integer> backgrounds, Collection<String> ages, Collection<Integer> sexes,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(BACKGROUND_CODE, backgrounds);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("UtlSvBakgGrov", mappings);
    }

    /**
     * <p>Fetch all number of persons with foreign or Swedish background (detailed
     * division) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPersonsWithBackgroundDetailedDivision(Collection, Collection, Collection,
     *      Collection, Collection)
     */
    public List<ResponseModel> getPersonsWithBackgroundDetailedDivision() {
        return getPersonsWithBackgroundDetailedDivision(null, null, null, null, null);
    }

    /**
     * <p>Fetch all number of persons with foreign or Swedish background (detailed
     * division) data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param backgrounds
     *            the backgrounds
     * @param ages
     *            the ages
     * @param sexes
     *            the sexes
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPersonsWithBackgroundDetailedDivision(Collection<String> regions,
            Collection<String> backgrounds, Collection<String> ages, Collection<Integer> sexes,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(BACKGROUND_CODE, backgrounds);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("UtlSvBakgFin", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0101/BE0101Q/");
    }

}
