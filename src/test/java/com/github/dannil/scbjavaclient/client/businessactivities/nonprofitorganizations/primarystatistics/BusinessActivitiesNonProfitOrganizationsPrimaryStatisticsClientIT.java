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

package com.github.dannil.scbjavaclient.client.businessactivities.nonprofitorganizations.primarystatistics;

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
public class BusinessActivitiesNonProfitOrganizationsPrimaryStatisticsClientIT {

    private BusinessActivitiesNonProfitOrganizationsPrimaryStatisticsClient client;

    @BeforeEach
    public void setup() {
        this.client = new BusinessActivitiesNonProfitOrganizationsPrimaryStatisticsClient();
    }

    @Test
    @Date("2017-04-09")
    public void getPresentationOfResults() {
        assertNotEquals(0, this.client.getPresentationOfResults().size());
    }

    @Test
    @Date("2017-04-09")
    public void getPresentationOfResultsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPresentationOfResults(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-09")
    public void getPresentationOfResultsWithParameters() {
        List<String> incomeStatements = Arrays.asList("AvNed", "FinInt");
        List<Integer> years = Arrays.asList(2013, 2014);

        assertNotEquals(0, this.client.getPresentationOfResults(incomeStatements, years).size());
    }

    @Test
    @Date("2017-04-09")
    public void getIncomeAndCostsFromPublicAdministration() {
        assertNotEquals(0, this.client.getIncomeAndCostsFromPublicAdministration().size());
    }

    @Test
    @Date("2017-04-09")
    public void getIncomeAndCostsFromPublicAdministrationWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getIncomeAndCostsFromPublicAdministration(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-09")
    public void getIncomeAndCostsFromPublicAdministrationWithParameters() {
        List<String> incomesAndCosts = Arrays.asList("Int", "Kost");
        List<Integer> years = Arrays.asList(2013, 2014);

        assertNotEquals(0, this.client.getIncomeAndCostsFromPublicAdministration(incomesAndCosts, years).size());
    }

    @Test
    @Date("2017-04-09")
    public void getPresentationOfResultsSwedishChurch() {
        assertNotEquals(0, this.client.getPresentationOfResultsSwedishChurch().size());
    }

    @Test
    @Date("2017-04-09")
    public void getPresentationOfResultsSwedishChurchWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPresentationOfResultsSwedishChurch(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-09")
    public void getPresentationOfResultsSwedishChurchWithParameters() {
        List<String> incomeStatements = Arrays.asList("AvNed", "FinInt");
        List<Integer> years = Arrays.asList(2013, 2014);

        assertNotEquals(0, this.client.getPresentationOfResultsSwedishChurch(incomeStatements, years).size());
    }

    @Test
    @Date("2017-04-09")
    public void getIncomeAndCostsFromOccupationalPension() {
        assertNotEquals(0, this.client.getIncomeAndCostsFromOccupationalPension().size());
    }

    @Test
    @Date("2017-04-09")
    public void getIncomeAndCostsFromOccupationalPensionWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getIncomeAndCostsFromOccupationalPension(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-09")
    public void getIncomeAndCostsFromOccupationalPensionWithParameters() {
        List<String> incomesAndCosts = Arrays.asList("Int", "Kost");
        List<Integer> years = Arrays.asList(2013, 2014);

        assertNotEquals(0, this.client.getIncomeAndCostsFromOccupationalPension(incomesAndCosts, years).size());
    }

}
