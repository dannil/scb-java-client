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

package com.github.dannil.scbjavaclient.client.population.statistics.vitalevents;

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
public class PopulationStatisticsVitalEventsClientIT {

    private PopulationStatisticsVitalEventsClient client;

    @BeforeEach
    public void setup() {
        this.client = new PopulationStatisticsVitalEventsClient();
    }

    @Test
    @Date("2017-05-10")
    public void getPopulationChangesNumberOfPersons() {
        assertNotEquals(0, this.client.getPopulationChangesNumberOfPersons().size());
    }

    @Test
    @Date("2017-05-10")
    public void getPopulationChangesNumberOfPersonsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getPopulationChangesNumberOfPersons(Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-10")
    public void getPopulationChangesNumberOfPersonsWithParameters() {
        List<String> regions = Arrays.asList("0120", "0125");
        List<Integer> populationChanges = Arrays.asList(140, 160);
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2003, 2004);

        assertNotEquals(0,
                this.client.getPopulationChangesNumberOfPersons(regions, populationChanges, sexes, years).size());
    }

    @Test
    @Date("2017-05-10")
    public void getPopulationAndPopulationChanges() {
        assertNotEquals(0, this.client.getPopulationAndPopulationChanges().size());
    }

    @Test
    @Date("2017-05-10")
    public void getPopulationAndPopulationChangesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPopulationAndPopulationChanges(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-10")
    public void getPopulationAndPopulationChangesWithParameters() {
        List<String> sexes = Arrays.asList("1", "2", "1+2");
        List<Integer> years = Arrays.asList(1876, 1948, 2004);

        assertNotEquals(0, this.client.getPopulationAndPopulationChanges(sexes, years).size());
    }

    @Test
    @Date("2017-05-10")
    public void getBirthsAndDeathsPerMonth() {
        assertNotEquals(0, this.client.getBirthsAndDeathsPerMonth().size());
    }

    @Test
    @Date("2017-05-10")
    public void getBirthsAndDeathsPerMonthWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getBirthsAndDeathsPerMonth(Collections.<Integer>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-10")
    public void getBirthsAndDeathsPerMonthWithParameters() {
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> months = Arrays.asList("06", "09");
        List<Integer> years = Arrays.asList(2008, 2010);

        assertNotEquals(0, this.client.getBirthsAndDeathsPerMonth(sexes, months, years).size());
    }

}
