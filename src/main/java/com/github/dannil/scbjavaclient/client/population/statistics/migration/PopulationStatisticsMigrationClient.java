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

package com.github.dannil.scbjavaclient.client.population.statistics.migration;

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
 * <p>Client which handles population statistics migration data fetching.</p>
 *
 * @since 0.3.0
 */
public class PopulationStatisticsMigrationClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PopulationStatisticsMigrationClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationStatisticsMigrationClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all immigrations data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getImmigrations(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getImmigrations() {
        return getImmigrations(null, null, null, null);
    }

    /**
     * <p>Fetch all immigrations data which match the input constraints.</p>
     *
     * @param groundsForSettlements
     *            the grounds for settlements
     * @param countriesOfBirths
     *            the countries of births
     * @param sexes
     *            the sexes
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getImmigrations(Collection<String> groundsForSettlements,
            Collection<String> countriesOfBirths, Collection<Integer> sexes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Bosattning", groundsForSettlements);
        mappings.put("Fodelseland", countriesOfBirths);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("ImmiBosatt", mappings);
    }

    /**
     * <p>Fetch all migration data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getMigration(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getMigration() {
        return getMigration(null, null, null, null);
    }

    /**
     * <p>Fetch all migration data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
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
    public List<ResponseModel> getMigration(Collection<String> regions, Collection<String> ages,
            Collection<Integer> sexes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Flyttningar97", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0101/BE0101J/");
    }

}
