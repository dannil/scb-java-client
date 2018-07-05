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

package com.github.dannil.scbjavaclient.client.population.statistics.vitalevents;

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
 * <p>Client which handles population statistics vital events data fetching.</p>
 *
 * @since 0.4.0
 */
public class PopulationStatisticsVitalEventsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PopulationStatisticsVitalEventsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationStatisticsVitalEventsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all population changes number of persons data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPopulationChangesNumberOfPersons(Collection, Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getPopulationChangesNumberOfPersons() {
        return getPopulationChangesNumberOfPersons(null, null, null, null);
    }

    /**
     * <p>Fetch all population changes number of persons data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param populationChanges
     *            the population changes
     * @param sexes
     *            the sexes
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPopulationChangesNumberOfPersons(Collection<String> regions,
            Collection<Integer> populationChanges, Collection<Integer> sexes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Forandringar", populationChanges);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Befforandr", mappings);
    }

    /**
     * <p>Fetch all population and population changes data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPopulationAndPopulationChanges(Collection, Collection)
     */
    public List<ResponseModel> getPopulationAndPopulationChanges() {
        return getPopulationAndPopulationChanges(null, null);
    }

    /**
     * <p>Fetch all population and population changes data which match the input
     * constraints.</p>
     *
     * @param sexes
     *            the sexes
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPopulationAndPopulationChanges(Collection<String> sexes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BefUtvKon1749", mappings);
    }

    /**
     * <p>Fetch all births and deaths per month data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getBirthsAndDeathsPerMonth(Collection, Collection, Collection)
     */
    public List<ResponseModel> getBirthsAndDeathsPerMonth() {
        return getBirthsAndDeathsPerMonth(null, null, null);
    }

    /**
     * <p>Fetch all births and deaths per month data which match the input
     * constraints.</p>
     *
     * @param sexes
     *            the sexes
     * @param months
     *            the months
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getBirthsAndDeathsPerMonth(Collection<Integer> sexes, Collection<String> months,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put("Manad", months);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("ManadFoddDod", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0101/BE0101G/");
    }

}
