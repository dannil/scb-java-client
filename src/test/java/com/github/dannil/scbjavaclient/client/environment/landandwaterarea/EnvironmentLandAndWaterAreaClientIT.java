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

package com.github.dannil.scbjavaclient.client.environment.landandwaterarea;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.test.runner.Date;
import com.github.dannil.scbjavaclient.test.runner.DateJUnitRunner;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DateJUnitRunner.class)
public class EnvironmentLandAndWaterAreaClientIT extends RemoteIntegrationTestSuite {

    private EnvironmentLandAndWaterAreaClient client;

    @Before
    public void setup() {
        this.client = new EnvironmentLandAndWaterAreaClient();
    }

    @Test
    @Date("2015-04-22")
    public void getArea() {
        assertNotEquals(0, this.client.getArea().size());
    }

    @Test
    @Date("2015-04-22")
    public void getAreaWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getArea(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2015-04-22")
    public void getAreaWithParameters() {
        List<String> regions = Arrays.asList("1263");
        List<String> types = Arrays.asList("01", "02", "03", "04");
        List<Integer> years = Arrays.asList(2012);

        assertNotEquals(0, this.client.getArea(regions, types, years).size());
    }

}
