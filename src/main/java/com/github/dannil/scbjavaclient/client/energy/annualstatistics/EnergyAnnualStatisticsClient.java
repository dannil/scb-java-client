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
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.model.ResponseModel;

/**
 * <p>Client which handles energy annual statistics data fetching.</p>
 *
 * @since 0.2.0
 */
public class EnergyAnnualStatisticsClient extends AbstractClient {

    private static final String POWERPLANTS_CODE = "Prodslag";

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
     *         of {@link com.github.dannil.scbjavaclient.model.ResponseModel
     *         ResponseModel} objects
     *
     * @see #getConsumptionOfFuelsInElectricityGeneration(Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getConsumptionOfFuelsInElectricityGeneration() {
        return getConsumptionOfFuelsInElectricityGeneration(null, null, null);
    }

    /**
     * <p>Fetch all consumption of fuels in electricity generation data which match the
     * input constraints.</p>
     *
     * @param powerPlants
     *            the power plants to fetch data for
     * @param fuels
     *            the fuels to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getConsumptionOfFuelsInElectricityGeneration(Collection<String> powerPlants,
            Collection<String> fuels, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(POWERPLANTS_CODE, powerPlants);
        mappings.put("Bransle", fuels);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BrforelAR", mappings);
    }

    /**
     * <p>Fetch all electricity supply data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getElectricitySupply(Collection, Collection)
     */
    public List<ResponseModel> getElectricitySupply() {
        return getElectricitySupply(null, null);
    }

    /**
     * <p>Fetch all electricity supply data which match the input constraints.</p>
     *
     * @param powerPlants
     *            the power plants to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getElectricitySupply(Collection<String> powerPlants, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(POWERPLANTS_CODE, powerPlants);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("ElProdAr", mappings);
    }

    /**
     * <p>Fetch all consumption of fuels for steam and hot water production data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getConsumptionOfFuelsForSteamAndHotWaterProduction(Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getConsumptionOfFuelsForSteamAndHotWaterProduction() {
        return getConsumptionOfFuelsForSteamAndHotWaterProduction(null, null, null);
    }

    /**
     * <p>Fetch all consumption of fuels for steam and hot water production data which
     * match the input constraints.</p>
     *
     * @param powerPlants
     *            the power plants to fetch data for
     * @param fuels
     *            the fuels to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getConsumptionOfFuelsForSteamAndHotWaterProduction(Collection<String> powerPlants,
            Collection<String> fuels, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(POWERPLANTS_CODE, powerPlants);
        mappings.put("Bransle", fuels);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BrforangaAR", mappings);
    }

    /**
     * <p>Fetch all electricity use in Sweden data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getElectricityUseInSweden(Collection, Collection)
     */
    public List<ResponseModel> getElectricityUseInSweden() {
        return getElectricityUseInSweden(null, null);
    }

    /**
     * <p>Fetch all electricity use in Sweden data which match the input constraints.</p>
     *
     * @param areaOfUses
     *            the area of uses to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getElectricityUseInSweden(Collection<String> areaOfUses, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("AnvOmrade", areaOfUses);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("ElAnvSNI2007Ar", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("EN/EN0105/");
    }

}
