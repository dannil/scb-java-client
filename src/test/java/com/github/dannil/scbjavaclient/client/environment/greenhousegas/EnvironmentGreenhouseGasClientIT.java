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
public class EnvironmentGreenhouseGasClientIT {

    private EnvironmentGreenhouseGasClient client;

    @BeforeEach
    public void setup() {
        this.client = new EnvironmentGreenhouseGasClient();
    }

    @Test
    @Date("2017-05-28")
    public void getTotalEmissions() {
        assertNotEquals(0, this.client.getTotalEmissions().size());
    }

    @Test
    @Date("2017-05-28")
    public void getTotalEmissionsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTotalEmissions(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-28")
    public void getTotalEmissionsWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "HFC");
        List<String> sectors = Arrays.asList("0.2", "0.4");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getTotalEmissions(greenhouseGases, sectors, years).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromWaste() {
        assertNotEquals(0, this.client.getEmissionsFromWaste().size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromWasteWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromWaste(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromWasteWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> subSectors = Arrays.asList("2.4.1", "2.4.2");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromWaste(greenhouseGases, subSectors, years).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromHeatingOfHousesAndBuildings() {
        assertNotEquals(0, this.client.getEmissionsFromHeatingOfHousesAndBuildings().size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromHeatingOfHousesAndBuildingsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromHeatingOfHousesAndBuildings(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromHeatingOfHousesAndBuildingsWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> subSectors = Arrays.asList("9.2.1", "9.2.2");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0,
                this.client.getEmissionsFromHeatingOfHousesAndBuildings(greenhouseGases, subSectors, years).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromLandUse() {
        assertNotEquals(0, this.client.getEmissionsFromLandUse().size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromLandUseWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromLandUse(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromLandUseWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> subSectors = Arrays.asList("10.1.1", "10.1.2");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromLandUse(greenhouseGases, subSectors, years).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromDomesticTransport() {
        assertNotEquals(0, this.client.getEmissionsFromDomesticTransport().size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromDomesticTransportWithEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromDomesticTransport(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromDomesticTransportWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> modesOfTransportations = Arrays.asList("8.4", "8.4.2");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0,
                this.client.getEmissionsFromDomesticTransport(greenhouseGases, modesOfTransportations, years).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromAgriculture() {
        assertNotEquals(0, this.client.getEmissionsFromAgriculture().size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromAgricultureWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromWaste(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromAgricultureWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> subSectors = Arrays.asList("6.3", "6.3.4");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromAgriculture(greenhouseGases, subSectors, years).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromInternationalTransport() {
        assertNotEquals(0, this.client.getEmissionsFromInternationalTransport().size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromInternationalTransportWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromInternationalTransport(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromInternationalTransportWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> activities = Arrays.asList("5.0", "5.1");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0,
                this.client.getEmissionsFromInternationalTransport(greenhouseGases, activities, years).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromSolventUse() {
        assertNotEquals(0, this.client.getEmissionsFromSolventUse().size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromSolventUseWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromWaste(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromSolventUseWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> areas = Arrays.asList("7.2.1", "7.2.5");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromSolventUse(greenhouseGases, areas, years).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromOffroadVehiclesAndMachinery() {
        assertNotEquals(0, this.client.getEmissionsFromOffroadVehiclesAndMachinery().size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromOffroadVehiclesAndMachineryWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromOffroadVehiclesAndMachinery(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromOffroadVehiclesAndMachineryWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> subSectors = Arrays.asList("1.0", "1.5");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0,
                this.client.getEmissionsFromOffroadVehiclesAndMachinery(greenhouseGases, subSectors, years).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromIndustry() {
        assertNotEquals(0, this.client.getEmissionsFromIndustry().size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromIndustryWithEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromIndustry(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromIndustryWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> industries = Arrays.asList("4.1.1", "4.1.3");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromIndustry(greenhouseGases, industries, years).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromElectricityAndHeating() {
        assertNotEquals(0, this.client.getEmissionsFromElectricityAndHeating().size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromElectricityAndHeatingParametersWithEmptyLists() {
        assertNotEquals(0, this.client.getEmissionsFromWaste(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-28")
    public void getEmissionsFromElectricityAndHeatingWithParameters() {
        List<String> greenhouseGases = Arrays.asList("CH4", "CO2");
        List<String> fuelTypes = Arrays.asList("3.0", "3.4");
        List<Integer> years = Arrays.asList(2005, 2007);

        assertNotEquals(0, this.client.getEmissionsFromElectricityAndHeating(greenhouseGases, fuelTypes, years).size());
    }

}
