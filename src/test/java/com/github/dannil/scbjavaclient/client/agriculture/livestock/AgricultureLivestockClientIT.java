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

package com.github.dannil.scbjavaclient.client.agriculture.livestock;

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
public class AgricultureLivestockClientIT extends RemoteIntegrationTestSuite {

    private AgricultureLivestockClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().agriculture().livestock();
    }

    @Test
    @Date("2017-05-21")
    public void getLivestockByMunicipality() {
        assertNotEquals(0, this.client.getLivestockByMunicipality().size());
    }

    @Test
    @Date("2017-05-21")
    public void getLivestockByMunicipalityWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getLivestockByMunicipality(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-21")
    public void getLivestockByMunicipalityWithParameters() {
        List<String> regions = Arrays.asList("0128", "0136");
        List<String> typesOfAnimals = Arrays.asList("05", "10");
        List<Integer> years = Arrays.asList(1992, 1993);

        assertNotEquals(0, this.client.getLivestockByMunicipality(regions, typesOfAnimals, years).size());
    }

    @Test
    @Date("2017-05-21")
    public void getLivestockByCounty() {
        assertNotEquals(0, this.client.getLivestockByCounty().size());
    }

    @Test
    @Date("2017-05-21")
    public void getLivestockByCountyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getLivestockByCounty(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-21")
    public void getLivestockByCountyWithParameters() {
        List<String> regions = Arrays.asList("10", "12");
        List<String> typesOfAnimals = Arrays.asList("05", "10");
        List<Integer> years = Arrays.asList(1992, 1993);

        assertNotEquals(0, this.client.getLivestockByCounty(regions, typesOfAnimals, years).size());
    }

}
