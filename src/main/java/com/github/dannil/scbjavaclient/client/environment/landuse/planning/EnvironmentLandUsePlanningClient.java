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

package com.github.dannil.scbjavaclient.client.environment.landuse.planning;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.http.EndpointURL;
import com.github.dannil.scbjavaclient.model.environment.landuse.planning.Planning;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles environment land use planning data fetching.</p>
 *
 * @since 0.2.0
 */
public class EnvironmentLandUsePlanningClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentLandUsePlanningClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentLandUsePlanningClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all planning data.</p>
     *
     * @return the planning data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.landuse.planning.Planning
     *         Planning} objects
     *
     * @see #getPlanning(Collection, Collection)
     */
    public List<Planning> getPlanning() {
        return getPlanning(null, null);
    }

    /**
     * <p>Fetch all planning data which match the input constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the planning data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.landuse.planning.Planning
     *         Planning} objects
     */
    public List<Planning> getPlanning(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        String response = doPostRequest(getUrl() + "MarkanvFornl", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(Planning.class);
    }

    @Override
    public EndpointURL getUrl() {
        return getRootUrl().append("MI/MI0803/MI0803C/");
    }

}
