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

package com.github.dannil.scbjavaclient.client.publicfinances.publiclyownedenterprises;

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
public class PublicFinancesPubliclyOwnedEnterprisesClientIT {

    private PublicFinancesPubliclyOwnedEnterprisesClient client;

    @BeforeEach
    public void setup() {
        this.client = new PublicFinancesPubliclyOwnedEnterprisesClient();
    }

    @Test
    @Date("2017-04-16")
    public void getDataForMunicipalityOwnedEnterprises() {
        assertNotEquals(0, this.client.getDataForMunicipalityOwnedEnterprises().size());
    }

    @Test
    @Date("2017-04-16")
    public void getDataForMunicipalityOwnedEnterprisesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getDataForMunicipalityOwnedEnterprises(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-16")
    public void getDataForMunicipalityOwnedEnterprisesWithParameters() {
        List<String> regions = Arrays.asList("0182", "0305");
        List<Integer> years = Arrays.asList(2015);

        assertNotEquals(0, this.client.getDataForMunicipalityOwnedEnterprises(regions, years).size());
    }

    @Test
    @Date("2017-04-16")
    public void getEnterprises() {
        assertNotEquals(0, this.client.getEnterprises().size());
    }

    @Test
    @Date("2017-04-16")
    public void getEnterprisesWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getEnterprises(Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-16")
    public void getEnterprisesWithParameters() {
        List<String> regions = Arrays.asList("0182", "0305");
        List<Integer> years = Arrays.asList(2015);

        assertNotEquals(0, this.client.getEnterprises(regions, years).size());
    }

    @Test
    @Date("2017-04-16")
    public void getCountyCouncilsEnterprises() {
        assertNotEquals(0, this.client.getCountyCouncilsEnterprises().size());
    }

    @Test
    @Date("2017-04-16")
    public void getCountyCouncilsEnterprisesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getCountyCouncilsEnterprises(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-16")
    public void getCountyCouncilsEnterprisesWithParameters() {
        List<String> regions = Arrays.asList("17", "19");
        List<String> sectors = Arrays.asList("samtliga");
        List<Integer> years = Arrays.asList(2015);

        assertNotEquals(0, this.client.getCountyCouncilsEnterprises(regions, sectors, years).size());
    }

    @Test
    @Date("2017-04-16")
    public void getPubliclyOwnedEnterprises() {
        assertNotEquals(0, this.client.getPubliclyOwnedEnterprises().size());
    }

    @Test
    @Date("2017-04-16")
    public void getPubliclyOwnedEnterprisesWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getPubliclyOwnedEnterprises(Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-16")
    public void getPubliclyOwnedEnterprisesWithParameters() {
        List<String> sectors = Arrays.asList("samtliga");
        List<Integer> typesOfOwnerships = Arrays.asList(60, 65);
        List<Integer> legalEntities = Arrays.asList(20, 40);
        List<Integer> years = Arrays.asList(2015);

        assertNotEquals(0,
                this.client.getPubliclyOwnedEnterprises(sectors, typesOfOwnerships, legalEntities, years).size());
    }

    @Test
    @Date("2017-04-16")
    public void getIncomeStatements() {
        assertNotEquals(0, this.client.getIncomeStatements().size());
    }

    @Test
    @Date("2017-04-16")
    public void getIncomeStatementsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getIncomeStatements(Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-16")
    public void getIncomeStatementsWithParameters() {
        List<String> sectors = Arrays.asList("samtliga");
        List<Integer> typesOfOwnerships = Arrays.asList(60, 65);
        List<String> industrialClassifications = Arrays.asList("B+C", "D+E");
        List<Integer> years = Arrays.asList(2015);

        assertNotEquals(0,
                this.client.getIncomeStatements(sectors, typesOfOwnerships, industrialClassifications, years).size());
    }

    @Test
    @Date("2017-04-16")
    public void getLiabilitiesAndEquity() {
        assertNotEquals(0, this.client.getLiabilitiesAndEquity().size());
    }

    @Test
    @Date("2017-04-16")
    public void getLiabilitiesAndEquityWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getLiabilitiesAndEquity(Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-16")
    public void getLiabilitiesAndEquityWithParameters() {
        List<String> sectors = Arrays.asList("samtliga");
        List<Integer> typesOfOwnerships = Arrays.asList(60, 65);
        List<String> industrialClassifications = Arrays.asList("B+C", "D+E");
        List<Integer> years = Arrays.asList(2015);

        assertNotEquals(0, this.client.getLiabilitiesAndEquity(sectors, typesOfOwnerships, industrialClassifications,
                years).size());
    }

    @Test
    @Date("2017-04-16")
    public void getAssets() {
        assertNotEquals(0, this.client.getAssets().size());
    }

    @Test
    @Date("2017-04-16")
    public void getAssetsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getAssets(Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-16")
    public void getAssetsWithParameters() {
        List<String> sectors = Arrays.asList("samtliga");
        List<Integer> typesOfOwnerships = Arrays.asList(60, 65);
        List<String> industrialClassifications = Arrays.asList("B+C", "D+E");
        List<Integer> years = Arrays.asList(2015);

        assertNotEquals(0, this.client.getAssets(sectors, typesOfOwnerships, industrialClassifications, years).size());
    }

}
