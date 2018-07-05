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
public class PopulationProjectionsLatestProjectionsClientIT {

    private PopulationProjectionsLatestProjectionsClient client;

    @BeforeEach
    public void setup() {
        this.client = new PopulationProjectionsLatestProjectionsClient();
    }

    @Test
    @Date("2018-05-12")
    public void getPopulation() {
        assertNotEquals(0, this.client.getPopulation().size());
    }

    @Test
    @Date("2018-05-12")
    public void getPopulationWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPopulation(Collections.<Integer>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-05-12")
    public void getPopulationWithParameters() {
        List<Integer> regionOfBirths = Arrays.asList(13, 23);
        List<String> ages = Arrays.asList("13", "66");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2038, 2053);

        assertNotEquals(0, this.client.getPopulation(regionOfBirths, ages, sexes, years).size());
    }

    @Test
    @Date("2018-05-12")
    public void getPopulationChanges() {
        assertNotEquals(0, this.client.getPopulationChanges().size());
    }

    @Test
    @Date("2018-05-12")
    public void getPopulationChangesWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getPopulationChanges(Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-05-12")
    public void getPopulationChangesWithParameters() {
        List<String> countries = Arrays.asList("020", "060");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> ages = Arrays.asList("13", "66");
        List<Integer> years = Arrays.asList(2038, 2053);

        assertNotEquals(0, this.client.getPopulationChanges(countries, sexes, ages, years).size());
    }

    @Test
    @Date("2018-05-12")
    public void getPopulationChangesOverview() {
        assertNotEquals(0, this.client.getPopulationChangesOverview().size());
    }

    @Test
    @Date("2018-05-12")
    public void getPopulationChangesOverviewWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPopulationChangesOverview(Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-05-12")
    public void getPopulationChangesOverviewWithParameters() {
        List<Integer> years = Arrays.asList(2038, 2053);

        assertNotEquals(0, this.client.getPopulationChangesOverview(years).size());
    }

    @Test
    @Date("2018-05-12")
    public void getNumberOfBirths() {
        assertNotEquals(0, this.client.getNumberOfBirths().size());
    }

    @Test
    @Date("2018-05-12")
    public void getNumberOfBirthsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNumberOfBirths(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-05-12")
    public void getNumberOfBirthsWithParameters() {
        List<String> countries = Arrays.asList("020", "060");
        List<String> ages = Arrays.asList("22", "33");
        List<Integer> years = Arrays.asList(2038, 2053);

        assertNotEquals(0, this.client.getNumberOfBirths(countries, ages, years).size());
    }

    @Test
    @Date("2018-05-12")
    public void getLifeExpectancy() {
        assertNotEquals(0, this.client.getLifeExpectancy().size());
    }

    @Test
    @Date("2018-05-12")
    public void getLifeExpectancyWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getPopulationChanges(Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-05-12")
    public void getLifeExpectancyWithParameters() {
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> ages = Arrays.asList("13", "66");
        List<Integer> years = Arrays.asList(2038, 2053);

        assertNotEquals(0, this.client.getLifeExpectancy(sexes, ages, years).size());
    }

}
