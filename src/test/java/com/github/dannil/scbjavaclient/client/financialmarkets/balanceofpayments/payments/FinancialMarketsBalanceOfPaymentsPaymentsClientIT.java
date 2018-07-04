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

package com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.payments;

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
public class FinancialMarketsBalanceOfPaymentsPaymentsClientIT {

    private FinancialMarketsBalanceOfPaymentsPaymentsClient client;

    @BeforeEach
    public void setup() {
        this.client = new FinancialMarketsBalanceOfPaymentsPaymentsClient();
    }

    @Test
    @Date("2017-06-12")
    public void getTransactionsQuarters() {
        assertNotEquals(0, this.client.getTransactionsQuarters().size());
    }

    @Test
    @Date("2017-06-12")
    public void getTransactionsQuartersWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTransactionsQuarters(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-12")
    public void getTransactionsQuartersWithParameters() {
        List<String> items = Arrays.asList("A1.1.1", "A1.1.2");
        List<String> quarters = Arrays.asList("1999K1", "1999K2");

        assertNotEquals(0, this.client.getTransactionsQuarters(items, quarters).size());
    }

    @Test
    @Date("2017-06-12")
    public void getSeasonallyAdjustedCurrentAccountAndCapitalAccount() {
        assertNotEquals(0, this.client.getSeasonallyAdjustedCurrentAccountAndCapitalAccount().size());
    }

    @Test
    @Date("2017-06-12")
    public void getSeasonallyAdjustedCurrentAccountAndCapitalAccountWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getSeasonallyAdjustedCurrentAccountAndCapitalAccount(Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-12")
    public void getSeasonallyAdjustedCurrentAccountAndCapitalAccountWithParameters() {
        List<String> items = Arrays.asList("S1.1.1", "S1.1.2");
        List<String> quarters = Arrays.asList("2015K1", "2016K2");

        assertNotEquals(0, this.client.getSeasonallyAdjustedCurrentAccountAndCapitalAccount(items, quarters).size());
    }

    @Test
    @Date("2017-06-12")
    public void getCurrentAccountsQuarters() {
        assertNotEquals(0, this.client.getCurrentAccountsQuarters().size());
    }

    @Test
    @Date("2017-06-12")
    public void getCurrentAccountsQuartersWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getCurrentAccountsQuarters(Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-12")
    public void getCurrentAccountsQuartersWithParameters() {
        List<String> countryGroups = Arrays.asList("B5", "D5");
        List<String> exportsAndImports = Arrays.asList("X1", "X2");
        List<String> items = Arrays.asList("B2.1", "B2.2");
        List<String> quarters = Arrays.asList("2005K3", "2005K4");

        assertNotEquals(0,
                this.client.getCurrentAccountsQuarters(countryGroups, exportsAndImports, items, quarters).size());
    }

    @Test
    @Date("2017-06-12")
    public void getFinancialAccountsQuarters() {
        assertNotEquals(0, this.client.getFinancialAccountsQuarters().size());
    }

    @Test
    @Date("2017-06-12")
    public void getFinancialAccountsQuartersWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getFinancialAccountsQuarters(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-12")
    public void getFinancialAccountsQuartersWithParameters() {
        List<String> typesOfInvestments = Arrays.asList("X1", "X2");
        List<String> items = Arrays.asList("G2.1", "G2.2");
        List<String> quarters = Arrays.asList("2005K3", "2005K4");

        assertNotEquals(0, this.client.getFinancialAccountsQuarters(typesOfInvestments, items, quarters).size());
    }

    @Test
    @Date("2017-06-12")
    public void getSecondaryIncomeAndCapitalAccounts() {
        assertNotEquals(0, this.client.getSecondaryIncomeAndCapitalAccounts().size());
    }

    @Test
    @Date("2017-06-12")
    public void getSecondaryIncomeAndCapitalAccountsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getSecondaryIncomeAndCapitalAccounts(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-12")
    public void getSecondaryIncomeAndCapitalAccountsWithParameters() {
        List<String> transactions = Arrays.asList("X1", "X2");
        List<String> items = Arrays.asList("F1", "F2");
        List<String> quarters = Arrays.asList("2005K3", "2005K4");

        assertNotEquals(0, this.client.getSecondaryIncomeAndCapitalAccounts(transactions, items, quarters).size());
    }

    @Test
    @Date("2017-06-12")
    public void getTransactionsYears() {
        assertNotEquals(0, this.client.getTransactionsYears().size());
    }

    @Test
    @Date("2017-06-12")
    public void getTransactionsYearsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTransactionsYears(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-12")
    public void getTransactionsYearsWithParameters() {
        List<String> items = Arrays.asList("A1.1.1", "A1.1.2");
        List<Integer> years = Arrays.asList(2006, 2007);

        assertNotEquals(0, this.client.getTransactionsYears(items, years).size());
    }

    @Test
    @Date("2017-06-12")
    public void getRevisions() {
        assertNotEquals(0, this.client.getRevisions().size());
    }

    @Test
    @Date("2017-06-12")
    public void getRevisionsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getRevisions(Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-12")
    public void getRevisionsWithParameters() {
        List<String> items = Arrays.asList("H3", "H4");
        List<String> quarters = Arrays.asList("2016K1", "2016K2");

        assertNotEquals(0, this.client.getRevisions(items, quarters).size());
    }

    @Test
    @Date("2017-06-12")
    public void getCurrentAccountsYears() {
        assertNotEquals(0, this.client.getCurrentAccountsYears().size());
    }

    @Test
    @Date("2017-06-12")
    public void getCurrentAccountsYearsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getCurrentAccountsYears(Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-12")
    public void getCurrentAccountsYearsWithParameters() {
        List<String> countryGroups = Arrays.asList("B5", "D5");
        List<String> exportsAndImports = Arrays.asList("X1", "X2");
        List<String> items = Arrays.asList("B2.1", "B2.2");
        List<Integer> years = Arrays.asList(2002, 2003);

        assertNotEquals(0, this.client.getCurrentAccountsYears(countryGroups, exportsAndImports, items, years).size());
    }

    @Test
    @Date("2017-06-12")
    public void getFinancialAccountsYears() {
        assertNotEquals(0, this.client.getFinancialAccountsYears().size());
    }

    @Test
    @Date("2017-06-12")
    public void getFinancialAccountsYearsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getFinancialAccountsYears(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-12")
    public void getFinancialAccountsYearsWithParameters() {
        List<String> typesOfInvestments = Arrays.asList("X1", "X2");
        List<String> items = Arrays.asList("G2.1", "G2.2");
        List<Integer> years = Arrays.asList(2002, 2003);

        assertNotEquals(0, this.client.getFinancialAccountsYears(typesOfInvestments, items, years).size());
    }

    @Test
    @Date("2017-06-12")
    public void getPrimaryIncome() {
        assertNotEquals(0, this.client.getPrimaryIncome().size());
    }

    @Test
    @Date("2017-06-12")
    public void getPrimaryIncomeWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPrimaryIncome(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-12")
    public void getPrimaryIncomeWithParameters() {
        List<String> exportsAndImports = Arrays.asList("X1", "X2");
        List<String> items = Arrays.asList("E2.2.1", "E2.2.2");
        List<String> quarters = Arrays.asList("2005K4", "2006K2");

        assertNotEquals(0, this.client.getPrimaryIncome(exportsAndImports, items, quarters).size());
    }

}
