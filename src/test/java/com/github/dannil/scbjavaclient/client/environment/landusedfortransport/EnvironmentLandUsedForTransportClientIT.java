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

package com.github.dannil.scbjavaclient.client.environment.landusedfortransport;

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
public class EnvironmentLandUsedForTransportClientIT extends RemoteIntegrationTestSuite {

    private EnvironmentLandUsedForTransportClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().environment().landUsedForTransport();
    }

    @Test
    public void getTransportInfrastructureArea() {
        assertNotEquals(0, this.client.getTransportInfrastructureArea().size());
    }

    @Test
    public void getTransportInfrastructureAreaWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTransportInfrastructureArea(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getTransportInfrastructureAreaWithParameters() {
        List<String> regions = Arrays.asList("0184", "0186");
        List<Integer> years = Arrays.asList(2010);

        assertNotEquals(0, this.client.getTransportInfrastructureArea(regions, years).size());
    }

    @Test
    public void getRoadLengthByOwner() {
        assertNotEquals(0, this.client.getRoadLengthByOwner().size());
    }

    @Test
    public void getRoadLengthByRoadOwnerWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getRoadLengthByOwner(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getRoadLengthByOwnerWithParameters() {
        List<String> regions = Arrays.asList("0184", "0186");
        List<String> owners = Arrays.asList("04", "06");
        List<Integer> years = Arrays.asList(2010);

        assertNotEquals(0, this.client.getRoadLengthByOwner(regions, owners, years).size());
    }

    @Test
    public void getRailways() {
        assertNotEquals(0, this.client.getRailways().size());
    }

    @Test
    public void getRailwaysWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getRailways(Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getRailwaysWithParameters() {
        List<String> regions = Arrays.asList("0184", "0186");
        List<Integer> years = Arrays.asList(2010);

        assertNotEquals(0, this.client.getRailways(regions, years).size());
    }

    @Test
    public void getRoadArea() {
        assertNotEquals(0, this.client.getRoadArea().size());
    }

    @Test
    public void getRoadAreaWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getRoadArea(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getRoadAreaWithParameters() {
        List<String> regions = Arrays.asList("0184", "0186");
        List<String> areas = Arrays.asList("VagOmr", "VagBana");
        List<Integer> years = Arrays.asList(2010);

        assertNotEquals(0, this.client.getRoadArea(regions, areas, years).size());
    }

    @Test
    public void getRoadLengthByCategory() {
        assertNotEquals(0, this.client.getRoadLengthByCategory().size());
    }

    @Test
    public void getRoadLengthByCategoryWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getRoadLengthByCategory(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getRoadLengthByCategoryWithParameters() {
        List<String> regions = Arrays.asList("0184", "0186");
        List<String> categories = Arrays.asList("L", "O");
        List<Integer> years = Arrays.asList(2010);

        assertNotEquals(0, this.client.getRoadLengthByCategory(regions, categories, years).size());
    }

}
