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

package com.github.dannil.scbjavaclient.client.goodsandservices.foodsales;

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
 * <p>Client which handles goods and services food sales data fetching.</p>
 *
 * @since 0.3.0
 */
public class GoodsAndServicesFoodSalesClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public GoodsAndServicesFoodSalesClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public GoodsAndServicesFoodSalesClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all turnover of food and drinks data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTurnoverOfFoodAndDrinks(Collection, Collection)
     */
    public List<ResponseModel> getTurnoverOfFoodAndDrinks() {
        return getTurnoverOfFoodAndDrinks(null, null);
    }

    /**
     * <p>Fetch all turnover of food and drinks data which match the input
     * constraints.</p>
     *
     * @param productGroups
     *            the product groups to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTurnoverOfFoodAndDrinks(Collection<String> productGroups, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Varugrupp", productGroups);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Livs", mappings);
    }

    /**
     * <p>Fetch all turnover of ecological food and non alcoholic drinks data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTurnoverOfEcologicalFoodAndNonAlcoholicDrinks(Collection, Collection)
     */
    public List<ResponseModel> getTurnoverOfEcologicalFoodAndNonAlcoholicDrinks() {
        return getTurnoverOfEcologicalFoodAndNonAlcoholicDrinks(null, null);
    }

    /**
     * <p>Fetch all turnover of ecological food and non alcoholic drinks data which match
     * the input constraints.</p>
     *
     * @param productGroups
     *            the product groups to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTurnoverOfEcologicalFoodAndNonAlcoholicDrinks(Collection<String> productGroups,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Varugrupp", productGroups);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("EkoLivs", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("HA/HA0103/");
    }

}
