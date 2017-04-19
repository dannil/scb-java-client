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

package com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.statementaccountsmunicipality;

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
public class PublicFinancesAnnualAccountsStatementAccountsMunicipalityClientIT extends RemoteIntegrationTestSuite {

    private PublicFinancesAnnualAccountsStatementAccountsMunicipalityClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().publicFinances().annualAccounts().statementAccountsMunicipality();
    }

    // Daniel 2017-04-17: Returns HTTP 403
    //
    // @Test
    // public void getCostsAndIncomes() {
    // assertNotEquals(0, this.client.getCostsAndIncomes().size());
    // }

    // Daniel 2017-04-17: Returns HTTP 403
    //
    // @Test
    // public void getCostsAndIncomesWithParametersEmptyLists() {
    // assertNotEquals(0, this.client.getCostsAndIncomes(Collections.<String>emptyList(),
    // Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    // }

    @Test
    public void getCostsAndIncomesWithParameters() {
        List<String> regions = Arrays.asList("0163", "0180");
        List<Integer> activities = Arrays.asList(600, 610);
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getCostsAndIncomes(regions, activities, years).size());
    }

    @Test
    public void getPurchaseOfMainActivities() {
        assertNotEquals(0, this.client.getPurchaseOfMainActivities().size());
    }

    @Test
    public void getPurchaseOfMainActivitiesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPurchaseOfMainActivities(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getPurchaseOfMainActivitiesWithParameters() {
        List<String> regions = Arrays.asList("0163", "0180");
        List<Integer> activities = Arrays.asList(600, 610);
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getPurchaseOfMainActivities(regions, activities, years).size());
    }

    @Test
    public void getCostsOfIndividualAndFamilyCare() {
        assertNotEquals(0, this.client.getCostsOfIndividualAndFamilyCare().size());
    }

    @Test
    public void getCostsOfIndividualAndFamilyCareWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getCostsOfIndividualAndFamilyCare(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getCostsOfIndividualAndFamilyCareWithParameters() {
        List<String> regions = Arrays.asList("0163", "0180");
        List<Integer> cares = Arrays.asList(600, 610);
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getCostsOfIndividualAndFamilyCare(regions, cares, years).size());
    }

    @Test
    public void getGrants() {
        assertNotEquals(0, this.client.getGrants().size());
    }

    @Test
    public void getGrantsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getGrants(Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getGrantsWithParameters() {
        List<String> regions = Arrays.asList("0163", "0180");
        List<Integer> activities = Arrays.asList(600, 610);
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getGrants(regions, activities, years).size());
    }

    @Test
    public void getSomeIncomes() {
        assertNotEquals(0, this.client.getSomeIncomes().size());
    }

    @Test
    public void getSomeIncomesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getSomeIncomes(Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getSomeIncomesWithParameters() {
        List<String> regions = Arrays.asList("0163", "0180");
        List<Integer> activities = Arrays.asList(600, 610);
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getSomeIncomes(regions, activities, years).size());
    }

}
