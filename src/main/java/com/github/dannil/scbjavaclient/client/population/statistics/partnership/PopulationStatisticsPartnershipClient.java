/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.population.statistics.partnership;

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
 * <p>Client which handles population statistics partnership data fetching.</p>
 *
 * @since 0.1.0
 */
public class PopulationStatisticsPartnershipClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PopulationStatisticsPartnershipClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationStatisticsPartnershipClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all population partnership data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPartnership(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getPartnership() {
        return getPartnership(null, null, null, null);
    }

    /**
     * <p>Fetch all population partnership data which match the input constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param maritalStatuses
     *            the marital statuses to fetch data for
     * @param sexes
     *            the sexes to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPartnership(Collection<String> regions, Collection<String> maritalStatuses,
            Collection<Integer> sexes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Civilstand", maritalStatuses);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Partnerskap", mappings);
    }

    /**
     * <p>Fetch all population partnership change data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPartnershipChange(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getPartnershipChange() {
        return getPartnershipChange(null, null, null, null);
    }

    /**
     * <p>Fetch all population partnership change data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions to fetch data for
     * @param maritalStatuses
     *            the marital statuses to fetch data for
     * @param sexes
     *            the sexes to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPartnershipChange(Collection<String> regions, Collection<String> maritalStatuses,
            Collection<Integer> sexes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Civilstand", maritalStatuses);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("PartnerskapAndring", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0101/BE0101O/");
    }

}
