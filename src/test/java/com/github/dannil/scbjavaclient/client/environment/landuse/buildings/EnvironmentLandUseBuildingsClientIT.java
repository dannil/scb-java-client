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

package com.github.dannil.scbjavaclient.client.environment.landuse.buildings;

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
public class EnvironmentLandUseBuildingsClientIT {

    private EnvironmentLandUseBuildingsClient client;

    @BeforeEach
    public void setup() {
        this.client = new EnvironmentLandUseBuildingsClient();
    }

    @Test
    @Date("2017-03-17")
    public void getBuilding() {
        assertNotEquals(0, this.client.getBuilding().size());
    }

    @Test
    @Date("2017-03-17")
    public void getBuildingWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getBuilding(Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-03-17")
    public void getBuildingWithParameters() {
        List<String> regions = Arrays.asList("0114", "0140");
        List<Integer> types = Arrays.asList(3, 7);
        List<Integer> years = Arrays.asList(2010);

        assertNotEquals(0, this.client.getBuilding(regions, types, years).size());
    }

}
