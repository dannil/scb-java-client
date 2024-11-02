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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.spin2002month;

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
 * Client which handles prices and consumption producer and import price index (PPI)
 * SPIN 2002 month data fetching.
 *
 * @since 0.4.0
 */
public class PricesAndConsumptionPPISPIN2002MonthClient extends AbstractClient {

    /**
     * Default constructor.
     */
    public PricesAndConsumptionPPISPIN2002MonthClient() {
        super();
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PricesAndConsumptionPPISPIN2002MonthClient(Locale locale) {
        super(locale);
    }

    /**
     * Fetch all producer price index home sales data.
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
     * Fetch all producer price index home sales data which match the input
     * constraints.
     *
     * @param spin2002
     *            the SPIN 2002
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getProducerPriceIndexHomeSales(Collection<String> spin2002, Collection<String> months) {
        return generate(spin2002, months, "HMPIM");
    }

    /**
     * Fetch all export price index data.
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
     * Fetch all export price index data which match the input constraints.
     *
     * @param spin2002
     *            the SPIN 2002
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getExportPriceIndex(Collection<String> spin2002, Collection<String> months) {
        return generate(spin2002, months, "EXPIM");
    }

    /**
     * Fetch all import price index data.
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
     * Fetch all import price index data which match the input constraints.
     *
     * @param spin2002
     *            the SPIN 2002
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getImportPriceIndex(Collection<String> spin2002, Collection<String> months) {
        return generate(spin2002, months, "IMPIM");
    }

    /**
     * Fetch all producer price index data.
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
     * Fetch all producer price index data which match the input constraints.
     *
     * @param spin2002
     *            the SPIN 2002
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getProducerPriceIndex(Collection<String> spin2002, Collection<String> months) {
        return generate(spin2002, months, "PPIM");
    }

    /**
     * Fetch all price index for domestic supply data.
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
     * Fetch all price index for domestic supply data which match the input
     * constraints.
     *
     * @param spin2002
     *            the SPIN 2002
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPriceIndexForDomesticSupply(Collection<String> spin2002, Collection<String> months) {
        return generate(spin2002, months, "ITPIM");
    }

    /**
     * Fetch all producer price index for services data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getProducerPriceIndexForServices(Collection, Collection)
     */
    public List<ResponseModel> getProducerPriceIndexForServices() {
        return getProducerPriceIndexForServices(null, null);
    }

    /**
     * Fetch all producer price index for services data which match the input
     * constraints.
     *
     * @param spin2002
     *            the SPIN 2002
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getProducerPriceIndexForServices(Collection<String> spin2002,
            Collection<String> quarters) {
        return generate(spin2002, quarters, "TPI2005Kv");
    }

    /**
     * Common generator method for the methods in this class.
     *
     * @param spin2002
     *            the SPIN 2002
     * @param times
     *            the times
     * @param table
     *            the table
     * @return a <code>List</code> of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     */
    private List<ResponseModel> generate(Collection<String> spin2002, Collection<String> times, String table) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SPIN_2002, spin2002);
        mappings.put(APIConstants.TIME_CODE, times);

        return getResponseModels(table, mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("PR/PR0301/PR0301C/");
    }

}
