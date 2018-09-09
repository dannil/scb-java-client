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

package com.github.dannil.scbjavaclient.client.labourmarket.costindex;

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
 * <p>Client which handles labour market cost index data fetching.</p>
 *
 * @since 0.3.0
 */
public class LabourMarketCostIndexClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public LabourMarketCostIndexClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public LabourMarketCostIndexClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all cost index for manual workers (LCI) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getCostIndexForManualWorkersLCI(Collection, Collection)
     */
    public List<ResponseModel> getCostIndexForManualWorkersLCI() {
        return getCostIndexForManualWorkersLCI(null, null);
    }

    /**
     * <p>Fetch all cost index for manual workers (LCI) data which match the input
     * constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications to fetch data for
     * @param quarters
     *            the quarters to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getCostIndexForManualWorkersLCI(Collection<String> industrialClassifications,
            Collection<String> quarters) {
        return generate(industrialClassifications, quarters, "LCIArbKv");
    }

    /**
     * <p>Fetch all cost index for non-manual workers (LCI) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getCostIndexForNonManualWorkersLCI(Collection, Collection)
     */
    public List<ResponseModel> getCostIndexForNonManualWorkersLCI() {
        return getCostIndexForNonManualWorkersLCI(null, null);
    }

    /**
     * <p>Fetch all cost index for non-manual workers (LCI) data which match the input
     * constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications to fetch data for
     * @param quarters
     *            the quarters to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getCostIndexForNonManualWorkersLCI(Collection<String> industrialClassifications,
            Collection<String> quarters) {
        return generate(industrialClassifications, quarters, "LCItjmKv");
    }

    /**
     * <p>Fetch all cost index for manual workers (WAG) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getCostIndexForManualWorkersWAG(Collection, Collection)
     */
    public List<ResponseModel> getCostIndexForManualWorkersWAG() {
        return getCostIndexForManualWorkersLCI(null, null);
    }

    /**
     * <p>Fetch all cost index for manual workers (WAG) data which match the input
     * constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications to fetch data for
     * @param quarters
     *            the quarters to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     */
    public List<ResponseModel> getCostIndexForManualWorkersWAG(Collection<String> industrialClassifications,
            Collection<String> quarters) {
        return generate(industrialClassifications, quarters, "WAGArbKv");
    }

    /**
     * <p>Fetch all cost index for non-manual workers (WAG) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getCostIndexForNonManualWorkersWAG(Collection, Collection)
     */
    public List<ResponseModel> getCostIndexForNonManualWorkersWAG() {
        return getCostIndexForNonManualWorkersLCI(null, null);
    }

    /**
     * <p>Fetch all cost index for non-manual workers (WAG) data which match the input
     * constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications to fetch data for
     * @param quarters
     *            the quarters to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getCostIndexForNonManualWorkersWAG(Collection<String> industrialClassifications,
            Collection<String> quarters) {
        return generate(industrialClassifications, quarters, "WAGtjmKv");
    }

    /**
     * <p>Common generator method for the methods in this class.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param quarters
     *            the quarters
     * @param table
     *            the table
     * @return a <code>List</code> of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     */
    private List<ResponseModel> generate(Collection<String> industrialClassifications, Collection<String> quarters,
            String table) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels(table, mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("AM/AM0114/");
    }

}
