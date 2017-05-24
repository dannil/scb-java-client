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

package com.github.dannil.scbjavaclient.client.agriculture.landuse;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

@RunWith(JUnit4.class)
public class AgricultureLandUseClientIT extends RemoteIntegrationTestSuite {

    private AgricultureLandUseClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().agriculture().landUse();
    }

    @Test
    public void getUseOfArableLandByMunicipality() {
        assertNotEquals(0, this.client.getUseOfArableLandByMunicipality().size());
    }

    @Test
    public void getUseOfArableLandByMunicipalityWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getUseOfArableLandByMunicipality(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getUseOfArableLandByMunicipalityWithParameters() {
        List<String> regions = Arrays.asList("0127", "0128");
        List<String> crops = Arrays.asList("001", "55");
        List<Integer> years = Arrays.asList(1989, 1990);

        assertNotEquals(0, this.client.getUseOfArableLandByMunicipality(regions, crops, years).size());
    }

    @Test
    public void getUseOfArableLandByCounty() {
        assertNotEquals(0, this.client.getUseOfArableLandByCounty().size());
    }

    @Test
    public void getUseOfArableLandByCountyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getUseOfArableLandByCounty(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getUseOfArableLandByCountyWithParameters() {
        List<String> regions = Arrays.asList("08", "09");
        List<String> crops = Arrays.asList("001", "55");
        List<Integer> years = Arrays.asList(1989, 1990);

        assertNotEquals(0, this.client.getUseOfArableLandByCounty(regions, crops, years).size());
    }

    @Test
    public void getTypeOfLandAreaByMunicipality() {
        assertNotEquals(0, this.client.getTypeOfLandAreaByMunicipality().size());
    }

    @Test
    public void getTypeOfLandAreaByMunicipalityWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTypeOfLandAreaByMunicipality(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getTypeOfLandAreaByMunicipalityWithParameters() {
        List<String> regions = Arrays.asList("0127", "0128");
        List<Integer> typesOfLands = Arrays.asList(10, 20);
        List<Integer> years = Arrays.asList(1989, 1990);

        assertNotEquals(0, this.client.getTypeOfLandAreaByMunicipality(regions, typesOfLands, years).size());
    }

    @Test
    public void getTypeOfLandAreaByCounty() {
        assertNotEquals(0, this.client.getTypeOfLandAreaByCounty().size());
    }

    @Test
    public void getTypeOfLandAreaByCountyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTypeOfLandAreaByCounty(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getTypeOfLandAreaByCountyWithParameters() {
        List<String> regions = Arrays.asList("08", "09");
        List<Integer> typesOfLands = Arrays.asList(10, 20);
        List<Integer> years = Arrays.asList(1989, 1990);

        assertNotEquals(0, this.client.getTypeOfLandAreaByCounty(regions, typesOfLands, years).size());
    }

}
