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

package com.github.dannil.scbjavaclient.client.financialmarkets.investmentfunds;

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
import org.junit.runners.JUnit4;

@RunWith(DateJUnitRunner.class)
public class FinancialMarketsInvestmentFundsClientIT extends RemoteIntegrationTestSuite {

    private FinancialMarketsInvestmentFundsClient client;

    @Before
    public void setup() {
        this.client = new FinancialMarketsInvestmentFundsClient();
    }

    @Test
    @Date("2017-11-22")
    public void getOwnershipOfInvestmentFund() {
        assertNotEquals(0, this.client.getOwnershipOfInvestmentFund().size());
    }

    @Test
    @Date("2017-11-22")
    public void getOwnershipOfInvestmentFundWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getOwnershipOfInvestmentFund(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-11-22")
    public void getOwnershipOfInvestmentFundWithParameters() {
        List<String> observations = Arrays.asList("inbet", "utbet");
        List<String> types = Arrays.asList("S12251", "S12354");
        List<String> sectors = Arrays.asList("S14", "S15");
        List<String> quarters = Arrays.asList("2011K1", "2011K2");

        assertNotEquals(0, this.client.getOwnershipOfInvestmentFund(observations, types, sectors, quarters).size());
    }

}
