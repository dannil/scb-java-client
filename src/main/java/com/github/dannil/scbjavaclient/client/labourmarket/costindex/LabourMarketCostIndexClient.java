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
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.http.URLEndpoint;
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

    public List<ResponseModel> getCostIndexForManualWorkersLCI() {
        return getCostIndexForManualWorkersLCI(null, null);
    }

    public List<ResponseModel> getCostIndexForManualWorkersLCI(Collection<String> industrialClassifications,
            Collection<String> quarters) {
        return generate(industrialClassifications, quarters, "LCIArbKv");
    }

    public List<ResponseModel> getCostIndexForNonManualWorkersLCI() {
        return getCostIndexForNonManualWorkersLCI(null, null);
    }

    public List<ResponseModel> getCostIndexForNonManualWorkersLCI(Collection<String> industrialClassifications,
            Collection<String> quarters) {
        return generate(industrialClassifications, quarters, "LCItjmKv");
    }

    public List<ResponseModel> getCostIndexForManualWorkersWAG() {
        return getCostIndexForManualWorkersLCI(null, null);
    }

    public List<ResponseModel> getCostIndexForManualWorkersWAG(Collection<String> industrialClassifications,
            Collection<String> quarters) {
        return generate(industrialClassifications, quarters, "WAGArbKv");
    }

    public List<ResponseModel> getCostIndexForNonManualWorkersWAG() {
        return getCostIndexForNonManualWorkersLCI(null, null);
    }

    public List<ResponseModel> getCostIndexForNonManualWorkersWAG(Collection<String> industrialClassifications,
            Collection<String> quarters) {
        return generate(industrialClassifications, quarters, "WAGtjmKv");
    }

    private List<ResponseModel> generate(Collection<String> industrialClassifications, Collection<String> quarters,
            String table) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("SNI2007", industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels(table, mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("AM/AM0114/");
    }

}
