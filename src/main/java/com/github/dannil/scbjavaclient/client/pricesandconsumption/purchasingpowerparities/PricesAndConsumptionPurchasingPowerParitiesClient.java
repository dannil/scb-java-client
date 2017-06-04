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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.purchasingpowerparities;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles prices and consumption purchasing power parities data
 * fetching.</p>
 *
 * @since 0.4.0
 */
public class PricesAndConsumptionPurchasingPowerParitiesClient extends AbstractContainerClient {

    /**
     * <p>Default constructor.</p>
     */
    public PricesAndConsumptionPurchasingPowerParitiesClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PricesAndConsumptionPurchasingPowerParitiesClient(Locale locale) {
        super(locale);
    }
    
    TODO

    // /**
    // * <p>Fetch all income statements data which match the input constraints.</p>
    // *
    // * @param regions
    // * the regions
    // * @param incomeStatements
    // * the income statements
    // * @param years
    // * the years
    // * @return the data wrapped in a list of
    // * {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
    // * objects
    // */
    // public List<ResponseModel> getIncomeStatements(Collection<String> regions,
    // Collection<String> incomeStatements,
    // Collection<Integer> years) {
    // Map<String, Collection<?>> mappings = new HashMap<>();
    // mappings.put(APIConstants.REGION_CODE, regions);
    // mappings.put("Resultatraknposter", incomeStatements);
    // mappings.put(APIConstants.TIME_CODE, years);
    //
    // return getResponseModels("ResultKn", mappings);
    // }
    //
    // /**
    // * <p>Fetch all balance sheet data which match the input constraints.</p>
    // *
    // * @param regions
    // * the regions
    // * @param balanceSheets
    // * the balance sheets
    // * @param years
    // * the years
    // * @return the data wrapped in a list of
    // * {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
    // * objects
    // */
    // public List<ResponseModel> getBalanceSheet(Collection<String> regions,
    // Collection<String> balanceSheets,
    // Collection<Integer> years) {
    // Map<String, Collection<?>> mappings = new HashMap<>();
    // mappings.put(APIConstants.REGION_CODE, regions);
    // mappings.put("Balansraknposter", balanceSheets);
    // mappings.put(APIConstants.TIME_CODE, years);
    //
    // return getResponseModels("BalansKn", mappings);
    // }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("PR/PR0401/");
    }

}
