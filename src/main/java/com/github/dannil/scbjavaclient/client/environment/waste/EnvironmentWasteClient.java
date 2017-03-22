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

package com.github.dannil.scbjavaclient.client.environment.waste;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.environment.waste.GeneratedWaste;
import com.github.dannil.scbjavaclient.model.environment.waste.TreatedWaste;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles environment waste data fetching.</p>
 *
 * @since 0.2.0
 */
public class EnvironmentWasteClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentWasteClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentWasteClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all generated waste data.</p>
     *
     * @return the generated waste data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.waste.GeneratedWaste
     *         GeneratedWaste} objects
     *
     * @see #getGeneratedWaste(Collection, Collection, Collection)
     */
    public List<GeneratedWaste> getGeneratedWaste() {
        return getGeneratedWaste(null, null, null);
    }

    /**
     * <p>Fetch all generated waste data which match the input constraints.</p>
     *
     * @param industrialClassification
     *            the industrial classifications to fetch data for
     * @param wasteCategories
     *            the waste categories to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the generated waste data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.waste.GeneratedWaste
     *         GeneratedWaste} objects
     */
    public List<GeneratedWaste> getGeneratedWaste(Collection<String> industrialClassification,
            Collection<String> wasteCategories, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.CONTENTSCODE_CODE, Arrays.asList("MI0305AA", "MI0305AO"));
        mappings.put("SNI2007MI", industrialClassification);
        mappings.put("Avfallsslag", wasteCategories);
        mappings.put(APIConstants.TIME_CODE, years);

        String response = doPostRequest(getUrl() + "MI0305T01", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(GeneratedWaste.class);
    }

    /**
     * <p>Fetch all treated waste data.</p>
     *
     * @return the treated waste data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.waste.TreatedWaste
     *         TreatedWaste} objects
     *
     * @see #getTreatedWaste(Collection, Collection, Collection)
     */
    public List<TreatedWaste> getTreatedWaste() {
        return getTreatedWaste(null, null, null);
    }

    /**
     * <p>Fetch all treated waste data which match the input constraints.</p>
     *
     * @param treatmentCategories
     *            the treatment categories to fetch data for
     * @param wasteCategories
     *            the waste categories to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the treated waste data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.waste.TreatedWaste
     *         TreatedWaste} objects
     */
    public List<TreatedWaste> getTreatedWaste(Collection<Integer> treatmentCategories,
            Collection<String> wasteCategories, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.CONTENTSCODE_CODE, Arrays.asList("MI0305AQ", "MI0305AR"));
        mappings.put("BehTyp", treatmentCategories);
        mappings.put("Avfallsslag", wasteCategories);
        mappings.put(APIConstants.TIME_CODE, years);

        String response = doPostRequest(getUrl() + "MI0305T02", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(TreatedWaste.class);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "MI/MI0305/";
    }
}
