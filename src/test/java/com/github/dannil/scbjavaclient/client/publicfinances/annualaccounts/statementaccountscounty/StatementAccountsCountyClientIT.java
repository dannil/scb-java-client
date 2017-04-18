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

package com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.statementaccountscounty;

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
public class StatementAccountsCountyClientIT extends RemoteIntegrationTestSuite {

    private StatementAccountsCountyClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().publicFinances().annualAccounts().statementAccountsCounty();
    }

    @Test
    public void getExpensesAndRevenues() {
        assertNotEquals(0, this.client.getExpensesAndRevenues().size());
    }

    @Test
    public void getExpensesAndRevenuesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getExpensesAndRevenues(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getExpensesAndRevenuesWithParameters() {
        List<String> regions = Arrays.asList("03L", "05L");
        List<String> activities = Arrays.asList("440", "0-4");
        List<Integer> years = Arrays.asList(2009, 2012);

        assertNotEquals(0, this.client.getExpensesAndRevenues(regions, activities, years).size());
    }

    @Test
    public void getNetCosts() {
        assertNotEquals(0, this.client.getNetCosts().size());
    }

    @Test
    public void getNetCostsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNetCosts(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getNetCostsWithParameters() {
        List<String> regions = Arrays.asList("03L", "05L");
        List<String> activities = Arrays.asList("310", "0-4");
        List<Integer> years = Arrays.asList(2009, 2012);

        assertNotEquals(0, this.client.getNetCosts(regions, activities, years).size());
    }

    @Test
    public void getPurchasesAndSales() {
        assertNotEquals(0, this.client.getPurchasesAndSales().size());
    }

    @Test
    public void getPurchasesAndSalesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPurchasesAndSales(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getPurchasesAndSalesWithParameters() {
        List<String> regions = Arrays.asList("03L", "05L");
        List<String> activities = Arrays.asList("430", "440");
        List<Integer> years = Arrays.asList(2013, 2014);

        assertNotEquals(0, this.client.getPurchasesAndSales(regions, activities, years).size());
    }

    @Test
    public void getContributions() {
        assertNotEquals(0, this.client.getContributions().size());
    }

    @Test
    public void getContributionsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getContributions(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getContributionsWithParameters() {
        List<String> regions = Arrays.asList("03L", "05L");
        List<String> activities = Arrays.asList("5", "5-8");
        List<Integer> years = Arrays.asList(2013, 2014);

        assertNotEquals(0, this.client.getContributions(regions, activities, years).size());
    }

    // Daniel 2017-04-17: Returns HTTP 403
    //
    // @Test
    // public void getIncomeAndCosts() {
    // assertNotEquals(0, this.client.getIncomeAndCosts().size());
    // }

    // Daniel 2017-04-17: Returns HTTP 403
    //
    // @Test
    // public void getIncomeAndCostsWithParametersEmptyLists() {
    // assertNotEquals(0, this.client.getIncomeAndCosts(Collections.<String>emptyList(),
    // Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    // }

    @Test
    public void getIncomeAndCostsWithParameters() {
        List<String> regions = Arrays.asList("03L", "05L");
        List<String> activities = Arrays.asList("710", "710_1");
        List<Integer> years = Arrays.asList(2013, 2014);

        assertNotEquals(0, this.client.getIncomeAndCosts(regions, activities, years).size());
    }

    @Test
    public void getInvestments() {
        assertNotEquals(0, this.client.getInvestments().size());
    }

    @Test
    public void getInvestmentsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getInvestments(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getInvestmentsWithParameters() {
        List<String> regions = Arrays.asList("03L", "05L");
        List<String> activities = Arrays.asList("430", "440");
        List<Integer> years = Arrays.asList(2013, 2014);

        assertNotEquals(0, this.client.getInvestments(regions, activities, years).size());
    }

}
