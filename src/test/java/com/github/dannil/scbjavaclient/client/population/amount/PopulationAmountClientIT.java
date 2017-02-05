/*
 * Copyright 2014 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.population.amount;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.client.population.amount.PopulationAmountClient;
import com.github.dannil.scbjavaclient.test.RemoteIntegrationTestSuite;

@RunWith(JUnit4.class)
public class PopulationAmountClientIT extends RemoteIntegrationTestSuite {

    private PopulationAmountClient populationAmountClient;

    @Before
    public void setup() {
        this.populationAmountClient = new SCBClient().population().amount();
    }

    @Test
    public void getPopulation() {
        assertNotEquals(0, this.populationAmountClient.getPopulation().size());
    }

    @Test
    public void getPopulationWithParameters() {
        List<String> regions = Arrays.asList("1263");
        List<String> statuses = Arrays.asList("OG", "G", "SK", "ÄNKL");
        List<String> ages = Arrays.asList("25");
        List<Integer> genders = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(1996);

        assertNotEquals(0, this.populationAmountClient.getPopulation(regions, statuses, ages, genders, years).size());
    }

}
