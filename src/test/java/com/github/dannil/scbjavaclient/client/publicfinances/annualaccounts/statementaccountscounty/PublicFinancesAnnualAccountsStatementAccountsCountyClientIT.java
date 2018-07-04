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

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
@Remote
public class PublicFinancesAnnualAccountsStatementAccountsCountyClientIT {

    private PublicFinancesAnnualAccountsStatementAccountsCountyClient client;

    @BeforeEach
    public void setup() {
        this.client = new PublicFinancesAnnualAccountsStatementAccountsCountyClient();
    }

    @Test
    @Date("2017-04-17")
    public void getExpensesAndRevenues() {
        assertNotEquals(0, this.client.getExpensesAndRevenues().size());
    }

    @Test
    @Date("2017-04-17")
    public void getExpensesAndRevenuesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getExpensesAndRevenues(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-17")
    public void getExpensesAndRevenuesWithParameters() {
        List<String> regions = Arrays.asList("03L", "05L");
        List<String> activities = Arrays.asList("440", "0-4");
        List<Integer> years = Arrays.asList(2009, 2012);

        assertNotEquals(0, this.client.getExpensesAndRevenues(regions, activities, years).size());
    }

    @Test
    @Date("2017-04-17")
    public void getNetCosts() {
        assertNotEquals(0, this.client.getNetCosts().size());
    }

    @Test
    @Date("2017-04-17")
    public void getNetCostsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNetCosts(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-17")
    public void getNetCostsWithParameters() {
        List<String> regions = Arrays.asList("03L", "05L");
        List<String> activities = Arrays.asList("310", "0-4");
        List<Integer> years = Arrays.asList(2009, 2012);

        assertNotEquals(0, this.client.getNetCosts(regions, activities, years).size());
    }

    @Test
    @Date("2017-04-17")
    public void getPurchasesAndSales() {
        assertNotEquals(0, this.client.getPurchasesAndSales().size());
    }

    @Test
    @Date("2017-04-17")
    public void getPurchasesAndSalesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPurchasesAndSales(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-17")
    public void getPurchasesAndSalesWithParameters() {
        List<String> regions = Arrays.asList("03L", "05L");
        List<String> activities = Arrays.asList("430", "440");
        List<Integer> years = Arrays.asList(2013, 2014);

        assertNotEquals(0, this.client.getPurchasesAndSales(regions, activities, years).size());
    }

    @Test
    @Date("2017-04-17")
    public void getContributions() {
        assertNotEquals(0, this.client.getContributions().size());
    }

    @Test
    @Date("2017-04-17")
    public void getContributionsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getContributions(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-17")
    public void getContributionsWithParameters() {
        List<String> regions = Arrays.asList("03L", "05L");
        List<String> activities = Arrays.asList("5", "5-8");
        List<Integer> years = Arrays.asList(2013, 2014);

        assertNotEquals(0, this.client.getContributions(regions, activities, years).size());
    }

    @Test
    @Date("2018-06-28")
    public void getIncomeAndCosts() {
        assertNotEquals(0, this.client.getIncomeAndCosts().size());
    }

    @Test
    @Date("2018-06-28")
    public void getIncomeAndCostsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getIncomeAndCosts(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-17")
    public void getIncomeAndCostsWithParameters() {
        List<String> regions = Arrays.asList("03L", "05L");
        List<String> activities = Arrays.asList("710", "710_1");
        List<Integer> years = Arrays.asList(2013, 2014);

        assertNotEquals(0, this.client.getIncomeAndCosts(regions, activities, years).size());
    }

    @Test
    @Date("2017-04-17")
    public void getInvestments() {
        assertNotEquals(0, this.client.getInvestments().size());
    }

    @Test
    @Date("2017-04-17")
    public void getInvestmentsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getInvestments(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-17")
    public void getInvestmentsWithParameters() {
        List<String> regions = Arrays.asList("03L", "05L");
        List<String> activities = Arrays.asList("430", "440");
        List<Integer> years = Arrays.asList(2013, 2014);

        assertNotEquals(0, this.client.getInvestments(regions, activities, years).size());
    }

}
