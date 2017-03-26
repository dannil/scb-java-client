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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.financialmarkets.shareholders.ForeignOwnershipOfShares;
import com.github.dannil.scbjavaclient.model.financialmarkets.shareholders.OwnershipOfShares;
import com.github.dannil.scbjavaclient.model.financialmarkets.shareholders.OwnershipOfSharesByMarketplace;
import com.github.dannil.scbjavaclient.model.financialmarkets.shareholders.OwnershipOfSharesBySeries;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

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
     * @return the ownership of shares data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.financialmarkets.shareholders.OwnershipOfShares
     *         OwnershipOfShares} objects
     *
     * @see #getOwnershipOfShares(Collection, Collection)
     */
    public List<OwnershipOfShares> getOwnershipOfShares() {
        return getOwnershipOfShares(null, null);
    }

    /**
     * <p>Fetch all ownership of shares data which match the input constraints.</p>
     *
     * @param sectors
     *            the sectors to fetch data for
     * @param halfYears
     *            the half years to fetch data for
     * @return the ownership of shares data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.financialmarkets.shareholders.OwnershipOfShares
     *         OwnershipOfShares} objects
     */
    public List<OwnershipOfShares> getOwnershipOfShares(Collection<String> sectors, Collection<String> halfYears) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.CONTENTSCODE_CODE, Arrays.asList("FM0201A1", "FM0201A2"));
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put(APIConstants.TIME_CODE, halfYears);

        String response = doPostRequest(getUrl() + "AktieAgarAr", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(OwnershipOfShares.class);
    }

    /**
     * <p>Fetch all ownership of shares by marketplace data.</p>
     *
     * @return the ownership of shares by marketplace data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.financialmarkets.shareholders.OwnershipOfSharesByMarketplace
     *         OwnershipOfSharesByMarketplace} objects
     *
     * @see #getOwnershipOfSharesByMarketplace(Collection, Collection, Collection)
     */
    public List<OwnershipOfSharesByMarketplace> getOwnershipOfSharesByMarketplace() {
        return getOwnershipOfSharesByMarketplace(null, null, null);
    }

    /**
     * <p>Fetch all ownership of shares by marketplace data which match the input
     * constraints.</p>
     *
     * @param sectors
     *            the sectors to fetch data for
     * @param halfYears
     *            the half years to fetch data for
     * @param marketplaces
     *            the marketplaces to fetch data for
     * @return the ownership of shares by marketplace data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.financialmarkets.shareholders.OwnershipOfSharesByMarketplace
     *         OwnershipOfSharesByMarketplace} objects
     */
    public List<OwnershipOfSharesByMarketplace> getOwnershipOfSharesByMarketplace(Collection<String> sectors,
            Collection<String> marketplaces, Collection<String> halfYears) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.CONTENTSCODE_CODE, Arrays.asList("FM0201C1", "FM0201C2"));
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put("Marknadsplats", marketplaces);
        mappings.put(APIConstants.TIME_CODE, halfYears);

        String response = doPostRequest(getUrl() + "AktieAgarMarknad", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(OwnershipOfSharesByMarketplace.class);
    }

    /**
     * <p>Fetch all ownership of shares by series data.</p>
     *
     * @return the ownership of of shares by series data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.financialmarkets.shareholders.OwnershipOfSharesBySeries
     *         OwnershipOfSharesBySeries} objects
     *
     * @see #getOwnershipOfSharesBySeries(Collection, Collection, Collection)
     */
    public List<OwnershipOfSharesBySeries> getOwnershipOfSharesBySeries() {
        return getOwnershipOfSharesBySeries(null, null, null);
    }

    /**
     * <p>Fetch all ownership of shares by series data which match the input
     * constraints.</p>
     *
     * @param sectors
     *            the sectors to fetch data for
     * @param halfYears
     *            the half years to fetch data for
     * @param series
     *            the series to fetch data for
     * @return the ownership of shares by series data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.financialmarkets.shareholders.OwnershipOfSharesBySeries
     *         OwnershipOfSharesBySeries} objects
     */
    public List<OwnershipOfSharesBySeries> getOwnershipOfSharesBySeries(Collection<String> sectors,
            Collection<String> series, Collection<String> halfYears) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.CONTENTSCODE_CODE, Arrays.asList("FM0201B1", "FM0201B2", "FM0201B3"));
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put("Aktieserie", series);
        mappings.put(APIConstants.TIME_CODE, halfYears);

        String response = doPostRequest(getUrl() + "AktieAgarSerie", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(OwnershipOfSharesBySeries.class);
    }

    /**
     * <p>Fetch all foreign ownership of shares data.</p>
     *
     * @return the foreign ownership of shares data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.financialmarkets.shareholders.ForeignOwnershipOfShares
     *         ForeignOwnershipOfShares} objects
     *
     * @see #getForeignOwnershipOfShares(Collection, Collection)
     */
    public List<ForeignOwnershipOfShares> getForeignOwnershipOfShares() {
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
     * @return the foreign ownership of shares data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.financialmarkets.shareholders.ForeignOwnershipOfShares
     *         ForeignOwnershipOfShares} objects
     */
    public List<ForeignOwnershipOfShares> getForeignOwnershipOfShares(Collection<String> countries,
            Collection<String> halfYears) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.CONTENTSCODE_CODE, Arrays.asList("FM0201D1", "FM0201D2"));
        mappings.put("Agarland", countries);
        mappings.put(APIConstants.TIME_CODE, halfYears);

        String response = doPostRequest(getUrl() + "AktieAgarUtland", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(ForeignOwnershipOfShares.class);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "FM/FM0201/";
    }

}
