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

package com.github.dannil.scbjavaclient.client.population.statistics.foreignbornpersons;

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
 * <p>Client which handles population statistics foreign-born persons data fetching.</p>
 *
 * @since 0.4.0
 */
public class PopulationStatisticsForeignBornPersonsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PopulationStatisticsForeignBornPersonsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationStatisticsForeignBornPersonsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all Swedish and foreign-born population data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getSwedishAndForeignBornPopulation(Collection, Collection, Collection,
     *      Collection, Collection)
     */
    public List<ResponseModel> getSwedishAndForeignBornPopulation() {
        return getSwedishAndForeignBornPopulation(null, null, null, null, null);
    }

    /**
     * <p>Fetch all Swedish and foreign-born population data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param ages
     *            the ages
     * @param sexes
     *            the sexes
     * @param regionOfBirths
     *            the region of births
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getSwedishAndForeignBornPopulation(Collection<String> regions, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> regionOfBirths, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put("Fodelseregion", regionOfBirths);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("InrUtrFoddaRegAlKon", mappings);
    }

    /**
     * <p>Fetch all population by country of birth data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPopulationByCountryOfBirth(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getPopulationByCountryOfBirth() {
        return getPopulationByCountryOfBirth(null, null, null, null);
    }

    /**
     * <p>Fetch all population by country of birth data which match the input
     * constraints.</p>
     *
     * @param countriesOfBirths
     *            the countries of births
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
    public List<ResponseModel> getPopulationByCountryOfBirth(Collection<String> countriesOfBirths,
            Collection<String> ages, Collection<Integer> sexes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Fodelseland", countriesOfBirths);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FodelselandArK", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0101/BE0101E/");
    }

}
