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

package com.github.dannil.scbjavaclient.client.environment.protectednature.naturetypes;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.runner.Date;
import com.github.dannil.scbjavaclient.test.runner.DateJUnitRunner;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DateJUnitRunner.class)
public class EnvironmentProtectedNatureNatureTypesClientIT extends RemoteIntegrationTestSuite {

    private EnvironmentProtectedNatureNatureTypesClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().environment().protectedNature().natureTypes();
    }

    @Test
    @Date("2017-09-15")
    public void getProtectedAreas() {
        assertNotEquals(0, this.client.getProtectedAreas().size());
    }

    @Test
    @Date("2017-09-15")
    public void getProtectedAreasWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getProtectedAreas(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-09-15")
    public void getProtectedAreasWithParameters() {
        List<String> natureTypes = Arrays.asList("BSS", "LSS");
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getProtectedAreas(natureTypes, years).size());
    }

    @Test
    @Date("2017-09-15")
    public void getProductiveForestLand() {
        assertNotEquals(0, this.client.getProductiveForestLand().size());
    }

    @Test
    @Date("2017-09-15")
    public void getProductiveForestLandWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getProductiveForestLand(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-09-15")
    public void getProductiveForestLandWithParameters() {
        List<String> regions = Arrays.asList("05", "09");
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getProductiveForestLand(regions, years).size());
    }

}
