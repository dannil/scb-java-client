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

package com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.balancesheetcounty;

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
public class PublicFinancesAnnualAccountsBalanceSheetCountyClientIT extends RemoteIntegrationTestSuite {

    private PublicFinancesAnnualAccountsBalanceSheetCountyClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().publicFinances().annualAccounts().balanceSheetCounty();
    }

    @Test
    public void getContingentLiabilities() {
        assertNotEquals(0, this.client.getContingentLiabilities().size());
    }

    @Test
    public void getContingentLiabilitiesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getContingentLiabilities(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getContingentLiabilitiesWithParameters() {
        List<String> regions = Arrays.asList("03L", "05L");
        List<String> contingentLiabilities = Arrays.asList("borgen", "p_skuld");
        List<Integer> years = Arrays.asList(2009, 2012);

        assertNotEquals(0, this.client.getContingentLiabilities(regions, contingentLiabilities, years).size());
    }

    @Test
    public void getRevenue() {
        assertNotEquals(0, this.client.getRevenue().size());
    }

    @Test
    public void getRevenueWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getRevenue(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getRevenueWithParameters() {
        List<String> regions = Arrays.asList("03L", "05L");
        List<String> items = Arrays.asList("307", "35-36");
        List<Integer> years = Arrays.asList(2009, 2012);

        assertNotEquals(0, this.client.getRevenue(regions, items, years).size());
    }

    @Test
    public void getCosts() {
        assertNotEquals(0, this.client.getCosts().size());
    }

    @Test
    public void getCostsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getCosts(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getCostsWithParameters() {
        List<String> regions = Arrays.asList("03L", "05L");
        List<String> items = Arrays.asList("558", "5615,5619");
        List<Integer> years = Arrays.asList(2009, 2012);

        assertNotEquals(0, this.client.getCosts(regions, items, years).size());
    }

    @Test
    public void getIncomeStatements() {
        assertNotEquals(0, this.client.getIncomeStatements().size());
    }

    @Test
    public void getIncomeStatementsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getIncomeStatements(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getIncomeStatementsWithParameters() {
        List<String> regions = Arrays.asList("03L", "05L");
        List<String> incomeStatements = Arrays.asList("030", "040");
        List<Integer> years = Arrays.asList(2009, 2012);

        assertNotEquals(0, this.client.getIncomeStatements(regions, incomeStatements, years).size());
    }

    @Test
    public void getBalanceSheet() {
        assertNotEquals(0, this.client.getBalanceSheet().size());
    }

    @Test
    public void getBalanceSheetWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getBalanceSheet(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getBalanceSheetWithParameters() {
        List<String> regions = Arrays.asList("03L", "05L");
        List<String> balanceSheets = Arrays.asList("132", "10-138");
        List<Integer> years = Arrays.asList(2009, 2012);

        assertNotEquals(0, this.client.getBalanceSheet(regions, balanceSheets, years).size());
    }

}
