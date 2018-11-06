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
public class PublicFinancesAnnualAccountsStatementAccountsMunicipalityClientIT {

    private PublicFinancesAnnualAccountsStatementAccountsMunicipalityClient client;

    @BeforeEach
    public void setup() {
        this.client = new PublicFinancesAnnualAccountsStatementAccountsMunicipalityClient();
    }

    @Test
    @Date("2018-06-28")
    public void getCostsAndIncomes() {
        assertNotEquals(0, this.client.getCostsAndIncomes().size());
    }

    @Test
    @Date("2018-06-28")
    public void getCostsAndIncomesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getCostsAndIncomes(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-17")
    public void getCostsAndIncomesWithParameters() {
        List<String> regions = Arrays.asList("0163", "0180");
        List<Integer> activities = Arrays.asList(600, 610);
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getCostsAndIncomes(regions, activities, years).size());
    }

    @Test
    @Date("2017-04-17")
    public void getPurchaseOfMainActivities() {
        assertNotEquals(0, this.client.getPurchaseOfMainActivities().size());
    }

    @Test
    @Date("2017-04-17")
    public void getPurchaseOfMainActivitiesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPurchaseOfMainActivities(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-17")
    public void getPurchaseOfMainActivitiesWithParameters() {
        List<String> regions = Arrays.asList("0163", "0180");
        List<Integer> activities = Arrays.asList(600, 610);
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getPurchaseOfMainActivities(regions, activities, years).size());
    }

    @Test
    @Date("2018-09-02")
    public void getCostsOfIndividualAndFamilyCare() {
        assertNotEquals(0, this.client.getCostsOfIndividualAndFamilyCare().size());
    }

    @Test
    @Date("2018-09-02")
    public void getCostsOfIndividualAndFamilyCareWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getCostsOfIndividualAndFamilyCare(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-09-02")
    public void getCostsOfIndividualAndFamilyCareWithParameters() {
        List<String> regions = Arrays.asList("0163", "0180");
        List<Integer> cares = Arrays.asList(600, 610);
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getCostsOfIndividualAndFamilyCare(regions, cares, years).size());
    }

    @Test
    @Date("2017-04-17")
    public void getGrants() {
        assertNotEquals(0, this.client.getGrants().size());
    }

    @Test
    @Date("2017-04-17")
    public void getGrantsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getGrants(Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-17")
    public void getGrantsWithParameters() {
        List<String> regions = Arrays.asList("0163", "0180");
        List<Integer> activities = Arrays.asList(600, 610);
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getGrants(regions, activities, years).size());
    }

    @Test
    @Date("2017-04-17")
    public void getSomeIncomes() {
        assertNotEquals(0, this.client.getSomeIncomes().size());
    }

    @Test
    @Date("2017-04-17")
    public void getSomeIncomesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getSomeIncomes(Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-17")
    public void getSomeIncomesWithParameters() {
        List<String> regions = Arrays.asList("0163", "0180");
        List<Integer> activities = Arrays.asList(600, 610);
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getSomeIncomes(regions, activities, years).size());
    }

}
