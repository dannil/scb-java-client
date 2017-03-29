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

package com.github.dannil.scbjavaclient.client.energy.annualstatistics;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.http.EndpointURL;
import com.github.dannil.scbjavaclient.model.energy.annualstatistics.ConsumptionOfFuelsInElectricityGeneration;
import com.github.dannil.scbjavaclient.model.energy.annualstatistics.ElectricitySupply;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles energy annual statistics data fetching.</p>
 *
 * @since 0.2.0
 */
public class EnergyAnnualStatisticsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnergyAnnualStatisticsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnergyAnnualStatisticsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all consumption of fuels in electricity generation data.</p>
     *
     * @return the consumption of fuels in electricity generation data wrapped in a list
     *         of
     *         {@link com.github.dannil.scbjavaclient.model.energy.annualstatistics.ConsumptionOfFuelsInElectricityGeneration
     *         ConsumptionOfFuelsInElectricityGeneration} objects
     *
     * @see #getConsumptionOfFuelsInElectricityGeneration(Collection, Collection,
     *      Collection)
     */
    public List<ConsumptionOfFuelsInElectricityGeneration> getConsumptionOfFuelsInElectricityGeneration() {
        return getConsumptionOfFuelsInElectricityGeneration(null, null, null);
    }

    /**
     * <p>Fetch all consumption of fuels in electricity generation data.</p>
     *
     * @param powerPlants
     *            the power plants to fetch data for
     * @param fuels
     *            the fuels to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the consumption of fuels in electricity generation data wrapped in a list
     *         of
     *         {@link com.github.dannil.scbjavaclient.model.energy.annualstatistics.ConsumptionOfFuelsInElectricityGeneration
     *         ConsumptionOfFuelsInElectricityGeneration} objects
     */
    public List<ConsumptionOfFuelsInElectricityGeneration> getConsumptionOfFuelsInElectricityGeneration(
            Collection<String> powerPlants, Collection<String> fuels, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Prodslag", powerPlants);
        mappings.put("Bransle", fuels);
        mappings.put(APIConstants.TIME_CODE, years);

        String response = doPostRequest(getUrl() + "BrforelAR", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(ConsumptionOfFuelsInElectricityGeneration.class);
    }

    /**
     * <p>Fetch all electricity supply data.</p>
     *
     * @return the electricity supply data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.energy.annualstatistics.ElectricitySupply
     *         ElectricitySupply} objects
     *
     * @see #getElectricitySupply(Collection, Collection)
     */
    public List<ElectricitySupply> getElectricitySupply() {
        return getElectricitySupply(null, null);
    }

    /**
     * <p>Fetch all electricity supply data.</p>
     *
     * @param powerPlants
     *            the power plants to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the electricity supply data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.energy.annualstatistics.ElectricitySupply
     *         ElectricitySupply} objects
     */
    public List<ElectricitySupply> getElectricitySupply(Collection<String> powerPlants, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Prodslag", powerPlants);
        mappings.put(APIConstants.TIME_CODE, years);

        String response = doPostRequest(getUrl() + "ElProdAr", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(ElectricitySupply.class);
    }

    @Override
    public EndpointURL getUrl() {
        return getRootUrl().append("EN/EN0105/");
    }

}
