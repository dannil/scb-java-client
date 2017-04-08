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
import com.github.dannil.scbjavaclient.http.URLEndpoint;
import com.github.dannil.scbjavaclient.model.ResponseModel;

/**
 * <p>Client which handles environment industrial water use data fetching.</p>
 *
 * @since 0.2.0
 */
public class IndustrialWaterUseClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public IndustrialWaterUseClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public IndustrialWaterUseClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all water abstraction data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getWaterAbstraction(Collection, Collection, Collection)
     */
    public List<ResponseModel> getWaterAbstraction() {
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
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getWaterAbstraction(Collection<String> regions, Collection<Integer> type,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("VattenTyp", type);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("UttagVatten", mappings);
    }

    /**
     * <p>Fetch all water use data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getWaterUse(Collection, Collection, Collection)
     */
    public List<ResponseModel> getWaterUse() {
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
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getWaterUse(Collection<String> regions, Collection<Integer> type,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("VattenTyp", type);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("VattenAnv", mappings);
    }

    /**
     * <p>Fetch all water discharge data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getWaterDischarge(Collection, Collection, Collection)
     */
    public List<ResponseModel> getWaterDischarge() {
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
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getWaterDischarge(Collection<String> regions, Collection<Integer> type,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Recipient", type);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("UtslappVatten", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0903/");
    }
}
