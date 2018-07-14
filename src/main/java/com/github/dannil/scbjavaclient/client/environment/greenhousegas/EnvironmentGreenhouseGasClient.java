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

package com.github.dannil.scbjavaclient.client.environment.greenhousegas;

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
 * <p>Client which handles environment greenhouse gas data fetching.</p>
 *
 * @since 0.4.0
 */
public class EnvironmentGreenhouseGasClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentGreenhouseGasClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentGreenhouseGasClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all total emissions data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTotalEmissions(Collection, Collection, Collection)
     */
    public List<ResponseModel> getTotalEmissions() {
        return getTotalEmissions(null, null, null);
    }

    /**
     * <p>Fetch all total emissions data which match the input constraints.</p>
     *
     * @param greenhouseGases
     *            the greenhouse gases
     * @param sectors
     *            the sectors
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTotalEmissions(Collection<String> greenhouseGases, Collection<String> sectors,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.GREENHOUSEGAS_CODE, greenhouseGases);
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("TotaltUtslappN", mappings);
    }

    /**
     * <p>Fetch all emissions from waste data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEmissionsFromWaste(Collection, Collection, Collection)
     */
    public List<ResponseModel> getEmissionsFromWaste() {
        return getEmissionsFromWaste(null, null, null);
    }

    /**
     * <p>Fetch all emissions from waste data which match the input constraints.</p>
     *
     * @param greenhouseGases
     *            the greenhouse gases
     * @param subSectors
     *            the sub sectors
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromWaste(Collection<String> greenhouseGases, Collection<String> subSectors,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.GREENHOUSEGAS_CODE, greenhouseGases);
        mappings.put(APIConstants.SUBSECTOR_CODE, subSectors);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0107Avfall", mappings);
    }

    /**
     * <p>Fetch all emissions from heating of houses and buildings data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEmissionsFromHeatingOfHousesAndBuildings(Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getEmissionsFromHeatingOfHousesAndBuildings() {
        return getEmissionsFromHeatingOfHousesAndBuildings(null, null, null);
    }

    /**
     * <p>Fetch all emissions from heating of houses and buildings data which match the
     * input constraints.</p>
     *
     * @param greenhouseGases
     *            the greenhouse gases
     * @param subSectors
     *            the sub sectors
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromHeatingOfHousesAndBuildings(Collection<String> greenhouseGases,
            Collection<String> subSectors, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.GREENHOUSEGAS_CODE, greenhouseGases);
        mappings.put(APIConstants.SUBSECTOR_CODE, subSectors);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0107UppvBoLok", mappings);
    }

    /**
     * <p>Fetch all emissions from land use data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEmissionsFromLandUse(Collection, Collection, Collection)
     */
    public List<ResponseModel> getEmissionsFromLandUse() {
        return getEmissionsFromLandUse(null, null, null);
    }

    /**
     * <p>Fetch all emissions from land use data which match the input constraints.</p>
     *
     * @param greenhouseGases
     *            the greenhouse gases
     * @param subSectors
     *            the sub sectors
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromLandUse(Collection<String> greenhouseGases,
            Collection<String> subSectors, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.GREENHOUSEGAS_CODE, greenhouseGases);
        mappings.put(APIConstants.SUBSECTOR_CODE, subSectors);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0107Markanv", mappings);
    }

    /**
     * <p>Fetch all emissions from domestic transport data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEmissionsFromDomesticTransport(Collection, Collection, Collection)
     */
    public List<ResponseModel> getEmissionsFromDomesticTransport() {
        return getEmissionsFromDomesticTransport(null, null, null);
    }

    /**
     * <p>Fetch all emissions from domestic transport data which match the input
     * constraints.</p>
     *
     * @param greenhouseGases
     *            the greenhouse gases
     * @param modesOfTransports
     *            the modes of transports
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromDomesticTransport(Collection<String> greenhouseGases,
            Collection<String> modesOfTransports, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.GREENHOUSEGAS_CODE, greenhouseGases);
        mappings.put("Transportslag", modesOfTransports);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0107InTransp", mappings);
    }

    /**
     * <p>Fetch all emissions from agriculture data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEmissionsFromAgriculture(Collection, Collection, Collection)
     */
    public List<ResponseModel> getEmissionsFromAgriculture() {
        return getEmissionsFromAgriculture(null, null, null);
    }

    /**
     * <p>Fetch all emissions from agriculture data which match the input constraints.</p>
     *
     * @param greenhouseGases
     *            the greenhouse gases
     * @param subSectors
     *            the sub sectors
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromAgriculture(Collection<String> greenhouseGases,
            Collection<String> subSectors, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.GREENHOUSEGAS_CODE, greenhouseGases);
        mappings.put(APIConstants.SUBSECTOR_CODE, subSectors);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0107Jordbruk", mappings);
    }

    /**
     * <p>Fetch all emissions from international transport data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEmissionsFromInternationalTransport(Collection, Collection, Collection)
     */
    public List<ResponseModel> getEmissionsFromInternationalTransport() {
        return getEmissionsFromInternationalTransport(null, null, null);
    }

    /**
     * <p>Fetch all emissions from international transport data which match the input
     * constraints.</p>
     *
     * @param greenhouseGases
     *            the greenhouse gases
     * @param activities
     *            the activities
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromInternationalTransport(Collection<String> greenhouseGases,
            Collection<String> activities, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.GREENHOUSEGAS_CODE, greenhouseGases);
        mappings.put("Verksamhetsomr", activities);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0107UtrikesTransp", mappings);
    }

    /**
     * <p>Fetch all emissions from solvent use data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEmissionsFromSolventUse(Collection, Collection, Collection)
     */
    public List<ResponseModel> getEmissionsFromSolventUse() {
        return getEmissionsFromSolventUse(null, null, null);
    }

    /**
     * <p>Fetch all emissions from solvent use data which match the input constraints.</p>
     *
     * @param greenhouseGases
     *            the greenhouse gases
     * @param areas
     *            the areas
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromSolventUse(Collection<String> greenhouseGases, Collection<String> areas,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.GREENHOUSEGAS_CODE, greenhouseGases);
        mappings.put("Omrade2", areas);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0107Prodanv", mappings);
    }

    /**
     * <p>Fetch all emissions from off-road vehicles and machinery data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEmissionsFromOffroadVehiclesAndMachinery(Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getEmissionsFromOffroadVehiclesAndMachinery() {
        return getEmissionsFromOffroadVehiclesAndMachinery(null, null, null);
    }

    /**
     * <p>Fetch all emissions from off-road vehicles and machinery data which match the
     * input constraints.</p>
     *
     * @param greenhouseGases
     *            the greenhouse gases
     * @param subSectors
     *            the sub sectors
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromOffroadVehiclesAndMachinery(Collection<String> greenhouseGases,
            Collection<String> subSectors, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.GREENHOUSEGAS_CODE, greenhouseGases);
        mappings.put(APIConstants.SUBSECTOR_CODE, subSectors);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0107ArbMask", mappings);
    }

    /**
     * <p>Fetch all emissions from industry data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEmissionsFromIndustry(Collection, Collection, Collection)
     */
    public List<ResponseModel> getEmissionsFromIndustry() {
        return getEmissionsFromIndustry(null, null, null);
    }

    /**
     * <p>Fetch all emissions from industry data which match the input constraints.</p>
     *
     * @param greenhouseGases
     *            the greenhouse gases
     * @param industries
     *            the industries
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromIndustry(Collection<String> greenhouseGases,
            Collection<String> industries, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.GREENHOUSEGAS_CODE, greenhouseGases);
        mappings.put("Bransch", industries);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0107IndustriN", mappings);
    }

    /**
     * <p>Fetch all emissions from electricity and heating data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEmissionsFromElectricityAndHeating(Collection, Collection, Collection)
     */
    public List<ResponseModel> getEmissionsFromElectricityAndHeating() {
        return getEmissionsFromElectricityAndHeating(null, null, null);
    }

    /**
     * <p>Fetch all emissions from electricity and heating data which match the input
     * constraints.</p>
     *
     * @param greenhouseGases
     *            the greenhouse gases
     * @param fuelTypes
     *            the fuel types
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromElectricityAndHeating(Collection<String> greenhouseGases,
            Collection<String> fuelTypes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.GREENHOUSEGAS_CODE, greenhouseGases);
        mappings.put("BransleMI", fuelTypes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0107ELoFjarrN", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0107/");
    }

}
