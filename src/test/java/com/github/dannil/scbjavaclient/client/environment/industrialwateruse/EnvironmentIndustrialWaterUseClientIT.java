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

package com.github.dannil.scbjavaclient.client.environment.industrialwateruse;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EnvironmentIndustrialWaterUseClientIT extends RemoteIntegrationTestSuite {

    private EnvironmentIndustrialWaterUseClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().environment().industrialWaterUse();
    }

    @Test
    public void getWaterAbstraction() {
        assertNotEquals(0, this.client.getWaterAbstraction().size());
    }

    @Test
    public void getWaterAbstractionWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getWaterAbstraction(Collections.<String>emptyList(), Collections.<Integer>emptyList(), Collections.<Integer>emptyList()));
    }

    @Test
    public void getWaterAbstractionWithParameters() {
        List<String> regions = Arrays.asList("04", "05");
        List<Integer> types = Arrays.asList(70, 80);
        List<Integer> years = Arrays.asList(2010, 2015);

        assertNotEquals(0, this.client.getWaterAbstraction(regions, types, years).size());
    }

    @Test
    public void getWaterUse() {
        assertNotEquals(0, this.client.getWaterUse().size());
    }

    @Test
    public void getWaterUseWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getWaterUse(Collections.<String>emptyList(), Collections.<Integer>emptyList(), Collections.<Integer>emptyList()));
    }

    @Test
    public void getWaterUseWithParameters() {
        List<String> regions = Arrays.asList("04", "05");
        List<Integer> types = Arrays.asList(70, 80);
        List<Integer> years = Arrays.asList(2010, 2015);

        assertNotEquals(0, this.client.getWaterUse(regions, types, years).size());
    }

    @Test
    public void getWaterDischarge() {
        assertNotEquals(0, this.client.getWaterDischarge().size());
    }

    @Test
    public void getWaterDischargeWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getWaterDischarge(Collections.<String>emptyList(), Collections.<Integer>emptyList(), Collections.<Integer>emptyList()));
    }

    @Test
    public void getWaterDischargeWithParameters() {
        List<String> regions = Arrays.asList("04", "05");
        List<Integer> recipients = Arrays.asList(130, 160);
        List<Integer> years = Arrays.asList(2010, 2015);

        assertNotEquals(0, this.client.getWaterDischarge(regions, recipients, years).size());
    }

}
