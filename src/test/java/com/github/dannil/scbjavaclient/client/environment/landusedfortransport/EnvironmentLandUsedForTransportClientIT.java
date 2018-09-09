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

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
@Remote
public class EnvironmentLandUsedForTransportClientIT {

    private EnvironmentLandUsedForTransportClient client;

    @BeforeEach
    public void setup() {
        this.client = new EnvironmentLandUsedForTransportClient();
    }

    @Test
    @Date("2017-05-29")
    public void getTransportInfrastructureArea() {
        assertNotEquals(0, this.client.getTransportInfrastructureArea().size());
    }

    @Test
    @Date("2017-05-29")
    public void getTransportInfrastructureAreaWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTransportInfrastructureArea(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-29")
    public void getTransportInfrastructureAreaWithParameters() {
        List<String> regions = Arrays.asList("0184", "0186");
        List<Integer> years = Arrays.asList(2010);

        assertNotEquals(0, this.client.getTransportInfrastructureArea(regions, years).size());
    }

    @Test
    @Date("2017-05-29")
    public void getRoadLengthByOwner() {
        assertNotEquals(0, this.client.getRoadLengthByOwner().size());
    }

    @Test
    @Date("2017-05-29")
    public void getRoadLengthByRoadOwnerWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getRoadLengthByOwner(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-29")
    public void getRoadLengthByOwnerWithParameters() {
        List<String> regions = Arrays.asList("0184", "0186");
        List<String> owners = Arrays.asList("04", "06");
        List<Integer> years = Arrays.asList(2010);

        assertNotEquals(0, this.client.getRoadLengthByOwner(regions, owners, years).size());
    }

    @Test
    @Date("2017-05-29")
    public void getRailways() {
        assertNotEquals(0, this.client.getRailways().size());
    }

    @Test
    @Date("2017-05-29")
    public void getRailwaysWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getRailways(Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-29")
    public void getRailwaysWithParameters() {
        List<String> regions = Arrays.asList("0184", "0186");
        List<Integer> years = Arrays.asList(2010);

        assertNotEquals(0, this.client.getRailways(regions, years).size());
    }

    @Test
    @Date("2017-05-29")
    public void getRoadArea() {
        assertNotEquals(0, this.client.getRoadArea().size());
    }

    @Test
    @Date("2017-05-29")
    public void getRoadAreaWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getRoadArea(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-29")
    public void getRoadAreaWithParameters() {
        List<String> regions = Arrays.asList("0184", "0186");
        List<String> areas = Arrays.asList("VagOmr", "VagBana");
        List<Integer> years = Arrays.asList(2010);

        assertNotEquals(0, this.client.getRoadArea(regions, areas, years).size());
    }

    @Test
    @Date("2017-05-29")
    public void getRoadLengthByCategory() {
        assertNotEquals(0, this.client.getRoadLengthByCategory().size());
    }

    @Test
    @Date("2017-05-29")
    public void getRoadLengthByCategoryWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getRoadLengthByCategory(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-29")
    public void getRoadLengthByCategoryWithParameters() {
        List<String> regions = Arrays.asList("0184", "0186");
        List<String> categories = Arrays.asList("L", "O");
        List<Integer> years = Arrays.asList(2010);

        assertNotEquals(0, this.client.getRoadLengthByCategory(regions, categories, years).size());
    }

}
