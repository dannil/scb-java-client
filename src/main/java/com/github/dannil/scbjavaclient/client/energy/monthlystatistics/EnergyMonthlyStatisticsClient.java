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

package com.github.dannil.scbjavaclient.client.energy.monthlystatistics;

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
 * <p>Client which handles energy monthly statistics data fetching.</p>
 *
 * @since 0.2.0
 */
public class EnergyMonthlyStatisticsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnergyMonthlyStatisticsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnergyMonthlyStatisticsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all deliveries of liquid fuels data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getDeliveriesOfLiquidFuels(Collection, Collection, Collection)
     */
    public List<ResponseModel> getDeliveriesOfLiquidFuels() {
        return getDeliveriesOfLiquidFuels(null, null, null);
    }

    /**
     * <p>Fetch all deliveries of liquid fuels data which match the input constraints.</p>
     *
     * @param commodities
     *            the commodities to fetch data for
     * @param userCategories
     *            the user categories to fetch data for
     * @param months
     *            the months to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getDeliveriesOfLiquidFuels(Collection<Integer> commodities,
            Collection<String> userCategories, Collection<String> months) {
        return generate(commodities, userCategories, months, "LevOljorKatM");
    }

    /**
     * <p>Fetch all deliveries of oil products data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getDeliveriesOfOilProducts(Collection, Collection, Collection)
     */
    public List<ResponseModel> getDeliveriesOfOilProducts() {
        return getDeliveriesOfOilProducts(null, null, null);
    }

    /**
     * <p>Fetch all deliveries of oil products data which match the input constraints.</p>
     *
     * @param commodities
     *            the commodities to fetch data for
     * @param userCategories
     *            the user categories to fetch data for
     * @param months
     *            the months to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getDeliveriesOfOilProducts(Collection<Integer> commodities,
            Collection<String> userCategories, Collection<String> months) {

        return generate(commodities, userCategories, months, "LevOljorM");
    }

    /**
     * <p>Common generator method for the methods in this class.</p>
     *
     * @param commodities
     *            the commodities
     * @param userCategories
     *            the user categories
     * @param months
     *            the months
     * @param table
     *            the table
     * @return a <code>List</code> of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     */
    private List<ResponseModel> generate(Collection<Integer> commodities, Collection<String> userCategories,
            Collection<String> months, String table) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Varuslag", commodities);
        mappings.put("Forbrukarkat", userCategories);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels(table, mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("EN/EN0107/");
    }

}
