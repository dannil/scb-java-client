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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.energy.monthlystatistics.DeliveriesOfLiquidFuels;
import com.github.dannil.scbjavaclient.model.energy.monthlystatistics.DeliveriesOfOilProducts;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

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
     * @return the deliveries of liquid fuels data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.energy.monthlystatistics.DeliveriesOfLiquidFuels
     *         DeliveriesOfLiquidFuels} objects
     *
     * @see #getDeliveriesOfLiquidFuels(Collection, Collection, Collection)
     */
    public List<DeliveriesOfLiquidFuels> getDeliveriesOfLiquidFuels() {
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
     * @return the deliveries of liquid fuels data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.energy.monthlystatistics.DeliveriesOfLiquidFuels
     *         DeliveriesOfLiquidFuels} objects
     */
    public List<DeliveriesOfLiquidFuels> getDeliveriesOfLiquidFuels(Collection<Integer> commodities,
            Collection<String> userCategories, Collection<String> months) {
        return generate(Arrays.asList("EN0107A3"), commodities, userCategories, months, "LevOljorKatM",
                DeliveriesOfLiquidFuels.class);
    }

    /**
     * <p>Fetch all deliveries of oil products data.</p>
     *
     * @return the deliveries of oil products data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.energy.monthlystatistics.DeliveriesOfOilProducts
     *         DeliveriesOfOilProducts} objects
     *
     * @see #getDeliveriesOfOilProducts(Collection, Collection, Collection)
     */
    public List<DeliveriesOfOilProducts> getDeliveriesOfOilProducts() {
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
     * @return the deliveries of oil products data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.energy.monthlystatistics.DeliveriesOfOilProducts
     *         DeliveriesOfOilProducts} objects
     */
    public List<DeliveriesOfOilProducts> getDeliveriesOfOilProducts(Collection<Integer> commodities,
            Collection<String> userCategories, Collection<String> months) {
        return generate(Arrays.asList("EN0107A2"), commodities, userCategories, months, "LevOljorM",
                DeliveriesOfOilProducts.class);
    }

    /**
     * <p>Common generator method for the methods in this class.</p>
     *
     * @param contentCodes
     *            the content codes
     * @param commodities
     *            the commodities
     * @param userCategories
     *            the user categories
     * @param months
     *            the months
     * @param table
     *            the table
     * @param clazz
     *            the class to convert the generated data to
     * @param <T>
     *            the data type of the list
     * @return a <code>List</code> of the specified class
     */
    private <T> List<T> generate(Collection<String> contentCodes, Collection<Integer> commodities,
            Collection<String> userCategories, Collection<String> months, String table, Class<T> clazz) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", contentCodes);
        mappings.put("Varuslag", commodities);
        mappings.put("Forbrukarkat", userCategories);
        mappings.put("Tid", months);

        String response = doPostRequest(getUrl() + table, QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(clazz);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "EN/EN0107/";
    }

}