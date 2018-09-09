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

package com.github.dannil.scbjavaclient.client.population.statistics.deaths;

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
 * <p>Client which handles population statistics deaths data fetching.</p>
 *
 * @since 0.3.0
 */
public class PopulationStatisticsDeathsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PopulationStatisticsDeathsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationStatisticsDeathsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all mortality rate data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getMortalityRate(Collection, Collection, Collection)
     */
    public List<ResponseModel> getMortalityRate() {
        return getMortalityRate(null, null, null);
    }

    /**
     * <p>Fetch all mortality rate data which match the input constraints.</p>
     *
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
    public List<ResponseModel> getMortalityRate(Collection<String> ages, Collection<Integer> sexes,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Dodstal", mappings);
    }

    /**
     * <p>Fetch all stillborn data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getStillborn(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getStillborn() {
        return getStillborn(null, null, null, null);
    }

    /**
     * <p>Fetch all stillborn data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param motherAges
     *            the mothers' ages
     * @param sexes
     *            the sexes
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getStillborn(Collection<String> regions, Collection<String> motherAges,
            Collection<Integer> sexes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("AlderModer", motherAges);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("DodFoddaAlderMorK1", mappings);
    }

    /**
     * <p>Fetch all life expectancy data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getLifeExpectency(Collection, Collection, Collection)
     */
    public List<ResponseModel> getLifeExpectency() {
        return getLifeExpectency(null, null, null);
    }

    /**
     * <p>Fetch all life expectancy data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param sexes
     *            the sexes
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getLifeExpectency(Collection<String> regions, Collection<Integer> sexes,
            Collection<String> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Medellivsl", mappings);
    }

    /**
     * <p>Fetch all life table data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getLifeTable(Collection, Collection, Collection)
     */
    public List<ResponseModel> getLifeTable() {
        return getLifeTable(null, null, null);
    }

    /**
     * <p>Fetch all life table data which match the input constraints.</p>
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
    public List<ResponseModel> getLifeTable(Collection<Integer> sexes, Collection<Integer> ages,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("LivslangdEttariga", mappings);
    }

    /**
     * <p>Fetch all infant mortality data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getInfantMortality(Collection, Collection, Collection)
     */
    public List<ResponseModel> getInfantMortality() {
        return getInfantMortality(null, null, null);
    }

    /**
     * <p>Fetch all infant mortality data which match the input constraints.</p>
     *
     * @param sexes
     *            the sexes
     * @param infantMortalities
     *            the infant mortalities
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getInfantMortality(Collection<String> sexes, Collection<String> infantMortalities,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put("Spadbarnsdodligh", infantMortalities);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Spadbarnsdodlighet", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0101/BE0101I/");
    }

}
