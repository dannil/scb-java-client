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

package com.github.dannil.scbjavaclient.client.labourmarket.grosspay.aggregatewages;

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
 * <p>Client which handles labour market gross pay aggregate wages data fetching.</p>
 *
 * @since 0.3.0
 */
public class LabourMarketGrossPayAggregateWagesClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public LabourMarketGrossPayAggregateWagesClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public LabourMarketGrossPayAggregateWagesClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all gross pay data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getGrossPay(Collection, Collection)
     */
    public List<ResponseModel> getGrossPay() {
        return getGrossPay(null, null);
    }

    /**
     * <p>Fetch all gross pay data which match the input constraints.</p>
     *
     * @param counties
     *            the counties
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getGrossPay(Collection<String> counties, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Lan", counties);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("LSUMLan", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("AM/AM0302/AM0302A/");
    }

}
