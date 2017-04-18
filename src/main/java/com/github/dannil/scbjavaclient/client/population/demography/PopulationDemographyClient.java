/*
 * Copyright 2014 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.population.demography;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.http.URLEndpoint;
import com.github.dannil.scbjavaclient.model.ResponseModel;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles population demography data fetching.</p>
 *
 * @since 0.0.2
 */
public class PopulationDemographyClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PopulationDemographyClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationDemographyClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all fertility rate data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getFertilityRate(Collection, Collection, Collection)
     */
    public List<ResponseModel> getFertilityRate() {
        return getFertilityRate(null, null, null);
    }

    /**
     * <p>Fetch all fertility rate data which match the input constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param genders
     *            the genders to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getFertilityRate(Collection<String> regions, Collection<Integer> genders,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.SEX_CODE, genders);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FruktsamhetSumNy", mappings);
    }

    /**
     * <p>Fetch all mean age for the first child data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getMeanAgeFirstChild(Collection, Collection, Collection)
     */
    public List<ResponseModel> getMeanAgeFirstChild() {
        return getMeanAgeFirstChild(null, null, null);
    }

    /**
     * <p>Fetch all mean age for the first child data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param genders
     *            the genders to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getMeanAgeFirstChild(Collection<String> regions, Collection<Integer> genders,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.SEX_CODE, genders);
        mappings.put(APIConstants.TIME_CODE, years);

        String response = doPostRequest(getUrl() + "MedelAlderNY", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(ResponseModel.class);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0701/");
    }

}
