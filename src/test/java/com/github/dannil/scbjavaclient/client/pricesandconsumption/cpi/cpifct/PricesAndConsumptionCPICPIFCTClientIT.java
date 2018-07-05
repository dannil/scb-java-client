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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.cpifct;

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
public class PricesAndConsumptionCPICPIFCTClientIT {

    private PricesAndConsumptionCPICPIFCTClient client;

    @BeforeEach
    public void setup() {
        this.client = new PricesAndConsumptionCPICPIFCTClient();
    }

    @Test
    @Date("2017-06-21")
    public void getFixedInterestRateMonthlyChanges() {
        assertNotEquals(0, this.client.getFixedInterestRateMonthlyChanges().size());
    }

    @Test
    @Date("2017-06-21")
    public void getFixedInterestRateMonthlyChangesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getFixedInterestRateMonthlyChanges(Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-21")
    public void getFixedInterestRateMonthlyChangesWithParameters() {
        List<String> months = Arrays.asList("1992M02", "1992M03");

        assertNotEquals(0, this.client.getFixedInterestRateMonthlyChanges(months).size());
    }

    @Test
    @Date("2017-06-21")
    public void getFixedInterestRateAnnualChanges() {
        assertNotEquals(0, this.client.getFixedInterestRateAnnualChanges().size());
    }

    @Test
    @Date("2017-06-21")
    public void getFixedInterestRateAnnualChangesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getFixedInterestRateAnnualChanges(Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-21")
    public void getFixedInterestRateAnnualChangesWithParameters() {
        List<String> months = Arrays.asList("1992M02", "1992M03");

        assertNotEquals(0, this.client.getFixedInterestRateAnnualChanges(months).size());
    }

}
