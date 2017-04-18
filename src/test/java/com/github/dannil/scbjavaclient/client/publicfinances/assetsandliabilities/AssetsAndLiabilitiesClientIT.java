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

package com.github.dannil.scbjavaclient.client.publicfinances.assetsandliabilities;

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
public class AssetsAndLiabilitiesClientIT extends RemoteIntegrationTestSuite {

    private AssetsAndLiabilitiesClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().publicFinances().assetsAndLiabilities();
    }

    @Test
    public void getAssetsAndLiabilities() {
        assertNotEquals(0, this.client.getAssetsAndLiabilities().size());
    }

    @Test
    public void getAssetsAndLiabilitiesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getAssetsAndLiabilities(Collections.<Integer>emptyList(),
                Collections.<Integer>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    public void getAssetsAndLiabilitiesWithParameters() {
        List<Integer> items = Arrays.asList(501, 504);
        List<Integer> sectors = Arrays.asList(410, 420);
        List<String> quarters = Arrays.asList("2005k2", "2007k3");

        assertNotEquals(0, this.client.getAssetsAndLiabilities(items, sectors, quarters).size());
    }

}
