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

package com.github.dannil.scbjavaclient.client.population.name.registeredpersons;

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
 * <p>Client which handles population name registered persons data fetching.</p>
 *
 * @since 0.5.0
 */
public class PopulationNameRegisteredPersonsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PopulationNameRegisteredPersonsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationNameRegisteredPersonsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all first names normally used data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getFirstNamesNormallyUsed(Collection, Collection)
     */
    public List<ResponseModel> getFirstNamesNormallyUsed() {
        return getFirstNamesNormallyUsed(null, null);
    }

    /**
     * <p>Fetch all first names normally used data which match the input constraints.</p>
     *
     * @param firstnames
     *            the firstnames
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getFirstNamesNormallyUsed(Collection<String> firstnames, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Tilltalsnamn", firstnames);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BE0001T06AR", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0001/BE0001G/");
    }

}
