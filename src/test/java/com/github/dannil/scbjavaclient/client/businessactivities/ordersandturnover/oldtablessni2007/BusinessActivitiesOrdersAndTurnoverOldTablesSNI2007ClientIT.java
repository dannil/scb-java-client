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

package com.github.dannil.scbjavaclient.client.businessactivities.ordersandturnover.oldtablessni2007;

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
public class BusinessActivitiesOrdersAndTurnoverOldTablesSNI2007ClientIT {

    private BusinessActivitiesOrdersAndTurnoverOldTablesSNI2007Client client;

    @BeforeEach
    public void setup() {
        this.client = new BusinessActivitiesOrdersAndTurnoverOldTablesSNI2007Client();
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverInIndustryFixedPricesSNI2007Annual() {
        assertNotEquals(0, this.client.getTurnoverInIndustryFixedPricesSNI2007Annual().size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverInIndustryFixedPricesSNI2007AnnualWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTurnoverInIndustryFixedPricesSNI2007Annual(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverInIndustryFixedPricesSNI2007AnnualWithParameters() {
        List<String> markets = Arrays.asList("HEMMA");
        List<String> industrialClassifications = Arrays.asList("B", "C");
        List<Integer> years = Arrays.asList(2005, 2006);

        assertNotEquals(0, this.client.getTurnoverInIndustryFixedPricesSNI2007Annual(markets, industrialClassifications,
                years).size());
    }

    @Test
    @Date("2018-01-13")
    public void getOrdersInIndustryFixedPricesSNI2007Annual() {
        assertNotEquals(0, this.client.getOrdersInIndustryFixedPricesSNI2007Annual().size());
    }

    @Test
    @Date("2018-01-13")
    public void getOrdersInIndustryFixedPricesSNI2007AnnualWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getOrdersInIndustryFixedPricesSNI2007Annual(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-01-13")
    public void getOrdersInIndustryFixedPricesSNI2007AnnualWithParameters() {
        List<String> markets = Arrays.asList("HEMMA");
        List<String> industrialClassifications = Arrays.asList("B", "C");
        List<Integer> years = Arrays.asList(2005, 2006);

        assertNotEquals(0, this.client.getOrdersInIndustryFixedPricesSNI2007Annual(markets, industrialClassifications,
                years).size());
    }

    @Test
    @Date("2018-01-13")
    public void getOrdersAndTurnoverInIndustryForTotalIndustry() {
        assertNotEquals(0, this.client.getOrdersAndTurnoverInIndustryForTotalIndustry().size());
    }

    @Test
    @Date("2018-01-13")
    public void getOrdersAndTurnoverInIndustryForTotalIndustryWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getOrdersAndTurnoverInIndustryForTotalIndustry(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2018-01-13")
    public void getOrdersAndTurnoverInIndustryForTotalIndustryWithParameters() {
        List<String> economicIndicators = Arrays.asList("IND10", "IND20");
        List<String> months = Arrays.asList("2015M03", "2015M04");

        assertNotEquals(0,
                this.client.getOrdersAndTurnoverInIndustryForTotalIndustry(economicIndicators, months).size());
    }

}
