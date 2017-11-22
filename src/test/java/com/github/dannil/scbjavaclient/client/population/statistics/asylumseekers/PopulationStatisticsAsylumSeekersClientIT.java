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

package com.github.dannil.scbjavaclient.client.population.statistics.asylumseekers;

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
public class PopulationStatisticsAsylumSeekersClientIT extends RemoteIntegrationTestSuite {

    private PopulationStatisticsAsylumSeekersClient client;

    @Before
    public void setup() {
        this.client = new PopulationStatisticsAsylumSeekersClient();
    }

    @Test
    @Date("2017-08-23")
    public void getAsylumSeekers() {
        assertNotEquals(0, this.client.getAsylumSeekers().size());
    }

    @Test
    @Date("2017-08-23")
    public void getAsylumSeekersWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getAsylumSeekers(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-08-23")
    public void getAsylumSeekersWithParameters() {
        List<String> countriesOfCitizenships = Arrays.asList("CD", "HR");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2009);

        assertNotEquals(0, this.client.getAsylumSeekers(countriesOfCitizenships, sexes, years).size());
    }

    @Test
    @Date("2017-04-27")
    public void getUnaccompaniedRefugeeMinors() {
        assertNotEquals(0, this.client.getUnaccompaniedRefugeeMinors().size());
    }

    @Test
    @Date("2017-04-27")
    public void getUnaccompaniedRefugeeMinorsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getUnaccompaniedRefugeeMinors(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-27")
    public void getUnaccompaniedRefugeeMinorsWithParameters() {
        List<String> sexes = Arrays.asList("5", "6");
        List<String> ages = Arrays.asList("0-6");
        List<String> countriesOfCitizenships = Arrays.asList("AD", "BS");
        List<Integer> years = Arrays.asList(2009);

        assertNotEquals(0,
                this.client.getUnaccompaniedRefugeeMinors(sexes, ages, countriesOfCitizenships, years).size());
    }

}
