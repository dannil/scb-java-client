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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.bpi;

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
public class PricesAndConsumptionBPIClientIT {

    private PricesAndConsumptionBPIClient client;

    @BeforeEach
    public void setup() {
        this.client = new PricesAndConsumptionBPIClient();
    }

    @Test
    @Date("2017-06-04")
    public void getBuildingPriceIndexForDwellingsQuarters() {
        assertNotEquals(0, this.client.getBuildingPriceIndexForDwellingsQuarters().size());
    }

    @Test
    @Date("2017-06-04")
    public void getBuildingPriceIndexForDwellingsQuartersWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getBuildingPriceIndexForDwellingsQuarters(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-04")
    public void getBuildingPriceIndexForDwellingsQuartersWithParameters() {
        List<String> typesOfBuildings = Arrays.asList("FLERBO", "GRUPPSMÅ");
        List<String> typesOfIndexes = Arrays.asList("ANPR", "PÅPR");
        List<String> quarters = Arrays.asList("2003K3", "2004K4");

        assertNotEquals(0, this.client.getBuildingPriceIndexForDwellingsQuarters(typesOfBuildings, typesOfIndexes,
                quarters).size());
    }

    @Test
    @Date("2017-06-04")
    public void getBuildingPriceIndexForDwellingsYears() {
        assertNotEquals(0, this.client.getBuildingPriceIndexForDwellingsYears().size());
    }

    @Test
    @Date("2017-06-04")
    public void getBuildingPriceIndexForDwellingsYearsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getBuildingPriceIndexForDwellingsYears(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-04")
    public void getBuildingPriceIndexForDwellingsYearsWithParameters() {
        List<String> typesOfBuildings = Arrays.asList("FLERBO", "GRUPPSMÅ");
        List<String> typesOfIndexes = Arrays.asList("ANPR", "PÅPR");
        List<Integer> years = Arrays.asList(2003, 2004);

        assertNotEquals(0,
                this.client.getBuildingPriceIndexForDwellingsYears(typesOfBuildings, typesOfIndexes, years).size());
    }

}
