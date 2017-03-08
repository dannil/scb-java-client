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

package com.github.dannil.scbjavaclient.client.finance.institutions;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FinanceInstitutionsClientIT extends RemoteIntegrationTestSuite {

    private FinanceInstitutionsClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().finance().institutions();
    }

    @Test
    public void getInstitutions() {
        assertNotEquals(0, this.client.getInstitutions().size());
    }

    @Test
    public void getInstitutionsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getInstitutions(Collections.<String>emptyList(), Collections.<String>emptyList(), Collections.<String>emptyList(), Collections.<String>emptyList()));
    }

    @Test
    public void getInstitutionsWithParameters() {
        List<String> institutions = Arrays.asList("41140", "11138");
        List<String> items = Arrays.asList("K11600", "K12300");
        List<String> currencies = Arrays.asList("v0", "v1");
        List<String> months = Arrays.asList("2010M03", "2011M03");

        assertNotEquals(0, this.client.getInstitutions(institutions, items, currencies, months).size());
    }

}