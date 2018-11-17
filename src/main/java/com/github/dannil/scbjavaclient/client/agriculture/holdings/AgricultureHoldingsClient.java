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

package com.github.dannil.scbjavaclient.client.agriculture.holdings;

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
 * <p>Client which handles agriculture holdings data fetching.</p>
 *
 * @since 0.4.0
 */
public class AgricultureHoldingsClient extends AbstractClient {

    private static final String SIZECLASS_CODE = "Storleksklass";

    /**
     * <p>Default constructor.</p>
     */
    public AgricultureHoldingsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public AgricultureHoldingsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all agricultural enterprises by municipality and size class data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAgriculturalEnterprisesByMunicipalityAndSizeClass(Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getAgriculturalEnterprisesByMunicipalityAndSizeClass() {
        return getAgriculturalEnterprisesByMunicipalityAndSizeClass(null, null, null);
    }

    /**
     * <p>Fetch all agricultural enterprises by municipality and size class data which
     * match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param sizeClasses
     *            the size classes
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAgriculturalEnterprisesByMunicipalityAndSizeClass(Collection<String> regions,
            Collection<String> sizeClasses, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(SIZECLASS_CODE, sizeClasses);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("ForetagStorlekK", mappings);
    }

    /**
     * <p>Fetch all agricultural enterprises by county and size class data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAgriculturalEnterprisesByCountyAndSizeClass(Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getAgriculturalEnterprisesByCountyAndSizeClass() {
        return getAgriculturalEnterprisesByCountyAndSizeClass(null, null, null);
    }

    /**
     * <p>Fetch all agricultural enterprises by county and size class data which match the
     * input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param sizeClasses
     *            the size classes
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAgriculturalEnterprisesByCountyAndSizeClass(Collection<String> regions,
            Collection<String> sizeClasses, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(SIZECLASS_CODE, sizeClasses);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("ForetagStorlekL", mappings);
    }

    /**
     * <p>Fetch all agricultural enterprises by county and juridical form data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAgriculturalEnterprisesByCountyAndJuridicalForm(Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getAgriculturalEnterprisesByCountyAndJuridicalForm() {
        return getAgriculturalEnterprisesByCountyAndJuridicalForm(null, null, null);
    }

    /**
     * <p>Fetch all agricultural enterprises by county and juridical form data which match
     * the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param typesOfHoldings
     *            the types of holdings
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAgriculturalEnterprisesByCountyAndJuridicalForm(Collection<String> regions,
            Collection<String> typesOfHoldings, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Foretagsform", typesOfHoldings);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("ForetagFormL", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("JO/JO0106/");
    }

}
