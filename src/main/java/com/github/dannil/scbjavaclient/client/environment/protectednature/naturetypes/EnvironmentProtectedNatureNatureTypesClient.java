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

package com.github.dannil.scbjavaclient.client.environment.protectednature.naturetypes;

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
 * <p>Client which handles environment protected nature nature types data fetching.</p>
 *
 * @since 0.5.0
 */
public class EnvironmentProtectedNatureNatureTypesClient extends AbstractClient {

    private static final String NATURETYPES_CODE = "Naturtyp";

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentProtectedNatureNatureTypesClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentProtectedNatureNatureTypesClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all protected areas data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getProtectedAreas(Collection, Collection)
     */
    public List<ResponseModel> getProtectedAreas() {
        return getProtectedAreas(null, null);
    }

    /**
     * <p>Fetch all protected areas data which match the input constraints.</p>
     *
     * @param natureTypes
     *            the nature types
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getProtectedAreas(Collection<String> natureTypes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(NATURETYPES_CODE, natureTypes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("NaturTypSkyddOmr", mappings);
    }

    /**
     * <p>Fetch all productive forest land data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getProductiveForestLand(Collection, Collection)
     */
    public List<ResponseModel> getProductiveForestLand() {
        return getProductiveForestLand(null, null);
    }

    /**
     * <p>Fetch all productive forest land data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getProductiveForestLand(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("ProdSkogsmark", mappings);
    }

    /**
     * <p>Fetch all protected nature above the boundaries for mountain forests data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getProtectedNatureAboveTheBoundariesForMountainForests(Collection,
     *      Collection)
     */
    public List<ResponseModel> getProtectedNatureAboveTheBoundariesForMountainForests() {
        return getProtectedNatureAboveTheBoundariesForMountainForests(null, null);
    }

    /**
     * <p>Fetch all protected nature above the boundaries for mountain forests data which
     * match the input constraints.</p>
     *
     * @param natureTypes
     *            the nature types
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getProtectedNatureAboveTheBoundariesForMountainForests(Collection<String> natureTypes,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(NATURETYPES_CODE, natureTypes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("NaturSkyddFjallSkog", mappings);
    }

    /**
     * <p>Fetch all new protected areas data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNewProtectedAreas(Collection, Collection)
     */
    public List<ResponseModel> getNewProtectedAreas() {
        return getNewProtectedAreas(null, null);
    }

    /**
     * <p>Fetch all new protected areas data which match the input constraints.</p>
     *
     * @param natureTypes
     *            the nature types
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNewProtectedAreas(Collection<String> natureTypes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(NATURETYPES_CODE, natureTypes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("NytillkSkyddAreal", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0603/MI0603H/");
    }

}
