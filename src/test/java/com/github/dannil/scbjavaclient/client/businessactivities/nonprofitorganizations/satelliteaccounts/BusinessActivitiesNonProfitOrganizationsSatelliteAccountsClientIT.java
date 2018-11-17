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
public class BusinessActivitiesNonProfitOrganizationsSatelliteAccountsClientIT {

    private BusinessActivitiesNonProfitOrganizationsSatelliteAccountsClient client;

    @BeforeEach
    public void setup() {
        this.client = new BusinessActivitiesNonProfitOrganizationsSatelliteAccountsClient();
    }

    @Test
    @Date("2017-04-09")
    public void getIncomeExpenditureAndSavings() {
        assertNotEquals(0, this.client.getIncomeExpenditureAndSavings().size());
    }

    @Test
    @Date("2017-04-09")
    public void getIncomeExpenditureAndSavingsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getIncomeExpenditureAndSavings(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-09")
    public void getIncomeExpenditureAndSavingsWithParameters() {
        List<String> icnpo = Arrays.asList("02", "06");
        List<String> transactionItems = Arrays.asList("D42.PAY", "B6n");
        List<Integer> years = Arrays.asList(2012, 2014);

        assertNotEquals(0, this.client.getIncomeExpenditureAndSavings(icnpo, transactionItems, years).size());
    }

    @Test
    @Date("2017-04-09")
    public void getNumberOfOrganizationsAndEmployment() {
        assertNotEquals(0, this.client.getNumberOfOrganizationsAndEmployment().size());
    }

    @Test
    @Date("2017-04-09")
    public void getNumberOfOrganizationsAndEmploymentWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNumberOfOrganizationsAndEmployment(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-09")
    public void getNumberOfOrganizationsAndEmploymentWithParameters() {
        List<String> incomesAndCosts = Arrays.asList("07", "10");
        List<Integer> years = Arrays.asList(2013, 2014);

        assertNotEquals(0, this.client.getNumberOfOrganizationsAndEmployment(incomesAndCosts, years).size());
    }

}
