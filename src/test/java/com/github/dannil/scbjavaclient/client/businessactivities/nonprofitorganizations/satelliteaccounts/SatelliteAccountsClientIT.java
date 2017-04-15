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

package com.github.dannil.scbjavaclient.client.businessactivities.nonprofitorganizations.satelliteaccounts;

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
public class SatelliteAccountsClientIT extends RemoteIntegrationTestSuite {

    private SatelliteAccountsClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().businessActivities().nonProfitOrganizations().satelliteAccounts();
    }

    @Test
    public void getIncomeExpenditureAndSavings() {
        assertNotEquals(0, this.client.getIncomeExpenditureAndSavings().size());
    }

    @Test
    public void getIncomeExpenditureAndSavingsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getIncomeExpenditureAndSavings(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getIncomeExpenditureAndSavingsWithParameters() {
        List<String> icnpo = Arrays.asList("02", "06");
        List<String> transactionItems = Arrays.asList("D42.PAY", "B6n");
        List<Integer> years = Arrays.asList(2012, 2014);

        assertNotEquals(0, this.client.getIncomeExpenditureAndSavings(icnpo, transactionItems, years).size());
    }

    @Test
    public void getNumberOfOrganizationsAndEmployment() {
        assertNotEquals(0, this.client.getNumberOfOrganizationsAndEmployment().size());
    }

    @Test
    public void getNumberOfOrganizationsAndEmploymentWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNumberOfOrganizationsAndEmployment(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getNumberOfOrganizationsAndEmploymentWithParameters() {
        List<String> incomesAndCosts = Arrays.asList("07", "10");
        List<Integer> years = Arrays.asList(2013, 2014);

        assertNotEquals(0, this.client.getNumberOfOrganizationsAndEmployment(incomesAndCosts, years).size());
    }

}
