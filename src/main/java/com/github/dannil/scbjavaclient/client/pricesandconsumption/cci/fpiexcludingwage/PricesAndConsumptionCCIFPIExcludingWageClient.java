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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.cci.fpiexcludingwage;

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
 * <p>Client which handles prices and consumption construction cost index (CCI) factor
 * price index (FPI) excluding wage data fetching.</p>
 *
 * @since 0.4.0
 */
public class PricesAndConsumptionCCIFPIExcludingWageClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PricesAndConsumptionCCIFPIExcludingWageClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PricesAndConsumptionCCIFPIExcludingWageClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all factor price index for buildings (1968=100) months data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getFactorPriceIndexForBuildings1968Months(Collection, Collection, Collection)
     */
    public List<ResponseModel> getFactorPriceIndexForBuildings1968Months() {
        return getFactorPriceIndexForBuildings1968Months(null, null, null);
    }

    /**
     * <p>Fetch all factor price index for buildings (1968=100) months data which match
     * the input constraints.</p>
     *
     * @param typesOfBuildings
     *            the types of buildings
     * @param typesOfExpenditures
     *            the types of expenditures
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getFactorPriceIndexForBuildings1968Months(Collection<String> typesOfBuildings,
            Collection<String> typesOfExpenditures, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.TYPEOFBUILDING_CODE, typesOfBuildings);
        mappings.put(APIConstants.TYPEOFEXPENDITURE_CODE, typesOfExpenditures);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("FPIBOM", mappings);
    }

    /**
     * <p>Fetch all factor price index for buildings (2015=100) months data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getFactorPriceIndexForBuildings2015Months(Collection, Collection, Collection)
     */
    public List<ResponseModel> getFactorPriceIndexForBuildings2015Months() {
        return getFactorPriceIndexForBuildings2015Months(null, null, null);
    }

    /**
     * <p>Fetch all factor price index for buildings (2015=100) months data which match
     * the input constraints.</p>
     *
     * @param typesOfBuildings
     *            the types of buildings
     * @param typesOfExpenditures
     *            the types of expenditures
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getFactorPriceIndexForBuildings2015Months(Collection<String> typesOfBuildings,
            Collection<String> typesOfExpenditures, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.TYPEOFBUILDING_CODE, typesOfBuildings);
        mappings.put(APIConstants.TYPEOFEXPENDITURE_CODE, typesOfExpenditures);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("FPIBOM2015", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("PR/PR0502/PR0502A/");
    }

}
