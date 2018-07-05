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

package com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.internationalinvestmentposition;

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
public class FinancialMarketsBalanceOfPaymentsInternationalInvestmentPositionClientIT {

    private FinancialMarketsBalanceOfPaymentsInternationalInvestmentPositionClient client;

    @BeforeEach
    public void setup() {
        this.client = new FinancialMarketsBalanceOfPaymentsInternationalInvestmentPositionClient();
    }

    @Test
    @Date("2017-06-13")
    public void getRevisions() {
        assertNotEquals(0, this.client.getRevisions().size());
    }

    @Test
    @Date("2017-06-13")
    public void getRevisionsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getRevisions(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-13")
    public void getRevisionsWithParameters() {
        List<String> assetsAndLiabilities = Arrays.asList("X1", "X2");
        List<String> items = Arrays.asList("I2", "I4");
        List<String> quarters = Arrays.asList("2016K2", "2016K3");

        assertNotEquals(0, this.client.getRevisions(assetsAndLiabilities, items, quarters).size());
    }

    @Test
    @Date("2017-06-13")
    public void getAssetsAndLiabilitiesBySectorsQuarters() {
        assertNotEquals(0, this.client.getAssetsAndLiabilitiesBySectorsQuarters().size());
    }

    @Test
    @Date("2017-06-13")
    public void getAssetsAndLiabilitiesBySectorsQuartersWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getAssetsAndLiabilitiesBySectorsQuarters(Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-13")
    public void getAssetsAndLiabilitiesBySectorsQuartersWithParameters() {
        List<String> assetsAndLiabilities = Arrays.asList("X1", "X2");
        List<Integer> sectors = Arrays.asList(3, 5);
        List<String> items = Arrays.asList("J2.2.1.1", "J2.2.1.2");
        List<String> quarters = Arrays.asList("2013K1", "2013K2");

        assertNotEquals(0, this.client.getAssetsAndLiabilitiesBySectorsQuarters(assetsAndLiabilities, sectors, items,
                quarters).size());
    }

    @Test
    @Date("2017-06-13")
    public void getAssetsAndLiabilitiesByCurrenciesYears() {
        assertNotEquals(0, this.client.getAssetsAndLiabilitiesByCurrenciesYears().size());
    }

    @Test
    @Date("2017-06-13")
    public void getAssetsAndLiabilitiesByCurrenciesYearsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getAssetsAndLiabilitiesByCurrenciesYears(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-13")
    public void getAssetsAndLiabilitiesByCurrenciesYearsWithParameters() {
        List<String> assetsAndLiabilities = Arrays.asList("X1", "X2");
        List<String> currencies = Arrays.asList("v0", "v1");
        List<String> items = Arrays.asList("I4.1", "I4.2");
        List<Integer> years = Arrays.asList(2002, 2003);

        assertNotEquals(0, this.client.getAssetsAndLiabilitiesByCurrenciesYears(assetsAndLiabilities, currencies, items,
                years).size());
    }

    @Test
    @Date("2017-06-13")
    public void getGrossExternalDebt() {
        assertNotEquals(0, this.client.getGrossExternalDebt().size());
    }

    @Test
    @Date("2017-06-13")
    public void getGrossExternalDebtWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getGrossExternalDebt(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-13")
    public void getGrossExternalDebtWithParameters() {
        List<String> items = Arrays.asList("R2.1.3", "R2.1.5");
        List<String> quarters = Arrays.asList("2016K2", "2016K3");

        assertNotEquals(0, this.client.getGrossExternalDebt(items, quarters).size());
    }

    @Test
    @Date("2017-06-13")
    public void getAssetsAndLiabilitiesBySectorsYears() {
        assertNotEquals(0, this.client.getAssetsAndLiabilitiesBySectorsYears().size());
    }

    @Test
    @Date("2017-06-13")
    public void getAssetsAndLiabilitiesBySectorsYearsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getAssetsAndLiabilitiesBySectorsYears(Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-13")
    public void getAssetsAndLiabilitiesBySectorsYearsWithParameters() {
        List<String> assetsAndLiabilities = Arrays.asList("X1", "X2");
        List<Integer> sectors = Arrays.asList(3, 5);
        List<String> items = Arrays.asList("J2.2.1.1", "J2.2.1.2");
        List<Integer> years = Arrays.asList(2008, 2009);

        assertNotEquals(0,
                this.client.getAssetsAndLiabilitiesBySectorsYears(assetsAndLiabilities, sectors, items, years).size());
    }

    @Test
    @Date("2017-06-13")
    public void getAssetsAndLiabilitiesWithDirectInvestments() {
        assertNotEquals(0, this.client.getAssetsAndLiabilitiesWithDirectInvestments().size());
    }

    @Test
    @Date("2017-06-13")
    public void getAssetsAndLiabilitiesWithDirectInvestmentsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getAssetsAndLiabilitiesWithDirectInvestments(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-13")
    public void getAssetsAndLiabilitiesWithDirectInvestmentsWithParameters() {
        List<String> assetsAndLiabilities = Arrays.asList("X1", "X2");
        List<String> currencies = Arrays.asList("v0", "v1");
        List<String> items = Arrays.asList("K2.1", "K2.2");
        List<Integer> years = Arrays.asList(2002, 2003);

        assertNotEquals(0, this.client.getAssetsAndLiabilitiesWithDirectInvestments(assetsAndLiabilities, currencies,
                items, years).size());
    }

    @Test
    @Date("2017-06-13")
    public void getAssetsAndLiabilitiesByCurrenciesQuarters() {
        assertNotEquals(0, this.client.getAssetsAndLiabilitiesByCurrenciesQuarters().size());
    }

    @Test
    @Date("2017-06-13")
    public void getAssetsAndLiabilitiesByCurrenciesQuartersWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getAssetsAndLiabilitiesByCurrenciesQuarters(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-13")
    public void getAssetsAndLiabilitiesByCurrenciesQuartersWithParameters() {
        List<String> assetsAndLiabilities = Arrays.asList("X1", "X2");
        List<String> currencies = Arrays.asList("v0", "v1");
        List<String> items = Arrays.asList("I4.1", "I4.2");
        List<String> quarters = Arrays.asList("2012K2", "2012K3");

        assertNotEquals(0, this.client.getAssetsAndLiabilitiesByCurrenciesQuarters(assetsAndLiabilities, currencies,
                items, quarters).size());
    }

}
