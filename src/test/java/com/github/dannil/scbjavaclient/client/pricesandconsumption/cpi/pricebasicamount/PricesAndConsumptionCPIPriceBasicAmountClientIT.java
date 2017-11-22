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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.pricebasicamount;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.test.runner.Date;
import com.github.dannil.scbjavaclient.test.runner.DateJUnitRunner;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DateJUnitRunner.class)
public class PricesAndConsumptionCPIPriceBasicAmountClientIT extends RemoteIntegrationTestSuite {

    private PricesAndConsumptionCPIPriceBasicAmountClient client;

    @Before
    public void setup() {
        this.client = new PricesAndConsumptionCPIPriceBasicAmountClient();
    }

    @Test
    @Date("2017-06-19")
    public void getPriceBasicAmount() {
        assertNotEquals(0, this.client.getPriceBasicAmount().size());
    }

    @Test
    @Date("2017-06-19")
    public void getPriceBasicAmountWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPriceBasicAmount(Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-19")
    public void getPriceBasicAmountWithParameters() {
        List<Integer> years = Arrays.asList(1980, 1981);

        assertNotEquals(0, this.client.getPriceBasicAmount(years).size());
    }

    @Test
    @Date("2017-06-19")
    public void getIncreasedPriceBasicAmount() {
        assertNotEquals(0, this.client.getIncreasedPriceBasicAmount().size());
    }

    @Test
    @Date("2017-06-19")
    public void getIncreasedPriceBasicAmountWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getIncreasedPriceBasicAmount(Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-19")
    public void getIncreasedPriceBasicAmountWithParameters() {
        List<Integer> years = Arrays.asList(1998, 1999);

        assertNotEquals(0, this.client.getIncreasedPriceBasicAmount(years).size());
    }

}
