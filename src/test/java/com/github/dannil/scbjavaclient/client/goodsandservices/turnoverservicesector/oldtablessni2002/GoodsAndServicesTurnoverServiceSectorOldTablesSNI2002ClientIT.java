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

package com.github.dannil.scbjavaclient.client.goodsandservices.turnoverservicesector.oldtablessni2002;

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
public class GoodsAndServicesTurnoverServiceSectorOldTablesSNI2002ClientIT {

    private GoodsAndServicesTurnoverServiceSectorOldTablesSNI2002Client client;

    @BeforeEach
    public void setup() {
        this.client = new GoodsAndServicesTurnoverServiceSectorOldTablesSNI2002Client();
    }

    @Test
    @Date("2018-01-15")
    public void getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Yearly() {
        assertNotEquals(0,
                this.client.getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Yearly().size());
    }

    @Test
    @Date("2018-01-15")
    public void getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002YearlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Yearly(
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-01-15")
    public void getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002YearlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("50.2", "50.5");
        List<Integer> years = Arrays.asList(2003, 2005);

        assertNotEquals(0, this.client.getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Yearly(
                industrialClassifications, years).size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Yearly() {
        assertNotEquals(0, this.client.getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Yearly().size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002YearlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Yearly(
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002YearlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("74.4", "74.5");
        List<Integer> years = Arrays.asList(2003, 2005);

        assertNotEquals(0,
                this.client.getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Yearly(industrialClassifications,
                        years).size());
    }

    @Test
    @Date("2018-01-13")
    public void getRetailSaleIndexSIC2002Monthly() {
        assertNotEquals(0, this.client.getRetailSaleIndexSIC2002Monthly().size());
    }

    @Test
    @Date("2018-01-13")
    public void getRetailSaleIndexSIC2002MonthlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getRetailSaleIndexSIC2002Monthly(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2018-01-13")
    public void getRetailSaleIndexSIC2002MonthlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("52.11", "52.12");
        List<String> months = Arrays.asList("2003M10", "2003M12");

        assertNotEquals(0, this.client.getRetailSaleIndexSIC2002Monthly(industrialClassifications, months).size());
    }

    @Test
    @Date("2018-01-13")
    public void getRetailSaleIndexSIC2002Yearly() {
        assertNotEquals(0, this.client.getRetailSaleIndexSIC2002Yearly().size());
    }

    @Test
    @Date("2018-01-13")
    public void getRetailSaleIndexSIC2002YearlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getRetailSaleIndexSIC2002Yearly(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-01-13")
    public void getRetailSaleIndexSIC2002YearlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("52.11", "52.12");
        List<Integer> years = Arrays.asList(2003, 2005);

        assertNotEquals(0, this.client.getRetailSaleIndexSIC2002Yearly(industrialClassifications, years).size());
    }

    @Test
    @Date("2018-01-15")
    public void getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Quarterly() {
        assertNotEquals(0,
                this.client.getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Quarterly().size());
    }

    @Test
    @Date("2018-01-15")
    public void getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002QuarterlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Quarterly(
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2018-01-15")
    public void getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002QuarterlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("50.2", "50.5");
        List<String> quarters = Arrays.asList("1998K2", "1998K3");

        assertNotEquals(0, this.client.getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Quarterly(
                industrialClassifications, quarters).size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Quarterly() {
        assertNotEquals(0, this.client.getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Quarterly().size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002QuarterlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Quarterly(
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2018-01-13")
    public void getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002QuarterlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("74.4", "74.5");
        List<String> quarters = Arrays.asList("2001K2", "2001K4");

        assertNotEquals(0,
                this.client.getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Quarterly(industrialClassifications,
                        quarters).size());
    }

}
