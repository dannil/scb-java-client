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

package com.github.dannil.scbjavaclient.client.population.projections.latestassumptions;

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
 * <p>Client which handles population projections latest assumptions data fetching.</p>
 *
 * @since 0.3.0
 */
public class PopulationProjectionsLatestAssumptionsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PopulationProjectionsLatestAssumptionsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationProjectionsLatestAssumptionsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all death rate data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getDeathRate(Collection, Collection, Collection)
     */
    public List<ResponseModel> getDeathRate() {
        return getDeathRate(null, null, null);
    }

    /**
     * <p>Fetch all death rate data which match the input constraints.</p>
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
    public List<ResponseModel> getDeathRate(Collection<Integer> sexes, Collection<String> ages,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BefProgDodstalN", mappings);
    }

    // Daniel 2018-05-12: Returns HTTP 403
    /**
     * <p>Fetch all emigration rate assumption data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEmigrationRateAssumption(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getEmigrationRateAssumption() {
        return getEmigrationRateAssumption(null, null, null, null);
    }

    /**
     * <p>Fetch all emigration rate assumption data which match the input constraints.</p>
     *
     * @param regionOfBirths
     *            the region of births
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
    public List<ResponseModel> getEmigrationRateAssumption(Collection<String> regionOfBirths, Collection<Integer> sexes,
            Collection<String> ages, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Fodelselandgrupp", regionOfBirths);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BefProgUtflyttN", mappings);
    }

    /**
     * <p>Fetch all fertility assumption data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getFertilityAssumption(Collection, Collection, Collection)
     */
    public List<ResponseModel> getFertilityAssumption() {
        return getFertilityAssumption(null, null, null);
    }

    /**
     * <p>Fetch all fertility assumption data which match the input constraints.</p>
     *
     * @param mothersRegionOfBirths
     *            the mother´s region of birth
     * @param ages
     *            the ages
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getFertilityAssumption(Collection<String> mothersRegionOfBirths, Collection<String> ages,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ModerFodlandgrupp", mothersRegionOfBirths);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BefProgFruktTotN", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0401/BE0401D/");
    }

}
