/*
 * Copyright 2018 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.goodsandservices.turnoverservicesector.oldtablessni2007;

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
 * <p>Client which handles goods and services turnover service sector old tables SNI 2007
 * data fetching.</p>
 *
 * @since 0.7.0
 */
public class GoodsAndServicesTurnoverServiceSectorOldTablesSNI2007Client extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public GoodsAndServicesTurnoverServiceSectorOldTablesSNI2007Client() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public GoodsAndServicesTurnoverServiceSectorOldTablesSNI2007Client(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all turnover index for the service sector by industry (SIC 2007) yearly
     * data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTurnoverIndexForTheServiceSectorSIC2007Yearly(Collection, Collection)
     */
    public List<ResponseModel> getTurnoverIndexForTheServiceSectorSIC2007Yearly() {
        return getTurnoverIndexForTheServiceSectorSIC2007Yearly(null, null);
    }

    /**
     * <p>Fetch all turnover index for the service sector by industry (SIC 2007) yearly
     * data which match the input constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTurnoverIndexForTheServiceSectorSIC2007Yearly(
            Collection<String> industrialClassifications, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("DivtjansterAr07X", mappings);
    }

    /**
     * <p>Fetch all turnover index for the service sector by industry (SIC 2007) quarterly
     * data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTurnoverIndexForTheServiceSectorSIC2007Quarterly(Collection, Collection)
     */
    public List<ResponseModel> getTurnoverIndexForTheServiceSectorSIC2007Quarterly() {
        return getTurnoverIndexForTheServiceSectorSIC2007Quarterly(null, null);
    }

    /**
     * <p>Fetch all turnover index for the service sector by industry (SIC 2007) quarterly
     * data which match the input constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTurnoverIndexForTheServiceSectorSIC2007Quarterly(
            Collection<String> industrialClassifications, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("DivtjansterKv07X", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("HA/HA0101/HA0101C");
    }

}
