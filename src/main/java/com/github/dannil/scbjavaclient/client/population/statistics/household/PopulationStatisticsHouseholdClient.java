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

package com.github.dannil.scbjavaclient.client.population.statistics.household;

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
 * <p>Client which handles population statistics household data fetching.</p>
 *
 * @since 0.4.0
 */
public class PopulationStatisticsHouseholdClient extends AbstractClient {

    private static final String TYPEOFHOUSEHOLD_CODE = "Hushallstyp";

    /**
     * <p>Default constructor.</p>
     */
    public PopulationStatisticsHouseholdClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationStatisticsHouseholdClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all number of households and persons data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNumberOfHouseholdsAndPersons(Collection, Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getNumberOfHouseholdsAndPersons() {
        return getNumberOfHouseholdsAndPersons(null, null, null, null);
    }

    /**
     * <p>Fetch all number of households and persons data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param typesOfHouseholds
     *            the types of households
     * @param numberOfChildrens
     *            the number of childrens
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNumberOfHouseholdsAndPersons(Collection<String> regions,
            Collection<String> typesOfHouseholds, Collection<String> numberOfChildrens, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(TYPEOFHOUSEHOLD_CODE, typesOfHouseholds);
        mappings.put("Barn", numberOfChildrens);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("HushallT05", mappings);
    }

    /**
     * <p>Fetch all number of persons data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNumberOfPersons(Collection, Collection, Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getNumberOfPersons() {
        return getNumberOfPersons(null, null, null, null, null);
    }

    /**
     * <p>Fetch all number of persons data which match the input constraints.</p>
     *
     * @param typesOfHouseholds
     *            the types of households
     * @param householdStatuses
     *            the household statuses
     * @param sexes
     *            the sexes
     * @param ages
     *            the ages
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNumberOfPersons(Collection<String> typesOfHouseholds,
            Collection<String> householdStatuses, Collection<Integer> sexes, Collection<String> ages,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(TYPEOFHOUSEHOLD_CODE, typesOfHouseholds);
        mappings.put("Hushallsstallning", householdStatuses);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("HushallT07", mappings);
    }

    /**
     * <p>Fetch all number and percentage of persons and households data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNumberOfAndPercentageOfPersonsAndHouseholds(Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getNumberOfAndPercentageOfPersonsAndHouseholds() {
        return getNumberOfAndPercentageOfPersonsAndHouseholds(null, null, null);
    }

    /**
     * <p>Fetch all number and percentage of persons and households data which match the
     * input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param householdSizes
     *            the household sizes
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNumberOfAndPercentageOfPersonsAndHouseholds(Collection<String> regions,
            Collection<String> householdSizes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Hushallsstorlek", householdSizes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("HushallT03", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0101/BE0101S/");
    }

}
