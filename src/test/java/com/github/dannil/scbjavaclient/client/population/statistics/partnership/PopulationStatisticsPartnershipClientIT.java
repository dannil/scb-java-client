/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.population.statistics.partnership;

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
public class PopulationStatisticsPartnershipClientIT {

    private PopulationStatisticsPartnershipClient client;

    @BeforeEach
    public void setup() {
        this.client = new PopulationStatisticsPartnershipClient();
    }

    @Test
    @Date("2017-01-01")
    public void getPartnership() {
        assertNotEquals(0, this.client.getPartnership().size());
    }

    @Test
    @Date("2017-01-01")
    public void getPartnershipWithParameters() {
        List<String> regions = Arrays.asList("12");
        List<String> statuses = Arrays.asList("RP", "SP", "EP");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2000, 2002);

        assertNotEquals(0, this.client.getPartnership(regions, statuses, sexes, years).size());
    }

    @Test
    @Date("2017-01-01")
    public void getPartnershipChange() {
        assertNotEquals(0, this.client.getPartnershipChange().size());
    }

    @Test
    @Date("2017-01-01")
    public void getPartnershipChangeWithParameters() {
        List<String> regions = Arrays.asList("122");
        List<String> statuses = Arrays.asList("RP", "SP", "EP");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2001, 2003);

        assertNotEquals(0, this.client.getPartnershipChange(regions, statuses, sexes, years).size());
    }

}
