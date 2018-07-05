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

package com.github.dannil.scbjavaclient.client.livingconditions.families.adoptions;

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
 * <p>Client which handles living conditions families adoptions data fetching.</p>
 *
 * @since 0.2.0
 */
public class LivingConditionsFamiliesAdoptionsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public LivingConditionsFamiliesAdoptionsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public LivingConditionsFamiliesAdoptionsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all adopted children and young persons aged 0-21 data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAllAdoptedChildrenAndYoungPersons(Collection, Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getAllAdoptedChildrenAndYoungPersons() {
        return getAllAdoptedChildrenAndYoungPersons(null, null, null, null);
    }

    /**
     * <p>Fetch all adopted children and young persons aged 0-21 data which match the
     * input constraints.</p>
     *
     * @param sexes
     *            the sexes
     * @param ages
     *            the ages
     * @param birthCountries
     *            the birth countries
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAllAdoptedChildrenAndYoungPersons(Collection<String> sexes, Collection<String> ages,
            Collection<String> birthCountries, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put("Fodelseland", birthCountries);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BarnAdoptionN", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("LE/LE0102/LE0102I/");
    }

}
