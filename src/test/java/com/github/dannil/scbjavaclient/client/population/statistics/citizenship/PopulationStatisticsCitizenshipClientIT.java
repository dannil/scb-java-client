/*
 * Copyright 2018 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.population.statistics.citizenship;

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
public class PopulationStatisticsCitizenshipClientIT {

    private PopulationStatisticsCitizenshipClient client;

    @BeforeEach
    public void setup() {
        this.client = new PopulationStatisticsCitizenshipClient();
    }

    @Test
    @Date("2018-06-22")
    public void getAcquiredSwedishCitizenship() {
        assertNotEquals(0, this.client.getAcquiredSwedishCitizenship().size());
    }

    @Test
    @Date("2018-06-22")
    public void getAcquiredSwedishCitizenshipWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getAcquiredSwedishCitizenship(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-06-22")
    public void getAcquiredSwedishCitizenshipWithParameters() {
        List<String> regions = Arrays.asList("0330", "0331");
        List<String> ages = Arrays.asList("18-24", "25-44");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2005, 2006);

        assertNotEquals(0, this.client.getAcquiredSwedishCitizenship(regions, ages, sexes, years).size());
    }

    @Test
    @Date("2018-06-22")
    public void getAcquiredSwedishCitizenshipInSweden() {
        assertNotEquals(0, this.client.getAcquiredSwedishCitizenshipInSweden().size());
    }

    @Test
    @Date("2018-06-22")
    public void getAcquiredSwedishCitizenshipInSwedenWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getAcquiredSwedishCitizenshipInSweden(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-06-22")
    public void getAcquiredSwedishCitizenshipInSwedenWithParameters() {
        List<String> countriesOfCitizenship = Arrays.asList("AD", "BR");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2005, 2006);

        assertNotEquals(0,
                this.client.getAcquiredSwedishCitizenshipInSweden(countriesOfCitizenship, sexes, years).size());
    }

}
