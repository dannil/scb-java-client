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

package com.github.dannil.scbjavaclient.client.environment.protectednature.numberandarea;

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
public class EnvironmentProtectedNatureNumberAndAreaClientIT {

    private EnvironmentProtectedNatureNumberAndAreaClient client;

    @BeforeEach
    public void setup() {
        this.client = new EnvironmentProtectedNatureNumberAndAreaClient();
    }

    @Test
    @Date("2017-09-15")
    public void getWildlifeSanctuaries() {
        assertNotEquals(0, this.client.getWildlifeSanctuaries().size());
    }

    @Test
    @Date("2017-09-15")
    public void getWildlifeSanctuariesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getWildlifeSanctuaries(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-09-15")
    public void getWildlifeSanctuariesWithParameters() {
        List<String> regions = Arrays.asList("05", "09");
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getWildlifeSanctuaries(regions, years).size());
    }

    @Test
    @Date("2017-09-15")
    public void getNatura2000Sites() {
        assertNotEquals(0, this.client.getNatura2000Sites().size());
    }

    @Test
    @Date("2017-09-15")
    public void getNatura2000SitesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNatura2000Sites(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-09-15")
    public void getNatura2000SitesWithParameters() {
        List<String> regions = Arrays.asList("05", "09");
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getNatura2000Sites(regions, years).size());
    }

    @Test
    @Date("2017-09-16")
    public void getProtectedNature() {
        assertNotEquals(0, this.client.getProtectedNature().size());
    }

    @Test
    @Date("2017-09-16")
    public void getProtectedNatureWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getProtectedNature(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-09-16")
    public void getProtectedNatureWithParameters() {
        List<String> regions = Arrays.asList("0128", "0182");
        List<String> protectionTypes = Arrays.asList("NVO", "SBO");
        List<Integer> years = Arrays.asList(2011, 2012);

        assertNotEquals(0, this.client.getProtectedNature(regions, protectionTypes, years).size());
    }

    @Test
    @Date("2017-09-17")
    public void getSpeciesProtectedByLaw() {
        assertNotEquals(0, this.client.getSpeciesProtectedByLaw().size());
    }

    @Test
    @Date("2017-09-17")
    public void getSpeciesProtectedByLawWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getSpeciesProtectedByLaw(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-09-17")
    public void getSpeciesProtectedByLawWithParameters() {
        List<String> regions = Arrays.asList("00");
        List<String> species = Arrays.asList("Groddjur", "Mossor");
        List<Integer> years = Arrays.asList(2015, 2016);

        assertNotEquals(0, this.client.getSpeciesProtectedByLaw(regions, species, years).size());
    }

    @Test
    @Date("2017-09-17")
    public void getCultureReserves() {
        assertNotEquals(0, this.client.getCultureReserves().size());
    }

    @Test
    @Date("2017-09-17")
    public void getCultureReservesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getCultureReserves(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-09-17")
    public void getCultureReservesWithParameters() {
        List<String> regions = Arrays.asList("07", "08");
        List<Integer> years = Arrays.asList(2005, 2006);

        assertNotEquals(0, this.client.getCultureReserves(regions, years).size());
    }

    @Test
    @Date("2017-09-17")
    public void getNaturalMonuments() {
        assertNotEquals(0, this.client.getNaturalMonuments().size());
    }

    @Test
    @Date("2017-09-17")
    public void getNaturalMonumentsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNaturalMonuments(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-09-17")
    public void getNaturalMonumentsWithParameters() {
        List<String> regions = Arrays.asList("04", "05");
        List<Integer> years = Arrays.asList(2015, 2016);

        assertNotEquals(0, this.client.getNaturalMonuments(regions, years).size());
    }

    @Test
    @Date("2017-09-17")
    public void getWaterProtectionAreas() {
        assertNotEquals(0, this.client.getWaterProtectionAreas().size());
    }

    @Test
    @Date("2017-09-17")
    public void getWaterProtectionAreasWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getWaterProtectionAreas(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-09-17")
    public void getWaterProtectionAreasWithParameters() {
        List<String> regions = Arrays.asList("0662", "0665");
        List<Integer> years = Arrays.asList(2015, 2016);

        assertNotEquals(0, this.client.getWaterProtectionAreas(regions, years).size());
    }

}
