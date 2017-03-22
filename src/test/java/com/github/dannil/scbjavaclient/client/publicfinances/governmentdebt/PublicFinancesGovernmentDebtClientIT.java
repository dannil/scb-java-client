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

package com.github.dannil.scbjavaclient.client.publicfinances.governmentdebt;

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
public class PublicFinancesGovernmentDebtClientIT extends RemoteIntegrationTestSuite {

    private PublicFinancesGovernmentDebtClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().publicFinances().governmentDebt();
    }

    @Test
    public void getGovernmentDebt() {
        assertNotEquals(0, this.client.getGovernmentDebt().size());
    }

    @Test
    public void getGovernmentDebtWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getGovernmentDebt(Collections.<String>emptyList(), Collections.<String>emptyList()));
    }

    @Test
    public void getGovernmentDebtWithParameters() {
        List<String> items = Arrays.asList("RG242", "RG290");
        List<String> months = Arrays.asList("1976M05", "1986M07");

        assertNotEquals(0, this.client.getGovernmentDebt(items, months).size());
    }

}
