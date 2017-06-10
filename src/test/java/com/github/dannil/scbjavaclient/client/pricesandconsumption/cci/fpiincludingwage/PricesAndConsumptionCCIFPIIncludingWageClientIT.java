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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.cci.fpiincludingwage;

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
public class PricesAndConsumptionCCIFPIIncludingWageClientIT extends RemoteIntegrationTestSuite {

    private PricesAndConsumptionCCIFPIIncludingWageClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().pricesAndConsumption().cci().fpiIncludingWage();
    }

    @Test
    public void getFactorPriceIndexForBuildings1968Years() {
        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings1968Years().size());
    }

    @Test
    public void getFactorPriceIndexForBuildings1968YearsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings1968Years(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getFactorPriceIndexForBuildings1968YearsWithParameters() {
        List<String> typesOfBuildings = Arrays.asList("FLERBO", "GRUPPSMÅ");
        List<String> typesOfExpenditures = Arrays.asList("TOTIM", "ARBL");
        List<Integer> years = Arrays.asList(1989, 1991);

        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings1968Years(typesOfBuildings, typesOfExpenditures,
                years).size());
    }

    @Test
    public void getFactorPriceIndexForBuildings2004Years() {
        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings2004Years().size());
    }

    @Test
    public void getFactorPriceIndexForBuildings2004YearsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings2004Years(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getFactorPriceIndexForBuildings2004YearsWithParameters() {
        List<String> typesOfBuildings = Arrays.asList("FLERBO", "GRUPPSMÅ");
        List<String> typesOfExpenditures = Arrays.asList("TOTIM", "ARBL");
        List<Integer> years = Arrays.asList(2010, 2011);

        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings2004Years(typesOfBuildings, typesOfExpenditures,
                years).size());
    }

}
