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

package com.github.dannil.scbjavaclient.client.environment.airpollutants;

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
 * <p>Client which handles environment air pollutants data fetching.</p>
 *
 * @since 0.4.0
 */
public class EnvironmentAirPollutantsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentAirPollutantsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentAirPollutantsClient(Locale locale) {
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
     * @param airPollutants
     *            the air pollutants
     * @param sectors
     *            the sectors
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTotalEmissions(Collection<String> airPollutants, Collection<String> sectors,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.AIRPOLLUTANT_CODE, airPollutants);
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("TotaltUtslapp", mappings);
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
     * @param airPollutants
     *            the air pollutants
     * @param subSectors
     *            the sub sectors
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromOffroadVehiclesAndMachinery(Collection<String> airPollutants,
            Collection<String> subSectors, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.AIRPOLLUTANT_CODE, airPollutants);
        mappings.put(APIConstants.SUBSECTOR_CODE, subSectors);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0108ArbMask", mappings);
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
     * @param airPollutants
     *            the air pollutants
     * @param subSectors
     *            the sub sectors
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromWaste(Collection<String> airPollutants, Collection<String> subSectors,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.AIRPOLLUTANT_CODE, airPollutants);
        mappings.put(APIConstants.SUBSECTOR_CODE, subSectors);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0108Avfall", mappings);
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
     * @param airPollutants
     *            the air pollutants
     * @param fuelTypes
     *            the fuel types
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromElectricityAndHeating(Collection<String> airPollutants,
            Collection<String> fuelTypes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.AIRPOLLUTANT_CODE, airPollutants);
        mappings.put("BransleMI", fuelTypes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0108EloFjarr", mappings);
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
     * @param airPollutants
     *            the air pollutants
     * @param industries
     *            the industries
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromIndustry(Collection<String> airPollutants, Collection<String> industries,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.AIRPOLLUTANT_CODE, airPollutants);
        mappings.put("Bransch", industries);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0108Industri", mappings);
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
     * @param airPollutants
     *            the air pollutants
     * @param modesOfTransports
     *            the modes of transports
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromDomesticTransport(Collection<String> airPollutants,
            Collection<String> modesOfTransports, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.AIRPOLLUTANT_CODE, airPollutants);
        mappings.put("Transportslag", modesOfTransports);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0108InTransp", mappings);
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
     * @param airPollutants
     *            the air pollutants
     * @param subSectors
     *            the sub sectors
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromAgriculture(Collection<String> airPollutants,
            Collection<String> subSectors, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.AIRPOLLUTANT_CODE, airPollutants);
        mappings.put(APIConstants.SUBSECTOR_CODE, subSectors);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0108Jordbruk", mappings);
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
     * @param airPollutants
     *            the air pollutants
     * @param areas
     *            the areas
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromSolventUse(Collection<String> airPollutants, Collection<String> areas,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.AIRPOLLUTANT_CODE, airPollutants);
        mappings.put("Omrade2", areas);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0108Prodanv", mappings);
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
     * @param airPollutants
     *            the air pollutants
     * @param subSectors
     *            the sub sectors
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromHeatingOfHousesAndBuildings(Collection<String> airPollutants,
            Collection<String> subSectors, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.AIRPOLLUTANT_CODE, airPollutants);
        mappings.put(APIConstants.SUBSECTOR_CODE, subSectors);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0108UppvBoLok", mappings);
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
     * @param airPollutants
     *            the air pollutants
     * @param activities
     *            the activities
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEmissionsFromInternationalTransport(Collection<String> airPollutants,
            Collection<String> activities, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.AIRPOLLUTANT_CODE, airPollutants);
        mappings.put("Verksamhetsomr", activities);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI0108UtrikesTransp", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0108/");
    }

}
