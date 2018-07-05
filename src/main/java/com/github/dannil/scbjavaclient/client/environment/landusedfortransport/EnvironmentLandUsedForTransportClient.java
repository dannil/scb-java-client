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

package com.github.dannil.scbjavaclient.client.environment.landusedfortransport;

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
 * <p>Client which handles environment land used for transport data fetching.</p>
 *
 * @since 0.4.0
 */
public class EnvironmentLandUsedForTransportClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentLandUsedForTransportClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentLandUsedForTransportClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all transport infrastructure area data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTransportInfrastructureArea(Collection, Collection)
     */
    public List<ResponseModel> getTransportInfrastructureArea() {
        return getTransportInfrastructureArea(null, null);
    }

    /**
     * <p>Fetch all transport infrastructure area data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTransportInfrastructureArea(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("TransportInfAreal", mappings);
    }

    /**
     * <p>Fetch all road length by road owner data.</p>
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
     * <p>Fetch all road length by owner data which match the input constraints.</p>
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
     * <p>Fetch all railways data.</p>
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
     * <p>Fetch all railways data which match the input constraints.</p>
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
     * <p>Fetch all road area data.</p>
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
     * <p>Fetch all road area data which match the input constraints.</p>
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
     * <p>Fetch all road length by category data.</p>
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
     * <p>Fetch all road length by category data which match the input constraints.</p>
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

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0816/");
    }

}
