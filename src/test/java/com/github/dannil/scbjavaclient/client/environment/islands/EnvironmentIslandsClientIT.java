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

package com.github.dannil.scbjavaclient.client.environment.islands;

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
public class EnvironmentIslandsClientIT extends RemoteIntegrationTestSuite {

    private EnvironmentIslandsClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().environment().islands();
    }

    @Test
    public void getShorelinePopulation() {
        assertNotEquals(0, this.client.getShorelinePopulation().size());
    }

    @Test
    public void getShorelinePopulationWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getShorelinePopulation(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getShorelinePopulationWithParameters() {
        List<String> regions = Arrays.asList("0117", "0120");
        List<String> livings = Arrays.asList("TO", "UTO");
        List<Integer> years = Arrays.asList(2013);

        assertNotEquals(0, this.client.getShorelinePopulation(regions, livings, years).size());
    }

    @Test
    public void getPopulatedIslands() {
        assertNotEquals(0, this.client.getPopulatedIslands().size());
    }

    @Test
    public void getPopulatedIslandsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPopulatedIslands(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getPopulatedIslandsWithParameters() {
        List<String> regions = Arrays.asList("0117", "0120");
        List<Integer> years = Arrays.asList(2013);

        assertNotEquals(0, this.client.getPopulatedIslands(regions, years).size());
    }

    @Test
    public void getIslandsInSweden() {
        assertNotEquals(0, this.client.getIslandsInSweden().size());
    }

    @Test
    public void getIslandsInSwedenWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getIslandsInSweden(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getIslandsInSwedenWithParameters() {
        List<String> regions = Arrays.asList("0117", "0120");
        List<Integer> years = Arrays.asList(2013);

        assertNotEquals(0, this.client.getIslandsInSweden(regions, years).size());
    }

    @Test
    public void getBuildingsOnIslands() {
        assertNotEquals(0, this.client.getBuildingsOnIslands().size());
    }

    @Test
    public void getBuildingsOnIslandsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getBuildingsOnIslands(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getBuildingsOnIslandsWithParameters() {
        List<String> regions = Arrays.asList("0117", "0120");
        List<Integer> years = Arrays.asList(2013);

        assertNotEquals(0, this.client.getBuildingsOnIslands(regions, years).size());
    }

    @Test
    public void getIslandsInSwedenNumberAreaAndPerimiter() {
        assertNotEquals(0, this.client.getIslandsInSwedenNumberAreaAndPerimiter().size());
    }

    @Test
    public void getIslandsInSwedenNumberAreaAndPerimiterWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getIslandsInSwedenNumberAreaAndPerimiter(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getIslandsInSwedenNumberAreaAndPerimiterWithParameters() {
        List<String> regions = Arrays.asList("0117", "0120");
        List<Integer> years = Arrays.asList(2013);

        assertNotEquals(0, this.client.getIslandsInSwedenNumberAreaAndPerimiter(regions, years).size());
    }

    @Test
    public void getPopulationOnIslands() {
        assertNotEquals(0, this.client.getPopulationOnIslands().size());
    }

    @Test
    public void getPopulationOnIslandsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPopulationOnIslands(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getPopulationOnIslandsWithParameters() {
        List<String> regions = Arrays.asList("0117", "0120");
        List<Integer> years = Arrays.asList(2013);

        assertNotEquals(0, this.client.getPopulationOnIslands(regions, years).size());
    }

    @Test
    public void getNumberOfIslandsInSweden() {
        assertNotEquals(0, this.client.getNumberOfIslandsInSweden().size());
    }

    @Test
    public void getNumberOfIslandsInSwedenWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNumberOfIslandsInSweden(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getNumberOfIslandsInSwedenWithParameters() {
        List<String> regions = Arrays.asList("0117", "0120");
        List<String> sizeClasses = Arrays.asList("1-9", "10-99");
        List<Integer> years = Arrays.asList(2013);

        assertNotEquals(0, this.client.getNumberOfIslandsInSweden(regions, sizeClasses, years).size());
    }

}
