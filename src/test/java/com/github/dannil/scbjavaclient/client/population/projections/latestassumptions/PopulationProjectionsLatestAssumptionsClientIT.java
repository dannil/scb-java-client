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

package com.github.dannil.scbjavaclient.client.population.projections.latestassumptions;

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
public class PopulationProjectionsLatestAssumptionsClientIT extends RemoteIntegrationTestSuite {

    private PopulationProjectionsLatestAssumptionsClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().population().projections().latestAssumptions();
    }

    @Test
    @Date("2017-04-10")
    public void getDeathRate() {
        assertNotEquals(0, this.client.getDeathRate().size());
    }

    @Test
    @Date("2017-04-10")
    public void getDeathRateWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getDeathRate(Collections.<Integer>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-10")
    public void getDeathRateWithParameters() {
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> ages = Arrays.asList("21", "31");
        List<Integer> years = Arrays.asList(2038, 2053);

        assertNotEquals(0, this.client.getDeathRate(sexes, ages, years).size());
    }

    @Test
    @Date("2017-04-10")
    public void getFertilityAssumption() {
        assertNotEquals(0, this.client.getFertilityAssumption().size());
    }

    @Test
    @Date("2017-04-10")
    public void getFertilityAssumptionWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getFertilityAssumption(Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-10")
    public void getFertilityAssumptionWithParameters() {
        List<Integer> years = Arrays.asList(2038, 2053);

        assertNotEquals(0, this.client.getFertilityAssumption(years).size());
    }

}
