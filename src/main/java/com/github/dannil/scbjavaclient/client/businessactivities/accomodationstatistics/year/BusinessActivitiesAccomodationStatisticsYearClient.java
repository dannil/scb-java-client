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

package com.github.dannil.scbjavaclient.client.businessactivities.accomodationstatistics.year;

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
 * <p>Client which handles business activities accomodation statistics year data
 * fetching.</p>
 *
 * @since 0.3.0
 */
public class BusinessActivitiesAccomodationStatisticsYearClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public BusinessActivitiesAccomodationStatisticsYearClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public BusinessActivitiesAccomodationStatisticsYearClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all number of hotels data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNumberOfHotels(Collection, Collection, Collection)
     */
    public List<ResponseModel> getNumberOfHotels() {
        return getNumberOfHotels(null, null, null);
    }

    /**
     * <p>Fetch all number of hotels data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param typesOfEstablishments
     *            the types of establishments
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNumberOfHotels(Collection<String> regions, Collection<String> typesOfEstablishments,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Anlaggning", typesOfEstablishments);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("NV1701T12TotAr", mappings);
    }

    /**
     * <p>Fetch all capacity for hotels data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getCapacityForHotels(Collection, Collection, Collection)
     */
    public List<ResponseModel> getCapacityForHotels() {
        return getCapacityForHotels(null, null, null);
    }

    /**
     * <p>Fetch all capacity for hotels data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param typesOfHousing
     *            the types of housing
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getCapacityForHotels(Collection<String> regions, Collection<String> typesOfHousing,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Overnattningstyp", typesOfHousing);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("NV1701T12Ar", mappings);
    }

    /**
     * <p>Fetch all occupancy rate data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getOccupancyRate(Collection, Collection, Collection)
     */
    public List<ResponseModel> getOccupancyRate() {
        return getOccupancyRate(null, null, null);
    }

    /**
     * <p>Fetch all occupancy rate data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param typesOfHousing
     *            the types of housing
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getOccupancyRate(Collection<String> regions, Collection<String> typesOfHousing,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Overnattningstyp", typesOfHousing);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("NV1701T4Ar", mappings);
    }

    /**
     * <p>Fetch all number of occupied rooms data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNumberOfOccupiedRooms(Collection, Collection)
     */
    public List<ResponseModel> getNumberOfOccupiedRooms() {
        return getNumberOfOccupiedRooms(null, null);
    }

    /**
     * <p>Fetch all number of occupied rooms data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNumberOfOccupiedRooms(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("NV1701T6Ar", mappings);
    }

    /**
     * <p>Fetch all accomodation revenue data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAccomodationRevenue(Collection, Collection)
     */
    public List<ResponseModel> getAccomodationRevenue() {
        return getNumberOfOccupiedRooms(null, null);
    }

    /**
     * <p>Fetch all accomodation revenue data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAccomodationRevenue(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("NV1701T15Ar", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/NV1701/NV1701A/");
    }

}
