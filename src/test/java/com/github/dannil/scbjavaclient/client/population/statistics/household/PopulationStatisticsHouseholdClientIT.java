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

package com.github.dannil.scbjavaclient.client.population.statistics.household;

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
public class PopulationStatisticsHouseholdClientIT extends RemoteIntegrationTestSuite {

    private PopulationStatisticsHouseholdClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().population().statistics().household();
    }

    @Test
    public void getNumberOfHouseholdsAndPersons() {
        assertNotEquals(0, this.client.getNumberOfHouseholdsAndPersons().size());
    }

    @Test
    public void getNumberOfHouseholdsAndPersonsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getNumberOfHouseholdsAndPersons(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getNumberOfHouseholdsAndPersonsWithParameters() {
        List<String> regions = Arrays.asList("0162", "0180");
        List<String> typesOfHouseholds = Arrays.asList("SMUB", "SAKNAS");
        List<String> numberOfChildrens = Arrays.asList("M1B", "M2B");
        List<Integer> years = Arrays.asList(2014);

        assertNotEquals(0, this.client.getNumberOfHouseholdsAndPersons(regions, typesOfHouseholds, numberOfChildrens,
                years).size());
    }

    @Test
    public void getNumberOfPersons() {
        assertNotEquals(0, this.client.getNumberOfPersons().size());
    }

    @Test
    public void getNumberOfPersonsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getNumberOfPersons(Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getNumberOfPersonsWithParameters() {
        List<String> typesOfHouseholds = Arrays.asList("SMUB", "SAKNAS");
        List<String> householdStatuses = Arrays.asList("BBarn", "Bensm");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> ages = Arrays.asList("0", "100+");
        List<Integer> years = Arrays.asList(2014);

        assertNotEquals(0,
                this.client.getNumberOfPersons(typesOfHouseholds, householdStatuses, sexes, ages, years).size());
    }

    @Test
    public void getNumberOfAndPercentageOfPersonsAndHouseholds() {
        assertNotEquals(0, this.client.getNumberOfAndPercentageOfPersonsAndHouseholds().size());
    }

    @Test
    public void getNumberOfAndPercentageOfPersonsAndHouseholdsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNumberOfAndPercentageOfPersonsAndHouseholds(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getNumberOfAndPercentageOfPersonsAndHouseholdsWithParameters() {
        List<String> regions = Arrays.asList("0162", "0180");
        List<String> householdSizes = Arrays.asList("4P", "US");
        List<Integer> years = Arrays.asList(2014);

        assertNotEquals(0,
                this.client.getNumberOfAndPercentageOfPersonsAndHouseholds(regions, householdSizes, years).size());
    }

}
