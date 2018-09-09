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

package com.github.dannil.scbjavaclient.client.businessactivities.ordersandturnover.ordersandturnover;

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
public class BusinessActivitiesOrdersAndTurnoverOrdersAndTurnoverClientIT {

    private BusinessActivitiesOrdersAndTurnoverOrdersAndTurnoverClient client;

    @BeforeEach
    public void setup() {
        this.client = new BusinessActivitiesOrdersAndTurnoverOrdersAndTurnoverClient();
    }

    @Test
    @Date("2018-01-04")
    public void getTurnoverInIndustrySNI2007Monthly() {
        assertNotEquals(0, this.client.getTurnoverInIndustrySNI2007Monthly().size());
    }

    @Test
    @Date("2018-01-04")
    public void getTurnoverInIndustrySNI2007MonthlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTurnoverInIndustrySNI2007Monthly(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2018-01-04")
    public void getTurnoverInIndustrySNI2007MonthlyWithParameters() {
        List<String> markets = Arrays.asList("HEMMA");
        List<String> industrialClassifications = Arrays.asList("B", "C");
        List<String> months = Arrays.asList("2014M11", "2014M12");

        assertNotEquals(0,
                this.client.getTurnoverInIndustrySNI2007Monthly(markets, industrialClassifications, months).size());
    }

    @Test
    @Date("2018-01-04")
    public void getOrdersInIndustrySNI2007Monthly() {
        assertNotEquals(0, this.client.getOrdersInIndustrySNI2007Monthly().size());
    }

    @Test
    @Date("2018-01-04")
    public void getOrdersInIndustrySNI2007MonthlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getOrdersInIndustrySNI2007Monthly(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2018-01-04")
    public void getOrdersInIndustrySNI2007MonthlyWithParameters() {
        List<String> markets = Arrays.asList("HEMMA");
        List<String> industrialClassifications = Arrays.asList("B", "C");
        List<String> months = Arrays.asList("2014M11", "2014M12");

        assertNotEquals(0,
                this.client.getOrdersInIndustrySNI2007Monthly(markets, industrialClassifications, months).size());
    }

}
