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

package com.github.dannil.scbjavaclient.client.financialmarkets.statistics.claimsandliabilities;

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
 * <p>Client which handles financial markets statistics claims and liabilities data
 * fetching.</p>
 *
 * @since 0.4.0
 */
public class FinancialMarketsStatisticsClaimsAndLiabilitiesClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public FinancialMarketsStatisticsClaimsAndLiabilitiesClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsStatisticsClaimsAndLiabilitiesClient(Locale locale) {
        super(locale);
    }

    // Daniel 2017-05-30: Returns HTTP 403
    /**
     * <p>Fetch all claims and liabilities outside Sweden data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getClaimsAndLiabilitiesOutsideSweden(Collection, Collection, Collection,
     *      Collection, Collection)
     */
    public List<ResponseModel> getClaimsAndLiabilitiesOutsideSweden() {
        return getClaimsAndLiabilitiesOutsideSweden(null, null, null, null, null);
    }

    /**
     * <p>Fetch all claims and liabilities outside Sweden data which match the input
     * constraints.</p>
     *
     * @param positions
     *            the positions
     * @param countryGroups
     *            the country groups
     * @param counterPartySectors
     *            the counter party sectors
     * @param currencies
     *            the currencies
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getClaimsAndLiabilitiesOutsideSweden(Collection<String> positions,
            Collection<String> countryGroups, Collection<String> counterPartySectors, Collection<Integer> currencies,
            Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Position", positions);
        mappings.put("LandLandgrupper", countryGroups);
        mappings.put("Motpartssektor", counterPartySectors);
        mappings.put("Valuta", currencies);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("MFIFordSku", mappings);
    }

    /**
     * <p>Fetch all consolidated claims outside Sweden data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getConsolidatedClaimsOutsideSweden(Collection, Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getConsolidatedClaimsOutsideSweden() {
        return getConsolidatedClaimsOutsideSweden(null, null, null, null);
    }

    /**
     * <p>Fetch all consolidated claims outside Sweden data which match the input
     * constraints.</p>
     *
     * @param positions
     *            the positions
     * @param countryGroups
     *            the country groups
     * @param counterPartySectors
     *            the counter party sectors
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getConsolidatedClaimsOutsideSweden(Collection<String> positions,
            Collection<String> countryGroups, Collection<String> counterPartySectors, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Position", positions);
        mappings.put("LandLandgrupper", countryGroups);
        mappings.put("Motpartssektor", counterPartySectors);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("MFIFord", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM5001/FM5001B/");
    }

}
