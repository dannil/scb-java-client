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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.spin2007year;

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
 * SPIN 2007 year data fetching.</p>
 *
 * @since 0.4.0
 */
public class PricesAndConsumptionPPISPIN2007YearClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PricesAndConsumptionPPISPIN2007YearClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PricesAndConsumptionPPISPIN2007YearClient(Locale locale) {
        super(locale);
    }

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
     * @param spin2007
     *            the SPIN 2007
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getProducerPriceIndexHomeSales(Collection<String> spin2007, Collection<Integer> years) {
        return generate(spin2007, years, "HMPIAr07");
    }

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
     * @param spin2007
     *            the SPIN 2007
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getExportPriceIndex(Collection<String> spin2007, Collection<Integer> years) {
        return generate(spin2007, years, "EXPIAr07");
    }

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
     * @param spin2007
     *            the SPIN 2007
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getImportPriceIndex(Collection<String> spin2007, Collection<Integer> years) {
        return generate(spin2007, years, "IMPIAr07");
    }

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
     * @param spin2007
     *            the SPIN 2007
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getProducerPriceIndex(Collection<String> spin2007, Collection<Integer> years) {
        return generate(spin2007, years, "PPIAr07");
    }

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
     * @param spin2007
     *            the SPIN 2007
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPriceIndexForDomesticSupply(Collection<String> spin2007, Collection<Integer> years) {
        return generate(spin2007, years, "ITPIAr07");
    }

    /**
     * <p>Fetch all weights for different indices data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getWeightsForDifferentIndices(Collection, Collection)
     */
    public List<ResponseModel> getWeightsForDifferentIndices() {
        return getWeightsForDifferentIndices(null, null);
    }

    /**
     * <p>Fetch all weights for different indices data which match the input
     * constraints.</p>
     *
     * @param spin2007
     *            the SPIN 2007
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getWeightsForDifferentIndices(Collection<String> spin2007, Collection<Integer> years) {
        return generate(spin2007, years, "PPIviktB");
    }

    /**
     * <p>Fetch all producer price index for services data.</p>
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
     * <p>Fetch all producer price index for services data which match the input
     * constraints.</p>
     *
     * @param spin2007
     *            the SPIN 2007
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getProducerPriceIndexForServices(Collection<String> spin2007,
            Collection<Integer> years) {
        return generate(spin2007, years, "TPI2005Ar07");
    }

    /**
     * <p>Common generator method for the methods in this class.</p>
     *
     * @param spin2007
     *            the SPIN 2007
     * @param times
     *            the times
     * @param table
     *            the table
     * @return a <code>List</code> of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     */
    private List<ResponseModel> generate(Collection<String> spin2007, Collection<Integer> times, String table) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SPIN_2007, spin2007);
        mappings.put(APIConstants.TIME_CODE, times);

        return getResponseModels(table, mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("PR/PR0301/PR0301E/");
    }

}
