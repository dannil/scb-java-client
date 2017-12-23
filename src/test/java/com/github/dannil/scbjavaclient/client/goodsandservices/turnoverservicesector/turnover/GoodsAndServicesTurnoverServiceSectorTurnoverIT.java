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

package com.github.dannil.scbjavaclient.client.goodsandservices.turnoverservicesector.turnover;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Suite
@Remote
public class GoodsAndServicesTurnoverServiceSectorTurnoverIT {

    private GoodsAndServicesTurnoverServiceSectorTurnover client;

    @BeforeEach
    public void setup() {
        this.client = new GoodsAndServicesTurnoverServiceSectorTurnover();
    }

    @Test
    @Date("2017-12-16")
    public void getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Yearly() {
        assertNotEquals(0,
                this.client.getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Yearly().size());
    }

    @Test
    @Date("2017-12-16")
    public void getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002YearlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Yearly(
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-12-16")
    public void getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002YearlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("50.2", "50.5");
        List<Integer> years = Arrays.asList(2003, 2005);

        assertNotEquals(0, this.client.getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Yearly(
                industrialClassifications, years).size());
    }

    @Test
    @Date("2017-12-16")
    public void getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Yearly() {
        assertNotEquals(0, this.client.getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Yearly().size());
    }

    @Test
    @Date("2017-12-16")
    public void getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002YearlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Yearly(
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-12-16")
    public void getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002YearlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("74.4", "74.5");
        List<Integer> years = Arrays.asList(2003, 2005);

        assertNotEquals(0,
                this.client.getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Yearly(industrialClassifications,
                        years).size());
    }

    @Test
    @Date("2017-12-16")
    public void getRetailSaleIndexSIC2002Monthly() {
        assertNotEquals(0, this.client.getRetailSaleIndexSIC2002Monthly().size());
    }

    @Test
    @Date("2017-12-16")
    public void getRetailSaleIndexSIC2002MonthlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getRetailSaleIndexSIC2002Monthly(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-12-16")
    public void getRetailSaleIndexSIC2002MonthlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("52.11", "52.12");
        List<String> months = Arrays.asList("2003M10", "2003M12");

        assertNotEquals(0, this.client.getRetailSaleIndexSIC2002Monthly(industrialClassifications, months).size());
    }

    @Test
    @Date("2017-12-16")
    public void getRetailSaleIndexSIC2002Yearly() {
        assertNotEquals(0, this.client.getRetailSaleIndexSIC2002Yearly().size());
    }

    @Test
    @Date("2017-12-16")
    public void getRetailSaleIndexSIC2002YearlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getRetailSaleIndexSIC2002Yearly(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-12-16")
    public void getRetailSaleIndexSIC2002YearlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("52.11", "52.12");
        List<Integer> years = Arrays.asList(2003, 2005);

        assertNotEquals(0, this.client.getRetailSaleIndexSIC2002Yearly(industrialClassifications, years).size());
    }

    @Test
    @Date("2017-12-16")
    public void getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Quarterly() {
        assertNotEquals(0,
                this.client.getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Quarterly().size());
    }

    @Test
    @Date("2017-12-16")
    public void getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002QuarterlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Quarterly(
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-12-16")
    public void getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002QuarterlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("50.2", "50.5");
        List<String> quarters = Arrays.asList("1998K2", "1998K3");

        assertNotEquals(0, this.client.getTurnoverIndexForMotorTradeHotelsRestaurantsAndOtherServicesSIC2002Quarterly(
                industrialClassifications, quarters).size());
    }

    @Test
    @Date("2017-12-16")
    public void getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Quarterly() {
        assertNotEquals(0, this.client.getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Quarterly().size());
    }

    @Test
    @Date("2017-12-16")
    public void getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002QuarterlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Quarterly(
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-12-16")
    public void getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002QuarterlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("74.4", "74.5");
        List<String> quarters = Arrays.asList("2001K2", "2001K4");

        assertNotEquals(0,
                this.client.getTurnoverIndexForWholesaleTradeAndOtherServicesSIC2002Quarterly(industrialClassifications,
                        quarters).size());
    }

    @Test
    @Date("2017-12-18")
    public void getRetailSaleIndexSIC2007Monthly() {
        assertNotEquals(0, this.client.getRetailSaleIndexSIC2007Monthly().size());
    }

    @Test
    @Date("2017-12-18")
    public void getRetailSaleIndexSIC2007MonthlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getRetailSaleIndexSIC2007Monthly(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-12-18")
    public void getRetailSaleIndexSIC2007MonthlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("47.2", "47.4");
        List<String> months = Arrays.asList("2003M10", "2004M12");

        assertNotEquals(0, this.client.getRetailSaleIndexSIC2007Monthly(industrialClassifications, months).size());
    }

    @Test
    @Date("2017-12-18")
    public void getRetailSaleIndexSIC2007Yearly() {
        assertNotEquals(0, this.client.getRetailSaleIndexSIC2007Yearly().size());
    }

    @Test
    @Date("2017-12-18")
    public void getRetailSaleIndexSIC2007YearlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getRetailSaleIndexSIC2007Yearly(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-12-18")
    public void getRetailSaleIndexSIC2007YearlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("47.2exkl47.25", "47.51+47.71-72");
        List<Integer> years = Arrays.asList(2001, 2002);

        assertNotEquals(0, this.client.getRetailSaleIndexSIC2007Yearly(industrialClassifications, years).size());
    }

    @Test
    @Date("2017-12-18")
    public void getTurnoverIndexForTheServiceSectorSIC2007Yearly() {
        assertNotEquals(0, this.client.getTurnoverIndexForTheServiceSectorSIC2007Yearly().size());
    }

    @Test
    @Date("2017-12-18")
    public void getTurnoverIndexForTheServiceSectorSIC2007YearlyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTurnoverIndexForTheServiceSectorSIC2007Yearly(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-12-18")
    public void getTurnoverIndexForTheServiceSectorSIC2007YearlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("45.1+45.3", "55-56");
        List<Integer> years = Arrays.asList(2011, 2012);

        assertNotEquals(0,
                this.client.getTurnoverIndexForTheServiceSectorSIC2007Yearly(industrialClassifications, years).size());
    }

    @Test
    @Date("2017-12-18")
    public void getTurnoverIndexForTheServiceSectorSIC2007Quarterly() {
        assertNotEquals(0, this.client.getTurnoverIndexForTheServiceSectorSIC2007Quarterly().size());
    }

    @Test
    @Date("2017-12-18")
    public void getTurnoverIndexForTheServiceSectorSIC2007QuarterlyWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getTurnoverIndexForTheServiceSectorSIC2007Quarterly(Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-12-18")
    public void getTurnoverIndexForTheServiceSectorSIC2007QuarterlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("45.1+45.3", "55-56");
        List<String> quarters = Arrays.asList("2007K2", "2007K3");

        assertNotEquals(0, this.client.getTurnoverIndexForTheServiceSectorSIC2007Quarterly(industrialClassifications,
                quarters).size());
    }

    @Test
    @Date("2017-12-18")
    public void getMonthlyIndicatorForHouseholdConsumption() {
        assertNotEquals(0, this.client.getMonthlyIndicatorForHouseholdConsumption().size());
    }

    @Test
    @Date("2017-12-18")
    public void getMonthlyIndicatorForHouseholdConsumptionWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getMonthlyIndicatorForHouseholdConsumption(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-12-18")
    public void getMonthlyIndicatorForHouseholdConsumptionMonthlyWithParameters() {
        List<String> purposes = Arrays.asList("BOS", "MOB");
        List<String> months = Arrays.asList("2006M08", "2006M09");

        assertNotEquals(0, this.client.getMonthlyIndicatorForHouseholdConsumption(purposes, months).size());
    }

    @Test
    @Date("2017-12-18")
    public void getTurnoverIndexForTheServiceSectorSIC2007Monthly() {
        assertNotEquals(0, this.client.getTurnoverIndexForTheServiceSectorSIC2007Monthly().size());
    }

    @Test
    @Date("2017-12-18")
    public void getTurnoverIndexForTheServiceSectorSIC2007MonthlyWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getTurnoverIndexForTheServiceSectorSIC2007Monthly(Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-12-18")
    public void getTurnoverIndexForTheServiceSectorSIC2007MonthlyWithParameters() {
        List<String> industrialClassifications = Arrays.asList("45.1+45.3", "45.2-45.4");
        List<String> months = Arrays.asList("2010M03", "2010M04");

        assertNotEquals(0, this.client.getTurnoverIndexForTheServiceSectorSIC2007Monthly(industrialClassifications,
                months).size());
    }

    // TODO Add methods here!

}
