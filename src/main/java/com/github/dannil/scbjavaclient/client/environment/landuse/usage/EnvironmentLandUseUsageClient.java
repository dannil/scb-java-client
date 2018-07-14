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
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getArableAndForestLand(Collection, Collection, Collection)
     */
    public List<ResponseModel> getArableAndForestLand() {
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
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getArableAndForestLand(Collection<String> regions, Collection<Integer> categories,
            Collection<Integer> years) {
        return generate(regions, categories, years, "MarkanvJbSk");
    }

    /**
     * <p>Fetch all built up land data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getBuiltUpLand(Collection, Collection, Collection)
     */
    public List<ResponseModel> getBuiltUpLand() {
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
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getBuiltUpLand(Collection<String> regions, Collection<Integer> categories,
            Collection<Integer> years) {
        return generate(regions, categories, years, "MarkanvBebyggdLnKn");
    }

    /**
     * <p>Fetch all land use by county data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getLandUseByCounty(Collection, Collection, Collection)
     */
    public List<ResponseModel> getLandUseByCounty() {
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
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getLandUseByCounty(Collection<String> regions, Collection<Integer> categories,
            Collection<Integer> years) {
        return generate(regions, categories, years, "MarkanvLan");
    }

    /**
     * <p>Fetch all land use by municipality data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getLandUseByMunicipality(Collection, Collection, Collection)
     */
    public List<ResponseModel> getLandUseByMunicipality() {
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
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getLandUseByMunicipality(Collection<String> regions, Collection<Integer> categories,
            Collection<Integer> years) {
        return generate(regions, categories, years, "MarkanvKn");
    }

    /**
     * <p>Common generator method for the methods in this class.</p>
     *
     * @param regions
     *            the regions
     * @param categories
     *            the categories
     * @param years
     *            the years
     * @param table
     *            the table
     * @return a <code>List</code> of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     */
    private List<ResponseModel> generate(Collection<String> regions, Collection<Integer> categories,
            Collection<Integer> years, String table) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Markanvandningsklass", categories);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels(table, mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0803/MI0803A/");
    }

}
