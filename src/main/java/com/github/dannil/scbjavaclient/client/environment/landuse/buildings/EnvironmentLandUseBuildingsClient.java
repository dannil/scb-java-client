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

package com.github.dannil.scbjavaclient.client.environment.landuse.buildings;

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
 * Client which handles environment land use building data fetching.
 *
 * @since 0.2.0
 */
public class EnvironmentLandUseBuildingsClient extends AbstractClient {

    /**
     * Default constructor.
     */
    public EnvironmentLandUseBuildingsClient() {
        super();
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentLandUseBuildingsClient(Locale locale) {
        super(locale);
    }

    /**
     * Fetch all building data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getBuilding(Collection, Collection, Collection)
     */
    public List<ResponseModel> getBuilding() {
        return getBuilding(null, null, null);
    }

    /**
     * Fetch all building data which match the input constraints.
     *
     * @param regions
     *            the regions to fetch data for
     * @param types
     *            the types to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getBuilding(Collection<String> regions, Collection<Integer> types,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Byggnadstyp", types);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MarkanvByggnadLnKn", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0803/MI0803B/");
    }

}
