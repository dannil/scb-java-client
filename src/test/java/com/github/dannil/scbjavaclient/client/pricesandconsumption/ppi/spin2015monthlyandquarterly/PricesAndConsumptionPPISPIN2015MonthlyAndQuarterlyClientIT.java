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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.spin2015monthlyandquarterly;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Suite
@Remote
public class PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClientIT {

    private PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClient client;

    @BeforeEach
    public void setup() {
        this.client = new PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClient();
    }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test @Date("2017-06-06")
    // public void getProducerPriceIndexHomeSales() {
    // assertNotEquals(0, this.client.getProducerPriceIndexHomeSales().size());
    // }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test @Date("2017-06-06")
    // public void getProducerPriceIndexHomeSalesWithParametersEmptyLists() {
    // assertNotEquals(0,
    // this.client.getProducerPriceIndexHomeSales(Collections.<String>emptyList(),
    // Collections.<String>emptyList()).size());
    // }

    @Test
    @Date("2017-06-06")
    public void getProducerPriceIndexHomeSalesWithParameters() {
        List<String> spin2015 = Arrays.asList("B", "C");
        List<String> months = Arrays.asList("2001M03", "2001M07");

        assertNotEquals(0, this.client.getProducerPriceIndexHomeSales(spin2015, months).size());
    }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test @Date("2017-06-06")
    // public void getExportPriceIndex() {
    // assertNotEquals(0, this.client.getExportPriceIndex().size());
    // }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test @Date("2017-06-06")
    // public void getExportPriceIndexWithParametersEmptyLists() {
    // assertNotEquals(0, this.client.getExportPriceIndex(Collections.<String>emptyList(),
    // Collections.<String>emptyList()).size());
    // }

    @Test
    @Date("2017-06-06")
    public void getExportPriceIndexWithParameters() {
        List<String> spin2015 = Arrays.asList("A", "B");
        List<String> months = Arrays.asList("2001M03", "2001M07");

        assertNotEquals(0, this.client.getExportPriceIndex(spin2015, months).size());
    }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test @Date("2017-06-06")
    // public void getImportPriceIndex() {
    // assertNotEquals(0, this.client.getImportPriceIndex().size());
    // }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test @Date("2017-06-06")
    // public void getImportPriceIndexWithParametersEmptyLists() {
    // assertNotEquals(0, this.client.getImportPriceIndex(Collections.<String>emptyList(),
    // Collections.<String>emptyList()).size());
    // }

    @Test
    @Date("2017-06-06")
    public void getImportPriceIndexWithParameters() {
        List<String> spin2015 = Arrays.asList("A", "B");
        List<String> months = Arrays.asList("2001M03", "2001M07");

        assertNotEquals(0, this.client.getImportPriceIndex(spin2015, months).size());
    }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test @Date("2017-06-06")
    // public void getProducerPriceIndex() {
    // assertNotEquals(0, this.client.getProducerPriceIndex().size());
    // }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test @Date("2017-06-06")
    // public void getProducerPriceIndexWithParametersEmptyLists() {
    // assertNotEquals(0,
    // this.client.getProducerPriceIndex(Collections.<String>emptyList(),
    // Collections.<String>emptyList()).size());
    // }

    @Test
    @Date("2017-06-06")
    public void getProducerPriceIndexWithParameters() {
        List<String> spin2015 = Arrays.asList("A", "B");
        List<String> months = Arrays.asList("2001M03", "2001M07");

        assertNotEquals(0, this.client.getProducerPriceIndex(spin2015, months).size());
    }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test @Date("2017-06-06")
    // public void getPriceIndexForDomesticSupply() {
    // assertNotEquals(0, this.client.getPriceIndexForDomesticSupply().size());
    // }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test @Date("2017-06-06")
    // public void getPriceIndexForDomesticSupplyWithParametersEmptyLists() {
    // assertNotEquals(0,
    // this.client.getPriceIndexForDomesticSupply(Collections.<String>emptyList(),
    // Collections.<String>emptyList()).size());
    // }

    @Test
    @Date("2017-06-06")
    public void getPriceIndexForDomesticSupplyWithParameters() {
        List<String> spin2015 = Arrays.asList("A", "B");
        List<String> months = Arrays.asList("2001M03", "2001M07");

        assertNotEquals(0, this.client.getPriceIndexForDomesticSupply(spin2015, months).size());
    }

}
