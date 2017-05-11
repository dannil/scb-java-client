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

package com.github.dannil.scbjavaclient.client.population.statistics.foreignbornpersons;

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
public class PopulationStatisticsForeignBornPersonsClientIT extends RemoteIntegrationTestSuite {

    private PopulationStatisticsForeignBornPersonsClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().population().statistics().foreignBornPersons();
    }

    @Test
    public void getForeignBornPersons() {
        assertNotEquals(0, this.client.getForeignBornPersons().size());
    }

    @Test
    public void getForeignBornPersonsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getForeignBornPersons(Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getForeignBornPersonsWithParameters() {
        List<String> regions = Arrays.asList("0162", "0180");
        List<String> ages = Arrays.asList("25-34", "55-64");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2009);

        assertNotEquals(0, this.client.getForeignBornPersons(regions, ages, sexes, years).size());
    }

    @Test
    public void getForeignBornPersonsInSweden() {
        assertNotEquals(0, this.client.getForeignBornPersonsInSweden().size());
    }

    @Test
    public void getForeignBornPersonsInSwedenWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getForeignBornPersonsInSweden(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getForeignBornPersonsInSwedenWithParameters() {
        List<String> countriesOfBirths = Arrays.asList("AU", "DK");
        List<String> ages = Arrays.asList("30-34", "40-44");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2009);

        assertNotEquals(0, this.client.getForeignBornPersonsInSweden(countriesOfBirths, ages, sexes, years).size());
    }

}
