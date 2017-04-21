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

package com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.balancesheetmunicipality;

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
public class PublicFinancesAnnualAccountsBalanceSheetMunicipalityClientIT extends RemoteIntegrationTestSuite {

    private PublicFinancesAnnualAccountsBalanceSheetMunicipalityClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().publicFinances().annualAccounts().balanceSheetMunicipality();
    }

    // Daniel 2017-04-17: Returns HTTP 403
    //
    // @Test
    // public void getIncomeStatements() {
    // assertNotEquals(0, this.client.getIncomeStatements().size());
    // }

    // Daniel 2017-04-17: Returns HTTP 403
    //
    // @Test
    // public void getIncomeStatementsWithParametersEmptyLists() {
    // assertNotEquals(0, this.client.getIncomeStatements(Collections.<String>emptyList(),
    // Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    // }

    @Test
    public void getIncomeStatementsWithParameters() {
        List<String> regions = Arrays.asList("0125", "0160");
        List<String> incomeStatements = Arrays.asList("030", "040");
        List<Integer> years = Arrays.asList(2009, 2012);

        assertNotEquals(0, this.client.getIncomeStatements(regions, incomeStatements, years).size());
    }

    // Daniel 2017-04-17: Returns HTTP 403
    //
    // @Test
    // public void getBalanceSheet() {
    // assertNotEquals(0, this.client.getBalanceSheet().size());
    // }

    // Daniel 2017-04-17: Returns HTTP 403
    //
    // @Test
    // public void getBalanceSheetWithParametersEmptyLists() {
    // assertNotEquals(0, this.client.getBalanceSheet(Collections.<String>emptyList(),
    // Collections.<String>emptyList(),
    // Collections.<Integer>emptyList()).size());
    // }

    @Test
    public void getBalanceSheetWithParameters() {
        List<String> regions = Arrays.asList("0125", "0160");
        List<String> balanceSheets = Arrays.asList("098", "091");
        List<Integer> years = Arrays.asList(2009, 2012);

        assertNotEquals(0, this.client.getBalanceSheet(regions, balanceSheets, years).size());
    }

    @Test
    public void getGuaranteesAndContingentLiabilities() {
        assertNotEquals(0, this.client.getGuaranteesAndContingentLiabilities().size());
    }

    @Test
    public void getGuaranteesAndContingentLiabilitiesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getGuaranteesAndContingentLiabilities(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getGuaranteesAndContingentLiabilitiesWithParameters() {
        List<String> regions = Arrays.asList("0125", "0160");
        List<Integer> typesOfGuarantees = Arrays.asList(110, 121);
        List<Integer> years = Arrays.asList(2009, 2012);

        assertNotEquals(0, this.client.getGuaranteesAndContingentLiabilities(regions, typesOfGuarantees, years).size());
    }

    @Test
    public void getLocalGovernmentIncomes() {
        assertNotEquals(0, this.client.getLocalGovernmentIncomes().size());
    }

    @Test
    public void getLocalGovernmentIncomesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getLocalGovernmentIncomes(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getLocalGovernmentIncomesWithParameters() {
        List<String> regions = Arrays.asList("0125", "0160");
        List<Integer> items = Arrays.asList(400, 490);
        List<Integer> years = Arrays.asList(2011, 2012);

        assertNotEquals(0, this.client.getLocalGovernmentIncomes(regions, items, years).size());
    }

    @Test
    public void getMunicipalitiesCosts() {
        assertNotEquals(0, this.client.getMunicipalitiesCosts().size());
    }

    @Test
    public void getMunicipalitiesCostsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getMunicipalitiesCosts(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getMunicipalitiesCostsWithParameters() {
        List<String> regions = Arrays.asList("0125", "0160");
        List<Integer> items = Arrays.asList(410, 411);
        List<Integer> years = Arrays.asList(2011, 2012);

        assertNotEquals(0, this.client.getMunicipalitiesCosts(regions, items, years).size());
    }

}
