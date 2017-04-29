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

package com.github.dannil.scbjavaclient.client.environment.protectednature;

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
public class ProtectedNatureClientIT extends RemoteIntegrationTestSuite {

    private ProtectedNatureClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().environment().protectedNature();
    }

    @Test
    public void getWildlifeSanctuaries() {
        assertNotEquals(0, this.client.getWildlifeSanctuaries().size());
    }

    @Test
    public void getWildlifeSanctuariesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getWildlifeSanctuaries(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getWildlifeSanctuariesWithParameters() {
        List<String> regions = Arrays.asList("05", "09");
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getWildlifeSanctuaries(regions, years).size());
    }

    @Test
    public void getNatura2000Sites() {
        assertNotEquals(0, this.client.getNatura2000Sites().size());
    }

    @Test
    public void getNatura2000SitesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNatura2000Sites(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getNatura2000SitesWithParameters() {
        List<String> regions = Arrays.asList("05", "09");
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getNatura2000Sites(regions, years).size());
    }

    @Test
    public void getProtectedAreas() {
        assertNotEquals(0, this.client.getProtectedAreas().size());
    }

    @Test
    public void getProtectedAreasWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getProtectedAreas(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getProtectedAreasWithParameters() {
        List<String> natureTypes = Arrays.asList("BSS", "LSS");
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getProtectedAreas(natureTypes, years).size());
    }

    @Test
    public void getProductiveForestLand() {
        assertNotEquals(0, this.client.getProductiveForestLand().size());
    }

    @Test
    public void getProductiveForestLandWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getProductiveForestLand(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    public void getProductiveForestLandWithParameters() {
        List<String> regions = Arrays.asList("05", "09");
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getProductiveForestLand(regions, years).size());
    }

}
