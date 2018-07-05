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

package com.github.dannil.scbjavaclient.client.population.statistics.background;

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
public class PopulationStatisticsBackgroundClientIT {

    private PopulationStatisticsBackgroundClient client;

    @BeforeEach
    public void setup() {
        this.client = new PopulationStatisticsBackgroundClient();
    }

    @Test
    @Date("2017-06-09")
    public void getPersonWithBackgroundRoughDivision() {
        assertNotEquals(0, this.client.getPersonsWithBackgroundRoughDivision().size());
    }

    @Test
    @Date("2017-06-09")
    public void getPersonWithBackgroundRoughDivisionWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getPersonsWithBackgroundRoughDivision(Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-09")
    public void getPersonWithBackgroundRoughDivisionWithParameters() {
        List<String> regions = Arrays.asList("0162", "0180");
        List<Integer> backgrounds = Arrays.asList(1, 2);
        List<String> ages = Arrays.asList("77", "100+");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2009);

        assertNotEquals(0,
                this.client.getPersonsWithBackgroundRoughDivision(regions, backgrounds, ages, sexes, years).size());
    }

    @Test
    @Date("2017-06-09")
    public void getPersonWithBackgroundDetailedDivision() {
        assertNotEquals(0, this.client.getPersonsWithBackgroundDetailedDivision().size());
    }

    @Test
    @Date("2017-06-09")
    public void getPersonWithBackgroundDetailedDivisionWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getPersonsWithBackgroundDetailedDivision(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-09")
    public void getPersonWithBackgroundDetailedDivisionWithParameters() {
        List<String> regions = Arrays.asList("0162", "0180");
        List<String> backgrounds = Arrays.asList("08", "4");
        List<String> ages = Arrays.asList("77", "100+");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2009);

        assertNotEquals(0,
                this.client.getPersonsWithBackgroundDetailedDivision(regions, backgrounds, ages, sexes, years).size());
    }

}
