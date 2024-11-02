/*
 * Copyright 2018 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.environment.landuse.infrastructurefortransport;

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
 * Client which handles environment land use infrastructure for transport data
 * fetching.
 *
 * @since 2.1.0
 */
public class EnvironmentLandUseInfrastructureForTransportClient extends AbstractClient {

    /**
     * Default constructor.
     */
    public EnvironmentLandUseInfrastructureForTransportClient() {
        super();
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentLandUseInfrastructureForTransportClient(Locale locale) {
        super(locale);
    }

    /**
     * Fetch all road length by road owner data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getRoadLengthByOwner(Collection, Collection, Collection)
     */
    public List<ResponseModel> getRoadLengthByOwner() {
        return getRoadLengthByOwner(null, null, null);
    }

    /**
     * Fetch all road length by owner data which match the input constraints.
     *
     * @param regions
     *            the regions
     * @param owners
     *            the owners
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getRoadLengthByOwner(Collection<String> regions, Collection<String> owners,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Vaghallare", owners);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("VaglangdHallare", mappings);
    }

    /**
     * Fetch all railways data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getRailways(Collection, Collection)
     */
    public List<ResponseModel> getRailways() {
        return getRailways(null, null);
    }

    /**
     * Fetch all railways data which match the input constraints.
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getRailways(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("JarnVagLangdAreai", mappings);
    }

    /**
     * Fetch all road area data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getRoadArea(Collection, Collection, Collection)
     */
    public List<ResponseModel> getRoadArea() {
        return getRoadArea(null, null, null);
    }

    /**
     * Fetch all road area data which match the input constraints.
     *
     * @param regions
     *            the regions
     * @param areas
     *            the areas
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getRoadArea(Collection<String> regions, Collection<String> areas,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("ArealTyp", areas);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("VagArealKategori", mappings);
    }

    /**
     * Fetch all road length by category data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getRoadLengthByCategory(Collection, Collection, Collection)
     */
    public List<ResponseModel> getRoadLengthByCategory() {
        return getRoadLengthByCategory(null, null, null);
    }

    /**
     * Fetch all road length by category data which match the input constraints.
     *
     * @param regions
     *            the regions
     * @param categories
     *            the categories
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getRoadLengthByCategory(Collection<String> regions, Collection<String> categories,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Vagkategori", categories);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("VaglangdKategori", mappings);
    }

    /**
     * Fetch all land with transport infrastructure data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getLandWithTransportInfrastructure(Collection, Collection)
     */
    public List<ResponseModel> getLandWithTransportInfrastructure() {
        return getLandWithTransportInfrastructure(null, null);
    }

    /**
     * Fetch all land with transport infrastructure data which match the input
     * constraints.
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getLandWithTransportInfrastructure(Collection<String> regions,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("TransportInfAreal", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0803/MI0803E");
    }

}
