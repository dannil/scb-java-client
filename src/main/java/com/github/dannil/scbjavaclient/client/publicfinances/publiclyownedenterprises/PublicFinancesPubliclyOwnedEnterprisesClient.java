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

package com.github.dannil.scbjavaclient.client.publicfinances.publiclyownedenterprises;

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
 * <p>Client which handles public finances publicly owned enterprises data fetching.</p>
 *
 * @since 0.3.0
 */
public class PublicFinancesPubliclyOwnedEnterprisesClient extends AbstractClient {

    private static final String OWNERCATEGORY_CODE = "Agarkategori";

    /**
     * <p>Default constructor.</p>
     */
    public PublicFinancesPubliclyOwnedEnterprisesClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PublicFinancesPubliclyOwnedEnterprisesClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all municipality owned enterprises data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getDataForMunicipalityOwnedEnterprises(Collection, Collection)
     */
    public List<ResponseModel> getDataForMunicipalityOwnedEnterprises() {
        return getDataForMunicipalityOwnedEnterprises(null, null);
    }

    /**
     * <p>Fetch all municipality owned enterprises data which match the input
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
    public List<ResponseModel> getDataForMunicipalityOwnedEnterprises(Collection<String> regions,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("KomFtgK", mappings);
    }

    /**
     * <p>Fetch all enterprises data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEnterprises(Collection, Collection)
     */
    public List<ResponseModel> getEnterprises() {
        return getEnterprises(null, null);
    }

    /**
     * <p>Fetch all enterprises data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEnterprises(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("KomFtgK100", mappings);
    }

    /**
     * <p>Fetch all county councils enterprises data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getCountyCouncilsEnterprises(Collection, Collection, Collection)
     */
    public List<ResponseModel> getCountyCouncilsEnterprises() {
        return getCountyCouncilsEnterprises(null, null, null);
    }

    /**
     * <p>Fetch all county councils enterprises data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param sectors
     *            the sectors
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getCountyCouncilsEnterprises(Collection<String> regions, Collection<String> sectors,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("LtFtgL", mappings);
    }

    /**
     * <p>Fetch all publicly owned enterprises data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPubliclyOwnedEnterprises(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getPubliclyOwnedEnterprises() {
        return getPubliclyOwnedEnterprises(null, null, null, null);
    }

    /**
     * <p>Fetch all publicly owned enterprises data which match the input constraints.</p>
     *
     * @param sectors
     *            the sectors
     * @param typesOfOwnerships
     *            the types of ownerships
     * @param legalEntities
     *            the legal entities
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPubliclyOwnedEnterprises(Collection<String> sectors,
            Collection<Integer> typesOfOwnerships, Collection<Integer> legalEntities, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put(OWNERCATEGORY_CODE, typesOfOwnerships);
        mappings.put("Juridiskform", legalEntities);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("OffFtg", mappings);
    }

    /**
     * <p>Fetch all income statements data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getIncomeStatements(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getIncomeStatements() {
        return getIncomeStatements(null, null, null, null);
    }

    /**
     * <p>Fetch all income statements data which match the input constraints.</p>
     *
     * @param sectors
     *            the sectors
     * @param typesOfOwnerships
     *            the types of ownerships
     * @param industrialClassifications
     *            the industrial classifications
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getIncomeStatements(Collection<String> sectors, Collection<Integer> typesOfOwnerships,
            Collection<String> industrialClassifications, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put(OWNERCATEGORY_CODE, typesOfOwnerships);
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("OffResultSektor", mappings);
    }

    /**
     * <p>Fetch all liabilities and equity data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getLiabilitiesAndEquity(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getLiabilitiesAndEquity() {
        return getLiabilitiesAndEquity(null, null, null, null);
    }

    /**
     * <p>Fetch all liabilities and equity data which match the input constraints.</p>
     *
     * @param sectors
     *            the sectors
     * @param typesOfOwnerships
     *            the types of ownerships
     * @param industrialClassifications
     *            the industrial classifications
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getLiabilitiesAndEquity(Collection<String> sectors,
            Collection<Integer> typesOfOwnerships, Collection<String> industrialClassifications,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put(OWNERCATEGORY_CODE, typesOfOwnerships);
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("OffSkulderSektor", mappings);
    }

    /**
     * <p>Fetch all assets data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAssets(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getAssets() {
        return getAssets(null, null, null, null);
    }

    /**
     * <p>Fetch all assets data which match the input constraints.</p>
     *
     * @param sectors
     *            the sectors
     * @param typesOfOwnerships
     *            the types of ownerships
     * @param industrialClassifications
     *            the industrial classifications
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAssets(Collection<String> sectors, Collection<Integer> typesOfOwnerships,
            Collection<String> industrialClassifications, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put(OWNERCATEGORY_CODE, typesOfOwnerships);
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("OffTillgSektor", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("OE/OE0108/");
    }

}
