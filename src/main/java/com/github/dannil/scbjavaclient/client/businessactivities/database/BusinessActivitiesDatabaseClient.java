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

package com.github.dannil.scbjavaclient.client.businessactivities.database;

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
 * <p>Client which handles business activities database data fetching.</p>
 *
 * @since 0.3.0
 */
public class BusinessActivitiesDatabaseClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public BusinessActivitiesDatabaseClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public BusinessActivitiesDatabaseClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all enterprises and employees (SNI 2002) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEnterprisesAndEmployeesSNI2002(Collection, Collection, Collection)
     */
    public List<ResponseModel> getEnterprisesAndEmployeesSNI2002() {
        return getEnterprisesAndEmployeesSNI2002(null, null, null);
    }

    /**
     * <p>Fetch all enterprises and employees (SNI 2002) data which match the input
     * constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param sizeClasses
     *            the size classes
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEnterprisesAndEmployeesSNI2002(Collection<String> industrialClassifications,
            Collection<String> sizeClasses, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2002_CODE, industrialClassifications);
        mappings.put("Storleksklass", sizeClasses);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FDBR", mappings);
    }

    /**
     * <p>Fetch all enterprises and employees (SNI 2007) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     * @see #getEnterprisesAndEmployeesSNI2007(Collection, Collection, Collection)
     */
    public List<ResponseModel> getEnterprisesAndEmployeesSNI2007() {
        return getEnterprisesAndEmployeesSNI2007(null, null, null);
    }

    /**
     * <p>Fetch all enterprises and employees (SNI 2007) data which match the input
     * constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param sizeClasses
     *            the size classes
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEnterprisesAndEmployeesSNI2007(Collection<String> industrialClassifications,
            Collection<String> sizeClasses, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put("Storleksklass", sizeClasses);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("FDBR07", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/NV0101/");
    }

}
