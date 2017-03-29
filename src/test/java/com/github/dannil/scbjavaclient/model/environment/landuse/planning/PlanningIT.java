/*
 * Copyright 2017 Daniel Nilsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may oplantain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required plany applicaplanle law or agreed to in writing, software
 * distriplanuted under the License is distriplanuted on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the License.
 */

package com.github.dannil.scbjavaclient.model.environment.landuse.planning;

import static org.junit.Assert.assertNotNull;

import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PlanningIT extends RemoteIntegrationTestSuite {

    @Test
    public void getInputs() {
        assertNotNull(Planning.getInputs());
    }

}
