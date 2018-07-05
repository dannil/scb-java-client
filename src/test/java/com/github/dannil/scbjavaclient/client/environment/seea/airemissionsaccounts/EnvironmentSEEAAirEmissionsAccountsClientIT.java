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

package com.github.dannil.scbjavaclient.client.environment.seea.airemissionsaccounts;

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
public class EnvironmentSEEAAirEmissionsAccountsClientIT {

    private EnvironmentSEEAAirEmissionsAccountsClient client;

    @BeforeEach
    public void setup() {
        this.client = new EnvironmentSEEAAirEmissionsAccountsClient();
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsByIndustrySNI2007() {
        assertNotEquals(0, this.client.getAirEmissionsByIndustrySNI2007().size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsByIndustrySNI2007WithParametersEmptyLists() {
        assertNotEquals(0, this.client.getAirEmissionsByIndustrySNI2007(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsByIndustrySNI2007WithParameters() {
        List<String> industrialClassifications = Arrays.asList("C25", "C26");
        List<String> substances = Arrays.asList("NH3", "NMVOC");
        List<Integer> years = Arrays.asList(2010, 2011);

        assertNotEquals(0,
                this.client.getAirEmissionsByIndustrySNI2007(industrialClassifications, substances, years).size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsByIndustrySNI92() {
        assertNotEquals(0, this.client.getAirEmissionsByIndustrySNI92().size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsByIndustrySNI92WithParametersEmptyLists() {
        assertNotEquals(0, this.client.getAirEmissionsByIndustrySNI92(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsByIndustrySNI92WithParameters() {
        List<String> industrialClassifications = Arrays.asList("50-52", "64");
        List<String> substances = Arrays.asList("pm10", "pm25");
        List<Integer> years = Arrays.asList(1996, 1997);

        assertNotEquals(0,
                this.client.getAirEmissionsByIndustrySNI92(industrialClassifications, substances, years).size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsByIndustryAndQuartersSNI2007() {
        assertNotEquals(0, this.client.getAirEmissionsByIndustryAndQuartersSNI2007().size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsByIndustryAndQuartersSNI2007WithParametersEmptyLists() {
        assertNotEquals(0, this.client.getAirEmissionsByIndustryAndQuartersSNI2007(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsByIndustryAndQuartersSNI2007WithParameters() {
        List<String> industrialClassifications = Arrays.asList("C22-C23", "M69-M72");
        List<String> substances = Arrays.asList("CO2", "SO2");
        List<String> quarters = Arrays.asList("2012K1", "2012K3");

        assertNotEquals(0, this.client.getAirEmissionsByIndustryAndQuartersSNI2007(industrialClassifications,
                substances, quarters).size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsByMunicipalityLAU2() {
        assertNotEquals(0, this.client.getAirEmissionsByMunicipalityLAU2().size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsByMunicipalityLAU2WithParametersEmptyLists() {
        assertNotEquals(0, this.client.getAirEmissionsByMunicipalityLAU2(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsByMunicipalityLAU2WithParameters() {
        List<String> regions = Arrays.asList("0330", "0331");
        List<String> substances = Arrays.asList("PM25", "PFC");
        List<Integer> years = Arrays.asList(2010, 2011);

        assertNotEquals(0, this.client.getAirEmissionsByMunicipalityLAU2(regions, substances, years).size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsNUTS2() {
        assertNotEquals(0, this.client.getAirEmissionsNUTS2().size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsNUTS2WithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getAirEmissionsNUTS2(Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsNUTS2WithParameters() {
        List<String> regions = Arrays.asList("SE21", "SE22");
        List<String> industrialClassifications = Arrays.asList("I55-I56", "M69-N82");
        List<String> substances = Arrays.asList("PM25", "PFC");
        List<Integer> years = Arrays.asList(2010, 2011);

        assertNotEquals(0,
                this.client.getAirEmissionsNUTS2(regions, industrialClassifications, substances, years).size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsFromTransportNUTS2() {
        assertNotEquals(0, this.client.getAirEmissionsFromTransportNUTS2().size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsFromTransportNUTS2WithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getAirEmissionsFromTransportNUTS2(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsFromTransportNUTS2WithParameters() {
        List<String> regions = Arrays.asList("SE21", "SE22");
        List<String> industrialClassifications = Arrays.asList("I55-I56", "M69-N82");
        List<String> substances = Arrays.asList("PM25", "PFC");
        List<Integer> years = Arrays.asList(2010, 2011);

        assertNotEquals(0, this.client.getAirEmissionsFromTransportNUTS2(regions, industrialClassifications, substances,
                years).size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsByCountyNUTS3() {
        assertNotEquals(0, this.client.getAirEmissionsByCountyNUTS3().size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsByCountyNUTS3WithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getAirEmissionsByCountyNUTS3(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-31")
    public void getAirEmissionsByCountyNUTS3WithParameters() {
        List<String> regions = Arrays.asList("06", "08");
        List<String> industrialClassifications = Arrays.asList("A01-F43", "G45-T98");
        List<String> substances = Arrays.asList("NOX", "N2O");
        List<Integer> years = Arrays.asList(2010, 2011);

        assertNotEquals(0,
                this.client.getAirEmissionsByCountyNUTS3(regions, industrialClassifications, substances, years).size());
    }

}
