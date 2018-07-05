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

package com.github.dannil.scbjavaclient.client.environment.landuse.planning;

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
public class EnvironmentLandUsePlanningClientIT {

    private EnvironmentLandUsePlanningClient client;

    @BeforeEach
    public void setup() {
        this.client = new EnvironmentLandUsePlanningClient();
    }

    @Test
    @Date("2017-03-17")
    public void getPlanning() {
        assertNotEquals(0, this.client.getPlanning().size());
    }

    @Test
    @Date("2017-03-17")
    public void getPlanningWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getPlanning(Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-03-17")
    public void getPlanningWithParameters() {
        List<String> regions = Arrays.asList("0114", "0140");
        List<Integer> years = Arrays.asList(2010);

        assertNotEquals(0, this.client.getPlanning(regions, years).size());
    }

}
