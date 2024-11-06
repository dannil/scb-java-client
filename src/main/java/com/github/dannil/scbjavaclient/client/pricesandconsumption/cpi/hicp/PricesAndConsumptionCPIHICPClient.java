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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.hicp;

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
 * Client which handles prices and consumption Consumer Price Index (CPI) Harmonized
 * Index of Consumer Prices (HICP) data fetching.
 *
 * @since 0.5.0
 */
public class PricesAndConsumptionCPIHICPClient extends AbstractClient {

    /**
     * Default constructor.
     */
    public PricesAndConsumptionCPIHICPClient() {
        super();
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PricesAndConsumptionCPIHICPClient(Locale locale) {
        super(locale);
    }

    /**
     * Fetch all harmonized index annual changes data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getHarmonizedIndexAnnualChanges(Collection)
     */
    public List<ResponseModel> getHarmonizedIndexAnnualChanges() {
        return getHarmonizedIndexAnnualChanges(null);
    }

    /**
     * Fetch all harmonized index annual changes data which match the input
     * constraints.
     *
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getHarmonizedIndexAnnualChanges(Collection<String> months) {
        return generate(months, "HIKPF12MP2015");
    }

    /**
     * Fetch all harmonized index monthly changes data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getHarmonizedIndexMonthlyChanges(Collection)
     */
    public List<ResponseModel> getHarmonizedIndexMonthlyChanges() {
        return getHarmonizedIndexMonthlyChanges(null);
    }

    /**
     * Fetch all harmonized index monthly changes data which match the input
     * constraints.
     *
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getHarmonizedIndexMonthlyChanges(Collection<String> months) {
        return generate(months, "HIKPFFMP2015");
    }

    /**
     * Fetch all harmonized index months data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getHarmonizedIndexMonths(Collection)
     */
    public List<ResponseModel> getHarmonizedIndexMonths() {
        return getHarmonizedIndexMonths(null);
    }

    /**
     * Fetch all harmonized index months data which match the input constraints.
     *
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getHarmonizedIndexMonths(Collection<String> months) {
        return generate(months, "HIKPIND22015");
    }

    /**
     * Fetch all harmonized index years data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getHarmonizedIndexYears(Collection)
     */
    public List<ResponseModel> getHarmonizedIndexYears() {
        return getHarmonizedIndexYears(null);
    }

    /**
     * Fetch all harmonized index years data which match the input constraints.
     *
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getHarmonizedIndexYears(Collection<Integer> years) {
        return generate(years, "HIKPAR22015");
    }

    /**
     * Common generator method for the methods in this class.
     *
     * @param times
     *            the times
     * @param table
     *            the table
     * @return a <code>List</code> of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     */
    private List<ResponseModel> generate(Collection<?> times, String table) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.TIME_CODE, times);

        return getResponseModels(table, mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("PR/PR0101/PR0101C/");
    }

}
