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

package com.github.dannil.scbjavaclient.client.agriculture.livestock;

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
 * Client which handles agriculture livestock data fetching.
 *
 * @since 0.4.0
 */
public class AgricultureLivestockClient extends AbstractClient {

    private static final String TYPEOFANIMAL_CODE = "Djurslag";

    /**
     * Default constructor.
     */
    public AgricultureLivestockClient() {
        super();
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public AgricultureLivestockClient(Locale locale) {
        super(locale);
    }

    /**
     * Fetch all livestock by municipality data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getLivestockByMunicipality(Collection, Collection, Collection)
     */
    public List<ResponseModel> getLivestockByMunicipality() {
        return getLivestockByMunicipality(null, null, null);
    }

    /**
     * Fetch all livestock by municipality data which match the input constraints.
     *
     * @param regions
     *            the regions
     * @param typesOfAnimals
     *            the types of animals
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getLivestockByMunicipality(Collection<String> regions, Collection<String> typesOfAnimals,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(TYPEOFANIMAL_CODE, typesOfAnimals);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("HusdjurK", mappings);
    }

    /**
     * Fetch all livestock by county data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getLivestockByCounty(Collection, Collection, Collection)
     */
    public List<ResponseModel> getLivestockByCounty() {
        return getLivestockByCounty(null, null, null);
    }

    /**
     * Fetch all livestock by county data which match the input constraints.
     *
     * @param regions
     *            the regions
     * @param typesOfAnimals
     *            the types of animals
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getLivestockByCounty(Collection<String> regions, Collection<String> typesOfAnimals,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(TYPEOFANIMAL_CODE, typesOfAnimals);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("HusdjurL", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("JO/JO0103/");
    }

}
