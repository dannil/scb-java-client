/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.population.demography;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.runner.Date;
import com.github.dannil.scbjavaclient.test.runner.DateJUnitRunner;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DateJUnitRunner.class)
public class PopulationDemographyClientIT extends RemoteIntegrationTestSuite {

    private PopulationDemographyClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().population().demography();
    }

    @Test
    @Date("2017-01-01")
    public void getFertilityRate() {
        assertNotEquals(0, this.client.getFertilityRate().size());
    }

    @Test
    @Date("2017-01-01")
    public void getFertilityRateWithParameters() {
        List<String> regions = Arrays.asList("1263");
        List<Integer> genders = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2002);

        assertNotEquals(0, this.client.getFertilityRate(regions, genders, years).size());
    }

    @Test
    @Date("2017-01-01")
    public void getMeanAgeFirstChild() {
        assertNotEquals(0, this.client.getMeanAgeFirstChild().size());
    }

    @Test
    @Date("2017-01-01")
    public void getMeanAgeFirstChildWithParameters() {
        List<String> regions = Arrays.asList("1263");
        List<Integer> genders = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2002);

        assertNotEquals(0, this.client.getMeanAgeFirstChild(regions, genders, years).size());
    }

}
