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

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EnvironmentLandUseUsageClientIT extends RemoteIntegrationTestSuite {

    private EnvironmentLandUseUsageClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().environment().landUse().usage();
    }

    @Test
    public void getArableAndForestLand() {
        assertNotEquals(0, this.client.getArableAndForestLand().size());
    }

    @Test
    public void getArableAndForestLandWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getArableAndForestLand(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()));
    }

    @Test
    public void getArableAndForestLandWithParameters() {
        List<String> regions = Arrays.asList("0114", "0140");
        List<Integer> categories = Arrays.asList(14);
        List<Integer> years = Arrays.asList(2010);

        assertNotEquals(0, this.client.getArableAndForestLand(regions, categories, years).size());
    }

    @Test
    public void getBuiltUpLand() {
        assertNotEquals(0, this.client.getBuiltUpLand().size());
    }

    @Test
    public void getBuiltUpLandWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getBuiltUpLand(Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                Collections.<Integer>emptyList()));
    }

    @Test
    public void getBuiltUpLandWithParameters() {
        List<String> regions = Arrays.asList("0114", "0140");
        List<Integer> categories = Arrays.asList(233, 236);
        List<Integer> years = Arrays.asList(2010);

        assertNotEquals(0, this.client.getBuiltUpLand(regions, categories, years).size());
    }

    @Test
    public void getLandUseByCounty() {
        assertNotEquals(0, this.client.getLandUseByCounty().size());
    }

    @Test
    public void getLandUseByCountyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getLandUseByCounty(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()));
    }

    @Test
    public void getLandUseByCountyWithParameters() {
        List<String> regions = Arrays.asList("07", "10");
        List<Integer> categories = Arrays.asList(211, 212);
        List<Integer> years = Arrays.asList(2010);

        assertNotEquals(0, this.client.getLandUseByCounty(regions, categories, years).size());
    }

    @Test
    public void getLandUseByMunicipality() {
        assertNotEquals(0, this.client.getLandUseByMunicipality().size());
    }

    @Test
    public void getLandUseByMunicipalityWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getLandUseByMunicipality(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()));
    }

    @Test
    public void getLandUseByMunicipalityWithParameters() {
        List<String> regions = Arrays.asList("0140", "0160");
        List<Integer> categories = Arrays.asList(811, 911);
        List<Integer> years = Arrays.asList(2010);

        assertNotEquals(0, this.client.getLandUseByMunicipality(regions, categories, years).size());
    }

}
