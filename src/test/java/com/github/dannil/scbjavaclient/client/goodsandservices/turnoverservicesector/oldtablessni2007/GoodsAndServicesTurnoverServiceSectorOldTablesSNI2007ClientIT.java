/*
 * Copyright 2018 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.goodsandservices.turnoverservicesector.oldtablessni2007;

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
public class GoodsAndServicesTurnoverServiceSectorOldTablesSNI2007ClientIT {

    private GoodsAndServicesTurnoverServiceSectorOldTablesSNI2007Client client;

    @BeforeEach
    public void setup() {
        this.client = new GoodsAndServicesTurnoverServiceSectorOldTablesSNI2007Client();
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverIndexForTheServiceSectorSIC2007Yearly() {
        assertNotEquals(0, this.client.getTurnoverIndexForTheServiceSectorSIC2007Yearly().size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverIndexForTheServiceSectorSIC2007YearlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTurnoverIndexForTheServiceSectorSIC2007Yearly(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverIndexForTheServiceSectorSIC2007YearlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("45.1+45.3", "55-56");
        List<Integer> years = Arrays.asList(2011, 2012);

        assertNotEquals(0,
                this.client.getTurnoverIndexForTheServiceSectorSIC2007Yearly(industrialClassifications, years).size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverIndexForTheServiceSectorSIC2007Quarterly() {
        assertNotEquals(0, this.client.getTurnoverIndexForTheServiceSectorSIC2007Quarterly().size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverIndexForTheServiceSectorSIC2007QuarterlyWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getTurnoverIndexForTheServiceSectorSIC2007Quarterly(Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverIndexForTheServiceSectorSIC2007QuarterlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("45.1+45.3", "55-56");
        List<String> quarters = Arrays.asList("2007K2", "2007K3");

        assertNotEquals(0, this.client.getTurnoverIndexForTheServiceSectorSIC2007Quarterly(industrialClassifications,
                quarters).size());
    }

}
