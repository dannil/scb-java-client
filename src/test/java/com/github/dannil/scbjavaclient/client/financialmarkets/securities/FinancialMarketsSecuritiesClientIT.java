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

package com.github.dannil.scbjavaclient.client.financialmarkets.securities;

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
public class FinancialMarketsSecuritiesClientIT extends RemoteIntegrationTestSuite {

    private FinancialMarketsSecuritiesClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().financialMarkets().securities();
    }

    @Test
    @Date("2017-03-08")
    public void getMaturityStructure() {
        assertNotEquals(0, this.client.getMaturityStructure().size());
    }

    @Test
    @Date("2017-03-08")
    public void getMaturityStructureWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getMaturityStructure(Collections.<Integer>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-03-08")
    public void getMaturityStructureWithParameters() {
        List<Integer> sectors = Arrays.asList(113, 114);
        List<String> maturities = Arrays.asList("4-6", "24");
        List<String> currencies = Arrays.asList("v2", "v3");
        List<String> months = Arrays.asList("2013M07", "2015M09");

        assertNotEquals(0, this.client.getMaturityStructure(sectors, maturities, currencies, months).size());
    }

    @Test
    @Date("2017-03-08")
    public void getOutstandingAndIssuedAmount() {
        assertNotEquals(0, this.client.getOutstandingAndIssuedAmount().size());
    }

    @Test
    @Date("2017-03-08")
    public void getOutstandingAndIssuedAmountWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getOutstandingAndIssuedAmount(Collections.<Integer>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-03-08")
    public void getOutstandingAndIssuedAmountStructureWithParameters() {
        List<Integer> sectors = Arrays.asList(113, 114);
        List<String> items = Arrays.asList("FMTOT", "FMPMI");
        List<String> currencies = Arrays.asList("v2", "v3");
        List<String> months = Arrays.asList("2013M07", "2015M09");

        assertNotEquals(0, this.client.getOutstandingAndIssuedAmount(sectors, items, currencies, months).size());
    }

}
