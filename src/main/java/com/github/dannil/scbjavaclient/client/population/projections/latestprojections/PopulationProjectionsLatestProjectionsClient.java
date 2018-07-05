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

package com.github.dannil.scbjavaclient.client.population.projections.latestprojections;

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
 * <p>Client which handles population projections latest projections data fetching.</p>
 *
 * @since 0.3.0
 */
public class PopulationProjectionsLatestProjectionsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PopulationProjectionsLatestProjectionsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationProjectionsLatestProjectionsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all population data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPopulation(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getPopulation() {
        return getPopulation(null, null, null, null);
    }

    /**
     * <p>Fetch all population data which match the input constraints.</p>
     *
     * @param regionOfBirths
     *            the region of births
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
    public List<ResponseModel> getPopulation(Collection<Integer> regionOfBirths, Collection<String> ages,
            Collection<Integer> sexes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Fodelseregion", regionOfBirths);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BefolkprognRevN", mappings);
    }

    /**
     * <p>Fetch all population changes data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPopulationChanges(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getPopulationChanges() {
        return getPopulationChanges(null, null, null, null);
    }

    /**
     * <p>Fetch all population changes data which match the input constraints.</p>
     *
     * @param countries
     *            the countries
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
    public List<ResponseModel> getPopulationChanges(Collection<String> countries, Collection<Integer> sexes,
            Collection<String> ages, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Fodelselandgrupp", countries);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BefProgOsiktDetaljN", mappings);
    }

    /**
     * <p>Fetch all population changes overview data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPopulationChangesOverview(Collection)
     */
    public List<ResponseModel> getPopulationChangesOverview() {
        return getPopulationChangesOverview(null);
    }

    /**
     * <p>Fetch all population changes overview data which match the input
     * constraints.</p>
     *
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPopulationChangesOverview(Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BefPrognosOversiktN", mappings);
    }

    /**
     * <p>Fetch all number of births data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNumberOfBirths(Collection, Collection, Collection)
     */
    public List<ResponseModel> getNumberOfBirths() {
        return getNumberOfBirths(null, null, null);
    }

    /**
     * <p>Fetch all number of births data which match the input constraints.</p>
     *
     * @param countries
     *            the countries
     * @param ages
     *            the ages
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNumberOfBirths(Collection<String> countries, Collection<String> ages,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ModerFodlandgrupp", countries);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BefProgFoddaMedelN", mappings);
    }

    /**
     * <p>Fetch all life expectancy data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getLifeExpectancy(Collection, Collection, Collection)
     */
    public List<ResponseModel> getLifeExpectancy() {
        return getLifeExpectancy(null, null, null);

    }

    /**
     * <p>Fetch all life expectancy data which match the input constraints.</p>
     *
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
    public List<ResponseModel> getLifeExpectancy(Collection<Integer> sexes, Collection<String> ages,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BefProgLivslangdN", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0401/BE0401A/");
    }

}
