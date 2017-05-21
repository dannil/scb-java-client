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

package com.github.dannil.scbjavaclient.client.agriculture.livestock;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles agriculture livestock data fetching.</p>
 *
 * @since 0.4.0
 */
public class AgricultureLivestockClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public AgricultureLivestockClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public AgricultureLivestockClient(Locale locale) {
        super(locale);
    }

    // /**
    // * <p>Fetch all enterprises and employees (SNI 2002) data.</p>
    // *
    // * @return the data wrapped in a list of
    // * {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
    // * objects
    // *
    // * @see #getEnterprisesAndEmployeesSNI2002(Collection, Collection, Collection)
    // */
    // public List<ResponseModel> getEnterprisesAndEmployeesSNI2002() {
    // return getEnterprisesAndEmployeesSNI2002(null, null, null);
    // }
    //
    // /**
    // * <p>Fetch all enterprises and employees (SNI 2002) data which match the input
    // * constraints.</p>
    // *
    // * @param industrialClassifications
    // * the industrial classifications
    // * @param sizeClasses
    // * the size classes
    // * @param years
    // * the years
    // * @return the data wrapped in a list of
    // * {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
    // * objects
    // */
    // public List<ResponseModel> getEnterprisesAndEmployeesSNI2002(Collection<String>
    // industrialClassifications,
    // Collection<String> sizeClasses, Collection<Integer> years) {
    // Map<String, Collection<?>> mappings = new HashMap<>();
    // mappings.put("SNI2002", industrialClassifications);
    // mappings.put("Storleksklass", sizeClasses);
    // mappings.put(APIConstants.TIME_CODE, years);
    //
    // return getResponseModels("FDBR", mappings);
    // }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("JO/JO0103/");
    }

}
