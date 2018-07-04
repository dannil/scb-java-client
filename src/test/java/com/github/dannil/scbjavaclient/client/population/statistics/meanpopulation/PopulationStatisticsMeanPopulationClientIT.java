/*
 * Copyright 2018 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.population.statistics.meanpopulation;

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
public class PopulationStatisticsMeanPopulationClientIT {

    private PopulationStatisticsMeanPopulationClient client;

    @BeforeEach
    public void setup() {
        this.client = new PopulationStatisticsMeanPopulationClient();
    }

    @Test
    @Date("2018-06-22")
    public void getMeanPopulationByBirthYear() {
        assertNotEquals(0, this.client.getMeanPopulationByBirthYear().size());
    }

    @Test
    @Date("2018-06-22")
    public void getMeanPopulationByBirthYearWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getMeanPopulationByBirthYear(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-06-22")
    public void getMeanPopulationByBirthYearWithParameters() {
        List<String> regions = Arrays.asList("0160", "0162");
        List<String> ages = Arrays.asList("34", "36+");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2009, 2010);

        assertNotEquals(0, this.client.getMeanPopulationByBirthYear(regions, ages, sexes, years).size());
    }

    @Test
    @Date("2018-06-22")
    public void getMeanPopulationByCurrentAge() {
        assertNotEquals(0, this.client.getMeanPopulationByCurrentAge().size());
    }

    @Test
    @Date("2018-06-22")
    public void getMeanPopulationByCurrentAgeWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getMeanPopulationByCurrentAge(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-06-22")
    public void getMeanPopulationByCurrentAgeWithParameters() {
        List<String> regions = Arrays.asList("0160", "0162");
        List<String> maritalStatuses = Arrays.asList("OG", "G");
        List<String> ages = Arrays.asList("34", "36+");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2009, 2010);

        assertNotEquals(0, this.client.getMeanPopulationByCurrentAge(regions, maritalStatuses, ages, sexes, years).size());
    }

}
