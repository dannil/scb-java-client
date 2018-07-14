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
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.exception.SCBClientResponseTooLargeException;
import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
@Remote
public class GoodsAndServicesTurnoverServiceSectorTurnoverClientIT {

    private GoodsAndServicesTurnoverServiceSectorTurnoverClient client;

    @BeforeEach
    public void setup() {
        this.client = new GoodsAndServicesTurnoverServiceSectorTurnoverClient();
    }

    // Daniel, 2018-06-28
    // Returns HTTP 403
    @Test
    @Date("2018-06-28")
    public void getRetailSaleIndexSIC2007Monthly() {
        assertThrows(SCBClientResponseTooLargeException.class, () -> this.client.getRetailSaleIndexSIC2007Monthly());
    }

    // Daniel, 2018-06-28
    // Returns HTTP 403
    @Test
    @Date("2018-06-28")
    public void getRetailSaleIndexSIC2007MonthlyWithParametersEmptyLists() {
        assertThrows(SCBClientResponseTooLargeException.class,
                () -> this.client.getRetailSaleIndexSIC2007Monthly(Collections.<String>emptyList(),
                        Collections.<String>emptyList()));
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

    @Test
    @Date("2018-02-01")
    public void getRetailTradeSales() {
        assertNotEquals(0, this.client.getRetailTradeSales().size());
    }

    @Test
    @Date("2018-02-01")
    public void getRetailTradeSalesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getRetailTradeSales(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2018-02-01")
    public void getRetailTradeSalesWithParameters() {
        List<String> indicators = Arrays.asList("DHF10", "DHF20");
        List<String> months = Arrays.asList("2007M05", "2007M06");

        assertNotEquals(0, this.client.getRetailTradeSales(indicators, months).size());
    }

    // TODO Add methods here!

}
