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

package com.github.dannil.scbjavaclient.client.businessactivities.accomodationstatistics.month;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.http.URLEndpoint;
import com.github.dannil.scbjavaclient.model.ResponseModel;

/**
 * <p>Client which handles business activities accomodation statistics month data
 * fetching.</p>
 *
 * @since 0.3.0
 */
public class BusinessActivitiesAccomodationStatisticsMonthClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public BusinessActivitiesAccomodationStatisticsMonthClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public BusinessActivitiesAccomodationStatisticsMonthClient(Locale locale) {
        super(locale);
    }

    public List<ResponseModel> getTotalCapacity() {
        return getTotalCapacity(null, null);
    }

    public List<ResponseModel> getTotalCapacity(Collection<String> typesOfEstablishments, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Anlaggning", typesOfEstablishments);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("NV1701T3M", mappings);
    }

    public List<ResponseModel> getAvailableBeds() {
        return getAvailableBeds(null, null);
    }

    public List<ResponseModel> getAvailableBeds(Collection<String> regions, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("NV1701T5BM", mappings);
    }

    public List<ResponseModel> getNumberOfAvailableRooms() {
        return getNumberOfAvailableRooms(null, null);
    }

    public List<ResponseModel> getNumberOfAvailableRooms(Collection<String> regions, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("NV1701T7M", mappings);
    }

    public List<ResponseModel> getNightsSpent() {
        return getNightsSpent(null, null, null);
    }

    public List<ResponseModel> getNightsSpent(Collection<String> regions, Collection<String> typesOfEstablishments,
            Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Anlaggning", typesOfEstablishments);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("NV1701T10M", mappings);
    }

    public List<ResponseModel> getOccupancy() {
        return getOccupancy(null, null);
    }

    public List<ResponseModel> getOccupancy(Collection<String> typesOfHousing, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Overnattningstyp", typesOfHousing);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("NV1701T5M", mappings);
    }

    public List<ResponseModel> getOccupiedRooms() {
        return getOccupiedRooms(null, null);
    }

    public List<ResponseModel> getOccupiedRooms(Collection<String> regions, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("NV1701T6M", mappings);
    }

    public List<ResponseModel> getRevenueOfOccupiedRooms() {
        return getRevenueOfOccupiedRooms(null);
    }

    public List<ResponseModel> getRevenueOfOccupiedRooms(Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("NV1701T8M", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/NV1701/NV1701B/");
    }

}
