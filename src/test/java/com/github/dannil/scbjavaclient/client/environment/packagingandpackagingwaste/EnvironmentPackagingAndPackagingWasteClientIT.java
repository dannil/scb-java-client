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

package com.github.dannil.scbjavaclient.client.environment.packagingandpackagingwaste;

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
public class EnvironmentPackagingAndPackagingWasteClientIT extends RemoteIntegrationTestSuite {

    private EnvironmentPackagingAndPackagingWasteClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().environment().packagingAndPackagingWaste();
    }

    @Test
    public void getPackagingAndPackagingWaste() {
        assertNotEquals(0, this.client.getPackagingAndPackagingWaste().size());
    }

    @Test
    public void getPackagingAndPackagingWasteWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPackagingAndPackagingWaste(Collections.<Integer>emptyList(), Collections.<Integer>emptyList()));
    }

    @Test
    public void getPackagingAndPackagingWasteWithParameters() {
        List<Integer> types = Arrays.asList(10, 20);
        List<Integer> years = Arrays.asList(2012, 2013);

        assertNotEquals(0, this.client.getPackagingAndPackagingWaste(types, years).size());
    }

}
