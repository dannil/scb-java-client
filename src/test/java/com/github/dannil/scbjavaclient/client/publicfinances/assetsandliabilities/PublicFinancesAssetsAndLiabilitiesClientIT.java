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
import com.github.dannil.scbjavaclient.test.runner.Date;
import com.github.dannil.scbjavaclient.test.runner.DateJUnitRunner;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DateJUnitRunner.class)
public class PublicFinancesAssetsAndLiabilitiesClientIT extends RemoteIntegrationTestSuite {

    private PublicFinancesAssetsAndLiabilitiesClient client;

    @Before
    public void setup() {
        this.client = new PublicFinancesAssetsAndLiabilitiesClient();
    }

    @Test
    @Date("2017-04-17")
    public void getAssetsAndLiabilities() {
        assertNotEquals(0, this.client.getAssetsAndLiabilities().size());
    }

    @Test
    @Date("2017-04-17")
    public void getAssetsAndLiabilitiesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getAssetsAndLiabilities(Collections.<Integer>emptyList(),
                Collections.<Integer>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-04-17")
    public void getAssetsAndLiabilitiesWithParameters() {
        List<Integer> items = Arrays.asList(501, 504);
        List<Integer> sectors = Arrays.asList(410, 420);
        List<String> quarters = Arrays.asList("2005k2", "2007k3");

        assertNotEquals(0, this.client.getAssetsAndLiabilities(items, sectors, quarters).size());
    }

}
