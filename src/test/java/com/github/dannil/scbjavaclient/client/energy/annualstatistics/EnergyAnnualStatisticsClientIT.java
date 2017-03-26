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

package com.github.dannil.scbjavaclient.client.energy.annualstatistics;

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
public class EnergyAnnualStatisticsClientIT extends RemoteIntegrationTestSuite {

    private EnergyAnnualStatisticsClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().energy().annualStatistics();
    }

    @Test
    public void getConsumptionOfFuelsInElectricityGeneration() {
        assertNotEquals(0, this.client.getConsumptionOfFuelsInElectricityGeneration().size());
    }

    @Test
    public void getConsumptionOfFuelsInElectricityGenerationWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getConsumptionOfFuelsInElectricityGeneration(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()));
    }

    @Test
    public void getConsumptionOfFuelsInElectricityGenerationWithParameters() {
        List<String> powerPlants = Arrays.asList("Kraftvindkr", "Gasturbin");
        List<String> fuels = Arrays.asList("kok", "karn");
        List<Integer> years = Arrays.asList(1997, 1999);

        assertNotEquals(0, this.client.getConsumptionOfFuelsInElectricityGeneration(powerPlants, fuels, years).size());
    }

    @Test
    public void getElectricitySupply() {
        assertNotEquals(0, this.client.getElectricitySupply().size());
    }

    @Test
    public void getElectricitySupplyWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getElectricitySupply(Collections.<String>emptyList(), Collections.<Integer>emptyList()));
    }

    @Test
    public void getElectricitySupplyWithParameters() {
        List<String> powerPlants = Arrays.asList("Kraftvi", "Vind");
        List<Integer> years = Arrays.asList(1997, 1999);

        System.out.println(this.client.getElectricitySupply(powerPlants, years));

        assertNotEquals(0, this.client.getElectricitySupply(powerPlants, years).size());
    }

}
