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

package com.github.dannil.scbjavaclient.client.population.statistics.averageage;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AverageAgeClientIT extends RemoteIntegrationTestSuite {

    private AverageAgeClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().population().statistics().averageAge();
    }

    @Test
    public void getAverageAge() {
        assertNotEquals(0, this.client.getAverageAge().size());
    }

    @Test
    public void getAverageAgeWithParameters() {
        List<String> regions = Arrays.asList("1263");
        List<String> genders = Arrays.asList("1", "2", "1+2");
        List<Integer> years = Arrays.asList(2002);

        assertNotEquals(0, this.client.getAverageAge(regions, genders, years).size());
    }
}
