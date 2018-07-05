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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.spin2015monthlyandquarterly;

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
 * <p>Client which handles prices and consumption producer and import price index (PPI)
 * SPIN 2015 monthly and quarterly data fetching.</p>
 *
 * @since 0.4.0
 */
public class PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClient(Locale locale) {
        super(locale);
    }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    /**
     * <p>Fetch all producer price index home sales data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getProducerPriceIndexHomeSales(Collection, Collection)
     */
    public List<ResponseModel> getProducerPriceIndexHomeSales() {
        return getProducerPriceIndexHomeSales(null, null);
    }

    /**
     * <p>Fetch all producer price index home sales data which match the input
     * constraints.</p>
     *
     * @param spin2015
     *            the SPIN 2015
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getProducerPriceIndexHomeSales(Collection<String> spin2015, Collection<String> months) {
        return generate(spin2015, months, "HMPIM15");
    }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    /**
     * <p>Fetch all export price index data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getExportPriceIndex(Collection, Collection)
     */
    public List<ResponseModel> getExportPriceIndex() {
        return getExportPriceIndex(null, null);
    }

    /**
     * <p>Fetch all export price index data which match the input constraints.</p>
     *
     * @param spin2015
     *            the SPIN 2015
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getExportPriceIndex(Collection<String> spin2015, Collection<String> months) {
        return generate(spin2015, months, "EXPIM15");
    }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    /**
     * <p>Fetch all import price index data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getImportPriceIndex(Collection, Collection)
     */
    public List<ResponseModel> getImportPriceIndex() {
        return getImportPriceIndex(null, null);
    }

    /**
     * <p>Fetch all import price index data which match the input constraints.</p>
     *
     * @param spin2015
     *            the SPIN 2015
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getImportPriceIndex(Collection<String> spin2015, Collection<String> months) {
        return generate(spin2015, months, "IMPIM15");
    }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    /**
     * <p>Fetch all producer price index data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getProducerPriceIndex(Collection, Collection)
     */
    public List<ResponseModel> getProducerPriceIndex() {
        return getProducerPriceIndex(null, null);
    }

    /**
     * <p>Fetch all producer price index data which match the input constraints.</p>
     *
     * @param spin2015
     *            the SPIN 2015
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getProducerPriceIndex(Collection<String> spin2015, Collection<String> months) {
        return generate(spin2015, months, "PPIM15");
    }

    // Daniel 2017-06-06
    // Returns HTTP 403
    /**
     * <p>Fetch all price index for domestic supply data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPriceIndexForDomesticSupply(Collection, Collection)
     */
    public List<ResponseModel> getPriceIndexForDomesticSupply() {
        return getPriceIndexForDomesticSupply(null, null);
    }

    /**
     * <p>Fetch all price index for domestic supply data which match the input
     * constraints.</p>
     *
     * @param spin2015
     *            the SPIN 2015
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPriceIndexForDomesticSupply(Collection<String> spin2015, Collection<String> months) {
        return generate(spin2015, months, "ITPIM15");
    }

    /**
     * <p>Common generator method for the methods in this class.</p>
     *
     * @param spin2015
     *            the SPIN 2015
     * @param times
     *            the times
     * @param table
     *            the table
     * @return a <code>List</code> of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     */
    private List<ResponseModel> generate(Collection<String> spin2015, Collection<String> times, String table) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SPIN_2015, spin2015);
        mappings.put(APIConstants.TIME_CODE, times);

        return getResponseModels(table, mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("PR/PR0301/PR0301J/");
    }

}
