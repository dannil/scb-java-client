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

package com.github.dannil.scbjavaclient.client.environment.protectednature.numberandarea;

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
 * <p>Client which handles environment protected nature number and area data fetching.</p>
 *
 * @since 0.5.0
 */
public class EnvironmentProtectedNatureNumberAndAreaClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentProtectedNatureNumberAndAreaClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentProtectedNatureNumberAndAreaClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all wildlife sanctuaries data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getWildlifeSanctuaries(Collection, Collection)
     */
    public List<ResponseModel> getWildlifeSanctuaries() {
        return getWildlifeSanctuaries(null, null);
    }

    /**
     * <p>Fetch all wildlife sanctuaries data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getWildlifeSanctuaries(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("DjurVaxtskydd", mappings);
    }

    /**
     * <p>Fetch all Natura 2000 sites data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNatura2000Sites(Collection, Collection)
     */
    public List<ResponseModel> getNatura2000Sites() {
        return getNatura2000Sites(null, null);
    }

    /**
     * <p>Fetch all Natura 2000 sites data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNatura2000Sites(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Natura2000", mappings);
    }

    /**
     * <p>Fetch all protected nature data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getProtectedNature(Collection, Collection, Collection)
     */
    public List<ResponseModel> getProtectedNature() {
        return getProtectedNature(null, null, null);
    }

    /**
     * <p>Fetch all protected nature data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param protectionTypes
     *            the protection types
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getProtectedNature(Collection<String> regions, Collection<String> protectionTypes,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Skyddsform", protectionTypes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Skyddadnatur", mappings);
    }

    /**
     * <p>Fetch all species protected by law data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getSpeciesProtectedByLaw(Collection, Collection, Collection)
     */
    public List<ResponseModel> getSpeciesProtectedByLaw() {
        return getSpeciesProtectedByLaw(null, null, null);
    }

    /**
     * <p>Fetch all species protected by law data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param species
     *            the species
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getSpeciesProtectedByLaw(Collection<String> regions, Collection<String> species,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Arter", species);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("DjuroVaxtart", mappings);
    }

    /**
     * <p>Fetch all culture reserves data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getCultureReserves(Collection, Collection)
     */
    public List<ResponseModel> getCultureReserves() {
        return getCultureReserves(null, null);
    }

    /**
     * <p>Fetch all culture reserves data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getCultureReserves(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("KulturRes", mappings);
    }

    /**
     * <p>Fetch all natural monuments data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNaturalMonuments(Collection, Collection)
     */
    public List<ResponseModel> getNaturalMonuments() {
        return getNaturalMonuments(null, null);
    }

    /**
     * <p>Fetch all natural monuments data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNaturalMonuments(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Naturminnen", mappings);
    }

    /**
     * <p>Fetch all water protection areas data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getWaterProtectionAreas(Collection, Collection)
     */
    public List<ResponseModel> getWaterProtectionAreas() {
        return getWaterProtectionAreas(null, null);
    }

    /**
     * <p>Fetch all water protection areas data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getWaterProtectionAreas(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Vattenskyddsomr", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0603/MI0603D/");
    }

}
