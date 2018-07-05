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

package com.github.dannil.scbjavaclient.client.labourmarket.costindex;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
@Remote
public class LabourMarketCostIndexClientIT {

    private LabourMarketCostIndexClient client;

    @BeforeEach
    public void setup() {
        this.client = new LabourMarketCostIndexClient();
    }

    @Test
    @Date("2017-04-04")
    public void getCostIndexForManualWorkersLCI() {
        assertNotEquals(0, this.client.getCostIndexForManualWorkersLCI().size());
    }

    @Test
    @Date("2017-04-04")
    public void getCostIndexForManualWorkersLCIWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getCostIndexForManualWorkersLCI(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-04-04")
    public void getCostIndexForManualWorkersLCIWithParameters() {
        List<String> industrialClassifications = Arrays.asList("E", "F");
        List<String> quarters = Arrays.asList("2011K3", "2012K3");

        assertNotEquals(0, this.client.getCostIndexForManualWorkersLCI(industrialClassifications, quarters).size());
    }

    @Test
    @Date("2017-04-04")
    public void getCostIndexForNonManualWorkersLCI() {
        assertNotEquals(0, this.client.getCostIndexForNonManualWorkersLCI().size());
    }

    @Test
    @Date("2017-04-04")
    public void getCostIndexForNonManualWorkersLCIWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getCostIndexForNonManualWorkersLCI(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-04-04")
    public void getCostIndexForNonManualWorkersLCIWithParameters() {
        List<String> industrialClassifications = Arrays.asList("E", "F");
        List<String> quarters = Arrays.asList("2011K3", "2012K3");

        assertNotEquals(0, this.client.getCostIndexForNonManualWorkersLCI(industrialClassifications, quarters).size());
    }

    @Test
    @Date("2017-04-04")
    public void getCostIndexForManualWorkersWAG() {
        assertNotEquals(0, this.client.getCostIndexForManualWorkersWAG().size());
    }

    @Test
    @Date("2017-04-04")
    public void getCostIndexForManualWorkersWAGWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getCostIndexForManualWorkersWAG(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-04-04")
    public void getCostIndexForManualWorkersWAGWithParameters() {
        List<String> industrialClassifications = Arrays.asList("E", "F");
        List<String> quarters = Arrays.asList("2011K3", "2012K3");

        assertNotEquals(0, this.client.getCostIndexForManualWorkersWAG(industrialClassifications, quarters).size());
    }

    @Test
    @Date("2017-04-04")
    public void getCostIndexForNonManualWorkersWAG() {
        assertNotEquals(0, this.client.getCostIndexForNonManualWorkersWAG().size());
    }

    @Test
    @Date("2017-04-04")
    public void getCostIndexForNonManualWorkersWAGWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getCostIndexForNonManualWorkersWAG(Collections.<String>emptyList(),
                Collections.<String>emptyList()));
    }

    @Test
    @Date("2017-04-04")
    public void getCostIndexForNonManualWorkersWAGWithParameters() {
        List<String> industrialClassifications = Arrays.asList("E", "F");
        List<String> quarters = Arrays.asList("2011K3", "2012K3");

        assertNotEquals(0, this.client.getCostIndexForNonManualWorkersWAG(industrialClassifications, quarters).size());
    }

}
