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

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles prices and consumption producer and import price index (PPI)
 * SPIN 2007 year data fetching.</p>
 *
 * @since 0.4.0
 */
public class PricesAndConsumptionPPISPIN2007YearClient extends AbstractContainerClient {

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
    
    TODO

    // /**
    // * <p>Fetch all extrapolated price level indices data.</p>
    // *
    // * @return the data wrapped in a list of
    // * {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
    // * objects
    // *
    // * @see #getExtrapolatedPriceLevelIndices(Collection, Collection)
    // */
    // public List<ResponseModel> getExtrapolatedPriceLevelIndices() {
    // return getExtrapolatedPriceLevelIndices(null, null);
    // }
    //
    // /**
    // * <p>Fetch all extrapolated price level indices data which match the input
    // * constraints.</p>
    // *
    // * @param countryGroups
    // * the country groups
    // * @param years
    // * the quarters
    // * @return the data wrapped in a list of
    // * {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
    // * objects
    // */
    // public List<ResponseModel> getExtrapolatedPriceLevelIndices(Collection<String>
    // countryGroups,
    // Collection<Integer> years) {
    // Map<String, Collection<?>> mappings = new HashMap<>();
    // mappings.put("LandLandgrupper", countryGroups);
    // mappings.put(APIConstants.TIME_CODE, years);
    //
    // return getResponseModels("PR0401T01Ar", mappings);
    // }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("PR/PR0301/PR0301E/");
    }

}
