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

package com.github.dannil.scbjavaclient.client.environment.greenhousegas;

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
public class EnvironmentGreenhouseGasClientIT extends RemoteIntegrationTestSuite {

    private EnvironmentGreenhouseGasClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().environment().greenhouseGas();
    }

    @Test
    public void getTotalEmissions() {
        assertNotEquals(0, this.client.getTotalEmissions().size());
    }

    @Test
    public void getTotalEmissionsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTotalEmissions(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getTotalEmissionsWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "HFC");
        List<String> sectors = Arrays.asList("0.2", "0.4");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getTotalEmissions(greenhouseGases, sectors, years).size());
    }

    @Test
    public void getEmissionsFromWaste() {
        assertNotEquals(0, this.client.getEmissionsFromWaste().size());
    }

    @Test
    public void getEmissionsFromWasteWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromWaste(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getEmissionsFromWasteWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> subSectors = Arrays.asList("2.4.1", "2.4.2");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromWaste(greenhouseGases, subSectors, years).size());
    }

    @Test
    public void getEmissionsFromHeatingOfHousesAndBuildings() {
        assertNotEquals(0, this.client.getEmissionsFromHeatingOfHousesAndBuildings().size());
    }

    @Test
    public void getEmissionsFromHeatingOfHousesAndBuildingsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromHeatingOfHousesAndBuildings(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getEmissionsFromHeatingOfHousesAndBuildingsWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> subSectors = Arrays.asList("9.2.1", "9.2.2");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0,
                this.client.getEmissionsFromHeatingOfHousesAndBuildings(greenhouseGases, subSectors, years).size());
    }

    @Test
    public void getEmissionsFromLandUse() {
        assertNotEquals(0, this.client.getEmissionsFromLandUse().size());
    }

    @Test
    public void getEmissionsFromLandUseWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromLandUse(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getEmissionsFromLandUseWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> subSectors = Arrays.asList("10.1.1", "10.1.2");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromLandUse(greenhouseGases, subSectors, years).size());
    }

    @Test
    public void getEmissionsFromDomesticTransport() {
        assertNotEquals(0, this.client.getEmissionsFromDomesticTransport().size());
    }

    @Test
    public void getEmissionsFromDomesticTransportWithEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromDomesticTransport(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getEmissionsFromDomesticTransportWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> modesOfTransportations = Arrays.asList("8.4", "8.4.2");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0,
                this.client.getEmissionsFromDomesticTransport(greenhouseGases, modesOfTransportations, years).size());
    }

    @Test
    public void getEmissionsFromAgriculture() {
        assertNotEquals(0, this.client.getEmissionsFromAgriculture().size());
    }

    @Test
    public void getEmissionsFromAgricultureWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromWaste(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getEmissionsFromAgricultureWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> subSectors = Arrays.asList("6.3", "6.3.4");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromAgriculture(greenhouseGases, subSectors, years).size());
    }

    @Test
    public void getEmissionsFromInternationalTransport() {
        assertNotEquals(0, this.client.getEmissionsFromInternationalTransport().size());
    }

    @Test
    public void getEmissionsFromInternationalTransportWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromInternationalTransport(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getEmissionsFromInternationalTransportWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> activities = Arrays.asList("5.0", "5.1");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0,
                this.client.getEmissionsFromInternationalTransport(greenhouseGases, activities, years).size());
    }

    @Test
    public void getEmissionsFromSolventUse() {
        assertNotEquals(0, this.client.getEmissionsFromSolventUse().size());
    }

    @Test
    public void getEmissionsFromSolventUseWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromWaste(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getEmissionsFromSolventUseWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> areas = Arrays.asList("7.2.1", "7.2.5");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromSolventUse(greenhouseGases, areas, years).size());
    }

    @Test
    public void getEmissionsFromOffroadVehiclesAndMachinery() {
        assertNotEquals(0, this.client.getEmissionsFromOffroadVehiclesAndMachinery().size());
    }

    @Test
    public void getEmissionsFromOffroadVehiclesAndMachineryWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromOffroadVehiclesAndMachinery(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getEmissionsFromOffroadVehiclesAndMachineryWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> subSectors = Arrays.asList("1.0", "1.5");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0,
                this.client.getEmissionsFromOffroadVehiclesAndMachinery(greenhouseGases, subSectors, years).size());
    }

    @Test
    public void getEmissionsFromIndustry() {
        assertNotEquals(0, this.client.getEmissionsFromIndustry().size());
    }

    @Test
    public void getEmissionsFromIndustryWithEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromIndustry(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getEmissionsFromIndustryWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> industries = Arrays.asList("4.1.1", "4.1.3");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromIndustry(greenhouseGases, industries, years).size());
    }

    @Test
    public void getEmissionsFromElectricityAndHeating() {
        assertNotEquals(0, this.client.getEmissionsFromElectricityAndHeating().size());
    }

    @Test
    public void getEmissionsFromElectricityAndHeatingParametersWithEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromWaste(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getEmissionsFromElectricityAndHeatingWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> fuelTypes = Arrays.asList("3.0", "3.4");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromElectricityAndHeating(greenhouseGases, fuelTypes, years).size());
    }

}
