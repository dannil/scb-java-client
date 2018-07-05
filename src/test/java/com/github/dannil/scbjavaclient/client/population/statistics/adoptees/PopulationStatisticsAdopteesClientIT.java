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

package com.github.dannil.scbjavaclient.client.population.statistics.adoptees;

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
public class PopulationStatisticsAdopteesClientIT {

    private PopulationStatisticsAdopteesClient client;

    @BeforeEach
    public void setup() {
        this.client = new PopulationStatisticsAdopteesClient();
    }

    @Test
    @Date("2017-04-09")
    public void getAdoptions() {
        assertNotEquals(0, this.client.getAdoptions().size());
    }

    @Test
    @Date("2017-04-09")
    public void getAdoptionsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getAdoptions(Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-09")
    public void getAdoptionsWithParameters() {
        List<String> sexes = Arrays.asList("1", "1+2");
        List<Integer> yearOfBirths = Arrays.asList(1928, 1956);
        List<Integer> years = Arrays.asList(2009);

        assertNotEquals(0, this.client.getAdoptions(sexes, yearOfBirths, years).size());
    }

}
