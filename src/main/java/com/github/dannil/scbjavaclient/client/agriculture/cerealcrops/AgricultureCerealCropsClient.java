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

package com.github.dannil.scbjavaclient.client.agriculture.cerealcrops;

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
 * <p>Client which handles agriculture cereal crops data fetching.</p>
 *
 * @since 0.4.0
 */
public class AgricultureCerealCropsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public AgricultureCerealCropsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public AgricultureCerealCropsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all yield per hectar and total production data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getYieldPerHectarAndTotalProduction(Collection, Collection, Collection)
     */
    public List<ResponseModel> getYieldPerHectarAndTotalProduction() {
        return getYieldPerHectarAndTotalProduction(null, null, null);
    }

    /**
     * <p>Fetch all yield per hectar and total production data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param crops
     *            the crops
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getYieldPerHectarAndTotalProduction(Collection<String> regions,
            Collection<Integer> crops, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Groda", crops);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("SkordarL", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("JO/JO0601/");
    }

}
