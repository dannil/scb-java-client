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

package com.github.dannil.scbjavaclient.client.population.projections.latestassumptions;

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
public class PopulationProjectionsLatestAssumptionsClientIT {

    private PopulationProjectionsLatestAssumptionsClient client;

    @BeforeEach
    public void setup() {
        this.client = new PopulationProjectionsLatestAssumptionsClient();
    }

    @Test
    @Date("2018-05-12")
    public void getDeathRate() {
        assertNotEquals(0, this.client.getDeathRate().size());
    }

    @Test
    @Date("2018-05-12")
    public void getDeathRateWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getDeathRate(Collections.<Integer>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-05-12")
    public void getDeathRateWithParameters() {
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> ages = Arrays.asList("21", "31");
        List<Integer> years = Arrays.asList(2038, 2053);

        assertNotEquals(0, this.client.getDeathRate(sexes, ages, years).size());
    }

    // Daniel 2018-05-12: Returns HTTP 403
    @Test
    @Date("2018-06-28")
    public void getEmigrationAssumption() {
        assertThrows(SCBClientResponseTooLargeException.class, () -> this.client.getEmigrationRateAssumption().size());
    }

    // Daniel 2018-05-12: Returns HTTP 403
    @Test
    @Date("2018-06-28")
    public void getEmigrationAssumptionWithParametersEmptyLists() {
        assertThrows(SCBClientResponseTooLargeException.class,
                () -> this.client.getEmigrationRateAssumption(Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-05-12")
    public void getEmigrationAssumptionWithParameters() {
        List<String> regionOfBirths = Arrays.asList("010", "020");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> ages = Arrays.asList("19", "42");
        List<Integer> years = Arrays.asList(2030, 2050);

        assertNotEquals(0, this.client.getEmigrationRateAssumption(regionOfBirths, sexes, ages, years).size());
    }

    @Test
    @Date("2018-05-12")
    public void getFertilityAssumption() {
        assertNotEquals(0, this.client.getFertilityAssumption().size());
    }

    @Test
    @Date("2018-05-12")
    public void getFertilityAssumptionWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getFertilityAssumption(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-05-12")
    public void getFertilityAssumptionWithParameters() {
        List<String> mothersRegionOfBirths = Arrays.asList("040", "070");
        List<String> ages = Arrays.asList("24", "25");
        List<Integer> years = Arrays.asList(2039, 2054);

        assertNotEquals(0, this.client.getFertilityAssumption(mothersRegionOfBirths, ages, years).size());
    }

}
