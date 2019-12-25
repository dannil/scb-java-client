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

package com.github.dannil.scbjavaclient.client.population.statistics.asylumseekers;

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
 * <p>Client which handles population statistics asylum seekers data fetching.</p>
 *
 * @since 0.3.0
 */
public class PopulationStatisticsAsylumSeekersClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PopulationStatisticsAsylumSeekersClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationStatisticsAsylumSeekersClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all asylum seekers data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAsylumSeekers(Collection, Collection, Collection)
     */
    public List<ResponseModel> getAsylumSeekers() {
        return getAsylumSeekers(null, null, null);
    }

    /**
     * <p>Fetch all asylum seekers data which match the input constraints.</p>
     *
     * @param countriesOfCitizenships
     *            the countries of citizenships
     * @param sexes
     *            the sexes
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAsylumSeekers(Collection<String> countriesOfCitizenships, Collection<Integer> sexes,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Medbland", countriesOfCitizenships);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Asylsokande", mappings);
    }

    /**
     * <p>Fetch all unaccompanied refugee minors data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getUnaccompaniedRefugeeMinors(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getUnaccompaniedRefugeeMinors() {
        return getUnaccompaniedRefugeeMinors(null, null, null, null);
    }

    /**
     * <p>Fetch all unaccompanied refugee minors data which match the input
     * constraints.</p>
     *
     * @param sexes
     *            the sexes
     * @param ages
     *            the ages
     * @param countriesOfCitizenships
     *            the countries of citizenships
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getUnaccompaniedRefugeeMinors(Collection<String> sexes, Collection<String> ages,
            Collection<String> countriesOfCitizenships, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put("Medbland", countriesOfCitizenships);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Ensamkommande", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0101/BE0101P/");
    }

}
