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

package com.github.dannil.scbjavaclient.client.population.projections.latestprojections;

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
public class PopulationProjectionsLatestProjectionsClientIT extends RemoteIntegrationTestSuite {

    private PopulationProjectionsLatestProjectionsClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().population().projections().latestProjections();
    }

    @Test
    public void getPopulation() {
        assertNotEquals(0, this.client.getPopulation().size());
    }

    @Test
    public void getPopulationWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPopulation(Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getPopulationWithParameters() {
        List<String> ages = Arrays.asList("13", "66");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2038, 2053);

        assertNotEquals(0, this.client.getPopulation(ages, sexes, years).size());
    }

    @Test
    public void getPopulationChanges() {
        assertNotEquals(0, this.client.getPopulationChanges().size());
    }

    @Test
    public void getPopulationChangesWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getPopulationChanges(Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getPopulationChangesWithParameters() {
        List<String> countries = Arrays.asList("020", "060");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> ages = Arrays.asList("13", "66");
        List<Integer> years = Arrays.asList(2038, 2053);

        assertNotEquals(0, this.client.getPopulationChanges(countries, sexes, ages, years).size());
    }

    @Test
    public void getPopulationChangesOverview() {
        assertNotEquals(0, this.client.getPopulationChangesOverview().size());
    }

    @Test
    public void getPopulationChangesOverviewWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPopulationChangesOverview(Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getPopulationChangesOverviewWithParameters() {
        List<Integer> years = Arrays.asList(2038, 2053);

        assertNotEquals(0, this.client.getPopulationChangesOverview(years).size());
    }

    @Test
    public void getNumberOfBirths() {
        assertNotEquals(0, this.client.getNumberOfBirths().size());
    }

    @Test
    public void getNumberOfBirthsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNumberOfBirths(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getNumberOfBirthsWithParameters() {
        List<String> countries = Arrays.asList("020", "060");
        List<String> ages = Arrays.asList("22", "33");
        List<Integer> years = Arrays.asList(2038, 2053);

        assertNotEquals(0, this.client.getNumberOfBirths(countries, ages, years).size());
    }

    @Test
    public void getLifeExpectancy() {
        assertNotEquals(0, this.client.getLifeExpectancy().size());
    }

    @Test
    public void getLifeExpectancyWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getPopulationChanges(Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getLifeExpectancyWithParameters() {
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> ages = Arrays.asList("13", "66");
        List<Integer> years = Arrays.asList(2038, 2053);

        assertNotEquals(0, this.client.getLifeExpectancy(sexes, ages, years).size());
    }

}
