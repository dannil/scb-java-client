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

package com.github.dannil.scbjavaclient.client.agriculture.cerealcrops;

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
public class AgricultureCerealCropsClientIT extends RemoteIntegrationTestSuite {

    private AgricultureCerealCropsClient client;

    @Before
    public void setup() {
        this.client = new AgricultureCerealCropsClient();
    }

    @Test
    @Date("2017-05-21")
    public void getYieldPerHectarAndTotalProduction() {
        assertNotEquals(0, this.client.getYieldPerHectarAndTotalProduction().size());
    }

    @Test
    @Date("2017-05-21")
    public void getYieldPerHectarAndTotalProductionWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getYieldPerHectarAndTotalProduction(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-21")
    public void getYieldPerHectarAndTotalProductionWithParameters() {
        List<String> regions = Arrays.asList("05", "08");
        List<Integer> crops = Arrays.asList(105, 150);
        List<Integer> years = Arrays.asList(2003, 2005);

        assertNotEquals(0, this.client.getYieldPerHectarAndTotalProduction(regions, crops, years).size());
    }

}
