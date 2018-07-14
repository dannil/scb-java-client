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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.kpif;

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
 * <p>Client which handles prices and consumption Consumer Price Index (CPI) Underlying
 * Inflation Rate (KPIF) data fetching.</p>
 *
 * @since 0.4.0
 */
public class PricesAndConsumptionCPIKPIFClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PricesAndConsumptionCPIKPIFClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PricesAndConsumptionCPIKPIFClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all underlying inflation monthly changes data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getUnderlyingInflationMonthlyChanges(Collection)
     */
    public List<ResponseModel> getUnderlyingInflationMonthlyChanges() {
        return getUnderlyingInflationMonthlyChanges(null);
    }

    /**
     * <p>Fetch all underlying inflation monthly changes data which match the input
     * constraints.</p>
     *
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getUnderlyingInflationMonthlyChanges(Collection<String> months) {
        return generate(months, "KPIF12M");
    }

    /**
     * <p>Fetch all underlying inflation annual changes data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getUnderlyingInflationAnnualChanges(Collection)
     */
    public List<ResponseModel> getUnderlyingInflationAnnualChanges() {
        return getUnderlyingInflationAnnualChanges(null);
    }

    /**
     * <p>Fetch all underlying inflation annual changes data which match the input
     * constraints.</p>
     *
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getUnderlyingInflationAnnualChanges(Collection<String> months) {
        return generate(months, "KPIFFM");
    }

    /**
     * <p>Common generator method for the methods in this class.</p>
     *
     * @param months
     *            the months
     * @param table
     *            the table
     * @return a <code>List</code> of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     */
    private List<ResponseModel> generate(Collection<String> months, String table) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels(table, mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("PR/PR0101/PR0101G/");
    }

}
