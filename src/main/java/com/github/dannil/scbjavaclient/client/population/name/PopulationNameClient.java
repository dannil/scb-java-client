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

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.http.URLEndpoint;
import com.github.dannil.scbjavaclient.model.ResponseModel;

/**
 * <p>Client which handles population statistics name data fetching.</p>
 *
 * @since 0.0.2
 */
public class PopulationNameClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PopulationNameClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationNameClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all number of children born with first name data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNumberOfChildrenBornWithFirstName(Collection, Collection)
     */
    public List<ResponseModel> getNumberOfChildrenBornWithFirstName() {
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
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNumberOfChildrenBornWithFirstName(Collection<String> firstnames,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Tilltalsnamn", firstnames);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BE0001T04Ar", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0001/");
    }

}
