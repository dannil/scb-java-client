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

package com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.directinvestments;

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
public class FinancialMarketsBalanceOfPaymentsDirectInvestmentsClientIT {

    private FinancialMarketsBalanceOfPaymentsDirectInvestmentsClient client;

    @BeforeEach
    public void setup() {
        this.client = new FinancialMarketsBalanceOfPaymentsDirectInvestmentsClient();
    }

    @Test
    @Date("2017-06-13")
    public void getDirectInvestmentsByEconomicActivityNACE2007() {
        assertNotEquals(0, this.client.getDirectInvestmentsByEconomicActivityNACE2007().size());
    }

    @Test
    @Date("2017-06-13")
    public void getDirectInvestmentsByEconomicActivityNACE2007WithParametersEmptyLists() {
        assertNotEquals(0, this.client.getDirectInvestmentsByEconomicActivityNACE2007(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-13")
    public void getDirectInvestmentsByEconomicActivityNACE2007WithParameters() {
        List<String> industrialClassifications = Arrays.asList("35-39", "ÅVM");
        List<Integer> years = Arrays.asList(2012, 2013);

        assertNotEquals(0,
                this.client.getDirectInvestmentsByEconomicActivityNACE2007(industrialClassifications, years).size());
    }

    @Test
    @Date("2017-06-13")
    public void getDirectInvestmentsByCountryYears() {
        assertNotEquals(0, this.client.getDirectInvestmentsByCountryYears().size());
    }

    @Test
    @Date("2017-06-13")
    public void getDirectInvestmentsByCountryYearsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getDirectInvestmentsByCountryYears(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-13")
    public void getDirectInvestmentsByCountryYearsWithParameters() {
        List<String> countries = Arrays.asList("IT", "LU");
        List<Integer> years = Arrays.asList(2012, 2013);

        assertNotEquals(0, this.client.getDirectInvestmentsByCountryYears(countries, years).size());
    }

    @Test
    @Date("2017-06-13")
    public void getDirectInvestmentsByEconomicActivityNACE2002() {
        assertNotEquals(0, this.client.getDirectInvestmentsByEconomicActivityNACE2002().size());
    }

    @Test
    @Date("2017-06-13")
    public void getDirectInvestmentsByEconomicActivityNACE2002WithParametersEmptyLists() {
        assertNotEquals(0, this.client.getDirectInvestmentsByEconomicActivityNACE2002(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-13")
    public void getDirectInvestmentsByEconomicActivityNACE2002WithParameters() {
        List<String> industrialClassifications = Arrays.asList("15+16", "74.11+74.12-74.14mfl");
        List<Integer> years = Arrays.asList(2006, 2007);

        assertNotEquals(0,
                this.client.getDirectInvestmentsByEconomicActivityNACE2002(industrialClassifications, years).size());
    }

    @Test
    @Date("2017-06-13")
    public void getDirectInvestmentsByInvestmentItem() {
        assertNotEquals(0, this.client.getDirectInvestmentsByInvestmentItem().size());
    }

    @Test
    @Date("2017-06-13")
    public void getDirectInvestmentsByInvestmentItemWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getDirectInvestmentsByInvestmentItem(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-13")
    public void getDirectInvestmentsByInvestmentItemWithParameters() {
        List<String> investments = Arrays.asList("020", "030");
        List<String> quarters = Arrays.asList("2007K2", "2007K3");

        assertNotEquals(0, this.client.getDirectInvestmentsByInvestmentItem(investments, quarters).size());
    }

    @Test
    @Date("2017-06-13")
    public void getDirectInvestmentsByCountryQuarters() {
        assertNotEquals(0, this.client.getDirectInvestmentsByCountryQuarters().size());
    }

    @Test
    @Date("2017-06-13")
    public void getDirectInvestmentsByCountryQuartersWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getDirectInvestmentsByCountryQuarters(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-13")
    public void getDirectInvestmentsByCountryQuartersWithParameters() {
        List<String> countries = Arrays.asList("IT", "LU");
        List<String> quarters = Arrays.asList("2008K1", "2008K2");

        assertNotEquals(0, this.client.getDirectInvestmentsByCountryQuarters(countries, quarters).size());
    }

}
