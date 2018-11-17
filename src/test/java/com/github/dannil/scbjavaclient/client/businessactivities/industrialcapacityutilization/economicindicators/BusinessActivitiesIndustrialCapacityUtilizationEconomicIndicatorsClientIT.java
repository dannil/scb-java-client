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

package com.github.dannil.scbjavaclient.client.businessactivities.industrialcapacityutilization.economicindicators;

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
public class BusinessActivitiesIndustrialCapacityUtilizationEconomicIndicatorsClientIT {

    private BusinessActivitiesIndustrialCapacityUtilizationEconomicIndicatorsClient client;

    @BeforeEach
    public void setup() {
        this.client = new BusinessActivitiesIndustrialCapacityUtilizationEconomicIndicatorsClient();
    }

    @Test
    @Date("2017-12-30")
    public void getCapacityUtilisationInTotalIndustry() {
        assertNotEquals(0, this.client.getCapacityUtilisationInTotalIndustry().size());
    }

    @Test
    @Date("2017-12-30")
    public void getCapacityUtilisationInTotalIndustryWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getCapacityUtilisationInTotalIndustry(Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-12-30")
    public void getCapacityUtilisationInTotalIndustryWithParameters() {
        List<String> quarters = Arrays.asList("2015K2", "2015K4");

        assertNotEquals(0, this.client.getCapacityUtilisationInTotalIndustry(quarters).size());
    }

    // TODO Add more methods

}
