/*
 * Copyright 2020 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.financialmarkets.shareholders.swedishmarketplace;

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
 * Client which handles financial markets shareholders Swedish marketplace data
 * fetching.
 *
 * @since 3.0.0
 */
public class FinancialMarketsShareholdersSwedishMarketplaceClient extends AbstractClient {

    /**
     * Default constructor.
     */
    public FinancialMarketsShareholdersSwedishMarketplaceClient() {
        super();
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsShareholdersSwedishMarketplaceClient(Locale locale) {
        super(locale);
    }

    /**
     * Fetch all ownership of shares by marketplace data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getOwnershipOfSharesByMarketplace(Collection, Collection, Collection)
     */
    public List<ResponseModel> getOwnershipOfSharesByMarketplace() {
        return getOwnershipOfSharesByMarketplace(null, null, null);
    }

    /**
     * Fetch all ownership of shares by marketplace data which match the input
     * constraints.
     *
     * @param sectors
     *            the sectors to fetch data for
     * @param marketplaces
     *            the marketplaces to fetch data for
     * @param twoTimesPerYears
     *            the two times per years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getOwnershipOfSharesByMarketplace(Collection<String> sectors,
            Collection<String> marketplaces, Collection<String> twoTimesPerYears) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put("Marknadsplats", marketplaces);
        mappings.put(APIConstants.TIME_CODE, twoTimesPerYears);

        return getResponseModels("AktieAgarMarknad", mappings);
    }

    /**
     * Fetch all ownership of shares by series data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getOwnershipOfSharesBySeries(Collection, Collection, Collection)
     */
    public List<ResponseModel> getOwnershipOfSharesBySeries() {
        return getOwnershipOfSharesBySeries(null, null, null);
    }

    /**
     * Fetch all ownership of shares by series data which match the input
     * constraints.
     *
     * @param sectors
     *            the sectors to fetch data for
     * @param classesOfShares
     *            the classes of shares to fetch data for
     * @param twoTimesPerYears
     *            the two times per years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getOwnershipOfSharesBySeries(Collection<String> sectors,
            Collection<String> classesOfShares, Collection<String> twoTimesPerYears) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put("Aktieserie", classesOfShares);
        mappings.put(APIConstants.TIME_CODE, twoTimesPerYears);

        return getResponseModels("AktieAgarSerieN", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM0201/FM0201A");
    }

}
