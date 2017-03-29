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

package com.github.dannil.scbjavaclient.client.environment.industrialwateruse;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.http.EndpointURL;
import com.github.dannil.scbjavaclient.model.environment.industrialwateruse.WaterAbstraction;
import com.github.dannil.scbjavaclient.model.environment.industrialwateruse.WaterDischarge;
import com.github.dannil.scbjavaclient.model.environment.industrialwateruse.WaterUse;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles environment industrial water use data fetching.</p>
 *
 * @since 0.2.0
 */
public class EnvironmentIndustrialWaterUseClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentIndustrialWaterUseClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentIndustrialWaterUseClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all water abstraction data.</p>
     *
     * @return the water abstraction data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.industrialwateruse.WaterAbstraction
     *         WaterAbstraction} objects
     *
     * @see #getWaterAbstraction(Collection, Collection, Collection)
     */
    public List<WaterAbstraction> getWaterAbstraction() {
        return getWaterAbstraction(null, null, null);
    }

    /**
     * <p>Fetch all water abstraction data which match the input constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param type
     *            the type to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the water abstraction data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.industrialwateruse.WaterAbstraction
     *         WaterAbstraction} objects
     */
    public List<WaterAbstraction> getWaterAbstraction(Collection<String> regions, Collection<Integer> type,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("VattenTyp", type);
        mappings.put(APIConstants.TIME_CODE, years);

        String response = doPostRequest(getUrl() + "UttagVatten", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(WaterAbstraction.class);
    }

    /**
     * <p>Fetch all water use data.</p>
     *
     * @return the water use data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.industrialwateruse.WaterUse
     *         WaterUse} objects
     *
     * @see #getWaterUse(Collection, Collection, Collection)
     */
    public List<WaterUse> getWaterUse() {
        return getWaterUse(null, null, null);
    }

    /**
     * <p>Fetch all water use data which match the input constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param type
     *            the type to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the water use data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.industrialwateruse.WaterUse
     *         WaterUse} objects
     */
    public List<WaterUse> getWaterUse(Collection<String> regions, Collection<Integer> type, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("VattenTyp", type);
        mappings.put(APIConstants.TIME_CODE, years);

        String response = doPostRequest(getUrl() + "VattenAnv", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(WaterUse.class);
    }

    /**
     * <p>Fetch all water discharge data.</p>
     *
     * @return the water discharge data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.industrialwateruse.WaterDischarge
     *         WaterDischarge} objects
     *
     * @see #getWaterDischarge(Collection, Collection, Collection)
     */
    public List<WaterDischarge> getWaterDischarge() {
        return getWaterDischarge(null, null, null);
    }

    /**
     * <p>Fetch all water discharge data which match the input constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param type
     *            the type to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the water abstraction data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.industrialwateruse.WaterDischarge
     *         WaterDischarge} objects
     */
    public List<WaterDischarge> getWaterDischarge(Collection<String> regions, Collection<Integer> type,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Recipient", type);
        mappings.put(APIConstants.TIME_CODE, years);

        String response = doPostRequest(getUrl() + "UtslappVatten", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(WaterDischarge.class);
    }

    @Override
    public EndpointURL getUrl() {
        return getRootUrl().append("MI/MI0903/");
    }
}
