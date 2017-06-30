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

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.runner.Date;
import com.github.dannil.scbjavaclient.test.runner.DateJUnitRunner;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DateJUnitRunner.class)
public class PricesAndConsumptionCPIHICPClientIT extends RemoteIntegrationTestSuite {

    private PricesAndConsumptionCPIHICPClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().pricesAndConsumption().cpi().hicp();
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexCTAnnualChanges() {
        assertNotEquals(0, this.client.getHarmonizedIndexCTAnnualChanges().size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexCTAnnualChangesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getHarmonizedIndexCTAnnualChanges(Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexCTAnnualChangesWithParameters() {
        List<String> months = Arrays.asList("2011M02", "2011M03");

        assertNotEquals(0, this.client.getHarmonizedIndexCTAnnualChanges(months).size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexCTMonthlyChanges() {
        assertNotEquals(0, this.client.getHarmonizedIndexCTMonthlyChanges().size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexCTMonthlyChangesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getHarmonizedIndexCTMonthlyChanges(Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexCTMonthlyChangesWithParameters() {
        List<String> months = Arrays.asList("2011M02", "2011M03");

        assertNotEquals(0, this.client.getHarmonizedIndexCTMonthlyChanges(months).size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexCTMonths() {
        assertNotEquals(0, this.client.getHarmonizedIndexCTMonths().size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexCTMonthsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getHarmonizedIndexCTMonths(Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexCTMonthsWithParameters() {
        List<String> months = Arrays.asList("2008M02", "2008M03");

        assertNotEquals(0, this.client.getHarmonizedIndexCTMonths(months).size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexCTYears() {
        assertNotEquals(0, this.client.getHarmonizedIndexCTYears().size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexCTYearsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getHarmonizedIndexCTYears(Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexCTYearsWithParameters() {
        List<Integer> years = Arrays.asList(2008, 2009);

        assertNotEquals(0, this.client.getHarmonizedIndexCTYears(years).size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexAnnualChanges() {
        assertNotEquals(0, this.client.getHarmonizedIndexAnnualChanges().size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexAnnualChangesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getHarmonizedIndexAnnualChanges(Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexAnnualChangesWithParameters() {
        List<String> months = Arrays.asList("1998M02", "1999M03");

        assertNotEquals(0, this.client.getHarmonizedIndexAnnualChanges(months).size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexMonthlyChanges() {
        assertNotEquals(0, this.client.getHarmonizedIndexMonthlyChanges().size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexMonthlyChangesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getHarmonizedIndexMonthlyChanges(Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexMonthlyChangesWithParameters() {
        List<String> months = Arrays.asList("1998M02", "1999M03");

        assertNotEquals(0, this.client.getHarmonizedIndexMonthlyChanges(months).size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexMonths() {
        assertNotEquals(0, this.client.getHarmonizedIndexMonths().size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexMonthsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getHarmonizedIndexMonths(Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexMonthsWithParameters() {
        List<String> months = Arrays.asList("1998M02", "1999M03");

        assertNotEquals(0, this.client.getHarmonizedIndexMonths(months).size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexYears() {
        assertNotEquals(0, this.client.getHarmonizedIndexYears().size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexYearsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getHarmonizedIndexYears(Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-26")
    public void getHarmonizedIndexYearsWithParameters() {
        List<Integer> years = Arrays.asList(2002, 2003);

        assertNotEquals(0, this.client.getHarmonizedIndexYears(years).size());
    }

}