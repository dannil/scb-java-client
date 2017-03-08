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

package com.github.dannil.scbjavaclient.client.finance.shareholders;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.finance.shareholders.ForeignOwnershipOfShares;
import com.github.dannil.scbjavaclient.model.finance.shareholders.OwnershipOfShares;
import com.github.dannil.scbjavaclient.model.finance.shareholders.OwnershipOfSharesByMarketplace;
import com.github.dannil.scbjavaclient.model.finance.shareholders.OwnershipOfSharesBySeries;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles finance shareholders data fetching.</p>
 *
 * @since 0.2.0
 */
public class FinanceShareholdersClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public FinanceShareholdersClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinanceShareholdersClient(Locale locale) {
        super(locale);
    }

    public List<OwnershipOfShares> getOwnershipOfShares() {
        return getOwnershipOfShares(null, null);
    }

    public List<OwnershipOfShares> getOwnershipOfShares(Collection<String> sectors, Collection<String> halfYears) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", Arrays.asList("FM0201A1", "FM0201A2"));
        mappings.put("Sektor", sectors);
        mappings.put("Tid", halfYears);

        String response = doPostRequest(getUrl() + "AktieAgarAr", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(OwnershipOfShares.class);
    }

    public List<OwnershipOfSharesByMarketplace> getOwnershipOfSharesByMarketplace() {
        return getOwnershipOfSharesByMarketplace(null, null, null);
    }

    public List<OwnershipOfSharesByMarketplace> getOwnershipOfSharesByMarketplace(Collection<String> sectors,
            Collection<String> marketplaces, Collection<String> halfYears) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", Arrays.asList("FM0201C1", "FM0201C2"));
        mappings.put("Sektor", sectors);
        mappings.put("Marknadsplats", marketplaces);
        mappings.put("Tid", halfYears);

        String response = doPostRequest(getUrl() + "AktieAgarMarknad", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(OwnershipOfSharesByMarketplace.class);
    }

    public List<OwnershipOfSharesBySeries> getOwnershipOfSharesBySeries() {
        return getOwnershipOfSharesBySeries(null, null, null);
    }

    public List<OwnershipOfSharesBySeries> getOwnershipOfSharesBySeries(Collection<String> sectors,
            Collection<String> series, Collection<String> halfYears) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", Arrays.asList("FM0201B1", "FM0201B2", "FM0201B3"));
        mappings.put("Sektor", sectors);
        mappings.put("Aktieserie", series);
        mappings.put("Tid", halfYears);

        String response = doPostRequest(getUrl() + "AktieAgarSerie", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(OwnershipOfSharesBySeries.class);
    }

    public List<ForeignOwnershipOfShares> getForeignOwnershipOfShares() {
        return getForeignOwnershipOfShares(null, null);
    }

    public List<ForeignOwnershipOfShares> getForeignOwnershipOfShares(Collection<String> countries,
            Collection<String> halfYears) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", Arrays.asList("FM0201D1", "FM0201D2"));
        mappings.put("Agarland", countries);
        mappings.put("Tid", halfYears);

        String response = doPostRequest(getUrl() + "AktieAgarUtland", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(ForeignOwnershipOfShares.class);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "FM/FM0201/";
    }

}
