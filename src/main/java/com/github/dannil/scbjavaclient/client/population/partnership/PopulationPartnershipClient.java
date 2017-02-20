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

package com.github.dannil.scbjavaclient.client.population.partnership;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.population.partnership.Partnership;
import com.github.dannil.scbjavaclient.model.population.partnership.PartnershipChange;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles population partnership data fetching.</p>
 *
 * @since 0.1.0
 */
public class PopulationPartnershipClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PopulationPartnershipClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationPartnershipClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all population partnership data.</p>
     *
     * @return the population partnership data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.population.partnership.Partnership
     *         Partnership} objects
     *
     * @see #getPartnership(Collection, Collection, Collection, Collection)
     */
    public List<Partnership> getPartnership() {
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
     * @return the population partnership data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.population.partnership.Partnership
     *         Partnership} objects
     */
    public List<Partnership> getPartnership(Collection<String> regions, Collection<String> maritalStatuses,
            Collection<Integer> sexes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", Arrays.asList("BE0101P1"));
        mappings.put("Region", regions);
        mappings.put("Civilstand", maritalStatuses);
        mappings.put("Kon", sexes);
        mappings.put("Tid", years);

        String response = postRequest(getUrl() + "Partnerskap", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(Partnership.class);
    }

    /**
     * <p>Fetch all population partnership change data.</p>
     *
     * @return the population partnership change data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.population.partnership.PartnershipChange
     *         PartnershipChange} objects
     *
     * @see #getPartnershipChange(Collection, Collection, Collection, Collection)
     */
    public List<PartnershipChange> getPartnershipChange() {
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
     * @return the population partnership change data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.population.partnership.PartnershipChange
     *         PartnershipChange} objects
     */
    public List<PartnershipChange> getPartnershipChange(Collection<String> regions, Collection<String> maritalStatuses,
            Collection<Integer> sexes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", Arrays.asList("BE0101XX"));
        mappings.put("Region", regions);
        mappings.put("Civilstand", maritalStatuses);
        mappings.put("Kon", sexes);
        mappings.put("Tid", years);

        String response = postRequest(getUrl() + "PartnerskapAndring", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(PartnershipChange.class);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "BE/BE0101/BE0101O/";
    }

}
