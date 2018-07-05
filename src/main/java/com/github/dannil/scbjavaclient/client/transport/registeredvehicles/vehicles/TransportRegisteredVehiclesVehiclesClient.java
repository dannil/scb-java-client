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

package com.github.dannil.scbjavaclient.client.transport.registeredvehicles.vehicles;

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
 * <p>Client which handles transport registered vehicles vehicles data fetching.</p>
 *
 * @since 0.4.0
 */
public class TransportRegisteredVehiclesVehiclesClient extends AbstractClient {

    private static final String TYPEOFVEHICLE_CODE = "Fordonsslag";

    /**
     * <p>Default constructor.</p>
     */
    public TransportRegisteredVehiclesVehiclesClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public TransportRegisteredVehiclesVehiclesClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all vehicles in use data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getVehiclesInUse(Collection, Collection, Collection)
     */
    public List<ResponseModel> getVehiclesInUse() {
        return getVehiclesInUse(null, null, null);
    }

    /**
     * <p>Fetch all vehicles in use data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param typesOfVehicles
     *            the types of vehicles
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getVehiclesInUse(Collection<String> regions, Collection<Integer> typesOfVehicles,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(TYPEOFVEHICLE_CODE, typesOfVehicles);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FordonTrafik", mappings);
    }

    /**
     * <p>Fetch all new registrations of passenger cars data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNewRegistrationsOfPassengerCars(Collection, Collection, Collection)
     */
    public List<ResponseModel> getNewRegistrationsOfPassengerCars() {
        return getNewRegistrationsOfPassengerCars(null, null, null);
    }

    /**
     * <p>Fetch all new registrations of passenger cars data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param fuels
     *            the fuels
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNewRegistrationsOfPassengerCars(Collection<String> regions, Collection<Integer> fuels,
            Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Drivmedel", fuels);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("PersBilarDrivMedel", mappings);
    }

    /**
     * <p>Fetch all vehicles from the vehicle register data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getVehiclesFromTheVehicleRegister(Collection, Collection,Collection)
     */
    public List<ResponseModel> getVehiclesFromTheVehicleRegister() {
        return getVehiclesFromTheVehicleRegister(null, null, null);
    }

    /**
     * <p>Fetch all vehicles from the vehicle register data which match the input
     * constraints.</p>
     *
     * @param typesOfVehicles
     *            the types of vehicles
     * @param statuses
     *            the statuses
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getVehiclesFromTheVehicleRegister(Collection<String> typesOfVehicles,
            Collection<String> statuses, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(TYPEOFVEHICLE_CODE, typesOfVehicles);
        mappings.put("Bestand", statuses);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("Fordon", mappings);
    }

    /**
     * <p>Fetch all passenger cars in use data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPassengerCarsInUse(Collection, Collection, Collection)
     */
    public List<ResponseModel> getPassengerCarsInUse() {
        return getPassengerCarsInUse(null, null, null);
    }

    /**
     * <p>Fetch all passenger cars in use data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param typesOfOwnerships
     *            the types of ownerships
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPassengerCarsInUse(Collection<String> regions, Collection<String> typesOfOwnerships,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Agarkategori", typesOfOwnerships);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("PersBilarA", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("TK/TK1001/TK1001A/");
    }

}
