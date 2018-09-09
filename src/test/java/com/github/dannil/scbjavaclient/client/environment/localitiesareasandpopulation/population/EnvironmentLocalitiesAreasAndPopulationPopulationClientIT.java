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

package com.github.dannil.scbjavaclient.client.environment.localitiesareasandpopulation.population;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.exception.SCBClientResponseTooLargeException;
import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
@Remote
public class EnvironmentLocalitiesAreasAndPopulationPopulationClientIT {

    private EnvironmentLocalitiesAreasAndPopulationPopulationClient client;

    @BeforeEach
    public void setup() {
        this.client = new EnvironmentLocalitiesAreasAndPopulationPopulationClient();
    }

    // Daniel 2017-03-29: Returns HTTP 403
    @Test
    @Date("2018-06-28")
    public void getPopulationAndLandAreaWithinLocalities() {
        assertThrows(SCBClientResponseTooLargeException.class,
                () -> this.client.getPopulationAndLandAreaWithinLocalities());
    }

    // Daniel 2017-03-29: Returns HTTP 403
    @Test
    @Date("2018-06-28")
    public void getPopulationAndLandAreaWithinLocalitiesWithParametersEmptyLists() {
        assertThrows(SCBClientResponseTooLargeException.class,
                () -> this.client.getPopulationAndLandAreaWithinLocalities(Collections.<String>emptyList(),
                        Collections.<Integer>emptyList()));
    }

    @Test
    @Date("2018-03-29")
    public void getPopulationAndLandAreaWithinLocalitiesWithParameters() {
        List<String> regions = Arrays.asList("T0132", "T0164");
        List<Integer> years = Arrays.asList(1990, 1995);

        assertNotEquals(0, this.client.getPopulationAndLandAreaWithinLocalities(regions, years).size());
    }

    @Test
    @Date("2017-12-26")
    public void getPopulationAndLandAreaWithinAndOutsideOfLocalities() {
        assertNotEquals(0, this.client.getPopulationAndLandAreaWithinAndOutsideOfLocalities().size());
    }

    @Test
    @Date("2017-12-26")
    public void getPopulationAndLandAreaWithinAndOutsideOfLocalitiesWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getPopulationAndLandAreaWithinAndOutsideOfLocalities(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-12-26")
    public void getPopulationAndLandAreaWithinAndOutsideOfLocalitiesWithParameters() {
        List<String> regions = Arrays.asList("0162", "0182");
        List<String> typeOfAreas = Arrays.asList("IT", "UT");
        List<Integer> years = Arrays.asList(2010, 2015);

        assertNotEquals(0,
                this.client.getPopulationAndLandAreaWithinAndOutsideOfLocalities(regions, typeOfAreas, years).size());
    }

    @Test
    @Date("2017-12-26")
    public void getNumberOfLocalitiesAndPopulationDensity() {
        assertNotEquals(0, this.client.getNumberOfLocalitiesAndPopulationDensity().size());
    }

    @Test
    @Date("2017-12-26")
    public void getNumberOfLocalitiesAndPopulationDensityWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNumberOfLocalitiesAndPopulationDensity(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-12-26")
    public void getNumberOfLocalitiesAndPopulationDensityWithParameters() {
        List<String> regions = Arrays.asList("0319", "0331");
        List<Integer> years = Arrays.asList(2005, 2010);

        assertNotEquals(0, this.client.getNumberOfLocalitiesAndPopulationDensity(regions, years).size());
    }

}
