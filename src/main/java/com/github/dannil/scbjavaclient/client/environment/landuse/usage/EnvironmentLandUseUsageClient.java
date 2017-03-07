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

package com.github.dannil.scbjavaclient.client.environment.landuse.usage;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.environment.landuse.usage.ArableAndForestLand;
import com.github.dannil.scbjavaclient.model.environment.landuse.usage.BuiltUpLand;
import com.github.dannil.scbjavaclient.model.environment.landuse.usage.LandUseByCounty;
import com.github.dannil.scbjavaclient.model.environment.landuse.usage.LandUseByMunicipality;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles environment land use usage data fetching.</p>
 *
 * @since 0.2.0
 */
public class EnvironmentLandUseUsageClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentLandUseUsageClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentLandUseUsageClient(Locale locale) {
        super(locale);
    }

    public List<ArableAndForestLand> getArableAndForestLand() {
        return getArableAndForestLand(null, null, null);
    }

    public List<ArableAndForestLand> getArableAndForestLand(Collection<String> regions, Collection<Integer> categories,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", Arrays.asList("MI0803AI"));
        mappings.put("Region", regions);
        mappings.put("Markanvandningsklass", categories);
        mappings.put("Tid", years);

        String response = doPostRequest(getUrl() + "MarkanvJbSk", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(ArableAndForestLand.class);
    }

    public List<BuiltUpLand> getBuiltUpLand() {
        return getBuiltUpLand(null, null, null);
    }

    public List<BuiltUpLand> getBuiltUpLand(Collection<String> regions, Collection<Integer> categories,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", Arrays.asList("MI0803AC"));
        mappings.put("Region", regions);
        mappings.put("Markanvandningsklass", categories);
        mappings.put("Tid", years);

        String response = doPostRequest(getUrl() + "MarkanvBebyggdLnKn", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(BuiltUpLand.class);
    }

    public List<LandUseByCounty> getLandUseByCounty() {
        return getLandUseByCounty(null, null, null);
    }

    public List<LandUseByCounty> getLandUseByCounty(Collection<String> regions, Collection<Integer> categories,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", Arrays.asList("MI0803AA"));
        mappings.put("Region", regions);
        mappings.put("Markanvandningsklass", categories);
        mappings.put("Tid", years);

        String response = doPostRequest(getUrl() + "MarkanvLan", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(LandUseByCounty.class);
    }

    public List<LandUseByMunicipality> getLandUseByMunicipality() {
        return getLandUseByMunicipality(null, null, null);
    }

    public List<LandUseByMunicipality> getLandUseByMunicipality(Collection<String> regions,
            Collection<Integer> categories, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", Arrays.asList("MI0803AB"));
        mappings.put("Region", regions);
        mappings.put("Markanvandningsklass", categories);
        mappings.put("Tid", years);

        String response = doPostRequest(getUrl() + "MarkanvKn", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(LandUseByMunicipality.class);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "MI/MI0803/MI0803A/";
    }

}
