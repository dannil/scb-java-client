/*
 * Copyright 2014 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.population.statistics.amount;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
@Remote
public class PopulationStatisticsAmountClientIT {

    private PopulationStatisticsAmountClient client;

    @BeforeEach
    public void setup() {
        this.client = new PopulationStatisticsAmountClient();
    }

    @Test
    @Date("2017-01-01")
    public void getPopulation() {
        assertNotEquals(0, this.client.getPopulation().size());
    }

    @Test
    @Date("2017-01-01")
    public void getPopulationWithParameters() {
        List<String> regions = Arrays.asList("1263");
        List<String> statuses = Arrays.asList("OG", "G", "SK", "ÄNKL");
        List<String> ages = Arrays.asList("25");
        List<Integer> genders = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(1996);

        assertNotEquals(0, this.client.getPopulation(regions, statuses, ages, genders, years).size());
    }

}
