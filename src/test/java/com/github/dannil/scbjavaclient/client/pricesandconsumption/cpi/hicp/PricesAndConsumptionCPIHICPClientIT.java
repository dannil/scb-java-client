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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.cpi.hicp;

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
public class PricesAndConsumptionCPIHICPClientIT {

    private PricesAndConsumptionCPIHICPClient client;

    @BeforeEach
    public void setup() {
        this.client = new PricesAndConsumptionCPIHICPClient();
    }

    @Test
    @Date("2017-09-12")
    public void getHarmonizedIndexAnnualChanges() {
        assertNotEquals(0, this.client.getHarmonizedIndexAnnualChanges().size());
    }

    @Test
    @Date("2017-09-12")
    public void getHarmonizedIndexAnnualChangesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getHarmonizedIndexAnnualChanges(Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-09-12")
    public void getHarmonizedIndexAnnualChangesWithParameters() {
        List<String> months = Arrays.asList("1998M02", "1999M03");

        assertNotEquals(0, this.client.getHarmonizedIndexAnnualChanges(months).size());
    }

    @Test
    @Date("2017-09-12")
    public void getHarmonizedIndexMonthlyChanges() {
        assertNotEquals(0, this.client.getHarmonizedIndexMonthlyChanges().size());
    }

    @Test
    @Date("2017-09-12")
    public void getHarmonizedIndexMonthlyChangesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getHarmonizedIndexMonthlyChanges(Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-09-12")
    public void getHarmonizedIndexMonthlyChangesWithParameters() {
        List<String> months = Arrays.asList("1998M02", "1999M03");

        assertNotEquals(0, this.client.getHarmonizedIndexMonthlyChanges(months).size());
    }

    @Test
    @Date("2017-09-12")
    public void getHarmonizedIndexMonths() {
        assertNotEquals(0, this.client.getHarmonizedIndexMonths().size());
    }

    @Test
    @Date("2017-09-12")
    public void getHarmonizedIndexMonthsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getHarmonizedIndexMonths(Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-09-12")
    public void getHarmonizedIndexMonthsWithParameters() {
        List<String> months = Arrays.asList("1998M02", "1999M03");

        assertNotEquals(0, this.client.getHarmonizedIndexMonths(months).size());
    }

    @Test
    @Date("2017-09-12")
    public void getHarmonizedIndexYears() {
        assertNotEquals(0, this.client.getHarmonizedIndexYears().size());
    }

    @Test
    @Date("2017-09-12")
    public void getHarmonizedIndexYearsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getHarmonizedIndexYears(Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-09-12")
    public void getHarmonizedIndexYearsWithParameters() {
        List<Integer> years = Arrays.asList(2002, 2003);

        assertNotEquals(0, this.client.getHarmonizedIndexYears(years).size());
    }

}
