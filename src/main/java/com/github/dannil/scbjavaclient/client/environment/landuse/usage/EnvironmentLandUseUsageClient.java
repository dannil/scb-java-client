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

package com.github.dannil.scbjavaclient.client.environment.landuse.usage;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.environment.landuse.usage.ArableAndForestLand;
import com.github.dannil.scbjavaclient.model.environment.landuse.usage.BuiltUpLand;
import com.github.dannil.scbjavaclient.model.environment.landuse.usage.LandUseByCounty;
import com.github.dannil.scbjavaclient.model.environment.landuse.usage.LandUseByMunicipality;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles environment land use usage data fetching.</p>
 *
 * @since 0.2.0
 */
public class EnvironmentLandUseUsageClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentLandUseUsageClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentLandUseUsageClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all arable land and forest land data.</p>
     *
     * @return the arable land and forest land data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.landuse.usage.ArableAndForestLand
     *         ArableAndForestLand} objects
     *
     * @see #getArableAndForestLand(Collection, Collection, Collection)
     */
    public List<ArableAndForestLand> getArableAndForestLand() {
        return getArableAndForestLand(null, null, null);
    }

    /**
     * <p>Fetch all arable land and forest land data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param categories
     *            the categories to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the arable land and forest land data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.landuse.usage.ArableAndForestLand
     *         ArableAndForestLand} objects
     */
    public List<ArableAndForestLand> getArableAndForestLand(Collection<String> regions, Collection<Integer> categories,
            Collection<Integer> years) {
        return generate(Arrays.asList("MI0803AI"), regions, categories, years, "MarkanvJbSk", ArableAndForestLand.class);
    }

    /**
     * <p>Fetch all built up land data.</p>
     *
     * @return the built up land data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.landuse.usage.BuiltUpLand
     *         BuiltUpLand} objects
     *
     * @see #getBuiltUpLand(Collection, Collection, Collection)
     */
    public List<BuiltUpLand> getBuiltUpLand() {
        return getBuiltUpLand(null, null, null);
    }

    /**
     * <p>Fetch all built up land data which match the input constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param categories
     *            the categories to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the built up land data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.landuse.usage.BuiltUpLand
     *         BuiltUpLand} objects
     */
    public List<BuiltUpLand> getBuiltUpLand(Collection<String> regions, Collection<Integer> categories,
            Collection<Integer> years) {
        return generate(Arrays.asList("MI0803AC"), regions, categories, years, "MarkanvBebyggdLnKn", BuiltUpLand.class);
    }

    /**
     * <p>Fetch all land use by county data.</p>
     *
     * @return the land use by county data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.landuse.usage.LandUseByCounty
     *         LandUseByCounty} objects
     *
     * @see #getLandUseByCounty(Collection, Collection, Collection)
     */
    public List<LandUseByCounty> getLandUseByCounty() {
        return getLandUseByCounty(null, null, null);
    }

    /**
     * <p>Fetch all land use by county data which match the input constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param categories
     *            the categories to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the land use by county data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.landuse.usage.LandUseByCounty
     *         LandUseByCounty} objects
     */
    public List<LandUseByCounty> getLandUseByCounty(Collection<String> regions, Collection<Integer> categories,
            Collection<Integer> years) {
        return generate(Arrays.asList("MI0803AA"), regions, categories, years, "MarkanvLan", LandUseByCounty.class);
    }

    /**
     * <p>Fetch all land use by municipality data.</p>
     *
     * @return the land use by municipality data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.landuse.usage.LandUseByMunicipality
     *         LandUseByMunicipality} objects
     *
     * @see #getLandUseByMunicipality(Collection, Collection, Collection)
     */
    public List<LandUseByMunicipality> getLandUseByMunicipality() {
        return getLandUseByMunicipality(null, null, null);
    }

    /**
     * <p>Fetch all land use by municipality data which match the input constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param categories
     *            the categories to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the land use by municipality data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.landuse.usage.LandUseByMunicipality
     *         LandUseByMunicipality} objects
     */
    public List<LandUseByMunicipality> getLandUseByMunicipality(Collection<String> regions,
            Collection<Integer> categories, Collection<Integer> years) {
        return generate(Arrays.asList("MI0803AB"), regions, categories, years, "MarkanvKn", LandUseByMunicipality.class);
    }

    /**
     * <p>Common generator method for the methods in this class.</p>
     *
     * @param contentCodes
     *            the content codes
     * @param regions
     *            the regions
     * @param categories
     *            the categories
     * @param years
     *            the years
     * @param table
     *            the table
     * @param clazz
     *            the class to convert the generated data to
     * @return a <code>List</code> of the specified class
     */
    private <T> List<T> generate(Collection<String> contentCodes, Collection<String> regions,
            Collection<Integer> categories, Collection<Integer> years, String table, Class<T> clazz) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", contentCodes);
        mappings.put("Region", regions);
        mappings.put("Markanvandningsklass", categories);
        mappings.put("Tid", years);

        String response = doPostRequest(getUrl() + table, QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(clazz);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "MI/MI0803/MI0803A/";
    }

}
