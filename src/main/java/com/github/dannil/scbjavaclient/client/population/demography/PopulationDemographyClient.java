/*
 * Copyright 2014 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.population.demography;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.population.demography.FertilityRate;
import com.github.dannil.scbjavaclient.model.population.demography.MeanAgeFirstChild;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;
import com.github.dannil.scbjavaclient.utility.URLUtility;

/**
 * <p>Client which handles population demography data fetching.</p>
 *
 * @since 0.0.2
 */
public class PopulationDemographyClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PopulationDemographyClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationDemographyClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all fertility rate data.</p>
     *
     * @return the fertility rate data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.population.demography.FertilityRate
     *         FertilityRate} objects
     *
     * @see PopulationDemographyClient#getFertilityRate(Collection, Collection,
     *      Collection)
     */
    public List<FertilityRate> getFertilityRate() {
        return getFertilityRate(null, null, null);
    }

    /**
     * <p>Fetch all fertility rate data which match the input constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param genders
     *            the genders to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the fertility rate data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.population.demography.FertilityRate
     *         FertilityRate} objects
     */
    public List<FertilityRate> getFertilityRate(Collection<String> regions, Collection<Integer> genders,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", Arrays.asList("BE0701AA"));
        mappings.put("Region", regions);
        mappings.put("Kon", genders);
        mappings.put("Tid", years);

        String response = post("BE/BE0701/FruktsamhetSumNy", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(FertilityRate.class);
    }

    /**
     * <p>Fetch all mean age for the first child data.</p>
     *
     * @return the mean age for the first child data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.population.demography.MeanAgeFirstChild
     *         MeanAgeFirstChild} objects
     *
     * @see #getMeanAgeFirstChild(Collection, Collection, Collection)
     */
    public List<MeanAgeFirstChild> getMeanAgeFirstChild() {
        return getMeanAgeFirstChild(null, null, null);
    }

    /**
     * <p>Fetch all mean age for the first child data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param genders
     *            the genders to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the mean age for the first child data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.population.demography.MeanAgeFirstChild
     *         MeanAgeFirstChild} objects
     */
    public List<MeanAgeFirstChild> getMeanAgeFirstChild(Collection<String> regions, Collection<Integer> genders,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", Arrays.asList("BE0701AB"));
        mappings.put("Region", regions);
        mappings.put("Kon", genders);
        mappings.put("Tid", years);

        String response = post("BE/BE0701/MedelAlderNY", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(MeanAgeFirstChild.class);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "BE/BE0701/";
    }

}
