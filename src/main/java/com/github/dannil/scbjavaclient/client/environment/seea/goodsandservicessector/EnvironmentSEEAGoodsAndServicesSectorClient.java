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

package com.github.dannil.scbjavaclient.client.environment.seea.goodsandservicessector;

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
 * <p>Client which handles environment System of Environmental-Economic Accounting (SEEA)
 * goods and services sector data fetching.</p>
 *
 * @since 0.4.0
 */
public class EnvironmentSEEAGoodsAndServicesSectorClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentSEEAGoodsAndServicesSectorClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentSEEAGoodsAndServicesSectorClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all environmental sector by environmental area data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEnvironmentalSectorByEnvironmentalArea(Collection, Collection)
     */
    public List<ResponseModel> getEnvironmentalSectorByEnvironmentalArea() {
        return getEnvironmentalSectorByEnvironmentalArea(null, null);
    }

    /**
     * <p>Fetch all environmental sector by environmental area data which match the input
     * constraints.</p>
     *
     * @param environmentalAreas
     *            the environmental areas
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEnvironmentalSectorByEnvironmentalArea(Collection<Integer> environmentalAreas,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Miljoomrade", environmentalAreas);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MiljosektorOmr", mappings);
    }

    /**
     * <p>Fetch all environmental sector by county data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEnvironmentalSectorByCounty(Collection, Collection)
     */
    public List<ResponseModel> getEnvironmentalSectorByCounty() {
        return getEnvironmentalSectorByCounty(null, null);
    }

    /**
     * <p>Fetch all environmental sector by county data which match the input
     * constraints.</p>
     *
     * @param counties
     *            the counties
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEnvironmentalSectorByCounty(Collection<String> counties, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Lan", counties);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MiljosektorLan", mappings);
    }

    /**
     * <p>Fetch all environmental sector by industry data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEnvironmentalSectorByIndustry(Collection, Collection)
     */
    public List<ResponseModel> getEnvironmentalSectorByIndustry() {
        return getEnvironmentalSectorByIndustry(null, null);
    }

    /**
     * <p>Fetch all environmental sector by industry data which match the input
     * constraints.</p>
     *
     * @param naceGroups
     *            the NACE groups
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEnvironmentalSectorByIndustry(Collection<String> naceGroups,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Branschgrupp", naceGroups);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MiljosektorBrGrp", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI1301/MI1301D/");
    }

}
