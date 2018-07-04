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

package com.github.dannil.scbjavaclient.client.population.statistics.migration;

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
public class PopulationStatisticsMigrationClientIT {

    private PopulationStatisticsMigrationClient client;

    @BeforeEach
    public void setup() {
        this.client = new PopulationStatisticsMigrationClient();
    }

    @Test
    @Date("2017-04-27")
    public void getImmigrations() {
        assertNotEquals(0, this.client.getImmigrations().size());
    }

    @Test
    @Date("2017-04-27")
    public void getImmigrationsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getImmigrations(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-27")
    public void getImmigrationsWithParameters() {
        List<String> groundsForSettlements = Arrays.asList("Hum", "Arb");
        List<String> countriesOfBirths = Arrays.asList("DZ", "AD");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2004, 2006);

        assertNotEquals(0, this.client.getImmigrations(groundsForSettlements, countriesOfBirths, sexes, years).size());
    }

    @Test
    @Date("2017-04-27")
    public void getMigration() {
        assertNotEquals(0, this.client.getMigration().size());
    }

    @Test
    @Date("2017-04-27")
    public void getMigrationWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getMigration(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-27")
    public void getMigrationWithParameters() {
        List<String> regions = Arrays.asList("0125");
        List<String> ages = Arrays.asList("13", "100+");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2000, 2002);

        assertNotEquals(0, this.client.getMigration(regions, ages, sexes, years).size());
    }

}
