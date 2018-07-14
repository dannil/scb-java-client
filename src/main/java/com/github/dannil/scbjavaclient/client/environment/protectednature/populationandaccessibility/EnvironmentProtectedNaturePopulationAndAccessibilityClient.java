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

package com.github.dannil.scbjavaclient.client.environment.protectednature.populationandaccessibility;

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
 * <p>Client which handles environment protected nature population and accessibility data
 * fetching.</p>
 *
 * @since 0.5.0
 */
public class EnvironmentProtectedNaturePopulationAndAccessibilityClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentProtectedNaturePopulationAndAccessibilityClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentProtectedNaturePopulationAndAccessibilityClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all protected nature within and around localities data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getProtectedNatureWithinAndAroundLocalities(Collection, Collection)
     */
    public List<ResponseModel> getProtectedNatureWithinAndAroundLocalities() {
        return getProtectedNatureWithinAndAroundLocalities(null, null);
    }

    /**
     * <p>Fetch all protected nature within and around localities data which match the
     * input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getProtectedNatureWithinAndAroundLocalities(Collection<String> regions,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("SkyddadnaturTatort", mappings);
    }

    /**
     * <p>Fetch all population within zone around protected nature data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPopulationWithinZoneAroundProtectedNature(Collection, Collection)
     */
    public List<ResponseModel> getPopulationWithinZoneAroundProtectedNature() {
        return getPopulationWithinZoneAroundProtectedNature(null, null);
    }

    /**
     * <p>Fetch all population within zone around protected nature data which match the
     * input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPopulationWithinZoneAroundProtectedNature(Collection<String> regions,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FmangdAvst", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0603/MI0603P/");
    }

}
