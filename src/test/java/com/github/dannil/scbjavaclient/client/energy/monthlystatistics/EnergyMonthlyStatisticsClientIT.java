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

package com.github.dannil.scbjavaclient.client.energy.monthlystatistics;

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
public class EnergyMonthlyStatisticsClientIT extends RemoteIntegrationTestSuite {

    private EnergyMonthlyStatisticsClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().energy().monthlyStatistics();
    }

    @Test
    @Date("2017-03-14")
    public void getDeliveriesOfLiquidFuels() {
        assertNotEquals(0, this.client.getDeliveriesOfLiquidFuels().size());
    }

    @Test
    @Date("2017-03-14")
    public void getDeliveriesOfLiquidFuelsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getDeliveriesOfLiquidFuels(Collections.<Integer>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-03-14")
    public void getDeliveriesOfLiquidFuelsWithParameters() {
        List<Integer> commodities = Arrays.asList(36, 39);
        List<String> userCategories = Arrays.asList("010", "014");
        List<String> months = Arrays.asList("2006M02", "2006M07");

        assertNotEquals(0, this.client.getDeliveriesOfLiquidFuels(commodities, userCategories, months).size());
    }

    @Test
    @Date("2017-03-14")
    public void getDeliveriesOfOilProducts() {
        assertNotEquals(0, this.client.getDeliveriesOfOilProducts().size());
    }

    @Test
    @Date("2017-03-14")
    public void getDeliveriesOfOilProductsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getDeliveriesOfOilProducts(Collections.<Integer>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-03-14")
    public void getDeliveriesOfOilProductsWithParameters() {
        List<Integer> commodities = Arrays.asList(13, 15);
        List<String> userCategories = Arrays.asList("002", "004");
        List<String> months = Arrays.asList("2006M02", "2006M07");

        assertNotEquals(0, this.client.getDeliveriesOfOilProducts(commodities, userCategories, months).size());
    }

}
