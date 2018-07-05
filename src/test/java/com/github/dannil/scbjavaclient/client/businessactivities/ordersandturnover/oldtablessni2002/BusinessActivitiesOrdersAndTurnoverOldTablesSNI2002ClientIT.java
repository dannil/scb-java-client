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

package com.github.dannil.scbjavaclient.client.businessactivities.ordersandturnover.oldtablessni2002;

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
public class BusinessActivitiesOrdersAndTurnoverOldTablesSNI2002ClientIT {

    private BusinessActivitiesOrdersAndTurnoverOldTablesSNI2002Client client;

    @BeforeEach
    public void setup() {
        this.client = new BusinessActivitiesOrdersAndTurnoverOldTablesSNI2002Client();
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverInIndustrySNI2002Annual() {
        assertNotEquals(0, this.client.getTurnoverInIndustrySNI2002Annual().size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverInIndustrySNI2002AnnualWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTurnoverInIndustrySNI2002Annual(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverInIndustrySNI2002AnnualWithParameters() {
        List<String> markets = Arrays.asList("HEMMA");
        List<String> industrialClassifications = Arrays.asList("C", "D");
        List<Integer> years = Arrays.asList(1992, 1993);

        assertNotEquals(0,
                this.client.getTurnoverInIndustrySNI2002Annual(markets, industrialClassifications, years).size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverInIndustrySNI2002Monthly() {
        assertNotEquals(0, this.client.getTurnoverInIndustrySNI2002Monthly().size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverInIndustrySNI2002MonthlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTurnoverInIndustrySNI2002Monthly(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverInIndustrySNI2002MonthlyWithParameters() {
        List<String> markets = Arrays.asList("HEMMA");
        List<String> industrialClassifications = Arrays.asList("C", "D");
        List<String> months = Arrays.asList("1998M04", "1998M05");

        assertNotEquals(0,
                this.client.getTurnoverInIndustrySNI2002Monthly(markets, industrialClassifications, months).size());
    }

    @Test
    @Date("2018-01-13")
    public void getOrdersInIndustrySNI2002Annual() {
        assertNotEquals(0, this.client.getOrdersInIndustrySNI2002Annual().size());
    }

    @Test
    @Date("2018-01-13")
    public void getOrdersInIndustrySNI2002AnnualWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getOrdersInIndustrySNI2002Annual(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-01-13")
    public void getOrdersInIndustrySNI2002AnnualAnnualWithParameters() {
        List<String> markets = Arrays.asList("HEMMA");
        List<String> industrialClassifications = Arrays.asList("C", "D");
        List<Integer> years = Arrays.asList(1992, 1993);

        assertNotEquals(0,
                this.client.getOrdersInIndustrySNI2002Annual(markets, industrialClassifications, years).size());
    }

    @Test
    @Date("2018-01-13")
    public void getOrdersInIndustrySNI2002Monthly() {
        assertNotEquals(0, this.client.getOrdersInIndustrySNI2002Monthly().size());
    }

    @Test
    @Date("2018-01-13")
    public void getOrdersInIndustrySNI2002MonthlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getOrdersInIndustrySNI2002Monthly(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2018-01-13")
    public void getOrdersInIndustrySNI2002MonthlyWithParameters() {
        List<String> markets = Arrays.asList("HEMMA");
        List<String> industrialClassifications = Arrays.asList("C", "D");
        List<String> months = Arrays.asList("1998M04", "1998M05");

        assertNotEquals(0,
                this.client.getOrdersInIndustrySNI2002Monthly(markets, industrialClassifications, months).size());
    }

}
