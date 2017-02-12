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

package com.github.dannil.scbjavaclient.client.population.name;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.population.name.NumberOfChildrenBornWithFirstName;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;
import com.github.dannil.scbjavaclient.utility.URLUtility;

/**
 * <p>Client which handles population name statistics data fetching.</p>
 *
 * @since 0.0.2
 */
public class PopulationNameStatisticsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PopulationNameStatisticsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationNameStatisticsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all number of children born with first name data.</p>
     *
     * @return the number of children born with first name data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.population.name.NumberOfChildrenBornWithFirstName
     *         NumberOfChildrenBornWithFirstName} objects
     *
     * @see #getNumberOfChildrenBornWithFirstName(Collection, Collection)
     */
    public List<NumberOfChildrenBornWithFirstName> getNumberOfChildrenBornWithFirstName() {
        return getNumberOfChildrenBornWithFirstName(null, null);
    }

    /**
     * <p>Fetch number of children born with first name data which match the input
     * constraints.</p>
     *
     * @param firstnames
     *            the firstnames to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the number of children born with first name data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.population.name.NumberOfChildrenBornWithFirstName
     *         NumberOfChildrenBornWithFirstName} objects
     */
    public List<NumberOfChildrenBornWithFirstName> getNumberOfChildrenBornWithFirstName(Collection<String> firstnames,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", Arrays.asList("BE0001AH"));
        mappings.put("Tilltalsnamn", firstnames);
        mappings.put("Tid", years);

        String response = super.post("BE/BE0001/BE0001T04Ar", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(NumberOfChildrenBornWithFirstName.class);
    }

    @Override
    public String getUrl() {
        return URLUtility.getRootUrl(getLocale()) + "BE/BE0001/";
    }

}
