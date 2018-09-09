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

package com.github.dannil.scbjavaclient.client.agriculture.landuse;

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
 * <p>Client which handles agriculture land use data fetching.</p>
 *
 * @since 0.4.0
 */
public class AgricultureLandUseClient extends AbstractClient {

    private static final String CROP_CODE = "Groda";

    private static final String TYPEOFLAND_CODE = "Agoslag";

    /**
     * <p>Default constructor.</p>
     */
    public AgricultureLandUseClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public AgricultureLandUseClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all use of arable land by municipality data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getUseOfArableLandByMunicipality(Collection, Collection, Collection)
     */
    public List<ResponseModel> getUseOfArableLandByMunicipality() {
        return getUseOfArableLandByMunicipality(null, null, null);
    }

    /**
     * <p>Fetch all use of arable land by municipality data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param crops
     *            the crops
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getUseOfArableLandByMunicipality(Collection<String> regions, Collection<String> crops,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(CROP_CODE, crops);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("AkerArealGrodaK", mappings);
    }

    /**
     * <p>Fetch all use of arable land by county data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getUseOfArableLandByCounty(Collection, Collection, Collection)
     */
    public List<ResponseModel> getUseOfArableLandByCounty() {
        return getUseOfArableLandByCounty(null, null, null);
    }

    /**
     * <p>Fetch all use of arable land by county data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param crops
     *            the crops
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getUseOfArableLandByCounty(Collection<String> regions, Collection<String> crops,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(CROP_CODE, crops);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("AkerArealGrodaL", mappings);
    }

    /**
     * <p>Fetch all type of land area by municipality data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTypeOfLandAreaByMunicipality(Collection, Collection, Collection)
     */
    public List<ResponseModel> getTypeOfLandAreaByMunicipality() {
        return getTypeOfLandAreaByMunicipality(null, null, null);
    }

    /**
     * <p>Fetch all type of land area by municipality data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param typesOfLands
     *            the types of lands
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTypeOfLandAreaByMunicipality(Collection<String> regions,
            Collection<Integer> typesOfLands, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(TYPEOFLAND_CODE, typesOfLands);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("AgoslagArealK", mappings);
    }

    /**
     * <p>Fetch all type of land area by county data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTypeOfLandAreaByCounty(Collection, Collection, Collection)
     */
    public List<ResponseModel> getTypeOfLandAreaByCounty() {
        return getTypeOfLandAreaByCounty(null, null, null);
    }

    /**
     * <p>Fetch all type of land area by county data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param typesOfLands
     *            the types of lands
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTypeOfLandAreaByCounty(Collection<String> regions, Collection<Integer> typesOfLands,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(TYPEOFLAND_CODE, typesOfLands);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("AgoslagArealL", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("JO/JO0104/");
    }

}
