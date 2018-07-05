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

package com.github.dannil.scbjavaclient.client.environment.islands;

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
 * <p>Client which handles environment islands data fetching.</p>
 *
 * @since 0.4.0
 */
public class EnvironmentIslandsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentIslandsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentIslandsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all shoreline population data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getShorelinePopulation(Collection, Collection, Collection)
     */
    public List<ResponseModel> getShorelinePopulation() {
        return getShorelinePopulation(null, null, null);
    }

    /**
     * <p>Fetch all shoreline population data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param livings
     *            the livings
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getShorelinePopulation(Collection<String> regions, Collection<String> livings,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Boende", livings);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BefStrandnara", mappings);
    }

    /**
     * <p>Fetch all populated islands data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPopulatedIslands(Collection, Collection)
     */
    public List<ResponseModel> getPopulatedIslands() {
        return getPopulatedIslands(null, null);
    }

    /**
     * <p>Fetch all populated islands data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPopulatedIslands(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("OarBebodda", mappings);
    }

    /**
     * <p>Fetch all islands in Sweden data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getIslandsInSweden(Collection, Collection)
     */
    public List<ResponseModel> getIslandsInSweden() {
        return getIslandsInSweden(null, null);
    }

    /**
     * <p>Fetch all islands in Sweden data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getIslandsInSweden(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("OarSv", mappings);
    }

    /**
     * <p>Fetch all buildings on islands data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getBuildingsOnIslands(Collection, Collection)
     */
    public List<ResponseModel> getBuildingsOnIslands() {
        return getBuildingsOnIslands(null, null);
    }

    /**
     * <p>Fetch all buildings on islands data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getBuildingsOnIslands(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BebyggelseOar", mappings);
    }

    /**
     * <p>Fetch all islands in Sweden by number, area and perimeter data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getIslandsInSwedenByNumberAreaAndPerimiter(Collection, Collection)
     */
    public List<ResponseModel> getIslandsInSwedenByNumberAreaAndPerimiter() {
        return getIslandsInSwedenByNumberAreaAndPerimiter(null, null);
    }

    /**
     * <p>Fetch all islands in Sweden by number, area and perimeter data which match the
     * input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getIslandsInSwedenByNumberAreaAndPerimiter(Collection<String> regions,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("OarArealOmk", mappings);
    }

    /**
     * <p>Fetch all population on islands data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPopulationOnIslands(Collection, Collection)
     */
    public List<ResponseModel> getPopulationOnIslands() {
        return getPopulationOnIslands(null, null);
    }

    /**
     * <p>Fetch all population on islands data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPopulationOnIslands(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("OarBefolkning", mappings);
    }

    /**
     * <p>Fetch all number of islands in Sweden data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNumberOfIslandsInSweden(Collection, Collection, Collection)
     */
    public List<ResponseModel> getNumberOfIslandsInSweden() {
        return getNumberOfIslandsInSweden(null, null, null);
    }

    /**
     * <p>Fetch all number of islands in Sweden data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param sizeClasses
     *            the size classes
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNumberOfIslandsInSweden(Collection<String> regions, Collection<String> sizeClasses,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Storleksklass", sizeClasses);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("OarStorleksklass", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0812/");
    }

}
