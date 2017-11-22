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

package com.github.dannil.scbjavaclient.client.environment.seea.taxes;

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
public class EnvironmentSEEATaxesClientIT extends RemoteIntegrationTestSuite {

    private EnvironmentSEEATaxesClient client;

    @Before
    public void setup() {
        this.client = new EnvironmentSEEATaxesClient();
    }

    @Test
    @Date("2017-10-05")
    public void getEnvironmentalTaxesSNI2007() {
        assertNotEquals(0, this.client.getEnvironmentalTaxesSNI2007().size());
    }

    @Test
    @Date("2017-10-05")
    public void getEnvironmentalTaxesSNI2007WithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEnvironmentalTaxesSNI2007(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-10-05")
    public void getEnvironmentalTaxesSNI2007WithParameters() {
        List<String> industrialClassifications = Arrays.asList("K65", "K66");
        List<Integer> years = Arrays.asList(2010, 2011);

        assertNotEquals(0, this.client.getEnvironmentalTaxesSNI2007(industrialClassifications, years).size());
    }

    @Test
    @Date("2017-05-31")
    public void getEnvironmentalTaxesSNI92() {
        assertNotEquals(0, this.client.getEnvironmentalTaxesSNI92().size());
    }

    @Test
    @Date("2017-05-31")
    public void getEnvironmentalTaxesSNI92WithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEnvironmentalTaxesSNI92(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-31")
    public void getEnvironmentalTaxesSNI92WithParameters() {
        List<String> industrialClassifications = Arrays.asList("13+14", "35");
        List<Integer> years = Arrays.asList(1995, 1996);

        assertNotEquals(0, this.client.getEnvironmentalTaxesSNI92(industrialClassifications, years).size());
    }

}
