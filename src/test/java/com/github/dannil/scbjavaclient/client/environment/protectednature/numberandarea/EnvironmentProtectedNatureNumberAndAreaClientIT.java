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

package com.github.dannil.scbjavaclient.client.environment.protectednature.numberandarea;

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
public class EnvironmentProtectedNatureNumberAndAreaClientIT extends RemoteIntegrationTestSuite {

    private EnvironmentProtectedNatureNumberAndAreaClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().environment().protectedNature().numberAndArea();
    }

    @Test
    @Date("2017-09-15")
    public void getWildlifeSanctuaries() {
        assertNotEquals(0, this.client.getWildlifeSanctuaries().size());
    }

    @Test
    @Date("2017-09-15")
    public void getWildlifeSanctuariesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getWildlifeSanctuaries(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-09-15")
    public void getWildlifeSanctuariesWithParameters() {
        List<String> regions = Arrays.asList("05", "09");
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getWildlifeSanctuaries(regions, years).size());
    }

    @Test
    @Date("2017-09-15")
    public void getNatura2000Sites() {
        assertNotEquals(0, this.client.getNatura2000Sites().size());
    }

    @Test
    @Date("2017-09-15")
    public void getNatura2000SitesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNatura2000Sites(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-09-15")
    public void getNatura2000SitesWithParameters() {
        List<String> regions = Arrays.asList("05", "09");
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getNatura2000Sites(regions, years).size());
    }

    @Test
    @Date("2017-09-16")
    public void getProtectedNature() {
        assertNotEquals(0, this.client.getProtectedNature().size());
    }

    @Test
    @Date("2017-09-16")
    public void getProtectedNatureWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getProtectedNature(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-09-16")
    public void getProtectedNatureWithParameters() {
        List<String> regions = Arrays.asList("0128", "0182");
        List<String> protectionTypes = Arrays.asList("NVO", "SBO");
        List<Integer> years = Arrays.asList(2011, 2012);

        assertNotEquals(0, this.client.getProtectedNature(regions, protectionTypes, years).size());
    }

}
