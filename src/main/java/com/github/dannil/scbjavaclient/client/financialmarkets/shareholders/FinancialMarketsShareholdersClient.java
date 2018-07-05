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

package com.github.dannil.scbjavaclient.client.financialmarkets.shareholders;

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
 * <p>Client which handles financial markets shareholders data fetching.</p>
 *
 * @since 0.2.0
 */
public class FinancialMarketsShareholdersClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public FinancialMarketsShareholdersClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsShareholdersClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all ownership of shares data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getOwnershipOfShares(Collection, Collection)
     */
    public List<ResponseModel> getOwnershipOfShares() {
        return getOwnershipOfShares(null, null);
    }

    /**
     * <p>Fetch all ownership of shares data which match the input constraints.</p>
     *
     * @param sectors
     *            the sectors to fetch data for
     * @param halfYears
     *            the half years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getOwnershipOfShares(Collection<String> sectors, Collection<String> halfYears) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put(APIConstants.TIME_CODE, halfYears);

        return getResponseModels("AktieAgarNAr", mappings);
    }

    /**
     * <p>Fetch all ownership of shares by marketplace data.</p>
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
     * <p>Fetch all ownership of shares by marketplace data which match the input
     * constraints.</p>
     *
     * @param sectors
     *            the sectors to fetch data for
     * @param marketplaces
     *            the marketplaces to fetch data for
     * @param halfYears
     *            the half years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getOwnershipOfSharesByMarketplace(Collection<String> sectors,
            Collection<String> marketplaces, Collection<String> halfYears) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put("Marknadsplats", marketplaces);
        mappings.put(APIConstants.TIME_CODE, halfYears);

        return getResponseModels("AktieAgarMarknad", mappings);
    }

    /**
     * <p>Fetch all ownership of shares by series data.</p>
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
     * <p>Fetch all ownership of shares by series data which match the input
     * constraints.</p>
     *
     * @param sectors
     *            the sectors to fetch data for
     * @param classesOfShares
     *            the classes of shares to fetch data for
     * @param halfYears
     *            the half years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getOwnershipOfSharesBySeries(Collection<String> sectors,
            Collection<String> classesOfShares, Collection<String> halfYears) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put("Aktieserie", classesOfShares);
        mappings.put(APIConstants.TIME_CODE, halfYears);

        return getResponseModels("AktieAgarSerieN", mappings);
    }

    /**
     * <p>Fetch all foreign ownership of shares data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getForeignOwnershipOfShares(Collection, Collection)
     */
    public List<ResponseModel> getForeignOwnershipOfShares() {
        return getForeignOwnershipOfShares(null, null);
    }

    /**
     * <p>Fetch all foreign ownership of shares data which match the input
     * constraints.</p>
     *
     * @param countries
     *            the countries to fetch data for
     * @param halfYears
     *            the half years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getForeignOwnershipOfShares(Collection<String> countries, Collection<String> halfYears) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Agarland", countries);
        mappings.put(APIConstants.TIME_CODE, halfYears);

        return getResponseModels("AktieAgarUtland", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM0201/");
    }

}
