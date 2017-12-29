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

package com.github.dannil.scbjavaclient.client.environment.localitiesareasandpopulation.gainfullyemployedandworkplaces;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Suite
@Remote
public class EnvironmentLocalitiesAreasAndPopulationGainfullyEmployedAndWorkplacesClientIT {

    private EnvironmentLocalitiesAreasAndPopulationGainfullyEmployedAndWorkplacesClient client;

    @BeforeEach
    public void setup() {
        this.client = new EnvironmentLocalitiesAreasAndPopulationGainfullyEmployedAndWorkplacesClient();
    }

    @Test
    @Date("2017-12-29")
    public void getGainfullyEmployed() {
        assertNotEquals(0, this.client.getGainfullyEmployed().size());
    }

    @Test
    @Date("2017-12-29")
    public void getGainfullyEmployedWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getGainfullyEmployed(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-12-29")
    public void getGainfullyEmployedWithParameters() {
        List<String> regions = Arrays.asList("T0388", "T0326");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2005, 2010);

        assertNotEquals(0, this.client.getGainfullyEmployed(regions, sexes, years).size());
    }

    @Test
    @Date("2017-12-29")
    public void getGainfullyEmployedWorkplaces() {
        assertNotEquals(0, this.client.getGainfullyEmployedWorkplaces().size());
    }

    @Test
    @Date("2017-12-29")
    public void getGainfullyEmployedWorkplacesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getGainfullyEmployedWorkplaces(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-12-29")
    public void getGainfullyEmployedWorkplacesWithParameters() {
        List<String> regions = Arrays.asList("T0224", "T0232");
        List<Integer> years = Arrays.asList(2005, 2010);

        assertNotEquals(0, this.client.getGainfullyEmployedWorkplaces(regions, years).size());
    }

    @Test
    @Date("2017-12-29")
    public void getGainfullyEmployedAreas() {
        assertNotEquals(0, this.client.getGainfullyEmployedAreas().size());
    }

    @Test
    @Date("2017-12-29")
    public void getGainfullyEmployedAreasWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getGainfullyEmployedAreas(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-12-29")
    public void getGainfullyEmployedAreasWithParameters() {
        List<String> regions = Arrays.asList("0125", "0128");
        List<String> typeOfAreas = Arrays.asList("IAO", "UTA");
        List<Integer> years = Arrays.asList(2005, 2010);

        assertNotEquals(0, this.client.getGainfullyEmployedAreas(regions, typeOfAreas, years).size());
    }

}
