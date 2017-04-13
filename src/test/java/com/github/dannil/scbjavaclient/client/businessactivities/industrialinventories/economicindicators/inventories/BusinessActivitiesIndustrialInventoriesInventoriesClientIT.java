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

package com.github.dannil.scbjavaclient.client.businessactivities.industrialinventories.economicindicators.inventories;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.client.businessactivities.industrialinventories.inventories.BusinessActivitiesIndustrialInventoriesInventoriesClient;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BusinessActivitiesIndustrialInventoriesInventoriesClientIT extends RemoteIntegrationTestSuite {

    private BusinessActivitiesIndustrialInventoriesInventoriesClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().businessActivities().industrialInventories().inventories();
    }

    @Test
    public void getChangesInInventories() {
        assertNotEquals(0, this.client.getChangesInInventories().size());
    }

    @Test
    public void getTotalInventoriesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getChangesInInventories(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    public void getTotalInventoriesWithParameters() {
        List<String> inventoryTypes = Arrays.asList("INSATS", "VARDARB");
        List<String> industrialClassifications = Arrays.asList("IVKON", "C");
        List<String> quarters = Arrays.asList("2015K2", "2015K4");

        assertNotEquals(0,
                this.client.getChangesInInventories(inventoryTypes, industrialClassifications, quarters).size());
    }

}
