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
import com.github.dannil.scbjavaclient.test.runner.Date;
import com.github.dannil.scbjavaclient.test.runner.DateJUnitRunner;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DateJUnitRunner.class)
public class PopulationStatisticsForeignBornPersonsClientIT extends RemoteIntegrationTestSuite {

    private PopulationStatisticsForeignBornPersonsClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().population().statistics().foreignBornPersons();
    }

    @Test
    @Date("2017-06-09")
    public void getSwedishAndForeignBornPopulation() {
        assertNotEquals(0, this.client.getSwedishAndForeignBornPopulation().size());
    }

    @Test
    @Date("2017-06-09")
    public void getSwedishAndForeignBornPopulationWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getSwedishAndForeignBornPopulation(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-09")
    public void getSwedishAndForeignBornPopulationWithParameters() {
        List<String> regions = Arrays.asList("0162", "0180");
        List<String> ages = Arrays.asList("77", "100+");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2009);

        assertNotEquals(0, this.client.getSwedishAndForeignBornPopulation(regions, ages, sexes, years).size());
    }

    @Test
    @Date("2017-06-09")
    public void getPopulationByCountryOfBirth() {
        assertNotEquals(0, this.client.getPopulationByCountryOfBirth().size());
    }

    @Test
    @Date("2017-06-09")
    public void getPopulationByCountryOfBirthWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getPopulationByCountryOfBirth(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-09")
    public void getPopulationByCountryOfBirthWithParameters() {
        List<String> countriesOfBirths = Arrays.asList("AU", "DK");
        List<String> ages = Arrays.asList("77", "100+");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2009);

        assertNotEquals(0, this.client.getPopulationByCountryOfBirth(countriesOfBirths, ages, sexes, years).size());
    }

}
